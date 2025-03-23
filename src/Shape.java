import java.awt.*;

abstract class Shape {
    String name;
    int x, y;
    Color color = Color.black;
    protected int rotationAngle = 0;
    protected boolean hollow = false;

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

    @Override
    public String toString() {
        return name + " at (" + x + ", " + y + ") color: " + color;
    }

    public abstract void draw(Graphics g);
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

        g2d.translate(x + size / 2, y + size / 2);
        g2d.rotate(Math.toRadians(rotationAngle));

        if(hollow)
            g2d.drawRect(-size / 2, -size / 2, size, size);
        else
            g2d.fillRect(-size / 2, -size / 2, size, size);

        g2d.rotate(-Math.toRadians(rotationAngle));
        g2d.translate(-(x + size / 2), -(y + size / 2));
        g.setColor(color);

      //  if(hollow)
        //    g.drawRect(x, y, size, size);
        //else
          //  g.fillRect(x, y, size, size);
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
        g.setColor(color);

        if(hollow)
            g.drawOval(x, y, radius, radius);
        else
            g.fillOval(x, y, radius, radius);
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

        g2d.translate(x + width / 2, y + height / 2);
        g2d.rotate(Math.toRadians(rotationAngle));

        if(hollow)
            g2d.drawRect(-width / 2, -height / 2, width, height);
        else
            g2d.fillRect(-width / 2, -height / 2, width, height);

        g2d.rotate(-Math.toRadians(rotationAngle));
        g2d.translate(-(x + width / 2), -(y + height / 2));
        g.setColor(color);
        //g.setColor(color);
        //g.fillRect(x, y, width, height);
    }
}

class Line extends Shape {
    int x2, y2;

    public Line(String name, int x1, int y1, int x2, int y2) {
        super(name, x1, y1);
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(x, y, x2, y2);
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
        this.x2 += x;
        this.y2 += y;
    }
}

//More shapes? E.g. ellipse, triangle and so on