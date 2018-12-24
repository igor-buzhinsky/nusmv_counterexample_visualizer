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
        if (!values.containsKey(name)) {
            throw new RuntimeException("Missing variable name: " + name
                    + ". One possible cause may be that this variable is present in an LTL formula"
                    + " but not in the corresponding counterexample. The list of all variables is: "
                    + values.keySet());
        }
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
