import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;

public class DrawingPanel extends JPanel implements MouseListener {
    private Set<Shape> selectedShapes = new HashSet<>();
    int selectedX = 0;
    int selectedY = 0;
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

    public Set<Shape> getSelectedShapes() {
        return selectedShapes;
    }

    public int getSelectedX() {
        return selectedX;
    }

    public int getSelectedY() {
        return selectedY;
    }

    @Override
    protected void paintComponent(Graphics g) {
        List<Shape> sortedShapes = new ArrayList<>(shapes.values());
        sortedShapes.sort(Comparator.naturalOrder());
        super.paintComponent(g);
        setBackground(backgroundColor);

        for (Shape shape : sortedShapes) {
            if (selectedShapes.contains(shape)) {
                shape.select();
            } else {
                shape.unselect();
            }
            shape.draw(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            int mouseX = e.getX();
            int mouseY = e.getY();
            selectedX = mouseX;
            selectedY = mouseY;

            List<Shape> sortedShapes = new ArrayList<>(shapes.values());
            sortedShapes.sort((s1, s2) -> Integer.compare(s2.layer, s1.layer));

            for (Shape shape : sortedShapes) {
                if (shape.contains(mouseX, mouseY)) {
                    if (e.isControlDown()) {
                        if (selectedShapes.contains(shape)) {
                            selectedShapes.remove(shape);
                        } else {
                            selectedShapes.add(shape);
                        }
                    } else {
                        selectedShapes.clear();
                        selectedShapes.add(shape);
                    }
                    System.out.println("Clicked on: " + shape.name);
                    break;
                }
            }

            if (!e.isControlDown() && selectedShapes.isEmpty()) {
                for (Shape shape : shapes.values()) {
                    shape.unselect();
                }
            }
        }

        if (e.getButton() == MouseEvent.BUTTON3) {
            selectedShapes.clear();
            for (Shape shape : shapes.values()) {
                shape.unselect();
            }
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
