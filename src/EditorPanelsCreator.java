import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditorPanelsCreator {
    private final PainterFrame parent;
    private final Map<String, Color> availableColors = new HashMap<>();

    public EditorPanelsCreator(PainterFrame parent) {
        this.parent = parent;
    }

    public void addDefinedColor(String name, Color color){
        availableColors.put(name, color);
    }

    public JPanel createShapeEditor(Shape shape) {
        if(shape instanceof ShapeGroup)
            return createEditorPanel((ShapeGroup) shape);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder(shape.name));

        PainterFrame.TriConsumer<String, JComponent, Integer> addLabeledField = (label, field, height) -> {
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

        hollowCheck.addActionListener(e -> {
            if (hollowCheck.isSelected()) shape.hollow();
            else shape.fill();
            parent.repaint();
        });

        JSlider rSlider = new JSlider(0, 255, shape.color.getRed());
        JSlider gSlider = new JSlider(0, 255, shape.color.getGreen());
        JSlider bSlider = new JSlider(0, 255, shape.color.getBlue());
        rSlider.setValue(shape.getColor().getRed());
        gSlider.setValue(shape.getColor().getGreen());
        bSlider.setValue(shape.getColor().getBlue());

        ChangeListener colorListener = e -> {
            int r = rSlider.getValue();
            int g = gSlider.getValue();
            int b = bSlider.getValue();
            shape.setColor(new Color(r, g, b));
            parent.repaint();
        };


        for (JSlider slider : List.of(rSlider, gSlider, bSlider)) {
            slider.setMajorTickSpacing(85);
            slider.setMinorTickSpacing(17);
            slider.setPaintTicks(true);
            slider.setPaintLabels(true);
            slider.addChangeListener(colorListener);
        }

        JSpinner rotationSpinner = new JSpinner(new SpinnerNumberModel(shape.rotationAngle, 0, 360, 5));
        JSpinner layerSpinner = new JSpinner(new SpinnerNumberModel(shape.layer, 0, 100, 1));
        JSpinner strokeSpinner = new JSpinner(new SpinnerNumberModel(shape.stroke, 0, 100, 1));
        JSpinner scaleSpinner = new JSpinner(new SpinnerNumberModel(1, 0, Double.MAX_VALUE, 0.1));

        editSpinner(rotationSpinner);
        editSpinner(layerSpinner);
        editSpinner(strokeSpinner);
        editSpinner(scaleSpinner);

        strokeSpinner.addChangeListener(e -> {
            shape.setStroke((int) strokeSpinner.getValue());
            parent.repaint();
        });
        rotationSpinner.addChangeListener(e -> {
            shape.setRotationAngle((int) rotationSpinner.getValue());
            parent.repaint();
        });
        layerSpinner.addChangeListener(e -> {
            shape.layer = (int) layerSpinner.getValue();
            parent.repaint();
        });
        scaleSpinner.addChangeListener(e -> {
            shape.scale((double) scaleSpinner.getValue());
            parent.repaint();
        });

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
        JPanel buttonRow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonRow.add(colorButton);
        panel.add(buttonRow);

        addColorsWindow(panel, rSlider, gSlider, bSlider);
        return panel;
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

    private JPanel createEditorPanel(ShapeGroup group) {
        JPanel groupPanel = new JPanel();
        groupPanel.setLayout(new BoxLayout(groupPanel, BoxLayout.Y_AXIS));
        groupPanel.setBorder(BorderFactory.createTitledBorder("Edit Group: " + group.name));

        for (Shape child : group.getChildren()) {
            groupPanel.add(createChildEditor(child));
        }
//        repaint();
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
//            repaint();
        });
        panel.add(applyButton, gbc);
        return panel;
    }

}
