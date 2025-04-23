import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ShapeGroupEditorPanel {

    public static JPanel createEditorPanel(ShapeGroup group) {
        JPanel groupPanel = new JPanel();
        groupPanel.setLayout(new BoxLayout(groupPanel, BoxLayout.Y_AXIS));
        groupPanel.setBorder(BorderFactory.createTitledBorder("Edit Group: " + group.name));

        for (Shape child : group.getChildren()) {
            groupPanel.add(createChildEditor(child));
        }
        return groupPanel;
    }

    private static JPanel createChildEditor(Shape shape) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Shape: " + shape.name));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.gridx = 0; gbc.gridy = 0;

        JCheckBox hollowCheck = new JCheckBox("Hollow", shape.hollow);
        hollowCheck.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getID() == ActionEvent.ACTION_PERFORMED) {
                    boolean isSelected = hollowCheck.isSelected();
                    System.out.println("Hollow checkbox is " + (isSelected ? "selected" : "deselected"));

                    if(isSelected)
                        shape.hollow();
                    else
                        shape.fill();
                }
            }
        });
        panel.add(hollowCheck, gbc);

        gbc.gridx++;
        JButton colorBtn = new JButton("Set Color");
        colorBtn.addActionListener(e -> {
            Color chosen = JColorChooser.showDialog(panel, "Choose Color", Color.BLACK);
            if (chosen != null) {
                shape.setColor(chosen);
            }
        });
        panel.add(colorBtn, gbc);

        // Scale slider
        gbc.gridx++;
        JLabel scaleLabel = new JLabel("Scale:");
        JSlider scaleSlider = new JSlider(50, 200, 100);
        scaleSlider.setMajorTickSpacing(50);
        scaleSlider.setPaintTicks(true);
        scaleSlider.setPaintLabels(true);
        scaleSlider.addChangeListener(e -> shape.scale(scaleSlider.getValue() / 100.0));  // Scale on slider change
        JPanel scalePanel = new JPanel(new BorderLayout());
        scalePanel.add(scaleLabel, BorderLayout.NORTH);
        scalePanel.add(scaleSlider, BorderLayout.SOUTH);
        panel.add(scalePanel, gbc);

        // Layer spinner
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

        return panel;
    }
}
