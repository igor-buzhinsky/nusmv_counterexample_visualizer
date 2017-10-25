package nusmv_counterexample_visualizer.variable;

/**
 * Created by buzhinsky on 4/13/17.
 */
public class BooleanVariable extends Variable {
    public BooleanVariable(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return name + ": boolean";
    }
}
