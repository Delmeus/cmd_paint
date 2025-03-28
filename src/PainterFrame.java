import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PainterFrame extends JFrame {
    private final Map<String, Shape> shapes;
    private final DrawingPanel drawingPanel;

    public PainterFrame(Map<String, Shape> shapes) {
        this.shapes = shapes;
        this.drawingPanel = new DrawingPanel(shapes);

        setTitle("CmdPaint - Drawing");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        add(drawingPanel);
    }

    public void setBackgroundColor(String colorStr) {
        Color color;
        switch (colorStr.toLowerCase()) {
            case "red" -> color = Color.RED;
            case "blue" -> color = Color.BLUE;
            case "green" -> color = Color.GREEN;
            case "yellow" -> color = Color.YELLOW;
            default -> color = Color.WHITE;
        }
        drawingPanel.setBackgroundColor(color);
    }

    public void setBackgroundColor(Color color) {
        drawingPanel.setBackgroundColor(color);
    }
    @Override
    public void repaint() {
        drawingPanel.repaint();
    }
}
