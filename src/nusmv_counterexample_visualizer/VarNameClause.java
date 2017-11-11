package nusmv_counterexample_visualizer;

/**
 * Created by buzhinsky on 9/3/17.
 */
class VarNameClause {
    private final int position;
    private final String varName;

    VarNameClause(int position, String varName) {
        this.position = position;
        this.varName = varName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VarNameClause clause = (VarNameClause) o;
        return position == clause.position && varName.equals(clause.varName);
    }

    @Override
    public int hashCode() {
        int result = position;
        result = 31 * result + varName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return varName + "@" + position;
    }
}
