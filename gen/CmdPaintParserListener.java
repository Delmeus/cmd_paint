// Generated from G:/Projekty_Studia/MiASI/cmdPaint/src/CmdPaintParser.g4 by ANTLR 4.13.2
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
}