package nusmv_counterexample_visualizer.formula.arithmetic;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by buzhinsky on 11/20/17.
 */
public class Constant extends ArithmeticExpression {
    public Constant(String name) {
        super(name);
    }

    @Override
    public Object calculate(Map<String, List<String>> values, int position) {
        return name.equals("TRUE") ? true : name.equals("FALSE") ? false : Integer.parseInt(name);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Set<String> variableSet() {
        return Collections.emptySet();
    }
}
