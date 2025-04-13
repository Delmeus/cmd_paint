import java.awt.*;
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
            int x = Integer.parseInt(shapeCtx.position().INT(0).getText());
            int y = Integer.parseInt(shapeCtx.position().INT(1).getText());
            int size = Integer.parseInt(shapeCtx.INT().getFirst().getText());
            shape = new Square(name, x, y, size);
        } else if (shapeCtx.RECTANGLE() != null) {
            int x = Integer.parseInt(shapeCtx.position().INT(0).getText());
            int y = Integer.parseInt(shapeCtx.position().INT(1).getText());
            int width = Integer.parseInt(shapeCtx.INT().get(0).getText());
            int height = Integer.parseInt(shapeCtx.INT().get(1).getText());
            shape = new Rectangle(name, x, y, width, height);
        } else if (shapeCtx.CIRCLE() != null) {
            int x = Integer.parseInt(shapeCtx.position().INT(0).getText());
            int y = Integer.parseInt(shapeCtx.position().INT(1).getText());
            int radius = Integer.parseInt(shapeCtx.INT().getFirst().getText());
            shape = new Circle(name, x, y, radius);
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

        if (shapeCtx.colorDefinition().colors().COLOR() != null) {
            String color = shapeCtx.colorDefinition().colors().COLOR().getText();
            if (definedColros.containsKey(color)) {
                shape.setColor(definedColros.get(color));
            } else {
                shape.setColor(color);
            }
        } else if(shapeCtx.colorDefinition().colors().rgb_color() != null){
            shape.setColor(parseRgb(shapeCtx));
        }

        if (shapeCtx.HOLLOW() != null)
            shape.hollow();

        if (shapeCtx.layerDefinition() != null)
            shape.setLayer(Integer.parseInt(shapeCtx.layerDefinition().INT().getText()));

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
            name = parseName(name);
        else
            name = parseName(ctx.NAME().getText());
        if (name.equals(error_name))
            return false;
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
        String name = "";
        if (ctx.NAME() == null)
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
            name = parseName(name);
        else
            name = parseName(ctx.NAME().getText());
        try {
            if(ctx.HOLLOW() != null)
                shapes.get(name).hollow();
            else
                shapes.get(name).fill();
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
            rgb[i] = Math.max(0, Math.min(255, rgb[i])); // Clamp to [0, 255]
        }

        return new Color(rgb[0], rgb[1], rgb[2]);
    }

    private Color parseRgb(CmdPaintParser.ShapeContext ctx){
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
}
