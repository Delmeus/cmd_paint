import java.awt.*;
import java.awt.geom.Line2D;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Shape implements Comparable<Shape>, Serializable {
    String name;
    int x, y;
    int layer = 0;
    int thickness = 1;
    Color color = Color.black;
    protected int rotationAngle = 0;
    protected boolean hollow = false;
    protected boolean showName = false;
    protected boolean selected = false;
    @Serial
    private static final long serialVersionUID = 1L;

    public Shape(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    //Would be nice to define more colors in antlr
    public void setColor(String colorStr) {
        switch (colorStr.toLowerCase()) {
            case "red" -> this.color = Color.RED;
            case "blue" -> this.color = Color.BLUE;
            case "green" -> this.color = Color.GREEN;
            case "yellow" -> this.color = Color.YELLOW;
            default -> this.color = Color.BLACK;
        }
    }

    public void setColor(Color color){
        this.color = color;
    }

    public void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    public void rotate(int angle) {
        System.out.println(name + " rotated by " + angle + " degrees");
        rotationAngle += angle;
    }

    public void hollow() {
        hollow = true;
    }

    public void fill(){
        hollow = false;
    }

    public void hideName() {
        showName = false;
    }

    public void showName() {
        showName = true;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public void setLayer(int layer){
        this.layer = layer;
    }

    public void moveDown(){
        if(layer > 0)
            layer--;
    }

    public void moveUp(){
        layer++;
    }

    public void select(){
        selected = true;
    }

    public void unselect(){
        selected = false;
    }

    @Override
    public String toString() {
        return name + " at (" + x + ", " + y + ") color: " + color;
    }

    @Override
    public int compareTo(Shape other) {
        return Integer.compare(this.layer, other.layer);
    }

    public abstract boolean contains(int x, int y);

    public abstract void draw(Graphics g);

    public abstract Shape clone(int x, int y);
//    public abstract String getScript(); TODO: retrun command which would draw shape

    protected void setColor(Graphics2D g2d) {
        if(selected) {
            if(color.getAlpha() < 180)
                g2d.setColor(color.brighter());
            else
                g2d.setColor(color.darker());
            g2d.setStroke(new BasicStroke(thickness + 2));
        }
        else {
            g2d.setColor(color);
            g2d.setStroke(new BasicStroke(thickness));
        }
    }
}

class Square extends Shape {
    int size;

    public Square(String name, int x, int y, int size) {
        super(name, x, y);
        this.size = size;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        setColor(g2d);

        g2d.translate(x + size / 2, y + size / 2);
        g2d.rotate(Math.toRadians(rotationAngle));

        if(hollow)
            g2d.drawRect(-size / 2, -size / 2, size, size);
        else
            g2d.fillRect(-size / 2, -size / 2, size, size);

        g2d.rotate(-Math.toRadians(rotationAngle));
        g2d.translate(-(x + size / 2), -(y + size / 2));
        g.setColor(color);

        // smart coloring should be implemented
        if(showName){
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.BOLD, 14));
            g2d.drawString(name, x + size / 2 - 10, y + size / 2);
        }
    }

    @Override
    public boolean contains(int px, int py) {
        double radians = Math.toRadians(-rotationAngle);
        int centerX = x + size / 2;
        int centerY = y + size / 2;

        // Translate and rotate point around the square center
        double dx = px - centerX;
        double dy = py - centerY;

        double rx = dx * Math.cos(radians) - dy * Math.sin(radians);
        double ry = dx * Math.sin(radians) + dy * Math.cos(radians);

        return Math.abs(rx) <= size / 2 && Math.abs(ry) <= size / 2;
    }

    @Override
    public Shape clone(int x, int y) {
        Square cloned = new Square(this.name + "_copy", x, y, this.size);
        cloned.setColor(this.color);
        cloned.setLayer(this.layer);
        cloned.setThickness(this.thickness);
        if (hollow)
            cloned.hollow();
        return cloned;
    }
}

class Circle extends Shape {
    int radius;

    public Circle(String name, int x, int y, int radius) {
        super(name, x, y);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        setColor(g2d);

        if(hollow)
            g2d.drawOval(x, y, radius, radius);
        else
            g2d.fillOval(x, y, radius, radius);

        // smart coloring should be implemented
        if(showName){
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.BOLD, 14));
            g2d.drawString(name, x + radius / 2 - 10, y + radius / 2);
        }
    }

    @Override
    public boolean contains(int px, int py) {
        int centerX = x + radius / 2;
        int centerY = y + radius / 2;
        double dx = px - centerX;
        double dy = py - centerY;
        return dx * dx + dy * dy <= (radius / 2.0) * (radius / 2.0);
    }

    @Override
    public Shape clone(int x, int y) {
        return null;
    }
}

