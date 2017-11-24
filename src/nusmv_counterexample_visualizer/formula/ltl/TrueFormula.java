package nusmv_counterexample_visualizer.formula.ltl;

import nusmv_counterexample_visualizer.Cause;
import nusmv_counterexample_visualizer.Counterexample;
import nusmv_counterexample_visualizer.highlighting.HighlightingMode;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

/**
 * Created by buzhinsky on 10/20/17.
 */
public class TrueFormula extends LTLFormula {
    public TrueFormula() {
        registerFormula(this);
    }

    @Override
    public Pair<Integer, Integer> pastTimeLoopUnwindingRequired() {
        return Pair.of(0, 0);
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
    public LTLFormula removeXor() {
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
        formulaValueCache.put(Pair.of(position, this), true);
        return true;
    }

    @Override
    public List<String> annotatedToString(int position,
                                          Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache,
                                          Set<Cause> causalSet) {
        return annotateString(toString(), true, false);
    }

    @Override
    public List<String> longGraphicalAnnotatedToString(int position,
                                                       Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache,
                                                       Set<Cause> causalSet, Set<Pair<LTLFormula, Integer>> highlightSet,
                                                       HighlightingMode hm) {
        return hm.longGraphicalAnnotateString(toString(), true, false, highlightSet.contains(Pair.of(this, position)));
    }

    @Override
    public List<String> shortGraphicalAnnotatedToString(int position,
                                                        Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache,
                                                        Set<Cause> causalSet,
                                                        Set<Pair<LTLFormula, Integer>> highlightSet,
                                                        HighlightingMode hm) {
        return hm.shortGraphicalAnnotateString(toString(), true, false, null,
                highlightSet.contains(Pair.of(this, position)));
    }

    @Override
    public String toString() {
        return "TRUE";
    }
}
