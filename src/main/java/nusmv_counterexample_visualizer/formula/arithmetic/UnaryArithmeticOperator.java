package nusmv_counterexample_visualizer.formula.arithmetic;

import nusmv_counterexample_visualizer.Util;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by buzhinsky on 11/20/17.
 */
public class UnaryArithmeticOperator extends ArithmeticExpression {
    private final ArithmeticExpression argument;

    public UnaryArithmeticOperator(String name, ArithmeticExpression argument) {
        super(name);
        this.argument = argument;
    }

    @Override
    public String toString() {
        return name + Util.par(argument.toString());
    }

    @Override
    public Object calculate(Map<String, List<String>> values, int position) {
        final Object argValue = argument.calculate(values, position);
        if ("+".equals(name) && (argValue instanceof Integer || argValue instanceof BigRational)) {
            return argValue;
        }
        if (argValue instanceof Integer) {
            if ("-".equals(name)) {
                return -((int) argValue);
            }
            throw unexpectedOperatorException("unary arithmetic (argument type: integer)");
        } else if (argValue instanceof Boolean) {
            if ("!".equals(name)) {
                return !((boolean) argValue);
            }
            throw unexpectedOperatorException("unary arithmetic (argument type: boolean)");
        } else if (argValue instanceof BigRational) {
            if ("-".equals(name)) {
                return ((BigRational) argValue).negate();
            }
            throw unexpectedOperatorException("unary arithmetic (argument type: real)");
        } else {
            throw arithmeticException();
        }
    }

    @Override
    public Set<String> variableSet() {
        return argument.variableSet();
    }
}
