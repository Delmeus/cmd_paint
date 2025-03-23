import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class DrawingPanel extends JPanel {
    private final Map<String, Shape> shapes;

    public DrawingPanel(Map<String, Shape> shapes) {
        this.shapes = shapes;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes.values()) {
            shape.draw(g);
        }
    }
}
