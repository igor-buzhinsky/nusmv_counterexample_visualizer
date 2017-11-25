package nusmv_counterexample_visualizer.formula.ltl;

import nusmv_counterexample_visualizer.Cause;
import nusmv_counterexample_visualizer.Counterexample;
import nusmv_counterexample_visualizer.Util;
import nusmv_counterexample_visualizer.formula.arithmetic.ArithmeticExpression;
import nusmv_counterexample_visualizer.highlighting.HighlightingMode;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by buzhinsky on 4/18/17.
 */
public class Proposition extends LTLFormula {
    private final ArithmeticExpression expression;
    private final Proposition originalVersion;

    private Proposition(ArithmeticExpression expression, Proposition originalVersion) {
        this.expression = expression;
        this.originalVersion = originalVersion;
    }

    public Proposition(ArithmeticExpression expression) {
        this(expression, null);
        registerFormula(this);
    }

    @Override
    public Pair<Integer, Integer> pastTimeLoopUnwindingRequired() {
        return Pair.of(0, 0);
    }

    public Proposition getOriginalVersion() {
        return originalVersion == null ? this : originalVersion;
    }

    Proposition not() {
        return new Proposition(expression, this);
    }

    @Override
    public String toString() {
        return originalVersion == null ? expression.toString() : ("!" + Util.par(expression));
    }

    private String htmlToString() {
        return Util.toHtmlString(toString());
    }

    @Override
    public Set<String> variableSet() {
        return new TreeSet<>(expression.variableSet());
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
    public LTLFormula removeXor() {
        return this;
    }

    @Override
    public void fillCache(Counterexample ce, Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache) {
        baseFillCache(ce, formulaValueCache);
    }

    public boolean calculate(Counterexample ce, int position) {
        final Object v = expression.calculate(ce.values(), position);
        if (v instanceof Boolean) {
            boolean value = (boolean) v;
            if (originalVersion != null) {
                value = !value;
            }
            return value;
        } else {
            throw new RuntimeException("Arithmetic error.");
        }
    }

    @Override
    public boolean compute(Counterexample ce, int position, Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache) {
        Boolean value = formulaValueCache.get(Pair.of(position, this));
        if (value == null) {
            value = calculate(ce, position);
            formulaValueCache.put(Pair.of(position, this), value);
        }
        return value;
    }

    @Override
    public List<String> annotatedToString(int position,
                                          Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache,
                                          Set<Cause> causalSet) {
        return annotateString(toString(), formulaValueCache.get(Pair.of(position, this)),
                causalSet.contains(new Cause(position, this)));
    }

    @Override
    public List<String> longGraphicalAnnotatedToString(int position,
                                                       Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache,
                                                       Set<Cause> causalSet, Set<Pair<LTLFormula, Integer>> highlightSet,
                                                       HighlightingMode hm) {
        return hm.longGraphicalAnnotateString(htmlToString(), formulaValueCache.get(Pair.of(position, this)),
                causalSet.contains(new Cause(position, this)), highlightSet.contains(Pair.of(this, position)));
    }

    @Override
    public List<String> shortGraphicalAnnotatedToString(int position,
                                                        Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache,
                                                        Set<Cause> causalSet,
                                                        Set<Pair<LTLFormula, Integer>> highlightSet,
                                                        HighlightingMode hm) {
        return hm.shortGraphicalAnnotateString(htmlToString(), formulaValueCache.get(Pair.of(position, this)),
                causalSet.contains(new Cause(position, this)), null, highlightSet.contains(Pair.of(this, position)));
    }
}
