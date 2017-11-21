package nusmv_counterexample_visualizer.formula.arithmetic;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by buzhinsky on 11/20/17.
 */
public abstract class ArithmeticExpression {
    final String name;

    ArithmeticExpression(String name) {
        this.name = name;
    }

    public abstract Object calculate(Map<String, List<String>> values, int position);
    public abstract Set<String> variableSet();
}
