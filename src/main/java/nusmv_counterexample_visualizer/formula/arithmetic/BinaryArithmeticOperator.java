package nusmv_counterexample_visualizer.formula.arithmetic;

import nusmv_counterexample_visualizer.Util;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by buzhinsky on 11/20/17.
 */
public class BinaryArithmeticOperator extends ArithmeticExpression {
    private final ArithmeticExpression leftArgument;
    private final ArithmeticExpression rightArgument;

    public BinaryArithmeticOperator(String name, ArithmeticExpression leftArgument, ArithmeticExpression rightArgument) {
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

        if (leftValue instanceof Boolean && rightValue instanceof Boolean) {
            final boolean l = (boolean) leftValue;
            final boolean r = (boolean) rightValue;
            switch (name) {
                case "&": return l & r;
                case "|": return l || r;
                case "->": return !l || r;
                case "xor": return l != r;
                case "<->": case "xnor": return l == r;
                default: throw unexpectedOperatorException("binary arithmetic");
            }
        } else if (leftValue instanceof Integer && rightValue instanceof Integer) {
            final int l = (int) leftValue;
            final int r = (int) rightValue;
            switch (name) {
                case "+": return l + r;
                case "-": return l - r;
                case "*": return l * r;
                case "/": return l / r;
                case "mod": return l % r;
                default: throw unexpectedOperatorException("binary arithmetic");
            }
        } else if (leftValue instanceof BigRational || rightValue instanceof BigRational) {
            if (leftValue instanceof Boolean || rightValue instanceof Boolean) {
                throw arithmeticException();
            }
            // ensure that both are rationals
            final BigRational l = (BigRational) intToRational(leftValue);
            final BigRational r = (BigRational) intToRational(rightValue);
            switch (name) {
                case "+": return l.plus(r);
                case "-": return l.minus(r);
                case "*": return l.times(r);
                case "/": return l.divides(r);
                case "mod": throw new RuntimeException("nuXmv does not support mod with reals.");
                default: throw unexpectedOperatorException("binary arithmetic");
            }
        } else {
            throw arithmeticException();
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
