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
		LPAREN=17, RPAREN=18, COMMA=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NAME", "COLOR", "INT", "WS", "DRAW", "COLORC", "ROTATE", "MOVE", "SQUARE", 
			"CIRCLE", "RECTANGLE", "LINE", "SIZE", "RADIUS", "WIDTH", "HEIGHT", "LPAREN", 
			"RPAREN", "COMMA"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'draw'", "'color'", "'rotate'", "'move'", 
			"'square'", "'circle'", "'rectangle'", "'line'", "'size'", "'radius'", 
			"'width'", "'height'", "'('", "')'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NAME", "COLOR", "INT", "WS", "DRAW", "COLORC", "ROTATE", "MOVE", 
			"SQUARE", "CIRCLE", "RECTANGLE", "LINE", "SIZE", "RADIUS", "WIDTH", "HEIGHT", 
			"LPAREN", "RPAREN", "COMMA"
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
		"\u0004\u0000\u0013\u00ae\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000"+
		"+\b\u0000\n\u0000\f\u0000.\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001N\b\u0001\u0001\u0002"+
		"\u0004\u0002Q\b\u0002\u000b\u0002\f\u0002R\u0001\u0003\u0004\u0003V\b"+
		"\u0003\u000b\u0003\f\u0003W\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0000\u0000\u0013\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011#\u0012%\u0013\u0001\u0000\u0004\u0003\u0000AZ__az"+
		"\u0004\u000009AZ__az\u0001\u000009\u0003\u0000\t\n\r\r  \u00b5\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000"+
		"\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000"+
		"\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0001"+
		"\'\u0001\u0000\u0000\u0000\u0003M\u0001\u0000\u0000\u0000\u0005P\u0001"+
		"\u0000\u0000\u0000\u0007U\u0001\u0000\u0000\u0000\t[\u0001\u0000\u0000"+
		"\u0000\u000b`\u0001\u0000\u0000\u0000\rf\u0001\u0000\u0000\u0000\u000f"+
		"m\u0001\u0000\u0000\u0000\u0011r\u0001\u0000\u0000\u0000\u0013y\u0001"+
		"\u0000\u0000\u0000\u0015\u0080\u0001\u0000\u0000\u0000\u0017\u008a\u0001"+
		"\u0000\u0000\u0000\u0019\u008f\u0001\u0000\u0000\u0000\u001b\u0094\u0001"+
		"\u0000\u0000\u0000\u001d\u009b\u0001\u0000\u0000\u0000\u001f\u00a1\u0001"+
		"\u0000\u0000\u0000!\u00a8\u0001\u0000\u0000\u0000#\u00aa\u0001\u0000\u0000"+
		"\u0000%\u00ac\u0001\u0000\u0000\u0000\'(\u0005\"\u0000\u0000(,\u0007\u0000"+
		"\u0000\u0000)+\u0007\u0001\u0000\u0000*)\u0001\u0000\u0000\u0000+.\u0001"+
		"\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000"+
		"-/\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000/0\u0005\"\u0000\u0000"+
		"0\u0002\u0001\u0000\u0000\u000012\u0005r\u0000\u000023\u0005e\u0000\u0000"+
		"3N\u0005d\u0000\u000045\u0005g\u0000\u000056\u0005r\u0000\u000067\u0005"+
		"e\u0000\u000078\u0005e\u0000\u00008N\u0005n\u0000\u00009:\u0005b\u0000"+
		"\u0000:;\u0005l\u0000\u0000;<\u0005u\u0000\u0000<N\u0005e\u0000\u0000"+
		"=>\u0005y\u0000\u0000>?\u0005e\u0000\u0000?@\u0005l\u0000\u0000@A\u0005"+
		"l\u0000\u0000AB\u0005o\u0000\u0000BN\u0005w\u0000\u0000CD\u0005b\u0000"+
		"\u0000DE\u0005l\u0000\u0000EF\u0005a\u0000\u0000FG\u0005c\u0000\u0000"+
		"GN\u0005k\u0000\u0000HI\u0005w\u0000\u0000IJ\u0005h\u0000\u0000JK\u0005"+
		"i\u0000\u0000KL\u0005t\u0000\u0000LN\u0005e\u0000\u0000M1\u0001\u0000"+
		"\u0000\u0000M4\u0001\u0000\u0000\u0000M9\u0001\u0000\u0000\u0000M=\u0001"+
		"\u0000\u0000\u0000MC\u0001\u0000\u0000\u0000MH\u0001\u0000\u0000\u0000"+
		"N\u0004\u0001\u0000\u0000\u0000OQ\u0007\u0002\u0000\u0000PO\u0001\u0000"+
		"\u0000\u0000QR\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001"+
		"\u0000\u0000\u0000S\u0006\u0001\u0000\u0000\u0000TV\u0007\u0003\u0000"+
		"\u0000UT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WU\u0001\u0000"+
		"\u0000\u0000WX\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YZ\u0006"+
		"\u0003\u0000\u0000Z\b\u0001\u0000\u0000\u0000[\\\u0005d\u0000\u0000\\"+
		"]\u0005r\u0000\u0000]^\u0005a\u0000\u0000^_\u0005w\u0000\u0000_\n\u0001"+
		"\u0000\u0000\u0000`a\u0005c\u0000\u0000ab\u0005o\u0000\u0000bc\u0005l"+
		"\u0000\u0000cd\u0005o\u0000\u0000de\u0005r\u0000\u0000e\f\u0001\u0000"+
		"\u0000\u0000fg\u0005r\u0000\u0000gh\u0005o\u0000\u0000hi\u0005t\u0000"+
		"\u0000ij\u0005a\u0000\u0000jk\u0005t\u0000\u0000kl\u0005e\u0000\u0000"+
		"l\u000e\u0001\u0000\u0000\u0000mn\u0005m\u0000\u0000no\u0005o\u0000\u0000"+
		"op\u0005v\u0000\u0000pq\u0005e\u0000\u0000q\u0010\u0001\u0000\u0000\u0000"+
		"rs\u0005s\u0000\u0000st\u0005q\u0000\u0000tu\u0005u\u0000\u0000uv\u0005"+
		"a\u0000\u0000vw\u0005r\u0000\u0000wx\u0005e\u0000\u0000x\u0012\u0001\u0000"+
		"\u0000\u0000yz\u0005c\u0000\u0000z{\u0005i\u0000\u0000{|\u0005r\u0000"+
		"\u0000|}\u0005c\u0000\u0000}~\u0005l\u0000\u0000~\u007f\u0005e\u0000\u0000"+
		"\u007f\u0014\u0001\u0000\u0000\u0000\u0080\u0081\u0005r\u0000\u0000\u0081"+
		"\u0082\u0005e\u0000\u0000\u0082\u0083\u0005c\u0000\u0000\u0083\u0084\u0005"+
		"t\u0000\u0000\u0084\u0085\u0005a\u0000\u0000\u0085\u0086\u0005n\u0000"+
		"\u0000\u0086\u0087\u0005g\u0000\u0000\u0087\u0088\u0005l\u0000\u0000\u0088"+
		"\u0089\u0005e\u0000\u0000\u0089\u0016\u0001\u0000\u0000\u0000\u008a\u008b"+
		"\u0005l\u0000\u0000\u008b\u008c\u0005i\u0000\u0000\u008c\u008d\u0005n"+
		"\u0000\u0000\u008d\u008e\u0005e\u0000\u0000\u008e\u0018\u0001\u0000\u0000"+
		"\u0000\u008f\u0090\u0005s\u0000\u0000\u0090\u0091\u0005i\u0000\u0000\u0091"+
		"\u0092\u0005z\u0000\u0000\u0092\u0093\u0005e\u0000\u0000\u0093\u001a\u0001"+
		"\u0000\u0000\u0000\u0094\u0095\u0005r\u0000\u0000\u0095\u0096\u0005a\u0000"+
		"\u0000\u0096\u0097\u0005d\u0000\u0000\u0097\u0098\u0005i\u0000\u0000\u0098"+
		"\u0099\u0005u\u0000\u0000\u0099\u009a\u0005s\u0000\u0000\u009a\u001c\u0001"+
		"\u0000\u0000\u0000\u009b\u009c\u0005w\u0000\u0000\u009c\u009d\u0005i\u0000"+
		"\u0000\u009d\u009e\u0005d\u0000\u0000\u009e\u009f\u0005t\u0000\u0000\u009f"+
		"\u00a0\u0005h\u0000\u0000\u00a0\u001e\u0001\u0000\u0000\u0000\u00a1\u00a2"+
		"\u0005h\u0000\u0000\u00a2\u00a3\u0005e\u0000\u0000\u00a3\u00a4\u0005i"+
		"\u0000\u0000\u00a4\u00a5\u0005g\u0000\u0000\u00a5\u00a6\u0005h\u0000\u0000"+
		"\u00a6\u00a7\u0005t\u0000\u0000\u00a7 \u0001\u0000\u0000\u0000\u00a8\u00a9"+
		"\u0005(\u0000\u0000\u00a9\"\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005"+
		")\u0000\u0000\u00ab$\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005,\u0000"+
		"\u0000\u00ad&\u0001\u0000\u0000\u0000\u0005\u0000,MRW\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}