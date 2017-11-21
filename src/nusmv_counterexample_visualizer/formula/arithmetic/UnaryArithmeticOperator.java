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
        if (argValue instanceof Integer) {
            switch (name) {
                case "-":
                    return -((Integer) argValue);
                case "+":
                    return argValue;
                default:
                    throw new RuntimeException("Unknown unary arithmetic operator.");
            }
        } else {
            throw new RuntimeException("Arithmetic type error.");
        }
    }

    @Override
    public Set<String> variableSet() {
        return argument.variableSet();
    }
}
