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
import javax.swing.event.ChangeEvent;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;

public class PainterFrame extends JFrame{
    private final List<String> history = new ArrayList<>();
    private int historyIndex = -1;
    private boolean forceOverwrite = false; // Used to suppress messages and overwrite checks when file is being read

    private final Map<String, Shape> shapes = new HashMap<>();
    private final Painter painter;

    private final Map<String, Color> availableColors = new HashMap<>();

    private final DrawingPanel drawingPanel;
    private final JTextField commandField;
    private final JPanel shapeInfoPanel = new JPanel();
    private final JPanel editorContainer = new JPanel();

    private final AtomicBoolean isConfirmWindowActive = new AtomicBoolean(false);

    @FunctionalInterface
    interface TriConsumer<A, B, C> {
        void accept(A a, B b, C c);
    }

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
            editorContainer.add(createShapeEditor(selected.iterator().next()));
        } else {
            JLabel label = new JLabel("More than one shape selected");
            editorContainer.add(label);
        }

        editorContainer.revalidate();
        editorContainer.repaint();
    }

    private JPanel createShapeEditor(Shape shape) {
        if(shape instanceof ShapeGroup)
            return createEditorPanel((ShapeGroup) shape);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder(shape.name));

        TriConsumer<String, JComponent, Integer> addLabeledField = (label, field, height) -> {
            field.setPreferredSize(new Dimension());
            JPanel row = new JPanel(new BorderLayout(5, 0));
            JLabel jLabel = new JLabel(label);
            jLabel.setPreferredSize(new Dimension(80, height));
            row.add(jLabel, BorderLayout.WEST);
            row.add(field, BorderLayout.CENTER);
            row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
            panel.add(row);
        };

        JCheckBox hollowCheck = new JCheckBox("Hollow", shape.hollow);

        JSlider rSlider = new JSlider(0, 255, shape.color.getRed());
        JSlider gSlider = new JSlider(0, 255, shape.color.getGreen());
        JSlider bSlider = new JSlider(0, 255, shape.color.getBlue());
        rSlider.setValue(shape.getColor().getRed());
        gSlider.setValue(shape.getColor().getGreen());
        bSlider.setValue(shape.getColor().getBlue());

        for (JSlider slider : List.of(rSlider, gSlider, bSlider)) {
            slider.setMajorTickSpacing(85);
            slider.setMinorTickSpacing(17);
            slider.setPaintTicks(true);
            slider.setPaintLabels(true);
            //slider.setPreferredSize(new Dimension(200, 40));
        }

        JSpinner rotationSpinner = new JSpinner(new SpinnerNumberModel(shape.rotationAngle, 0, 360, 5));
        JSpinner layerSpinner = new JSpinner(new SpinnerNumberModel(shape.layer, 0, 100, 1));
        JSpinner strokeSpinner = new JSpinner(new SpinnerNumberModel(shape.stroke, 0, 100, 1));
        JSpinner scaleSpinner = new JSpinner(new SpinnerNumberModel(1, 0, Double.MAX_VALUE, 0.1));

        editSpinner(rotationSpinner);
        editSpinner(layerSpinner);
        editSpinner(strokeSpinner);
        editSpinner(scaleSpinner);

        JButton colorButton = new JButton("Choose color");
        colorButton.setPreferredSize(new Dimension(130, 30));
        colorButton.addActionListener(e -> {
            Color chosen = JColorChooser.showDialog(panel, "Choose Color", Color.BLACK);
            if (chosen != null) {
                rSlider.setValue(chosen.getRed());
                gSlider.setValue(chosen.getGreen());
                bSlider.setValue(chosen.getBlue());
            }
        });

        addLabeledField.accept("Stroke:", strokeSpinner, 30);
        addLabeledField.accept("Rotation:", rotationSpinner, 30);
        addLabeledField.accept("Scale:", scaleSpinner, 30);
        addLabeledField.accept("Layer", layerSpinner, 30);
        addLabeledField.accept("Color R:", rSlider, 45);
        addLabeledField.accept("Color G:", gSlider, 45);
        addLabeledField.accept("Color B:", bSlider, 45);

        if(shape instanceof Line){
            addPositionRow(panel, "x1", shape.x, "\ty1", shape.y);
            addPositionRow(panel, "x2", ((Line) shape).x2, "\ty2", ((Line) shape).y2);
        } else if (shape instanceof Polygon) {
            for(int i = 0; i < ((Polygon) shape).x_points.length; i++){
                addPositionRow(panel, "x" + i, ((Polygon) shape).x_points[i],
                        "\ty" + i, (((Polygon) shape).y_points[i]));
            }
        } else {
            addPositionRow(panel, "x", shape.x, "\ty", shape.y);
        }

        JPanel hollowRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
        hollowRow.add(hollowCheck);
        panel.add(hollowRow);

        JButton applyButton = new JButton("Apply");
        applyButton.setPreferredSize(new Dimension(130, 30));
        JPanel buttonRow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonRow.add(applyButton);
        buttonRow.add(colorButton);
        panel.add(buttonRow);

        applyButton.addActionListener(e -> {
            try {
                int stroke = (int) strokeSpinner.getValue();
                int rotation = (int) rotationSpinner.getValue();
                double factor = (double) scaleSpinner.getValue();
                int r = rSlider.getValue();
                int g = gSlider.getValue();
                int b = bSlider.getValue();
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
                shape.layer = (int) layerSpinner.getValue();

                repaint();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error updating shape: " + ex.getMessage());
            }
        });


    addColorsWindow(panel, rSlider, gSlider, bSlider);
        return panel;
    }

    private void editSpinner(JSpinner spinner){
        JComponent editor = spinner.getEditor();
        if (editor instanceof JSpinner.DefaultEditor defaultEditor) {
            JFormattedTextField textField = defaultEditor.getTextField();
            textField.setHorizontalAlignment(SwingConstants.LEFT);
        }
        Dimension size = spinner.getPreferredSize();
        size.height = 60;
        spinner.setPreferredSize(size);
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

    private void addColorsWindow(JPanel panel, JSlider rSlider, JSlider gSlider, JSlider bSlider) {
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
                rSlider.setValue(c.getRed());
                gSlider.setValue(c.getGreen());
                bSlider.setValue(c.getBlue());
            });
            colorRow.add(colorBtn);
        }
        panel.add(colorRow);
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

    private JPanel createEditorPanel(ShapeGroup group) {
        JPanel groupPanel = new JPanel();
        groupPanel.setLayout(new BoxLayout(groupPanel, BoxLayout.Y_AXIS));
        groupPanel.setBorder(BorderFactory.createTitledBorder("Edit Group: " + group.name));

        for (Shape child : group.getChildren()) {
            groupPanel.add(createChildEditor(child));
        }
        repaint();
        return groupPanel;
    }

    private JPanel createChildEditor(Shape shape) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Shape: " + shape.name));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.gridx = 0; gbc.gridy = 0;

        JCheckBox hollowCheck = new JCheckBox("Hollow", shape.hollow);
        hollowCheck.addActionListener(e -> {
            if (e.getID() == ActionEvent.ACTION_PERFORMED) {
                boolean isSelected = hollowCheck.isSelected();

                if(isSelected)
                    shape.hollow();
                else
                    shape.fill();
            }
        });
        panel.add(hollowCheck, gbc);

        gbc.gridx++;
        JButton colorBtn = new JButton("Set Color");
        final Color[] selectedColor = {null};
        colorBtn.addActionListener(e -> {
            Color chosen = JColorChooser.showDialog(panel, "Choose Color", shape.getColor());
            if (chosen != null) {
                selectedColor[0] = chosen;
            }
        });
        panel.add(colorBtn, gbc);

        gbc.gridx++;
        JLabel scaleLabel = new JLabel("Scale:");
        JTextField scaleField = new JTextField("1.0");
        JPanel scalePanel = new JPanel(new BorderLayout());
        scalePanel.add(scaleLabel, BorderLayout.NORTH);
        scalePanel.add(scaleField, BorderLayout.SOUTH);
        panel.add(scalePanel, gbc);

        gbc.gridx = 0; gbc.gridy++;
        gbc.gridwidth = 3;
        JPanel layerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        layerPanel.add(new JLabel("Layer:"));
        SpinnerNumberModel model = new SpinnerNumberModel(shape.layer, 0, 100, 1);
        JSpinner spinner = new JSpinner(model);
        spinner.addChangeListener((ChangeEvent e) -> {
            shape.layer = (int) spinner.getValue();
        });
        layerPanel.add(spinner);
        panel.add(layerPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 3;
        JButton applyButton = new JButton("Apply");
        applyButton.addActionListener(e -> {
            if (hollowCheck.isSelected()) shape.hollow();
            else shape.fill();

            if (selectedColor[0] != null) shape.setColor(selectedColor[0]);

            try {
                double scaleFactor = Double.parseDouble(scaleField.getText());
                shape.scale(scaleFactor);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid scale value!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            shape.layer = (int) spinner.getValue();
            repaint();
        });
        panel.add(applyButton, gbc);
        return panel;
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
