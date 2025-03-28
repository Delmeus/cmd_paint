// Generated from /home/antek/studia/magisterka/semI/MiASI/cmd_paint/src/CmdPaintParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CmdPaintParser}.
 */
public interface CmdPaintParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CmdPaintParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CmdPaintParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmdPaintParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CmdPaintParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(CmdPaintParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(CmdPaintParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmdPaintParser#shape}.
	 * @param ctx the parse tree
	 */
	void enterShape(CmdPaintParser.ShapeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmdPaintParser#shape}.
	 * @param ctx the parse tree
	 */
	void exitShape(CmdPaintParser.ShapeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmdPaintParser#position}.
	 * @param ctx the parse tree
	 */
	void enterPosition(CmdPaintParser.PositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmdPaintParser#position}.
	 * @param ctx the parse tree
	 */
	void exitPosition(CmdPaintParser.PositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmdPaintParser#poly_pos}.
	 * @param ctx the parse tree
	 */
	void enterPoly_pos(CmdPaintParser.Poly_posContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmdPaintParser#poly_pos}.
	 * @param ctx the parse tree
	 */
	void exitPoly_pos(CmdPaintParser.Poly_posContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmdPaintParser#line_pos}.
	 * @param ctx the parse tree
	 */
	void enterLine_pos(CmdPaintParser.Line_posContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmdPaintParser#line_pos}.
	 * @param ctx the parse tree
	 */
	void exitLine_pos(CmdPaintParser.Line_posContext ctx);
}