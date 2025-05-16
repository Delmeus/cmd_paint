import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {
    private final int size = 100;
    private final int x = 10;
    private final int y = 10;
    private final String name = "square";

    Square getSquare() {
        return new Square(name, x, y, size);
    }

    @org.junit.jupiter.api.Test
    void testClone() {
        int destX = 40;
        int destY = 40;
        Square square = getSquare();
        Shape cloned = square.clone(destX, destY);

        assertInstanceOf(Square.class, cloned);
        assertEquals(destX, cloned.x);
        assertEquals(destY, cloned.y);
        assertEquals(name + "_c", cloned.name);
    }

    @org.junit.jupiter.api.Test
    void testGetScript() {
        Color color = new Color(80, 80, 80);

        Square square = getSquare();
        square.setColor(color);
        String expectedScript = "draw \"" + name + "\" square (" + x + ", " + y + ") size " + size +
                " color (" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ") stroke 1 layer 0 ";

        StringBuilder result = new StringBuilder();
        for (String s : square.getScript()) {
            result.append(s).append(" ");
        }
        assertEquals(expectedScript, result.toString());
    }

    @org.junit.jupiter.api.Test
    void testScale() {
        Square square = getSquare();
        square.scale(0.5);
        assertEquals(size / 2, square.size);

        square.scale(4);
        assertEquals(size * 2, square.size);
    }
}

class RectangleTest {
    private final int width = 100;
    private final int height = 80;
    private final String name = "rectangle";
    private final int x = 10;
    private final int y = 10;

    Rectangle getRectangle() {
        return new Rectangle(name, x, y, width, height);
    }

    @org.junit.jupiter.api.Test
    void testClone() {
        int destX = 40;
        int destY = 40;
        Rectangle rectangle = getRectangle();
        Shape cloned = rectangle.clone(destX, destY);

        assertInstanceOf(Rectangle.class, cloned);
        assertEquals(destX, cloned.x);
        assertEquals(destY, cloned.y);
        assertEquals(name + "_c", cloned.name);
    }

    @org.junit.jupiter.api.Test
    void getScript() {
        Color color = new Color(80, 80, 80);

        Rectangle rectangle = getRectangle();
        rectangle.setColor(color);
        String expectedScript = "draw \"" + name + "\" rectangle (" + x + ", " + y + ") width " + width + " height " + height +
                " color (" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ") stroke 1 layer 0 ";

        StringBuilder result = new StringBuilder();
        for (String s : rectangle.getScript()) {
            result.append(s).append(" ");
        }
        assertEquals(expectedScript, result.toString());
    }

    @org.junit.jupiter.api.Test
    void scale() {
        Rectangle rectangle = getRectangle();
        rectangle.scale(0.5);
        assertEquals(height / 2, rectangle.height);
        assertEquals(width / 2, rectangle.width);

        rectangle.scale(4);
        assertEquals(height * 2, rectangle.height);
        assertEquals(width * 2, rectangle.width);
    }
}

class CircleTest {
    private final int radius = 100;
    private final int x = 10;
    private final int y = 10;
    private final String name = "circle";

    Circle getCircle() {
        return new Circle(name, x, y, radius);
    }

    @org.junit.jupiter.api.Test
    void testClone() {
        int destX = 40;
        int destY = 40;
        Circle circle = getCircle();
        Shape cloned = circle.clone(destX, destY);

        assertInstanceOf(Circle.class, cloned);
        assertEquals(destX, cloned.x);
        assertEquals(destY, cloned.y);
        assertEquals(name + "_c", cloned.name);
    }

    @org.junit.jupiter.api.Test
    void getScript() {
        Color color = new Color(80, 80, 80);

        Circle circle = getCircle();
        circle.setColor(color);
        String expectedScript = "draw \"" + name + "\" circle (" + x + ", " + y + ") radius " + radius +
                " color (" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ") stroke 1 layer 0 ";

        StringBuilder result = new StringBuilder();
        for (String s : circle.getScript()) {
            result.append(s).append(" ");
        }
        assertEquals(expectedScript, result.toString());
    }

    @org.junit.jupiter.api.Test
    void scale() {
        Circle circle = getCircle();
        circle.scale(0.5);
        assertEquals(radius / 2, circle.radius);

        circle.scale(4);
        assertEquals(radius * 2, circle.radius);
    }
}

class LineTest {
    private final int length = 100;
    private final int x1 = 10;
    private final int y1 = 10;
    private final int x2 = 110;
    private final int y2 = 10;
    private final String name = "line";

    Line getLineByCords() {
        return new Line(name, x1, y1, x2, y2);
    }

    Line getLineByLength() {
        return new Line(name, x1, y1, length);
    }

    @org.junit.jupiter.api.Test
    void testClone() {
        int destX = 40;
        int destY = 40;
        Line line = getLineByCords();
        Shape cloned = line.clone(destX, destY);

        assertInstanceOf(Line.class, cloned);
        assertEquals(destX, cloned.x);
        assertEquals(destY, cloned.y);
        assertEquals(name + "_c", cloned.name);
    }
}
