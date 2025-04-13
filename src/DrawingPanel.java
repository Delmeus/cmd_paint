import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
        List<Shape> sortedShapes = new ArrayList<>(shapes.values());
        sortedShapes.sort(Comparator.naturalOrder());
        super.paintComponent(g);
        setBackground(backgroundColor);
        for (Shape shape : sortedShapes) {
            shape.draw(g);
        }
    }
}
