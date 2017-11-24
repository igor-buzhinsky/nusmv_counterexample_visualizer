package nusmv_counterexample_visualizer.formula.arithmetic;

import nusmv_counterexample_visualizer.Util;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by buzhinsky on 11/20/17.
 */
public class TernaryArithmeticOperator extends ArithmeticExpression {
    private final ArithmeticExpression condition;
    private final ArithmeticExpression leftOption;
    private final ArithmeticExpression rightOption;

    public TernaryArithmeticOperator(ArithmeticExpression condition, ArithmeticExpression leftOption,
                                     ArithmeticExpression rightOption) {
        super("?:");
        this.condition = condition;
        this.leftOption = leftOption;
        this.rightOption = rightOption;
    }

    @Override
    public String toString() {
        return Util.par(condition + " ? " + leftOption + " : " + rightOption);
    }

    @Override
    public Object calculate(Map<String, List<String>> values, int position) {
        final Object conditionValue = condition.calculate(values, position);
        if (conditionValue instanceof Boolean) {
            return ((boolean) conditionValue ? leftOption : rightOption).calculate(values, position);
        } else {
            throw new RuntimeException("Arithmetic type error.");
        }
    }

    @Override
    public Set<String> variableSet() {
        final Set<String> vars = new TreeSet<>();
        vars.addAll(condition.variableSet());
        vars.addAll(leftOption.variableSet());
        vars.addAll(rightOption.variableSet());
        return vars;
    }
}
