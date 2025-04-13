import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Painter extends CmdPaintParserBaseVisitor<Boolean> {

    private final String error_name = "CHANGE THIS NAME";
    private final Map<String, Shape> shapes = new HashMap<>();
    private final Map<String, Color> definedColros = new HashMap<>();
    private final PainterFrame painterFrame = new PainterFrame(shapes);

    @Override
    public Boolean visitProgram(CmdPaintParser.ProgramContext ctx) {
        boolean result = true;
        for (CmdPaintParser.CommandContext command : ctx.command()) {
            result &= visit(command);
        }
        painterFrame.repaint();
        return result;
    }
    @Override
    public Boolean visitDrawOp(CmdPaintParser.DrawOpContext ctx) {
        System.out.println("Visit draw");
        String name = "";
        if (ctx.NAME() == null)
            name = parseName(name);
        else
            name = parseName(ctx.NAME().getText());
        Shape shape = null;

        CmdPaintParser.ShapeContext shapeCtx = ctx.shape();
        if (shapeCtx.SQUARE() != null) {
            int[] pos = getPosition(shapeCtx);
            int size = Integer.parseInt(shapeCtx.INT().getFirst().getText());
            shape = new Square(name, pos[0], pos[1], size);
        } else if (shapeCtx.RECTANGLE() != null) {
            int[] pos = getPosition(shapeCtx);
            int width = Integer.parseInt(shapeCtx.INT().get(0).getText());
            int height = Integer.parseInt(shapeCtx.INT().get(1).getText());
            shape = new Rectangle(name, pos[0], pos[1], width, height);
        } else if (shapeCtx.CIRCLE() != null) {
            int[] pos = getPosition(shapeCtx);
            int radius = Integer.parseInt(shapeCtx.INT().getFirst().getText());
            shape = new Circle(name, pos[0], pos[1], radius);
        } else if (shapeCtx.LINE() != null) {
            int x = Integer.parseInt(shapeCtx.line_pos().INT(0).getText());
            int y = Integer.parseInt(shapeCtx.line_pos().INT(1).getText());
            int x2 = Integer.parseInt(shapeCtx.line_pos().INT(2).getText());
            int y2 = Integer.parseInt(shapeCtx.line_pos().INT(3).getText());
            shape = new Line(name, x, y, x2, y2);
        } else if (shapeCtx.POLYGON() != null) {
            if (shapeCtx.poly_pos(0).getChildCount() == shapeCtx.poly_pos(1).getChildCount()) {
                int size = shapeCtx.poly_pos(0).INT().size();
                int[] x = new int[size];
                int[] y = new int[size];
                for (int i = 0; i < size; i++) {
                    x[i] = Integer.parseInt(shapeCtx.poly_pos(0).INT(i).getText());
                    y[i] = Integer.parseInt(shapeCtx.poly_pos(1).INT(i).getText());
                }
                shape = new Polygon(name, x, y);
            } else {
                System.out.println("X.size = " + shapeCtx.poly_pos(0).INT().size() + " != Y.size = " + shapeCtx.poly_pos(1).INT().size());
            }
        }

        if(shape == null)
            return false;

        for (CmdPaintParser.ShapeAttributesContext attrCtx : shapeCtx.shapeAttributes()) {
            if (attrCtx.colorDefinition() != null) {
                var colorCtx = attrCtx.colorDefinition().colors();
                if (colorCtx.COLOR() != null) {
                    String color = colorCtx.COLOR().getText();
                    if (definedColros.containsKey(color)) {
                        shape.setColor(definedColros.get(color));
                    } else {
                        shape.setColor(color);
                    }
                } else if (colorCtx.rgb_color() != null) {
                    shape.setColor(parseRgb(attrCtx));
                }
            } else if (attrCtx.HOLLOW() != null) {
                shape.hollow();
            } else if (attrCtx.layerDefinition() != null) {
                shape.setLayer(Integer.parseInt(attrCtx.layerDefinition().INT().getText()));
            } else if (attrCtx.strokeDefinition() != null) {
                shape.setThickness(Integer.parseInt(attrCtx.strokeDefinition().INT().getText()));
            }
        }

        shapes.put(shape.name, shape);
        System.out.println("Created shape " + shape.getClass().getName() + " " + shape);
        painterFrame.repaint();
        return true;
    }

    @Override
    public Boolean visitColorOp(CmdPaintParser.ColorOpContext ctx) {
        System.out.println("Visit color");
        String name = "";
        if (ctx.NAME() == null)
            if(painterFrame.hasShapeSelected())
                name = painterFrame.getSelectedShape().name;
            else
                name = parseName(name);
        else
            name = parseName(ctx.NAME().getText());
        if (!shapes.containsKey(name)){
            System.out.println("There is no shape with name: " + name);
            return false;
        }

        try {
            if(ctx.colors().COLOR() != null)
                if(definedColros.containsKey(ctx.colors().COLOR().getText())) {
                    shapes.get(name).setColor(definedColros.get(ctx.colors().COLOR().getText()));
                    System.out.println(ctx.colors().COLOR().getText() + " to " + definedColros.get(ctx.colors().COLOR().getText()).toString());
                }
                else
                    shapes.get(name).setColor(ctx.colors().COLOR().getText());
            else if(ctx.colors().rgb_color() != null)
                shapes.get(name).setColor(parseRgb(ctx.colors()));
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        painterFrame.repaint();
        return true;
    }

    @Override
    public Boolean visitRotateOp(CmdPaintParser.RotateOpContext ctx) {
        System.out.println("Visit rotate");
        String name = "";
        if (ctx.NAME() == null)
            if(painterFrame.hasShapeSelected())
                name = painterFrame.getSelectedShape().name;
            else
                name = parseName(name);
        else
            name = parseName(ctx.NAME().getText());
        if (!shapes.containsKey(name)){
            System.out.println("There is no shape with name: " + name);
            return false;
        }

        int rotationAngle;
        try {
            rotationAngle = Integer.parseInt(ctx.INT().getText());
        }catch (Exception e){
            System.err.println("Invalid angle: " + ctx.INT().getText());
            rotationAngle = 0;
        }

        shapes.get(name).rotate(rotationAngle);
        return true;
    }

    @Override
    public Boolean visitMoveOp(CmdPaintParser.MoveOpContext ctx) {
        System.out.println("Visit move");
        String name = "";
        if (ctx.NAME() == null)
            if(painterFrame.hasShapeSelected())
                name = painterFrame.getSelectedShape().name;
            else
                name = parseName(name);
        else
            name = parseName(ctx.NAME().getText());
        if (!shapes.containsKey(name)){
            System.out.println("There is no shape with name: " + name);
            return false;
        }

        try {
            shapes.get(name).move(Integer.parseInt(ctx.position().INT(0).getText()), Integer.parseInt(ctx.position().INT(1).getText()));
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        painterFrame.repaint();
        return true;
    }

    @Override
    public Boolean visitSaveOp(CmdPaintParser.SaveOpContext ctx) {
        return painterFrame.saveAsImage();
    }

    @Override
    public Boolean visitDeleteOp(CmdPaintParser.DeleteOpContext ctx) {
        System.out.println("Visit delete");
        if (ctx.ALL() != null){
            shapes.clear();
            return true;
        }
        String name = "";
        if (ctx.NAME() == null)
            if(painterFrame.hasShapeSelected())
                name = painterFrame.getSelectedShape().name;
            else
                name = parseName(name);
        else
            name = parseName(ctx.NAME().getText());
        if (name.equals(error_name))
            return false;
        if (!shapes.containsKey(name)){
            System.out.println("There is no shape with name: " + name);
            return false;
        }
        shapes.remove(name);
        painterFrame.repaint();
        return true;
    }

    @Override
    public Boolean visitBackgroundOp(CmdPaintParser.BackgroundOpContext ctx) {
        if(ctx.colorDefinition().colors().COLOR() != null)
            if(definedColros.containsKey(ctx.colorDefinition().colors().COLOR().getText()))
                painterFrame.setBackgroundColor(definedColros.get(ctx.colorDefinition().colors().COLOR().getText()));
            else
                painterFrame.setBackgroundColor(ctx.colorDefinition().colors().COLOR().getText());
        else if(ctx.colorDefinition().colors().rgb_color() != null)
            painterFrame.setBackgroundColor(parseRgb(ctx.colorDefinition().colors()));
        return true;
    }

    @Override
    public Boolean visitRenameOp(CmdPaintParser.RenameOpContext ctx) {
        System.out.println("Visit rename");
        String oldName = ctx.NAME(0).getText().replace("\"", "");
        if (!shapes.containsKey(oldName)){
            System.out.println("There is no shape with name: " + oldName);
            return false;
        }
        String newName = ctx.NAME(1).getText().replace("\"", "");

        shapes.put(newName, shapes.remove(oldName));
        return true;
    }

    @Override
    public Boolean visitShowNamesOp(CmdPaintParser.ShowNamesOpContext ctx) {
        printShapes();
        for(Shape s : shapes.values()){
            s.toggleName();
        }
        return true;
    }

    @Override
    public Boolean visitHollowOp(CmdPaintParser.HollowOpContext ctx) {
        String name = "";
        if (ctx.NAME() == null)
            if(painterFrame.hasShapeSelected())
                name = painterFrame.getSelectedShape().name;
            else
                name = parseName(name);
        else
            name = parseName(ctx.NAME().getText());
        try {
            if(ctx.HOLLOW() != null)
                shapes.get(name).hollow();
            else if (ctx.FILL() != null)
                shapes.get(name).fill();
            else if (ctx.STROKE() != null)
                shapes.get(name).setThickness(Integer.parseInt(ctx.INT().getText()));
        }catch (Exception e){
            System.err.println(e);
            return false;
        }
        return true;
    }

    @Override
    public Boolean visitDefineOp(CmdPaintParser.DefineOpContext ctx) {
        String name = "";
        if (ctx.NAME() == null)
            return false;
        else
            name = parseName(ctx.NAME().getText());
        Color color = parseRgb(ctx.colors());
        definedColros.put(name, color);
        return true;
    }

    @Override
    public Boolean visitLayerOp(CmdPaintParser.LayerOpContext ctx) {
        String name = "";
        if (ctx.NAME() == null)
            if(painterFrame.hasShapeSelected())
                name = painterFrame.getSelectedShape().name;
            else
                name = parseName(name);
        else
            name = parseName(ctx.NAME().getText());

        if (!shapes.containsKey(name))
            return false;

        if(ctx.INT() != null)
            shapes.get(name).setLayer(Math.max(0, Integer.parseInt(ctx.INT().getText())));
        else if (ctx.DOWN() != null)
            shapes.get(name).moveDown();
        else if (ctx.UP() != null)
            shapes.get(name).moveUp();
        else
            return false;
        return true;
    }

    @Override
    public Boolean visitSerializeOp(CmdPaintParser.SerializeOpContext ctx) {
        if(ctx.SERIALIZE() != null){
            Map<String, Shape> toBeSerialized = new HashMap<>();
            if (ctx.NAME().isEmpty()){
                Shape shape = painterFrame.getSelectedShape();
                if(shape == null)
                    return false;
                toBeSerialized.put(shape.name, shape);
            } else {
                for (int i = 0; i < ctx.NAME().size(); i++) {
                    String name = parseName(ctx.NAME(i).getText());
                    if (shapes.containsKey(name))
                        toBeSerialized.put(name, shapes.get(name));
                }
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serialized/file.ser"))) {
                oos.writeObject(toBeSerialized);
                System.out.println("Shapes saved");
                return true;
            } catch (IOException e) {
                System.err.println("Error saving shapes: " + e.getMessage());
                return false;
            }
        } else if (ctx.LOAD() != null) {
            String path = "serialized/" + parseName(ctx.NAME().getFirst().getText()) + ".ser";
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
                Map<String, Shape> loadedShapes = (Map<String, Shape>) ois.readObject();
                shapes.putAll(loadedShapes);
                painterFrame.repaint();
                System.out.println("Shapes loaded from " + path);
                return true;
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error loading shapes: " + e.getMessage());
                return false;
            }
        }
        return true;
    }

//--------------------------------------------------
//               UTILITY METHODS
//--------------------------------------------------
    private String parseName(String passedName){
        if (passedName.isEmpty()){
            System.err.println("Name not provided, name set to " +
                    error_name + "\n failing to provide proper name will lead do overriding this shape");
            return error_name;
        }
        String name = "";
        try{
            name = passedName.replace("\"", "");
        }catch (Exception e){
            System.err.println("Error in parsing name, name set to " +
                    error_name + "\n failing to provide proper name will lead do overriding this shape");
            name = error_name;
        }
        return name;
    }

    private void printShapes(){
        for (Shape shape : shapes.values()){
            System.out.println(shape.toString());
        }
    }

    private Color parseRgb(CmdPaintParser.ColorsContext ctx){
        int[] rgb = new int[3];

        for (int i = 0; i < 3; i++) {
            rgb[i] = Integer.parseInt(ctx.rgb_color().INT(i).getText());
            rgb[i] = Math.max(0, Math.min(255, rgb[i]));
        }

        return new Color(rgb[0], rgb[1], rgb[2]);
    }

    private Color parseRgb(CmdPaintParser.ShapeAttributesContext ctx){
        int[] rgb = new int[3];
        for(int i = 0; i < 3; i++){
            rgb[i] = Integer.parseInt(ctx.colorDefinition().colors().rgb_color().INT(i).getText());
            if(rgb[i] < 0)
                rgb[i] = 0;
            else if (rgb[i] > 255)
                rgb[i] = 255;
        }
        return new Color(rgb[0], rgb[1], rgb[2]);
    }

    private int[] getPosition(CmdPaintParser.ShapeContext shapeCtx){
        int x, y;
        if (shapeCtx.position() == null){
            x = painterFrame.getSelectedX();
            y = painterFrame.getSelectedY();
        }
        else {
            x = Integer.parseInt(shapeCtx.position().INT(0).getText());
            y = Integer.parseInt(shapeCtx.position().INT(1).getText());
        }
        int[] pos = new int[2];
        pos[0] = x;
        pos[1] = y;
        return pos;
    }
}
