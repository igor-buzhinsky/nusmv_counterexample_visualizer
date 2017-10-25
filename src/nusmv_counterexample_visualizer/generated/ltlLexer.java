// Generated from /home/buzhinsky/repos/other/nusmv_counterexample_visualizer/ltl.g4 by ANTLR 4.6
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
		AND=17, OR=18, IMPLIES=19, NOT=20, GT=21, GE=22, LT=23, LE=24, TRUE=25, 
		FALSE=26, INT_CONST=27, ID=28;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "WS", "GLOBALLY", "FUTURE", "UNTIL", "RELEASE", "NEXT", "AND", 
		"OR", "IMPLIES", "NOT", "GT", "GE", "LT", "LE", "TRUE", "FALSE", "INT_CONST", 
		"ID"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'<->'", "'='", "'xnor'", "'xor'", "'!='", "'.'", "'['", "']'", 
		"'('", "')'", null, "'G'", "'F'", "'U'", "'V'", "'X'", "'&'", "'|'", "'->'", 
		"'!'", "'>'", "'>='", "'<'", "'<='", "'TRUE'", "'FALSE'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "WS", 
		"GLOBALLY", "FUTURE", "UNTIL", "RELEASE", "NEXT", "AND", "OR", "IMPLIES", 
		"NOT", "GT", "GE", "LT", "LE", "TRUE", "FALSE", "INT_CONST", "ID"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\36\u009e\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3"+
		"\t\3\n\3\n\3\13\3\13\3\f\3\f\5\fZ\n\f\3\f\6\f]\n\f\r\f\16\f^\3\f\3\f\3"+
		"\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\5\34\u008c"+
		"\n\34\3\34\3\34\3\34\7\34\u0091\n\34\f\34\16\34\u0094\13\34\5\34\u0096"+
		"\n\34\3\35\3\35\7\35\u009a\n\35\f\35\16\35\u009d\13\35\2\2\36\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36\3\2\5\4\2\13"+
		"\13\"\"\5\2C\\aac|\6\2\62;C\\aac|\u00a4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\3;\3\2\2\2\5?\3\2\2\2\7A\3\2\2\2\t"+
		"F\3\2\2\2\13J\3\2\2\2\rM\3\2\2\2\17O\3\2\2\2\21Q\3\2\2\2\23S\3\2\2\2\25"+
		"U\3\2\2\2\27\\\3\2\2\2\31b\3\2\2\2\33d\3\2\2\2\35f\3\2\2\2\37h\3\2\2\2"+
		"!j\3\2\2\2#l\3\2\2\2%n\3\2\2\2\'p\3\2\2\2)s\3\2\2\2+u\3\2\2\2-w\3\2\2"+
		"\2/z\3\2\2\2\61|\3\2\2\2\63\177\3\2\2\2\65\u0084\3\2\2\2\67\u008b\3\2"+
		"\2\29\u0097\3\2\2\2;<\7>\2\2<=\7/\2\2=>\7@\2\2>\4\3\2\2\2?@\7?\2\2@\6"+
		"\3\2\2\2AB\7z\2\2BC\7p\2\2CD\7q\2\2DE\7t\2\2E\b\3\2\2\2FG\7z\2\2GH\7q"+
		"\2\2HI\7t\2\2I\n\3\2\2\2JK\7#\2\2KL\7?\2\2L\f\3\2\2\2MN\7\60\2\2N\16\3"+
		"\2\2\2OP\7]\2\2P\20\3\2\2\2QR\7_\2\2R\22\3\2\2\2ST\7*\2\2T\24\3\2\2\2"+
		"UV\7+\2\2V\26\3\2\2\2W]\t\2\2\2XZ\7\17\2\2YX\3\2\2\2YZ\3\2\2\2Z[\3\2\2"+
		"\2[]\7\f\2\2\\W\3\2\2\2\\Y\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_`\3"+
		"\2\2\2`a\b\f\2\2a\30\3\2\2\2bc\7I\2\2c\32\3\2\2\2de\7H\2\2e\34\3\2\2\2"+
		"fg\7W\2\2g\36\3\2\2\2hi\7X\2\2i \3\2\2\2jk\7Z\2\2k\"\3\2\2\2lm\7(\2\2"+
		"m$\3\2\2\2no\7~\2\2o&\3\2\2\2pq\7/\2\2qr\7@\2\2r(\3\2\2\2st\7#\2\2t*\3"+
		"\2\2\2uv\7@\2\2v,\3\2\2\2wx\7@\2\2xy\7?\2\2y.\3\2\2\2z{\7>\2\2{\60\3\2"+
		"\2\2|}\7>\2\2}~\7?\2\2~\62\3\2\2\2\177\u0080\7V\2\2\u0080\u0081\7T\2\2"+
		"\u0081\u0082\7W\2\2\u0082\u0083\7G\2\2\u0083\64\3\2\2\2\u0084\u0085\7"+
		"H\2\2\u0085\u0086\7C\2\2\u0086\u0087\7N\2\2\u0087\u0088\7U\2\2\u0088\u0089"+
		"\7G\2\2\u0089\66\3\2\2\2\u008a\u008c\7/\2\2\u008b\u008a\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u0095\3\2\2\2\u008d\u0096\7\62\2\2\u008e\u0092\4"+
		"\63;\2\u008f\u0091\4\62;\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2"+
		"\2\2\u0095\u008d\3\2\2\2\u0095\u008e\3\2\2\2\u00968\3\2\2\2\u0097\u009b"+
		"\t\3\2\2\u0098\u009a\t\4\2\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b"+
		"\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c:\3\2\2\2\u009d\u009b\3\2\2\2"+
		"\n\2Y\\^\u008b\u0092\u0095\u009b\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}