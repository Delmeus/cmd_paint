import java.util.HashMap;
import java.util.Map;

public class Painter extends CmdPaintParserBaseVisitor<Boolean> {

    private final String error_name = "CHANGE THIS NAME";
    private final Map<String, Shape> shapes = new HashMap<>();
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
    public Boolean visitCommand(CmdPaintParser.CommandContext ctx) {
        if (ctx.DRAW() != null) {
            return visitDraw(ctx);
        } else if (ctx.COLORC() != null) {
            return visitColor(ctx);
        } else if (ctx.ROTATE() != null) {
            return visitRotate(ctx);
        } else if (ctx.MOVE() != null) {
            return visitMove(ctx);
        } else if (ctx.SAVE() != null) {
            return visitSave(ctx);
        } else if (ctx.DELETE() != null) {
            return visitDelete(ctx);
        } else if (ctx.RENAME() != null) {
            return visitRename(ctx);
        }
        return false;
    }

    private Boolean visitDraw(CmdPaintParser.CommandContext ctx){
        System.out.println("Visit draw");
        String name = parseName(ctx);
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
        }

        if(shape == null)
            return false;

        if (shapeCtx.COLOR() != null) {
            String color = shapeCtx.COLOR().getText();
            shape.setColor(color);
        }

        if (shapeCtx.HOLLOW() != null)
            shape.hollow();

        shapes.put(shape.name, shape);
        System.out.println("Created shape " + shape.getClass().getName() + " " + shape);
        painterFrame.repaint();
        return true;
    }
    //TODO - FIX ME: java.lang.NullPointerException: Cannot invoke "CmdPaintParser$ShapeContext.COLORC()" because the return value of "CmdPaintParser$CommandContext.shape()" is null
    private Boolean visitColor(CmdPaintParser.CommandContext ctx){
        System.out.println("Visit color");
        String name = parseName(ctx);
        if (name.equals(error_name))
            return false;
        if (!shapes.containsKey(name)){
            System.out.println("There is no shape with name: " + name);
            return false;
        }

        try {
            shapes.get(name).setColor(ctx.shape().COLORC().getText());
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        painterFrame.repaint();
        return true;
    }

    //TODO Implement
    private Boolean visitRotate(CmdPaintParser.CommandContext ctx){
        System.out.println("Visit rotate");
        String name = parseName(ctx);
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

    private Boolean visitMove(CmdPaintParser.CommandContext ctx){
        System.out.println("Visit move");
        String name = parseName(ctx);
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

    //TODO Implement, needs handling for adding extension if provided filename is invalid
    private Boolean visitSave(CmdPaintParser.CommandContext ctx){
        System.out.println("Visit save"); // placeholder for file saving
        return true;
    }

    private Boolean visitDelete(CmdPaintParser.CommandContext ctx){
        System.out.println("Visit delete");
        String name = parseName(ctx);
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

    private Boolean visitRename(CmdPaintParser.CommandContext ctx){
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

/////////////////////////////// UTILITY METHODS ///////////////////////////////////

    private String parseName(CmdPaintParser.CommandContext ctx){
        String name = "";
        try{
            name = ctx.NAME(0).getText().replace("\"", "");
        }catch (Exception e){
            System.err.println("Error in parsing name, name set to " +
                    error_name + "\n failing to provide proper name will lead do overriding this shape");
            name = error_name;
        }
        return name;
    }

    private void print_shapes(){
        for (Shape shape : shapes.values()){
            System.out.println(shape.toString());
        }
    }
}
