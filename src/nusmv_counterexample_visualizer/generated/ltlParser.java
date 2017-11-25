// Generated from /home/buzhinsky/repos/nusmv_counterexample_visualizer/ltl.g4 by ANTLR 4.6
package nusmv_counterexample_visualizer.generated;

import nusmv_counterexample_visualizer.formula.arithmetic.*;
import nusmv_counterexample_visualizer.formula.ltl.BinaryOperator;
import nusmv_counterexample_visualizer.formula.ltl.LTLFormula;
import nusmv_counterexample_visualizer.formula.ltl.Proposition;
import nusmv_counterexample_visualizer.formula.ltl.UnaryOperator;
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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, WS=37, INT_CONST=38, 
		ID=39;
	public static final int
		RULE_constant = 0, RULE_composite_id = 1, RULE_unary_operator_sign = 2, 
		RULE_binary_operator_sign = 3, RULE_comparison_operator_sign = 4, RULE_arithmetic_atomic_value = 5, 
		RULE_arithmetic_atom = 6, RULE_arithmetic_expression3 = 7, RULE_arithmetic_expression2 = 8, 
		RULE_arithmetic_expression1 = 9, RULE_comparison_expression = 10, RULE_and_arithmetic_expression = 11, 
		RULE_or_arithmetic_expression = 12, RULE_ternary_arithmetic_expression = 13, 
		RULE_eq_arithmetic_expression = 14, RULE_implies_arithmetic_expression = 15, 
		RULE_proposition = 16, RULE_atom = 17, RULE_unary_operator = 18, RULE_binary_operator = 19, 
		RULE_formula = 20;
	public static final String[] ruleNames = {
		"constant", "composite_id", "unary_operator_sign", "binary_operator_sign", 
		"comparison_operator_sign", "arithmetic_atomic_value", "arithmetic_atom", 
		"arithmetic_expression3", "arithmetic_expression2", "arithmetic_expression1", 
		"comparison_expression", "and_arithmetic_expression", "or_arithmetic_expression", 
		"ternary_arithmetic_expression", "eq_arithmetic_expression", "implies_arithmetic_expression", 
		"proposition", "atom", "unary_operator", "binary_operator", "formula"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'TRUE'", "'FALSE'", "'.'", "'['", "']'", "'!'", "'X'", "'G'", "'F'", 
		"'Y'", "'Z'", "'O'", "'H'", "'&'", "'|'", "'->'", "'<->'", "'xnor'", "'xor'", 
		"'U'", "'V'", "'='", "'!='", "'>'", "'>='", "'<'", "'<='", "'('", "')'", 
		"'-'", "'+'", "'*'", "'/'", "'mod'", "'?'", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "WS", "INT_CONST", "ID"
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
	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode INT_CONST() { return getToken(ltlParser.INT_CONST, 0); }
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
			setState(42);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << INT_CONST))) != 0)) ) {
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
			setState(44);
			match(ID);
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(45);
				match(T__2);
				setState(46);
				match(ID);
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(52);
				match(T__3);
				setState(53);
				match(INT_CONST);
				setState(54);
				match(T__4);
				}
				}
				setState(59);
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
			setState(60);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12))) != 0)) ) {
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

	public static class Binary_operator_signContext extends ParserRuleContext {
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
		enterRule(_localctx, 6, RULE_binary_operator_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20))) != 0)) ) {
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
		enterRule(_localctx, 8, RULE_comparison_operator_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26))) != 0)) ) {
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
		enterRule(_localctx, 10, RULE_arithmetic_atomic_value);
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case INT_CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				((Arithmetic_atomic_valueContext)_localctx).constant = constant();
				 ((Arithmetic_atomic_valueContext)_localctx).f =  new Constant((((Arithmetic_atomic_valueContext)_localctx).constant!=null?_input.getText(((Arithmetic_atomic_valueContext)_localctx).constant.start,((Arithmetic_atomic_valueContext)_localctx).constant.stop):null)); 
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
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
		public Arithmetic_atomic_valueContext arithmetic_atomic_value() {
			return getRuleContext(Arithmetic_atomic_valueContext.class,0);
		}
		public Implies_arithmetic_expressionContext implies_arithmetic_expression() {
			return getRuleContext(Implies_arithmetic_expressionContext.class,0);
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
		enterRule(_localctx, 12, RULE_arithmetic_atom);
		try {
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case INT_CONST:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				((Arithmetic_atomContext)_localctx).arithmetic_atomic_value = arithmetic_atomic_value();
				 ((Arithmetic_atomContext)_localctx).f =  ((Arithmetic_atomContext)_localctx).arithmetic_atomic_value.f; 
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				match(T__27);
				setState(78);
				((Arithmetic_atomContext)_localctx).implies_arithmetic_expression = implies_arithmetic_expression();
				setState(79);
				match(T__28);
				 ((Arithmetic_atomContext)_localctx).f =  ((Arithmetic_atomContext)_localctx).implies_arithmetic_expression.f; 
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
		enterRule(_localctx, 14, RULE_arithmetic_expression3);
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__27:
			case INT_CONST:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				((Arithmetic_expression3Context)_localctx).arithmetic_atom = arithmetic_atom();
				 ((Arithmetic_expression3Context)_localctx).f =  ((Arithmetic_expression3Context)_localctx).arithmetic_atom.f; 
				}
				break;
			case T__5:
			case T__29:
			case T__30:
				enterOuterAlt(_localctx, 2);
				{
				 String op; 
				setState(94);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__29:
					{
					setState(88);
					match(T__29);
					 op = "-"; 
					}
					break;
				case T__30:
					{
					setState(90);
					match(T__30);
					 op = "+"; 
					}
					break;
				case T__5:
					{
					setState(92);
					match(T__5);
					 op = "!"; 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(96);
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
		enterRule(_localctx, 16, RULE_arithmetic_expression2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			((Arithmetic_expression2Context)_localctx).f1 = arithmetic_expression3();
			 ((Arithmetic_expression2Context)_localctx).f =  ((Arithmetic_expression2Context)_localctx).f1.f; String op; 
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__33))) != 0)) {
				{
				{
				setState(109);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__31:
					{
					setState(103);
					match(T__31);
					 op = "*"; 
					}
					break;
				case T__32:
					{
					setState(105);
					match(T__32);
					 op = "/"; 
					}
					break;
				case T__33:
					{
					setState(107);
					match(T__33);
					 op = "mod"; 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(111);
				((Arithmetic_expression2Context)_localctx).f2 = arithmetic_expression3();
				 ((Arithmetic_expression2Context)_localctx).f =  new BinaryArithmeticOperator(op, _localctx.f, ((Arithmetic_expression2Context)_localctx).f2.f); 
				}
				}
				setState(118);
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
		enterRule(_localctx, 18, RULE_arithmetic_expression1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			((Arithmetic_expression1Context)_localctx).f1 = arithmetic_expression2();
			 ((Arithmetic_expression1Context)_localctx).f =  ((Arithmetic_expression1Context)_localctx).f1.f; String op; 
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__29 || _la==T__30) {
				{
				{
				setState(125);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__30:
					{
					setState(121);
					match(T__30);
					 op = "+"; 
					}
					break;
				case T__29:
					{
					setState(123);
					match(T__29);
					 op = "-"; 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(127);
				((Arithmetic_expression1Context)_localctx).f2 = arithmetic_expression2();
				 ((Arithmetic_expression1Context)_localctx).f =  new BinaryArithmeticOperator(op, _localctx.f, ((Arithmetic_expression1Context)_localctx).f2.f); 
				}
				}
				setState(134);
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
		enterRule(_localctx, 20, RULE_comparison_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			((Comparison_expressionContext)_localctx).f1 = arithmetic_expression1();
			 ((Comparison_expressionContext)_localctx).f =  ((Comparison_expressionContext)_localctx).f1.f; 
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26))) != 0)) {
				{
				setState(137);
				((Comparison_expressionContext)_localctx).comparison_operator_sign = comparison_operator_sign();
				setState(138);
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
		enterRule(_localctx, 22, RULE_and_arithmetic_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			((And_arithmetic_expressionContext)_localctx).f1 = comparison_expression();
			 ((And_arithmetic_expressionContext)_localctx).f =  ((And_arithmetic_expressionContext)_localctx).f1.f; 
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(145);
				match(T__13);
				setState(146);
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
		enterRule(_localctx, 24, RULE_or_arithmetic_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			((Or_arithmetic_expressionContext)_localctx).f1 = and_arithmetic_expression();
			 ((Or_arithmetic_expressionContext)_localctx).f =  ((Or_arithmetic_expressionContext)_localctx).f1.f; String op; 
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(159);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__14:
					{
					setState(153);
					match(T__14);
					 op = "|"; 
					}
					break;
				case T__18:
					{
					setState(155);
					match(T__18);
					 op = "xor"; 
					}
					break;
				case T__17:
					{
					setState(157);
					match(T__17);
					 op = "xnor"; 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(161);
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
		enterRule(_localctx, 26, RULE_ternary_arithmetic_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			((Ternary_arithmetic_expressionContext)_localctx).f1 = or_arithmetic_expression();
			 ((Ternary_arithmetic_expressionContext)_localctx).f =  ((Ternary_arithmetic_expressionContext)_localctx).f1.f; 
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__34) {
				{
				setState(168);
				match(T__34);
				setState(169);
				((Ternary_arithmetic_expressionContext)_localctx).f2 = or_arithmetic_expression();
				setState(170);
				match(T__35);
				setState(171);
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
		enterRule(_localctx, 28, RULE_eq_arithmetic_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			((Eq_arithmetic_expressionContext)_localctx).f1 = ternary_arithmetic_expression();
			 ((Eq_arithmetic_expressionContext)_localctx).f =  ((Eq_arithmetic_expressionContext)_localctx).f1.f; 
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(178);
				match(T__16);
				setState(179);
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
		enterRule(_localctx, 30, RULE_implies_arithmetic_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			((Implies_arithmetic_expressionContext)_localctx).f1 = eq_arithmetic_expression();
			 ((Implies_arithmetic_expressionContext)_localctx).f =  ((Implies_arithmetic_expressionContext)_localctx).f1.f; 
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(186);
				match(T__15);
				setState(187);
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
		enterRule(_localctx, 32, RULE_proposition);
		try {
			setState(207);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				((PropositionContext)_localctx).f1 = arithmetic_expression1();
				setState(193);
				((PropositionContext)_localctx).comparison_operator_sign = comparison_operator_sign();
				setState(194);
				((PropositionContext)_localctx).f2 = arithmetic_expression1();
				 ((PropositionContext)_localctx).f =  new ComparisonOperator((((PropositionContext)_localctx).comparison_operator_sign!=null?_input.getText(((PropositionContext)_localctx).comparison_operator_sign.start,((PropositionContext)_localctx).comparison_operator_sign.stop):null), ((PropositionContext)_localctx).f1.f, ((PropositionContext)_localctx).f2.f); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				((PropositionContext)_localctx).o1 = or_arithmetic_expression();
				setState(198);
				match(T__34);
				setState(199);
				((PropositionContext)_localctx).o2 = or_arithmetic_expression();
				setState(200);
				match(T__35);
				setState(201);
				((PropositionContext)_localctx).o3 = or_arithmetic_expression();
				 ((PropositionContext)_localctx).f =  new TernaryArithmeticOperator(((PropositionContext)_localctx).o1.f, ((PropositionContext)_localctx).o2.f, ((PropositionContext)_localctx).o3.f); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(204);
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
		enterRule(_localctx, 34, RULE_atom);
		try {
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				match(T__27);
				setState(210);
				((AtomContext)_localctx).formula = formula();
				setState(211);
				match(T__28);
				 ((AtomContext)_localctx).f =  ((AtomContext)_localctx).formula.f; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
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
		enterRule(_localctx, 36, RULE_unary_operator);
		try {
			setState(226);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				((Unary_operatorContext)_localctx).atom = atom();
				 ((Unary_operatorContext)_localctx).f =  ((Unary_operatorContext)_localctx).atom.f; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				((Unary_operatorContext)_localctx).unary_operator_sign = unary_operator_sign();
				setState(223);
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
		enterRule(_localctx, 38, RULE_binary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			((Binary_operatorContext)_localctx).f1 = unary_operator();
			 ((Binary_operatorContext)_localctx).f =  ((Binary_operatorContext)_localctx).f1.f; 
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20))) != 0)) {
				{
				setState(230);
				((Binary_operatorContext)_localctx).binary_operator_sign = binary_operator_sign();
				setState(231);
				((Binary_operatorContext)_localctx).f2 = unary_operator();
				 ((Binary_operatorContext)_localctx).f =  new BinaryOperator((((Binary_operatorContext)_localctx).binary_operator_sign!=null?_input.getText(((Binary_operatorContext)_localctx).binary_operator_sign.start,((Binary_operatorContext)_localctx).binary_operator_sign.stop):null), _localctx.f, ((Binary_operatorContext)_localctx).f2.f); 
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
		enterRule(_localctx, 40, RULE_formula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3)\u00f2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\3\3\3\3\3\7\3\62\n"+
		"\3\f\3\16\3\65\13\3\3\3\3\3\3\3\7\3:\n\3\f\3\16\3=\13\3\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7K\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\5\bU\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\ta\n\t\3\t\3"+
		"\t\3\t\5\tf\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\np\n\n\3\n\3\n\3\n\7"+
		"\nu\n\n\f\n\16\nx\13\n\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0080\n\13\3"+
		"\13\3\13\3\13\7\13\u0085\n\13\f\13\16\13\u0088\13\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\5\f\u0090\n\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0098\n\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\5\16\u00a2\n\16\3\16\3\16\3\16\5\16\u00a7"+
		"\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00b1\n\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\5\20\u00b9\n\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u00c1\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\5\22\u00d2\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\5\23\u00dc\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00e5\n\24\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\5\25\u00ed\n\25\3\26\3\26\3\26\3\26\2\2\27"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\6\4\2\3\4((\3\2\b\17"+
		"\3\2\20\27\3\2\30\35\u00f5\2,\3\2\2\2\4.\3\2\2\2\6>\3\2\2\2\b@\3\2\2\2"+
		"\nB\3\2\2\2\fJ\3\2\2\2\16T\3\2\2\2\20e\3\2\2\2\22g\3\2\2\2\24y\3\2\2\2"+
		"\26\u0089\3\2\2\2\30\u0091\3\2\2\2\32\u0099\3\2\2\2\34\u00a8\3\2\2\2\36"+
		"\u00b2\3\2\2\2 \u00ba\3\2\2\2\"\u00d1\3\2\2\2$\u00db\3\2\2\2&\u00e4\3"+
		"\2\2\2(\u00e6\3\2\2\2*\u00ee\3\2\2\2,-\t\2\2\2-\3\3\2\2\2.\63\7)\2\2/"+
		"\60\7\5\2\2\60\62\7)\2\2\61/\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64"+
		"\3\2\2\2\64;\3\2\2\2\65\63\3\2\2\2\66\67\7\6\2\2\678\7(\2\28:\7\7\2\2"+
		"9\66\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<\5\3\2\2\2=;\3\2\2\2>?\t\3"+
		"\2\2?\7\3\2\2\2@A\t\4\2\2A\t\3\2\2\2BC\t\5\2\2C\13\3\2\2\2DE\5\2\2\2E"+
		"F\b\7\1\2FK\3\2\2\2GH\5\4\3\2HI\b\7\1\2IK\3\2\2\2JD\3\2\2\2JG\3\2\2\2"+
		"K\r\3\2\2\2LM\5\f\7\2MN\b\b\1\2NU\3\2\2\2OP\7\36\2\2PQ\5 \21\2QR\7\37"+
		"\2\2RS\b\b\1\2SU\3\2\2\2TL\3\2\2\2TO\3\2\2\2U\17\3\2\2\2VW\5\16\b\2WX"+
		"\b\t\1\2Xf\3\2\2\2Y`\b\t\1\2Z[\7 \2\2[a\b\t\1\2\\]\7!\2\2]a\b\t\1\2^_"+
		"\7\b\2\2_a\b\t\1\2`Z\3\2\2\2`\\\3\2\2\2`^\3\2\2\2ab\3\2\2\2bc\5\20\t\2"+
		"cd\b\t\1\2df\3\2\2\2eV\3\2\2\2eY\3\2\2\2f\21\3\2\2\2gh\5\20\t\2hv\b\n"+
		"\1\2ij\7\"\2\2jp\b\n\1\2kl\7#\2\2lp\b\n\1\2mn\7$\2\2np\b\n\1\2oi\3\2\2"+
		"\2ok\3\2\2\2om\3\2\2\2pq\3\2\2\2qr\5\20\t\2rs\b\n\1\2su\3\2\2\2to\3\2"+
		"\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\23\3\2\2\2xv\3\2\2\2yz\5\22\n\2z\u0086"+
		"\b\13\1\2{|\7!\2\2|\u0080\b\13\1\2}~\7 \2\2~\u0080\b\13\1\2\177{\3\2\2"+
		"\2\177}\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\5\22\n\2\u0082\u0083\b"+
		"\13\1\2\u0083\u0085\3\2\2\2\u0084\177\3\2\2\2\u0085\u0088\3\2\2\2\u0086"+
		"\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\25\3\2\2\2\u0088\u0086\3\2\2"+
		"\2\u0089\u008a\5\24\13\2\u008a\u008f\b\f\1\2\u008b\u008c\5\n\6\2\u008c"+
		"\u008d\5\24\13\2\u008d\u008e\b\f\1\2\u008e\u0090\3\2\2\2\u008f\u008b\3"+
		"\2\2\2\u008f\u0090\3\2\2\2\u0090\27\3\2\2\2\u0091\u0092\5\26\f\2\u0092"+
		"\u0097\b\r\1\2\u0093\u0094\7\20\2\2\u0094\u0095\5\26\f\2\u0095\u0096\b"+
		"\r\1\2\u0096\u0098\3\2\2\2\u0097\u0093\3\2\2\2\u0097\u0098\3\2\2\2\u0098"+
		"\31\3\2\2\2\u0099\u009a\5\30\r\2\u009a\u00a6\b\16\1\2\u009b\u009c\7\21"+
		"\2\2\u009c\u00a2\b\16\1\2\u009d\u009e\7\25\2\2\u009e\u00a2\b\16\1\2\u009f"+
		"\u00a0\7\24\2\2\u00a0\u00a2\b\16\1\2\u00a1\u009b\3\2\2\2\u00a1\u009d\3"+
		"\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\5\30\r\2\u00a4"+
		"\u00a5\b\16\1\2\u00a5\u00a7\3\2\2\2\u00a6\u00a1\3\2\2\2\u00a6\u00a7\3"+
		"\2\2\2\u00a7\33\3\2\2\2\u00a8\u00a9\5\32\16\2\u00a9\u00b0\b\17\1\2\u00aa"+
		"\u00ab\7%\2\2\u00ab\u00ac\5\32\16\2\u00ac\u00ad\7&\2\2\u00ad\u00ae\5\32"+
		"\16\2\u00ae\u00af\b\17\1\2\u00af\u00b1\3\2\2\2\u00b0\u00aa\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\35\3\2\2\2\u00b2\u00b3\5\34\17\2\u00b3\u00b8\b\20"+
		"\1\2\u00b4\u00b5\7\23\2\2\u00b5\u00b6\5\34\17\2\u00b6\u00b7\b\20\1\2\u00b7"+
		"\u00b9\3\2\2\2\u00b8\u00b4\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\37\3\2\2"+
		"\2\u00ba\u00bb\5\36\20\2\u00bb\u00c0\b\21\1\2\u00bc\u00bd\7\22\2\2\u00bd"+
		"\u00be\5 \21\2\u00be\u00bf\b\21\1\2\u00bf\u00c1\3\2\2\2\u00c0\u00bc\3"+
		"\2\2\2\u00c0\u00c1\3\2\2\2\u00c1!\3\2\2\2\u00c2\u00c3\5\24\13\2\u00c3"+
		"\u00c4\5\n\6\2\u00c4\u00c5\5\24\13\2\u00c5\u00c6\b\22\1\2\u00c6\u00d2"+
		"\3\2\2\2\u00c7\u00c8\5\32\16\2\u00c8\u00c9\7%\2\2\u00c9\u00ca\5\32\16"+
		"\2\u00ca\u00cb\7&\2\2\u00cb\u00cc\5\32\16\2\u00cc\u00cd\b\22\1\2\u00cd"+
		"\u00d2\3\2\2\2\u00ce\u00cf\5\f\7\2\u00cf\u00d0\b\22\1\2\u00d0\u00d2\3"+
		"\2\2\2\u00d1\u00c2\3\2\2\2\u00d1\u00c7\3\2\2\2\u00d1\u00ce\3\2\2\2\u00d2"+
		"#\3\2\2\2\u00d3\u00d4\7\36\2\2\u00d4\u00d5\5*\26\2\u00d5\u00d6\7\37\2"+
		"\2\u00d6\u00d7\b\23\1\2\u00d7\u00dc\3\2\2\2\u00d8\u00d9\5\"\22\2\u00d9"+
		"\u00da\b\23\1\2\u00da\u00dc\3\2\2\2\u00db\u00d3\3\2\2\2\u00db\u00d8\3"+
		"\2\2\2\u00dc%\3\2\2\2\u00dd\u00de\5$\23\2\u00de\u00df\b\24\1\2\u00df\u00e5"+
		"\3\2\2\2\u00e0\u00e1\5\6\4\2\u00e1\u00e2\5&\24\2\u00e2\u00e3\b\24\1\2"+
		"\u00e3\u00e5\3\2\2\2\u00e4\u00dd\3\2\2\2\u00e4\u00e0\3\2\2\2\u00e5\'\3"+
		"\2\2\2\u00e6\u00e7\5&\24\2\u00e7\u00ec\b\25\1\2\u00e8\u00e9\5\b\5\2\u00e9"+
		"\u00ea\5&\24\2\u00ea\u00eb\b\25\1\2\u00eb\u00ed\3\2\2\2\u00ec\u00e8\3"+
		"\2\2\2\u00ec\u00ed\3\2\2\2\u00ed)\3\2\2\2\u00ee\u00ef\5(\25\2\u00ef\u00f0"+
		"\b\26\1\2\u00f0+\3\2\2\2\27\63;JT`eov\177\u0086\u008f\u0097\u00a1\u00a6"+
		"\u00b0\u00b8\u00c0\u00d1\u00db\u00e4\u00ec";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}