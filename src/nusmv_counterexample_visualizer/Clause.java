package nusmv_counterexample_visualizer;

import nusmv_counterexample_visualizer.formula.Proposition;

/**
 * Created by buzhinsky on 9/3/17.
 */
public class Clause {
    final int position;
    final Proposition p;

    public Clause(int position, Proposition p) {
        this.position = position;
        this.p = p;
    }

    VarNameClause toVarNameClause() {
        return new VarNameClause(position, p.varName);
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
