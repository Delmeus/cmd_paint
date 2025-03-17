// Generated from G:/Projekty_Studia/MiASI/cmdPaint/src/CmdPaintLexer.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CmdPaintLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NAME=1, COLOR=2, INT=3, WS=4, DRAW=5, COLORC=6, ROTATE=7, MOVE=8, SQUARE=9, 
		CIRCLE=10, RECTANGLE=11, LINE=12, SIZE=13, RADIUS=14, WIDTH=15, HEIGHT=16, 
		SAVE=17, LPAREN=18, RPAREN=19, COMMA=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NAME", "COLOR", "INT", "WS", "DRAW", "COLORC", "ROTATE", "MOVE", "SQUARE", 
			"CIRCLE", "RECTANGLE", "LINE", "SIZE", "RADIUS", "WIDTH", "HEIGHT", "SAVE", 
			"LPAREN", "RPAREN", "COMMA"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'draw'", "'color'", "'rotate'", "'move'", 
			"'square'", "'circle'", "'rectangle'", "'line'", "'size'", "'radius'", 
			"'width'", "'height'", "'save'", "'('", "')'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NAME", "COLOR", "INT", "WS", "DRAW", "COLORC", "ROTATE", "MOVE", 
			"SQUARE", "CIRCLE", "RECTANGLE", "LINE", "SIZE", "RADIUS", "WIDTH", "HEIGHT", 
			"SAVE", "LPAREN", "RPAREN", "COMMA"
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


	public CmdPaintLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CmdPaintLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0014\u00b5\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0005\u0000-\b\u0000\n\u0000\f\u00000\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"P\b\u0001\u0001\u0002\u0004\u0002S\b\u0002\u000b\u0002\f\u0002T\u0001"+
		"\u0003\u0004\u0003X\b\u0003\u000b\u0003\f\u0003Y\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0000\u0000\u0014\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014\u0001\u0000\u0004\u0003"+
		"\u0000AZ__az\u0004\u000009AZ__az\u0001\u000009\u0003\u0000\t\n\r\r  \u00bc"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0001)\u0001\u0000\u0000\u0000"+
		"\u0003O\u0001\u0000\u0000\u0000\u0005R\u0001\u0000\u0000\u0000\u0007W"+
		"\u0001\u0000\u0000\u0000\t]\u0001\u0000\u0000\u0000\u000bb\u0001\u0000"+
		"\u0000\u0000\rh\u0001\u0000\u0000\u0000\u000fo\u0001\u0000\u0000\u0000"+
		"\u0011t\u0001\u0000\u0000\u0000\u0013{\u0001\u0000\u0000\u0000\u0015\u0082"+
		"\u0001\u0000\u0000\u0000\u0017\u008c\u0001\u0000\u0000\u0000\u0019\u0091"+
		"\u0001\u0000\u0000\u0000\u001b\u0096\u0001\u0000\u0000\u0000\u001d\u009d"+
		"\u0001\u0000\u0000\u0000\u001f\u00a3\u0001\u0000\u0000\u0000!\u00aa\u0001"+
		"\u0000\u0000\u0000#\u00af\u0001\u0000\u0000\u0000%\u00b1\u0001\u0000\u0000"+
		"\u0000\'\u00b3\u0001\u0000\u0000\u0000)*\u0005\"\u0000\u0000*.\u0007\u0000"+
		"\u0000\u0000+-\u0007\u0001\u0000\u0000,+\u0001\u0000\u0000\u0000-0\u0001"+
		"\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000"+
		"/1\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u000012\u0005\"\u0000\u0000"+
		"2\u0002\u0001\u0000\u0000\u000034\u0005r\u0000\u000045\u0005e\u0000\u0000"+
		"5P\u0005d\u0000\u000067\u0005g\u0000\u000078\u0005r\u0000\u000089\u0005"+
		"e\u0000\u00009:\u0005e\u0000\u0000:P\u0005n\u0000\u0000;<\u0005b\u0000"+
		"\u0000<=\u0005l\u0000\u0000=>\u0005u\u0000\u0000>P\u0005e\u0000\u0000"+
		"?@\u0005y\u0000\u0000@A\u0005e\u0000\u0000AB\u0005l\u0000\u0000BC\u0005"+
		"l\u0000\u0000CD\u0005o\u0000\u0000DP\u0005w\u0000\u0000EF\u0005b\u0000"+
		"\u0000FG\u0005l\u0000\u0000GH\u0005a\u0000\u0000HI\u0005c\u0000\u0000"+
		"IP\u0005k\u0000\u0000JK\u0005w\u0000\u0000KL\u0005h\u0000\u0000LM\u0005"+
		"i\u0000\u0000MN\u0005t\u0000\u0000NP\u0005e\u0000\u0000O3\u0001\u0000"+
		"\u0000\u0000O6\u0001\u0000\u0000\u0000O;\u0001\u0000\u0000\u0000O?\u0001"+
		"\u0000\u0000\u0000OE\u0001\u0000\u0000\u0000OJ\u0001\u0000\u0000\u0000"+
		"P\u0004\u0001\u0000\u0000\u0000QS\u0007\u0002\u0000\u0000RQ\u0001\u0000"+
		"\u0000\u0000ST\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000TU\u0001"+
		"\u0000\u0000\u0000U\u0006\u0001\u0000\u0000\u0000VX\u0007\u0003\u0000"+
		"\u0000WV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YW\u0001\u0000"+
		"\u0000\u0000YZ\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[\\\u0006"+
		"\u0003\u0000\u0000\\\b\u0001\u0000\u0000\u0000]^\u0005d\u0000\u0000^_"+
		"\u0005r\u0000\u0000_`\u0005a\u0000\u0000`a\u0005w\u0000\u0000a\n\u0001"+
		"\u0000\u0000\u0000bc\u0005c\u0000\u0000cd\u0005o\u0000\u0000de\u0005l"+
		"\u0000\u0000ef\u0005o\u0000\u0000fg\u0005r\u0000\u0000g\f\u0001\u0000"+
		"\u0000\u0000hi\u0005r\u0000\u0000ij\u0005o\u0000\u0000jk\u0005t\u0000"+
		"\u0000kl\u0005a\u0000\u0000lm\u0005t\u0000\u0000mn\u0005e\u0000\u0000"+
		"n\u000e\u0001\u0000\u0000\u0000op\u0005m\u0000\u0000pq\u0005o\u0000\u0000"+
		"qr\u0005v\u0000\u0000rs\u0005e\u0000\u0000s\u0010\u0001\u0000\u0000\u0000"+
		"tu\u0005s\u0000\u0000uv\u0005q\u0000\u0000vw\u0005u\u0000\u0000wx\u0005"+
		"a\u0000\u0000xy\u0005r\u0000\u0000yz\u0005e\u0000\u0000z\u0012\u0001\u0000"+
		"\u0000\u0000{|\u0005c\u0000\u0000|}\u0005i\u0000\u0000}~\u0005r\u0000"+
		"\u0000~\u007f\u0005c\u0000\u0000\u007f\u0080\u0005l\u0000\u0000\u0080"+
		"\u0081\u0005e\u0000\u0000\u0081\u0014\u0001\u0000\u0000\u0000\u0082\u0083"+
		"\u0005r\u0000\u0000\u0083\u0084\u0005e\u0000\u0000\u0084\u0085\u0005c"+
		"\u0000\u0000\u0085\u0086\u0005t\u0000\u0000\u0086\u0087\u0005a\u0000\u0000"+
		"\u0087\u0088\u0005n\u0000\u0000\u0088\u0089\u0005g\u0000\u0000\u0089\u008a"+
		"\u0005l\u0000\u0000\u008a\u008b\u0005e\u0000\u0000\u008b\u0016\u0001\u0000"+
		"\u0000\u0000\u008c\u008d\u0005l\u0000\u0000\u008d\u008e\u0005i\u0000\u0000"+
		"\u008e\u008f\u0005n\u0000\u0000\u008f\u0090\u0005e\u0000\u0000\u0090\u0018"+
		"\u0001\u0000\u0000\u0000\u0091\u0092\u0005s\u0000\u0000\u0092\u0093\u0005"+
		"i\u0000\u0000\u0093\u0094\u0005z\u0000\u0000\u0094\u0095\u0005e\u0000"+
		"\u0000\u0095\u001a\u0001\u0000\u0000\u0000\u0096\u0097\u0005r\u0000\u0000"+
		"\u0097\u0098\u0005a\u0000\u0000\u0098\u0099\u0005d\u0000\u0000\u0099\u009a"+
		"\u0005i\u0000\u0000\u009a\u009b\u0005u\u0000\u0000\u009b\u009c\u0005s"+
		"\u0000\u0000\u009c\u001c\u0001\u0000\u0000\u0000\u009d\u009e\u0005w\u0000"+
		"\u0000\u009e\u009f\u0005i\u0000\u0000\u009f\u00a0\u0005d\u0000\u0000\u00a0"+
		"\u00a1\u0005t\u0000\u0000\u00a1\u00a2\u0005h\u0000\u0000\u00a2\u001e\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a4\u0005h\u0000\u0000\u00a4\u00a5\u0005e\u0000"+
		"\u0000\u00a5\u00a6\u0005i\u0000\u0000\u00a6\u00a7\u0005g\u0000\u0000\u00a7"+
		"\u00a8\u0005h\u0000\u0000\u00a8\u00a9\u0005t\u0000\u0000\u00a9 \u0001"+
		"\u0000\u0000\u0000\u00aa\u00ab\u0005s\u0000\u0000\u00ab\u00ac\u0005a\u0000"+
		"\u0000\u00ac\u00ad\u0005v\u0000\u0000\u00ad\u00ae\u0005e\u0000\u0000\u00ae"+
		"\"\u0001\u0000\u0000\u0000\u00af\u00b0\u0005(\u0000\u0000\u00b0$\u0001"+
		"\u0000\u0000\u0000\u00b1\u00b2\u0005)\u0000\u0000\u00b2&\u0001\u0000\u0000"+
		"\u0000\u00b3\u00b4\u0005,\u0000\u0000\u00b4(\u0001\u0000\u0000\u0000\u0005"+
		"\u0000.OTY\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}