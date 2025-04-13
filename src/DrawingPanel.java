import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class DrawingPanel extends JPanel implements MouseListener {
    private Shape selectedShape = null;
    private final Map<String, Shape> shapes;
    private Color backgroundColor = Color.WHITE;
    public DrawingPanel(Map<String, Shape> shapes) {
        this.shapes = shapes;
        addMouseListener(this);
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
        repaint();
    }

    public Shape getSelectedShape() {
        return selectedShape;
    }

    @Override
    protected void paintComponent(Graphics g) {
        List<Shape> sortedShapes = new ArrayList<>(shapes.values());
        sortedShapes.sort(Comparator.naturalOrder());
        super.paintComponent(g);
        setBackground(backgroundColor);
        for (Shape shape : sortedShapes) {
            if(selectedShape == shape)
                shape.select();
            shape.draw(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        List<Shape> sortedShapes = new ArrayList<>(shapes.values());
        sortedShapes.sort((s1, s2) -> Integer.compare(s2.layer, s1.layer));
        selectedShape = null;
        for (Shape shape : sortedShapes) {
            if (shape.contains(mouseX, mouseY)) {
                selectedShape = shape;
                System.out.println("Clicked on: " + selectedShape.name);
                break;
            }
        }

        for (Shape shape : shapes.values()) {
            if (shape != selectedShape)
                shape.unselect();
        }

        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
