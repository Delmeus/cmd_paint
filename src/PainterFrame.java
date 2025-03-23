import javax.swing.*;
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

    @Override
    public void repaint() {
        drawingPanel.repaint();
    }
}
