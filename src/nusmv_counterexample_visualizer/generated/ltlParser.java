// Generated from /home/buzhinsky/repos/other/nusmv_counterexample_visualizer/ltl.g4 by ANTLR 4.6
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
		AND=17, OR=18, IMPLIES=19, NOT=20, GT=21, GE=22, LT=23, LE=24, TRUE=25, 
		FALSE=26, INT_CONST=27, ID=28;
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
			setState(44);
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
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AND:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				match(AND);
				 ((Binary_operator_signContext)_localctx).value =  "&"; 
				}
				break;
			case OR:
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				match(OR);
				 ((Binary_operator_signContext)_localctx).value =  "|"; 
				}
				break;
			case IMPLIES:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				match(IMPLIES);
				 ((Binary_operator_signContext)_localctx).value =  "->"; 
				}
				break;
			case T__0:
			case T__1:
			case T__2:
				enterOuterAlt(_localctx, 4);
				{
				setState(52);
				equivalent();
				 ((Binary_operator_signContext)_localctx).value =  "<->"; 
				}
				break;
			case UNTIL:
				enterOuterAlt(_localctx, 5);
				{
				setState(55);
				match(UNTIL);
				 ((Binary_operator_signContext)_localctx).value =  "U"; 
				}
				break;
			case RELEASE:
				enterOuterAlt(_localctx, 6);
				{
				setState(57);
				match(RELEASE);
				 ((Binary_operator_signContext)_localctx).value =  "V"; 
				}
				break;
			case T__3:
			case T__4:
				enterOuterAlt(_localctx, 7);
				{
				setState(59);
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
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				eq();
				 ((Comparison_operator_signContext)_localctx).value =  "="; 
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				ne();
				 ((Comparison_operator_signContext)_localctx).value =  "!="; 
				}
				break;
			case GT:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				match(GT);
				 ((Comparison_operator_signContext)_localctx).value =  ">"; 
				}
				break;
			case GE:
				enterOuterAlt(_localctx, 4);
				{
				setState(72);
				match(GE);
				 ((Comparison_operator_signContext)_localctx).value =  ">="; 
				}
				break;
			case LT:
				enterOuterAlt(_localctx, 5);
				{
				setState(74);
				match(LT);
				 ((Comparison_operator_signContext)_localctx).value =  "<"; 
				}
				break;
			case LE:
				enterOuterAlt(_localctx, 6);
				{
				setState(76);
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
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				((ConstantContext)_localctx).INT_CONST = match(INT_CONST);
				 ((ConstantContext)_localctx).value =  (((ConstantContext)_localctx).INT_CONST!=null?((ConstantContext)_localctx).INT_CONST.getText():null); 
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				match(TRUE);
				 ((ConstantContext)_localctx).value =  "TRUE"; 
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
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
			setState(88);
			match(ID);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(89);
				match(T__5);
				setState(90);
				match(ID);
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(96);
				match(T__6);
				setState(97);
				match(INT_CONST);
				setState(98);
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
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				match(TRUE);
				 ((PropositionContext)_localctx).f =  new TrueFormula(); 
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				match(FALSE);
				 ((PropositionContext)_localctx).f =  new FalseFormula(); 
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				{
				 String c = "TRUE"; String op = "="; 
				setState(106);
				((PropositionContext)_localctx).composite_id = composite_id();
				setState(111);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(107);
					((PropositionContext)_localctx).comparison_operator_sign = comparison_operator_sign();
					setState(108);
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
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				((AtomContext)_localctx).proposition = proposition();
				 ((AtomContext)_localctx).f =  ((AtomContext)_localctx).proposition.f; 
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(T__8);
				setState(121);
				((AtomContext)_localctx).formula = formula();
				setState(122);
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
			setState(134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
			case TRUE:
			case FALSE:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				((Unary_operatorContext)_localctx).atom = atom();
				 ((Unary_operatorContext)_localctx).f =  ((Unary_operatorContext)_localctx).atom.f; 
				}
				break;
			case GLOBALLY:
			case FUTURE:
			case NEXT:
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				((Unary_operatorContext)_localctx).unary_operator_sign = unary_operator_sign();
				setState(131);
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
			setState(136);
			((Binary_operatorContext)_localctx).f1 = unary_operator();
			 ((Binary_operatorContext)_localctx).f =  ((Binary_operatorContext)_localctx).f1.f; 
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << UNTIL) | (1L << RELEASE) | (1L << AND) | (1L << OR) | (1L << IMPLIES))) != 0)) {
				{
				setState(138);
				((Binary_operatorContext)_localctx).binary_operator_sign = binary_operator_sign();
				setState(139);
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
			setState(144);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\36\u0096\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6/\n\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7A\n\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bQ\n\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\5\tY\n\t\3\n\3\n\3\n\7\n^\n\n\f\n\16\na\13\n\3\n\3\n\3\n\5\nf\n\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13r\n\13\3\13\3\13\5\13"+
		"v\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0080\n\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\5\r\u0089\n\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0091\n\16"+
		"\3\17\3\17\3\17\3\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\4\3"+
		"\2\3\5\3\2\6\7\u009f\2\36\3\2\2\2\4 \3\2\2\2\6\"\3\2\2\2\b$\3\2\2\2\n"+
		".\3\2\2\2\f@\3\2\2\2\16P\3\2\2\2\20X\3\2\2\2\22Z\3\2\2\2\24u\3\2\2\2\26"+
		"\177\3\2\2\2\30\u0088\3\2\2\2\32\u008a\3\2\2\2\34\u0092\3\2\2\2\36\37"+
		"\t\2\2\2\37\3\3\2\2\2 !\t\3\2\2!\5\3\2\2\2\"#\7\4\2\2#\7\3\2\2\2$%\7\7"+
		"\2\2%\t\3\2\2\2&\'\7\26\2\2\'/\b\6\1\2()\7\22\2\2)/\b\6\1\2*+\7\16\2\2"+
		"+/\b\6\1\2,-\7\17\2\2-/\b\6\1\2.&\3\2\2\2.(\3\2\2\2.*\3\2\2\2.,\3\2\2"+
		"\2/\13\3\2\2\2\60\61\7\23\2\2\61A\b\7\1\2\62\63\7\24\2\2\63A\b\7\1\2\64"+
		"\65\7\25\2\2\65A\b\7\1\2\66\67\5\2\2\2\678\b\7\1\28A\3\2\2\29:\7\20\2"+
		"\2:A\b\7\1\2;<\7\21\2\2<A\b\7\1\2=>\5\4\3\2>?\b\7\1\2?A\3\2\2\2@\60\3"+
		"\2\2\2@\62\3\2\2\2@\64\3\2\2\2@\66\3\2\2\2@9\3\2\2\2@;\3\2\2\2@=\3\2\2"+
		"\2A\r\3\2\2\2BC\5\6\4\2CD\b\b\1\2DQ\3\2\2\2EF\5\b\5\2FG\b\b\1\2GQ\3\2"+
		"\2\2HI\7\27\2\2IQ\b\b\1\2JK\7\30\2\2KQ\b\b\1\2LM\7\31\2\2MQ\b\b\1\2NO"+
		"\7\32\2\2OQ\b\b\1\2PB\3\2\2\2PE\3\2\2\2PH\3\2\2\2PJ\3\2\2\2PL\3\2\2\2"+
		"PN\3\2\2\2Q\17\3\2\2\2RS\7\35\2\2SY\b\t\1\2TU\7\33\2\2UY\b\t\1\2VW\7\34"+
		"\2\2WY\b\t\1\2XR\3\2\2\2XT\3\2\2\2XV\3\2\2\2Y\21\3\2\2\2Z_\7\36\2\2[\\"+
		"\7\b\2\2\\^\7\36\2\2][\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`e\3\2\2\2"+
		"a_\3\2\2\2bc\7\t\2\2cd\7\35\2\2df\7\n\2\2eb\3\2\2\2ef\3\2\2\2f\23\3\2"+
		"\2\2gh\7\33\2\2hv\b\13\1\2ij\7\34\2\2jv\b\13\1\2kl\b\13\1\2lq\5\22\n\2"+
		"mn\5\16\b\2no\5\20\t\2op\b\13\1\2pr\3\2\2\2qm\3\2\2\2qr\3\2\2\2rs\3\2"+
		"\2\2st\b\13\1\2tv\3\2\2\2ug\3\2\2\2ui\3\2\2\2uk\3\2\2\2v\25\3\2\2\2wx"+
		"\5\24\13\2xy\b\f\1\2y\u0080\3\2\2\2z{\7\13\2\2{|\5\34\17\2|}\7\f\2\2}"+
		"~\b\f\1\2~\u0080\3\2\2\2\177w\3\2\2\2\177z\3\2\2\2\u0080\27\3\2\2\2\u0081"+
		"\u0082\5\26\f\2\u0082\u0083\b\r\1\2\u0083\u0089\3\2\2\2\u0084\u0085\5"+
		"\n\6\2\u0085\u0086\5\30\r\2\u0086\u0087\b\r\1\2\u0087\u0089\3\2\2\2\u0088"+
		"\u0081\3\2\2\2\u0088\u0084\3\2\2\2\u0089\31\3\2\2\2\u008a\u008b\5\30\r"+
		"\2\u008b\u0090\b\16\1\2\u008c\u008d\5\f\7\2\u008d\u008e\5\30\r\2\u008e"+
		"\u008f\b\16\1\2\u008f\u0091\3\2\2\2\u0090\u008c\3\2\2\2\u0090\u0091\3"+
		"\2\2\2\u0091\33\3\2\2\2\u0092\u0093\5\32\16\2\u0093\u0094\b\17\1\2\u0094"+
		"\35\3\2\2\2\r.@PX_equ\177\u0088\u0090";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}