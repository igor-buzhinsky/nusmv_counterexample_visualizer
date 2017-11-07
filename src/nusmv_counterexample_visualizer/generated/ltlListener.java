// Generated from /home/buzhinsky/repos/nusmv_counterexample_visualizer/ltl.g4 by ANTLR 4.6
package nusmv_counterexample_visualizer.generated;

import nusmv_counterexample_visualizer.formula.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ltlParser}.
 */
public interface ltlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ltlParser#equivalent}.
	 * @param ctx the parse tree
	 */
	void enterEquivalent(ltlParser.EquivalentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#equivalent}.
	 * @param ctx the parse tree
	 */
	void exitEquivalent(ltlParser.EquivalentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#xor}.
	 * @param ctx the parse tree
	 */
	void enterXor(ltlParser.XorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#xor}.
	 * @param ctx the parse tree
	 */
	void exitXor(ltlParser.XorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#eq}.
	 * @param ctx the parse tree
	 */
	void enterEq(ltlParser.EqContext ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#eq}.
	 * @param ctx the parse tree
	 */
	void exitEq(ltlParser.EqContext ctx);
	/**
	 * Enter a parse tree produced by {@link ltlParser#ne}.
	 * @param ctx the parse tree
	 */
	void enterNe(ltlParser.NeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#ne}.
	 * @param ctx the parse tree
	 */
	void exitNe(ltlParser.NeContext ctx);
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
	 * Enter a parse tree produced by {@link ltlParser#binary_operator_sign}.
	 * @param ctx the parse tree
	 */
	void enterBinary_operator_sign(ltlParser.Binary_operator_signContext ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#binary_operator_sign}.
	 * @param ctx the parse tree
	 */
	void exitBinary_operator_sign(ltlParser.Binary_operator_signContext ctx);
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
	 * Enter a parse tree produced by {@link ltlParser#binary_operator}.
	 * @param ctx the parse tree
	 */
	void enterBinary_operator(ltlParser.Binary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ltlParser#binary_operator}.
	 * @param ctx the parse tree
	 */
	void exitBinary_operator(ltlParser.Binary_operatorContext ctx);
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