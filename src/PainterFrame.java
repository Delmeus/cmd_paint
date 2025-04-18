import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.List;

public class PainterFrame extends JFrame{
    private final List<String> history = new ArrayList<>();
    private int historyIndex = -1;

    private final Map<String, Shape> shapes = new HashMap<>();
    private final Painter painter;

    private final DrawingPanel drawingPanel;
    private final JTextField commandField;

    public PainterFrame() {
        this(null);
    }

    public PainterFrame(String filename){
        this.drawingPanel = new DrawingPanel(shapes);
        painter = new Painter(shapes, this);
        setTitle("CmdPaint - Drawing");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        add(commandField, BorderLayout.SOUTH);

    }

    private void processCommand(String command) {
        try {
            history.add(command);
            CharStream input = CharStreams.fromString(command);
            CmdPaintLexer lexer = new CmdPaintLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CmdPaintParser parser = new CmdPaintParser(tokens);

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
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!line.trim().isEmpty()) {
                        String finalLine = line;
                        SwingUtilities.invokeLater(() -> processCommand(finalLine));
                        Thread.sleep(500);
                    }
                }
            } catch (Exception e) {
                SwingUtilities.invokeLater(() ->
                        JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage()));
            }
        }).start();
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
            System.out.println("Image saved successfully.");
            return true;
        } catch (IOException e) {
            System.out.println("Error saving image: " + e.getMessage());
            return false;
        }
    }

    public void popMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }

    // util, won't work for commands used with mouse - not essential
    private void saveCommandsToFile(){
        try {
            FileWriter fw = new FileWriter("commandHistory.txt");
            for (String command : history) {
                fw.write(command + "\n");
            }
        }catch (IOException e){
            System.out.println("Error saving commands to file: " + e.getMessage());
        }
    }
}
