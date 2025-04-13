// Generated from G:/Projekty_Studia/MiASI/cmdPaint/src/CmdPaintParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CmdPaintParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NAME=1, INT=2, WS=3, DRAW=4, DEFINE=5, COLORC=6, ROTATE=7, MOVE=8, DELETE=9, 
		BACKGROUND=10, SHOW_NAMES=11, RENAME=12, LAYER=13, FILL=14, SQUARE=15, 
		CIRCLE=16, RECTANGLE=17, POLYGON=18, LINE=19, SIZE=20, RADIUS=21, WIDTH=22, 
		HEIGHT=23, HOLLOW=24, SAVE=25, DOWN=26, UP=27, LPAREN=28, RPAREN=29, COMMA=30, 
		COLOR=31;
	public static final int
		RULE_program = 0, RULE_command = 1, RULE_shape = 2, RULE_position = 3, 
		RULE_poly_pos = 4, RULE_line_pos = 5, RULE_rgb_color = 6, RULE_colors = 7, 
		RULE_colorDefinition = 8, RULE_layerDefinition = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "command", "shape", "position", "poly_pos", "line_pos", "rgb_color", 
			"colors", "colorDefinition", "layerDefinition"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'color'", null, null, null, null, 
			"'names'", null, null, "'fill'", null, null, null, null, "'line'", null, 
			null, null, null, "'hollow'", "'save'", "'down'", "'up'", "'('", "')'", 
			"','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NAME", "INT", "WS", "DRAW", "DEFINE", "COLORC", "ROTATE", "MOVE", 
			"DELETE", "BACKGROUND", "SHOW_NAMES", "RENAME", "LAYER", "FILL", "SQUARE", 
			"CIRCLE", "RECTANGLE", "POLYGON", "LINE", "SIZE", "RADIUS", "WIDTH", 
			"HEIGHT", "HOLLOW", "SAVE", "DOWN", "UP", "LPAREN", "RPAREN", "COMMA", 
			"COLOR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CmdPaintParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CmdPaintParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CmdPaintParser.EOF, 0); }
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(20);
				command();
				}
				}
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 50364400L) != 0) );
			setState(25);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CommandContext extends ParserRuleContext {
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
	 
		public CommandContext() { }
		public void copyFrom(CommandContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MoveOpContext extends CommandContext {
		public TerminalNode MOVE() { return getToken(CmdPaintParser.MOVE, 0); }
		public TerminalNode NAME() { return getToken(CmdPaintParser.NAME, 0); }
		public PositionContext position() {
			return getRuleContext(PositionContext.class,0);
		}
		public MoveOpContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterMoveOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitMoveOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitMoveOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RotateOpContext extends CommandContext {
		public TerminalNode ROTATE() { return getToken(CmdPaintParser.ROTATE, 0); }
		public TerminalNode NAME() { return getToken(CmdPaintParser.NAME, 0); }
		public TerminalNode INT() { return getToken(CmdPaintParser.INT, 0); }
		public RotateOpContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterRotateOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitRotateOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitRotateOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SaveOpContext extends CommandContext {
		public TerminalNode SAVE() { return getToken(CmdPaintParser.SAVE, 0); }
		public SaveOpContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterSaveOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitSaveOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitSaveOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RenameOpContext extends CommandContext {
		public TerminalNode RENAME() { return getToken(CmdPaintParser.RENAME, 0); }
		public List<TerminalNode> NAME() { return getTokens(CmdPaintParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(CmdPaintParser.NAME, i);
		}
		public RenameOpContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterRenameOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitRenameOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitRenameOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeleteOpContext extends CommandContext {
		public TerminalNode DELETE() { return getToken(CmdPaintParser.DELETE, 0); }
		public TerminalNode NAME() { return getToken(CmdPaintParser.NAME, 0); }
		public DeleteOpContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterDeleteOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitDeleteOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitDeleteOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BackgroundOpContext extends CommandContext {
		public TerminalNode BACKGROUND() { return getToken(CmdPaintParser.BACKGROUND, 0); }
		public ColorDefinitionContext colorDefinition() {
			return getRuleContext(ColorDefinitionContext.class,0);
		}
		public BackgroundOpContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterBackgroundOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitBackgroundOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitBackgroundOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DefineOpContext extends CommandContext {
		public TerminalNode DEFINE() { return getToken(CmdPaintParser.DEFINE, 0); }
		public TerminalNode NAME() { return getToken(CmdPaintParser.NAME, 0); }
		public ColorsContext colors() {
			return getRuleContext(ColorsContext.class,0);
		}
		public DefineOpContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterDefineOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitDefineOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitDefineOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ShowNamesOpContext extends CommandContext {
		public TerminalNode SHOW_NAMES() { return getToken(CmdPaintParser.SHOW_NAMES, 0); }
		public ShowNamesOpContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterShowNamesOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitShowNamesOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitShowNamesOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ColorOpContext extends CommandContext {
		public TerminalNode COLORC() { return getToken(CmdPaintParser.COLORC, 0); }
		public TerminalNode NAME() { return getToken(CmdPaintParser.NAME, 0); }
		public ColorsContext colors() {
			return getRuleContext(ColorsContext.class,0);
		}
		public ColorOpContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterColorOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitColorOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitColorOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DrawOpContext extends CommandContext {
		public TerminalNode DRAW() { return getToken(CmdPaintParser.DRAW, 0); }
		public TerminalNode NAME() { return getToken(CmdPaintParser.NAME, 0); }
		public ShapeContext shape() {
			return getRuleContext(ShapeContext.class,0);
		}
		public DrawOpContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterDrawOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitDrawOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitDrawOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LayerOpContext extends CommandContext {
		public TerminalNode LAYER() { return getToken(CmdPaintParser.LAYER, 0); }
		public TerminalNode NAME() { return getToken(CmdPaintParser.NAME, 0); }
		public TerminalNode INT() { return getToken(CmdPaintParser.INT, 0); }
		public TerminalNode MOVE() { return getToken(CmdPaintParser.MOVE, 0); }
		public TerminalNode DOWN() { return getToken(CmdPaintParser.DOWN, 0); }
		public TerminalNode UP() { return getToken(CmdPaintParser.UP, 0); }
		public LayerOpContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterLayerOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitLayerOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitLayerOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HollowOpContext extends CommandContext {
		public TerminalNode HOLLOW() { return getToken(CmdPaintParser.HOLLOW, 0); }
		public TerminalNode NAME() { return getToken(CmdPaintParser.NAME, 0); }
		public TerminalNode FILL() { return getToken(CmdPaintParser.FILL, 0); }
		public HollowOpContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterHollowOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitHollowOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitHollowOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_command);
		int _la;
		try {
			setState(61);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new DrawOpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				match(DRAW);
				setState(28);
				match(NAME);
				setState(29);
				shape();
				}
				break;
			case 2:
				_localctx = new ColorOpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
				match(COLORC);
				setState(31);
				match(NAME);
				setState(32);
				colors();
				}
				break;
			case 3:
				_localctx = new RotateOpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(33);
				match(ROTATE);
				setState(34);
				match(NAME);
				setState(35);
				match(INT);
				}
				break;
			case 4:
				_localctx = new MoveOpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(36);
				match(MOVE);
				setState(37);
				match(NAME);
				setState(38);
				position();
				}
				break;
			case 5:
				_localctx = new SaveOpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(39);
				match(SAVE);
				}
				break;
			case 6:
				_localctx = new DeleteOpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(40);
				match(DELETE);
				setState(41);
				match(NAME);
				}
				break;
			case 7:
				_localctx = new BackgroundOpContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(42);
				match(BACKGROUND);
				setState(43);
				colorDefinition();
				}
				break;
			case 8:
				_localctx = new RenameOpContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(44);
				match(RENAME);
				setState(45);
				match(NAME);
				setState(46);
				match(NAME);
				}
				break;
			case 9:
				_localctx = new ShowNamesOpContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(47);
				match(SHOW_NAMES);
				}
				break;
			case 10:
				_localctx = new HollowOpContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(48);
				match(HOLLOW);
				setState(49);
				match(NAME);
				}
				break;
			case 11:
				_localctx = new HollowOpContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(50);
				match(FILL);
				setState(51);
				match(NAME);
				}
				break;
			case 12:
				_localctx = new DefineOpContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(52);
				match(DEFINE);
				setState(53);
				match(NAME);
				setState(54);
				colors();
				}
				break;
			case 13:
				_localctx = new LayerOpContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(55);
				match(LAYER);
				setState(56);
				match(NAME);
				setState(57);
				match(INT);
				}
				break;
			case 14:
				_localctx = new LayerOpContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(58);
				match(MOVE);
				setState(59);
				match(NAME);
				setState(60);
				_la = _input.LA(1);
				if ( !(_la==DOWN || _la==UP) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ShapeContext extends ParserRuleContext {
		public TerminalNode SQUARE() { return getToken(CmdPaintParser.SQUARE, 0); }
		public PositionContext position() {
			return getRuleContext(PositionContext.class,0);
		}
		public TerminalNode SIZE() { return getToken(CmdPaintParser.SIZE, 0); }
		public List<TerminalNode> INT() { return getTokens(CmdPaintParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(CmdPaintParser.INT, i);
		}
		public ColorDefinitionContext colorDefinition() {
			return getRuleContext(ColorDefinitionContext.class,0);
		}
		public TerminalNode HOLLOW() { return getToken(CmdPaintParser.HOLLOW, 0); }
		public LayerDefinitionContext layerDefinition() {
			return getRuleContext(LayerDefinitionContext.class,0);
		}
		public TerminalNode CIRCLE() { return getToken(CmdPaintParser.CIRCLE, 0); }
		public TerminalNode RADIUS() { return getToken(CmdPaintParser.RADIUS, 0); }
		public TerminalNode RECTANGLE() { return getToken(CmdPaintParser.RECTANGLE, 0); }
		public TerminalNode WIDTH() { return getToken(CmdPaintParser.WIDTH, 0); }
		public TerminalNode HEIGHT() { return getToken(CmdPaintParser.HEIGHT, 0); }
		public TerminalNode LINE() { return getToken(CmdPaintParser.LINE, 0); }
		public Line_posContext line_pos() {
			return getRuleContext(Line_posContext.class,0);
		}
		public TerminalNode POLYGON() { return getToken(CmdPaintParser.POLYGON, 0); }
		public List<Poly_posContext> poly_pos() {
			return getRuleContexts(Poly_posContext.class);
		}
		public Poly_posContext poly_pos(int i) {
			return getRuleContext(Poly_posContext.class,i);
		}
		public ShapeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shape; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterShape(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitShape(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitShape(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShapeContext shape() throws RecognitionException {
		ShapeContext _localctx = new ShapeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_shape);
		try {
			setState(127);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SQUARE:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				match(SQUARE);
				setState(64);
				position();
				setState(65);
				match(SIZE);
				setState(66);
				match(INT);
				setState(68);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(67);
					colorDefinition();
					}
					break;
				}
				setState(71);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(70);
					match(HOLLOW);
					}
					break;
				}
				setState(74);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(73);
					layerDefinition();
					}
					break;
				}
				}
				break;
			case CIRCLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				match(CIRCLE);
				setState(77);
				position();
				setState(78);
				match(RADIUS);
				setState(79);
				match(INT);
				setState(81);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(80);
					colorDefinition();
					}
					break;
				}
				setState(84);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(83);
					match(HOLLOW);
					}
					break;
				}
				setState(87);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(86);
					layerDefinition();
					}
					break;
				}
				}
				break;
			case RECTANGLE:
				enterOuterAlt(_localctx, 3);
				{
				setState(89);
				match(RECTANGLE);
				setState(90);
				position();
				setState(91);
				match(WIDTH);
				setState(92);
				match(INT);
				setState(93);
				match(HEIGHT);
				setState(94);
				match(INT);
				setState(96);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(95);
					colorDefinition();
					}
					break;
				}
				setState(99);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(98);
					match(HOLLOW);
					}
					break;
				}
				setState(102);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(101);
					layerDefinition();
					}
					break;
				}
				}
				break;
			case LINE:
				enterOuterAlt(_localctx, 4);
				{
				setState(104);
				match(LINE);
				setState(105);
				line_pos();
				setState(107);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(106);
					colorDefinition();
					}
					break;
				}
				setState(110);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(109);
					match(HOLLOW);
					}
					break;
				}
				setState(113);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(112);
					layerDefinition();
					}
					break;
				}
				}
				break;
			case POLYGON:
				enterOuterAlt(_localctx, 5);
				{
				setState(115);
				match(POLYGON);
				setState(116);
				poly_pos();
				setState(117);
				poly_pos();
				setState(119);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(118);
					colorDefinition();
					}
					break;
				}
				setState(122);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(121);
					match(HOLLOW);
					}
					break;
				}
				setState(125);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(124);
					layerDefinition();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PositionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(CmdPaintParser.LPAREN, 0); }
		public List<TerminalNode> INT() { return getTokens(CmdPaintParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(CmdPaintParser.INT, i);
		}
		public TerminalNode COMMA() { return getToken(CmdPaintParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(CmdPaintParser.RPAREN, 0); }
		public PositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_position; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterPosition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitPosition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitPosition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PositionContext position() throws RecognitionException {
		PositionContext _localctx = new PositionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_position);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(LPAREN);
			setState(130);
			match(INT);
			setState(131);
			match(COMMA);
			setState(132);
			match(INT);
			setState(133);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Poly_posContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(CmdPaintParser.LPAREN, 0); }
		public List<TerminalNode> INT() { return getTokens(CmdPaintParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(CmdPaintParser.INT, i);
		}
		public TerminalNode RPAREN() { return getToken(CmdPaintParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(CmdPaintParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmdPaintParser.COMMA, i);
		}
		public Poly_posContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_poly_pos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterPoly_pos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitPoly_pos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitPoly_pos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Poly_posContext poly_pos() throws RecognitionException {
		Poly_posContext _localctx = new Poly_posContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_poly_pos);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(LPAREN);
			setState(138); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(136);
					match(INT);
					setState(137);
					match(COMMA);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(140); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(142);
			match(INT);
			setState(143);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Line_posContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(CmdPaintParser.LPAREN, 0); }
		public List<TerminalNode> INT() { return getTokens(CmdPaintParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(CmdPaintParser.INT, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmdPaintParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmdPaintParser.COMMA, i);
		}
		public TerminalNode RPAREN() { return getToken(CmdPaintParser.RPAREN, 0); }
		public Line_posContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line_pos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterLine_pos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitLine_pos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitLine_pos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Line_posContext line_pos() throws RecognitionException {
		Line_posContext _localctx = new Line_posContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_line_pos);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(LPAREN);
			setState(146);
			match(INT);
			setState(147);
			match(COMMA);
			setState(148);
			match(INT);
			setState(149);
			match(COMMA);
			setState(150);
			match(INT);
			setState(151);
			match(COMMA);
			setState(152);
			match(INT);
			setState(153);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Rgb_colorContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(CmdPaintParser.LPAREN, 0); }
		public List<TerminalNode> INT() { return getTokens(CmdPaintParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(CmdPaintParser.INT, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmdPaintParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmdPaintParser.COMMA, i);
		}
		public TerminalNode RPAREN() { return getToken(CmdPaintParser.RPAREN, 0); }
		public Rgb_colorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rgb_color; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterRgb_color(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitRgb_color(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitRgb_color(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rgb_colorContext rgb_color() throws RecognitionException {
		Rgb_colorContext _localctx = new Rgb_colorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_rgb_color);
		try {
			setState(165);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(155);
				match(LPAREN);
				setState(156);
				match(INT);
				setState(157);
				match(COMMA);
				setState(158);
				match(INT);
				setState(159);
				match(COMMA);
				setState(160);
				match(INT);
				setState(161);
				match(RPAREN);
				}
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(162);
				match(INT);
				setState(163);
				match(INT);
				setState(164);
				match(INT);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColorsContext extends ParserRuleContext {
		public TerminalNode COLOR() { return getToken(CmdPaintParser.COLOR, 0); }
		public Rgb_colorContext rgb_color() {
			return getRuleContext(Rgb_colorContext.class,0);
		}
		public ColorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colors; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterColors(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitColors(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitColors(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColorsContext colors() throws RecognitionException {
		ColorsContext _localctx = new ColorsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_colors);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COLOR:
				{
				setState(167);
				match(COLOR);
				}
				break;
			case INT:
			case LPAREN:
				{
				setState(168);
				rgb_color();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColorDefinitionContext extends ParserRuleContext {
		public TerminalNode COLORC() { return getToken(CmdPaintParser.COLORC, 0); }
		public ColorsContext colors() {
			return getRuleContext(ColorsContext.class,0);
		}
		public ColorDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colorDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterColorDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitColorDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitColorDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColorDefinitionContext colorDefinition() throws RecognitionException {
		ColorDefinitionContext _localctx = new ColorDefinitionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_colorDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(COLORC);
			setState(172);
			colors();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LayerDefinitionContext extends ParserRuleContext {
		public TerminalNode LAYER() { return getToken(CmdPaintParser.LAYER, 0); }
		public TerminalNode INT() { return getToken(CmdPaintParser.INT, 0); }
		public LayerDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_layerDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterLayerDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitLayerDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitLayerDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LayerDefinitionContext layerDefinition() throws RecognitionException {
		LayerDefinitionContext _localctx = new LayerDefinitionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_layerDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(LAYER);
			setState(175);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001f\u00b2\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0004\u0000\u0016\b\u0000"+
		"\u000b\u0000\f\u0000\u0017\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001>\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002E\b\u0002\u0001\u0002"+
		"\u0003\u0002H\b\u0002\u0001\u0002\u0003\u0002K\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002R\b\u0002\u0001"+
		"\u0002\u0003\u0002U\b\u0002\u0001\u0002\u0003\u0002X\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002a\b\u0002\u0001\u0002\u0003\u0002d\b\u0002\u0001\u0002\u0003"+
		"\u0002g\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002l\b\u0002"+
		"\u0001\u0002\u0003\u0002o\b\u0002\u0001\u0002\u0003\u0002r\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002x\b\u0002\u0001"+
		"\u0002\u0003\u0002{\b\u0002\u0001\u0002\u0003\u0002~\b\u0002\u0003\u0002"+
		"\u0080\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004\u008b\b\u0004"+
		"\u000b\u0004\f\u0004\u008c\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006\u00a6\b\u0006\u0001\u0007\u0001\u0007\u0003\u0007"+
		"\u00aa\b\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0000\u0000\n\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0000\u0001"+
		"\u0001\u0000\u001a\u001b\u00cb\u0000\u0015\u0001\u0000\u0000\u0000\u0002"+
		"=\u0001\u0000\u0000\u0000\u0004\u007f\u0001\u0000\u0000\u0000\u0006\u0081"+
		"\u0001\u0000\u0000\u0000\b\u0087\u0001\u0000\u0000\u0000\n\u0091\u0001"+
		"\u0000\u0000\u0000\f\u00a5\u0001\u0000\u0000\u0000\u000e\u00a9\u0001\u0000"+
		"\u0000\u0000\u0010\u00ab\u0001\u0000\u0000\u0000\u0012\u00ae\u0001\u0000"+
		"\u0000\u0000\u0014\u0016\u0003\u0002\u0001\u0000\u0015\u0014\u0001\u0000"+
		"\u0000\u0000\u0016\u0017\u0001\u0000\u0000\u0000\u0017\u0015\u0001\u0000"+
		"\u0000\u0000\u0017\u0018\u0001\u0000\u0000\u0000\u0018\u0019\u0001\u0000"+
		"\u0000\u0000\u0019\u001a\u0005\u0000\u0000\u0001\u001a\u0001\u0001\u0000"+
		"\u0000\u0000\u001b\u001c\u0005\u0004\u0000\u0000\u001c\u001d\u0005\u0001"+
		"\u0000\u0000\u001d>\u0003\u0004\u0002\u0000\u001e\u001f\u0005\u0006\u0000"+
		"\u0000\u001f \u0005\u0001\u0000\u0000 >\u0003\u000e\u0007\u0000!\"\u0005"+
		"\u0007\u0000\u0000\"#\u0005\u0001\u0000\u0000#>\u0005\u0002\u0000\u0000"+
		"$%\u0005\b\u0000\u0000%&\u0005\u0001\u0000\u0000&>\u0003\u0006\u0003\u0000"+
		"\'>\u0005\u0019\u0000\u0000()\u0005\t\u0000\u0000)>\u0005\u0001\u0000"+
		"\u0000*+\u0005\n\u0000\u0000+>\u0003\u0010\b\u0000,-\u0005\f\u0000\u0000"+
		"-.\u0005\u0001\u0000\u0000.>\u0005\u0001\u0000\u0000/>\u0005\u000b\u0000"+
		"\u000001\u0005\u0018\u0000\u00001>\u0005\u0001\u0000\u000023\u0005\u000e"+
		"\u0000\u00003>\u0005\u0001\u0000\u000045\u0005\u0005\u0000\u000056\u0005"+
		"\u0001\u0000\u00006>\u0003\u000e\u0007\u000078\u0005\r\u0000\u000089\u0005"+
		"\u0001\u0000\u00009>\u0005\u0002\u0000\u0000:;\u0005\b\u0000\u0000;<\u0005"+
		"\u0001\u0000\u0000<>\u0007\u0000\u0000\u0000=\u001b\u0001\u0000\u0000"+
		"\u0000=\u001e\u0001\u0000\u0000\u0000=!\u0001\u0000\u0000\u0000=$\u0001"+
		"\u0000\u0000\u0000=\'\u0001\u0000\u0000\u0000=(\u0001\u0000\u0000\u0000"+
		"=*\u0001\u0000\u0000\u0000=,\u0001\u0000\u0000\u0000=/\u0001\u0000\u0000"+
		"\u0000=0\u0001\u0000\u0000\u0000=2\u0001\u0000\u0000\u0000=4\u0001\u0000"+
		"\u0000\u0000=7\u0001\u0000\u0000\u0000=:\u0001\u0000\u0000\u0000>\u0003"+
		"\u0001\u0000\u0000\u0000?@\u0005\u000f\u0000\u0000@A\u0003\u0006\u0003"+
		"\u0000AB\u0005\u0014\u0000\u0000BD\u0005\u0002\u0000\u0000CE\u0003\u0010"+
		"\b\u0000DC\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EG\u0001\u0000"+
		"\u0000\u0000FH\u0005\u0018\u0000\u0000GF\u0001\u0000\u0000\u0000GH\u0001"+
		"\u0000\u0000\u0000HJ\u0001\u0000\u0000\u0000IK\u0003\u0012\t\u0000JI\u0001"+
		"\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000K\u0080\u0001\u0000\u0000"+
		"\u0000LM\u0005\u0010\u0000\u0000MN\u0003\u0006\u0003\u0000NO\u0005\u0015"+
		"\u0000\u0000OQ\u0005\u0002\u0000\u0000PR\u0003\u0010\b\u0000QP\u0001\u0000"+
		"\u0000\u0000QR\u0001\u0000\u0000\u0000RT\u0001\u0000\u0000\u0000SU\u0005"+
		"\u0018\u0000\u0000TS\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000"+
		"UW\u0001\u0000\u0000\u0000VX\u0003\u0012\t\u0000WV\u0001\u0000\u0000\u0000"+
		"WX\u0001\u0000\u0000\u0000X\u0080\u0001\u0000\u0000\u0000YZ\u0005\u0011"+
		"\u0000\u0000Z[\u0003\u0006\u0003\u0000[\\\u0005\u0016\u0000\u0000\\]\u0005"+
		"\u0002\u0000\u0000]^\u0005\u0017\u0000\u0000^`\u0005\u0002\u0000\u0000"+
		"_a\u0003\u0010\b\u0000`_\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000"+
		"ac\u0001\u0000\u0000\u0000bd\u0005\u0018\u0000\u0000cb\u0001\u0000\u0000"+
		"\u0000cd\u0001\u0000\u0000\u0000df\u0001\u0000\u0000\u0000eg\u0003\u0012"+
		"\t\u0000fe\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000g\u0080\u0001"+
		"\u0000\u0000\u0000hi\u0005\u0013\u0000\u0000ik\u0003\n\u0005\u0000jl\u0003"+
		"\u0010\b\u0000kj\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000ln\u0001"+
		"\u0000\u0000\u0000mo\u0005\u0018\u0000\u0000nm\u0001\u0000\u0000\u0000"+
		"no\u0001\u0000\u0000\u0000oq\u0001\u0000\u0000\u0000pr\u0003\u0012\t\u0000"+
		"qp\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000r\u0080\u0001\u0000"+
		"\u0000\u0000st\u0005\u0012\u0000\u0000tu\u0003\b\u0004\u0000uw\u0003\b"+
		"\u0004\u0000vx\u0003\u0010\b\u0000wv\u0001\u0000\u0000\u0000wx\u0001\u0000"+
		"\u0000\u0000xz\u0001\u0000\u0000\u0000y{\u0005\u0018\u0000\u0000zy\u0001"+
		"\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{}\u0001\u0000\u0000\u0000"+
		"|~\u0003\u0012\t\u0000}|\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000"+
		"~\u0080\u0001\u0000\u0000\u0000\u007f?\u0001\u0000\u0000\u0000\u007fL"+
		"\u0001\u0000\u0000\u0000\u007fY\u0001\u0000\u0000\u0000\u007fh\u0001\u0000"+
		"\u0000\u0000\u007fs\u0001\u0000\u0000\u0000\u0080\u0005\u0001\u0000\u0000"+
		"\u0000\u0081\u0082\u0005\u001c\u0000\u0000\u0082\u0083\u0005\u0002\u0000"+
		"\u0000\u0083\u0084\u0005\u001e\u0000\u0000\u0084\u0085\u0005\u0002\u0000"+
		"\u0000\u0085\u0086\u0005\u001d\u0000\u0000\u0086\u0007\u0001\u0000\u0000"+
		"\u0000\u0087\u008a\u0005\u001c\u0000\u0000\u0088\u0089\u0005\u0002\u0000"+
		"\u0000\u0089\u008b\u0005\u001e\u0000\u0000\u008a\u0088\u0001\u0000\u0000"+
		"\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000"+
		"\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000"+
		"\u0000\u008e\u008f\u0005\u0002\u0000\u0000\u008f\u0090\u0005\u001d\u0000"+
		"\u0000\u0090\t\u0001\u0000\u0000\u0000\u0091\u0092\u0005\u001c\u0000\u0000"+
		"\u0092\u0093\u0005\u0002\u0000\u0000\u0093\u0094\u0005\u001e\u0000\u0000"+
		"\u0094\u0095\u0005\u0002\u0000\u0000\u0095\u0096\u0005\u001e\u0000\u0000"+
		"\u0096\u0097\u0005\u0002\u0000\u0000\u0097\u0098\u0005\u001e\u0000\u0000"+
		"\u0098\u0099\u0005\u0002\u0000\u0000\u0099\u009a\u0005\u001d\u0000\u0000"+
		"\u009a\u000b\u0001\u0000\u0000\u0000\u009b\u009c\u0005\u001c\u0000\u0000"+
		"\u009c\u009d\u0005\u0002\u0000\u0000\u009d\u009e\u0005\u001e\u0000\u0000"+
		"\u009e\u009f\u0005\u0002\u0000\u0000\u009f\u00a0\u0005\u001e\u0000\u0000"+
		"\u00a0\u00a1\u0005\u0002\u0000\u0000\u00a1\u00a6\u0005\u001d\u0000\u0000"+
		"\u00a2\u00a3\u0005\u0002\u0000\u0000\u00a3\u00a4\u0005\u0002\u0000\u0000"+
		"\u00a4\u00a6\u0005\u0002\u0000\u0000\u00a5\u009b\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a2\u0001\u0000\u0000\u0000\u00a6\r\u0001\u0000\u0000\u0000\u00a7"+
		"\u00aa\u0005\u001f\u0000\u0000\u00a8\u00aa\u0003\f\u0006\u0000\u00a9\u00a7"+
		"\u0001\u0000\u0000\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00aa\u000f"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005\u0006\u0000\u0000\u00ac\u00ad"+
		"\u0003\u000e\u0007\u0000\u00ad\u0011\u0001\u0000\u0000\u0000\u00ae\u00af"+
		"\u0005\r\u0000\u0000\u00af\u00b0\u0005\u0002\u0000\u0000\u00b0\u0013\u0001"+
		"\u0000\u0000\u0000\u0015\u0017=DGJQTW`cfknqwz}\u007f\u008c\u00a5\u00a9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}