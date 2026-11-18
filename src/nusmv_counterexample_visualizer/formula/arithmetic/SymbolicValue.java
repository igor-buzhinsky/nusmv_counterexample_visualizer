package nusmv_counterexample_visualizer.formula.arithmetic;

/**
 * A value of a NuSMV enumeration type given by a symbolic constant, e.g. "idle" for a variable of type
 * {idle, busy}. Symbolic values can only be compared for equality.
 */
public final class SymbolicValue {
    private final String name;

    SymbolicValue(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || (o instanceof SymbolicValue && name.equals(((SymbolicValue) o).name));
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}
