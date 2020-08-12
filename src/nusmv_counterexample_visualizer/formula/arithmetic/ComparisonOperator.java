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
        // to simplify processing, let's cast integers to rationals
        // (boolean are kept unchanged)
        final Object leftValue = intToRational(leftArgument.calculate(values, position));
        final Object rightValue = intToRational(rightArgument.calculate(values, position));

        switch (name) {
            case "=":
                return leftValue.equals(rightValue);
            case "!=":
                return !leftValue.equals(rightValue);
            default:
                if (leftValue instanceof BigRational && rightValue instanceof BigRational) {
                    final int cmp = ((BigRational) leftValue).compareTo((BigRational) rightValue);
                    switch (name) {
                        case ">": return cmp > 0;
                        case ">=": return cmp >= 0;
                        case "<": return cmp < 0;
                        case "<=": return cmp <= 0;
                        default: throw unexpectedOperatorException("comparison");
                    }
                } else {
                    throw arithmeticException();
                }
        }
    }

    @Override
    public Set<String> variableSet() {
        return new TreeSet<String>() {{
            addAll(leftArgument.variableSet());
            addAll(rightArgument.variableSet());
        }};
    }
}