class Rectangle extends Shape {
    int width, height;

    public Rectangle(String name, int x, int y, int width, int height) {
        super(name, x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        setColor(g2d);

        g2d.translate(x + width / 2, y + height / 2);
        g2d.rotate(Math.toRadians(rotationAngle));

        if(hollow)
            g2d.drawRect(-width / 2, -height / 2, width, height);
        else
            g2d.fillRect(-width / 2, -height / 2, width, height);

        g2d.rotate(-Math.toRadians(rotationAngle));
        g2d.translate(-(x + width / 2), -(y + height / 2));
        g.setColor(color);

        // smart coloring should be implemented
        if(showName){
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.BOLD, 14));
            g2d.drawString(name, x + width / 2 - 10, y + height / 2);
        }
    }

    @Override
    public boolean contains(int px, int py) {
        double radians = Math.toRadians(-rotationAngle);
        int centerX = x + width / 2;
        int centerY = y + height / 2;

        double dx = px - centerX;
        double dy = py - centerY;

        double rx = dx * Math.cos(radians) - dy * Math.sin(radians);
        double ry = dx * Math.sin(radians) + dy * Math.cos(radians);

        return Math.abs(rx) <= width / 2 && Math.abs(ry) <= height / 2;
    }

    @Override
    public Shape clone(int x, int y) {
        return null;
    }
}

class Line extends Shape {
    int x2, y2;
    int length;
    public Line(String name, int x1, int y1, int x2, int y2) {
        super(name, x1, y1);
        this.x2 = x2;
        this.y2 = y2;
        this.length = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public Line(String name, int x, int y, int length) {
        super(name, x, y);
        this.length = length;
        x2 = x + length;
        y2 = y;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        setColor(g2d);

        int centerX = (x + x2) / 2;
        int centerY = (y + y2) / 2;

        g2d.translate(centerX, centerY);
        g2d.rotate(Math.toRadians(rotationAngle));

        g2d.drawLine(x - centerX, y - centerY, x2 - centerX, y2 - centerY);

        g2d.rotate(-Math.toRadians(rotationAngle));
        g2d.translate(-centerX, -centerY);

        // smart coloring should be implemented
        if(showName){
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 14));
            g.drawString(name, centerX, centerY + 10);
        }
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
        this.x2 += x;
        this.y2 += y;
    }

    @Override
    public boolean contains(int px, int py) {
        int centerX = (x + x2) / 2;
        int centerY = (y + y2) / 2;
        double radians = Math.toRadians(rotationAngle);

        double dx = px - centerX;
        double dy = py - centerY;
        double rx = dx * Math.cos(-radians) - dy * Math.sin(-radians) + centerX;
        double ry = dx * Math.sin(-radians) + dy * Math.cos(-radians) + centerY;

        return Line2D.ptSegDist(x, y, x2, y2, rx, ry) <= 3;
    }

    @Override
    public Shape clone(int x, int y) {
        return null;
    }
}

class Polygon extends Shape {
    int[] x_points;
    int[] y_points;

    public Polygon(String name, int[] x_points, int[] y_points) {
        super(name, x_points[0], y_points[0]);
        this.x_points = x_points;
        this.y_points = y_points;
    }

