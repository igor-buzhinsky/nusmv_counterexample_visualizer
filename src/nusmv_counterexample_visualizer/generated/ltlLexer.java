// Generated from /home/buzhinsky/repos/nusmv_counterexample_visualizer/ltl.g4 by ANTLR 4.6
package nusmv_counterexample_visualizer.generated;

import nusmv_counterexample_visualizer.formula.ltl.*;
import nusmv_counterexample_visualizer.formula.arithmetic.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ltlLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, WS=13, GLOBALLY=14, FUTURE=15, UNTIL=16, 
		RELEASE=17, NEXT=18, PREV_Y=19, PREV_Z=20, ONCE=21, HISTORICALLY=22, AND=23, 
		OR=24, IMPLIES=25, NOT=26, GT=27, GE=28, LT=29, LE=30, TRUE=31, FALSE=32, 
		INT_CONST=33, DIV=34, MOD=35, MUL=36, ID=37;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "WS", "GLOBALLY", "FUTURE", "UNTIL", "RELEASE", 
		"NEXT", "PREV_Y", "PREV_Z", "ONCE", "HISTORICALLY", "AND", "OR", "IMPLIES", 
		"NOT", "GT", "GE", "LT", "LE", "TRUE", "FALSE", "INT_CONST", "DIV", "MOD", 
		"MUL", "ID"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'+'", "'-'", "'<->'", "'='", "'xnor'", "'xor'", "'!='", "'.'", 
		"'['", "']'", "'('", "')'", null, "'G'", "'F'", "'U'", "'V'", "'X'", "'Y'", 
		"'Z'", "'O'", "'H'", "'&'", "'|'", "'->'", "'!'", "'>'", "'>='", "'<'", 
		"'<='", "'TRUE'", "'FALSE'", null, "'/'", "'mod'", "'*'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "WS", "GLOBALLY", "FUTURE", "UNTIL", "RELEASE", "NEXT", "PREV_Y", 
		"PREV_Z", "ONCE", "HISTORICALLY", "AND", "OR", "IMPLIES", "NOT", "GT", 
		"GE", "LT", "LE", "TRUE", "FALSE", "INT_CONST", "DIV", "MOD", "MUL", "ID"
	};
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


	public ltlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ltl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\'\u00c4\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\5\16p\n\16\3\16\6\16s\n\16\r\16\16"+
		"\16t\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32"+
		"\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3 "+
		"\3 \3 \3!\3!\3!\3!\3!\3!\3\"\5\"\u00aa\n\"\3\"\3\"\3\"\7\"\u00af\n\"\f"+
		"\"\16\"\u00b2\13\"\5\"\u00b4\n\"\3#\3#\3$\3$\3$\3$\3%\3%\3&\3&\7&\u00c0"+
		"\n&\f&\16&\u00c3\13&\2\2\'\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'\3\2\5\4\2\13\13\"\"\5\2C"+
		"\\aac|\6\2\62;C\\aac|\u00ca\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C"+
		"\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3M\3\2\2\2\5O\3\2"+
		"\2\2\7Q\3\2\2\2\tU\3\2\2\2\13W\3\2\2\2\r\\\3\2\2\2\17`\3\2\2\2\21c\3\2"+
		"\2\2\23e\3\2\2\2\25g\3\2\2\2\27i\3\2\2\2\31k\3\2\2\2\33r\3\2\2\2\35x\3"+
		"\2\2\2\37z\3\2\2\2!|\3\2\2\2#~\3\2\2\2%\u0080\3\2\2\2\'\u0082\3\2\2\2"+
		")\u0084\3\2\2\2+\u0086\3\2\2\2-\u0088\3\2\2\2/\u008a\3\2\2\2\61\u008c"+
		"\3\2\2\2\63\u008e\3\2\2\2\65\u0091\3\2\2\2\67\u0093\3\2\2\29\u0095\3\2"+
		"\2\2;\u0098\3\2\2\2=\u009a\3\2\2\2?\u009d\3\2\2\2A\u00a2\3\2\2\2C\u00a9"+
		"\3\2\2\2E\u00b5\3\2\2\2G\u00b7\3\2\2\2I\u00bb\3\2\2\2K\u00bd\3\2\2\2M"+
		"N\7-\2\2N\4\3\2\2\2OP\7/\2\2P\6\3\2\2\2QR\7>\2\2RS\7/\2\2ST\7@\2\2T\b"+
		"\3\2\2\2UV\7?\2\2V\n\3\2\2\2WX\7z\2\2XY\7p\2\2YZ\7q\2\2Z[\7t\2\2[\f\3"+
		"\2\2\2\\]\7z\2\2]^\7q\2\2^_\7t\2\2_\16\3\2\2\2`a\7#\2\2ab\7?\2\2b\20\3"+
		"\2\2\2cd\7\60\2\2d\22\3\2\2\2ef\7]\2\2f\24\3\2\2\2gh\7_\2\2h\26\3\2\2"+
		"\2ij\7*\2\2j\30\3\2\2\2kl\7+\2\2l\32\3\2\2\2ms\t\2\2\2np\7\17\2\2on\3"+
		"\2\2\2op\3\2\2\2pq\3\2\2\2qs\7\f\2\2rm\3\2\2\2ro\3\2\2\2st\3\2\2\2tr\3"+
		"\2\2\2tu\3\2\2\2uv\3\2\2\2vw\b\16\2\2w\34\3\2\2\2xy\7I\2\2y\36\3\2\2\2"+
		"z{\7H\2\2{ \3\2\2\2|}\7W\2\2}\"\3\2\2\2~\177\7X\2\2\177$\3\2\2\2\u0080"+
		"\u0081\7Z\2\2\u0081&\3\2\2\2\u0082\u0083\7[\2\2\u0083(\3\2\2\2\u0084\u0085"+
		"\7\\\2\2\u0085*\3\2\2\2\u0086\u0087\7Q\2\2\u0087,\3\2\2\2\u0088\u0089"+
		"\7J\2\2\u0089.\3\2\2\2\u008a\u008b\7(\2\2\u008b\60\3\2\2\2\u008c\u008d"+
		"\7~\2\2\u008d\62\3\2\2\2\u008e\u008f\7/\2\2\u008f\u0090\7@\2\2\u0090\64"+
		"\3\2\2\2\u0091\u0092\7#\2\2\u0092\66\3\2\2\2\u0093\u0094\7@\2\2\u0094"+
		"8\3\2\2\2\u0095\u0096\7@\2\2\u0096\u0097\7?\2\2\u0097:\3\2\2\2\u0098\u0099"+
		"\7>\2\2\u0099<\3\2\2\2\u009a\u009b\7>\2\2\u009b\u009c\7?\2\2\u009c>\3"+
		"\2\2\2\u009d\u009e\7V\2\2\u009e\u009f\7T\2\2\u009f\u00a0\7W\2\2\u00a0"+
		"\u00a1\7G\2\2\u00a1@\3\2\2\2\u00a2\u00a3\7H\2\2\u00a3\u00a4\7C\2\2\u00a4"+
		"\u00a5\7N\2\2\u00a5\u00a6\7U\2\2\u00a6\u00a7\7G\2\2\u00a7B\3\2\2\2\u00a8"+
		"\u00aa\7/\2\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00b3\3\2"+
		"\2\2\u00ab\u00b4\7\62\2\2\u00ac\u00b0\4\63;\2\u00ad\u00af\4\62;\2\u00ae"+
		"\u00ad\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2"+
		"\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00ab\3\2\2\2\u00b3"+
		"\u00ac\3\2\2\2\u00b4D\3\2\2\2\u00b5\u00b6\7\61\2\2\u00b6F\3\2\2\2\u00b7"+
		"\u00b8\7o\2\2\u00b8\u00b9\7q\2\2\u00b9\u00ba\7f\2\2\u00baH\3\2\2\2\u00bb"+
		"\u00bc\7,\2\2\u00bcJ\3\2\2\2\u00bd\u00c1\t\3\2\2\u00be\u00c0\t\4\2\2\u00bf"+
		"\u00be\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2"+
		"\2\2\u00c2L\3\2\2\2\u00c3\u00c1\3\2\2\2\n\2ort\u00a9\u00b0\u00b3\u00c1"+
		"\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}