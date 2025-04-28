import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class PainterFrame extends JFrame{
    private final List<String> history = new ArrayList<>();
    private int historyIndex = -1;
    private boolean forceOverwrite = false; // Used to suppress messages and overwrite checks when file is being read

    private final Map<String, Shape> shapes = new HashMap<>();
    private final Painter painter;
    private final EditorPanelsCreator creator = new EditorPanelsCreator(this);

    private final DrawingPanel drawingPanel;
    private final JTextField commandField;
    private final JPanel shapeInfoPanel = new JPanel();
    private final JPanel editorContainer = new JPanel();

    private final AtomicBoolean isConfirmWindowActive = new AtomicBoolean(false);

    @FunctionalInterface
    interface TriConsumer<A, B, C> {
        void accept(A a, B b, C c);
    }

    public PainterFrame(String filename){
        this.drawingPanel = new DrawingPanel(shapes, this);
        painter = new Painter(shapes, this);
        setTitle("CmdPaint - Drawing");
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 600));

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveCommandsToFile();
            }
        });

        setVisible(true);
        add(drawingPanel);

        if(filename != null)
            handleInputFile(filename);

        commandField = new JTextField();
        commandField.addActionListener(e -> {
            historyIndex = -1;
            String command = commandField.getText();
            processCommand(command);
            commandField.setText("");
        });

        commandField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (history.isEmpty()) return;

                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (historyIndex > 0) {
                        historyIndex--;
                        commandField.setText(history.get(historyIndex));
                    } else if (historyIndex == -1 && !history.isEmpty()) {
                        historyIndex = history.size() - 1;
                        commandField.setText(history.get(historyIndex));
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (historyIndex >= 0 && historyIndex < history.size() - 1) {
                        historyIndex++;
                        commandField.setText(history.get(historyIndex));
                    } else {
                        historyIndex = -1;
                        commandField.setText("");
                    }
                }
            }
        });
        JLabel commandLabel = new JLabel("Command:");
        JPanel commandPanel = new JPanel(new BorderLayout(5, 5));
        commandPanel.add(commandLabel, BorderLayout.WEST);
        commandPanel.add(commandField, BorderLayout.CENTER);
        commandPanel.add(new CommandHelperPanel(commandField), BorderLayout.NORTH);
        add(commandPanel, BorderLayout.SOUTH);

        editorContainer.setLayout(new BoxLayout(editorContainer, BoxLayout.Y_AXIS));
        shapeInfoPanel.setLayout(new BorderLayout());
        shapeInfoPanel.setBorder(BorderFactory.createTitledBorder("Selected Shape Editor"));

        JScrollPane editorScrollPane = new JScrollPane(editorContainer);
        editorScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        shapeInfoPanel.add(editorScrollPane, BorderLayout.CENTER);
        shapeInfoPanel.setPreferredSize(new Dimension(300, getHeight()));
        add(shapeInfoPanel, BorderLayout.EAST);
    }

    public void addDefinedColor(String name, Color color){
        creator.addDefinedColor(name, color);
    }

    public void setBackgroundColor(String colorStr) {
        Color color;
        switch (colorStr.toLowerCase()) {
            case "red" -> color = Color.RED;
            case "blue" -> color = Color.BLUE;
            case "green" -> color = Color.GREEN;
            case "yellow" -> color = Color.YELLOW;
            default -> color = Color.WHITE;
        }
        drawingPanel.setBackgroundColor(color);
    }

    public void setBackgroundColor(Color color) {
        drawingPanel.setBackgroundColor(color);
    }

    public Set<Shape> getSelectedShapes(){
        return drawingPanel.getSelectedShapes();
    }

    public int getSelectedX() {
        return drawingPanel.selectedX;
    }

    public int getSelectedY() {
        return drawingPanel.selectedY;
    }

    public boolean hasShapesSelected(){
        return !drawingPanel.getSelectedShapes().isEmpty();
    }

    @Override
    public void repaint() {
        drawingPanel.repaint();
    }

    public boolean saveAsImage() {
        int width = drawingPanel.getWidth();
        int height = drawingPanel.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = image.createGraphics();

        drawingPanel.paint(g2d);

        g2d.dispose();

        try {
            ImageIO.write(image, "PNG", new File("drawing.png"));
            pushMessage("Image saved successfully.");
            return true;
        } catch (IOException e) {
            pushMessage("Error saving image: " + e.getMessage());
            return false;
        }
    }

    public void pushMessage(String message){
        if(forceOverwrite)
            return;
        JOptionPane.showMessageDialog(this, message);
    }

    public boolean confirmWindow(String message) {
        if(forceOverwrite)
            return true;
        isConfirmWindowActive.set(true);
        try {
            int result = JOptionPane.showConfirmDialog(
                    this,
                    message,
                    "Confirm",
                    JOptionPane.YES_NO_OPTION
            );
            return result == JOptionPane.YES_OPTION;
        } finally {
            isConfirmWindowActive.set(false);
        }
    }

    public void updateShapeInfoPanel() {
        editorContainer.removeAll();
        Set<Shape> selected = getSelectedShapes();

        if (selected.isEmpty()) {
            JLabel label = new JLabel("No shapes selected.");
            editorContainer.add(label);
        } else if (selected.size() == 1) {
            editorContainer.add(creator.createShapeEditor(selected.iterator().next()));
        } else {
            JLabel label = new JLabel("More than one shape selected");
            editorContainer.add(label);
        }

        editorContainer.revalidate();
        editorContainer.repaint();
    }

    public boolean toggleGrid(){
        return drawingPanel.toggleGrid();
    }

    private void processCommand(String command) {
        try {
            history.add(command);
            CharStream input = CharStreams.fromString(command);
            CmdPaintLexer lexer = new CmdPaintLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CmdPaintParser parser = new CmdPaintParser(tokens);

            parser.removeErrorListeners();
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer,
                                        Object offendingSymbol,
                                        int line, int charPositionInLine,
                                        String msg, RecognitionException e) {
                    pushMessage("Invalid command: " + msg);
                }
            });

            ParseTree tree = parser.program();
            painter.visit(tree);

            drawingPanel.repaint();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Command Error:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleInputFile(String filename) {
        new Thread(() -> {
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                forceOverwrite = true;
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!line.trim().isEmpty()) {
                        String finalLine = line;
                        SwingUtilities.invokeLater(() -> processCommand(finalLine));
                        Thread.sleep(100); // 500
                    }
                }
                forceOverwrite = false;
            } catch (Exception e) {
                SwingUtilities.invokeLater(() ->
                        JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage()));
            }
        }).start();
    }

    // util, won't work for commands used with mouse - not essential (just for debugging)
    private void saveCommandsToFile(){
        try {
            FileWriter fw = new FileWriter("commandHistory.txt");
            for (String command : history) {
                fw.write(command + "\n");
            }
            fw.close();
        }catch (IOException e){
            System.out.println("Error saving commands to file: " + e.getMessage());
        }
    }
}
