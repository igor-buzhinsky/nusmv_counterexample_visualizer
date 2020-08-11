// Generated from /home/buzhinsky/repos/nusmv_counterexample_visualizer/ltl.g4 by ANTLR 4.7.2
package nusmv_counterexample_visualizer.generated;

import nusmv_counterexample_visualizer.formula.ltl.*;
import nusmv_counterexample_visualizer.formula.arithmetic.*;

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
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, WS=36, REAL_CONST=37, INT_CONST=38, 
		TRUE=39, FALSE=40, COUNT=41, ID=42;
	public static final int
		RULE_constant = 0, RULE_composite_id = 1, RULE_unary_operator_sign = 2, 
		RULE_binary_operator_sign5 = 3, RULE_binary_operator_sign4 = 4, RULE_binary_operator_sign3 = 5, 
		RULE_binary_operator_sign2 = 6, RULE_binary_operator_sign1 = 7, RULE_comparison_operator_sign = 8, 
		RULE_arithmetic_atomic_value = 9, RULE_arithmetic_atom = 10, RULE_arithmetic_expression3 = 11, 
		RULE_arithmetic_expression2 = 12, RULE_arithmetic_expression1 = 13, RULE_comparison_expression = 14, 
		RULE_and_arithmetic_expression = 15, RULE_or_arithmetic_expression = 16, 
		RULE_ternary_arithmetic_expression = 17, RULE_eq_arithmetic_expression = 18, 
		RULE_implies_arithmetic_expression = 19, RULE_proposition = 20, RULE_atom = 21, 
		RULE_unary_operator = 22, RULE_binary_operator5 = 23, RULE_binary_operator4 = 24, 
		RULE_binary_operator3 = 25, RULE_binary_operator2 = 26, RULE_binary_operator1 = 27, 
		RULE_formula = 28, RULE_formula_eof = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"constant", "composite_id", "unary_operator_sign", "binary_operator_sign5", 
			"binary_operator_sign4", "binary_operator_sign3", "binary_operator_sign2", 
			"binary_operator_sign1", "comparison_operator_sign", "arithmetic_atomic_value", 
			"arithmetic_atom", "arithmetic_expression3", "arithmetic_expression2", 
			"arithmetic_expression1", "comparison_expression", "and_arithmetic_expression", 
			"or_arithmetic_expression", "ternary_arithmetic_expression", "eq_arithmetic_expression", 
			"implies_arithmetic_expression", "proposition", "atom", "unary_operator", 
			"binary_operator5", "binary_operator4", "binary_operator3", "binary_operator2", 
			"binary_operator1", "formula", "formula_eof"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "'['", "']'", "'!'", "'X'", "'G'", "'F'", "'Y'", "'Z'", 
			"'O'", "'H'", "'U'", "'V'", "'&'", "'|'", "'xnor'", "'xor'", "'<->'", 
			"'->'", "'='", "'!='", "'>'", "'>='", "'<'", "'<='", "'('", "')'", "','", 
			"'-'", "'+'", "'*'", "'/'", "'mod'", "'?'", "':'", null, null, null, 
			"'TRUE'", "'FALSE'", "'count'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"WS", "REAL_CONST", "INT_CONST", "TRUE", "FALSE", "COUNT", "ID"
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

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode REAL_CONST() { return getToken(ltlParser.REAL_CONST, 0); }
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
		enterRule(_localctx, 0, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << REAL_CONST) | (1L << INT_CONST) | (1L << TRUE) | (1L << FALSE))) != 0)) ) {
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

	public static class Composite_idContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ltlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ltlParser.ID, i);
		}
		public List<TerminalNode> INT_CONST() { return getTokens(ltlParser.INT_CONST); }
		public TerminalNode INT_CONST(int i) {
			return getToken(ltlParser.INT_CONST, i);
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
		enterRule(_localctx, 2, RULE_composite_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(ID);
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(63);
				match(T__0);
				setState(64);
				match(ID);
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(70);
				match(T__1);
				setState(71);
				match(INT_CONST);
				setState(72);
				match(T__2);
				}
				}
				setState(77);
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

	public static class Unary_operator_signContext extends ParserRuleContext {
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
		enterRule(_localctx, 4, RULE_unary_operator_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) ) {
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

	public static class Binary_operator_sign5Context extends ParserRuleContext {
		public Binary_operator_sign5Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_operator_sign5; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterBinary_operator_sign5(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitBinary_operator_sign5(this);
		}
	}

	public final Binary_operator_sign5Context binary_operator_sign5() throws RecognitionException {
		Binary_operator_sign5Context _localctx = new Binary_operator_sign5Context(_ctx, getState());
		enterRule(_localctx, 6, RULE_binary_operator_sign5);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_la = _input.LA(1);
			if ( !(_la==T__11 || _la==T__12) ) {
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

	public static class Binary_operator_sign4Context extends ParserRuleContext {
		public Binary_operator_sign4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_operator_sign4; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterBinary_operator_sign4(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitBinary_operator_sign4(this);
		}
	}

	public final Binary_operator_sign4Context binary_operator_sign4() throws RecognitionException {
		Binary_operator_sign4Context _localctx = new Binary_operator_sign4Context(_ctx, getState());
		enterRule(_localctx, 8, RULE_binary_operator_sign4);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(T__13);
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

	public static class Binary_operator_sign3Context extends ParserRuleContext {
		public Binary_operator_sign3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_operator_sign3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterBinary_operator_sign3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitBinary_operator_sign3(this);
		}
	}

	public final Binary_operator_sign3Context binary_operator_sign3() throws RecognitionException {
		Binary_operator_sign3Context _localctx = new Binary_operator_sign3Context(_ctx, getState());
		enterRule(_localctx, 10, RULE_binary_operator_sign3);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16))) != 0)) ) {
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

	public static class Binary_operator_sign2Context extends ParserRuleContext {
		public Binary_operator_sign2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_operator_sign2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterBinary_operator_sign2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitBinary_operator_sign2(this);
		}
	}

	public final Binary_operator_sign2Context binary_operator_sign2() throws RecognitionException {
		Binary_operator_sign2Context _localctx = new Binary_operator_sign2Context(_ctx, getState());
		enterRule(_localctx, 12, RULE_binary_operator_sign2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__17);
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

	public static class Binary_operator_sign1Context extends ParserRuleContext {
		public Binary_operator_sign1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_operator_sign1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterBinary_operator_sign1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitBinary_operator_sign1(this);
		}
	}

	public final Binary_operator_sign1Context binary_operator_sign1() throws RecognitionException {
		Binary_operator_sign1Context _localctx = new Binary_operator_sign1Context(_ctx, getState());
		enterRule(_localctx, 14, RULE_binary_operator_sign1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T__18);
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
		enterRule(_localctx, 16, RULE_comparison_operator_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24))) != 0)) ) {
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

	public static class Arithmetic_atomic_valueContext extends ParserRuleContext {
		public ArithmeticExpression f;
		public ConstantContext constant;
		public Composite_idContext composite_id;
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public Composite_idContext composite_id() {
			return getRuleContext(Composite_idContext.class,0);
		}
		public Arithmetic_atomic_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic_atomic_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterArithmetic_atomic_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitArithmetic_atomic_value(this);
		}
	}

	public final Arithmetic_atomic_valueContext arithmetic_atomic_value() throws RecognitionException {
		Arithmetic_atomic_valueContext _localctx = new Arithmetic_atomic_valueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_arithmetic_atomic_value);
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REAL_CONST:
			case INT_CONST:
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				((Arithmetic_atomic_valueContext)_localctx).constant = constant();
				 ((Arithmetic_atomic_valueContext)_localctx).f =  new Constant((((Arithmetic_atomic_valueContext)_localctx).constant!=null?_input.getText(((Arithmetic_atomic_valueContext)_localctx).constant.start,((Arithmetic_atomic_valueContext)_localctx).constant.stop):null)); 
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				((Arithmetic_atomic_valueContext)_localctx).composite_id = composite_id();
				 ((Arithmetic_atomic_valueContext)_localctx).f =  new Variable((((Arithmetic_atomic_valueContext)_localctx).composite_id!=null?_input.getText(((Arithmetic_atomic_valueContext)_localctx).composite_id.start,((Arithmetic_atomic_valueContext)_localctx).composite_id.stop):null)); 
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
		public Arithmetic_atomic_valueContext arithmetic_atomic_value;
		public Implies_arithmetic_expressionContext implies_arithmetic_expression;
		public Implies_arithmetic_expressionContext f1;
		public Implies_arithmetic_expressionContext f2;
		public Arithmetic_atomic_valueContext arithmetic_atomic_value() {
			return getRuleContext(Arithmetic_atomic_valueContext.class,0);
		}
		public List<Implies_arithmetic_expressionContext> implies_arithmetic_expression() {
			return getRuleContexts(Implies_arithmetic_expressionContext.class);
		}
		public Implies_arithmetic_expressionContext implies_arithmetic_expression(int i) {
			return getRuleContext(Implies_arithmetic_expressionContext.class,i);
		}
		public TerminalNode COUNT() { return getToken(ltlParser.COUNT, 0); }
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
		enterRule(_localctx, 20, RULE_arithmetic_atom);
		int _la;
		try {
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REAL_CONST:
			case INT_CONST:
			case TRUE:
			case FALSE:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				((Arithmetic_atomContext)_localctx).arithmetic_atomic_value = arithmetic_atomic_value();
				 ((Arithmetic_atomContext)_localctx).f =  ((Arithmetic_atomContext)_localctx).arithmetic_atomic_value.f; 
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				match(T__25);
				setState(104);
				((Arithmetic_atomContext)_localctx).implies_arithmetic_expression = implies_arithmetic_expression();
				setState(105);
				match(T__26);
				 ((Arithmetic_atomContext)_localctx).f =  ((Arithmetic_atomContext)_localctx).implies_arithmetic_expression.f; 
				}
				break;
			case COUNT:
				enterOuterAlt(_localctx, 3);
				{
				setState(108);
				match(COUNT);
				setState(109);
				match(T__25);
				 List<ArithmeticExpression> args = new ArrayList<>(); 
				setState(111);
				((Arithmetic_atomContext)_localctx).f1 = implies_arithmetic_expression();
				 args.add(((Arithmetic_atomContext)_localctx).f1.f); 
				setState(117); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(113);
					match(T__27);
					setState(114);
					((Arithmetic_atomContext)_localctx).f2 = implies_arithmetic_expression();
					 args.add(((Arithmetic_atomContext)_localctx).f2.f); 
					}
					}
					setState(119); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__27 );
				setState(121);
				match(T__26);
				 ((Arithmetic_atomContext)_localctx).f =  new CountArithmeticOperator(args); 
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
		enterRule(_localctx, 22, RULE_arithmetic_expression3);
		try {
			setState(141);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__25:
			case REAL_CONST:
			case INT_CONST:
			case TRUE:
			case FALSE:
			case COUNT:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				((Arithmetic_expression3Context)_localctx).arithmetic_atom = arithmetic_atom();
				 ((Arithmetic_expression3Context)_localctx).f =  ((Arithmetic_expression3Context)_localctx).arithmetic_atom.f; 
				}
				break;
			case T__3:
			case T__28:
			case T__29:
				enterOuterAlt(_localctx, 2);
				{
				 String op; 
				setState(136);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__28:
					{
					setState(130);
					match(T__28);
					 op = "-"; 
					}
					break;
				case T__29:
					{
					setState(132);
					match(T__29);
					 op = "+"; 
					}
					break;
				case T__3:
					{
					setState(134);
					match(T__3);
					 op = "!"; 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(138);
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
		enterRule(_localctx, 24, RULE_arithmetic_expression2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			((Arithmetic_expression2Context)_localctx).f1 = arithmetic_expression3();
			 ((Arithmetic_expression2Context)_localctx).f =  ((Arithmetic_expression2Context)_localctx).f1.f; String op; 
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__31) | (1L << T__32))) != 0)) {
				{
				{
				setState(151);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__30:
					{
					setState(145);
					match(T__30);
					 op = "*"; 
					}
					break;
				case T__31:
					{
					setState(147);
					match(T__31);
					 op = "/"; 
					}
					break;
				case T__32:
					{
					setState(149);
					match(T__32);
					 op = "mod"; 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(153);
				((Arithmetic_expression2Context)_localctx).f2 = arithmetic_expression3();
				 ((Arithmetic_expression2Context)_localctx).f =  new BinaryArithmeticOperator(op, _localctx.f, ((Arithmetic_expression2Context)_localctx).f2.f); 
				}
				}
				setState(160);
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
		enterRule(_localctx, 26, RULE_arithmetic_expression1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			((Arithmetic_expression1Context)_localctx).f1 = arithmetic_expression2();
			 ((Arithmetic_expression1Context)_localctx).f =  ((Arithmetic_expression1Context)_localctx).f1.f; String op; 
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__28 || _la==T__29) {
				{
				{
				setState(167);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__29:
					{
					setState(163);
					match(T__29);
					 op = "+"; 
					}
					break;
				case T__28:
					{
					setState(165);
					match(T__28);
					 op = "-"; 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(169);
				((Arithmetic_expression1Context)_localctx).f2 = arithmetic_expression2();
				 ((Arithmetic_expression1Context)_localctx).f =  new BinaryArithmeticOperator(op, _localctx.f, ((Arithmetic_expression1Context)_localctx).f2.f); 
				}
				}
				setState(176);
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
		enterRule(_localctx, 28, RULE_comparison_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			((Comparison_expressionContext)_localctx).f1 = arithmetic_expression1();
			 ((Comparison_expressionContext)_localctx).f =  ((Comparison_expressionContext)_localctx).f1.f; 
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24))) != 0)) {
				{
				setState(179);
				((Comparison_expressionContext)_localctx).comparison_operator_sign = comparison_operator_sign();
				setState(180);
				((Comparison_expressionContext)_localctx).f2 = arithmetic_expression1();
				 ((Comparison_expressionContext)_localctx).f =  new ComparisonOperator((((Comparison_expressionContext)_localctx).comparison_operator_sign!=null?_input.getText(((Comparison_expressionContext)_localctx).comparison_operator_sign.start,((Comparison_expressionContext)_localctx).comparison_operator_sign.stop):null), _localctx.f, ((Comparison_expressionContext)_localctx).f2.f); 
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

	public static class And_arithmetic_expressionContext extends ParserRuleContext {
		public ArithmeticExpression f;
		public Comparison_expressionContext f1;
		public Comparison_expressionContext f2;
		public List<Comparison_expressionContext> comparison_expression() {
			return getRuleContexts(Comparison_expressionContext.class);
		}
		public Comparison_expressionContext comparison_expression(int i) {
			return getRuleContext(Comparison_expressionContext.class,i);
		}
		public And_arithmetic_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_arithmetic_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterAnd_arithmetic_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitAnd_arithmetic_expression(this);
		}
	}

	public final And_arithmetic_expressionContext and_arithmetic_expression() throws RecognitionException {
		And_arithmetic_expressionContext _localctx = new And_arithmetic_expressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_and_arithmetic_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			((And_arithmetic_expressionContext)_localctx).f1 = comparison_expression();
			 ((And_arithmetic_expressionContext)_localctx).f =  ((And_arithmetic_expressionContext)_localctx).f1.f; 
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(187);
				match(T__13);
				setState(188);
				((And_arithmetic_expressionContext)_localctx).f2 = comparison_expression();
				 ((And_arithmetic_expressionContext)_localctx).f =  new BinaryArithmeticOperator("&", _localctx.f, ((And_arithmetic_expressionContext)_localctx).f2.f); 
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

	public static class Or_arithmetic_expressionContext extends ParserRuleContext {
		public ArithmeticExpression f;
		public And_arithmetic_expressionContext f1;
		public And_arithmetic_expressionContext f2;
		public List<And_arithmetic_expressionContext> and_arithmetic_expression() {
			return getRuleContexts(And_arithmetic_expressionContext.class);
		}
		public And_arithmetic_expressionContext and_arithmetic_expression(int i) {
			return getRuleContext(And_arithmetic_expressionContext.class,i);
		}
		public Or_arithmetic_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_arithmetic_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterOr_arithmetic_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitOr_arithmetic_expression(this);
		}
	}

	public final Or_arithmetic_expressionContext or_arithmetic_expression() throws RecognitionException {
		Or_arithmetic_expressionContext _localctx = new Or_arithmetic_expressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_or_arithmetic_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			((Or_arithmetic_expressionContext)_localctx).f1 = and_arithmetic_expression();
			 ((Or_arithmetic_expressionContext)_localctx).f =  ((Or_arithmetic_expressionContext)_localctx).f1.f; String op; 
			setState(206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(201);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__14:
					{
					setState(195);
					match(T__14);
					 op = "|"; 
					}
					break;
				case T__16:
					{
					setState(197);
					match(T__16);
					 op = "xor"; 
					}
					break;
				case T__15:
					{
					setState(199);
					match(T__15);
					 op = "xnor"; 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(203);
				((Or_arithmetic_expressionContext)_localctx).f2 = and_arithmetic_expression();
				 ((Or_arithmetic_expressionContext)_localctx).f =  new BinaryArithmeticOperator(op, _localctx.f, ((Or_arithmetic_expressionContext)_localctx).f2.f); 
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

	public static class Ternary_arithmetic_expressionContext extends ParserRuleContext {
		public ArithmeticExpression f;
		public Or_arithmetic_expressionContext f1;
		public Or_arithmetic_expressionContext f2;
		public Or_arithmetic_expressionContext f3;
		public List<Or_arithmetic_expressionContext> or_arithmetic_expression() {
			return getRuleContexts(Or_arithmetic_expressionContext.class);
		}
		public Or_arithmetic_expressionContext or_arithmetic_expression(int i) {
			return getRuleContext(Or_arithmetic_expressionContext.class,i);
		}
		public Ternary_arithmetic_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ternary_arithmetic_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterTernary_arithmetic_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitTernary_arithmetic_expression(this);
		}
	}

	public final Ternary_arithmetic_expressionContext ternary_arithmetic_expression() throws RecognitionException {
		Ternary_arithmetic_expressionContext _localctx = new Ternary_arithmetic_expressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_ternary_arithmetic_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			((Ternary_arithmetic_expressionContext)_localctx).f1 = or_arithmetic_expression();
			 ((Ternary_arithmetic_expressionContext)_localctx).f =  ((Ternary_arithmetic_expressionContext)_localctx).f1.f; 
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__33) {
				{
				setState(210);
				match(T__33);
				setState(211);
				((Ternary_arithmetic_expressionContext)_localctx).f2 = or_arithmetic_expression();
				setState(212);
				match(T__34);
				setState(213);
				((Ternary_arithmetic_expressionContext)_localctx).f3 = or_arithmetic_expression();
				 ((Ternary_arithmetic_expressionContext)_localctx).f =  new TernaryArithmeticOperator(((Ternary_arithmetic_expressionContext)_localctx).f1.f, ((Ternary_arithmetic_expressionContext)_localctx).f2.f, ((Ternary_arithmetic_expressionContext)_localctx).f3.f); 
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

	public static class Eq_arithmetic_expressionContext extends ParserRuleContext {
		public ArithmeticExpression f;
		public Ternary_arithmetic_expressionContext f1;
		public Ternary_arithmetic_expressionContext f2;
		public List<Ternary_arithmetic_expressionContext> ternary_arithmetic_expression() {
			return getRuleContexts(Ternary_arithmetic_expressionContext.class);
		}
		public Ternary_arithmetic_expressionContext ternary_arithmetic_expression(int i) {
			return getRuleContext(Ternary_arithmetic_expressionContext.class,i);
		}
		public Eq_arithmetic_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eq_arithmetic_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterEq_arithmetic_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitEq_arithmetic_expression(this);
		}
	}

	public final Eq_arithmetic_expressionContext eq_arithmetic_expression() throws RecognitionException {
		Eq_arithmetic_expressionContext _localctx = new Eq_arithmetic_expressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_eq_arithmetic_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			((Eq_arithmetic_expressionContext)_localctx).f1 = ternary_arithmetic_expression();
			 ((Eq_arithmetic_expressionContext)_localctx).f =  ((Eq_arithmetic_expressionContext)_localctx).f1.f; 
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(220);
				match(T__17);
				setState(221);
				((Eq_arithmetic_expressionContext)_localctx).f2 = ternary_arithmetic_expression();
				 ((Eq_arithmetic_expressionContext)_localctx).f =  new BinaryArithmeticOperator("<->", _localctx.f, ((Eq_arithmetic_expressionContext)_localctx).f2.f); 
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

	public static class Implies_arithmetic_expressionContext extends ParserRuleContext {
		public ArithmeticExpression f;
		public Eq_arithmetic_expressionContext f1;
		public Implies_arithmetic_expressionContext f2;
		public Eq_arithmetic_expressionContext eq_arithmetic_expression() {
			return getRuleContext(Eq_arithmetic_expressionContext.class,0);
		}
		public Implies_arithmetic_expressionContext implies_arithmetic_expression() {
			return getRuleContext(Implies_arithmetic_expressionContext.class,0);
		}
		public Implies_arithmetic_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_implies_arithmetic_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterImplies_arithmetic_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitImplies_arithmetic_expression(this);
		}
	}

	public final Implies_arithmetic_expressionContext implies_arithmetic_expression() throws RecognitionException {
		Implies_arithmetic_expressionContext _localctx = new Implies_arithmetic_expressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_implies_arithmetic_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			((Implies_arithmetic_expressionContext)_localctx).f1 = eq_arithmetic_expression();
			 ((Implies_arithmetic_expressionContext)_localctx).f =  ((Implies_arithmetic_expressionContext)_localctx).f1.f; 
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(228);
				match(T__18);
				setState(229);
				((Implies_arithmetic_expressionContext)_localctx).f2 = implies_arithmetic_expression();
				 ((Implies_arithmetic_expressionContext)_localctx).f =  new BinaryArithmeticOperator("->", _localctx.f, ((Implies_arithmetic_expressionContext)_localctx).f2.f); 
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
		public ArithmeticExpression f;
		public Arithmetic_expression1Context f1;
		public Comparison_operator_signContext comparison_operator_sign;
		public Arithmetic_expression1Context f2;
		public Or_arithmetic_expressionContext o1;
		public Or_arithmetic_expressionContext o2;
		public Or_arithmetic_expressionContext o3;
		public Arithmetic_atomic_valueContext arithmetic_atomic_value;
		public Comparison_operator_signContext comparison_operator_sign() {
			return getRuleContext(Comparison_operator_signContext.class,0);
		}
		public List<Arithmetic_expression1Context> arithmetic_expression1() {
			return getRuleContexts(Arithmetic_expression1Context.class);
		}
		public Arithmetic_expression1Context arithmetic_expression1(int i) {
			return getRuleContext(Arithmetic_expression1Context.class,i);
		}
		public List<Or_arithmetic_expressionContext> or_arithmetic_expression() {
			return getRuleContexts(Or_arithmetic_expressionContext.class);
		}
		public Or_arithmetic_expressionContext or_arithmetic_expression(int i) {
			return getRuleContext(Or_arithmetic_expressionContext.class,i);
		}
		public Arithmetic_atomic_valueContext arithmetic_atomic_value() {
			return getRuleContext(Arithmetic_atomic_valueContext.class,0);
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
		enterRule(_localctx, 40, RULE_proposition);
		try {
			setState(249);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				((PropositionContext)_localctx).f1 = arithmetic_expression1();
				setState(235);
				((PropositionContext)_localctx).comparison_operator_sign = comparison_operator_sign();
				setState(236);
				((PropositionContext)_localctx).f2 = arithmetic_expression1();
				 ((PropositionContext)_localctx).f =  new ComparisonOperator((((PropositionContext)_localctx).comparison_operator_sign!=null?_input.getText(((PropositionContext)_localctx).comparison_operator_sign.start,((PropositionContext)_localctx).comparison_operator_sign.stop):null), ((PropositionContext)_localctx).f1.f, ((PropositionContext)_localctx).f2.f); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
				((PropositionContext)_localctx).o1 = or_arithmetic_expression();
				setState(240);
				match(T__33);
				setState(241);
				((PropositionContext)_localctx).o2 = or_arithmetic_expression();
				setState(242);
				match(T__34);
				setState(243);
				((PropositionContext)_localctx).o3 = or_arithmetic_expression();
				 ((PropositionContext)_localctx).f =  new TernaryArithmeticOperator(((PropositionContext)_localctx).o1.f, ((PropositionContext)_localctx).o2.f, ((PropositionContext)_localctx).o3.f); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(246);
				((PropositionContext)_localctx).arithmetic_atomic_value = arithmetic_atomic_value();
				 ((PropositionContext)_localctx).f =  ((PropositionContext)_localctx).arithmetic_atomic_value.f; 
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

	public static class AtomContext extends ParserRuleContext {
		public LTLFormula f;
		public FormulaContext formula;
		public PropositionContext proposition;
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public PropositionContext proposition() {
			return getRuleContext(PropositionContext.class,0);
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
		enterRule(_localctx, 42, RULE_atom);
		try {
			setState(259);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				match(T__25);
				setState(252);
				((AtomContext)_localctx).formula = formula();
				setState(253);
				match(T__26);
				 ((AtomContext)_localctx).f =  ((AtomContext)_localctx).formula.f; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(256);
				((AtomContext)_localctx).proposition = proposition();
				 ((AtomContext)_localctx).f =  new Proposition(((AtomContext)_localctx).proposition.f); 
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
		enterRule(_localctx, 44, RULE_unary_operator);
		try {
			setState(268);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(261);
				((Unary_operatorContext)_localctx).atom = atom();
				 ((Unary_operatorContext)_localctx).f =  ((Unary_operatorContext)_localctx).atom.f; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(264);
				((Unary_operatorContext)_localctx).unary_operator_sign = unary_operator_sign();
				setState(265);
				((Unary_operatorContext)_localctx).unary_operator = unary_operator();
				 ((Unary_operatorContext)_localctx).f =  new UnaryOperator((((Unary_operatorContext)_localctx).unary_operator_sign!=null?_input.getText(((Unary_operatorContext)_localctx).unary_operator_sign.start,((Unary_operatorContext)_localctx).unary_operator_sign.stop):null), ((Unary_operatorContext)_localctx).unary_operator.f); 
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

	public static class Binary_operator5Context extends ParserRuleContext {
		public LTLFormula f;
		public Unary_operatorContext f1;
		public Binary_operator_sign5Context binary_operator_sign5;
		public Unary_operatorContext f2;
		public List<Unary_operatorContext> unary_operator() {
			return getRuleContexts(Unary_operatorContext.class);
		}
		public Unary_operatorContext unary_operator(int i) {
			return getRuleContext(Unary_operatorContext.class,i);
		}
		public List<Binary_operator_sign5Context> binary_operator_sign5() {
			return getRuleContexts(Binary_operator_sign5Context.class);
		}
		public Binary_operator_sign5Context binary_operator_sign5(int i) {
			return getRuleContext(Binary_operator_sign5Context.class,i);
		}
		public Binary_operator5Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_operator5; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterBinary_operator5(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitBinary_operator5(this);
		}
	}

	public final Binary_operator5Context binary_operator5() throws RecognitionException {
		Binary_operator5Context _localctx = new Binary_operator5Context(_ctx, getState());
		enterRule(_localctx, 46, RULE_binary_operator5);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			((Binary_operator5Context)_localctx).f1 = unary_operator();
			 ((Binary_operator5Context)_localctx).f =  ((Binary_operator5Context)_localctx).f1.f; 
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11 || _la==T__12) {
				{
				{
				setState(272);
				((Binary_operator5Context)_localctx).binary_operator_sign5 = binary_operator_sign5();
				setState(273);
				((Binary_operator5Context)_localctx).f2 = unary_operator();
				 ((Binary_operator5Context)_localctx).f =  new BinaryOperator((((Binary_operator5Context)_localctx).binary_operator_sign5!=null?_input.getText(((Binary_operator5Context)_localctx).binary_operator_sign5.start,((Binary_operator5Context)_localctx).binary_operator_sign5.stop):null), _localctx.f, ((Binary_operator5Context)_localctx).f2.f); 
				}
				}
				setState(280);
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

	public static class Binary_operator4Context extends ParserRuleContext {
		public LTLFormula f;
		public Binary_operator5Context f1;
		public Binary_operator_sign4Context binary_operator_sign4;
		public Binary_operator5Context f2;
		public List<Binary_operator5Context> binary_operator5() {
			return getRuleContexts(Binary_operator5Context.class);
		}
		public Binary_operator5Context binary_operator5(int i) {
			return getRuleContext(Binary_operator5Context.class,i);
		}
		public List<Binary_operator_sign4Context> binary_operator_sign4() {
			return getRuleContexts(Binary_operator_sign4Context.class);
		}
		public Binary_operator_sign4Context binary_operator_sign4(int i) {
			return getRuleContext(Binary_operator_sign4Context.class,i);
		}
		public Binary_operator4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_operator4; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterBinary_operator4(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitBinary_operator4(this);
		}
	}

	public final Binary_operator4Context binary_operator4() throws RecognitionException {
		Binary_operator4Context _localctx = new Binary_operator4Context(_ctx, getState());
		enterRule(_localctx, 48, RULE_binary_operator4);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			((Binary_operator4Context)_localctx).f1 = binary_operator5();
			 ((Binary_operator4Context)_localctx).f =  ((Binary_operator4Context)_localctx).f1.f; 
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(283);
				((Binary_operator4Context)_localctx).binary_operator_sign4 = binary_operator_sign4();
				setState(284);
				((Binary_operator4Context)_localctx).f2 = binary_operator5();
				 ((Binary_operator4Context)_localctx).f =  new BinaryOperator((((Binary_operator4Context)_localctx).binary_operator_sign4!=null?_input.getText(((Binary_operator4Context)_localctx).binary_operator_sign4.start,((Binary_operator4Context)_localctx).binary_operator_sign4.stop):null), _localctx.f, ((Binary_operator4Context)_localctx).f2.f); 
				}
				}
				setState(291);
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

	public static class Binary_operator3Context extends ParserRuleContext {
		public LTLFormula f;
		public Binary_operator4Context f1;
		public Binary_operator_sign3Context binary_operator_sign3;
		public Binary_operator4Context f2;
		public List<Binary_operator4Context> binary_operator4() {
			return getRuleContexts(Binary_operator4Context.class);
		}
		public Binary_operator4Context binary_operator4(int i) {
			return getRuleContext(Binary_operator4Context.class,i);
		}
		public List<Binary_operator_sign3Context> binary_operator_sign3() {
			return getRuleContexts(Binary_operator_sign3Context.class);
		}
		public Binary_operator_sign3Context binary_operator_sign3(int i) {
			return getRuleContext(Binary_operator_sign3Context.class,i);
		}
		public Binary_operator3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_operator3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterBinary_operator3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitBinary_operator3(this);
		}
	}

	public final Binary_operator3Context binary_operator3() throws RecognitionException {
		Binary_operator3Context _localctx = new Binary_operator3Context(_ctx, getState());
		enterRule(_localctx, 50, RULE_binary_operator3);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			((Binary_operator3Context)_localctx).f1 = binary_operator4();
			 ((Binary_operator3Context)_localctx).f =  ((Binary_operator3Context)_localctx).f1.f; 
			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16))) != 0)) {
				{
				{
				setState(294);
				((Binary_operator3Context)_localctx).binary_operator_sign3 = binary_operator_sign3();
				setState(295);
				((Binary_operator3Context)_localctx).f2 = binary_operator4();
				 ((Binary_operator3Context)_localctx).f =  new BinaryOperator((((Binary_operator3Context)_localctx).binary_operator_sign3!=null?_input.getText(((Binary_operator3Context)_localctx).binary_operator_sign3.start,((Binary_operator3Context)_localctx).binary_operator_sign3.stop):null), _localctx.f, ((Binary_operator3Context)_localctx).f2.f); 
				}
				}
				setState(302);
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

	public static class Binary_operator2Context extends ParserRuleContext {
		public LTLFormula f;
		public Binary_operator3Context f1;
		public Binary_operator_sign2Context binary_operator_sign2;
		public Binary_operator3Context f2;
		public List<Binary_operator3Context> binary_operator3() {
			return getRuleContexts(Binary_operator3Context.class);
		}
		public Binary_operator3Context binary_operator3(int i) {
			return getRuleContext(Binary_operator3Context.class,i);
		}
		public List<Binary_operator_sign2Context> binary_operator_sign2() {
			return getRuleContexts(Binary_operator_sign2Context.class);
		}
		public Binary_operator_sign2Context binary_operator_sign2(int i) {
			return getRuleContext(Binary_operator_sign2Context.class,i);
		}
		public Binary_operator2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_operator2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterBinary_operator2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitBinary_operator2(this);
		}
	}

	public final Binary_operator2Context binary_operator2() throws RecognitionException {
		Binary_operator2Context _localctx = new Binary_operator2Context(_ctx, getState());
		enterRule(_localctx, 52, RULE_binary_operator2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			((Binary_operator2Context)_localctx).f1 = binary_operator3();
			 ((Binary_operator2Context)_localctx).f =  ((Binary_operator2Context)_localctx).f1.f; 
			setState(311);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17) {
				{
				{
				setState(305);
				((Binary_operator2Context)_localctx).binary_operator_sign2 = binary_operator_sign2();
				setState(306);
				((Binary_operator2Context)_localctx).f2 = binary_operator3();
				 ((Binary_operator2Context)_localctx).f =  new BinaryOperator((((Binary_operator2Context)_localctx).binary_operator_sign2!=null?_input.getText(((Binary_operator2Context)_localctx).binary_operator_sign2.start,((Binary_operator2Context)_localctx).binary_operator_sign2.stop):null), _localctx.f, ((Binary_operator2Context)_localctx).f2.f); 
				}
				}
				setState(313);
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

	public static class Binary_operator1Context extends ParserRuleContext {
		public LTLFormula f;
		public Binary_operator2Context f1;
		public Binary_operator_sign1Context binary_operator_sign1;
		public Binary_operator1Context f2;
		public Binary_operator2Context binary_operator2() {
			return getRuleContext(Binary_operator2Context.class,0);
		}
		public Binary_operator_sign1Context binary_operator_sign1() {
			return getRuleContext(Binary_operator_sign1Context.class,0);
		}
		public Binary_operator1Context binary_operator1() {
			return getRuleContext(Binary_operator1Context.class,0);
		}
		public Binary_operator1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_operator1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterBinary_operator1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitBinary_operator1(this);
		}
	}

	public final Binary_operator1Context binary_operator1() throws RecognitionException {
		Binary_operator1Context _localctx = new Binary_operator1Context(_ctx, getState());
		enterRule(_localctx, 54, RULE_binary_operator1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			((Binary_operator1Context)_localctx).f1 = binary_operator2();
			 ((Binary_operator1Context)_localctx).f =  ((Binary_operator1Context)_localctx).f1.f; 
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(316);
				((Binary_operator1Context)_localctx).binary_operator_sign1 = binary_operator_sign1();
				setState(317);
				((Binary_operator1Context)_localctx).f2 = binary_operator1();
				 ((Binary_operator1Context)_localctx).f =  new BinaryOperator((((Binary_operator1Context)_localctx).binary_operator_sign1!=null?_input.getText(((Binary_operator1Context)_localctx).binary_operator_sign1.start,((Binary_operator1Context)_localctx).binary_operator_sign1.stop):null), _localctx.f, ((Binary_operator1Context)_localctx).f2.f); 
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
		public Binary_operator1Context binary_operator1;
		public Binary_operator1Context binary_operator1() {
			return getRuleContext(Binary_operator1Context.class,0);
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
		enterRule(_localctx, 56, RULE_formula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			((FormulaContext)_localctx).binary_operator1 = binary_operator1();
			 ((FormulaContext)_localctx).f =  ((FormulaContext)_localctx).binary_operator1.f; 
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

	public static class Formula_eofContext extends ParserRuleContext {
		public LTLFormula f;
		public FormulaContext formula;
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ltlParser.EOF, 0); }
		public Formula_eofContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula_eof; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).enterFormula_eof(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ltlListener ) ((ltlListener)listener).exitFormula_eof(this);
		}
	}

	public final Formula_eofContext formula_eof() throws RecognitionException {
		Formula_eofContext _localctx = new Formula_eofContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_formula_eof);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			((Formula_eofContext)_localctx).formula = formula();
			 ((Formula_eofContext)_localctx).f =  ((Formula_eofContext)_localctx).formula.f; 
			setState(327);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u014c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\3\3\3\3\3\7\3D\n\3\f\3\16\3G\13\3\3\3\3\3\3\3\7\3L\n\3\f\3\16\3O\13\3"+
		"\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13e\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\6\fx\n\f\r\f\16\fy\3\f\3\f\3\f\5\f\177\n\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u008b\n\r\3\r\3\r\3\r\5\r\u0090"+
		"\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u009a\n\16\3\16\3\16"+
		"\3\16\7\16\u009f\n\16\f\16\16\16\u00a2\13\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\5\17\u00aa\n\17\3\17\3\17\3\17\7\17\u00af\n\17\f\17\16\17\u00b2"+
		"\13\17\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00ba\n\20\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\5\21\u00c2\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\5\22\u00cc\n\22\3\22\3\22\3\22\5\22\u00d1\n\22\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\5\23\u00db\n\23\3\24\3\24\3\24\3\24\3\24\3\24\5\24"+
		"\u00e3\n\24\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00eb\n\25\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00fc"+
		"\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0106\n\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\5\30\u010f\n\30\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\7\31\u0117\n\31\f\31\16\31\u011a\13\31\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\7\32\u0122\n\32\f\32\16\32\u0125\13\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\7\33\u012d\n\33\f\33\16\33\u0130\13\33\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\7\34\u0138\n\34\f\34\16\34\u013b\13\34\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\5\35\u0143\n\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\2\2 \2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<\2\7\3\2\'*\3\2"+
		"\6\r\3\2\16\17\3\2\21\23\3\2\26\33\2\u014c\2>\3\2\2\2\4@\3\2\2\2\6P\3"+
		"\2\2\2\bR\3\2\2\2\nT\3\2\2\2\fV\3\2\2\2\16X\3\2\2\2\20Z\3\2\2\2\22\\\3"+
		"\2\2\2\24d\3\2\2\2\26~\3\2\2\2\30\u008f\3\2\2\2\32\u0091\3\2\2\2\34\u00a3"+
		"\3\2\2\2\36\u00b3\3\2\2\2 \u00bb\3\2\2\2\"\u00c3\3\2\2\2$\u00d2\3\2\2"+
		"\2&\u00dc\3\2\2\2(\u00e4\3\2\2\2*\u00fb\3\2\2\2,\u0105\3\2\2\2.\u010e"+
		"\3\2\2\2\60\u0110\3\2\2\2\62\u011b\3\2\2\2\64\u0126\3\2\2\2\66\u0131\3"+
		"\2\2\28\u013c\3\2\2\2:\u0144\3\2\2\2<\u0147\3\2\2\2>?\t\2\2\2?\3\3\2\2"+
		"\2@E\7,\2\2AB\7\3\2\2BD\7,\2\2CA\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2"+
		"FM\3\2\2\2GE\3\2\2\2HI\7\4\2\2IJ\7(\2\2JL\7\5\2\2KH\3\2\2\2LO\3\2\2\2"+
		"MK\3\2\2\2MN\3\2\2\2N\5\3\2\2\2OM\3\2\2\2PQ\t\3\2\2Q\7\3\2\2\2RS\t\4\2"+
		"\2S\t\3\2\2\2TU\7\20\2\2U\13\3\2\2\2VW\t\5\2\2W\r\3\2\2\2XY\7\24\2\2Y"+
		"\17\3\2\2\2Z[\7\25\2\2[\21\3\2\2\2\\]\t\6\2\2]\23\3\2\2\2^_\5\2\2\2_`"+
		"\b\13\1\2`e\3\2\2\2ab\5\4\3\2bc\b\13\1\2ce\3\2\2\2d^\3\2\2\2da\3\2\2\2"+
		"e\25\3\2\2\2fg\5\24\13\2gh\b\f\1\2h\177\3\2\2\2ij\7\34\2\2jk\5(\25\2k"+
		"l\7\35\2\2lm\b\f\1\2m\177\3\2\2\2no\7+\2\2op\7\34\2\2pq\b\f\1\2qr\5(\25"+
		"\2rw\b\f\1\2st\7\36\2\2tu\5(\25\2uv\b\f\1\2vx\3\2\2\2ws\3\2\2\2xy\3\2"+
		"\2\2yw\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\7\35\2\2|}\b\f\1\2}\177\3\2\2\2~"+
		"f\3\2\2\2~i\3\2\2\2~n\3\2\2\2\177\27\3\2\2\2\u0080\u0081\5\26\f\2\u0081"+
		"\u0082\b\r\1\2\u0082\u0090\3\2\2\2\u0083\u008a\b\r\1\2\u0084\u0085\7\37"+
		"\2\2\u0085\u008b\b\r\1\2\u0086\u0087\7 \2\2\u0087\u008b\b\r\1\2\u0088"+
		"\u0089\7\6\2\2\u0089\u008b\b\r\1\2\u008a\u0084\3\2\2\2\u008a\u0086\3\2"+
		"\2\2\u008a\u0088\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\5\30\r\2\u008d"+
		"\u008e\b\r\1\2\u008e\u0090\3\2\2\2\u008f\u0080\3\2\2\2\u008f\u0083\3\2"+
		"\2\2\u0090\31\3\2\2\2\u0091\u0092\5\30\r\2\u0092\u00a0\b\16\1\2\u0093"+
		"\u0094\7!\2\2\u0094\u009a\b\16\1\2\u0095\u0096\7\"\2\2\u0096\u009a\b\16"+
		"\1\2\u0097\u0098\7#\2\2\u0098\u009a\b\16\1\2\u0099\u0093\3\2\2\2\u0099"+
		"\u0095\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\5\30"+
		"\r\2\u009c\u009d\b\16\1\2\u009d\u009f\3\2\2\2\u009e\u0099\3\2\2\2\u009f"+
		"\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\33\3\2\2"+
		"\2\u00a2\u00a0\3\2\2\2\u00a3\u00a4\5\32\16\2\u00a4\u00b0\b\17\1\2\u00a5"+
		"\u00a6\7 \2\2\u00a6\u00aa\b\17\1\2\u00a7\u00a8\7\37\2\2\u00a8\u00aa\b"+
		"\17\1\2\u00a9\u00a5\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab"+
		"\u00ac\5\32\16\2\u00ac\u00ad\b\17\1\2\u00ad\u00af\3\2\2\2\u00ae\u00a9"+
		"\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1"+
		"\35\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b4\5\34\17\2\u00b4\u00b9\b\20"+
		"\1\2\u00b5\u00b6\5\22\n\2\u00b6\u00b7\5\34\17\2\u00b7\u00b8\b\20\1\2\u00b8"+
		"\u00ba\3\2\2\2\u00b9\u00b5\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\37\3\2\2"+
		"\2\u00bb\u00bc\5\36\20\2\u00bc\u00c1\b\21\1\2\u00bd\u00be\7\20\2\2\u00be"+
		"\u00bf\5\36\20\2\u00bf\u00c0\b\21\1\2\u00c0\u00c2\3\2\2\2\u00c1\u00bd"+
		"\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2!\3\2\2\2\u00c3\u00c4\5 \21\2\u00c4"+
		"\u00d0\b\22\1\2\u00c5\u00c6\7\21\2\2\u00c6\u00cc\b\22\1\2\u00c7\u00c8"+
		"\7\23\2\2\u00c8\u00cc\b\22\1\2\u00c9\u00ca\7\22\2\2\u00ca\u00cc\b\22\1"+
		"\2\u00cb\u00c5\3\2\2\2\u00cb\u00c7\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cd"+
		"\3\2\2\2\u00cd\u00ce\5 \21\2\u00ce\u00cf\b\22\1\2\u00cf\u00d1\3\2\2\2"+
		"\u00d0\u00cb\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1#\3\2\2\2\u00d2\u00d3\5"+
		"\"\22\2\u00d3\u00da\b\23\1\2\u00d4\u00d5\7$\2\2\u00d5\u00d6\5\"\22\2\u00d6"+
		"\u00d7\7%\2\2\u00d7\u00d8\5\"\22\2\u00d8\u00d9\b\23\1\2\u00d9\u00db\3"+
		"\2\2\2\u00da\u00d4\3\2\2\2\u00da\u00db\3\2\2\2\u00db%\3\2\2\2\u00dc\u00dd"+
		"\5$\23\2\u00dd\u00e2\b\24\1\2\u00de\u00df\7\24\2\2\u00df\u00e0\5$\23\2"+
		"\u00e0\u00e1\b\24\1\2\u00e1\u00e3\3\2\2\2\u00e2\u00de\3\2\2\2\u00e2\u00e3"+
		"\3\2\2\2\u00e3\'\3\2\2\2\u00e4\u00e5\5&\24\2\u00e5\u00ea\b\25\1\2\u00e6"+
		"\u00e7\7\25\2\2\u00e7\u00e8\5(\25\2\u00e8\u00e9\b\25\1\2\u00e9\u00eb\3"+
		"\2\2\2\u00ea\u00e6\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb)\3\2\2\2\u00ec\u00ed"+
		"\5\34\17\2\u00ed\u00ee\5\22\n\2\u00ee\u00ef\5\34\17\2\u00ef\u00f0\b\26"+
		"\1\2\u00f0\u00fc\3\2\2\2\u00f1\u00f2\5\"\22\2\u00f2\u00f3\7$\2\2\u00f3"+
		"\u00f4\5\"\22\2\u00f4\u00f5\7%\2\2\u00f5\u00f6\5\"\22\2\u00f6\u00f7\b"+
		"\26\1\2\u00f7\u00fc\3\2\2\2\u00f8\u00f9\5\24\13\2\u00f9\u00fa\b\26\1\2"+
		"\u00fa\u00fc\3\2\2\2\u00fb\u00ec\3\2\2\2\u00fb\u00f1\3\2\2\2\u00fb\u00f8"+
		"\3\2\2\2\u00fc+\3\2\2\2\u00fd\u00fe\7\34\2\2\u00fe\u00ff\5:\36\2\u00ff"+
		"\u0100\7\35\2\2\u0100\u0101\b\27\1\2\u0101\u0106\3\2\2\2\u0102\u0103\5"+
		"*\26\2\u0103\u0104\b\27\1\2\u0104\u0106\3\2\2\2\u0105\u00fd\3\2\2\2\u0105"+
		"\u0102\3\2\2\2\u0106-\3\2\2\2\u0107\u0108\5,\27\2\u0108\u0109\b\30\1\2"+
		"\u0109\u010f\3\2\2\2\u010a\u010b\5\6\4\2\u010b\u010c\5.\30\2\u010c\u010d"+
		"\b\30\1\2\u010d\u010f\3\2\2\2\u010e\u0107\3\2\2\2\u010e\u010a\3\2\2\2"+
		"\u010f/\3\2\2\2\u0110\u0111\5.\30\2\u0111\u0118\b\31\1\2\u0112\u0113\5"+
		"\b\5\2\u0113\u0114\5.\30\2\u0114\u0115\b\31\1\2\u0115\u0117\3\2\2\2\u0116"+
		"\u0112\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2"+
		"\2\2\u0119\61\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u011c\5\60\31\2\u011c"+
		"\u0123\b\32\1\2\u011d\u011e\5\n\6\2\u011e\u011f\5\60\31\2\u011f\u0120"+
		"\b\32\1\2\u0120\u0122\3\2\2\2\u0121\u011d\3\2\2\2\u0122\u0125\3\2\2\2"+
		"\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\63\3\2\2\2\u0125\u0123"+
		"\3\2\2\2\u0126\u0127\5\62\32\2\u0127\u012e\b\33\1\2\u0128\u0129\5\f\7"+
		"\2\u0129\u012a\5\62\32\2\u012a\u012b\b\33\1\2\u012b\u012d\3\2\2\2\u012c"+
		"\u0128\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2"+
		"\2\2\u012f\65\3\2\2\2\u0130\u012e\3\2\2\2\u0131\u0132\5\64\33\2\u0132"+
		"\u0139\b\34\1\2\u0133\u0134\5\16\b\2\u0134\u0135\5\64\33\2\u0135\u0136"+
		"\b\34\1\2\u0136\u0138\3\2\2\2\u0137\u0133\3\2\2\2\u0138\u013b\3\2\2\2"+
		"\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\67\3\2\2\2\u013b\u0139"+
		"\3\2\2\2\u013c\u013d\5\66\34\2\u013d\u0142\b\35\1\2\u013e\u013f\5\20\t"+
		"\2\u013f\u0140\58\35\2\u0140\u0141\b\35\1\2\u0141\u0143\3\2\2\2\u0142"+
		"\u013e\3\2\2\2\u0142\u0143\3\2\2\2\u01439\3\2\2\2\u0144\u0145\58\35\2"+
		"\u0145\u0146\b\36\1\2\u0146;\3\2\2\2\u0147\u0148\5:\36\2\u0148\u0149\b"+
		"\37\1\2\u0149\u014a\7\2\2\3\u014a=\3\2\2\2\34EMdy~\u008a\u008f\u0099\u00a0"+
		"\u00a9\u00b0\u00b9\u00c1\u00cb\u00d0\u00da\u00e2\u00ea\u00fb\u0105\u010e"+
		"\u0118\u0123\u012e\u0139\u0142";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}