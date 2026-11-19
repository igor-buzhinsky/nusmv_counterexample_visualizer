package nusmv_counterexample_visualizer.formula.arithmetic;

import nusmv_counterexample_visualizer.Util;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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
        final Object leftValue = intToRational(operandValue(leftArgument, rightArgument, values, position));
        final Object rightValue = intToRational(operandValue(rightArgument, leftArgument, values, position));

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

    /*
     * In a formula, a symbolic constant (e.g. "idle" in "state = idle") is syntactically indistinguishable from a
     * variable name. An identifier that is not a variable of the trace is therefore treated as a symbolic constant
     * if it is a direct operand of = or != and the other operand is of an enumeration type, i.e. it is either
     * a trace variable that takes a symbolic value somewhere in the trace (the type may mix integers and symbols)
     * or an expression whose current value is symbolic. Otherwise, it is evaluated as a variable, which reports
     * the missing variable (e.g., a misspelled one in "stat = 1" or "x = y_typo" for an integer x).
     */
    private Object operandValue(ArithmeticExpression operand, ArithmeticExpression other,
                                Map<String, List<String>> values, int position) {
        if ((name.equals("=") || name.equals("!=")) && isUndefinedVariable(operand, values)
                && hasEnumerationType(other, values, position)) {
            return new SymbolicValue(operand.name);
        }
        return operand.calculate(values, position);
    }

    private static boolean hasEnumerationType(ArithmeticExpression e, Map<String, List<String>> values,
                                              int position) {
        if (e instanceof Variable) {
            final List<String> trace = values.get(e.name);
            return trace != null && trace.stream().anyMatch(Constant::isSymbolic);
        }
        return e.calculate(values, position) instanceof SymbolicValue;
    }

    private static boolean isUndefinedVariable(ArithmeticExpression e, Map<String, List<String>> values) {
        return e instanceof Variable && !values.containsKey(e.name);
    }

    @Override
    public Set<String> variableSet() {
        return new TreeSet<String>() {{
            addAll(leftArgument.variableSet());
            addAll(rightArgument.variableSet());
        }};
    }
}
