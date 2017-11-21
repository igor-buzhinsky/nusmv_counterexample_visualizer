package nusmv_counterexample_visualizer.formula.arithmetic;

import nusmv_counterexample_visualizer.Util;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by buzhinsky on 11/20/17.
 */
public class ComparisonOperator extends ArithmeticExpression {
    private final ArithmeticExpression leftArgument;
    private final ArithmeticExpression rightArgument;

    public ComparisonOperator(String name, ArithmeticExpression leftArgument, ArithmeticExpression rightArgument) {
        super(name);
        this.leftArgument = leftArgument;
        this.rightArgument = rightArgument;
    }

    @Override
    public String toString() {
        return Util.par(leftArgument + " " + name + " " + rightArgument);
    }

    @Override
    public Object calculate(Map<String, List<String>> values, int position) {
        final Object leftValue = leftArgument.calculate(values, position);
        final Object rightValue = rightArgument.calculate(values, position);
        switch (name) {
            case "=":
                return leftValue.equals(rightValue);
            case "!=":
                return !leftValue.equals(rightValue);
            default:
                if (leftValue instanceof Integer && rightValue instanceof Integer) {
                    final int l = (int) leftValue;
                    final int r = (int) rightValue;
                    switch (name) {
                        case ">":
                            return l > r;
                        case ">=":
                            return l >= r;
                        case "<":
                            return l < r;
                        case "<=":
                            return l <= r;
                        default:
                            throw new RuntimeException("Unknown comparison operator.");
                    }
                } else {
                    throw new RuntimeException("Arithmetic type error.");
                }
        }
    }

    @Override
    public Set<String> variableSet() {
        final Set<String> vars = new TreeSet<>();
        vars.addAll(leftArgument.variableSet());
        vars.addAll(rightArgument.variableSet());
        return vars;
    }
}
