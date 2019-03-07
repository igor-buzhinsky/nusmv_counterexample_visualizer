// Generated from /home/buzhinsky/repos/nusmv_counterexample_visualizer/ltl.g4 by ANTLR 4.7.2
package nusmv_counterexample_visualizer.generated;

import nusmv_counterexample_visualizer.formula.ltl.*;
import nusmv_counterexample_visualizer.formula.arithmetic.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ltlParser}.
 */
public interface ltlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ltlParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(ltlParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(ltlParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#composite_id}.
	 * @param ctx the parse tree
	 */
	void enterComposite_id(ltlParser.Composite_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#composite_id}.
	 * @param ctx the parse tree
	 */
	void exitComposite_id(ltlParser.Composite_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#unary_operator_sign}.
	 * @param ctx the parse tree
	 */
	void enterUnary_operator_sign(ltlParser.Unary_operator_signContext ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#unary_operator_sign}.
	 * @param ctx the parse tree
	 */
	void exitUnary_operator_sign(ltlParser.Unary_operator_signContext ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#binary_operator_sign5}.
	 * @param ctx the parse tree
	 */
	void enterBinary_operator_sign5(ltlParser.Binary_operator_sign5Context ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#binary_operator_sign5}.
	 * @param ctx the parse tree
	 */
	void exitBinary_operator_sign5(ltlParser.Binary_operator_sign5Context ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#binary_operator_sign4}.
	 * @param ctx the parse tree
	 */
	void enterBinary_operator_sign4(ltlParser.Binary_operator_sign4Context ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#binary_operator_sign4}.
	 * @param ctx the parse tree
	 */
	void exitBinary_operator_sign4(ltlParser.Binary_operator_sign4Context ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#binary_operator_sign3}.
	 * @param ctx the parse tree
	 */
	void enterBinary_operator_sign3(ltlParser.Binary_operator_sign3Context ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#binary_operator_sign3}.
	 * @param ctx the parse tree
	 */
	void exitBinary_operator_sign3(ltlParser.Binary_operator_sign3Context ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#binary_operator_sign2}.
	 * @param ctx the parse tree
	 */
	void enterBinary_operator_sign2(ltlParser.Binary_operator_sign2Context ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#binary_operator_sign2}.
	 * @param ctx the parse tree
	 */
	void exitBinary_operator_sign2(ltlParser.Binary_operator_sign2Context ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#binary_operator_sign1}.
	 * @param ctx the parse tree
	 */
	void enterBinary_operator_sign1(ltlParser.Binary_operator_sign1Context ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#binary_operator_sign1}.
	 * @param ctx the parse tree
	 */
	void exitBinary_operator_sign1(ltlParser.Binary_operator_sign1Context ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#comparison_operator_sign}.
	 * @param ctx the parse tree
	 */
	void enterComparison_operator_sign(ltlParser.Comparison_operator_signContext ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#comparison_operator_sign}.
	 * @param ctx the parse tree
	 */
	void exitComparison_operator_sign(ltlParser.Comparison_operator_signContext ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#arithmetic_atomic_value}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_atomic_value(ltlParser.Arithmetic_atomic_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#arithmetic_atomic_value}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_atomic_value(ltlParser.Arithmetic_atomic_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#arithmetic_atom}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_atom(ltlParser.Arithmetic_atomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#arithmetic_atom}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_atom(ltlParser.Arithmetic_atomContext ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#arithmetic_expression3}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_expression3(ltlParser.Arithmetic_expression3Context ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#arithmetic_expression3}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_expression3(ltlParser.Arithmetic_expression3Context ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#arithmetic_expression2}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_expression2(ltlParser.Arithmetic_expression2Context ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#arithmetic_expression2}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_expression2(ltlParser.Arithmetic_expression2Context ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#arithmetic_expression1}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_expression1(ltlParser.Arithmetic_expression1Context ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#arithmetic_expression1}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_expression1(ltlParser.Arithmetic_expression1Context ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void enterComparison_expression(ltlParser.Comparison_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void exitComparison_expression(ltlParser.Comparison_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#and_arithmetic_expression}.
	 * @param ctx the parse tree
	 */
	void enterAnd_arithmetic_expression(ltlParser.And_arithmetic_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#and_arithmetic_expression}.
	 * @param ctx the parse tree
	 */
	void exitAnd_arithmetic_expression(ltlParser.And_arithmetic_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#or_arithmetic_expression}.
	 * @param ctx the parse tree
	 */
	void enterOr_arithmetic_expression(ltlParser.Or_arithmetic_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#or_arithmetic_expression}.
	 * @param ctx the parse tree
	 */
	void exitOr_arithmetic_expression(ltlParser.Or_arithmetic_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#ternary_arithmetic_expression}.
	 * @param ctx the parse tree
	 */
	void enterTernary_arithmetic_expression(ltlParser.Ternary_arithmetic_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#ternary_arithmetic_expression}.
	 * @param ctx the parse tree
	 */
	void exitTernary_arithmetic_expression(ltlParser.Ternary_arithmetic_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#eq_arithmetic_expression}.
	 * @param ctx the parse tree
	 */
	void enterEq_arithmetic_expression(ltlParser.Eq_arithmetic_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#eq_arithmetic_expression}.
	 * @param ctx the parse tree
	 */
	void exitEq_arithmetic_expression(ltlParser.Eq_arithmetic_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#implies_arithmetic_expression}.
	 * @param ctx the parse tree
	 */
	void enterImplies_arithmetic_expression(ltlParser.Implies_arithmetic_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#implies_arithmetic_expression}.
	 * @param ctx the parse tree
	 */
	void exitImplies_arithmetic_expression(ltlParser.Implies_arithmetic_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#proposition}.
	 * @param ctx the parse tree
	 */
	void enterProposition(ltlParser.PropositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#proposition}.
	 * @param ctx the parse tree
	 */
	void exitProposition(ltlParser.PropositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(ltlParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(ltlParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void enterUnary_operator(ltlParser.Unary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void exitUnary_operator(ltlParser.Unary_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#binary_operator5}.
	 * @param ctx the parse tree
	 */
	void enterBinary_operator5(ltlParser.Binary_operator5Context ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#binary_operator5}.
	 * @param ctx the parse tree
	 */
	void exitBinary_operator5(ltlParser.Binary_operator5Context ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#binary_operator4}.
	 * @param ctx the parse tree
	 */
	void enterBinary_operator4(ltlParser.Binary_operator4Context ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#binary_operator4}.
	 * @param ctx the parse tree
	 */
	void exitBinary_operator4(ltlParser.Binary_operator4Context ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#binary_operator3}.
	 * @param ctx the parse tree
	 */
	void enterBinary_operator3(ltlParser.Binary_operator3Context ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#binary_operator3}.
	 * @param ctx the parse tree
	 */
	void exitBinary_operator3(ltlParser.Binary_operator3Context ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#binary_operator2}.
	 * @param ctx the parse tree
	 */
	void enterBinary_operator2(ltlParser.Binary_operator2Context ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#binary_operator2}.
	 * @param ctx the parse tree
	 */
	void exitBinary_operator2(ltlParser.Binary_operator2Context ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#binary_operator1}.
	 * @param ctx the parse tree
	 */
	void enterBinary_operator1(ltlParser.Binary_operator1Context ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#binary_operator1}.
	 * @param ctx the parse tree
	 */
	void exitBinary_operator1(ltlParser.Binary_operator1Context ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterFormula(ltlParser.FormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitFormula(ltlParser.FormulaContext ctx);
}