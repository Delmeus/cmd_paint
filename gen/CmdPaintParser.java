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
		NAME=1, COLOR=2, INT=3, WS=4, DRAW=5, COLORC=6, ROTATE=7, MOVE=8, DELETE=9, 
		RENAME=10, SQUARE=11, CIRCLE=12, RECTANGLE=13, LINE=14, SIZE=15, RADIUS=16, 
		WIDTH=17, HEIGHT=18, SAVE=19, LPAREN=20, RPAREN=21, COMMA=22;
	public static final int
		RULE_program = 0, RULE_command = 1, RULE_shape = 2, RULE_position = 3, 
		RULE_line_pos = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "command", "shape", "position", "line_pos"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'draw'", "'color'", "'rotate'", "'move'", 
			"'delete'", "'rename'", "'square'", "'circle'", "'rectangle'", "'line'", 
			"'size'", "'radius'", "'width'", "'height'", "'save'", "'('", "')'", 
			"','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NAME", "COLOR", "INT", "WS", "DRAW", "COLORC", "ROTATE", "MOVE", 
			"DELETE", "RENAME", "SQUARE", "CIRCLE", "RECTANGLE", "LINE", "SIZE", 
			"RADIUS", "WIDTH", "HEIGHT", "SAVE", "LPAREN", "RPAREN", "COMMA"
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
			setState(11); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(10);
				command();
				}
				}
				setState(13); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 526304L) != 0) );
			setState(15);
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
		public TerminalNode DRAW() { return getToken(CmdPaintParser.DRAW, 0); }
		public List<TerminalNode> NAME() { return getTokens(CmdPaintParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(CmdPaintParser.NAME, i);
		}
		public ShapeContext shape() {
			return getRuleContext(ShapeContext.class,0);
		}
		public TerminalNode COLORC() { return getToken(CmdPaintParser.COLORC, 0); }
		public TerminalNode COLOR() { return getToken(CmdPaintParser.COLOR, 0); }
		public TerminalNode ROTATE() { return getToken(CmdPaintParser.ROTATE, 0); }
		public TerminalNode INT() { return getToken(CmdPaintParser.INT, 0); }
		public TerminalNode MOVE() { return getToken(CmdPaintParser.MOVE, 0); }
		public PositionContext position() {
			return getRuleContext(PositionContext.class,0);
		}
		public TerminalNode SAVE() { return getToken(CmdPaintParser.SAVE, 0); }
		public TerminalNode DELETE() { return getToken(CmdPaintParser.DELETE, 0); }
		public TerminalNode RENAME() { return getToken(CmdPaintParser.RENAME, 0); }
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmdPaintParserListener ) ((CmdPaintParserListener)listener).exitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdPaintParserVisitor ) return ((CmdPaintParserVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_command);
		try {
			setState(36);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DRAW:
				enterOuterAlt(_localctx, 1);
				{
				setState(17);
				match(DRAW);
				setState(18);
				match(NAME);
				setState(19);
				shape();
				}
				break;
			case COLORC:
				enterOuterAlt(_localctx, 2);
				{
				setState(20);
				match(COLORC);
				setState(21);
				match(NAME);
				setState(22);
				match(COLOR);
				}
				break;
			case ROTATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(23);
				match(ROTATE);
				setState(24);
				match(NAME);
				setState(25);
				match(INT);
				}
				break;
			case MOVE:
				enterOuterAlt(_localctx, 4);
				{
				setState(26);
				match(MOVE);
				setState(27);
				match(NAME);
				setState(28);
				position();
				}
				break;
			case SAVE:
				enterOuterAlt(_localctx, 5);
				{
				setState(29);
				match(SAVE);
				setState(30);
				match(NAME);
				}
				break;
			case DELETE:
				enterOuterAlt(_localctx, 6);
				{
				setState(31);
				match(DELETE);
				setState(32);
				match(NAME);
				}
				break;
			case RENAME:
				enterOuterAlt(_localctx, 7);
				{
				setState(33);
				match(RENAME);
				setState(34);
				match(NAME);
				setState(35);
				match(NAME);
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
		public TerminalNode COLORC() { return getToken(CmdPaintParser.COLORC, 0); }
		public TerminalNode COLOR() { return getToken(CmdPaintParser.COLOR, 0); }
		public TerminalNode CIRCLE() { return getToken(CmdPaintParser.CIRCLE, 0); }
		public TerminalNode RADIUS() { return getToken(CmdPaintParser.RADIUS, 0); }
		public TerminalNode RECTANGLE() { return getToken(CmdPaintParser.RECTANGLE, 0); }
		public TerminalNode WIDTH() { return getToken(CmdPaintParser.WIDTH, 0); }
		public TerminalNode HEIGHT() { return getToken(CmdPaintParser.HEIGHT, 0); }
		public TerminalNode LINE() { return getToken(CmdPaintParser.LINE, 0); }
		public Line_posContext line_pos() {
			return getRuleContext(Line_posContext.class,0);
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
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SQUARE:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				match(SQUARE);
				setState(39);
				position();
				setState(40);
				match(SIZE);
				setState(41);
				match(INT);
				setState(44);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(42);
					match(COLORC);
					setState(43);
					match(COLOR);
					}
					break;
				}
				}
				break;
			case CIRCLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				match(CIRCLE);
				setState(47);
				position();
				setState(48);
				match(RADIUS);
				setState(49);
				match(INT);
				setState(52);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(50);
					match(COLORC);
					setState(51);
					match(COLOR);
					}
					break;
				}
				}
				break;
			case RECTANGLE:
				enterOuterAlt(_localctx, 3);
				{
				setState(54);
				match(RECTANGLE);
				setState(55);
				position();
				setState(56);
				match(WIDTH);
				setState(57);
				match(INT);
				setState(58);
				match(HEIGHT);
				setState(59);
				match(INT);
				setState(62);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(60);
					match(COLORC);
					setState(61);
					match(COLOR);
					}
					break;
				}
				}
				break;
			case LINE:
				enterOuterAlt(_localctx, 4);
				{
				setState(64);
				match(LINE);
				setState(65);
				line_pos();
				setState(68);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(66);
					match(COLORC);
					setState(67);
					match(COLOR);
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
			setState(72);
			match(LPAREN);
			setState(73);
			match(INT);
			setState(74);
			match(COMMA);
			setState(75);
			match(INT);
			setState(76);
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
		enterRule(_localctx, 8, RULE_line_pos);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(LPAREN);
			setState(79);
			match(INT);
			setState(80);
			match(COMMA);
			setState(81);
			match(INT);
			setState(82);
			match(COMMA);
			setState(83);
			match(INT);
			setState(84);
			match(COMMA);
			setState(85);
			match(INT);
			setState(86);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0016Y\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0004\u0000\f\b\u0000\u000b\u0000\f\u0000\r\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001%\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002-\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"5\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002?\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002E\b\u0002\u0003\u0002"+
		"G\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0000\u0000\u0005\u0000\u0002\u0004\u0006\b\u0000\u0000a\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0002$\u0001\u0000\u0000\u0000\u0004F\u0001\u0000"+
		"\u0000\u0000\u0006H\u0001\u0000\u0000\u0000\bN\u0001\u0000\u0000\u0000"+
		"\n\f\u0003\u0002\u0001\u0000\u000b\n\u0001\u0000\u0000\u0000\f\r\u0001"+
		"\u0000\u0000\u0000\r\u000b\u0001\u0000\u0000\u0000\r\u000e\u0001\u0000"+
		"\u0000\u0000\u000e\u000f\u0001\u0000\u0000\u0000\u000f\u0010\u0005\u0000"+
		"\u0000\u0001\u0010\u0001\u0001\u0000\u0000\u0000\u0011\u0012\u0005\u0005"+
		"\u0000\u0000\u0012\u0013\u0005\u0001\u0000\u0000\u0013%\u0003\u0004\u0002"+
		"\u0000\u0014\u0015\u0005\u0006\u0000\u0000\u0015\u0016\u0005\u0001\u0000"+
		"\u0000\u0016%\u0005\u0002\u0000\u0000\u0017\u0018\u0005\u0007\u0000\u0000"+
		"\u0018\u0019\u0005\u0001\u0000\u0000\u0019%\u0005\u0003\u0000\u0000\u001a"+
		"\u001b\u0005\b\u0000\u0000\u001b\u001c\u0005\u0001\u0000\u0000\u001c%"+
		"\u0003\u0006\u0003\u0000\u001d\u001e\u0005\u0013\u0000\u0000\u001e%\u0005"+
		"\u0001\u0000\u0000\u001f \u0005\t\u0000\u0000 %\u0005\u0001\u0000\u0000"+
		"!\"\u0005\n\u0000\u0000\"#\u0005\u0001\u0000\u0000#%\u0005\u0001\u0000"+
		"\u0000$\u0011\u0001\u0000\u0000\u0000$\u0014\u0001\u0000\u0000\u0000$"+
		"\u0017\u0001\u0000\u0000\u0000$\u001a\u0001\u0000\u0000\u0000$\u001d\u0001"+
		"\u0000\u0000\u0000$\u001f\u0001\u0000\u0000\u0000$!\u0001\u0000\u0000"+
		"\u0000%\u0003\u0001\u0000\u0000\u0000&\'\u0005\u000b\u0000\u0000\'(\u0003"+
		"\u0006\u0003\u0000()\u0005\u000f\u0000\u0000),\u0005\u0003\u0000\u0000"+
		"*+\u0005\u0006\u0000\u0000+-\u0005\u0002\u0000\u0000,*\u0001\u0000\u0000"+
		"\u0000,-\u0001\u0000\u0000\u0000-G\u0001\u0000\u0000\u0000./\u0005\f\u0000"+
		"\u0000/0\u0003\u0006\u0003\u000001\u0005\u0010\u0000\u000014\u0005\u0003"+
		"\u0000\u000023\u0005\u0006\u0000\u000035\u0005\u0002\u0000\u000042\u0001"+
		"\u0000\u0000\u000045\u0001\u0000\u0000\u00005G\u0001\u0000\u0000\u0000"+
		"67\u0005\r\u0000\u000078\u0003\u0006\u0003\u000089\u0005\u0011\u0000\u0000"+
		"9:\u0005\u0003\u0000\u0000:;\u0005\u0012\u0000\u0000;>\u0005\u0003\u0000"+
		"\u0000<=\u0005\u0006\u0000\u0000=?\u0005\u0002\u0000\u0000><\u0001\u0000"+
		"\u0000\u0000>?\u0001\u0000\u0000\u0000?G\u0001\u0000\u0000\u0000@A\u0005"+
		"\u000e\u0000\u0000AD\u0003\b\u0004\u0000BC\u0005\u0006\u0000\u0000CE\u0005"+
		"\u0002\u0000\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000"+
		"EG\u0001\u0000\u0000\u0000F&\u0001\u0000\u0000\u0000F.\u0001\u0000\u0000"+
		"\u0000F6\u0001\u0000\u0000\u0000F@\u0001\u0000\u0000\u0000G\u0005\u0001"+
		"\u0000\u0000\u0000HI\u0005\u0014\u0000\u0000IJ\u0005\u0003\u0000\u0000"+
		"JK\u0005\u0016\u0000\u0000KL\u0005\u0003\u0000\u0000LM\u0005\u0015\u0000"+
		"\u0000M\u0007\u0001\u0000\u0000\u0000NO\u0005\u0014\u0000\u0000OP\u0005"+
		"\u0003\u0000\u0000PQ\u0005\u0016\u0000\u0000QR\u0005\u0003\u0000\u0000"+
		"RS\u0005\u0016\u0000\u0000ST\u0005\u0003\u0000\u0000TU\u0005\u0016\u0000"+
		"\u0000UV\u0005\u0003\u0000\u0000VW\u0005\u0015\u0000\u0000W\t\u0001\u0000"+
		"\u0000\u0000\u0007\r$,4>DF";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}