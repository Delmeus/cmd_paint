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


    CommandHelperPanel(JTextField commandTextField) {
        this.commandTextField = commandTextField;
        setLayout(new BorderLayout());
        add(createShapeChooserPanel(), BorderLayout.WEST);

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            command = "";
        });
        add(resetButton, BorderLayout.EAST);
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
                command = "draw " + type.name().toLowerCase() + " ";
                commandTextField.setText(command);
            }
        });

        return panel;
    }

    private JPanel createShapeEditorPanel(ShapeType type) {
        JPanel panel = new JPanel();
        if (type == ShapeType.RECTANGLE) {
            JSpinner widthSpinner = new JSpinner(new SpinnerNumberModel(100, 0, Integer.MAX_VALUE, 10));
            JSpinner heightSpinner = new JSpinner(new SpinnerNumberModel(100, 0, Integer.MAX_VALUE, 10));

            widthSpinner.addChangeListener(e -> {
                options.put("width", String.valueOf(widthSpinner.getValue()));
                updateCommandField();
            });
            heightSpinner.addChangeListener(e -> {
                options.put("height", String.valueOf(heightSpinner.getValue()));
                updateCommandField();
            });
        }
        return null;
    }

    private JPanel optionalOptionsPanel() {
        return null;
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

    private void updateCommandField() {
        StringBuilder sb = new StringBuilder(command.trim());

        for (Map.Entry<String, String> entry : options.entrySet()) {
            sb.append(" ").append(entry.getKey()).append(" ").append(entry.getValue());
        }

        commandTextField.setText(sb.toString());
    }

}