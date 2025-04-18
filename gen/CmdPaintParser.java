// Generated from /home/antek/studia/magisterka/semI/MiASI/cmd_paint/src/CmdPaintParser.g4 by ANTLR 4.13.2
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
		GROUP=16, LOAD=17, CLONE=18, SQUARE=19, CIRCLE=20, RECTANGLE=21, POLYGON=22, 
		LINE=23, SIZE=24, LENGTH=25, RADIUS=26, WIDTH=27, HEIGHT=28, HOLLOW=29, 
		SAVE=30, DOWN=31, UP=32, STROKE=33, ALL=34, LPAREN=35, RPAREN=36, COMMA=37, 
		COLOR=38;
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
			"'names'", null, null, "'fill'", "'serialize'", "'group'", "'load'", 
			"'clone'", null, null, null, null, "'line'", null, "'length'", null, 
			null, null, "'hollow'", "'save'", "'down'", "'up'", null, "'all'", "'('", 
			"')'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NAME", "INT", "WS", "DRAW", "DEFINE", "COLORC", "ROTATE", "MOVE", 
			"DELETE", "BACKGROUND", "SHOW_NAMES", "RENAME", "LAYER", "FILL", "SERIALIZE", 
			"GROUP", "LOAD", "CLONE", "SQUARE", "CIRCLE", "RECTANGLE", "POLYGON", 
			"LINE", "SIZE", "LENGTH", "RADIUS", "WIDTH", "HEIGHT", "HOLLOW", "SAVE", 
			"DOWN", "UP", "STROKE", "ALL", "LPAREN", "RPAREN", "COMMA", "COLOR"
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 10201071600L) != 0) );
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
		public List<TerminalNode> NAME() { return getTokens(CmdPaintParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(CmdPaintParser.NAME, i);
		}
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
		public List<TerminalNode> NAME() { return getTokens(CmdPaintParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(CmdPaintParser.NAME, i);
		}
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
		public List<TerminalNode> NAME() { return getTokens(CmdPaintParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(CmdPaintParser.NAME, i);
		}
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
		public List<TerminalNode> NAME() { return getTokens(CmdPaintParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(CmdPaintParser.NAME, i);
		}
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
		public List<TerminalNode> NAME() { return getTokens(CmdPaintParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(CmdPaintParser.NAME, i);
		}
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
	public static class CloneOpContext extends CommandContext {
		public TerminalNode CLONE() { return getToken(CmdPaintParser.CLONE, 0); }
		public TerminalNode NAME() { return getToken(CmdPaintParser.NAME, 0); }
		public PositionContext position() {
			return getRuleContext(PositionContext.class,0);
		}
		public CloneOpContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterCloneOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitCloneOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitCloneOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ColorOpContext extends CommandContext {
		public TerminalNode COLORC() { return getToken(CmdPaintParser.COLORC, 0); }
		public ColorsContext colors() {
			return getRuleContext(ColorsContext.class,0);
		}
		public List<TerminalNode> NAME() { return getTokens(CmdPaintParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(CmdPaintParser.NAME, i);
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
	public static class GroupOpContext extends CommandContext {
		public TerminalNode GROUP() { return getToken(CmdPaintParser.GROUP, 0); }
		public List<TerminalNode> NAME() { return getTokens(CmdPaintParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(CmdPaintParser.NAME, i);
		}
		public GroupOpContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterGroupOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitGroupOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitGroupOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_command);
		int _la;
		try {
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
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
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(35);
					match(NAME);
					}
					}
					setState(40);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(41);
				colors();
				}
				break;
			case 3:
				_localctx = new RotateOpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				match(ROTATE);
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(43);
					match(NAME);
					}
					}
					setState(48);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(49);
				match(INT);
				}
				break;
			case 4:
				_localctx = new MoveOpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(50);
				match(MOVE);
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(51);
					match(NAME);
					}
					}
					setState(56);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(57);
					position();
					}
				}

				}
				break;
			case 5:
				_localctx = new SaveOpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(60);
				match(SAVE);
				}
				break;
			case 6:
				_localctx = new DeleteOpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(61);
				match(DELETE);
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(62);
					match(NAME);
					}
					}
					setState(67);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ALL) {
					{
					setState(68);
					match(ALL);
					}
				}

				}
				break;
			case 7:
				_localctx = new BackgroundOpContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(71);
				match(BACKGROUND);
				setState(72);
				colorDefinition();
				}
				break;
			case 8:
				_localctx = new RenameOpContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(73);
				match(RENAME);
				setState(74);
				match(NAME);
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NAME) {
					{
					setState(75);
					match(NAME);
					}
				}

				}
				break;
			case 9:
				_localctx = new ShowNamesOpContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(78);
				match(SHOW_NAMES);
				}
				break;
			case 10:
				_localctx = new HollowOpContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(79);
				match(HOLLOW);
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(80);
					match(NAME);
					}
					}
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 11:
				_localctx = new HollowOpContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(86);
				match(FILL);
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(87);
					match(NAME);
					}
					}
					setState(92);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 12:
				_localctx = new HollowOpContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(93);
				match(STROKE);
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
				setState(100);
				match(INT);
				}
				break;
			case 13:
				_localctx = new DefineOpContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(101);
				match(DEFINE);
				setState(102);
				match(NAME);
				setState(103);
				colors();
				}
				break;
			case 14:
				_localctx = new LayerOpContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(104);
				match(LAYER);
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(105);
					match(NAME);
					}
					}
					setState(110);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(111);
				match(INT);
				}
				break;
			case 15:
				_localctx = new LayerOpContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(112);
				match(MOVE);
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(113);
					match(NAME);
					}
					}
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(119);
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
				_localctx = new CloneOpContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(120);
				match(CLONE);
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NAME) {
					{
					setState(121);
					match(NAME);
					}
				}

				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(124);
					position();
					}
				}

				}
				break;
			case 17:
				_localctx = new SerializeOpContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(127);
				match(SERIALIZE);
				setState(128);
				match(NAME);
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(129);
					match(NAME);
					}
					}
					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 18:
				_localctx = new GroupOpContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(135);
				match(GROUP);
				setState(136);
				match(NAME);
				setState(138); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(137);
					match(NAME);
					}
					}
					setState(140); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NAME );
				}
				break;
			case 19:
				_localctx = new SerializeOpContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(142);
				match(LOAD);
				setState(143);
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
		public TerminalNode LENGTH() { return getToken(CmdPaintParser.LENGTH, 0); }
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
			setState(205);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SQUARE:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				match(SQUARE);
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(147);
					position();
					}
				}

				setState(150);
				match(SIZE);
				setState(151);
				match(INT);
				setState(155);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(152);
						shapeAttributes();
						}
						} 
					}
					setState(157);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				}
				}
				break;
			case CIRCLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				match(CIRCLE);
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(159);
					position();
					}
				}

				setState(162);
				match(RADIUS);
				setState(163);
				match(INT);
				setState(167);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(164);
						shapeAttributes();
						}
						} 
					}
					setState(169);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				}
				}
				break;
			case RECTANGLE:
				enterOuterAlt(_localctx, 3);
				{
				setState(170);
				match(RECTANGLE);
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(171);
					position();
					}
				}

				setState(174);
				match(WIDTH);
				setState(175);
				match(INT);
				setState(176);
				match(HEIGHT);
				setState(177);
				match(INT);
				setState(181);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(178);
						shapeAttributes();
						}
						} 
					}
					setState(183);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				}
				}
				break;
			case LINE:
				enterOuterAlt(_localctx, 4);
				{
				setState(184);
				match(LINE);
				setState(188);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LPAREN:
					{
					setState(185);
					line_pos();
					}
					break;
				case LENGTH:
					{
					{
					setState(186);
					match(LENGTH);
					setState(187);
					match(INT);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(193);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(190);
						shapeAttributes();
						}
						} 
					}
					setState(195);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				}
				}
				break;
			case POLYGON:
				enterOuterAlt(_localctx, 5);
				{
				setState(196);
				match(POLYGON);
				setState(197);
				poly_pos();
				setState(198);
				poly_pos();
				setState(202);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(199);
						shapeAttributes();
						}
						} 
					}
					setState(204);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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
			setState(207);
			match(LPAREN);
			setState(208);
			match(INT);
			setState(209);
			match(COMMA);
			setState(210);
			match(INT);
			setState(211);
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
			setState(213);
			match(LPAREN);
			setState(216); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(214);
					match(INT);
					setState(215);
					match(COMMA);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(218); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(220);
			match(INT);
			setState(221);
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
			setState(223);
			match(LPAREN);
			setState(224);
			match(INT);
			setState(225);
			match(COMMA);
			setState(226);
			match(INT);
			setState(227);
			match(COMMA);
			setState(228);
			match(INT);
			setState(229);
			match(COMMA);
			setState(230);
			match(INT);
			setState(231);
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
			setState(243);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(233);
				match(LPAREN);
				setState(234);
				match(INT);
				setState(235);
				match(COMMA);
				setState(236);
				match(INT);
				setState(237);
				match(COMMA);
				setState(238);
				match(INT);
				setState(239);
				match(RPAREN);
				}
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(240);
				match(INT);
				setState(241);
				match(INT);
				setState(242);
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
			setState(247);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COLOR:
				{
				setState(245);
				match(COLOR);
				}
				break;
			case INT:
			case LPAREN:
				{
				setState(246);
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
			setState(249);
			match(COLORC);
			setState(250);
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
			setState(252);
			match(LAYER);
			setState(253);
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
			setState(255);
			match(STROKE);
			setState(256);
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
			setState(262);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COLORC:
				enterOuterAlt(_localctx, 1);
				{
				setState(258);
				colorDefinition();
				}
				break;
			case HOLLOW:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				match(HOLLOW);
				}
				break;
			case LAYER:
				enterOuterAlt(_localctx, 3);
				{
				setState(260);
				layerDefinition();
				}
				break;
			case STROKE:
				enterOuterAlt(_localctx, 4);
				{
				setState(261);
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
		"\u0004\u0001&\u0109\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0004\u0000\u001a\b\u0000\u000b\u0000\f\u0000\u001b\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001%\b\u0001\n\u0001\f\u0001(\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001-\b\u0001\n\u0001\f\u00010\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u00015\b\u0001\n\u0001\f\u00018\t\u0001"+
		"\u0001\u0001\u0003\u0001;\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001@\b\u0001\n\u0001\f\u0001C\t\u0001\u0001\u0001\u0003\u0001"+
		"F\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001M\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"R\b\u0001\n\u0001\f\u0001U\t\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"Y\b\u0001\n\u0001\f\u0001\\\t\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"`\b\u0001\n\u0001\f\u0001c\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001k\b\u0001\n\u0001\f\u0001"+
		"n\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001s\b\u0001\n\u0001"+
		"\f\u0001v\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001{\b\u0001"+
		"\u0001\u0001\u0003\u0001~\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001\u0083\b\u0001\n\u0001\f\u0001\u0086\t\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0004\u0001\u008b\b\u0001\u000b\u0001\f\u0001\u008c"+
		"\u0001\u0001\u0001\u0001\u0003\u0001\u0091\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0003\u0002\u0095\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"\u009a\b\u0002\n\u0002\f\u0002\u009d\t\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002\u00a1\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u00a6"+
		"\b\u0002\n\u0002\f\u0002\u00a9\t\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"\u00ad\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002\u00b4\b\u0002\n\u0002\f\u0002\u00b7\t\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u00bd\b\u0002\u0001\u0002\u0005"+
		"\u0002\u00c0\b\u0002\n\u0002\f\u0002\u00c3\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u0002\u00c9\b\u0002\n\u0002\f\u0002\u00cc"+
		"\t\u0002\u0003\u0002\u00ce\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0004\u0004\u00d9\b\u0004\u000b\u0004\f\u0004\u00da\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00f4\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u00f8\b\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u0107\b\u000b\u0001\u000b\u0000\u0000\f"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0000\u0001"+
		"\u0001\u0000\u001f \u0132\u0000\u0019\u0001\u0000\u0000\u0000\u0002\u0090"+
		"\u0001\u0000\u0000\u0000\u0004\u00cd\u0001\u0000\u0000\u0000\u0006\u00cf"+
		"\u0001\u0000\u0000\u0000\b\u00d5\u0001\u0000\u0000\u0000\n\u00df\u0001"+
		"\u0000\u0000\u0000\f\u00f3\u0001\u0000\u0000\u0000\u000e\u00f7\u0001\u0000"+
		"\u0000\u0000\u0010\u00f9\u0001\u0000\u0000\u0000\u0012\u00fc\u0001\u0000"+
		"\u0000\u0000\u0014\u00ff\u0001\u0000\u0000\u0000\u0016\u0106\u0001\u0000"+
		"\u0000\u0000\u0018\u001a\u0003\u0002\u0001\u0000\u0019\u0018\u0001\u0000"+
		"\u0000\u0000\u001a\u001b\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000"+
		"\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000"+
		"\u0000\u0000\u001d\u001e\u0005\u0000\u0000\u0001\u001e\u0001\u0001\u0000"+
		"\u0000\u0000\u001f \u0005\u0004\u0000\u0000 !\u0005\u0001\u0000\u0000"+
		"!\u0091\u0003\u0004\u0002\u0000\"&\u0005\u0006\u0000\u0000#%\u0005\u0001"+
		"\u0000\u0000$#\u0001\u0000\u0000\u0000%(\u0001\u0000\u0000\u0000&$\u0001"+
		"\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\')\u0001\u0000\u0000\u0000"+
		"(&\u0001\u0000\u0000\u0000)\u0091\u0003\u000e\u0007\u0000*.\u0005\u0007"+
		"\u0000\u0000+-\u0005\u0001\u0000\u0000,+\u0001\u0000\u0000\u0000-0\u0001"+
		"\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000"+
		"/1\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u00001\u0091\u0005\u0002"+
		"\u0000\u000026\u0005\b\u0000\u000035\u0005\u0001\u0000\u000043\u0001\u0000"+
		"\u0000\u000058\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000067\u0001"+
		"\u0000\u0000\u00007:\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u0000"+
		"9;\u0003\u0006\u0003\u0000:9\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000"+
		"\u0000;\u0091\u0001\u0000\u0000\u0000<\u0091\u0005\u001e\u0000\u0000="+
		"A\u0005\t\u0000\u0000>@\u0005\u0001\u0000\u0000?>\u0001\u0000\u0000\u0000"+
		"@C\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000"+
		"\u0000BE\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000DF\u0005\"\u0000"+
		"\u0000ED\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000F\u0091\u0001"+
		"\u0000\u0000\u0000GH\u0005\n\u0000\u0000H\u0091\u0003\u0010\b\u0000IJ"+
		"\u0005\f\u0000\u0000JL\u0005\u0001\u0000\u0000KM\u0005\u0001\u0000\u0000"+
		"LK\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000M\u0091\u0001\u0000"+
		"\u0000\u0000N\u0091\u0005\u000b\u0000\u0000OS\u0005\u001d\u0000\u0000"+
		"PR\u0005\u0001\u0000\u0000QP\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000"+
		"\u0000SQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000T\u0091\u0001"+
		"\u0000\u0000\u0000US\u0001\u0000\u0000\u0000VZ\u0005\u000e\u0000\u0000"+
		"WY\u0005\u0001\u0000\u0000XW\u0001\u0000\u0000\u0000Y\\\u0001\u0000\u0000"+
		"\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[\u0091\u0001"+
		"\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000]a\u0005!\u0000\u0000^`\u0005"+
		"\u0001\u0000\u0000_^\u0001\u0000\u0000\u0000`c\u0001\u0000\u0000\u0000"+
		"a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bd\u0001\u0000\u0000"+
		"\u0000ca\u0001\u0000\u0000\u0000d\u0091\u0005\u0002\u0000\u0000ef\u0005"+
		"\u0005\u0000\u0000fg\u0005\u0001\u0000\u0000g\u0091\u0003\u000e\u0007"+
		"\u0000hl\u0005\r\u0000\u0000ik\u0005\u0001\u0000\u0000ji\u0001\u0000\u0000"+
		"\u0000kn\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000lm\u0001\u0000"+
		"\u0000\u0000mo\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000o\u0091"+
		"\u0005\u0002\u0000\u0000pt\u0005\b\u0000\u0000qs\u0005\u0001\u0000\u0000"+
		"rq\u0001\u0000\u0000\u0000sv\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000"+
		"\u0000tu\u0001\u0000\u0000\u0000uw\u0001\u0000\u0000\u0000vt\u0001\u0000"+
		"\u0000\u0000w\u0091\u0007\u0000\u0000\u0000xz\u0005\u0012\u0000\u0000"+
		"y{\u0005\u0001\u0000\u0000zy\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000"+
		"\u0000{}\u0001\u0000\u0000\u0000|~\u0003\u0006\u0003\u0000}|\u0001\u0000"+
		"\u0000\u0000}~\u0001\u0000\u0000\u0000~\u0091\u0001\u0000\u0000\u0000"+
		"\u007f\u0080\u0005\u000f\u0000\u0000\u0080\u0084\u0005\u0001\u0000\u0000"+
		"\u0081\u0083\u0005\u0001\u0000\u0000\u0082\u0081\u0001\u0000\u0000\u0000"+
		"\u0083\u0086\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000"+
		"\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0091\u0001\u0000\u0000\u0000"+
		"\u0086\u0084\u0001\u0000\u0000\u0000\u0087\u0088\u0005\u0010\u0000\u0000"+
		"\u0088\u008a\u0005\u0001\u0000\u0000\u0089\u008b\u0005\u0001\u0000\u0000"+
		"\u008a\u0089\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000"+
		"\u008c\u008a\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000"+
		"\u008d\u0091\u0001\u0000\u0000\u0000\u008e\u008f\u0005\u0011\u0000\u0000"+
		"\u008f\u0091\u0005\u0001\u0000\u0000\u0090\u001f\u0001\u0000\u0000\u0000"+
		"\u0090\"\u0001\u0000\u0000\u0000\u0090*\u0001\u0000\u0000\u0000\u0090"+
		"2\u0001\u0000\u0000\u0000\u0090<\u0001\u0000\u0000\u0000\u0090=\u0001"+
		"\u0000\u0000\u0000\u0090G\u0001\u0000\u0000\u0000\u0090I\u0001\u0000\u0000"+
		"\u0000\u0090N\u0001\u0000\u0000\u0000\u0090O\u0001\u0000\u0000\u0000\u0090"+
		"V\u0001\u0000\u0000\u0000\u0090]\u0001\u0000\u0000\u0000\u0090e\u0001"+
		"\u0000\u0000\u0000\u0090h\u0001\u0000\u0000\u0000\u0090p\u0001\u0000\u0000"+
		"\u0000\u0090x\u0001\u0000\u0000\u0000\u0090\u007f\u0001\u0000\u0000\u0000"+
		"\u0090\u0087\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000"+
		"\u0091\u0003\u0001\u0000\u0000\u0000\u0092\u0094\u0005\u0013\u0000\u0000"+
		"\u0093\u0095\u0003\u0006\u0003\u0000\u0094\u0093\u0001\u0000\u0000\u0000"+
		"\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000"+
		"\u0096\u0097\u0005\u0018\u0000\u0000\u0097\u009b\u0005\u0002\u0000\u0000"+
		"\u0098\u009a\u0003\u0016\u000b\u0000\u0099\u0098\u0001\u0000\u0000\u0000"+
		"\u009a\u009d\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000"+
		"\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u00ce\u0001\u0000\u0000\u0000"+
		"\u009d\u009b\u0001\u0000\u0000\u0000\u009e\u00a0\u0005\u0014\u0000\u0000"+
		"\u009f\u00a1\u0003\u0006\u0003\u0000\u00a0\u009f\u0001\u0000\u0000\u0000"+
		"\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a2\u00a3\u0005\u001a\u0000\u0000\u00a3\u00a7\u0005\u0002\u0000\u0000"+
		"\u00a4\u00a6\u0003\u0016\u000b\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a9\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00ce\u0001\u0000\u0000\u0000"+
		"\u00a9\u00a7\u0001\u0000\u0000\u0000\u00aa\u00ac\u0005\u0015\u0000\u0000"+
		"\u00ab\u00ad\u0003\u0006\u0003\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000"+
		"\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000"+
		"\u00ae\u00af\u0005\u001b\u0000\u0000\u00af\u00b0\u0005\u0002\u0000\u0000"+
		"\u00b0\u00b1\u0005\u001c\u0000\u0000\u00b1\u00b5\u0005\u0002\u0000\u0000"+
		"\u00b2\u00b4\u0003\u0016\u000b\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000"+
		"\u00b4\u00b7\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u00ce\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b8\u00bc\u0005\u0017\u0000\u0000"+
		"\u00b9\u00bd\u0003\n\u0005\u0000\u00ba\u00bb\u0005\u0019\u0000\u0000\u00bb"+
		"\u00bd\u0005\u0002\u0000\u0000\u00bc\u00b9\u0001\u0000\u0000\u0000\u00bc"+
		"\u00ba\u0001\u0000\u0000\u0000\u00bd\u00c1\u0001\u0000\u0000\u0000\u00be"+
		"\u00c0\u0003\u0016\u000b\u0000\u00bf\u00be\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c3\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c2\u00ce\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c1\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005\u0016\u0000\u0000\u00c5"+
		"\u00c6\u0003\b\u0004\u0000\u00c6\u00ca\u0003\b\u0004\u0000\u00c7\u00c9"+
		"\u0003\u0016\u000b\u0000\u00c8\u00c7\u0001\u0000\u0000\u0000\u00c9\u00cc"+
		"\u0001\u0000\u0000\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00ca\u00cb"+
		"\u0001\u0000\u0000\u0000\u00cb\u00ce\u0001\u0000\u0000\u0000\u00cc\u00ca"+
		"\u0001\u0000\u0000\u0000\u00cd\u0092\u0001\u0000\u0000\u0000\u00cd\u009e"+
		"\u0001\u0000\u0000\u0000\u00cd\u00aa\u0001\u0000\u0000\u0000\u00cd\u00b8"+
		"\u0001\u0000\u0000\u0000\u00cd\u00c4\u0001\u0000\u0000\u0000\u00ce\u0005"+
		"\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005#\u0000\u0000\u00d0\u00d1\u0005"+
		"\u0002\u0000\u0000\u00d1\u00d2\u0005%\u0000\u0000\u00d2\u00d3\u0005\u0002"+
		"\u0000\u0000\u00d3\u00d4\u0005$\u0000\u0000\u00d4\u0007\u0001\u0000\u0000"+
		"\u0000\u00d5\u00d8\u0005#\u0000\u0000\u00d6\u00d7\u0005\u0002\u0000\u0000"+
		"\u00d7\u00d9\u0005%\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d9"+
		"\u00da\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00da"+
		"\u00db\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc"+
		"\u00dd\u0005\u0002\u0000\u0000\u00dd\u00de\u0005$\u0000\u0000\u00de\t"+
		"\u0001\u0000\u0000\u0000\u00df\u00e0\u0005#\u0000\u0000\u00e0\u00e1\u0005"+
		"\u0002\u0000\u0000\u00e1\u00e2\u0005%\u0000\u0000\u00e2\u00e3\u0005\u0002"+
		"\u0000\u0000\u00e3\u00e4\u0005%\u0000\u0000\u00e4\u00e5\u0005\u0002\u0000"+
		"\u0000\u00e5\u00e6\u0005%\u0000\u0000\u00e6\u00e7\u0005\u0002\u0000\u0000"+
		"\u00e7\u00e8\u0005$\u0000\u0000\u00e8\u000b\u0001\u0000\u0000\u0000\u00e9"+
		"\u00ea\u0005#\u0000\u0000\u00ea\u00eb\u0005\u0002\u0000\u0000\u00eb\u00ec"+
		"\u0005%\u0000\u0000\u00ec\u00ed\u0005\u0002\u0000\u0000\u00ed\u00ee\u0005"+
		"%\u0000\u0000\u00ee\u00ef\u0005\u0002\u0000\u0000\u00ef\u00f4\u0005$\u0000"+
		"\u0000\u00f0\u00f1\u0005\u0002\u0000\u0000\u00f1\u00f2\u0005\u0002\u0000"+
		"\u0000\u00f2\u00f4\u0005\u0002\u0000\u0000\u00f3\u00e9\u0001\u0000\u0000"+
		"\u0000\u00f3\u00f0\u0001\u0000\u0000\u0000\u00f4\r\u0001\u0000\u0000\u0000"+
		"\u00f5\u00f8\u0005&\u0000\u0000\u00f6\u00f8\u0003\f\u0006\u0000\u00f7"+
		"\u00f5\u0001\u0000\u0000\u0000\u00f7\u00f6\u0001\u0000\u0000\u0000\u00f8"+
		"\u000f\u0001\u0000\u0000\u0000\u00f9\u00fa\u0005\u0006\u0000\u0000\u00fa"+
		"\u00fb\u0003\u000e\u0007\u0000\u00fb\u0011\u0001\u0000\u0000\u0000\u00fc"+
		"\u00fd\u0005\r\u0000\u0000\u00fd\u00fe\u0005\u0002\u0000\u0000\u00fe\u0013"+
		"\u0001\u0000\u0000\u0000\u00ff\u0100\u0005!\u0000\u0000\u0100\u0101\u0005"+
		"\u0002\u0000\u0000\u0101\u0015\u0001\u0000\u0000\u0000\u0102\u0107\u0003"+
		"\u0010\b\u0000\u0103\u0107\u0005\u001d\u0000\u0000\u0104\u0107\u0003\u0012"+
		"\t\u0000\u0105\u0107\u0003\u0014\n\u0000\u0106\u0102\u0001\u0000\u0000"+
		"\u0000\u0106\u0103\u0001\u0000\u0000\u0000\u0106\u0104\u0001\u0000\u0000"+
		"\u0000\u0106\u0105\u0001\u0000\u0000\u0000\u0107\u0017\u0001\u0000\u0000"+
		"\u0000 \u001b&.6:AELSZaltz}\u0084\u008c\u0090\u0094\u009b\u00a0\u00a7"+
		"\u00ac\u00b5\u00bc\u00c1\u00ca\u00cd\u00da\u00f3\u00f7\u0106";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}