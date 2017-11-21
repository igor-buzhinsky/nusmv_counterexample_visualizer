package nusmv_counterexample_visualizer;

import nusmv_counterexample_visualizer.formula.Proposition;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by buzhinsky on 9/3/17.
 */
public class Cause {
    private final int position;
    private final Proposition p;

    public Cause(int position, Proposition p) {
        this.position = position;
        this.p = p;
    }

    List<VarNameCause> toVarNameClauses() {
        return p.variableSet().stream().map(name -> new VarNameCause(position, name)).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cause cause = (Cause) o;
        return position == cause.position && p.equals(cause.p);
    }

    @Override
    public int hashCode() {
        int result = position;
        result = 31 * result + p.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return p + "@" + position;
    }
}
