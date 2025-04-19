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
		SAVE=30, DOWN=31, UP=32, STROKE=33, ALL=34, IMAGE=35, SCRIPT=36, LPAREN=37, 
		RPAREN=38, COMMA=39, COLOR=40;
	public static final int
		RULE_program = 0, RULE_command = 1, RULE_shape = 2, RULE_position = 3, 
		RULE_poly_pos = 4, RULE_line_pos = 5, RULE_rgb_color = 6, RULE_colors = 7, 
		RULE_colorDefinition = 8, RULE_layerDefinition = 9, RULE_strokeDefinition = 10, 
		RULE_shapeAttributes = 11, RULE_savePossibility = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "command", "shape", "position", "poly_pos", "line_pos", "rgb_color", 
			"colors", "colorDefinition", "layerDefinition", "strokeDefinition", "shapeAttributes", 
			"savePossibility"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'color'", null, null, null, null, 
			"'names'", null, null, "'fill'", "'serialize'", "'group'", "'load'", 
			"'clone'", null, null, null, null, "'line'", null, "'length'", null, 
			null, null, "'hollow'", "'save'", "'down'", "'up'", null, "'all'", null, 
			"'script'", "'('", "')'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NAME", "INT", "WS", "DRAW", "DEFINE", "COLORC", "ROTATE", "MOVE", 
			"DELETE", "BACKGROUND", "SHOW_NAMES", "RENAME", "LAYER", "FILL", "SERIALIZE", 
			"GROUP", "LOAD", "CLONE", "SQUARE", "CIRCLE", "RECTANGLE", "POLYGON", 
			"LINE", "SIZE", "LENGTH", "RADIUS", "WIDTH", "HEIGHT", "HOLLOW", "SAVE", 
			"DOWN", "UP", "STROKE", "ALL", "IMAGE", "SCRIPT", "LPAREN", "RPAREN", 
			"COMMA", "COLOR"
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
			setState(27); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(26);
				command();
				}
				}
				setState(29); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 10201071600L) != 0) );
			setState(31);
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
		public SavePossibilityContext savePossibility() {
			return getRuleContext(SavePossibilityContext.class,0);
		}
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
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new DrawOpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				match(DRAW);
				setState(34);
				match(NAME);
				setState(35);
				shape();
				}
				break;
			case 2:
				_localctx = new ColorOpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(36);
				match(COLORC);
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(37);
					match(NAME);
					}
					}
					setState(42);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(43);
				colors();
				}
				break;
			case 3:
				_localctx = new RotateOpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(44);
				match(ROTATE);
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(45);
					match(NAME);
					}
					}
					setState(50);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(51);
				match(INT);
				}
				break;
			case 4:
				_localctx = new MoveOpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(52);
				match(MOVE);
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(53);
					match(NAME);
					}
					}
					setState(58);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(59);
					position();
					}
				}

				}
				break;
			case 5:
				_localctx = new SaveOpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(62);
				match(SAVE);
				setState(63);
				savePossibility();
				}
				break;
			case 6:
				_localctx = new DeleteOpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(64);
				match(DELETE);
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(65);
					match(NAME);
					}
					}
					setState(70);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ALL) {
					{
					setState(71);
					match(ALL);
					}
				}

				}
				break;
			case 7:
				_localctx = new BackgroundOpContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(74);
				match(BACKGROUND);
				setState(75);
				colorDefinition();
				}
				break;
			case 8:
				_localctx = new RenameOpContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(76);
				match(RENAME);
				setState(77);
				match(NAME);
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NAME) {
					{
					setState(78);
					match(NAME);
					}
				}

				}
				break;
			case 9:
				_localctx = new ShowNamesOpContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(81);
				match(SHOW_NAMES);
				}
				break;
			case 10:
				_localctx = new HollowOpContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(82);
				match(HOLLOW);
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(83);
					match(NAME);
					}
					}
					setState(88);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 11:
				_localctx = new HollowOpContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(89);
				match(FILL);
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(90);
					match(NAME);
					}
					}
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 12:
				_localctx = new HollowOpContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(96);
				match(STROKE);
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(97);
					match(NAME);
					}
					}
					setState(102);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(103);
				match(INT);
				}
				break;
			case 13:
				_localctx = new DefineOpContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(104);
				match(DEFINE);
				setState(105);
				match(NAME);
				setState(106);
				colors();
				}
				break;
			case 14:
				_localctx = new LayerOpContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(107);
				match(LAYER);
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(108);
					match(NAME);
					}
					}
					setState(113);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(114);
				match(INT);
				}
				break;
			case 15:
				_localctx = new LayerOpContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(115);
				match(MOVE);
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(116);
					match(NAME);
					}
					}
					setState(121);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(122);
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
				setState(123);
				match(CLONE);
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NAME) {
					{
					setState(124);
					match(NAME);
					}
				}

				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(127);
					position();
					}
				}

				}
				break;
			case 17:
				_localctx = new SerializeOpContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(130);
				match(SERIALIZE);
				setState(131);
				match(NAME);
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(132);
					match(NAME);
					}
					}
					setState(137);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 18:
				_localctx = new GroupOpContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(138);
				match(GROUP);
				setState(139);
				match(NAME);
				setState(141); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(140);
					match(NAME);
					}
					}
					setState(143); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NAME );
				}
				break;
			case 19:
				_localctx = new SerializeOpContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(145);
				match(LOAD);
				setState(146);
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
			setState(208);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SQUARE:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				match(SQUARE);
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(150);
					position();
					}
				}

				setState(153);
				match(SIZE);
				setState(154);
				match(INT);
				setState(158);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(155);
						shapeAttributes();
						}
						} 
					}
					setState(160);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				}
				}
				break;
			case CIRCLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				match(CIRCLE);
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(162);
					position();
					}
				}

				setState(165);
				match(RADIUS);
				setState(166);
				match(INT);
				setState(170);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(167);
						shapeAttributes();
						}
						} 
					}
					setState(172);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				}
				}
				break;
			case RECTANGLE:
				enterOuterAlt(_localctx, 3);
				{
				setState(173);
				match(RECTANGLE);
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(174);
					position();
					}
				}

				setState(177);
				match(WIDTH);
				setState(178);
				match(INT);
				setState(179);
				match(HEIGHT);
				setState(180);
				match(INT);
				setState(184);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(181);
						shapeAttributes();
						}
						} 
					}
					setState(186);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				}
				}
				break;
			case LINE:
				enterOuterAlt(_localctx, 4);
				{
				setState(187);
				match(LINE);
				setState(191);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LPAREN:
					{
					setState(188);
					line_pos();
					}
					break;
				case LENGTH:
					{
					{
					setState(189);
					match(LENGTH);
					setState(190);
					match(INT);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(196);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(193);
						shapeAttributes();
						}
						} 
					}
					setState(198);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				}
				}
				break;
			case POLYGON:
				enterOuterAlt(_localctx, 5);
				{
				setState(199);
				match(POLYGON);
				setState(200);
				poly_pos();
				setState(201);
				poly_pos();
				setState(205);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(202);
						shapeAttributes();
						}
						} 
					}
					setState(207);
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
			setState(210);
			match(LPAREN);
			setState(211);
			match(INT);
			setState(212);
			match(COMMA);
			setState(213);
			match(INT);
			setState(214);
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
			setState(216);
			match(LPAREN);
			setState(219); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(217);
					match(INT);
					setState(218);
					match(COMMA);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(221); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(223);
			match(INT);
			setState(224);
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
			setState(226);
			match(LPAREN);
			setState(227);
			match(INT);
			setState(228);
			match(COMMA);
			setState(229);
			match(INT);
			setState(230);
			match(COMMA);
			setState(231);
			match(INT);
			setState(232);
			match(COMMA);
			setState(233);
			match(INT);
			setState(234);
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
			setState(246);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(236);
				match(LPAREN);
				setState(237);
				match(INT);
				setState(238);
				match(COMMA);
				setState(239);
				match(INT);
				setState(240);
				match(COMMA);
				setState(241);
				match(INT);
				setState(242);
				match(RPAREN);
				}
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(243);
				match(INT);
				setState(244);
				match(INT);
				setState(245);
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
			setState(250);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COLOR:
				{
				setState(248);
				match(COLOR);
				}
				break;
			case INT:
			case LPAREN:
				{
				setState(249);
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
			setState(252);
			match(COLORC);
			setState(253);
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
			setState(255);
			match(LAYER);
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
			setState(258);
			match(STROKE);
			setState(259);
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
			setState(265);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COLORC:
				enterOuterAlt(_localctx, 1);
				{
				setState(261);
				colorDefinition();
				}
				break;
			case HOLLOW:
				enterOuterAlt(_localctx, 2);
				{
				setState(262);
				match(HOLLOW);
				}
				break;
			case LAYER:
				enterOuterAlt(_localctx, 3);
				{
				setState(263);
				layerDefinition();
				}
				break;
			case STROKE:
				enterOuterAlt(_localctx, 4);
				{
				setState(264);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SavePossibilityContext extends ParserRuleContext {
		public TerminalNode IMAGE() { return getToken(CmdPaintParser.IMAGE, 0); }
		public TerminalNode SCRIPT() { return getToken(CmdPaintParser.SCRIPT, 0); }
		public SavePossibilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_savePossibility; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterSavePossibility(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitSavePossibility(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitSavePossibility(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SavePossibilityContext savePossibility() throws RecognitionException {
		SavePossibilityContext _localctx = new SavePossibilityContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_savePossibility);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			_la = _input.LA(1);
			if ( !(_la==IMAGE || _la==SCRIPT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static final String _serializedATN =
		"\u0004\u0001(\u010e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0004\u0000\u001c\b\u0000\u000b\u0000\f\u0000\u001d"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001\'\b\u0001\n\u0001\f\u0001*\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001/\b\u0001\n\u0001\f\u00012\t\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u00017\b\u0001\n\u0001\f\u0001"+
		":\t\u0001\u0001\u0001\u0003\u0001=\b\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u0001C\b\u0001\n\u0001\f\u0001F\t\u0001\u0001"+
		"\u0001\u0003\u0001I\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001P\b\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u0001U\b\u0001\n\u0001\f\u0001X\t\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u0001\\\b\u0001\n\u0001\f\u0001_\t\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u0001c\b\u0001\n\u0001\f\u0001f\t\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001n\b"+
		"\u0001\n\u0001\f\u0001q\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005"+
		"\u0001v\b\u0001\n\u0001\f\u0001y\t\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001~\b\u0001\u0001\u0001\u0003\u0001\u0081\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0005\u0001\u0086\b\u0001\n\u0001\f\u0001"+
		"\u0089\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u0001\u008e\b"+
		"\u0001\u000b\u0001\f\u0001\u008f\u0001\u0001\u0001\u0001\u0003\u0001\u0094"+
		"\b\u0001\u0001\u0002\u0001\u0002\u0003\u0002\u0098\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u0002\u009d\b\u0002\n\u0002\f\u0002\u00a0"+
		"\t\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u00a4\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u0002\u00a9\b\u0002\n\u0002\f\u0002\u00ac"+
		"\t\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u00b0\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u00b7\b\u0002"+
		"\n\u0002\f\u0002\u00ba\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002\u00c0\b\u0002\u0001\u0002\u0005\u0002\u00c3\b\u0002"+
		"\n\u0002\f\u0002\u00c6\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002\u00cc\b\u0002\n\u0002\f\u0002\u00cf\t\u0002\u0003\u0002"+
		"\u00d1\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004\u00dc\b\u0004"+
		"\u000b\u0004\f\u0004\u00dd\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006\u00f7\b\u0006\u0001\u0007\u0001\u0007\u0003\u0007"+
		"\u00fb\b\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n"+
		"\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u010a\b\u000b\u0001\f\u0001\f\u0001\f\u0000\u0000\r\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000\u0002\u0001"+
		"\u0000\u001f \u0001\u0000#$\u0136\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0002\u0093\u0001\u0000\u0000\u0000\u0004\u00d0\u0001\u0000\u0000\u0000"+
		"\u0006\u00d2\u0001\u0000\u0000\u0000\b\u00d8\u0001\u0000\u0000\u0000\n"+
		"\u00e2\u0001\u0000\u0000\u0000\f\u00f6\u0001\u0000\u0000\u0000\u000e\u00fa"+
		"\u0001\u0000\u0000\u0000\u0010\u00fc\u0001\u0000\u0000\u0000\u0012\u00ff"+
		"\u0001\u0000\u0000\u0000\u0014\u0102\u0001\u0000\u0000\u0000\u0016\u0109"+
		"\u0001\u0000\u0000\u0000\u0018\u010b\u0001\u0000\u0000\u0000\u001a\u001c"+
		"\u0003\u0002\u0001\u0000\u001b\u001a\u0001\u0000\u0000\u0000\u001c\u001d"+
		"\u0001\u0000\u0000\u0000\u001d\u001b\u0001\u0000\u0000\u0000\u001d\u001e"+
		"\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f \u0005"+
		"\u0000\u0000\u0001 \u0001\u0001\u0000\u0000\u0000!\"\u0005\u0004\u0000"+
		"\u0000\"#\u0005\u0001\u0000\u0000#\u0094\u0003\u0004\u0002\u0000$(\u0005"+
		"\u0006\u0000\u0000%\'\u0005\u0001\u0000\u0000&%\u0001\u0000\u0000\u0000"+
		"\'*\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000()\u0001\u0000\u0000"+
		"\u0000)+\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000+\u0094\u0003"+
		"\u000e\u0007\u0000,0\u0005\u0007\u0000\u0000-/\u0005\u0001\u0000\u0000"+
		".-\u0001\u0000\u0000\u0000/2\u0001\u0000\u0000\u00000.\u0001\u0000\u0000"+
		"\u000001\u0001\u0000\u0000\u000013\u0001\u0000\u0000\u000020\u0001\u0000"+
		"\u0000\u00003\u0094\u0005\u0002\u0000\u000048\u0005\b\u0000\u000057\u0005"+
		"\u0001\u0000\u000065\u0001\u0000\u0000\u00007:\u0001\u0000\u0000\u0000"+
		"86\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009<\u0001\u0000\u0000"+
		"\u0000:8\u0001\u0000\u0000\u0000;=\u0003\u0006\u0003\u0000<;\u0001\u0000"+
		"\u0000\u0000<=\u0001\u0000\u0000\u0000=\u0094\u0001\u0000\u0000\u0000"+
		">?\u0005\u001e\u0000\u0000?\u0094\u0003\u0018\f\u0000@D\u0005\t\u0000"+
		"\u0000AC\u0005\u0001\u0000\u0000BA\u0001\u0000\u0000\u0000CF\u0001\u0000"+
		"\u0000\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EH\u0001"+
		"\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000GI\u0005\"\u0000\u0000HG\u0001"+
		"\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000I\u0094\u0001\u0000\u0000"+
		"\u0000JK\u0005\n\u0000\u0000K\u0094\u0003\u0010\b\u0000LM\u0005\f\u0000"+
		"\u0000MO\u0005\u0001\u0000\u0000NP\u0005\u0001\u0000\u0000ON\u0001\u0000"+
		"\u0000\u0000OP\u0001\u0000\u0000\u0000P\u0094\u0001\u0000\u0000\u0000"+
		"Q\u0094\u0005\u000b\u0000\u0000RV\u0005\u001d\u0000\u0000SU\u0005\u0001"+
		"\u0000\u0000TS\u0001\u0000\u0000\u0000UX\u0001\u0000\u0000\u0000VT\u0001"+
		"\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000W\u0094\u0001\u0000\u0000"+
		"\u0000XV\u0001\u0000\u0000\u0000Y]\u0005\u000e\u0000\u0000Z\\\u0005\u0001"+
		"\u0000\u0000[Z\u0001\u0000\u0000\u0000\\_\u0001\u0000\u0000\u0000][\u0001"+
		"\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^\u0094\u0001\u0000\u0000"+
		"\u0000_]\u0001\u0000\u0000\u0000`d\u0005!\u0000\u0000ac\u0005\u0001\u0000"+
		"\u0000ba\u0001\u0000\u0000\u0000cf\u0001\u0000\u0000\u0000db\u0001\u0000"+
		"\u0000\u0000de\u0001\u0000\u0000\u0000eg\u0001\u0000\u0000\u0000fd\u0001"+
		"\u0000\u0000\u0000g\u0094\u0005\u0002\u0000\u0000hi\u0005\u0005\u0000"+
		"\u0000ij\u0005\u0001\u0000\u0000j\u0094\u0003\u000e\u0007\u0000ko\u0005"+
		"\r\u0000\u0000ln\u0005\u0001\u0000\u0000ml\u0001\u0000\u0000\u0000nq\u0001"+
		"\u0000\u0000\u0000om\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000"+
		"pr\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000r\u0094\u0005\u0002"+
		"\u0000\u0000sw\u0005\b\u0000\u0000tv\u0005\u0001\u0000\u0000ut\u0001\u0000"+
		"\u0000\u0000vy\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000wx\u0001"+
		"\u0000\u0000\u0000xz\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000"+
		"z\u0094\u0007\u0000\u0000\u0000{}\u0005\u0012\u0000\u0000|~\u0005\u0001"+
		"\u0000\u0000}|\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u0080"+
		"\u0001\u0000\u0000\u0000\u007f\u0081\u0003\u0006\u0003\u0000\u0080\u007f"+
		"\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0094"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0005\u000f\u0000\u0000\u0083\u0087"+
		"\u0005\u0001\u0000\u0000\u0084\u0086\u0005\u0001\u0000\u0000\u0085\u0084"+
		"\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000\u0000\u0087\u0085"+
		"\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0094"+
		"\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a\u008b"+
		"\u0005\u0010\u0000\u0000\u008b\u008d\u0005\u0001\u0000\u0000\u008c\u008e"+
		"\u0005\u0001\u0000\u0000\u008d\u008c\u0001\u0000\u0000\u0000\u008e\u008f"+
		"\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f\u0090"+
		"\u0001\u0000\u0000\u0000\u0090\u0094\u0001\u0000\u0000\u0000\u0091\u0092"+
		"\u0005\u0011\u0000\u0000\u0092\u0094\u0005\u0001\u0000\u0000\u0093!\u0001"+
		"\u0000\u0000\u0000\u0093$\u0001\u0000\u0000\u0000\u0093,\u0001\u0000\u0000"+
		"\u0000\u00934\u0001\u0000\u0000\u0000\u0093>\u0001\u0000\u0000\u0000\u0093"+
		"@\u0001\u0000\u0000\u0000\u0093J\u0001\u0000\u0000\u0000\u0093L\u0001"+
		"\u0000\u0000\u0000\u0093Q\u0001\u0000\u0000\u0000\u0093R\u0001\u0000\u0000"+
		"\u0000\u0093Y\u0001\u0000\u0000\u0000\u0093`\u0001\u0000\u0000\u0000\u0093"+
		"h\u0001\u0000\u0000\u0000\u0093k\u0001\u0000\u0000\u0000\u0093s\u0001"+
		"\u0000\u0000\u0000\u0093{\u0001\u0000\u0000\u0000\u0093\u0082\u0001\u0000"+
		"\u0000\u0000\u0093\u008a\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000"+
		"\u0000\u0000\u0094\u0003\u0001\u0000\u0000\u0000\u0095\u0097\u0005\u0013"+
		"\u0000\u0000\u0096\u0098\u0003\u0006\u0003\u0000\u0097\u0096\u0001\u0000"+
		"\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000"+
		"\u0000\u0000\u0099\u009a\u0005\u0018\u0000\u0000\u009a\u009e\u0005\u0002"+
		"\u0000\u0000\u009b\u009d\u0003\u0016\u000b\u0000\u009c\u009b\u0001\u0000"+
		"\u0000\u0000\u009d\u00a0\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000"+
		"\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00d1\u0001\u0000"+
		"\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a1\u00a3\u0005\u0014"+
		"\u0000\u0000\u00a2\u00a4\u0003\u0006\u0003\u0000\u00a3\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000"+
		"\u0000\u0000\u00a5\u00a6\u0005\u001a\u0000\u0000\u00a6\u00aa\u0005\u0002"+
		"\u0000\u0000\u00a7\u00a9\u0003\u0016\u000b\u0000\u00a8\u00a7\u0001\u0000"+
		"\u0000\u0000\u00a9\u00ac\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00d1\u0001\u0000"+
		"\u0000\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ad\u00af\u0005\u0015"+
		"\u0000\u0000\u00ae\u00b0\u0003\u0006\u0003\u0000\u00af\u00ae\u0001\u0000"+
		"\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b2\u0005\u001b\u0000\u0000\u00b2\u00b3\u0005\u0002"+
		"\u0000\u0000\u00b3\u00b4\u0005\u001c\u0000\u0000\u00b4\u00b8\u0005\u0002"+
		"\u0000\u0000\u00b5\u00b7\u0003\u0016\u000b\u0000\u00b6\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b7\u00ba\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\u00d1\u0001\u0000"+
		"\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000\u00bb\u00bf\u0005\u0017"+
		"\u0000\u0000\u00bc\u00c0\u0003\n\u0005\u0000\u00bd\u00be\u0005\u0019\u0000"+
		"\u0000\u00be\u00c0\u0005\u0002\u0000\u0000\u00bf\u00bc\u0001\u0000\u0000"+
		"\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00c0\u00c4\u0001\u0000\u0000"+
		"\u0000\u00c1\u00c3\u0003\u0016\u000b\u0000\u00c2\u00c1\u0001\u0000\u0000"+
		"\u0000\u00c3\u00c6\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000"+
		"\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5\u00d1\u0001\u0000\u0000"+
		"\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c7\u00c8\u0005\u0016\u0000"+
		"\u0000\u00c8\u00c9\u0003\b\u0004\u0000\u00c9\u00cd\u0003\b\u0004\u0000"+
		"\u00ca\u00cc\u0003\u0016\u000b\u0000\u00cb\u00ca\u0001\u0000\u0000\u0000"+
		"\u00cc\u00cf\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000"+
		"\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000"+
		"\u00cf\u00cd\u0001\u0000\u0000\u0000\u00d0\u0095\u0001\u0000\u0000\u0000"+
		"\u00d0\u00a1\u0001\u0000\u0000\u0000\u00d0\u00ad\u0001\u0000\u0000\u0000"+
		"\u00d0\u00bb\u0001\u0000\u0000\u0000\u00d0\u00c7\u0001\u0000\u0000\u0000"+
		"\u00d1\u0005\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005%\u0000\u0000\u00d3"+
		"\u00d4\u0005\u0002\u0000\u0000\u00d4\u00d5\u0005\'\u0000\u0000\u00d5\u00d6"+
		"\u0005\u0002\u0000\u0000\u00d6\u00d7\u0005&\u0000\u0000\u00d7\u0007\u0001"+
		"\u0000\u0000\u0000\u00d8\u00db\u0005%\u0000\u0000\u00d9\u00da\u0005\u0002"+
		"\u0000\u0000\u00da\u00dc\u0005\'\u0000\u0000\u00db\u00d9\u0001\u0000\u0000"+
		"\u0000\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000"+
		"\u0000\u00dd\u00de\u0001\u0000\u0000\u0000\u00de\u00df\u0001\u0000\u0000"+
		"\u0000\u00df\u00e0\u0005\u0002\u0000\u0000\u00e0\u00e1\u0005&\u0000\u0000"+
		"\u00e1\t\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005%\u0000\u0000\u00e3"+
		"\u00e4\u0005\u0002\u0000\u0000\u00e4\u00e5\u0005\'\u0000\u0000\u00e5\u00e6"+
		"\u0005\u0002\u0000\u0000\u00e6\u00e7\u0005\'\u0000\u0000\u00e7\u00e8\u0005"+
		"\u0002\u0000\u0000\u00e8\u00e9\u0005\'\u0000\u0000\u00e9\u00ea\u0005\u0002"+
		"\u0000\u0000\u00ea\u00eb\u0005&\u0000\u0000\u00eb\u000b\u0001\u0000\u0000"+
		"\u0000\u00ec\u00ed\u0005%\u0000\u0000\u00ed\u00ee\u0005\u0002\u0000\u0000"+
		"\u00ee\u00ef\u0005\'\u0000\u0000\u00ef\u00f0\u0005\u0002\u0000\u0000\u00f0"+
		"\u00f1\u0005\'\u0000\u0000\u00f1\u00f2\u0005\u0002\u0000\u0000\u00f2\u00f7"+
		"\u0005&\u0000\u0000\u00f3\u00f4\u0005\u0002\u0000\u0000\u00f4\u00f5\u0005"+
		"\u0002\u0000\u0000\u00f5\u00f7\u0005\u0002\u0000\u0000\u00f6\u00ec\u0001"+
		"\u0000\u0000\u0000\u00f6\u00f3\u0001\u0000\u0000\u0000\u00f7\r\u0001\u0000"+
		"\u0000\u0000\u00f8\u00fb\u0005(\u0000\u0000\u00f9\u00fb\u0003\f\u0006"+
		"\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fa\u00f9\u0001\u0000\u0000"+
		"\u0000\u00fb\u000f\u0001\u0000\u0000\u0000\u00fc\u00fd\u0005\u0006\u0000"+
		"\u0000\u00fd\u00fe\u0003\u000e\u0007\u0000\u00fe\u0011\u0001\u0000\u0000"+
		"\u0000\u00ff\u0100\u0005\r\u0000\u0000\u0100\u0101\u0005\u0002\u0000\u0000"+
		"\u0101\u0013\u0001\u0000\u0000\u0000\u0102\u0103\u0005!\u0000\u0000\u0103"+
		"\u0104\u0005\u0002\u0000\u0000\u0104\u0015\u0001\u0000\u0000\u0000\u0105"+
		"\u010a\u0003\u0010\b\u0000\u0106\u010a\u0005\u001d\u0000\u0000\u0107\u010a"+
		"\u0003\u0012\t\u0000\u0108\u010a\u0003\u0014\n\u0000\u0109\u0105\u0001"+
		"\u0000\u0000\u0000\u0109\u0106\u0001\u0000\u0000\u0000\u0109\u0107\u0001"+
		"\u0000\u0000\u0000\u0109\u0108\u0001\u0000\u0000\u0000\u010a\u0017\u0001"+
		"\u0000\u0000\u0000\u010b\u010c\u0007\u0001\u0000\u0000\u010c\u0019\u0001"+
		"\u0000\u0000\u0000 \u001d(08<DHOV]dow}\u0080\u0087\u008f\u0093\u0097\u009e"+
		"\u00a3\u00aa\u00af\u00b8\u00bf\u00c4\u00cd\u00d0\u00dd\u00f6\u00fa\u0109";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}