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
	 * Enter a parse tree produced by the {@code drawOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void enterDrawOp(CmdPaintParser.DrawOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code drawOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void exitDrawOp(CmdPaintParser.DrawOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code colorOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void enterColorOp(CmdPaintParser.ColorOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code colorOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void exitColorOp(CmdPaintParser.ColorOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rotateOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void enterRotateOp(CmdPaintParser.RotateOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rotateOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void exitRotateOp(CmdPaintParser.RotateOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code moveOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void enterMoveOp(CmdPaintParser.MoveOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code moveOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void exitMoveOp(CmdPaintParser.MoveOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code saveOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void enterSaveOp(CmdPaintParser.SaveOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code saveOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void exitSaveOp(CmdPaintParser.SaveOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code deleteOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void enterDeleteOp(CmdPaintParser.DeleteOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code deleteOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void exitDeleteOp(CmdPaintParser.DeleteOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code backgroundOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void enterBackgroundOp(CmdPaintParser.BackgroundOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code backgroundOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void exitBackgroundOp(CmdPaintParser.BackgroundOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code renameOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void enterRenameOp(CmdPaintParser.RenameOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code renameOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void exitRenameOp(CmdPaintParser.RenameOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showNamesOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void enterShowNamesOp(CmdPaintParser.ShowNamesOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showNamesOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void exitShowNamesOp(CmdPaintParser.ShowNamesOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code hollowOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void enterHollowOp(CmdPaintParser.HollowOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code hollowOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void exitHollowOp(CmdPaintParser.HollowOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code defineOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void enterDefineOp(CmdPaintParser.DefineOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code defineOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void exitDefineOp(CmdPaintParser.DefineOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code layerOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void enterLayerOp(CmdPaintParser.LayerOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code layerOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void exitLayerOp(CmdPaintParser.LayerOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code serializeOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void enterSerializeOp(CmdPaintParser.SerializeOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code serializeOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 */
	void exitSerializeOp(CmdPaintParser.SerializeOpContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link CmdPaintParser#rgb_color}.
	 * @param ctx the parse tree
	 */
	void enterRgb_color(CmdPaintParser.Rgb_colorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmdPaintParser#rgb_color}.
	 * @param ctx the parse tree
	 */
	void exitRgb_color(CmdPaintParser.Rgb_colorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmdPaintParser#colors}.
	 * @param ctx the parse tree
	 */
	void enterColors(CmdPaintParser.ColorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmdPaintParser#colors}.
	 * @param ctx the parse tree
	 */
	void exitColors(CmdPaintParser.ColorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmdPaintParser#colorDefinition}.
	 * @param ctx the parse tree
	 */
	void enterColorDefinition(CmdPaintParser.ColorDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmdPaintParser#colorDefinition}.
	 * @param ctx the parse tree
	 */
	void exitColorDefinition(CmdPaintParser.ColorDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmdPaintParser#layerDefinition}.
	 * @param ctx the parse tree
	 */
	void enterLayerDefinition(CmdPaintParser.LayerDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmdPaintParser#layerDefinition}.
	 * @param ctx the parse tree
	 */
	void exitLayerDefinition(CmdPaintParser.LayerDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmdPaintParser#strokeDefinition}.
	 * @param ctx the parse tree
	 */
	void enterStrokeDefinition(CmdPaintParser.StrokeDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmdPaintParser#strokeDefinition}.
	 * @param ctx the parse tree
	 */
	void exitStrokeDefinition(CmdPaintParser.StrokeDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmdPaintParser#shapeAttributes}.
	 * @param ctx the parse tree
	 */
	void enterShapeAttributes(CmdPaintParser.ShapeAttributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmdPaintParser#shapeAttributes}.
	 * @param ctx the parse tree
	 */
	void exitShapeAttributes(CmdPaintParser.ShapeAttributesContext ctx);
}