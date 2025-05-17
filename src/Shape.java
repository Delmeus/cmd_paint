import java.awt.*;
import java.awt.geom.Line2D;
import java.io.Serial;
import java.io.Serializable;
import java.util.*;
import java.util.List;

public abstract class Shape implements Comparable<Shape>, Serializable {
    String name;
    int x, y;
    int layer = 0;
    int stroke = 1;
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

    public void setColor(String colorStr) {
        switch (colorStr.toLowerCase()) {
            case "red" -> this.color = Color.RED;
            case "green" -> this.color = Color.GREEN;
            case "blue" -> this.color = Color.BLUE;
            case "yellow" -> this.color = Color.YELLOW;
            case "orange" -> this.color = Color.ORANGE;
            case "magenta" -> this.color = Color.MAGENTA;
            case "cyan" -> this.color = Color.CYAN;
            case "white" -> this.color = Color.WHITE;
            default -> this.color = Color.BLACK;
        }
    }

    public void setColor(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    public void rotate(int angle) {
        rotationAngle += angle;
    }

    public int getRotationAngle() {
        return rotationAngle;
    }

    public void setRotationAngle(int angle) {
        rotationAngle = angle;
    }

    public boolean isHollow() {
        return hollow;
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

    public void setStroke(int stroke) {
        this.stroke = stroke;
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

    public void moveBy(int dx, int dy) {
        this.x += dx;
        this.y += dy;
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
    public abstract List<String> getScript();
    public abstract void scale(double factor);

    protected Stroke getStroke(){
        if (selected)
            if (hollow)
                return new BasicStroke(stroke + 2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, new float[]{9}, 0.0f);
            else
                return new BasicStroke(4, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, new float[]{9}, 0.0f);
        return new BasicStroke(stroke);
    }

    protected boolean isColorDark(){
        return color.getRed() < 120 && color.getBlue() < 120 && color.getGreen() < 120;
    }

    protected void setFont(Graphics2D g2d){
        if (isColorDark())
            g2d.setColor(new Color(220, 220, 220));
        else
            g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 14));
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
        g2d.setColor(color);
        g2d.setStroke(getStroke());

        g2d.translate(x + size / 2, y + size / 2);
        g2d.rotate(Math.toRadians(rotationAngle));

        if(hollow)
            g2d.drawRect(-size / 2, -size / 2, size, size);
        else {
            g2d.fillRect(-size / 2, -size / 2, size, size);
            if(selected){
                g2d.setColor(Color.BLACK);
                g2d.drawRect(-size / 2, -size / 2, size, size);
            }
        }

        g2d.rotate(-Math.toRadians(rotationAngle));
        g2d.translate(-(x + size / 2), -(y + size / 2));

        if (showName){
            setFont(g2d);
            g2d.drawString(name, x + size / 2 - 10, y + size / 2);
        }
    }

    @Override
    public boolean contains(int px, int py) {
        double radians = Math.toRadians(-rotationAngle);
        int centerX = x + size / 2;
        int centerY = y + size / 2;

        double dx = px - centerX;
        double dy = py - centerY;

        double rx = dx * Math.cos(radians) - dy * Math.sin(radians);
        double ry = dx * Math.sin(radians) + dy * Math.cos(radians);

        return Math.abs(rx) <= size / 2 && Math.abs(ry) <= size / 2;
    }

    @Override
    public Shape clone(int x, int y) {
        Square cloned = new Square(this.name + "_c", x, y, this.size);
        cloned.setColor(this.color);
        cloned.setLayer(this.layer);
        cloned.setStroke(this.stroke);
        if (hollow)
            cloned.hollow();
        cloned.setRotationAngle(this.rotationAngle);
        return cloned;
    }

    @Override
    public List<String> getScript() {
        List<String> script = new ArrayList<>();
        String drawString = "draw " + "\"" + name + "\" square (" + x + ", " + y + ") size "
                + size + " color (" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() +
                ") stroke " + stroke + " layer " + layer;
        if(hollow)
            drawString += " hollow";
        script.add(drawString);
        if(rotationAngle != 0)
            script.add("rotate " + "\"" + name + "\" "  + rotationAngle);
        return script;
    }

    @Override
    public void scale(double factor) {
        size = (int)(size * factor);
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
        g2d.setColor(color);
        g2d.setStroke(getStroke());

        if(hollow)
            g2d.drawOval(x, y, radius, radius);
        else {
            g2d.fillOval(x, y, radius, radius);
            if(selected){
                g2d.setColor(Color.BLACK);
                g2d.drawOval(x, y, radius, radius);
            }
        }

        if(showName){
            setFont(g2d);
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
        Circle cloned = new Circle(name + "_c", x, y, radius);
        cloned.setColor(this.color);
        cloned.setLayer(this.layer);
        cloned.setStroke(this.stroke);
        if (hollow)
            cloned.hollow();
        return cloned;
    }

    @Override
    public List<String> getScript() {
        List<String> script = new ArrayList<>();
        String drawString = "draw " + "\"" + name + "\" circle (" + x + ", " + y + ") radius "
                + radius + " color (" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() +
                ") stroke " + stroke + " layer " + layer;
        if(hollow)
            drawString += " hollow";
        script.add(drawString);
        return script;
    }

    @Override
    public void scale(double factor) {
        radius = (int)(radius * factor);
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
        g2d.setColor(color);
        g2d.setStroke(getStroke());

        g2d.translate(x + width / 2, y + height / 2);
        g2d.rotate(Math.toRadians(rotationAngle));

        if(hollow)
            g2d.drawRect(-width / 2, -height / 2, width, height);
        else {
            g2d.fillRect(-width / 2, -height / 2, width, height);
            if (selected) {
                g2d.setColor(Color.BLACK);
                g2d.drawRect(-width / 2, -height / 2, width, height);
            }
        }

        g2d.rotate(-Math.toRadians(rotationAngle));
        g2d.translate(-(x + width / 2), -(y + height / 2));

        if(showName){
            setFont(g2d);
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
        Rectangle cloned = new Rectangle(name + "_c", x, y, width, height);
        cloned.setColor(this.color);
        cloned.setLayer(this.layer);
        cloned.setStroke(this.stroke);
        if (hollow)
            cloned.hollow();
        cloned.setRotationAngle(this.rotationAngle);
        return cloned;
    }

    @Override
    public List<String> getScript() {
        List<String> script = new ArrayList<>();
        String drawString = "draw " + "\"" + name + "\" rectangle (" + x + ", " + y + ") width "
                + width + " height " + height +
                " color (" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() +
                ") stroke " + stroke + " layer " + layer;
        if(hollow)
            drawString += " hollow";
        script.add(drawString);
        if(rotationAngle != 0)
            script.add("rotate " + "\"" + name + "\" "  + rotationAngle);
        return script;
    }

    @Override
    public void scale(double factor) {
        width = (int)(width * factor);
        height = (int)(height * factor);
    }
}

class Line extends Shape {
    int x2, y2;
    int length;
    public Line(String name, int x1, int y1, int x2, int y2) {
        super(name, x1, y1);
        this.x2 = x2;
        this.y2 = y2;
        this.length = calculateLength();
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
        g2d.setColor(color);
        g2d.setStroke(getStroke());

        int centerX = (x + x2) / 2;
        int centerY = (y + y2) / 2;
        g2d.drawLine(x, y, x2, y2);

        if(showName){
            setFont(g2d);
            g.drawString(name, centerX, centerY + 10);
        }
    }

    @Override
    public void setRotationAngle(int angle){
        rotationAngle = angle;
        applyRotation();
    }

    @Override
    public void rotate(int angle){
        rotationAngle = angle;
        applyRotation();
    }

    public void applyRotation() {
        int centerX = (x + x2) / 2;
        int centerY = (y + y2) / 2;

        double angleRad = Math.toRadians(rotationAngle);

        int[] newPoint1 = rotatePoint(x, y, centerX, centerY, angleRad);
        x = newPoint1[0];
        y = newPoint1[1];

        int[] newPoint2 = rotatePoint(x2, y2, centerX, centerY, angleRad);
        x2 = newPoint2[0];
        y2 = newPoint2[1];

        rotationAngle = 0;
    }

    private int[] rotatePoint(int px, int py, int cx, int cy, double angle) {
        double dx = px - cx;
        double dy = py - cy;

        int rx = (int) Math.round(cx + dx * Math.cos(angle) - dy * Math.sin(angle));
        int ry = (int) Math.round(cy + dx * Math.sin(angle) + dy * Math.cos(angle));
        return new int[]{rx, ry};
    }

    @Override
    public void move(int newX, int newY) {
        int dx = x2 - x;
        int dy = y2 - y;
        this.x = newX;
        this.y = newY;
        this.x2 = newX + dx;
        this.y2 = newY + dy;
    }

    @Override
    public void moveBy(int dx, int dy) {
        this.x += dx;
        this.y += dy;
        this.x2 += dx;
        this.y2 += dy;
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
        int dx = this.x2 - this.x;
        int dy = this.y2 - this.y;

        Line cloned = new Line(name + "_c", x, y, x + dx, y + dy);

        cloned.setColor(this.color);
        cloned.setLayer(this.layer);
        cloned.setStroke(this.stroke);
        if (hollow)
            cloned.hollow();
        return cloned;
    }

    @Override
    public List<String> getScript() {
        List<String> script = new ArrayList<>();
        String drawString = "draw " + "\"" + name + "\" line (" + x + ", " + y + ", " + x2 + ", " + y2 + ") color"
                + "(" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() +
                ") stroke " + stroke + " layer " + layer;
        if(hollow)
            drawString += " hollow";
        script.add(drawString);
        if(rotationAngle != 0)
            script.add("rotate " + "\"" + name + "\" "  + rotationAngle);
        return script;
    }

    @Override
    public void scale(double factor) {
        int dx = x2 - x;
        int dy = y2 - y;
        dx = (int) (dx * factor);
        dy = (int) (dy * factor);
        x2 = x + dx;
        y2 = y + dy;
        length = calculateLength();
    }

    private int calculateLength() {
        return (int) Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2));
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
    public void moveBy(int dx, int dy) {
        for(int i = 0; i < x_points.length; i++){
            x_points[i] += dx;
            y_points[i] += dy;
        }
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g2d.setStroke(getStroke());

        int cx = 0, cy = 0;
        for (int i = 0; i < x_points.length; i++) {
            cx += x_points[i];
            cy += y_points[i];
        }
        cx /= x_points.length;
        cy /= y_points.length;

        if (hollow)
            g2d.drawPolygon(x_points, y_points, x_points.length);
        else {
            g2d.fillPolygon(x_points, y_points, x_points.length);
            if (selected) {
                g2d.setColor(Color.BLACK);
                g2d.drawPolygon(x_points, y_points, x_points.length);
            }
        }

        if(showName){
            setFont(g2d);
            g2d.drawString(name, cx - 10, cy);
        }
    }

    @Override
    public void rotate(int angle){
        this.rotationAngle = angle;
        applyRotation();
    }

    @Override
    public void setRotationAngle(int angle) {
        this.rotationAngle = angle;
        applyRotation();
    }

    private void applyRotation() {
        int cx = 0, cy = 0;
        for (int i = 0; i < x_points.length; i++) {
            cx += x_points[i];
            cy += y_points[i];
        }
        cx /= x_points.length;
        cy /= y_points.length;

        double angleRad = Math.toRadians(rotationAngle);

        for (int i = 0; i < x_points.length; i++) {
            int dx = x_points[i] - cx;
            int dy = y_points[i] - cy;

            int rotatedX = (int) Math.round(cx + dx * Math.cos(angleRad) - dy * Math.sin(angleRad));
            int rotatedY = (int) Math.round(cy + dx * Math.sin(angleRad) + dy * Math.cos(angleRad));

            x_points[i] = rotatedX;
            y_points[i] = rotatedY;
        }

        this.x = x_points[0];
        this.y = y_points[0];
        rotationAngle = 0;
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
        int[] newX = Arrays.copyOf(this.x_points, this.x_points.length);
        int[] newY = Arrays.copyOf(this.y_points, this.y_points.length);

        Polygon cloned = new Polygon(this.name + "_c", newX, newY);
        cloned.setColor(this.color);
        cloned.setLayer(this.layer);
        cloned.setStroke(this.stroke);
        cloned.rotationAngle = this.rotationAngle;
        if (this.hollow)
            cloned.hollow();

        cloned.move(x, y);
        return cloned;
    }

    @Override
    public List<String> getScript() {
        List<String> script = new ArrayList<>();
        String drawString = "draw " + "\"" + name + "\" polygon " + getXString() + " " + getYString() +
                " color (" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() +
                ") stroke " + stroke + " layer " + layer;
        if(hollow)
            drawString += " hollow";
        script.add(drawString);
        if(rotationAngle != 0)
            script.add("rotate " + "\"" + name + "\" "  + rotationAngle);
        return script;
    }

    private String getXString(){
        StringBuilder xString = new StringBuilder("(");
        for (int i = 0; i < x_points.length; i++) {
            if(i != x_points.length - 1)
                xString.append(x_points[i]).append(", ");
            else
                xString.append(x_points[i]);
        }
        xString.append(")");
        return xString.toString();
    }

    private String getYString(){
        StringBuilder yString = new StringBuilder("(");
        for (int i = 0; i < y_points.length; i++) {
            if(i != y_points.length - 1)
                yString.append(y_points[i]).append(", ");
            else
                yString.append(y_points[i]);
        }
        yString.append(")");
        return yString.toString();
    }

    @Override
    public void scale(double factor) {
        int cx = 0, cy = 0;
        for (int i = 0; i < x_points.length; i++) {
            cx += x_points[i];
            cy += y_points[i];
        }
        cx /= x_points.length;
        cy /= y_points.length;

        for (int i = 0; i < x_points.length; i++) {
            x_points[i] = (int)((x_points[i] - cx) * factor + cx);
            y_points[i] = (int)((y_points[i] - cy) * factor + cy);
        }

        x = x_points[0];
        y = y_points[0];
    }

}

class ShapeGroup extends Shape{
    private final List<String> drawOrder = new ArrayList<>();
    private final Map<String, Shape> children = new HashMap<>();

    ShapeGroup(String name, List<Shape> children) {
        super(name, 0, 0);
        for(Shape child : children) {
            this.children.put(child.name, child);
            this.drawOrder.add(child.name);
        }
        sortDrawOrder();
    }

    public void add(Shape shape) {
        children.put(shape.name, shape);
        drawOrder.add(shape.name);
        sortDrawOrder();
    }

    public void remove(Shape shape) {
        children.remove(shape.name);
        drawOrder.remove(shape.name);
    }

    public List<Shape> getChildren() {
        List<Shape> ordered = new ArrayList<>();
        for (String name : drawOrder) {
            Shape shape = children.get(name);
            if (shape != null) ordered.add(shape);
        }
        return ordered;
    }

    @Override
    public boolean contains(int x, int y) {
        for (String name : drawOrder) {
            Shape child = children.get(name);
            if (child != null && child.contains(x, y))
                return true;
        }
        return false;
    }

    @Override
    public void draw(Graphics g) {
        sortDrawOrder();
        for (String name : drawOrder) {
            Shape child = children.get(name);
            if (child != null) {
                if (selected) child.select();
                else child.unselect();
                child.hideName();
                child.draw(g);
            }
        }

        if(showName){
            java.awt.Rectangle bounds = getBounds();
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 14));
            g.drawString(name, bounds.x + bounds.width / 2 - 10, bounds.y + bounds.height / 2);
        }
    }

    public void hollow(String childName) {
        if (children.containsKey(childName))
            children.get(childName).hollow();
    }

    public void fill(String childName) {
        if (children.containsKey(childName))
            children.get(childName).fill();
    }

    public void setColor(String childName, Color color) {
        if (children.containsKey(childName))
            children.get(childName).setColor(color);
    }

    @Override
    public void hollow() {
        for (Shape child : children.values())
            child.hollow();
    }

    @Override
    public void fill(){
        for (Shape child : children.values())
            child.fill();
    }

    @Override
    public void setColor(Color color) {
        for (Shape child : children.values())
            child.setColor(color);
    }

    @Override
    public Shape clone(int x, int y) {
        java.awt.Rectangle bounds = getBounds();
        int dx = x - bounds.x;
        int dy = y - bounds.y;

        List<Shape> copies = new ArrayList<>();
        for (Shape child : getChildren()) {
            Shape clonedChild = child.clone(child.x + dx, child.y + dy);
            copies.add(clonedChild);
        }

        ShapeGroup clonedGroup = new ShapeGroup(name + "_c", copies);
        clonedGroup.setLayer(this.layer);
        clonedGroup.setStroke(this.stroke);
        return clonedGroup;
    }

    @Override
    public void move(int newX, int newY) {
        java.awt.Rectangle bounds = getBounds();
        int dx = newX - bounds.x;
        int dy = newY - bounds.y;
        for (Shape shape : children.values()) {
            shape.move(shape.x + dx, shape.y + dy);
        }
        x = newX;
        y = newY;
    }

    @Override
    public void moveBy(int dx, int dy) {
        for (Shape shape : children.values()) {
            shape.moveBy(dx, dy);
        }
    }

    @Override
    public void rotate(int angle) {
        for (Shape shape : children.values()) {
            shape.rotate(angle);
        }
        rotationAngle += angle;
    }

    @Override
    public List<String> getScript() {
        List<String> script = new ArrayList<>();
        for (Shape child : children.values()) {
            script.addAll(child.getScript());
        }
        StringBuilder groupString = new StringBuilder("group \"" + name + "\" ");
        for (Shape child : children.values()) {
            groupString.append("\"").append(child.name).append("\" ");
        }
        script.add(groupString.toString());
        script.add("layer \"" + name + "\" " + layer);
        return script;
    }

    private java.awt.Rectangle getBounds() {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

        for (Shape shape : children.values()) {
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

    public void scale(String childName, double factor){
        if (children.containsKey(childName))
            children.get(childName).scale(factor);
    }

    @Override
    public void scale(double factor) {
        for (Shape child : children.values()) {
            child.scale(factor);
        }
    }

    private void sortDrawOrder() {
        drawOrder.sort((name1, name2) -> {
            Shape s1 = children.get(name1);
            Shape s2 = children.get(name2);
            return s1.compareTo(s2);
        });
    }

}