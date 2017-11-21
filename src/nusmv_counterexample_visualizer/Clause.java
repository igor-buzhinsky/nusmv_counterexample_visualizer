package nusmv_counterexample_visualizer;

import nusmv_counterexample_visualizer.formula.Proposition;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by buzhinsky on 9/3/17.
 */
public class Clause {
    private final int position;
    private final Proposition p;

    public Clause(int position, Proposition p) {
        this.position = position;
        this.p = p;
    }

    List<VarNameClause> toVarNameClauses() {
        return p.variableSet().stream().map(name -> new VarNameClause(position, name)).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clause clause = (Clause) o;
        return position == clause.position && p.equals(clause.p);
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
