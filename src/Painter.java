public class Painter extends CmdPaintParserBaseVisitor<Boolean> {
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
        }
        return false;
    }

    private Boolean visitDraw(CmdPaintParser.CommandContext ctx){
        System.out.println("Visit draw");
        return true;
    }

    private Boolean visitColor(CmdPaintParser.CommandContext ctx){
        System.out.println("Visit color");
        return true;
    }

    private Boolean visitRotate(CmdPaintParser.CommandContext ctx){
        System.out.println("Visit rotate");
        return true;
    }

    private Boolean visitMove(CmdPaintParser.CommandContext ctx){
        System.out.println("Visit move");
        return true;
    }
}
