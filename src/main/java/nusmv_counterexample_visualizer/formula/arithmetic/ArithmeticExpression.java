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

    Object intToRational(Object x) {
        if (x instanceof Integer) {
            return new BigRational((int) x, 1);
        }
        return x;
    }

    RuntimeException arithmeticException() {
        return new RuntimeException("Arithmetic type error in " + toString() + ".");
    }

    RuntimeException unexpectedOperatorException(String description) {
        return new RuntimeException("In expression " + toString() + ", unknown or unexpected "
                + description + " operator " + name + ".");
    }
}
