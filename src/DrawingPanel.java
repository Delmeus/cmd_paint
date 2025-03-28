import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class DrawingPanel extends JPanel {
    private final Map<String, Shape> shapes;
    private Color backgroundColor = Color.WHITE;
    public DrawingPanel(Map<String, Shape> shapes) {
        this.shapes = shapes;
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(backgroundColor);
        for (Shape shape : shapes.values()) {
            shape.draw(g);
        }
    }
}