    //kinda wonky? fix
    @Override
    public void move(int newX, int newY) {
        int dx = newX - x;
        int dy = newY - y;

        for (int i = 0; i < x_points.length; i++) {
            x_points[i] += dx;
            y_points[i] += dy;
        }

        this.x = newX;
        this.y = newY;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        setColor(g2d);

        int cx = 0, cy = 0;
        for (int i = 0; i < x_points.length; i++) {
            cx += x_points[i];
            cy += y_points[i];
        }
        cx /= x_points.length;
        cy /= y_points.length;

        int[] rotatedX = new int[x_points.length];
        int[] rotatedY = new int[y_points.length];
        double radians = Math.toRadians(rotationAngle);

        for (int i = 0; i < x_points.length; i++) {
            int x = x_points[i] - cx;
            int y = y_points[i] - cy;
            rotatedX[i] = (int) (x * Math.cos(radians) - y * Math.sin(radians)) + cx;
            rotatedY[i] = (int) (x * Math.sin(radians) + y * Math.cos(radians)) + cy;
        }

        if(hollow)
            g2d.drawPolygon(rotatedX, rotatedY, x_points.length);
        else
            g2d.fillPolygon(rotatedX, rotatedY, x_points.length);

        // smart coloring should be implemented
        if(showName){
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.BOLD, 14));
            g2d.drawString(name, cx - 10, cy);
        }
    }

    @Override
    public boolean contains(int px, int py) {
        int cx = 0, cy = 0;
        for (int i = 0; i < x_points.length; i++) {
            cx += x_points[i];
            cy += y_points[i];
        }
        cx /= x_points.length;
        cy /= y_points.length;

        int[] rotatedX = new int[x_points.length];
        int[] rotatedY = new int[y_points.length];
        double radians = Math.toRadians(rotationAngle);

        for (int i = 0; i < x_points.length; i++) {
            int x = x_points[i] - cx;
            int y = y_points[i] - cy;
            rotatedX[i] = (int) (x * Math.cos(radians) - y * Math.sin(radians)) + cx;
            rotatedY[i] = (int) (x * Math.sin(radians) + y * Math.cos(radians)) + cy;
        }

        java.awt.Polygon poly = new java.awt.Polygon(rotatedX, rotatedY, rotatedX.length);
        return poly.contains(px, py);
    }

    @Override
    public Shape clone(int x, int y) {
        int cx = 0, cy = 0;
        for (int i = 0; i < x_points.length; i++) {
            cx += x_points[i];
            cy += y_points[i];
        }
        cx /= x_points.length;
        cy /= y_points.length;

        int dx = x - cx;
        int dy = y - cy;

        int[] newX = new int[x_points.length];
        int[] newY = new int[y_points.length];
        for (int i = 0; i < x_points.length; i++) {
            newX[i] = x_points[i] + dx;
            newY[i] = y_points[i] + dy;
        }

        Polygon cloned = new Polygon(this.name + "_copy", newX, newY);
        cloned.setColor(this.color);
        cloned.setLayer(this.layer);
        cloned.setThickness(this.thickness);
        cloned.rotationAngle = this.rotationAngle;
        if (this.hollow)
            cloned.hollow();

        return cloned;
    }
}

class ShapeGroup extends Shape{
    private final List<Shape> children;

    ShapeGroup(String name) {
        super(name, 0, 0);
        children = new ArrayList<>();
    }

    ShapeGroup(String name, List<Shape> children) {
        super(name, 0, 0);
        this.children = children;
    }

    public void add(Shape shape) {
        children.add(shape);
    }

    public void remove(Shape shape) {
        children.remove(shape);
    }

    public void remove(int index) {
        children.remove(index);
    }

    public List<Shape> getChildren() {
        return children;
    }

    @Override
    public boolean contains(int x, int y) {
        return false;
    }

    @Override
    public void draw(Graphics g) {
        for (Shape child : children) {
            child.hideName();
            child.draw(g);
        }

        if(showName){
            java.awt.Rectangle bounds = getBounds();
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 14));
            g.drawString(name, bounds.x + bounds.width / 2 - 10, bounds.y + bounds.height / 2);
        }
    }

    @Override
    public Shape clone(int x, int y) {
        return null;
    }

    @Override
    public void move(int newX, int newY) {
        java.awt.Rectangle bounds = getBounds();
        int dx = newX - bounds.x;
        int dy = newY - bounds.y;
        for (Shape shape : children) {
            shape.move(shape.x + dx, shape.y + dy);
        }
        x = newX;
        y = newY;
    }

    @Override
    public void rotate(int angle) {
        for (Shape shape : children) {
            shape.rotate(angle);
        }
        rotationAngle += angle;
    }

    private java.awt.Rectangle getBounds() {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

        for (Shape shape : children) {
            if (shape instanceof Polygon poly) {
                for (int xp : poly.x_points) minX = Math.min(minX, xp);
                for (int yp : poly.y_points) minY = Math.min(minY, yp);
                for (int xp : poly.x_points) maxX = Math.max(maxX, xp);
                for (int yp : poly.y_points) maxY = Math.max(maxY, yp);
            } else {
                minX = Math.min(minX, shape.x);
                minY = Math.min(minY, shape.y);
                maxX = Math.max(maxX, shape.x);
                maxY = Math.max(maxY, shape.y);
            }
        }

        return new java.awt.Rectangle(minX, minY, maxX - minX, maxY - minY);
    }
}