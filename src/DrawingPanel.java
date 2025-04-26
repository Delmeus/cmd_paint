import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;

public class DrawingPanel extends JPanel implements MouseListener {
    private final PainterFrame parent;

    private Set<Shape> selectedShapes = new HashSet<>();
    int selectedX = 0;
    int selectedY = 0;
    private final Map<String, Shape> shapes;
    private Color backgroundColor = Color.WHITE;

    private boolean isGridActive = false;
    public DrawingPanel(Map<String, Shape> shapes, PainterFrame parent) {
        this.parent = parent;
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

    public void toggleGrid(){
        isGridActive = !isGridActive;
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

        if(isGridActive) {
            Graphics2D g2d = (Graphics2D) g.create();
            drawGrid(g2d);
        }

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
                    parent.updateShapeInfoPanel();
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
            parent.updateShapeInfoPanel();
        }

        repaint();
    }

    private void drawGrid(Graphics2D g2d) {
        Color gridColor;
        if(checkIfBackgroundIsGray())
            gridColor = Color.BLACK;
        else
            gridColor = new Color(220, 220, 220);
        g2d.setColor(gridColor);
        int gridSize = 50;
        int width = getWidth();
        int height = getHeight();

        for (int x = 0; x <= width; x += gridSize) {
            g2d.drawLine(x, 0, x, height);
            g2d.setFont(new Font("Arial", Font.PLAIN, 10));
            g2d.drawString(Integer.toString(x), x + 2, 10);
        }

        for (int y = 0; y <= height; y += gridSize) {
            g2d.drawLine(0, y, width, y);
            g2d.setFont(new Font("Arial", Font.PLAIN, 10));
            g2d.drawString(Integer.toString(y), 2, y - 2);
        }
    }

    private boolean checkIfBackgroundIsGray(){
        Color c = backgroundColor;
        return c.getRed() > 200 && c.getRed() < 240 && c.getGreen() > 200 && c.getGreen() < 240
                && c.getBlue() > 200 && c.getBlue() < 240;
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
