// Generated from /home/buzhinsky/repos/nusmv_counterexample_visualizer/ltl.g4 by ANTLR 4.6
package nusmv_counterexample_visualizer.generated;

import nusmv_counterexample_visualizer.formula.*;

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
		T__9=10, WS=11, GLOBALLY=12, FUTURE=13, UNTIL=14, RELEASE=15, NEXT=16, 
		PREV_Y=17, PREV_Z=18, ONCE=19, HISTORICALLY=20, AND=21, OR=22, IMPLIES=23, 
		NOT=24, GT=25, GE=26, LT=27, LE=28, TRUE=29, FALSE=30, INT_CONST=31, ID=32;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "WS", "GLOBALLY", "FUTURE", "UNTIL", "RELEASE", "NEXT", "PREV_Y", 
		"PREV_Z", "ONCE", "HISTORICALLY", "AND", "OR", "IMPLIES", "NOT", "GT", 
		"GE", "LT", "LE", "TRUE", "FALSE", "INT_CONST", "ID"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'<->'", "'='", "'xnor'", "'xor'", "'!='", "'.'", "'['", "']'", 
		"'('", "')'", null, "'G'", "'F'", "'U'", "'V'", "'X'", "'Y'", "'Z'", "'O'", 
		"'H'", "'&'", "'|'", "'->'", "'!'", "'>'", "'>='", "'<'", "'<='", "'TRUE'", 
		"'FALSE'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "WS", 
		"GLOBALLY", "FUTURE", "UNTIL", "RELEASE", "NEXT", "PREV_Y", "PREV_Z", 
		"ONCE", "HISTORICALLY", "AND", "OR", "IMPLIES", "NOT", "GT", "GE", "LT", 
		"LE", "TRUE", "FALSE", "INT_CONST", "ID"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\"\u00ae\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\5\fb\n\f\3\f"+
		"\6\fe\n\f\r\f\16\ff\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \5 \u009c\n"+
		" \3 \3 \3 \7 \u00a1\n \f \16 \u00a4\13 \5 \u00a6\n \3!\3!\7!\u00aa\n!"+
		"\f!\16!\u00ad\13!\2\2\"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\37= ?!A\"\3\2\5\4\2\13\13\"\"\5\2C\\aac|\6\2\62;"+
		"C\\aac|\u00b4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\3C\3\2\2\2\5G\3\2\2"+
		"\2\7I\3\2\2\2\tN\3\2\2\2\13R\3\2\2\2\rU\3\2\2\2\17W\3\2\2\2\21Y\3\2\2"+
		"\2\23[\3\2\2\2\25]\3\2\2\2\27d\3\2\2\2\31j\3\2\2\2\33l\3\2\2\2\35n\3\2"+
		"\2\2\37p\3\2\2\2!r\3\2\2\2#t\3\2\2\2%v\3\2\2\2\'x\3\2\2\2)z\3\2\2\2+|"+
		"\3\2\2\2-~\3\2\2\2/\u0080\3\2\2\2\61\u0083\3\2\2\2\63\u0085\3\2\2\2\65"+
		"\u0087\3\2\2\2\67\u008a\3\2\2\29\u008c\3\2\2\2;\u008f\3\2\2\2=\u0094\3"+
		"\2\2\2?\u009b\3\2\2\2A\u00a7\3\2\2\2CD\7>\2\2DE\7/\2\2EF\7@\2\2F\4\3\2"+
		"\2\2GH\7?\2\2H\6\3\2\2\2IJ\7z\2\2JK\7p\2\2KL\7q\2\2LM\7t\2\2M\b\3\2\2"+
		"\2NO\7z\2\2OP\7q\2\2PQ\7t\2\2Q\n\3\2\2\2RS\7#\2\2ST\7?\2\2T\f\3\2\2\2"+
		"UV\7\60\2\2V\16\3\2\2\2WX\7]\2\2X\20\3\2\2\2YZ\7_\2\2Z\22\3\2\2\2[\\\7"+
		"*\2\2\\\24\3\2\2\2]^\7+\2\2^\26\3\2\2\2_e\t\2\2\2`b\7\17\2\2a`\3\2\2\2"+
		"ab\3\2\2\2bc\3\2\2\2ce\7\f\2\2d_\3\2\2\2da\3\2\2\2ef\3\2\2\2fd\3\2\2\2"+
		"fg\3\2\2\2gh\3\2\2\2hi\b\f\2\2i\30\3\2\2\2jk\7I\2\2k\32\3\2\2\2lm\7H\2"+
		"\2m\34\3\2\2\2no\7W\2\2o\36\3\2\2\2pq\7X\2\2q \3\2\2\2rs\7Z\2\2s\"\3\2"+
		"\2\2tu\7[\2\2u$\3\2\2\2vw\7\\\2\2w&\3\2\2\2xy\7Q\2\2y(\3\2\2\2z{\7J\2"+
		"\2{*\3\2\2\2|}\7(\2\2},\3\2\2\2~\177\7~\2\2\177.\3\2\2\2\u0080\u0081\7"+
		"/\2\2\u0081\u0082\7@\2\2\u0082\60\3\2\2\2\u0083\u0084\7#\2\2\u0084\62"+
		"\3\2\2\2\u0085\u0086\7@\2\2\u0086\64\3\2\2\2\u0087\u0088\7@\2\2\u0088"+
		"\u0089\7?\2\2\u0089\66\3\2\2\2\u008a\u008b\7>\2\2\u008b8\3\2\2\2\u008c"+
		"\u008d\7>\2\2\u008d\u008e\7?\2\2\u008e:\3\2\2\2\u008f\u0090\7V\2\2\u0090"+
		"\u0091\7T\2\2\u0091\u0092\7W\2\2\u0092\u0093\7G\2\2\u0093<\3\2\2\2\u0094"+
		"\u0095\7H\2\2\u0095\u0096\7C\2\2\u0096\u0097\7N\2\2\u0097\u0098\7U\2\2"+
		"\u0098\u0099\7G\2\2\u0099>\3\2\2\2\u009a\u009c\7/\2\2\u009b\u009a\3\2"+
		"\2\2\u009b\u009c\3\2\2\2\u009c\u00a5\3\2\2\2\u009d\u00a6\7\62\2\2\u009e"+
		"\u00a2\4\63;\2\u009f\u00a1\4\62;\2\u00a0\u009f\3\2\2\2\u00a1\u00a4\3\2"+
		"\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4"+
		"\u00a2\3\2\2\2\u00a5\u009d\3\2\2\2\u00a5\u009e\3\2\2\2\u00a6@\3\2\2\2"+
		"\u00a7\u00ab\t\3\2\2\u00a8\u00aa\t\4\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ad"+
		"\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00acB\3\2\2\2\u00ad"+
		"\u00ab\3\2\2\2\n\2adf\u009b\u00a2\u00a5\u00ab\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}