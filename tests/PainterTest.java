import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PainterTest {
    PainterFrame frameMock = mock(PainterFrame.class);
    Painter painter = new Painter(getShapes(), frameMock);
    Map<String, Shape> shapes;

    Map<String, Shape> getShapes(){
        shapes = new HashMap<>();
        shapes.put("square", new Square("square", 100, 100, 100));
        shapes.put("circle", new Circle("circle", 200, 200, 100));
        shapes.put("rectangle", new Rectangle("rectangle", 300, 300, 100, 80));
        return shapes;
    }

    void setZeroSelectedShapes(){
        when(frameMock.getSelectedShapes()).thenReturn(new HashSet<>());
    }

    void setOneSelectedShape(){
        Set<Shape> selectedShapes = new HashSet<>();
        selectedShapes.add(shapes.get("square"));
        when(frameMock.getSelectedShapes()).thenReturn(selectedShapes);
    }

    void setTwoSelectedShapes(){
        Set<Shape> selectedShapes = new HashSet<>();
        selectedShapes.add(shapes.get("circle"));
        selectedShapes.add(shapes.get("rectangle"));
        when(frameMock.getSelectedShapes()).thenReturn(selectedShapes);
    }

//    @Test
//    void visitRotateOp() {
//    }
//
//    @Test
//    void visitMoveOp() {
//    }
//
//    @Test
//    void visitSaveOp() {
//    }
}


class ColorOpTest extends PainterTest{
    CmdPaintParser.ColorOpContext ctxMock = mock(CmdPaintParser.ColorOpContext.class);

    void ctxHasNoNames(){
        when(ctxMock.NAME().isEmpty()).thenReturn(true);
    }

    void ctxHasName(){
        when(ctxMock.NAME().isEmpty()).thenReturn(false);
        when(ctxMock.NAME().get(anyInt()).getText()).thenReturn("square");
    }

    void ctxHasManyNames(){
        when(ctxMock.NAME().isEmpty()).thenReturn(false);
        when(ctxMock.NAME().get(0).getText()).thenReturn("square");
        when(ctxMock.NAME().get(1).getText()).thenReturn("circle");
    }

    void ctxHasStringColor(){
        when(ctxMock.colors().COLOR()).thenReturn(any());
        when(ctxMock.colors().COLOR().getText()).thenReturn(getDefinedColor());
    }

    void ctxHasRgbColor(){
        when(ctxMock.colors().COLOR()).thenReturn(any());
        when(ctxMock.colors().COLOR().getText()).thenReturn(getRGBColor());
    }

    String getDefinedColor(){
        return "red";
    }

    String getRGBColor(){
        return "(80, 80, 80)";
    }

    Color getDefinedColorValue(){
        return Color.RED;
    }

    Color getRGBColorValue(){
        return new Color(80, 80, 80);
    }

    @Test
    void testVisitColorOp() {
        setZeroSelectedShapes();
        ctxHasName();
        ctxHasRgbColor();
        painter.visitColorOp(ctxMock);
        assertEquals(shapes.get("square").color, getRGBColorValue());
    }
}