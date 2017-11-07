// Generated from /home/buzhinsky/repos/nusmv_counterexample_visualizer/ltl.g4 by ANTLR 4.6
package nusmv_counterexample_visualizer.generated;

import nusmv_counterexample_visualizer.formula.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ltlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, WS=11, GLOBALLY=12, FUTURE=13, UNTIL=14, RELEASE=15, NEXT=16, 
		PREV_Y=17, PREV_Z=18, ONCE=19, HISTORICALLY=20, AND=21, OR=22, IMPLIES=23, 
		NOT=24, GT=25, GE=26, LT=27, LE=28, TRUE=29, FALSE=30, INT_CONST=31, ID=32;
	public static final int
		RULE_equivalent = 0, RULE_xor = 1, RULE_eq = 2, RULE_ne = 3, RULE_unary_operator_sign = 4, 
		RULE_binary_operator_sign = 5, RULE_comparison_operator_sign = 6, RULE_constant = 7, 
		RULE_composite_id = 8, RULE_proposition = 9, RULE_atom = 10, RULE_unary_operator = 11, 
		RULE_binary_operator = 12, RULE_formula = 13;
	public static final String[] ruleNames = {
		"equivalent", "xor", "eq", "ne", "unary_operator_sign", "binary_operator_sign", 
		"comparison_operator_sign", "constant", "composite_id", "proposition", 
		"atom", "unary_operator", "binary_operator", "formula"
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
		enterRule(_localctx, 0, RULE_equivalent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2))) != 0)) ) {
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
		enterRule(_localctx, 2, RULE_xor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==T__4) ) {
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
		enterRule(_localctx, 4, RULE_eq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
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
		enterRule(_localctx, 6, RULE_ne);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(T__4);
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
		enterRule(_localctx, 8, RULE_unary_operator_sign);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				match(NOT);
				 ((Unary_operator_signContext)_localctx).value =  "!"; 
				}
				break;
			case NEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				match(NEXT);
				 ((Unary_operator_signContext)_localctx).value =  "X"; 
				}
				break;
			case GLOBALLY:
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				match(GLOBALLY);
				 ((Unary_operator_signContext)_localctx).value =  "G"; 
				}
				break;
			case FUTURE:
				enterOuterAlt(_localctx, 4);
				{
				setState(42);
				match(FUTURE);
				 ((Unary_operator_signContext)_localctx).value =  "F"; 
				}
				break;
			case PREV_Y:
				enterOuterAlt(_localctx, 5);
				{
				setState(44);
				match(PREV_Y);
				 ((Unary_operator_signContext)_localctx).value =  "Y"; 
				}
				break;
			case PREV_Z:
				enterOuterAlt(_localctx, 6);
				{
				setState(46);
				match(PREV_Z);
				 ((Unary_operator_signContext)_localctx).value =  "Z"; 
				}
				break;
			case ONCE:
				enterOuterAlt(_localctx, 7);
				{
				setState(48);
				match(ONCE);
				 ((Unary_operator_signContext)_localctx).value =  "O"; 
				}
				break;
			case HISTORICALLY:
				enterOuterAlt(_localctx, 8);
				{
				setState(50);
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
		enterRule(_localctx, 10, RULE_binary_operator_sign);
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AND:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				match(AND);
				 ((Binary_operator_signContext)_localctx).value =  "&"; 
				}
				break;
			case OR:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				match(OR);
				 ((Binary_operator_signContext)_localctx).value =  "|"; 
				}
				break;
			case IMPLIES:
				enterOuterAlt(_localctx, 3);
				{
				setState(58);
				match(IMPLIES);
				 ((Binary_operator_signContext)_localctx).value =  "->"; 
				}
				break;
			case T__0:
			case T__1:
			case T__2:
				enterOuterAlt(_localctx, 4);
				{
				setState(60);
				equivalent();
				 ((Binary_operator_signContext)_localctx).value =  "<->"; 
				}
				break;
			case UNTIL:
				enterOuterAlt(_localctx, 5);
				{
				setState(63);
				match(UNTIL);
				 ((Binary_operator_signContext)_localctx).value =  "U"; 
				}
				break;
			case RELEASE:
				enterOuterAlt(_localctx, 6);
				{
				setState(65);
				match(RELEASE);
				 ((Binary_operator_signContext)_localctx).value =  "V"; 
				}
				break;
			case T__3:
			case T__4:
				enterOuterAlt(_localctx, 7);
				{
				setState(67);
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
		enterRule(_localctx, 12, RULE_comparison_operator_sign);
		try {
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				eq();
				 ((Comparison_operator_signContext)_localctx).value =  "="; 
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				ne();
				 ((Comparison_operator_signContext)_localctx).value =  "!="; 
				}
				break;
			case GT:
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				match(GT);
				 ((Comparison_operator_signContext)_localctx).value =  ">"; 
				}
				break;
			case GE:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				match(GE);
				 ((Comparison_operator_signContext)_localctx).value =  ">="; 
				}
				break;
			case LT:
				enterOuterAlt(_localctx, 5);
				{
				setState(82);
				match(LT);
				 ((Comparison_operator_signContext)_localctx).value =  "<"; 
				}
				break;
			case LE:
				enterOuterAlt(_localctx, 6);
				{
				setState(84);
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
			setState(94);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				((ConstantContext)_localctx).INT_CONST = match(INT_CONST);
				 ((ConstantContext)_localctx).value =  (((ConstantContext)_localctx).INT_CONST!=null?((ConstantContext)_localctx).INT_CONST.getText():null); 
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				match(TRUE);
				 ((ConstantContext)_localctx).value =  "TRUE"; 
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(92);
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

	public static class Composite_idContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ltlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ltlParser.ID, i);
		}
		public TerminalNode INT_CONST() { return getToken(ltlParser.INT_CONST, 0); }
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
		enterRule(_localctx, 16, RULE_composite_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(ID);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(97);
				match(T__5);
				setState(98);
				match(ID);
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(104);
				match(T__6);
				setState(105);
				match(INT_CONST);
				setState(106);
				match(T__7);
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

	public static class PropositionContext extends ParserRuleContext {
		public LTLFormula f;
		public Composite_idContext composite_id;
		public Comparison_operator_signContext comparison_operator_sign;
		public ConstantContext constant;
		public TerminalNode TRUE() { return getToken(ltlParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ltlParser.FALSE, 0); }
		public Composite_idContext composite_id() {
			return getRuleContext(Composite_idContext.class,0);
		}
		public Comparison_operator_signContext comparison_operator_sign() {
			return getRuleContext(Comparison_operator_signContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public PropositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proposition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterProposition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitProposition(this);
		}
	}

	public final PropositionContext proposition() throws RecognitionException {
		PropositionContext _localctx = new PropositionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_proposition);
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				match(TRUE);
				 ((PropositionContext)_localctx).f =  new TrueFormula(); 
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				match(FALSE);
				 ((PropositionContext)_localctx).f =  new FalseFormula(); 
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				{
				 String c = "TRUE"; String op = "="; 
				setState(114);
				((PropositionContext)_localctx).composite_id = composite_id();
				setState(119);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(115);
					((PropositionContext)_localctx).comparison_operator_sign = comparison_operator_sign();
					setState(116);
					((PropositionContext)_localctx).constant = constant();
					 op = ((PropositionContext)_localctx).comparison_operator_sign.value; c = ((PropositionContext)_localctx).constant.value; 
					}
					break;
				}
				 ((PropositionContext)_localctx).f =  new Proposition((((PropositionContext)_localctx).composite_id!=null?_input.getText(((PropositionContext)_localctx).composite_id.start,((PropositionContext)_localctx).composite_id.stop):null), op, c); 
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

	public static class AtomContext extends ParserRuleContext {
		public LTLFormula f;
		public PropositionContext proposition;
		public FormulaContext formula;
		public PropositionContext proposition() {
			return getRuleContext(PropositionContext.class,0);
		}
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
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
		enterRule(_localctx, 20, RULE_atom);
		try {
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				((AtomContext)_localctx).proposition = proposition();
				 ((AtomContext)_localctx).f =  ((AtomContext)_localctx).proposition.f; 
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				match(T__8);
				setState(129);
				((AtomContext)_localctx).formula = formula();
				setState(130);
				match(T__9);
				 ((AtomContext)_localctx).f =  ((AtomContext)_localctx).formula.f; 
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
		enterRule(_localctx, 22, RULE_unary_operator);
		try {
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
			case TRUE:
			case FALSE:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
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
				setState(138);
				((Unary_operatorContext)_localctx).unary_operator_sign = unary_operator_sign();
				setState(139);
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
		enterRule(_localctx, 24, RULE_binary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			((Binary_operatorContext)_localctx).f1 = unary_operator();
			 ((Binary_operatorContext)_localctx).f =  ((Binary_operatorContext)_localctx).f1.f; 
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << UNTIL) | (1L << RELEASE) | (1L << AND) | (1L << OR) | (1L << IMPLIES))) != 0)) {
				{
				setState(146);
				((Binary_operatorContext)_localctx).binary_operator_sign = binary_operator_sign();
				setState(147);
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
		enterRule(_localctx, 26, RULE_formula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\"\u009e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6"+
		"\67\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\5\7I\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5"+
		"\bY\n\b\3\t\3\t\3\t\3\t\3\t\3\t\5\ta\n\t\3\n\3\n\3\n\7\nf\n\n\f\n\16\n"+
		"i\13\n\3\n\3\n\3\n\5\nn\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\5\13z\n\13\3\13\3\13\5\13~\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\5\f\u0088\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0091\n\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\5\16\u0099\n\16\3\17\3\17\3\17\3\17\2\2\20\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\2\4\3\2\3\5\3\2\6\7\u00ab\2\36\3\2\2\2\4"+
		" \3\2\2\2\6\"\3\2\2\2\b$\3\2\2\2\n\66\3\2\2\2\fH\3\2\2\2\16X\3\2\2\2\20"+
		"`\3\2\2\2\22b\3\2\2\2\24}\3\2\2\2\26\u0087\3\2\2\2\30\u0090\3\2\2\2\32"+
		"\u0092\3\2\2\2\34\u009a\3\2\2\2\36\37\t\2\2\2\37\3\3\2\2\2 !\t\3\2\2!"+
		"\5\3\2\2\2\"#\7\4\2\2#\7\3\2\2\2$%\7\7\2\2%\t\3\2\2\2&\'\7\32\2\2\'\67"+
		"\b\6\1\2()\7\22\2\2)\67\b\6\1\2*+\7\16\2\2+\67\b\6\1\2,-\7\17\2\2-\67"+
		"\b\6\1\2./\7\23\2\2/\67\b\6\1\2\60\61\7\24\2\2\61\67\b\6\1\2\62\63\7\25"+
		"\2\2\63\67\b\6\1\2\64\65\7\26\2\2\65\67\b\6\1\2\66&\3\2\2\2\66(\3\2\2"+
		"\2\66*\3\2\2\2\66,\3\2\2\2\66.\3\2\2\2\66\60\3\2\2\2\66\62\3\2\2\2\66"+
		"\64\3\2\2\2\67\13\3\2\2\289\7\27\2\29I\b\7\1\2:;\7\30\2\2;I\b\7\1\2<="+
		"\7\31\2\2=I\b\7\1\2>?\5\2\2\2?@\b\7\1\2@I\3\2\2\2AB\7\20\2\2BI\b\7\1\2"+
		"CD\7\21\2\2DI\b\7\1\2EF\5\4\3\2FG\b\7\1\2GI\3\2\2\2H8\3\2\2\2H:\3\2\2"+
		"\2H<\3\2\2\2H>\3\2\2\2HA\3\2\2\2HC\3\2\2\2HE\3\2\2\2I\r\3\2\2\2JK\5\6"+
		"\4\2KL\b\b\1\2LY\3\2\2\2MN\5\b\5\2NO\b\b\1\2OY\3\2\2\2PQ\7\33\2\2QY\b"+
		"\b\1\2RS\7\34\2\2SY\b\b\1\2TU\7\35\2\2UY\b\b\1\2VW\7\36\2\2WY\b\b\1\2"+
		"XJ\3\2\2\2XM\3\2\2\2XP\3\2\2\2XR\3\2\2\2XT\3\2\2\2XV\3\2\2\2Y\17\3\2\2"+
		"\2Z[\7!\2\2[a\b\t\1\2\\]\7\37\2\2]a\b\t\1\2^_\7 \2\2_a\b\t\1\2`Z\3\2\2"+
		"\2`\\\3\2\2\2`^\3\2\2\2a\21\3\2\2\2bg\7\"\2\2cd\7\b\2\2df\7\"\2\2ec\3"+
		"\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2hm\3\2\2\2ig\3\2\2\2jk\7\t\2\2kl\7"+
		"!\2\2ln\7\n\2\2mj\3\2\2\2mn\3\2\2\2n\23\3\2\2\2op\7\37\2\2p~\b\13\1\2"+
		"qr\7 \2\2r~\b\13\1\2st\b\13\1\2ty\5\22\n\2uv\5\16\b\2vw\5\20\t\2wx\b\13"+
		"\1\2xz\3\2\2\2yu\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\b\13\1\2|~\3\2\2\2}o\3"+
		"\2\2\2}q\3\2\2\2}s\3\2\2\2~\25\3\2\2\2\177\u0080\5\24\13\2\u0080\u0081"+
		"\b\f\1\2\u0081\u0088\3\2\2\2\u0082\u0083\7\13\2\2\u0083\u0084\5\34\17"+
		"\2\u0084\u0085\7\f\2\2\u0085\u0086\b\f\1\2\u0086\u0088\3\2\2\2\u0087\177"+
		"\3\2\2\2\u0087\u0082\3\2\2\2\u0088\27\3\2\2\2\u0089\u008a\5\26\f\2\u008a"+
		"\u008b\b\r\1\2\u008b\u0091\3\2\2\2\u008c\u008d\5\n\6\2\u008d\u008e\5\30"+
		"\r\2\u008e\u008f\b\r\1\2\u008f\u0091\3\2\2\2\u0090\u0089\3\2\2\2\u0090"+
		"\u008c\3\2\2\2\u0091\31\3\2\2\2\u0092\u0093\5\30\r\2\u0093\u0098\b\16"+
		"\1\2\u0094\u0095\5\f\7\2\u0095\u0096\5\30\r\2\u0096\u0097\b\16\1\2\u0097"+
		"\u0099\3\2\2\2\u0098\u0094\3\2\2\2\u0098\u0099\3\2\2\2\u0099\33\3\2\2"+
		"\2\u009a\u009b\5\32\16\2\u009b\u009c\b\17\1\2\u009c\35\3\2\2\2\r\66HX"+
		"`gmy}\u0087\u0090\u0098";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}