import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class PainterFrame extends JFrame{
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

    public Shape getSelectedShape(){
        return drawingPanel.getSelectedShape();
    }

    public int getSelectedX() {
        return drawingPanel.selectedX;
    }

    public int getSelectedY() {
        return drawingPanel.selectedY;
    }

    public boolean hasShapeSelected(){
        return drawingPanel.getSelectedShape() != null;
    }

    @Override
    public void repaint() {
        drawingPanel.repaint();
    }

    public boolean saveAsImage() {
        int width = drawingPanel.getWidth();
        int height = drawingPanel.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = image.createGraphics();

        drawingPanel.paint(g2d);

        g2d.dispose();

        try {
            ImageIO.write(image, "PNG", new File("drawing.png"));
            System.out.println("Image saved successfully.");
            return true;
        } catch (IOException e) {
            System.out.println("Error saving image: " + e.getMessage());
            return false;
        }
    }
}
