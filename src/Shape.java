abstract class Shape {
    String name;
    int x, y;
    String color = "black";

    public Shape(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    //Would be nice to define more colors in antlr
    public void setColor(String color) {
        this.color = color;
    }

    public void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    //TODO implement somehow
    public void rotate(int angle) {
        System.out.println(name + " rotated by " + angle + " degrees");
    }

    @Override
    public String toString() {
        return name + " at (" + x + ", " + y + ") color: " + color;
    }
}

class Square extends Shape {
    int size;

    public Square(String name, int x, int y, int size) {
        super(name, x, y);
        this.size = size;
    }
}

class Circle extends Shape {
    int radius;

    public Circle(String name, int x, int y, int radius) {
        super(name, x, y);
        this.radius = radius;
    }
}

class Rectangle extends Shape {
    int width, height;

    public Rectangle(String name, int x, int y, int width, int height) {
        super(name, x, y);
        this.width = width;
        this.height = height;
    }
}

class Line extends Shape {
    public Line(String name, int x, int y){
        super(name, x, y);
    }
}

//More shapes? E.g. ellipse, triangle and so on