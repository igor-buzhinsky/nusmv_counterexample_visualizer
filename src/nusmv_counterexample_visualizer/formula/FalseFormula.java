package nusmv_counterexample_visualizer.formula;

import nusmv_counterexample_visualizer.Clause;
import nusmv_counterexample_visualizer.Counterexample;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by buzhinsky on 10/20/17.
 */
public class FalseFormula extends LTLFormula {
    public FalseFormula() {
        registerFormula(this);
    }

    @Override
    public Set<String> variableSet() {
        return new TreeSet<>();
    }

    @Override
    public LTLFormula removeFuture() {
        return this;
    }

    @Override
    public LTLFormula removeRelease() {
        return this;
    }

    @Override
    public LTLFormula removeImplication() {
        return this;
    }

    @Override
    public LTLFormula removeEquivalence() {
        return this;
    }

    @Override
    public LTLFormula toNNF() {
        return this;
    }

    @Override
    public void fillCache(Counterexample ce, Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache) {
        baseFillCache(ce, formulaValueCache);
    }

    @Override
    public boolean compute(Counterexample ce, int position,
                           Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache) {
        formulaValueCache.put(Pair.of(position, this), false);
        return false;
    }

    @Override
    public List<String> annotatedToString(int position,
                                          Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache,
                                          Set<Clause> causalSet) {
        return annotateString(toString(), false, false);
    }

    @Override
    public List<String> graphicalAnnotatedToString(int position,
                                                   Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache,
                                                   Set<Clause> causalSet, Set<Pair<LTLFormula, Integer>> highlightSet) {
        return graphicalAnnotateString(toString(), false, false, highlightSet.contains(Pair.of(this, position)));
    }

    @Override
    public String toString() {
        return "FALSE";
    }
}
