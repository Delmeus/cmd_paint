// Generated from G:/Projekty_Studia/MiASI/cmdPaint/src/CmdPaintParser.g4 by ANTLR 4.13.2
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
	 * Visit a parse tree produced by the {@code drawOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrawOp(CmdPaintParser.DrawOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code colorOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColorOp(CmdPaintParser.ColorOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rotateOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRotateOp(CmdPaintParser.RotateOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code moveOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoveOp(CmdPaintParser.MoveOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code saveOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSaveOp(CmdPaintParser.SaveOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code deleteOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteOp(CmdPaintParser.DeleteOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code backgroundOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBackgroundOp(CmdPaintParser.BackgroundOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code renameOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameOp(CmdPaintParser.RenameOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showNamesOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowNamesOp(CmdPaintParser.ShowNamesOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hollowOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHollowOp(CmdPaintParser.HollowOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defineOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineOp(CmdPaintParser.DefineOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code layerOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLayerOp(CmdPaintParser.LayerOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cloneOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCloneOp(CmdPaintParser.CloneOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code serializeOp}
	 * labeled alternative in {@link CmdPaintParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSerializeOp(CmdPaintParser.SerializeOpContext ctx);
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
	 * Visit a parse tree produced by {@link CmdPaintParser#poly_pos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPoly_pos(CmdPaintParser.Poly_posContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmdPaintParser#line_pos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine_pos(CmdPaintParser.Line_posContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmdPaintParser#rgb_color}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRgb_color(CmdPaintParser.Rgb_colorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmdPaintParser#colors}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColors(CmdPaintParser.ColorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmdPaintParser#colorDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColorDefinition(CmdPaintParser.ColorDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmdPaintParser#layerDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLayerDefinition(CmdPaintParser.LayerDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmdPaintParser#strokeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrokeDefinition(CmdPaintParser.StrokeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmdPaintParser#shapeAttributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShapeAttributes(CmdPaintParser.ShapeAttributesContext ctx);
}