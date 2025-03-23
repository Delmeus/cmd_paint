// Generated from /home/antek/studia/magisterka/semI/MiASI/cmd_paint/src/CmdPaintParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CmdPaintParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CmdPaintParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CmdPaintParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CmdPaintParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(CmdPaintParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmdPaintParser#shape}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShape(CmdPaintParser.ShapeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmdPaintParser#position}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPosition(CmdPaintParser.PositionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmdPaintParser#line_pos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine_pos(CmdPaintParser.Line_posContext ctx);
}