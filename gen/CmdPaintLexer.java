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
		NAME=1, INT=2, WS=3, DRAW=4, DEFINE=5, COLORC=6, ROTATE=7, MOVE=8, DELETE=9, 
		BACKGROUND=10, SHOW_NAMES=11, RENAME=12, FILL=13, SQUARE=14, CIRCLE=15, 
		RECTANGLE=16, POLYGON=17, LINE=18, SIZE=19, RADIUS=20, WIDTH=21, HEIGHT=22, 
		HOLLOW=23, SAVE=24, LPAREN=25, RPAREN=26, COMMA=27, COLOR=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NAME", "INT", "WS", "DRAW", "DEFINE", "COLORC", "ROTATE", "MOVE", "DELETE", 
			"BACKGROUND", "SHOW_NAMES", "RENAME", "FILL", "SQUARE", "CIRCLE", "RECTANGLE", 
			"POLYGON", "LINE", "SIZE", "RADIUS", "WIDTH", "HEIGHT", "HOLLOW", "SAVE", 
			"LPAREN", "RPAREN", "COMMA", "COLOR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'color'", null, null, null, null, 
			"'names'", null, "'fill'", null, null, null, null, "'line'", null, null, 
			null, null, "'hollow'", "'save'", "'('", "')'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NAME", "INT", "WS", "DRAW", "DEFINE", "COLORC", "ROTATE", "MOVE", 
			"DELETE", "BACKGROUND", "SHOW_NAMES", "RENAME", "FILL", "SQUARE", "CIRCLE", 
			"RECTANGLE", "POLYGON", "LINE", "SIZE", "RADIUS", "WIDTH", "HEIGHT", 
			"HOLLOW", "SAVE", "LPAREN", "RPAREN", "COMMA", "COLOR"
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
		"\u0004\u0000\u001c\u012b\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000"+
		"=\b\u0000\n\u0000\f\u0000@\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0003\u0001E\b\u0001\u0001\u0001\u0004\u0001H\b\u0001\u000b\u0001\f\u0001"+
		"I\u0001\u0002\u0004\u0002M\b\u0002\u000b\u0002\f\u0002N\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003X\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004c\b"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006v\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007~\b\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0091\b\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0003\t\u00a2\b\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u00b4\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00c3\b\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00cf\b\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0003\u000f\u00de\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u00eb\b\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u00f7\b\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0100"+
		"\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0003\u0014\u0108\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0111\b\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001b\u0001\u001b\u0005\u001b\u0127\b\u001b\n\u001b\f\u001b\u012a\t\u001b"+
		"\u0000\u0000\u001c\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019"+
		"\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015"+
		"+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c\u0001\u0000\u0004\u0003"+
		"\u0000AZ__az\u0004\u000009AZ__az\u0001\u000009\u0003\u0000\t\n\r\r  \u0142"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/"+
		"\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000"+
		"\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000"+
		"\u00019\u0001\u0000\u0000\u0000\u0003D\u0001\u0000\u0000\u0000\u0005L"+
		"\u0001\u0000\u0000\u0000\u0007W\u0001\u0000\u0000\u0000\tb\u0001\u0000"+
		"\u0000\u0000\u000bd\u0001\u0000\u0000\u0000\ru\u0001\u0000\u0000\u0000"+
		"\u000f}\u0001\u0000\u0000\u0000\u0011\u0090\u0001\u0000\u0000\u0000\u0013"+
		"\u00a1\u0001\u0000\u0000\u0000\u0015\u00a3\u0001\u0000\u0000\u0000\u0017"+
		"\u00b3\u0001\u0000\u0000\u0000\u0019\u00b5\u0001\u0000\u0000\u0000\u001b"+
		"\u00c2\u0001\u0000\u0000\u0000\u001d\u00ce\u0001\u0000\u0000\u0000\u001f"+
		"\u00dd\u0001\u0000\u0000\u0000!\u00ea\u0001\u0000\u0000\u0000#\u00ec\u0001"+
		"\u0000\u0000\u0000%\u00f6\u0001\u0000\u0000\u0000\'\u00ff\u0001\u0000"+
		"\u0000\u0000)\u0107\u0001\u0000\u0000\u0000+\u0110\u0001\u0000\u0000\u0000"+
		"-\u0112\u0001\u0000\u0000\u0000/\u0119\u0001\u0000\u0000\u00001\u011e"+
		"\u0001\u0000\u0000\u00003\u0120\u0001\u0000\u0000\u00005\u0122\u0001\u0000"+
		"\u0000\u00007\u0124\u0001\u0000\u0000\u00009:\u0005\"\u0000\u0000:>\u0007"+
		"\u0000\u0000\u0000;=\u0007\u0001\u0000\u0000<;\u0001\u0000\u0000\u0000"+
		"=@\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000"+
		"\u0000?A\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000AB\u0005\"\u0000"+
		"\u0000B\u0002\u0001\u0000\u0000\u0000CE\u0005-\u0000\u0000DC\u0001\u0000"+
		"\u0000\u0000DE\u0001\u0000\u0000\u0000EG\u0001\u0000\u0000\u0000FH\u0007"+
		"\u0002\u0000\u0000GF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000"+
		"IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000J\u0004\u0001\u0000"+
		"\u0000\u0000KM\u0007\u0003\u0000\u0000LK\u0001\u0000\u0000\u0000MN\u0001"+
		"\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000"+
		"OP\u0001\u0000\u0000\u0000PQ\u0006\u0002\u0000\u0000Q\u0006\u0001\u0000"+
		"\u0000\u0000RS\u0005d\u0000\u0000ST\u0005r\u0000\u0000TU\u0005a\u0000"+
		"\u0000UX\u0005w\u0000\u0000VX\u0005d\u0000\u0000WR\u0001\u0000\u0000\u0000"+
		"WV\u0001\u0000\u0000\u0000X\b\u0001\u0000\u0000\u0000YZ\u0005d\u0000\u0000"+
		"Z[\u0005e\u0000\u0000[\\\u0005f\u0000\u0000\\]\u0005i\u0000\u0000]^\u0005"+
		"n\u0000\u0000^c\u0005e\u0000\u0000_`\u0005d\u0000\u0000`a\u0005e\u0000"+
		"\u0000ac\u0005f\u0000\u0000bY\u0001\u0000\u0000\u0000b_\u0001\u0000\u0000"+
		"\u0000c\n\u0001\u0000\u0000\u0000de\u0005c\u0000\u0000ef\u0005o\u0000"+
		"\u0000fg\u0005l\u0000\u0000gh\u0005o\u0000\u0000hi\u0005r\u0000\u0000"+
		"i\f\u0001\u0000\u0000\u0000jk\u0005r\u0000\u0000kl\u0005o\u0000\u0000"+
		"lm\u0005t\u0000\u0000mn\u0005a\u0000\u0000no\u0005t\u0000\u0000ov\u0005"+
		"e\u0000\u0000pq\u0005r\u0000\u0000qr\u0005o\u0000\u0000rv\u0005t\u0000"+
		"\u0000st\u0005r\u0000\u0000tv\u0005t\u0000\u0000uj\u0001\u0000\u0000\u0000"+
		"up\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000v\u000e\u0001\u0000"+
		"\u0000\u0000wx\u0005m\u0000\u0000xy\u0005o\u0000\u0000yz\u0005v\u0000"+
		"\u0000z~\u0005e\u0000\u0000{|\u0005m\u0000\u0000|~\u0005v\u0000\u0000"+
		"}w\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000~\u0010\u0001\u0000"+
		"\u0000\u0000\u007f\u0080\u0005d\u0000\u0000\u0080\u0081\u0005e\u0000\u0000"+
		"\u0081\u0082\u0005l\u0000\u0000\u0082\u0083\u0005e\u0000\u0000\u0083\u0084"+
		"\u0005t\u0000\u0000\u0084\u0091\u0005e\u0000\u0000\u0085\u0086\u0005d"+
		"\u0000\u0000\u0086\u0087\u0005e\u0000\u0000\u0087\u0091\u0005l\u0000\u0000"+
		"\u0088\u0089\u0005r\u0000\u0000\u0089\u0091\u0005m\u0000\u0000\u008a\u008b"+
		"\u0005r\u0000\u0000\u008b\u008c\u0005e\u0000\u0000\u008c\u008d\u0005m"+
		"\u0000\u0000\u008d\u008e\u0005o\u0000\u0000\u008e\u008f\u0005v\u0000\u0000"+
		"\u008f\u0091\u0005e\u0000\u0000\u0090\u007f\u0001\u0000\u0000\u0000\u0090"+
		"\u0085\u0001\u0000\u0000\u0000\u0090\u0088\u0001\u0000\u0000\u0000\u0090"+
		"\u008a\u0001\u0000\u0000\u0000\u0091\u0012\u0001\u0000\u0000\u0000\u0092"+
		"\u0093\u0005b\u0000\u0000\u0093\u0094\u0005a\u0000\u0000\u0094\u0095\u0005"+
		"c\u0000\u0000\u0095\u0096\u0005k\u0000\u0000\u0096\u0097\u0005g\u0000"+
		"\u0000\u0097\u0098\u0005r\u0000\u0000\u0098\u0099\u0005o\u0000\u0000\u0099"+
		"\u009a\u0005u\u0000\u0000\u009a\u009b\u0005n\u0000\u0000\u009b\u00a2\u0005"+
		"d\u0000\u0000\u009c\u009d\u0005b\u0000\u0000\u009d\u009e\u0005a\u0000"+
		"\u0000\u009e\u009f\u0005c\u0000\u0000\u009f\u00a2\u0005k\u0000\u0000\u00a0"+
		"\u00a2\u0005b\u0000\u0000\u00a1\u0092\u0001\u0000\u0000\u0000\u00a1\u009c"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a2\u0014"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005n\u0000\u0000\u00a4\u00a5\u0005"+
		"a\u0000\u0000\u00a5\u00a6\u0005m\u0000\u0000\u00a6\u00a7\u0005e\u0000"+
		"\u0000\u00a7\u00a8\u0005s\u0000\u0000\u00a8\u0016\u0001\u0000\u0000\u0000"+
		"\u00a9\u00aa\u0005r\u0000\u0000\u00aa\u00ab\u0005e\u0000\u0000\u00ab\u00ac"+
		"\u0005n\u0000\u0000\u00ac\u00ad\u0005a\u0000\u0000\u00ad\u00ae\u0005m"+
		"\u0000\u0000\u00ae\u00b4\u0005e\u0000\u0000\u00af\u00b0\u0005n\u0000\u0000"+
		"\u00b0\u00b1\u0005a\u0000\u0000\u00b1\u00b2\u0005m\u0000\u0000\u00b2\u00b4"+
		"\u0005e\u0000\u0000\u00b3\u00a9\u0001\u0000\u0000\u0000\u00b3\u00af\u0001"+
		"\u0000\u0000\u0000\u00b4\u0018\u0001\u0000\u0000\u0000\u00b5\u00b6\u0005"+
		"f\u0000\u0000\u00b6\u00b7\u0005i\u0000\u0000\u00b7\u00b8\u0005l\u0000"+
		"\u0000\u00b8\u00b9\u0005l\u0000\u0000\u00b9\u001a\u0001\u0000\u0000\u0000"+
		"\u00ba\u00bb\u0005s\u0000\u0000\u00bb\u00bc\u0005q\u0000\u0000\u00bc\u00bd"+
		"\u0005u\u0000\u0000\u00bd\u00be\u0005a\u0000\u0000\u00be\u00bf\u0005r"+
		"\u0000\u0000\u00bf\u00c3\u0005e\u0000\u0000\u00c0\u00c1\u0005s\u0000\u0000"+
		"\u00c1\u00c3\u0005q\u0000\u0000\u00c2\u00ba\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c0\u0001\u0000\u0000\u0000\u00c3\u001c\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c5\u0005c\u0000\u0000\u00c5\u00c6\u0005i\u0000\u0000\u00c6\u00c7\u0005"+
		"r\u0000\u0000\u00c7\u00c8\u0005c\u0000\u0000\u00c8\u00c9\u0005l\u0000"+
		"\u0000\u00c9\u00cf\u0005e\u0000\u0000\u00ca\u00cb\u0005c\u0000\u0000\u00cb"+
		"\u00cc\u0005i\u0000\u0000\u00cc\u00cd\u0005r\u0000\u0000\u00cd\u00cf\u0005"+
		"c\u0000\u0000\u00ce\u00c4\u0001\u0000\u0000\u0000\u00ce\u00ca\u0001\u0000"+
		"\u0000\u0000\u00cf\u001e\u0001\u0000\u0000\u0000\u00d0\u00d1\u0005r\u0000"+
		"\u0000\u00d1\u00d2\u0005e\u0000\u0000\u00d2\u00d3\u0005c\u0000\u0000\u00d3"+
		"\u00d4\u0005t\u0000\u0000\u00d4\u00d5\u0005a\u0000\u0000\u00d5\u00d6\u0005"+
		"n\u0000\u0000\u00d6\u00d7\u0005g\u0000\u0000\u00d7\u00d8\u0005l\u0000"+
		"\u0000\u00d8\u00de\u0005e\u0000\u0000\u00d9\u00da\u0005r\u0000\u0000\u00da"+
		"\u00db\u0005e\u0000\u0000\u00db\u00dc\u0005c\u0000\u0000\u00dc\u00de\u0005"+
		"t\u0000\u0000\u00dd\u00d0\u0001\u0000\u0000\u0000\u00dd\u00d9\u0001\u0000"+
		"\u0000\u0000\u00de \u0001\u0000\u0000\u0000\u00df\u00e0\u0005p\u0000\u0000"+
		"\u00e0\u00e1\u0005o\u0000\u0000\u00e1\u00e2\u0005l\u0000\u0000\u00e2\u00e3"+
		"\u0005y\u0000\u0000\u00e3\u00e4\u0005g\u0000\u0000\u00e4\u00e5\u0005o"+
		"\u0000\u0000\u00e5\u00eb\u0005n\u0000\u0000\u00e6\u00e7\u0005p\u0000\u0000"+
		"\u00e7\u00e8\u0005o\u0000\u0000\u00e8\u00e9\u0005l\u0000\u0000\u00e9\u00eb"+
		"\u0005y\u0000\u0000\u00ea\u00df\u0001\u0000\u0000\u0000\u00ea\u00e6\u0001"+
		"\u0000\u0000\u0000\u00eb\"\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005l"+
		"\u0000\u0000\u00ed\u00ee\u0005i\u0000\u0000\u00ee\u00ef\u0005n\u0000\u0000"+
		"\u00ef\u00f0\u0005e\u0000\u0000\u00f0$\u0001\u0000\u0000\u0000\u00f1\u00f2"+
		"\u0005s\u0000\u0000\u00f2\u00f3\u0005i\u0000\u0000\u00f3\u00f4\u0005z"+
		"\u0000\u0000\u00f4\u00f7\u0005e\u0000\u0000\u00f5\u00f7\u0005s\u0000\u0000"+
		"\u00f6\u00f1\u0001\u0000\u0000\u0000\u00f6\u00f5\u0001\u0000\u0000\u0000"+
		"\u00f7&\u0001\u0000\u0000\u0000\u00f8\u00f9\u0005r\u0000\u0000\u00f9\u00fa"+
		"\u0005a\u0000\u0000\u00fa\u00fb\u0005d\u0000\u0000\u00fb\u00fc\u0005i"+
		"\u0000\u0000\u00fc\u00fd\u0005u\u0000\u0000\u00fd\u0100\u0005s\u0000\u0000"+
		"\u00fe\u0100\u0005r\u0000\u0000\u00ff\u00f8\u0001\u0000\u0000\u0000\u00ff"+
		"\u00fe\u0001\u0000\u0000\u0000\u0100(\u0001\u0000\u0000\u0000\u0101\u0102"+
		"\u0005w\u0000\u0000\u0102\u0103\u0005i\u0000\u0000\u0103\u0104\u0005d"+
		"\u0000\u0000\u0104\u0105\u0005t\u0000\u0000\u0105\u0108\u0005h\u0000\u0000"+
		"\u0106\u0108\u0005w\u0000\u0000\u0107\u0101\u0001\u0000\u0000\u0000\u0107"+
		"\u0106\u0001\u0000\u0000\u0000\u0108*\u0001\u0000\u0000\u0000\u0109\u010a"+
		"\u0005h\u0000\u0000\u010a\u010b\u0005e\u0000\u0000\u010b\u010c\u0005i"+
		"\u0000\u0000\u010c\u010d\u0005g\u0000\u0000\u010d\u010e\u0005h\u0000\u0000"+
		"\u010e\u0111\u0005t\u0000\u0000\u010f\u0111\u0005h\u0000\u0000\u0110\u0109"+
		"\u0001\u0000\u0000\u0000\u0110\u010f\u0001\u0000\u0000\u0000\u0111,\u0001"+
		"\u0000\u0000\u0000\u0112\u0113\u0005h\u0000\u0000\u0113\u0114\u0005o\u0000"+
		"\u0000\u0114\u0115\u0005l\u0000\u0000\u0115\u0116\u0005l\u0000\u0000\u0116"+
		"\u0117\u0005o\u0000\u0000\u0117\u0118\u0005w\u0000\u0000\u0118.\u0001"+
		"\u0000\u0000\u0000\u0119\u011a\u0005s\u0000\u0000\u011a\u011b\u0005a\u0000"+
		"\u0000\u011b\u011c\u0005v\u0000\u0000\u011c\u011d\u0005e\u0000\u0000\u011d"+
		"0\u0001\u0000\u0000\u0000\u011e\u011f\u0005(\u0000\u0000\u011f2\u0001"+
		"\u0000\u0000\u0000\u0120\u0121\u0005)\u0000\u0000\u01214\u0001\u0000\u0000"+
		"\u0000\u0122\u0123\u0005,\u0000\u0000\u01236\u0001\u0000\u0000\u0000\u0124"+
		"\u0128\u0007\u0000\u0000\u0000\u0125\u0127\u0007\u0001\u0000\u0000\u0126"+
		"\u0125\u0001\u0000\u0000\u0000\u0127\u012a\u0001\u0000\u0000\u0000\u0128"+
		"\u0126\u0001\u0000\u0000\u0000\u0128\u0129\u0001\u0000\u0000\u0000\u0129"+
		"8\u0001\u0000\u0000\u0000\u012a\u0128\u0001\u0000\u0000\u0000\u0015\u0000"+
		">DINWbu}\u0090\u00a1\u00b3\u00c2\u00ce\u00dd\u00ea\u00f6\u00ff\u0107\u0110"+
		"\u0128\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}