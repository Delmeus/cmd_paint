import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

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

        List<JSlider> colorSliders = getColorSliders(shape);

        JSpinner rotationSpinner = new JSpinner(new SpinnerNumberModel(shape.rotationAngle, -360, 360, 5));
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
            if (shape instanceof Line || shape instanceof Polygon)
                rotationSpinner.setValue(0);
            parent.repaint();
        });
        layerSpinner.addChangeListener(e -> {
            shape.setLayer((int) layerSpinner.getValue());
            parent.repaint();
        });
        scaleSpinner.addChangeListener(e -> {
            shape.scale((double) scaleSpinner.getValue());
            parent.repaint();
        });

        JButton colorButton = getButton("Choose color");
        colorButton.addActionListener(e -> {
            Color chosen = JColorChooser.showDialog(panel, "Choose Color", Color.BLACK);
            if (chosen != null) {
                colorSliders.get(0).setValue(chosen.getRed());
                colorSliders.get(1).setValue(chosen.getGreen());
                colorSliders.get(2).setValue(chosen.getBlue());
            }
        });

        JButton updateButton = getButton("Update data");
        updateButton.addActionListener(e -> {
            parent.updateShapeInfoPanel();
            parent.repaint();
        });

        addLabeledField.accept("Stroke:", strokeSpinner, 30);
        addLabeledField.accept("Rotation:", rotationSpinner, 30);
        addLabeledField.accept("Scale:", scaleSpinner, 30);
        addLabeledField.accept("Layer", layerSpinner, 30);
        addLabeledField.accept("Color R:", colorSliders.get(0), 45);
        addLabeledField.accept("Color G:", colorSliders.get(1), 45);
        addLabeledField.accept("Color B:", colorSliders.get(2), 45);

        if(shape instanceof Line line){
            addPositionRow(panel, "x1", line.x, "y1", line.y, x -> line.x = x, y -> line.y = y);
            addPositionRow(panel, "x2", line.x2, "y2", line.y2, x -> line.x2 = x, y -> line.y2 = y);
        } else if (shape instanceof Polygon poly) {
            for (int i = 0; i < poly.x_points.length; i++) {
                int index = i;
                addPositionRow(panel, "x" + i, poly.x_points[i], "y" + i, poly.y_points[i],
                        x -> poly.x_points[index] = x,
                        y -> poly.y_points[index] = y);
            }
        } else {
            addPositionRow(panel, "x", shape.x, "y", shape.y,
                    x -> shape.x = x,
                    y -> shape.y = y);
        }

        JPanel hollowRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
        hollowRow.add(hollowCheck);
        panel.add(hollowRow);

        JPanel buttonColumn = new JPanel();
        buttonColumn.setLayout(new BoxLayout(buttonColumn, BoxLayout.Y_AXIS));
        buttonColumn.add(colorButton);
        buttonColumn.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonColumn.add(updateButton);
        panel.add(buttonColumn);

        addColorsWindow(panel, colorSliders.get(0), colorSliders.get(1), colorSliders.get(2));
        return panel;
    }

    private void addPositionRow(JPanel panel, String xString, int x, String yString, int y, Consumer<Integer> setter1, Consumer<Integer> setter2) {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        JLabel xLabel = new JLabel(xString + ": ");
        JLabel yLabel = new JLabel(yString + ": ");

        JSpinner xSpinner = new JSpinner(new SpinnerNumberModel(x, Integer.MIN_VALUE, Integer.MAX_VALUE, 10));
        JSpinner ySpinner = new JSpinner(new SpinnerNumberModel(y, Integer.MIN_VALUE, Integer.MAX_VALUE, 10));

        Dimension spinnerSize = new Dimension(60, 25);
        xSpinner.setPreferredSize(spinnerSize);
        ySpinner.setPreferredSize(spinnerSize);

        xSpinner.addChangeListener(e -> {
            int newX = (int) xSpinner.getValue();
            setter1.accept(newX);
            parent.repaint();
        });

        ySpinner.addChangeListener(e -> {
            int newY = (int) ySpinner.getValue();
            setter2.accept(newY);
            parent.repaint();
        });

        row.add(xLabel);
        row.add(xSpinner);
        row.add(yLabel);
        row.add(ySpinner);

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
            groupPanel.add(createShapeEditor(child));
        }
        parent.repaint();
        return groupPanel;
    }

    private List<JSlider> getColorSliders(Shape shape){
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
        List<JSlider> sliders = new ArrayList<>();
        sliders.add(rSlider);
        sliders.add(gSlider);
        sliders.add(bSlider);
        return sliders;
    }

    private JButton getButton(String text){
        JButton button = new JButton(text);
        Dimension buttonSize = new Dimension(200, 30);
        button.setPreferredSize(buttonSize);
        button.setMaximumSize(buttonSize);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }
}
