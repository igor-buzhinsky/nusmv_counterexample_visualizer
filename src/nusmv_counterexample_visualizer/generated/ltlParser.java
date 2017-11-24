// Generated from /home/buzhinsky/repos/nusmv_counterexample_visualizer/ltl.g4 by ANTLR 4.6
package nusmv_counterexample_visualizer.generated;

import nusmv_counterexample_visualizer.formula.BinaryOperator;
import nusmv_counterexample_visualizer.formula.LTLFormula;
import nusmv_counterexample_visualizer.formula.Proposition;
import nusmv_counterexample_visualizer.formula.UnaryOperator;
import nusmv_counterexample_visualizer.formula.arithmetic.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ltlParser extends Parser {
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
	public static final int
		RULE_plus = 0, RULE_minus = 1, RULE_equivalent = 2, RULE_xor = 3, RULE_eq = 4, 
		RULE_ne = 5, RULE_composite_id = 6, RULE_constant = 7, RULE_unary_operator_sign = 8, 
		RULE_binary_operator_sign = 9, RULE_comparison_operator_sign = 10, RULE_arithmetic_atom = 11, 
		RULE_arithmetic_expression3 = 12, RULE_arithmetic_expression2 = 13, RULE_arithmetic_expression1 = 14, 
		RULE_comparison_expression = 15, RULE_atom = 16, RULE_unary_operator = 17, 
		RULE_binary_operator = 18, RULE_formula = 19;
	public static final String[] ruleNames = {
		"plus", "minus", "equivalent", "xor", "eq", "ne", "composite_id", "constant", 
		"unary_operator_sign", "binary_operator_sign", "comparison_operator_sign", 
		"arithmetic_atom", "arithmetic_expression3", "arithmetic_expression2", 
		"arithmetic_expression1", "comparison_expression", "atom", "unary_operator", 
		"binary_operator", "formula"
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

	@Override
	public String getGrammarFileName() { return "ltl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	public ltlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class PlusContext extends ParserRuleContext {
		public PlusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitPlus(this);
		}
	}

	public final PlusContext plus() throws RecognitionException {
		PlusContext _localctx = new PlusContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_plus);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(T__0);
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

	public static class MinusContext extends ParserRuleContext {
		public MinusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_minus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitMinus(this);
		}
	}

	public final MinusContext minus() throws RecognitionException {
		MinusContext _localctx = new MinusContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_minus);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(T__1);
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

	public static class EquivalentContext extends ParserRuleContext {
		public EquivalentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equivalent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterEquivalent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitEquivalent(this);
		}
	}

	public final EquivalentContext equivalent() throws RecognitionException {
		EquivalentContext _localctx = new EquivalentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_equivalent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4))) != 0)) ) {
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

	public static class XorContext extends ParserRuleContext {
		public XorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterXor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitXor(this);
		}
	}

	public final XorContext xor() throws RecognitionException {
		XorContext _localctx = new XorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_xor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			_la = _input.LA(1);
			if ( !(_la==T__5 || _la==T__6) ) {
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

	public static class EqContext extends ParserRuleContext {
		public EqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitEq(this);
		}
	}

	public final EqContext eq() throws RecognitionException {
		EqContext _localctx = new EqContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_eq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(T__3);
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

	public static class NeContext extends ParserRuleContext {
		public NeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ne; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterNe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitNe(this);
		}
	}

	public final NeContext ne() throws RecognitionException {
		NeContext _localctx = new NeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ne);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__6);
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

	public static class Composite_idContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ltlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ltlParser.ID, i);
		}
		public List<TerminalNode> INT_CONST() { return getTokens(ltlParser.INT_CONST); }
		public TerminalNode INT_CONST(int i) {
			return getToken(ltlParser.INT_CONST, i);
		}
		public List<MinusContext> minus() {
			return getRuleContexts(MinusContext.class);
		}
		public MinusContext minus(int i) {
			return getRuleContext(MinusContext.class,i);
		}
		public Composite_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_composite_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterComposite_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitComposite_id(this);
		}
	}

	public final Composite_idContext composite_id() throws RecognitionException {
		Composite_idContext _localctx = new Composite_idContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_composite_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(ID);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(53);
				match(T__7);
				setState(54);
				match(ID);
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(60);
				match(T__8);
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(61);
					minus();
					}
				}

				setState(64);
				match(INT_CONST);
				setState(65);
				match(T__9);
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ConstantContext extends ParserRuleContext {
		public String value;
		public Token INT_CONST;
		public TerminalNode INT_CONST() { return getToken(ltlParser.INT_CONST, 0); }
		public TerminalNode TRUE() { return getToken(ltlParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ltlParser.FALSE, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_constant);
		try {
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				((ConstantContext)_localctx).INT_CONST = match(INT_CONST);
				 ((ConstantContext)_localctx).value =  (((ConstantContext)_localctx).INT_CONST!=null?((ConstantContext)_localctx).INT_CONST.getText():null); 
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				match(TRUE);
				 ((ConstantContext)_localctx).value =  "TRUE"; 
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				match(FALSE);
				 ((ConstantContext)_localctx).value =  "FALSE"; 
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

	public static class Unary_operator_signContext extends ParserRuleContext {
		public String value;
		public TerminalNode NOT() { return getToken(ltlParser.NOT, 0); }
		public TerminalNode NEXT() { return getToken(ltlParser.NEXT, 0); }
		public TerminalNode GLOBALLY() { return getToken(ltlParser.GLOBALLY, 0); }
		public TerminalNode FUTURE() { return getToken(ltlParser.FUTURE, 0); }
		public TerminalNode PREV_Y() { return getToken(ltlParser.PREV_Y, 0); }
		public TerminalNode PREV_Z() { return getToken(ltlParser.PREV_Z, 0); }
		public TerminalNode ONCE() { return getToken(ltlParser.ONCE, 0); }
		public TerminalNode HISTORICALLY() { return getToken(ltlParser.HISTORICALLY, 0); }
		public Unary_operator_signContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator_sign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterUnary_operator_sign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitUnary_operator_sign(this);
		}
	}

	public final Unary_operator_signContext unary_operator_sign() throws RecognitionException {
		Unary_operator_signContext _localctx = new Unary_operator_signContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_unary_operator_sign);
		try {
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				match(NOT);
				 ((Unary_operator_signContext)_localctx).value =  "!"; 
				}
				break;
			case NEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				match(NEXT);
				 ((Unary_operator_signContext)_localctx).value =  "X"; 
				}
				break;
			case GLOBALLY:
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
				match(GLOBALLY);
				 ((Unary_operator_signContext)_localctx).value =  "G"; 
				}
				break;
			case FUTURE:
				enterOuterAlt(_localctx, 4);
				{
				setState(85);
				match(FUTURE);
				 ((Unary_operator_signContext)_localctx).value =  "F"; 
				}
				break;
			case PREV_Y:
				enterOuterAlt(_localctx, 5);
				{
				setState(87);
				match(PREV_Y);
				 ((Unary_operator_signContext)_localctx).value =  "Y"; 
				}
				break;
			case PREV_Z:
				enterOuterAlt(_localctx, 6);
				{
				setState(89);
				match(PREV_Z);
				 ((Unary_operator_signContext)_localctx).value =  "Z"; 
				}
				break;
			case ONCE:
				enterOuterAlt(_localctx, 7);
				{
				setState(91);
				match(ONCE);
				 ((Unary_operator_signContext)_localctx).value =  "O"; 
				}
				break;
			case HISTORICALLY:
				enterOuterAlt(_localctx, 8);
				{
				setState(93);
				match(HISTORICALLY);
				 ((Unary_operator_signContext)_localctx).value =  "H"; 
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

	public static class Binary_operator_signContext extends ParserRuleContext {
		public String value;
		public TerminalNode AND() { return getToken(ltlParser.AND, 0); }
		public TerminalNode OR() { return getToken(ltlParser.OR, 0); }
		public TerminalNode IMPLIES() { return getToken(ltlParser.IMPLIES, 0); }
		public EquivalentContext equivalent() {
			return getRuleContext(EquivalentContext.class,0);
		}
		public TerminalNode UNTIL() { return getToken(ltlParser.UNTIL, 0); }
		public TerminalNode RELEASE() { return getToken(ltlParser.RELEASE, 0); }
		public XorContext xor() {
			return getRuleContext(XorContext.class,0);
		}
		public Binary_operator_signContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_operator_sign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterBinary_operator_sign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitBinary_operator_sign(this);
		}
	}

	public final Binary_operator_signContext binary_operator_sign() throws RecognitionException {
		Binary_operator_signContext _localctx = new Binary_operator_signContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_binary_operator_sign);
		try {
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AND:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				match(AND);
				 ((Binary_operator_signContext)_localctx).value =  "&"; 
				}
				break;
			case OR:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				match(OR);
				 ((Binary_operator_signContext)_localctx).value =  "|"; 
				}
				break;
			case IMPLIES:
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				match(IMPLIES);
				 ((Binary_operator_signContext)_localctx).value =  "->"; 
				}
				break;
			case T__2:
			case T__3:
			case T__4:
				enterOuterAlt(_localctx, 4);
				{
				setState(103);
				equivalent();
				 ((Binary_operator_signContext)_localctx).value =  "<->"; 
				}
				break;
			case UNTIL:
				enterOuterAlt(_localctx, 5);
				{
				setState(106);
				match(UNTIL);
				 ((Binary_operator_signContext)_localctx).value =  "U"; 
				}
				break;
			case RELEASE:
				enterOuterAlt(_localctx, 6);
				{
				setState(108);
				match(RELEASE);
				 ((Binary_operator_signContext)_localctx).value =  "V"; 
				}
				break;
			case T__5:
			case T__6:
				enterOuterAlt(_localctx, 7);
				{
				setState(110);
				xor();
				 ((Binary_operator_signContext)_localctx).value =  "xor"; 
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

	public static class Comparison_operator_signContext extends ParserRuleContext {
		public String value;
		public EqContext eq() {
			return getRuleContext(EqContext.class,0);
		}
		public NeContext ne() {
			return getRuleContext(NeContext.class,0);
		}
		public TerminalNode GT() { return getToken(ltlParser.GT, 0); }
		public TerminalNode GE() { return getToken(ltlParser.GE, 0); }
		public TerminalNode LT() { return getToken(ltlParser.LT, 0); }
		public TerminalNode LE() { return getToken(ltlParser.LE, 0); }
		public Comparison_operator_signContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison_operator_sign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterComparison_operator_sign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitComparison_operator_sign(this);
		}
	}

	public final Comparison_operator_signContext comparison_operator_sign() throws RecognitionException {
		Comparison_operator_signContext _localctx = new Comparison_operator_signContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_comparison_operator_sign);
		try {
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				eq();
				 ((Comparison_operator_signContext)_localctx).value =  "="; 
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				ne();
				 ((Comparison_operator_signContext)_localctx).value =  "!="; 
				}
				break;
			case GT:
				enterOuterAlt(_localctx, 3);
				{
				setState(121);
				match(GT);
				 ((Comparison_operator_signContext)_localctx).value =  ">"; 
				}
				break;
			case GE:
				enterOuterAlt(_localctx, 4);
				{
				setState(123);
				match(GE);
				 ((Comparison_operator_signContext)_localctx).value =  ">="; 
				}
				break;
			case LT:
				enterOuterAlt(_localctx, 5);
				{
				setState(125);
				match(LT);
				 ((Comparison_operator_signContext)_localctx).value =  "<"; 
				}
				break;
			case LE:
				enterOuterAlt(_localctx, 6);
				{
				setState(127);
				match(LE);
				 ((Comparison_operator_signContext)_localctx).value =  "<="; 
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

	public static class Arithmetic_atomContext extends ParserRuleContext {
		public ArithmeticExpression f;
		public ConstantContext constant;
		public Composite_idContext composite_id;
		public Arithmetic_expression1Context arithmetic_expression1;
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public Composite_idContext composite_id() {
			return getRuleContext(Composite_idContext.class,0);
		}
		public Arithmetic_expression1Context arithmetic_expression1() {
			return getRuleContext(Arithmetic_expression1Context.class,0);
		}
		public Arithmetic_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterArithmetic_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitArithmetic_atom(this);
		}
	}

	public final Arithmetic_atomContext arithmetic_atom() throws RecognitionException {
		Arithmetic_atomContext _localctx = new Arithmetic_atomContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_arithmetic_atom);
		try {
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case INT_CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				((Arithmetic_atomContext)_localctx).constant = constant();
				 ((Arithmetic_atomContext)_localctx).f =  new Constant(((Arithmetic_atomContext)_localctx).constant.value); 
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				((Arithmetic_atomContext)_localctx).composite_id = composite_id();
				 ((Arithmetic_atomContext)_localctx).f =  new Variable((((Arithmetic_atomContext)_localctx).composite_id!=null?_input.getText(((Arithmetic_atomContext)_localctx).composite_id.start,((Arithmetic_atomContext)_localctx).composite_id.stop):null)); 
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(137);
				match(T__10);
				setState(138);
				((Arithmetic_atomContext)_localctx).arithmetic_expression1 = arithmetic_expression1();
				setState(139);
				match(T__11);
				 ((Arithmetic_atomContext)_localctx).f =  ((Arithmetic_atomContext)_localctx).arithmetic_expression1.f; 
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

	public static class Arithmetic_expression3Context extends ParserRuleContext {
		public ArithmeticExpression f;
		public Arithmetic_atomContext arithmetic_atom;
		public Arithmetic_expression3Context arithmetic_expression3;
		public Arithmetic_atomContext arithmetic_atom() {
			return getRuleContext(Arithmetic_atomContext.class,0);
		}
		public Arithmetic_expression3Context arithmetic_expression3() {
			return getRuleContext(Arithmetic_expression3Context.class,0);
		}
		public MinusContext minus() {
			return getRuleContext(MinusContext.class,0);
		}
		public PlusContext plus() {
			return getRuleContext(PlusContext.class,0);
		}
		public Arithmetic_expression3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic_expression3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterArithmetic_expression3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitArithmetic_expression3(this);
		}
	}

	public final Arithmetic_expression3Context arithmetic_expression3() throws RecognitionException {
		Arithmetic_expression3Context _localctx = new Arithmetic_expression3Context(_ctx, getState());
		enterRule(_localctx, 24, RULE_arithmetic_expression3);
		try {
			setState(159);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case TRUE:
			case FALSE:
			case INT_CONST:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				((Arithmetic_expression3Context)_localctx).arithmetic_atom = arithmetic_atom();
				 ((Arithmetic_expression3Context)_localctx).f =  ((Arithmetic_expression3Context)_localctx).arithmetic_atom.f; 
				}
				break;
			case T__0:
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				 String op; 
				setState(154);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__1:
					{
					setState(148);
					minus();
					 op = "-"; 
					}
					break;
				case T__0:
					{
					setState(151);
					plus();
					 op = "+"; 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(156);
				((Arithmetic_expression3Context)_localctx).arithmetic_expression3 = arithmetic_expression3();
				 ((Arithmetic_expression3Context)_localctx).f =  new UnaryArithmeticOperator(op, ((Arithmetic_expression3Context)_localctx).arithmetic_expression3.f); 
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

	public static class Arithmetic_expression2Context extends ParserRuleContext {
		public ArithmeticExpression f;
		public Arithmetic_expression3Context f1;
		public Arithmetic_expression3Context f2;
		public List<Arithmetic_expression3Context> arithmetic_expression3() {
			return getRuleContexts(Arithmetic_expression3Context.class);
		}
		public Arithmetic_expression3Context arithmetic_expression3(int i) {
			return getRuleContext(Arithmetic_expression3Context.class,i);
		}
		public List<TerminalNode> MUL() { return getTokens(ltlParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(ltlParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(ltlParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(ltlParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(ltlParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(ltlParser.MOD, i);
		}
		public Arithmetic_expression2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic_expression2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterArithmetic_expression2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitArithmetic_expression2(this);
		}
	}

	public final Arithmetic_expression2Context arithmetic_expression2() throws RecognitionException {
		Arithmetic_expression2Context _localctx = new Arithmetic_expression2Context(_ctx, getState());
		enterRule(_localctx, 26, RULE_arithmetic_expression2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			((Arithmetic_expression2Context)_localctx).f1 = arithmetic_expression3();
			 ((Arithmetic_expression2Context)_localctx).f =  ((Arithmetic_expression2Context)_localctx).f1.f; String op; 
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIV) | (1L << MOD) | (1L << MUL))) != 0)) {
				{
				{
				setState(169);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MUL:
					{
					setState(163);
					match(MUL);
					 op = "*"; 
					}
					break;
				case DIV:
					{
					setState(165);
					match(DIV);
					 op = "/"; 
					}
					break;
				case MOD:
					{
					setState(167);
					match(MOD);
					 op = "mod"; 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(171);
				((Arithmetic_expression2Context)_localctx).f2 = arithmetic_expression3();
				 ((Arithmetic_expression2Context)_localctx).f =  new BinaryArithmeticOperator(op, _localctx.f, ((Arithmetic_expression2Context)_localctx).f2.f); 
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Arithmetic_expression1Context extends ParserRuleContext {
		public ArithmeticExpression f;
		public Arithmetic_expression2Context f1;
		public Arithmetic_expression2Context f2;
		public List<Arithmetic_expression2Context> arithmetic_expression2() {
			return getRuleContexts(Arithmetic_expression2Context.class);
		}
		public Arithmetic_expression2Context arithmetic_expression2(int i) {
			return getRuleContext(Arithmetic_expression2Context.class,i);
		}
		public List<PlusContext> plus() {
			return getRuleContexts(PlusContext.class);
		}
		public PlusContext plus(int i) {
			return getRuleContext(PlusContext.class,i);
		}
		public List<MinusContext> minus() {
			return getRuleContexts(MinusContext.class);
		}
		public MinusContext minus(int i) {
			return getRuleContext(MinusContext.class,i);
		}
		public Arithmetic_expression1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic_expression1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterArithmetic_expression1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitArithmetic_expression1(this);
		}
	}

	public final Arithmetic_expression1Context arithmetic_expression1() throws RecognitionException {
		Arithmetic_expression1Context _localctx = new Arithmetic_expression1Context(_ctx, getState());
		enterRule(_localctx, 28, RULE_arithmetic_expression1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			((Arithmetic_expression1Context)_localctx).f1 = arithmetic_expression2();
			 ((Arithmetic_expression1Context)_localctx).f =  ((Arithmetic_expression1Context)_localctx).f1.f; String op; 
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==T__1) {
				{
				{
				setState(187);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(181);
					plus();
					 op = "+"; 
					}
					break;
				case T__1:
					{
					setState(184);
					minus();
					 op = "-"; 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(189);
				((Arithmetic_expression1Context)_localctx).f2 = arithmetic_expression2();
				 ((Arithmetic_expression1Context)_localctx).f =  new BinaryArithmeticOperator(op, _localctx.f, ((Arithmetic_expression1Context)_localctx).f2.f); 
				}
				}
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Comparison_expressionContext extends ParserRuleContext {
		public ArithmeticExpression f;
		public Arithmetic_expression1Context f1;
		public Comparison_operator_signContext comparison_operator_sign;
		public Arithmetic_expression1Context f2;
		public List<Arithmetic_expression1Context> arithmetic_expression1() {
			return getRuleContexts(Arithmetic_expression1Context.class);
		}
		public Arithmetic_expression1Context arithmetic_expression1(int i) {
			return getRuleContext(Arithmetic_expression1Context.class,i);
		}
		public Comparison_operator_signContext comparison_operator_sign() {
			return getRuleContext(Comparison_operator_signContext.class,0);
		}
		public Comparison_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterComparison_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitComparison_expression(this);
		}
	}

	public final Comparison_expressionContext comparison_expression() throws RecognitionException {
		Comparison_expressionContext _localctx = new Comparison_expressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_comparison_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			((Comparison_expressionContext)_localctx).f1 = arithmetic_expression1();
			 ((Comparison_expressionContext)_localctx).f =  ((Comparison_expressionContext)_localctx).f1.f; String op; 
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(199);
				((Comparison_expressionContext)_localctx).comparison_operator_sign = comparison_operator_sign();
				setState(200);
				((Comparison_expressionContext)_localctx).f2 = arithmetic_expression1();
				 ((Comparison_expressionContext)_localctx).f =  new ComparisonOperator(((Comparison_expressionContext)_localctx).comparison_operator_sign.value, _localctx.f, ((Comparison_expressionContext)_localctx).f2.f); 
				}
				break;
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

	public static class AtomContext extends ParserRuleContext {
		public LTLFormula f;
		public FormulaContext formula;
		public Comparison_expressionContext comparison_expression;
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public Comparison_expressionContext comparison_expression() {
			return getRuleContext(Comparison_expressionContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitAtom(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_atom);
		try {
			setState(213);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				match(T__10);
				setState(206);
				((AtomContext)_localctx).formula = formula();
				setState(207);
				match(T__11);
				 ((AtomContext)_localctx).f =  ((AtomContext)_localctx).formula.f; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(210);
				((AtomContext)_localctx).comparison_expression = comparison_expression();
				 ((AtomContext)_localctx).f =  new Proposition(((AtomContext)_localctx).comparison_expression.f); 
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

	public static class Unary_operatorContext extends ParserRuleContext {
		public LTLFormula f;
		public AtomContext atom;
		public Unary_operator_signContext unary_operator_sign;
		public Unary_operatorContext unary_operator;
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public Unary_operator_signContext unary_operator_sign() {
			return getRuleContext(Unary_operator_signContext.class,0);
		}
		public Unary_operatorContext unary_operator() {
			return getRuleContext(Unary_operatorContext.class,0);
		}
		public Unary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitUnary_operator(this);
		}
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_unary_operator);
		try {
			setState(222);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__10:
			case TRUE:
			case FALSE:
			case INT_CONST:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				((Unary_operatorContext)_localctx).atom = atom();
				 ((Unary_operatorContext)_localctx).f =  ((Unary_operatorContext)_localctx).atom.f; 
				}
				break;
			case GLOBALLY:
			case FUTURE:
			case NEXT:
			case PREV_Y:
			case PREV_Z:
			case ONCE:
			case HISTORICALLY:
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				((Unary_operatorContext)_localctx).unary_operator_sign = unary_operator_sign();
				setState(219);
				((Unary_operatorContext)_localctx).unary_operator = unary_operator();
				 ((Unary_operatorContext)_localctx).f =  new UnaryOperator(((Unary_operatorContext)_localctx).unary_operator_sign.value, ((Unary_operatorContext)_localctx).unary_operator.f); 
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

	public static class Binary_operatorContext extends ParserRuleContext {
		public LTLFormula f;
		public Unary_operatorContext f1;
		public Binary_operator_signContext binary_operator_sign;
		public Unary_operatorContext f2;
		public List<Unary_operatorContext> unary_operator() {
			return getRuleContexts(Unary_operatorContext.class);
		}
		public Unary_operatorContext unary_operator(int i) {
			return getRuleContext(Unary_operatorContext.class,i);
		}
		public Binary_operator_signContext binary_operator_sign() {
			return getRuleContext(Binary_operator_signContext.class,0);
		}
		public Binary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterBinary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitBinary_operator(this);
		}
	}

	public final Binary_operatorContext binary_operator() throws RecognitionException {
		Binary_operatorContext _localctx = new Binary_operatorContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_binary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			((Binary_operatorContext)_localctx).f1 = unary_operator();
			 ((Binary_operatorContext)_localctx).f =  ((Binary_operatorContext)_localctx).f1.f; 
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << UNTIL) | (1L << RELEASE) | (1L << AND) | (1L << OR) | (1L << IMPLIES))) != 0)) {
				{
				setState(226);
				((Binary_operatorContext)_localctx).binary_operator_sign = binary_operator_sign();
				setState(227);
				((Binary_operatorContext)_localctx).f2 = unary_operator();
				 ((Binary_operatorContext)_localctx).f =  new BinaryOperator(((Binary_operatorContext)_localctx).binary_operator_sign.value, _localctx.f, ((Binary_operatorContext)_localctx).f2.f); 
				}
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

	public static class FormulaContext extends ParserRuleContext {
		public LTLFormula f;
		public Binary_operatorContext binary_operator;
		public Binary_operatorContext binary_operator() {
			return getRuleContext(Binary_operatorContext.class,0);
		}
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitFormula(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		FormulaContext _localctx = new FormulaContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_formula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			((FormulaContext)_localctx).binary_operator = binary_operator();
			 ((FormulaContext)_localctx).f =  ((FormulaContext)_localctx).binary_operator.f; 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\'\u00ee\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\b\7\b:\n\b\f\b\16\b=\13\b\3\b\3\b\5\bA\n\b\3\b\3\b"+
		"\7\bE\n\b\f\b\16\bH\13\b\3\t\3\t\3\t\3\t\3\t\3\t\5\tP\n\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nb\n\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\5\13t\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5"+
		"\f\u0084\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0091\n\r"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u009d\n\16\3\16"+
		"\3\16\3\16\5\16\u00a2\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u00ac\n\17\3\17\3\17\3\17\7\17\u00b1\n\17\f\17\16\17\u00b4\13\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00be\n\20\3\20\3\20\3\20\7\20"+
		"\u00c3\n\20\f\20\16\20\u00c6\13\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u00ce\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00d8\n\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00e1\n\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\5\24\u00e9\n\24\3\25\3\25\3\25\3\25\2\2\26\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(\2\4\3\2\5\7\3\2\b\t\u00fd\2*\3\2\2\2\4,\3"+
		"\2\2\2\6.\3\2\2\2\b\60\3\2\2\2\n\62\3\2\2\2\f\64\3\2\2\2\16\66\3\2\2\2"+
		"\20O\3\2\2\2\22a\3\2\2\2\24s\3\2\2\2\26\u0083\3\2\2\2\30\u0090\3\2\2\2"+
		"\32\u00a1\3\2\2\2\34\u00a3\3\2\2\2\36\u00b5\3\2\2\2 \u00c7\3\2\2\2\"\u00d7"+
		"\3\2\2\2$\u00e0\3\2\2\2&\u00e2\3\2\2\2(\u00ea\3\2\2\2*+\7\3\2\2+\3\3\2"+
		"\2\2,-\7\4\2\2-\5\3\2\2\2./\t\2\2\2/\7\3\2\2\2\60\61\t\3\2\2\61\t\3\2"+
		"\2\2\62\63\7\6\2\2\63\13\3\2\2\2\64\65\7\t\2\2\65\r\3\2\2\2\66;\7\'\2"+
		"\2\678\7\n\2\28:\7\'\2\29\67\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<F\3"+
		"\2\2\2=;\3\2\2\2>@\7\13\2\2?A\5\4\3\2@?\3\2\2\2@A\3\2\2\2AB\3\2\2\2BC"+
		"\7#\2\2CE\7\f\2\2D>\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\17\3\2\2\2"+
		"HF\3\2\2\2IJ\7#\2\2JP\b\t\1\2KL\7!\2\2LP\b\t\1\2MN\7\"\2\2NP\b\t\1\2O"+
		"I\3\2\2\2OK\3\2\2\2OM\3\2\2\2P\21\3\2\2\2QR\7\34\2\2Rb\b\n\1\2ST\7\24"+
		"\2\2Tb\b\n\1\2UV\7\20\2\2Vb\b\n\1\2WX\7\21\2\2Xb\b\n\1\2YZ\7\25\2\2Zb"+
		"\b\n\1\2[\\\7\26\2\2\\b\b\n\1\2]^\7\27\2\2^b\b\n\1\2_`\7\30\2\2`b\b\n"+
		"\1\2aQ\3\2\2\2aS\3\2\2\2aU\3\2\2\2aW\3\2\2\2aY\3\2\2\2a[\3\2\2\2a]\3\2"+
		"\2\2a_\3\2\2\2b\23\3\2\2\2cd\7\31\2\2dt\b\13\1\2ef\7\32\2\2ft\b\13\1\2"+
		"gh\7\33\2\2ht\b\13\1\2ij\5\6\4\2jk\b\13\1\2kt\3\2\2\2lm\7\22\2\2mt\b\13"+
		"\1\2no\7\23\2\2ot\b\13\1\2pq\5\b\5\2qr\b\13\1\2rt\3\2\2\2sc\3\2\2\2se"+
		"\3\2\2\2sg\3\2\2\2si\3\2\2\2sl\3\2\2\2sn\3\2\2\2sp\3\2\2\2t\25\3\2\2\2"+
		"uv\5\n\6\2vw\b\f\1\2w\u0084\3\2\2\2xy\5\f\7\2yz\b\f\1\2z\u0084\3\2\2\2"+
		"{|\7\35\2\2|\u0084\b\f\1\2}~\7\36\2\2~\u0084\b\f\1\2\177\u0080\7\37\2"+
		"\2\u0080\u0084\b\f\1\2\u0081\u0082\7 \2\2\u0082\u0084\b\f\1\2\u0083u\3"+
		"\2\2\2\u0083x\3\2\2\2\u0083{\3\2\2\2\u0083}\3\2\2\2\u0083\177\3\2\2\2"+
		"\u0083\u0081\3\2\2\2\u0084\27\3\2\2\2\u0085\u0086\5\20\t\2\u0086\u0087"+
		"\b\r\1\2\u0087\u0091\3\2\2\2\u0088\u0089\5\16\b\2\u0089\u008a\b\r\1\2"+
		"\u008a\u0091\3\2\2\2\u008b\u008c\7\r\2\2\u008c\u008d\5\36\20\2\u008d\u008e"+
		"\7\16\2\2\u008e\u008f\b\r\1\2\u008f\u0091\3\2\2\2\u0090\u0085\3\2\2\2"+
		"\u0090\u0088\3\2\2\2\u0090\u008b\3\2\2\2\u0091\31\3\2\2\2\u0092\u0093"+
		"\5\30\r\2\u0093\u0094\b\16\1\2\u0094\u00a2\3\2\2\2\u0095\u009c\b\16\1"+
		"\2\u0096\u0097\5\4\3\2\u0097\u0098\b\16\1\2\u0098\u009d\3\2\2\2\u0099"+
		"\u009a\5\2\2\2\u009a\u009b\b\16\1\2\u009b\u009d\3\2\2\2\u009c\u0096\3"+
		"\2\2\2\u009c\u0099\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\5\32\16\2\u009f"+
		"\u00a0\b\16\1\2\u00a0\u00a2\3\2\2\2\u00a1\u0092\3\2\2\2\u00a1\u0095\3"+
		"\2\2\2\u00a2\33\3\2\2\2\u00a3\u00a4\5\32\16\2\u00a4\u00b2\b\17\1\2\u00a5"+
		"\u00a6\7&\2\2\u00a6\u00ac\b\17\1\2\u00a7\u00a8\7$\2\2\u00a8\u00ac\b\17"+
		"\1\2\u00a9\u00aa\7%\2\2\u00aa\u00ac\b\17\1\2\u00ab\u00a5\3\2\2\2\u00ab"+
		"\u00a7\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\5\32"+
		"\16\2\u00ae\u00af\b\17\1\2\u00af\u00b1\3\2\2\2\u00b0\u00ab\3\2\2\2\u00b1"+
		"\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\35\3\2\2"+
		"\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\5\34\17\2\u00b6\u00c4\b\20\1\2\u00b7"+
		"\u00b8\5\2\2\2\u00b8\u00b9\b\20\1\2\u00b9\u00be\3\2\2\2\u00ba\u00bb\5"+
		"\4\3\2\u00bb\u00bc\b\20\1\2\u00bc\u00be\3\2\2\2\u00bd\u00b7\3\2\2\2\u00bd"+
		"\u00ba\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\5\34\17\2\u00c0\u00c1\b"+
		"\20\1\2\u00c1\u00c3\3\2\2\2\u00c2\u00bd\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\37\3\2\2\2\u00c6\u00c4\3\2\2"+
		"\2\u00c7\u00c8\5\36\20\2\u00c8\u00cd\b\21\1\2\u00c9\u00ca\5\26\f\2\u00ca"+
		"\u00cb\5\36\20\2\u00cb\u00cc\b\21\1\2\u00cc\u00ce\3\2\2\2\u00cd\u00c9"+
		"\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce!\3\2\2\2\u00cf\u00d0\7\r\2\2\u00d0"+
		"\u00d1\5(\25\2\u00d1\u00d2\7\16\2\2\u00d2\u00d3\b\22\1\2\u00d3\u00d8\3"+
		"\2\2\2\u00d4\u00d5\5 \21\2\u00d5\u00d6\b\22\1\2\u00d6\u00d8\3\2\2\2\u00d7"+
		"\u00cf\3\2\2\2\u00d7\u00d4\3\2\2\2\u00d8#\3\2\2\2\u00d9\u00da\5\"\22\2"+
		"\u00da\u00db\b\23\1\2\u00db\u00e1\3\2\2\2\u00dc\u00dd\5\22\n\2\u00dd\u00de"+
		"\5$\23\2\u00de\u00df\b\23\1\2\u00df\u00e1\3\2\2\2\u00e0\u00d9\3\2\2\2"+
		"\u00e0\u00dc\3\2\2\2\u00e1%\3\2\2\2\u00e2\u00e3\5$\23\2\u00e3\u00e8\b"+
		"\24\1\2\u00e4\u00e5\5\24\13\2\u00e5\u00e6\5$\23\2\u00e6\u00e7\b\24\1\2"+
		"\u00e7\u00e9\3\2\2\2\u00e8\u00e4\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\'\3"+
		"\2\2\2\u00ea\u00eb\5&\24\2\u00eb\u00ec\b\25\1\2\u00ec)\3\2\2\2\24;@FO"+
		"as\u0083\u0090\u009c\u00a1\u00ab\u00b2\u00bd\u00c4\u00cd\u00d7\u00e0\u00e8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}