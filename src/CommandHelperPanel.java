import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

enum ShapeType{
    SQUARE,
    CIRCLE,
    RECTANGLE,
    POLYGON,
    LINE
}

public class CommandHelperPanel extends JPanel {

    private final JTextField commandTextField;
    private String command = "";

    private Map<String, String> options = new HashMap<>();
    private final JPanel shapeEditorContainer = new JPanel(new BorderLayout());

    private int selectedX = 0;
    private int selectedY = 0;
    private JSpinner xSpinner;
    private JSpinner ySpinner;

    CommandHelperPanel(JTextField commandTextField) {
        this.commandTextField = commandTextField;
        setLayout(new BorderLayout());
        add(createShapeChooserPanel(), BorderLayout.WEST);

        shapeEditorContainer.setLayout(new BoxLayout(shapeEditorContainer, BoxLayout.Y_AXIS));
        add(shapeEditorContainer, BorderLayout.CENTER);

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            command = "";
            options.clear();
            commandTextField.setText("");
            shapeEditorContainer.removeAll();
            shapeEditorContainer.revalidate();
            shapeEditorContainer.repaint();
        });
        add(resetButton, BorderLayout.EAST);
    }

    public void setSelectedX(int selectedX) {
        this.selectedX = selectedX;
        if (xSpinner != null)
            xSpinner.setValue(selectedX);
    }

    public void setSelectedY(int selectedY) {
        this.selectedY = selectedY;
        if (ySpinner != null)
            ySpinner.setValue(selectedY);
    }

    private JPanel createShapeChooserPanel() {
        JPanel shapesPanel = new JPanel();
        shapesPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        for (ShapeType type : ShapeType.values()) {
            shapesPanel.add(createShapeButton(type));
        }

        return shapesPanel;
    }

    private JPanel createShapeButton(ShapeType type) {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawShapeIcon(g, type);
            }
        };
        panel.setPreferredSize(new Dimension(20, 20));
        panel.setMaximumSize(new Dimension(20, 20));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setBackground(Color.WHITE);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                command = "draw \"name\" " + type.name().toLowerCase() + " ";
                options.clear();
                commandTextField.setText(command);
                showShapeEditor(type);
            }
        });

        return panel;
    }

    private JPanel createShapeEditorPanel(ShapeType type) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        addNameField(panel);
        switch (type) {
            case RECTANGLE -> {
                xSpinner = addSizeSpinner("x", panel, Integer.MIN_VALUE, selectedX);
                ySpinner = addSizeSpinner("y", panel, Integer.MIN_VALUE, selectedY);
                panel.add(xSpinner);
                panel.add(ySpinner);
                panel.add(addSizeSpinner("width", panel, 1, 100));
                panel.add(addSizeSpinner("height", panel, 1, 80));
            }
            case CIRCLE -> {
                xSpinner = addSizeSpinner("x", panel, Integer.MIN_VALUE, selectedX);
                ySpinner = addSizeSpinner("y", panel, Integer.MIN_VALUE, selectedY);
                panel.add(xSpinner);
                panel.add(ySpinner);
                panel.add(addSizeSpinner("radius", panel, 1, 100));
            }
            case SQUARE -> {
                xSpinner = addSizeSpinner("x", panel, Integer.MIN_VALUE, selectedX);
                ySpinner = addSizeSpinner("y", panel, Integer.MIN_VALUE, selectedY);
                panel.add(xSpinner);
                panel.add(ySpinner);
                panel.add(addSizeSpinner("size", panel, 1, 100));
            }
            case LINE -> {
                xSpinner = addSizeSpinner("x", panel, Integer.MIN_VALUE, selectedX);
                ySpinner = addSizeSpinner("y", panel, Integer.MIN_VALUE, selectedY);
                panel.add(xSpinner);
                panel.add(ySpinner);
                panel.add(addSizeSpinner("x2", panel, Integer.MIN_VALUE, selectedX + 100));
                panel.add(addSizeSpinner("y2", panel, Integer.MIN_VALUE, selectedY));
            }
            case POLYGON -> {
                panel.add(new JLabel("Please add position manually"));
            }
            default -> {
                panel.add(new JLabel("No editable properties"));
            }
        }
        return panel;
    }

    private JSpinner addSizeSpinner(String name, JPanel panel, int min, int defaultValue){
        panel.add(new JLabel(name + ":"));
        JSpinner spinner = new JSpinner(new SpinnerNumberModel(defaultValue, min, Integer.MAX_VALUE, 10));
        options.put(name, spinner.getValue().toString());
        updateCommandField();
        spinner.addChangeListener(e -> {
            options.put(name, spinner.getValue().toString());
            updateCommandField();
        });
        spinner.setPreferredSize(new Dimension(50, 20));
//        panel.add(spinner);
        return spinner;
    }

    private JPanel optionalOptionsPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JButton colorButton = new JButton("Pick Color");
        colorButton.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(this, "Choose a color", Color.BLACK);
            if (selectedColor != null) {
                String color = "(" + selectedColor.getRed() + ", " + selectedColor.getGreen() + ", " + selectedColor.getBlue() + ")";
                options.put("color", color);
                updateCommandField();
            }
        });
        panel.add(colorButton);

        panel.add(new JLabel("Stroke:"));
        JSpinner strokeSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        options.put("stroke", strokeSpinner.getValue().toString());
        strokeSpinner.addChangeListener(e -> {
            options.put("stroke", strokeSpinner.getValue().toString());
            updateCommandField();
        });
        panel.add(strokeSpinner);

        panel.add(new JLabel("Layer:"));
        JSpinner layerSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        options.put("layer", layerSpinner.getValue().toString());
        layerSpinner.addChangeListener(e -> {
            options.put("layer", layerSpinner.getValue().toString());
            updateCommandField();
        });
        panel.add(layerSpinner);

        JCheckBox hollowCheckBox = new JCheckBox("Hollow:");
        hollowCheckBox.addActionListener(e -> {
            if(hollowCheckBox.isSelected())
                options.put("hollow", "");
            else options.remove("hollow");
            updateCommandField();
        });
        panel.add(hollowCheckBox);

        return panel;
    }

    private void addNameField(JPanel panel){
        panel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField("name");
        nameField.addActionListener(e -> {
           options.put("name", nameField.getText());
           updateCommandField();
        });
        nameField.setPreferredSize(new Dimension(100, 20));
        panel.add(nameField);
    }

    private void drawShapeIcon(Graphics g, ShapeType type) {
        g.setColor(Color.BLACK);
        int w = 20;
        int h = 20;
        int size = Math.min(w, h) / 2;
        int x = (w - size) / 2;
        int y = (h - size) / 2;

        switch (type) {
            case SQUARE -> g.drawRect(x, y, size, size);
            case CIRCLE -> g.drawOval(x, y, size, size);
            case RECTANGLE -> g.drawRect(x, y + size/4, size, size/2);
            case LINE -> g.drawLine(x, y, x + size, y + size);
            case POLYGON -> {
                int[] xPoints = {x + size/2, x, x + size};
                int[] yPoints = {y, y + size, y + size};
                g.drawPolygon(xPoints, yPoints, 3);
            }
        }
    }

    private void showShapeEditor(ShapeType type) {
        shapeEditorContainer.removeAll();

        JPanel editor = createShapeEditorPanel(type);
        shapeEditorContainer.add(editor);

        JPanel optionalPanel = optionalOptionsPanel();
        shapeEditorContainer.add(optionalPanel);

        shapeEditorContainer.revalidate();
        shapeEditorContainer.repaint();
    }

    private void updateCommandField() {
        StringBuilder sb = new StringBuilder(command.trim());

        if (options.containsKey("name")) {
            String currentCommand = sb.toString();
            int firstQuote = currentCommand.indexOf("\"");
            int secondQuote = currentCommand.indexOf("\"", firstQuote + 1);
            if (firstQuote != -1 && secondQuote != -1) {
                sb = new StringBuilder(
                        currentCommand.substring(0, firstQuote + 1) +
                                options.get("name") +
                                currentCommand.substring(secondQuote)
                );
            }
        }

        boolean hasStart = options.containsKey("x") && options.containsKey("y");
        boolean hasEnd = options.containsKey("x2") && options.containsKey("y2");

        if (hasStart)
            sb.append(" (").append(options.get("x")).append(", ").append(options.get("y"));

        if (hasEnd)
            sb.append(", ").append(options.get("x2")).append(", ").append(options.get("y2"));

        if(hasStart)
            sb.append(")");

        for (Map.Entry<String, String> entry : options.entrySet()) {
            String key = entry.getKey();
            if (checkIfKeyRequiresOmitting(key)) continue;
            if (key.equals("hollow")){
                sb.append(" ").append("hollow").append(" ");
            }
            else
                sb.append(" ").append(entry.getKey()).append(" ").append(entry.getValue());
        }

        commandTextField.setText(sb.toString());
    }

    private boolean checkIfKeyRequiresOmitting(String key){
        return key.equals("x") || key.equals("y") || key.equals("x2") || key.equals("y2") || key.equals("name");
    }

}