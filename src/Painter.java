import java.util.HashMap;
import java.util.Map;

public class Painter extends CmdPaintParserBaseVisitor<Boolean> {
    private final Map<String, Shape> shapes = new HashMap<>(); // after command redraw shapes (I guess)

    @Override
    public Boolean visitProgram(CmdPaintParser.ProgramContext ctx) {
        boolean result = true;
        for (CmdPaintParser.CommandContext command : ctx.command()) {
            result &= visit(command);
        }
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
        }
        return false;
    }

    private Boolean visitDraw(CmdPaintParser.CommandContext ctx){
        System.out.println("Visit draw");
        String name = ctx.NAME().getText().replace("\"", "");
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
            int x = Integer.parseInt(shapeCtx.position().INT(0).getText());
            int y = Integer.parseInt(shapeCtx.position().INT(1).getText());
            shape = new Line(name, x, y);
        }

        if(shape == null)
            return false;

        if (shapeCtx.COLOR() != null) {
            String color = shapeCtx.COLOR().getText();
            shape.setColor(color);
        }

        shapes.put(shape.name, shape);
        System.out.println("Created shape " + shape.getClass().getName() + " " + shape);
        return true;
    }

    private Boolean visitColor(CmdPaintParser.CommandContext ctx){
        System.out.println("Visit color");
        String name = ctx.NAME().getText().replace("\"", "");
        if (!shapes.containsKey(name)){
            System.out.println("There is no shape with name: " + name);
            return false;
        }

        try {
            shapes.get(name).setColor(ctx.shape().COLOR().getText());
        }catch (Exception e){
            System.out.println(e);
            return false;
        }

        return true;
    }

    //TODO Implement
    private Boolean visitRotate(CmdPaintParser.CommandContext ctx){
        System.out.println("Visit rotate"); // placeholder for rotating shapes
        return true;
    }

    //TODO Implement
    private Boolean visitMove(CmdPaintParser.CommandContext ctx){
        System.out.println("Visit move"); // placeholder for moving shapes
        return true;
    }

    //TODO Implement, needs handling for adding extension if provided filename is invalid
    private Boolean visitSave(CmdPaintParser.CommandContext ctx){
        System.out.println("Visit save"); // placeholder for file saving
        return true;
    }
}
