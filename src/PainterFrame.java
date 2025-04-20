import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;

public class PainterFrame extends JFrame{
    private final List<String> history = new ArrayList<>();
    private int historyIndex = -1;

    private final Map<String, Shape> shapes = new HashMap<>();
    private final Painter painter;

    private final Map<String, Color> availableColors = new HashMap<>();

    private final DrawingPanel drawingPanel;
    private final JTextField commandField;
    private final JPanel shapeInfoPanel = new JPanel();
    private final JPanel editorContainer = new JPanel();

    private final AtomicBoolean isConfirmWindowActive = new AtomicBoolean(false);


    public PainterFrame() {
        this(null);
    }

    public PainterFrame(String filename){
        this.drawingPanel = new DrawingPanel(shapes, this);
        painter = new Painter(shapes, this);
        setTitle("CmdPaint - Drawing");
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
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

        editorContainer.setLayout(new BoxLayout(editorContainer, BoxLayout.Y_AXIS));
        shapeInfoPanel.setLayout(new BorderLayout());
        shapeInfoPanel.setBorder(BorderFactory.createTitledBorder("Selected Shape Editor"));
        shapeInfoPanel.add(new JScrollPane(editorContainer), BorderLayout.CENTER);
        shapeInfoPanel.setPreferredSize(new Dimension(300, getHeight()));
        add(shapeInfoPanel, BorderLayout.EAST);
    }

    public void addDefinedColor(String name, Color color){
        availableColors.put(name, color);
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

    public void pushMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }

    public boolean confirmWindow(String message) {
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
            editorContainer.add(createShapeEditor(selected.iterator().next()));
        } else {
            JLabel label = new JLabel("More than one shape selected");
            editorContainer.add(label);
        }

        editorContainer.revalidate();
        editorContainer.repaint();
    }

    private JPanel createShapeEditor(Shape shape) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder(shape.name));

        BiConsumer<String, JComponent> addLabeledField = (label, field) -> {
            JPanel row = new JPanel(new BorderLayout(5, 0));
            row.add(new JLabel(label), BorderLayout.WEST);
            row.add(field, BorderLayout.CENTER);
            row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
            panel.add(row);
        };

        JTextField strokeField = new JTextField(String.valueOf(shape.stroke));
        JTextField rotationField = new JTextField(String.valueOf(shape.getRotationAngle()));
        JTextField scaleField = new JTextField("1");
        JCheckBox hollowCheck = new JCheckBox("Hollow", shape.hollow);

        JTextField rField = new JTextField(String.valueOf(shape.color.getRed()));
        JTextField gField = new JTextField(String.valueOf(shape.color.getGreen()));
        JTextField bField = new JTextField(String.valueOf(shape.color.getBlue()));

        addLabeledField.accept("Stroke:", strokeField);
        addLabeledField.accept("Rotation:", rotationField);
        addLabeledField.accept("Scale:", scaleField);
        addLabeledField.accept("Color R:", rField);
        addLabeledField.accept("Color G:", gField);
        addLabeledField.accept("Color B:", bField);

        if(shape instanceof Line){
            addPositionRow(panel, "x1", shape.x, "\ty1", shape.y);
            addPositionRow(panel, "x2", ((Line) shape).x2, "\ty2", ((Line) shape).y2);
        } else if (shape instanceof Polygon) {
            for(int i = 0; i < ((Polygon) shape).x_points.length; i++){
                addPositionRow(panel, "x" + i, ((Polygon) shape).x_points[i],
                        "\ty" + i, (((Polygon) shape).y_points[i]));
            }
        } else if (shape instanceof ShapeGroup) {
            ;
        } else {
            addPositionRow(panel, "x", shape.x, "\ty", shape.y);
        }

        JPanel hollowRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
        hollowRow.add(hollowCheck);
        panel.add(hollowRow);

        JButton applyButton = new JButton("Apply Changes");
        JPanel buttonRow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonRow.add(applyButton);
        panel.add(buttonRow);

        applyButton.addActionListener(e -> {
            try {
                int stroke = Integer.parseInt(strokeField.getText());
                int rotation = Integer.parseInt(rotationField.getText());
                double factor = Double.parseDouble(scaleField.getText());
                int r = Integer.parseInt(rField.getText());
                int g = Integer.parseInt(gField.getText());
                int b = Integer.parseInt(bField.getText());
                Color newColor = new Color(r, g, b);
                boolean hollow = hollowCheck.isSelected();

                shape.setStroke(stroke);
                shape.setRotationAngle(rotation);
                shape.scale(factor);
                shape.setColor(newColor);
                if (hollow)
                    shape.hollow();
                else
                    shape.fill();

                repaint();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error updating shape: " + ex.getMessage());
            }
        });


        addColorsWindow(panel, rField, gField, bField);
        return panel;
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

    private void addPositionRow(JPanel panel, String xString, int x, String yString, int y) {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        JLabel xLabel = new JLabel(xString + ": " + x);
        JLabel yLabel = new JLabel(yString + ": " + y);

        row.add(xLabel);
        row.add(yLabel);

        panel.add(row);
    }

    private void addColorsWindow(JPanel panel, JTextField rField, JTextField gField, JTextField bField) {
        setDefaultColors();
        JPanel colorRow = new JPanel(new GridLayout(0, 8, 5, 5));
        colorRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        colorRow.setBorder(BorderFactory.createTitledBorder("Quick Colors"));

        for (Color c : availableColors.values()) {
            JButton colorBtn = new JButton();
            colorBtn.setBackground(c);
            colorBtn.setPreferredSize(new Dimension(20, 20));
            colorBtn.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
            colorBtn.setFocusPainted(false);
            colorBtn.addActionListener(e -> {
                rField.setText(String.valueOf(c.getRed()));
                gField.setText(String.valueOf(c.getGreen()));
                bField.setText(String.valueOf(c.getBlue()));
            });
            colorRow.add(colorBtn);
        }
        panel.add(colorRow);
    }

    private void handleInputFile(String filename) {
        new Thread(() -> {
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!line.trim().isEmpty()) {
                        while(isConfirmWindowActive.get())
                            Thread.sleep(1000);
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

    private void setDefaultColors() {
        availableColors.put("red", Color.RED);
        availableColors.put("green", Color.GREEN);
        availableColors.put("blue", Color.BLUE);
        availableColors.put("yellow", Color.YELLOW);
        availableColors.put("orange", Color.ORANGE);
        availableColors.put("magenta", Color.MAGENTA);
        availableColors.put("cyan", Color.CYAN);
        availableColors.put("white", Color.WHITE);
        availableColors.put("black", Color.BLACK);
    }

    // util, won't work for commands used with mouse - not essential
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
