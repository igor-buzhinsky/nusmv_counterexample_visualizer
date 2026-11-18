package nusmv_counterexample_visualizer.formula.arithmetic;

import nusmv_counterexample_visualizer.Util;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by buzhinsky on 11/20/17.
 */
public class CountArithmeticOperator extends ArithmeticExpression {
    private final List<ArithmeticExpression> arguments;

    public CountArithmeticOperator(List<ArithmeticExpression> arguments) {
        super("count");
        this.arguments = arguments;
    }

    @Override
    public String toString() {
        return name + Util.par(arguments.toString()
                .replace("[", "")
                .replace("]", ""));
    }

    @Override
    public Object calculate(Map<String, List<String>> values, int position) {
        int count = 0;
        for (ArithmeticExpression arg : arguments) {
            final Object argValue = arg.calculate(values, position);
            if (argValue instanceof Boolean) {
                count += ((Boolean) argValue) ? 1 : 0;
            } else {
                throw new RuntimeException("Arithmetic type error: count accepts only Booleans.");
            }
        }
        return count;
    }

    @Override
    public Set<String> variableSet() {
        final Set<String> vars = new TreeSet<>();
        arguments.forEach(arg -> vars.addAll(arg.variableSet()));
        return vars;
    }
}
