package nusmv_counterexample_visualizer.formula.arithmetic;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by buzhinsky on 11/20/17.
 */
public class Variable extends ArithmeticExpression {
    public Variable(String name) {
        super(name);
    }

    @Override
    public Object calculate(Map<String, List<String>> values, int position) {
        return new Constant(values.get(name).get(position)).calculate(values, position);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Set<String> variableSet() {
        return Collections.singleton(name);
    }
}
