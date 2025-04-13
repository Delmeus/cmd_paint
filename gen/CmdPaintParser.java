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
		BACKGROUND=10, SHOW_NAMES=11, RENAME=12, LAYER=13, FILL=14, SERIALIZE=15, 
		LOAD=16, SQUARE=17, CIRCLE=18, RECTANGLE=19, POLYGON=20, LINE=21, SIZE=22, 
		RADIUS=23, WIDTH=24, HEIGHT=25, HOLLOW=26, SAVE=27, DOWN=28, UP=29, STROKE=30, 
		ALL=31, LPAREN=32, RPAREN=33, COMMA=34, COLOR=35;
	public static final int
		RULE_program = 0, RULE_command = 1, RULE_shape = 2, RULE_position = 3, 
		RULE_poly_pos = 4, RULE_line_pos = 5, RULE_rgb_color = 6, RULE_colors = 7, 
		RULE_colorDefinition = 8, RULE_layerDefinition = 9, RULE_strokeDefinition = 10, 
		RULE_shapeAttributes = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "command", "shape", "position", "poly_pos", "line_pos", "rgb_color", 
			"colors", "colorDefinition", "layerDefinition", "strokeDefinition", "shapeAttributes"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'color'", null, null, null, null, 
			"'names'", null, null, "'fill'", "'serialize'", "'load'", null, null, 
			null, null, "'line'", null, null, null, null, "'hollow'", "'save'", "'down'", 
			"'up'", null, "'all'", "'('", "')'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NAME", "INT", "WS", "DRAW", "DEFINE", "COLORC", "ROTATE", "MOVE", 
			"DELETE", "BACKGROUND", "SHOW_NAMES", "RENAME", "LAYER", "FILL", "SERIALIZE", 
			"LOAD", "SQUARE", "CIRCLE", "RECTANGLE", "POLYGON", "LINE", "SIZE", "RADIUS", 
			"WIDTH", "HEIGHT", "HOLLOW", "SAVE", "DOWN", "UP", "STROKE", "ALL", "LPAREN", 
			"RPAREN", "COMMA", "COLOR"
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
			setState(25); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(24);
				command();
				}
				}
				setState(27); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1275199472L) != 0) );
			setState(29);
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
		public TerminalNode INT() { return getToken(CmdPaintParser.INT, 0); }
		public TerminalNode NAME() { return getToken(CmdPaintParser.NAME, 0); }
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
	public static class LayerOpContext extends CommandContext {
		public TerminalNode LAYER() { return getToken(CmdPaintParser.LAYER, 0); }
		public TerminalNode INT() { return getToken(CmdPaintParser.INT, 0); }
		public TerminalNode NAME() { return getToken(CmdPaintParser.NAME, 0); }
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
		public TerminalNode STROKE() { return getToken(CmdPaintParser.STROKE, 0); }
		public TerminalNode INT() { return getToken(CmdPaintParser.INT, 0); }
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
	@SuppressWarnings("CheckReturnValue")
	public static class SerializeOpContext extends CommandContext {
		public TerminalNode SERIALIZE() { return getToken(CmdPaintParser.SERIALIZE, 0); }
		public List<TerminalNode> NAME() { return getTokens(CmdPaintParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(CmdPaintParser.NAME, i);
		}
		public TerminalNode LOAD() { return getToken(CmdPaintParser.LOAD, 0); }
		public SerializeOpContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterSerializeOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitSerializeOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitSerializeOp(this);
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
	public static class DeleteOpContext extends CommandContext {
		public TerminalNode DELETE() { return getToken(CmdPaintParser.DELETE, 0); }
		public TerminalNode NAME() { return getToken(CmdPaintParser.NAME, 0); }
		public TerminalNode ALL() { return getToken(CmdPaintParser.ALL, 0); }
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
	public static class ColorOpContext extends CommandContext {
		public TerminalNode COLORC() { return getToken(CmdPaintParser.COLORC, 0); }
		public ColorsContext colors() {
			return getRuleContext(ColorsContext.class,0);
		}
		public TerminalNode NAME() { return getToken(CmdPaintParser.NAME, 0); }
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

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_command);
		int _la;
		try {
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new DrawOpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				match(DRAW);
				setState(32);
				match(NAME);
				setState(33);
				shape();
				}
				break;
			case 2:
				_localctx = new ColorOpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				match(COLORC);
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NAME) {
					{
					setState(35);
					match(NAME);
					}
				}

				setState(38);
				colors();
				}
				break;
			case 3:
				_localctx = new RotateOpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(39);
				match(ROTATE);
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NAME) {
					{
					setState(40);
					match(NAME);
					}
				}

				setState(43);
				match(INT);
				}
				break;
			case 4:
				_localctx = new MoveOpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(44);
				match(MOVE);
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NAME) {
					{
					setState(45);
					match(NAME);
					}
				}

				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(48);
					position();
					}
				}

				}
				break;
			case 5:
				_localctx = new SaveOpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(51);
				match(SAVE);
				}
				break;
			case 6:
				_localctx = new DeleteOpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(52);
				match(DELETE);
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NAME) {
					{
					setState(53);
					match(NAME);
					}
				}

				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ALL) {
					{
					setState(56);
					match(ALL);
					}
				}

				}
				break;
			case 7:
				_localctx = new BackgroundOpContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(59);
				match(BACKGROUND);
				setState(60);
				colorDefinition();
				}
				break;
			case 8:
				_localctx = new RenameOpContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(61);
				match(RENAME);
				setState(62);
				match(NAME);
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NAME) {
					{
					setState(63);
					match(NAME);
					}
				}

				}
				break;
			case 9:
				_localctx = new ShowNamesOpContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(66);
				match(SHOW_NAMES);
				}
				break;
			case 10:
				_localctx = new HollowOpContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(67);
				match(HOLLOW);
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NAME) {
					{
					setState(68);
					match(NAME);
					}
				}

				}
				break;
			case 11:
				_localctx = new HollowOpContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(71);
				match(FILL);
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NAME) {
					{
					setState(72);
					match(NAME);
					}
				}

				}
				break;
			case 12:
				_localctx = new HollowOpContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(75);
				match(STROKE);
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NAME) {
					{
					setState(76);
					match(NAME);
					}
				}

				setState(79);
				match(INT);
				}
				break;
			case 13:
				_localctx = new DefineOpContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(80);
				match(DEFINE);
				setState(81);
				match(NAME);
				setState(82);
				colors();
				}
				break;
			case 14:
				_localctx = new LayerOpContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(83);
				match(LAYER);
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NAME) {
					{
					setState(84);
					match(NAME);
					}
				}

				setState(87);
				match(INT);
				}
				break;
			case 15:
				_localctx = new LayerOpContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(88);
				match(MOVE);
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NAME) {
					{
					setState(89);
					match(NAME);
					}
				}

				setState(92);
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
			case 16:
				_localctx = new SerializeOpContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(93);
				match(SERIALIZE);
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(94);
					match(NAME);
					}
					}
					setState(99);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 17:
				_localctx = new SerializeOpContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(100);
				match(LOAD);
				setState(101);
				match(NAME);
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
		public TerminalNode SIZE() { return getToken(CmdPaintParser.SIZE, 0); }
		public List<TerminalNode> INT() { return getTokens(CmdPaintParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(CmdPaintParser.INT, i);
		}
		public PositionContext position() {
			return getRuleContext(PositionContext.class,0);
		}
		public List<ShapeAttributesContext> shapeAttributes() {
			return getRuleContexts(ShapeAttributesContext.class);
		}
		public ShapeAttributesContext shapeAttributes(int i) {
			return getRuleContext(ShapeAttributesContext.class,i);
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
		int _la;
		try {
			int _alt;
			setState(159);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SQUARE:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				match(SQUARE);
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(105);
					position();
					}
				}

				setState(108);
				match(SIZE);
				setState(109);
				match(INT);
				setState(113);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(110);
						shapeAttributes();
						}
						} 
					}
					setState(115);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				}
				}
				break;
			case CIRCLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(CIRCLE);
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(117);
					position();
					}
				}

				setState(120);
				match(RADIUS);
				setState(121);
				match(INT);
				setState(125);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(122);
						shapeAttributes();
						}
						} 
					}
					setState(127);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				}
				}
				break;
			case RECTANGLE:
				enterOuterAlt(_localctx, 3);
				{
				setState(128);
				match(RECTANGLE);
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(129);
					position();
					}
				}

				setState(132);
				match(WIDTH);
				setState(133);
				match(INT);
				setState(134);
				match(HEIGHT);
				setState(135);
				match(INT);
				setState(139);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(136);
						shapeAttributes();
						}
						} 
					}
					setState(141);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				}
				break;
			case LINE:
				enterOuterAlt(_localctx, 4);
				{
				setState(142);
				match(LINE);
				setState(143);
				line_pos();
				setState(147);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(144);
						shapeAttributes();
						}
						} 
					}
					setState(149);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				}
				}
				break;
			case POLYGON:
				enterOuterAlt(_localctx, 5);
				{
				setState(150);
				match(POLYGON);
				setState(151);
				poly_pos();
				setState(152);
				poly_pos();
				setState(156);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(153);
						shapeAttributes();
						}
						} 
					}
					setState(158);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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
			setState(161);
			match(LPAREN);
			setState(162);
			match(INT);
			setState(163);
			match(COMMA);
			setState(164);
			match(INT);
			setState(165);
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
			setState(167);
			match(LPAREN);
			setState(170); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(168);
					match(INT);
					setState(169);
					match(COMMA);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(172); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(174);
			match(INT);
			setState(175);
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
			setState(177);
			match(LPAREN);
			setState(178);
			match(INT);
			setState(179);
			match(COMMA);
			setState(180);
			match(INT);
			setState(181);
			match(COMMA);
			setState(182);
			match(INT);
			setState(183);
			match(COMMA);
			setState(184);
			match(INT);
			setState(185);
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
			setState(197);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(187);
				match(LPAREN);
				setState(188);
				match(INT);
				setState(189);
				match(COMMA);
				setState(190);
				match(INT);
				setState(191);
				match(COMMA);
				setState(192);
				match(INT);
				setState(193);
				match(RPAREN);
				}
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(194);
				match(INT);
				setState(195);
				match(INT);
				setState(196);
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
			setState(201);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COLOR:
				{
				setState(199);
				match(COLOR);
				}
				break;
			case INT:
			case LPAREN:
				{
				setState(200);
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
			setState(203);
			match(COLORC);
			setState(204);
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
			setState(206);
			match(LAYER);
			setState(207);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StrokeDefinitionContext extends ParserRuleContext {
		public TerminalNode STROKE() { return getToken(CmdPaintParser.STROKE, 0); }
		public TerminalNode INT() { return getToken(CmdPaintParser.INT, 0); }
		public StrokeDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strokeDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterStrokeDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitStrokeDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitStrokeDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrokeDefinitionContext strokeDefinition() throws RecognitionException {
		StrokeDefinitionContext _localctx = new StrokeDefinitionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_strokeDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(STROKE);
			setState(210);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ShapeAttributesContext extends ParserRuleContext {
		public ColorDefinitionContext colorDefinition() {
			return getRuleContext(ColorDefinitionContext.class,0);
		}
		public TerminalNode HOLLOW() { return getToken(CmdPaintParser.HOLLOW, 0); }
		public LayerDefinitionContext layerDefinition() {
			return getRuleContext(LayerDefinitionContext.class,0);
		}
		public StrokeDefinitionContext strokeDefinition() {
			return getRuleContext(StrokeDefinitionContext.class,0);
		}
		public ShapeAttributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shapeAttributes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterShapeAttributes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitShapeAttributes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitShapeAttributes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShapeAttributesContext shapeAttributes() throws RecognitionException {
		ShapeAttributesContext _localctx = new ShapeAttributesContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_shapeAttributes);
		try {
			setState(216);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COLORC:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				colorDefinition();
				}
				break;
			case HOLLOW:
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				match(HOLLOW);
				}
				break;
			case LAYER:
				enterOuterAlt(_localctx, 3);
				{
				setState(214);
				layerDefinition();
				}
				break;
			case STROKE:
				enterOuterAlt(_localctx, 4);
				{
				setState(215);
				strokeDefinition();
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

	public static final String _serializedATN =
		"\u0004\u0001#\u00db\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0004\u0000\u001a\b\u0000\u000b\u0000\f\u0000\u001b\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001%\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"*\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001/\b\u0001\u0001"+
		"\u0001\u0003\u00012\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u00017\b\u0001\u0001\u0001\u0003\u0001:\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001A\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001F\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001J\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001N\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001V\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001[\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001`\b\u0001\n\u0001\f\u0001"+
		"c\t\u0001\u0001\u0001\u0001\u0001\u0003\u0001g\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0003\u0002k\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002p\b\u0002\n\u0002\f\u0002s\t\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002w\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002|\b\u0002"+
		"\n\u0002\f\u0002\u007f\t\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u0083"+
		"\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002\u008a\b\u0002\n\u0002\f\u0002\u008d\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002\u0092\b\u0002\n\u0002\f\u0002\u0095\t\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u009b\b\u0002\n"+
		"\u0002\f\u0002\u009e\t\u0002\u0003\u0002\u00a0\b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0004\u0004\u00ab\b\u0004\u000b\u0004\f\u0004\u00ac"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"\u00c6\b\u0006\u0001\u0007\u0001\u0007\u0003\u0007\u00ca\b\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00d9\b\u000b\u0001"+
		"\u000b\u0000\u0000\f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0000\u0001\u0001\u0000\u001c\u001d\u00fe\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0002f\u0001\u0000\u0000\u0000\u0004\u009f\u0001\u0000\u0000"+
		"\u0000\u0006\u00a1\u0001\u0000\u0000\u0000\b\u00a7\u0001\u0000\u0000\u0000"+
		"\n\u00b1\u0001\u0000\u0000\u0000\f\u00c5\u0001\u0000\u0000\u0000\u000e"+
		"\u00c9\u0001\u0000\u0000\u0000\u0010\u00cb\u0001\u0000\u0000\u0000\u0012"+
		"\u00ce\u0001\u0000\u0000\u0000\u0014\u00d1\u0001\u0000\u0000\u0000\u0016"+
		"\u00d8\u0001\u0000\u0000\u0000\u0018\u001a\u0003\u0002\u0001\u0000\u0019"+
		"\u0018\u0001\u0000\u0000\u0000\u001a\u001b\u0001\u0000\u0000\u0000\u001b"+
		"\u0019\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c"+
		"\u001d\u0001\u0000\u0000\u0000\u001d\u001e\u0005\u0000\u0000\u0001\u001e"+
		"\u0001\u0001\u0000\u0000\u0000\u001f \u0005\u0004\u0000\u0000 !\u0005"+
		"\u0001\u0000\u0000!g\u0003\u0004\u0002\u0000\"$\u0005\u0006\u0000\u0000"+
		"#%\u0005\u0001\u0000\u0000$#\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000"+
		"\u0000%&\u0001\u0000\u0000\u0000&g\u0003\u000e\u0007\u0000\')\u0005\u0007"+
		"\u0000\u0000(*\u0005\u0001\u0000\u0000)(\u0001\u0000\u0000\u0000)*\u0001"+
		"\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+g\u0005\u0002\u0000\u0000"+
		",.\u0005\b\u0000\u0000-/\u0005\u0001\u0000\u0000.-\u0001\u0000\u0000\u0000"+
		"./\u0001\u0000\u0000\u0000/1\u0001\u0000\u0000\u000002\u0003\u0006\u0003"+
		"\u000010\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u00002g\u0001\u0000"+
		"\u0000\u00003g\u0005\u001b\u0000\u000046\u0005\t\u0000\u000057\u0005\u0001"+
		"\u0000\u000065\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u000079\u0001"+
		"\u0000\u0000\u00008:\u0005\u001f\u0000\u000098\u0001\u0000\u0000\u0000"+
		"9:\u0001\u0000\u0000\u0000:g\u0001\u0000\u0000\u0000;<\u0005\n\u0000\u0000"+
		"<g\u0003\u0010\b\u0000=>\u0005\f\u0000\u0000>@\u0005\u0001\u0000\u0000"+
		"?A\u0005\u0001\u0000\u0000@?\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000"+
		"\u0000Ag\u0001\u0000\u0000\u0000Bg\u0005\u000b\u0000\u0000CE\u0005\u001a"+
		"\u0000\u0000DF\u0005\u0001\u0000\u0000ED\u0001\u0000\u0000\u0000EF\u0001"+
		"\u0000\u0000\u0000Fg\u0001\u0000\u0000\u0000GI\u0005\u000e\u0000\u0000"+
		"HJ\u0005\u0001\u0000\u0000IH\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000"+
		"\u0000Jg\u0001\u0000\u0000\u0000KM\u0005\u001e\u0000\u0000LN\u0005\u0001"+
		"\u0000\u0000ML\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NO\u0001"+
		"\u0000\u0000\u0000Og\u0005\u0002\u0000\u0000PQ\u0005\u0005\u0000\u0000"+
		"QR\u0005\u0001\u0000\u0000Rg\u0003\u000e\u0007\u0000SU\u0005\r\u0000\u0000"+
		"TV\u0005\u0001\u0000\u0000UT\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000"+
		"\u0000VW\u0001\u0000\u0000\u0000Wg\u0005\u0002\u0000\u0000XZ\u0005\b\u0000"+
		"\u0000Y[\u0005\u0001\u0000\u0000ZY\u0001\u0000\u0000\u0000Z[\u0001\u0000"+
		"\u0000\u0000[\\\u0001\u0000\u0000\u0000\\g\u0007\u0000\u0000\u0000]a\u0005"+
		"\u000f\u0000\u0000^`\u0005\u0001\u0000\u0000_^\u0001\u0000\u0000\u0000"+
		"`c\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000"+
		"\u0000bg\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000de\u0005\u0010"+
		"\u0000\u0000eg\u0005\u0001\u0000\u0000f\u001f\u0001\u0000\u0000\u0000"+
		"f\"\u0001\u0000\u0000\u0000f\'\u0001\u0000\u0000\u0000f,\u0001\u0000\u0000"+
		"\u0000f3\u0001\u0000\u0000\u0000f4\u0001\u0000\u0000\u0000f;\u0001\u0000"+
		"\u0000\u0000f=\u0001\u0000\u0000\u0000fB\u0001\u0000\u0000\u0000fC\u0001"+
		"\u0000\u0000\u0000fG\u0001\u0000\u0000\u0000fK\u0001\u0000\u0000\u0000"+
		"fP\u0001\u0000\u0000\u0000fS\u0001\u0000\u0000\u0000fX\u0001\u0000\u0000"+
		"\u0000f]\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000g\u0003\u0001"+
		"\u0000\u0000\u0000hj\u0005\u0011\u0000\u0000ik\u0003\u0006\u0003\u0000"+
		"ji\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000"+
		"\u0000lm\u0005\u0016\u0000\u0000mq\u0005\u0002\u0000\u0000np\u0003\u0016"+
		"\u000b\u0000on\u0001\u0000\u0000\u0000ps\u0001\u0000\u0000\u0000qo\u0001"+
		"\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000r\u00a0\u0001\u0000\u0000"+
		"\u0000sq\u0001\u0000\u0000\u0000tv\u0005\u0012\u0000\u0000uw\u0003\u0006"+
		"\u0003\u0000vu\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wx\u0001"+
		"\u0000\u0000\u0000xy\u0005\u0017\u0000\u0000y}\u0005\u0002\u0000\u0000"+
		"z|\u0003\u0016\u000b\u0000{z\u0001\u0000\u0000\u0000|\u007f\u0001\u0000"+
		"\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u00a0"+
		"\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u0082\u0005"+
		"\u0013\u0000\u0000\u0081\u0083\u0003\u0006\u0003\u0000\u0082\u0081\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0084\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0005\u0018\u0000\u0000\u0085\u0086\u0005"+
		"\u0002\u0000\u0000\u0086\u0087\u0005\u0019\u0000\u0000\u0087\u008b\u0005"+
		"\u0002\u0000\u0000\u0088\u008a\u0003\u0016\u000b\u0000\u0089\u0088\u0001"+
		"\u0000\u0000\u0000\u008a\u008d\u0001\u0000\u0000\u0000\u008b\u0089\u0001"+
		"\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u00a0\u0001"+
		"\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008e\u008f\u0005"+
		"\u0015\u0000\u0000\u008f\u0093\u0003\n\u0005\u0000\u0090\u0092\u0003\u0016"+
		"\u000b\u0000\u0091\u0090\u0001\u0000\u0000\u0000\u0092\u0095\u0001\u0000"+
		"\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000"+
		"\u0000\u0000\u0094\u00a0\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000"+
		"\u0000\u0000\u0096\u0097\u0005\u0014\u0000\u0000\u0097\u0098\u0003\b\u0004"+
		"\u0000\u0098\u009c\u0003\b\u0004\u0000\u0099\u009b\u0003\u0016\u000b\u0000"+
		"\u009a\u0099\u0001\u0000\u0000\u0000\u009b\u009e\u0001\u0000\u0000\u0000"+
		"\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000"+
		"\u009d\u00a0\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000"+
		"\u009fh\u0001\u0000\u0000\u0000\u009ft\u0001\u0000\u0000\u0000\u009f\u0080"+
		"\u0001\u0000\u0000\u0000\u009f\u008e\u0001\u0000\u0000\u0000\u009f\u0096"+
		"\u0001\u0000\u0000\u0000\u00a0\u0005\u0001\u0000\u0000\u0000\u00a1\u00a2"+
		"\u0005 \u0000\u0000\u00a2\u00a3\u0005\u0002\u0000\u0000\u00a3\u00a4\u0005"+
		"\"\u0000\u0000\u00a4\u00a5\u0005\u0002\u0000\u0000\u00a5\u00a6\u0005!"+
		"\u0000\u0000\u00a6\u0007\u0001\u0000\u0000\u0000\u00a7\u00aa\u0005 \u0000"+
		"\u0000\u00a8\u00a9\u0005\u0002\u0000\u0000\u00a9\u00ab\u0005\"\u0000\u0000"+
		"\u00aa\u00a8\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000"+
		"\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000"+
		"\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u00af\u0005\u0002\u0000\u0000"+
		"\u00af\u00b0\u0005!\u0000\u0000\u00b0\t\u0001\u0000\u0000\u0000\u00b1"+
		"\u00b2\u0005 \u0000\u0000\u00b2\u00b3\u0005\u0002\u0000\u0000\u00b3\u00b4"+
		"\u0005\"\u0000\u0000\u00b4\u00b5\u0005\u0002\u0000\u0000\u00b5\u00b6\u0005"+
		"\"\u0000\u0000\u00b6\u00b7\u0005\u0002\u0000\u0000\u00b7\u00b8\u0005\""+
		"\u0000\u0000\u00b8\u00b9\u0005\u0002\u0000\u0000\u00b9\u00ba\u0005!\u0000"+
		"\u0000\u00ba\u000b\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005 \u0000\u0000"+
		"\u00bc\u00bd\u0005\u0002\u0000\u0000\u00bd\u00be\u0005\"\u0000\u0000\u00be"+
		"\u00bf\u0005\u0002\u0000\u0000\u00bf\u00c0\u0005\"\u0000\u0000\u00c0\u00c1"+
		"\u0005\u0002\u0000\u0000\u00c1\u00c6\u0005!\u0000\u0000\u00c2\u00c3\u0005"+
		"\u0002\u0000\u0000\u00c3\u00c4\u0005\u0002\u0000\u0000\u00c4\u00c6\u0005"+
		"\u0002\u0000\u0000\u00c5\u00bb\u0001\u0000\u0000\u0000\u00c5\u00c2\u0001"+
		"\u0000\u0000\u0000\u00c6\r\u0001\u0000\u0000\u0000\u00c7\u00ca\u0005#"+
		"\u0000\u0000\u00c8\u00ca\u0003\f\u0006\u0000\u00c9\u00c7\u0001\u0000\u0000"+
		"\u0000\u00c9\u00c8\u0001\u0000\u0000\u0000\u00ca\u000f\u0001\u0000\u0000"+
		"\u0000\u00cb\u00cc\u0005\u0006\u0000\u0000\u00cc\u00cd\u0003\u000e\u0007"+
		"\u0000\u00cd\u0011\u0001\u0000\u0000\u0000\u00ce\u00cf\u0005\r\u0000\u0000"+
		"\u00cf\u00d0\u0005\u0002\u0000\u0000\u00d0\u0013\u0001\u0000\u0000\u0000"+
		"\u00d1\u00d2\u0005\u001e\u0000\u0000\u00d2\u00d3\u0005\u0002\u0000\u0000"+
		"\u00d3\u0015\u0001\u0000\u0000\u0000\u00d4\u00d9\u0003\u0010\b\u0000\u00d5"+
		"\u00d9\u0005\u001a\u0000\u0000\u00d6\u00d9\u0003\u0012\t\u0000\u00d7\u00d9"+
		"\u0003\u0014\n\u0000\u00d8\u00d4\u0001\u0000\u0000\u0000\u00d8\u00d5\u0001"+
		"\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d7\u0001"+
		"\u0000\u0000\u0000\u00d9\u0017\u0001\u0000\u0000\u0000\u001c\u001b$)."+
		"169@EIMUZafjqv}\u0082\u008b\u0093\u009c\u009f\u00ac\u00c5\u00c9\u00d8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}