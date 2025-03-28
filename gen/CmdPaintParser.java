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
		RENAME=10, SQUARE=11, CIRCLE=12, RECTANGLE=13, POLYGON=14, LINE=15, SIZE=16, 
		RADIUS=17, WIDTH=18, HEIGHT=19, HOLLOW=20, SAVE=21, LPAREN=22, RPAREN=23, 
		COMMA=24;
	public static final int
		RULE_program = 0, RULE_command = 1, RULE_shape = 2, RULE_position = 3, 
		RULE_poly_pos = 4, RULE_line_pos = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "command", "shape", "position", "poly_pos", "line_pos"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'draw'", "'color'", "'rotate'", "'move'", 
			"'delete'", "'rename'", "'square'", "'circle'", "'rectangle'", "'polygon'", 
			"'line'", "'size'", "'radius'", "'width'", "'height'", "'hollow'", "'save'", 
			"'('", "')'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NAME", "COLOR", "INT", "WS", "DRAW", "COLORC", "ROTATE", "MOVE", 
			"DELETE", "RENAME", "SQUARE", "CIRCLE", "RECTANGLE", "POLYGON", "LINE", 
			"SIZE", "RADIUS", "WIDTH", "HEIGHT", "HOLLOW", "SAVE", "LPAREN", "RPAREN", 
			"COMMA"
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
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(12);
				command();
				}
				}
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2099168L) != 0) );
			setState(17);
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
			setState(38);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DRAW:
				enterOuterAlt(_localctx, 1);
				{
				setState(19);
				match(DRAW);
				setState(20);
				match(NAME);
				setState(21);
				shape();
				}
				break;
			case COLORC:
				enterOuterAlt(_localctx, 2);
				{
				setState(22);
				match(COLORC);
				setState(23);
				match(NAME);
				setState(24);
				match(COLOR);
				}
				break;
			case ROTATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(25);
				match(ROTATE);
				setState(26);
				match(NAME);
				setState(27);
				match(INT);
				}
				break;
			case MOVE:
				enterOuterAlt(_localctx, 4);
				{
				setState(28);
				match(MOVE);
				setState(29);
				match(NAME);
				setState(30);
				position();
				}
				break;
			case SAVE:
				enterOuterAlt(_localctx, 5);
				{
				setState(31);
				match(SAVE);
				setState(32);
				match(NAME);
				}
				break;
			case DELETE:
				enterOuterAlt(_localctx, 6);
				{
				setState(33);
				match(DELETE);
				setState(34);
				match(NAME);
				}
				break;
			case RENAME:
				enterOuterAlt(_localctx, 7);
				{
				setState(35);
				match(RENAME);
				setState(36);
				match(NAME);
				setState(37);
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
		public TerminalNode HOLLOW() { return getToken(CmdPaintParser.HOLLOW, 0); }
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
			setState(94);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SQUARE:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				match(SQUARE);
				setState(41);
				position();
				setState(42);
				match(SIZE);
				setState(43);
				match(INT);
				setState(46);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(44);
					match(COLORC);
					setState(45);
					match(COLOR);
					}
					break;
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==HOLLOW) {
					{
					setState(48);
					match(HOLLOW);
					}
				}

				}
				break;
			case CIRCLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				match(CIRCLE);
				setState(52);
				position();
				setState(53);
				match(RADIUS);
				setState(54);
				match(INT);
				setState(57);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(55);
					match(COLORC);
					setState(56);
					match(COLOR);
					}
					break;
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==HOLLOW) {
					{
					setState(59);
					match(HOLLOW);
					}
				}

				}
				break;
			case RECTANGLE:
				enterOuterAlt(_localctx, 3);
				{
				setState(62);
				match(RECTANGLE);
				setState(63);
				position();
				setState(64);
				match(WIDTH);
				setState(65);
				match(INT);
				setState(66);
				match(HEIGHT);
				setState(67);
				match(INT);
				setState(70);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(68);
					match(COLORC);
					setState(69);
					match(COLOR);
					}
					break;
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==HOLLOW) {
					{
					setState(72);
					match(HOLLOW);
					}
				}

				}
				break;
			case LINE:
				enterOuterAlt(_localctx, 4);
				{
				setState(75);
				match(LINE);
				setState(76);
				line_pos();
				setState(79);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(77);
					match(COLORC);
					setState(78);
					match(COLOR);
					}
					break;
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==HOLLOW) {
					{
					setState(81);
					match(HOLLOW);
					}
				}

				}
				break;
			case POLYGON:
				enterOuterAlt(_localctx, 5);
				{
				setState(84);
				match(POLYGON);
				setState(85);
				poly_pos();
				setState(86);
				poly_pos();
				setState(89);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(87);
					match(COLORC);
					setState(88);
					match(COLOR);
					}
					break;
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==HOLLOW) {
					{
					setState(91);
					match(HOLLOW);
					}
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
			setState(96);
			match(LPAREN);
			setState(97);
			match(INT);
			setState(98);
			match(COMMA);
			setState(99);
			match(INT);
			setState(100);
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
			setState(102);
			match(LPAREN);
			setState(105); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(103);
					match(INT);
					setState(104);
					match(COMMA);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(107); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(109);
			match(INT);
			setState(110);
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
			setState(112);
			match(LPAREN);
			setState(113);
			match(INT);
			setState(114);
			match(COMMA);
			setState(115);
			match(INT);
			setState(116);
			match(COMMA);
			setState(117);
			match(INT);
			setState(118);
			match(COMMA);
			setState(119);
			match(INT);
			setState(120);
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
		"\u0004\u0001\u0018{\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0004\u0000\u000e\b\u0000\u000b\u0000\f"+
		"\u0000\u000f\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\'\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002/\b\u0002\u0001\u0002\u0003\u00022\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002:\b"+
		"\u0002\u0001\u0002\u0003\u0002=\b\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002G\b\u0002\u0001\u0002\u0003\u0002J\b\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002P\b\u0002\u0001\u0002\u0003\u0002"+
		"S\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002Z\b\u0002\u0001\u0002\u0003\u0002]\b\u0002\u0003\u0002_\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004j\b\u0004\u000b"+
		"\u0004\f\u0004k\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0000\u0000\u0006\u0000\u0002"+
		"\u0004\u0006\b\n\u0000\u0000\u008a\u0000\r\u0001\u0000\u0000\u0000\u0002"+
		"&\u0001\u0000\u0000\u0000\u0004^\u0001\u0000\u0000\u0000\u0006`\u0001"+
		"\u0000\u0000\u0000\bf\u0001\u0000\u0000\u0000\np\u0001\u0000\u0000\u0000"+
		"\f\u000e\u0003\u0002\u0001\u0000\r\f\u0001\u0000\u0000\u0000\u000e\u000f"+
		"\u0001\u0000\u0000\u0000\u000f\r\u0001\u0000\u0000\u0000\u000f\u0010\u0001"+
		"\u0000\u0000\u0000\u0010\u0011\u0001\u0000\u0000\u0000\u0011\u0012\u0005"+
		"\u0000\u0000\u0001\u0012\u0001\u0001\u0000\u0000\u0000\u0013\u0014\u0005"+
		"\u0005\u0000\u0000\u0014\u0015\u0005\u0001\u0000\u0000\u0015\'\u0003\u0004"+
		"\u0002\u0000\u0016\u0017\u0005\u0006\u0000\u0000\u0017\u0018\u0005\u0001"+
		"\u0000\u0000\u0018\'\u0005\u0002\u0000\u0000\u0019\u001a\u0005\u0007\u0000"+
		"\u0000\u001a\u001b\u0005\u0001\u0000\u0000\u001b\'\u0005\u0003\u0000\u0000"+
		"\u001c\u001d\u0005\b\u0000\u0000\u001d\u001e\u0005\u0001\u0000\u0000\u001e"+
		"\'\u0003\u0006\u0003\u0000\u001f \u0005\u0015\u0000\u0000 \'\u0005\u0001"+
		"\u0000\u0000!\"\u0005\t\u0000\u0000\"\'\u0005\u0001\u0000\u0000#$\u0005"+
		"\n\u0000\u0000$%\u0005\u0001\u0000\u0000%\'\u0005\u0001\u0000\u0000&\u0013"+
		"\u0001\u0000\u0000\u0000&\u0016\u0001\u0000\u0000\u0000&\u0019\u0001\u0000"+
		"\u0000\u0000&\u001c\u0001\u0000\u0000\u0000&\u001f\u0001\u0000\u0000\u0000"+
		"&!\u0001\u0000\u0000\u0000&#\u0001\u0000\u0000\u0000\'\u0003\u0001\u0000"+
		"\u0000\u0000()\u0005\u000b\u0000\u0000)*\u0003\u0006\u0003\u0000*+\u0005"+
		"\u0010\u0000\u0000+.\u0005\u0003\u0000\u0000,-\u0005\u0006\u0000\u0000"+
		"-/\u0005\u0002\u0000\u0000.,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000"+
		"\u0000/1\u0001\u0000\u0000\u000002\u0005\u0014\u0000\u000010\u0001\u0000"+
		"\u0000\u000012\u0001\u0000\u0000\u00002_\u0001\u0000\u0000\u000034\u0005"+
		"\f\u0000\u000045\u0003\u0006\u0003\u000056\u0005\u0011\u0000\u000069\u0005"+
		"\u0003\u0000\u000078\u0005\u0006\u0000\u00008:\u0005\u0002\u0000\u0000"+
		"97\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:<\u0001\u0000\u0000"+
		"\u0000;=\u0005\u0014\u0000\u0000<;\u0001\u0000\u0000\u0000<=\u0001\u0000"+
		"\u0000\u0000=_\u0001\u0000\u0000\u0000>?\u0005\r\u0000\u0000?@\u0003\u0006"+
		"\u0003\u0000@A\u0005\u0012\u0000\u0000AB\u0005\u0003\u0000\u0000BC\u0005"+
		"\u0013\u0000\u0000CF\u0005\u0003\u0000\u0000DE\u0005\u0006\u0000\u0000"+
		"EG\u0005\u0002\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000"+
		"\u0000GI\u0001\u0000\u0000\u0000HJ\u0005\u0014\u0000\u0000IH\u0001\u0000"+
		"\u0000\u0000IJ\u0001\u0000\u0000\u0000J_\u0001\u0000\u0000\u0000KL\u0005"+
		"\u000f\u0000\u0000LO\u0003\n\u0005\u0000MN\u0005\u0006\u0000\u0000NP\u0005"+
		"\u0002\u0000\u0000OM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000"+
		"PR\u0001\u0000\u0000\u0000QS\u0005\u0014\u0000\u0000RQ\u0001\u0000\u0000"+
		"\u0000RS\u0001\u0000\u0000\u0000S_\u0001\u0000\u0000\u0000TU\u0005\u000e"+
		"\u0000\u0000UV\u0003\b\u0004\u0000VY\u0003\b\u0004\u0000WX\u0005\u0006"+
		"\u0000\u0000XZ\u0005\u0002\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001"+
		"\u0000\u0000\u0000Z\\\u0001\u0000\u0000\u0000[]\u0005\u0014\u0000\u0000"+
		"\\[\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]_\u0001\u0000\u0000"+
		"\u0000^(\u0001\u0000\u0000\u0000^3\u0001\u0000\u0000\u0000^>\u0001\u0000"+
		"\u0000\u0000^K\u0001\u0000\u0000\u0000^T\u0001\u0000\u0000\u0000_\u0005"+
		"\u0001\u0000\u0000\u0000`a\u0005\u0016\u0000\u0000ab\u0005\u0003\u0000"+
		"\u0000bc\u0005\u0018\u0000\u0000cd\u0005\u0003\u0000\u0000de\u0005\u0017"+
		"\u0000\u0000e\u0007\u0001\u0000\u0000\u0000fi\u0005\u0016\u0000\u0000"+
		"gh\u0005\u0003\u0000\u0000hj\u0005\u0018\u0000\u0000ig\u0001\u0000\u0000"+
		"\u0000jk\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000kl\u0001\u0000"+
		"\u0000\u0000lm\u0001\u0000\u0000\u0000mn\u0005\u0003\u0000\u0000no\u0005"+
		"\u0017\u0000\u0000o\t\u0001\u0000\u0000\u0000pq\u0005\u0016\u0000\u0000"+
		"qr\u0005\u0003\u0000\u0000rs\u0005\u0018\u0000\u0000st\u0005\u0003\u0000"+
		"\u0000tu\u0005\u0018\u0000\u0000uv\u0005\u0003\u0000\u0000vw\u0005\u0018"+
		"\u0000\u0000wx\u0005\u0003\u0000\u0000xy\u0005\u0017\u0000\u0000y\u000b"+
		"\u0001\u0000\u0000\u0000\u000e\u000f&.19<FIORY\\^k";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}