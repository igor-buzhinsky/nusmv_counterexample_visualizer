package nusmv_counterexample_visualizer.formula;

import nusmv_counterexample_visualizer.Clause;
import nusmv_counterexample_visualizer.Counterexample;
import nusmv_counterexample_visualizer.highlighting.HighlightingMode;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

/**
 * Created by buzhinsky on 4/18/17.
 */
public class Proposition extends LTLFormula {
    public final String varName;
    private final String operator;
    private final String constant;
    private final Proposition originalVersion;

    private Proposition(String varName, String operator, String constant, Proposition originalVersion) {
        this.varName = varName;
        this.operator = operator;
        this.constant = constant;
        this.originalVersion = originalVersion;
        registerFormula(this);
    }

    @Override
    public Pair<Integer, Integer> pastTimeLoopUnwindingRequired() {
        return Pair.of(0, 0);
    }

    public Proposition getOriginalVersion() {
        return originalVersion == null ? this : originalVersion;
    }

    public Proposition(String varName, String operator, String constant) {
        this(varName, operator, constant, null);
    }

    Proposition not() {
        final Proposition newOriginalVersion = originalVersion == null ? this : originalVersion;
        if (operator.equals("=") && constant.equals("TRUE")) {
            return new Proposition(varName, "=", "FALSE", newOriginalVersion);
        }
        if (operator.equals("=") && constant.equals("FALSE")) {
            return new Proposition(varName, "=", "TRUE", newOriginalVersion);
        }
        if (operator.equals("!=") && constant.equals("TRUE")) {
            return new Proposition(varName, "=", "TRUE", newOriginalVersion);
        }
        if (operator.equals("!=") && constant.equals("FALSE")) {
            return new Proposition(varName, "=", "FALSE", newOriginalVersion);
        }
        final String newOperator;
        switch (operator) {
            case "=": newOperator = "!="; break;
            case "!=": newOperator = "="; break;
            case "<": newOperator = ">="; break;
            case "<=": newOperator = ">"; break;
            case ">": newOperator = "<="; break;
            case ">=": newOperator = "<"; break;
            default: throw new RuntimeException("Unknown comparison operator " + operator + "!");
        }
        return new Proposition(varName, newOperator, constant, newOriginalVersion);
    }

    public boolean calculate(String value) {
        switch (operator) {
            case "=": return constant.equals(value);
            case "!=": return !constant.equals(value);
            default:
                final int intValue = Integer.parseInt(value);
                final int intConstant = Integer.parseInt(constant);
                switch (operator) {
                    case "<": return intValue < intConstant;
                    case "<=": return intValue <= intConstant;
                    case ">": return intValue > intConstant;
                    case ">=": return intValue >= intConstant;
                    default: throw new RuntimeException("Unknown comparison operator " + operator + "!");
                }
        }
    }

    @Override
    public String toString() {
        return varName + " " + operator + " " + constant;
    }

    private String prettyToString() {
        if (constant.equals("TRUE") && operator.equals("=") || constant.equals("FALSE") && operator.equals("!=") ) {
            return varName;
        }
        if (constant.equals("TRUE") && operator.equals("!=") || constant.equals("FALSE") && operator.equals("=") ) {
            return "!" + varName;
        }
        return toString();
    }

    private String htmlToString() {
        return prettyToString().replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }

    @Override
    public Set<String> variableSet() {
        return new TreeSet<>(Collections.singletonList(varName));
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
    public boolean compute(Counterexample ce, int position, Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache) {
        Boolean value = formulaValueCache.get(Pair.of(position, this));
        if (value == null) {
            value = calculate(ce.values().get(varName).get(position));
            formulaValueCache.put(Pair.of(position, this), value);
        }
        return value;
    }

    @Override
    public List<String> annotatedToString(int position,
                                          Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache,
                                          Set<Clause> causalSet) {
        return annotateString(prettyToString(), formulaValueCache.get(Pair.of(position, this)),
                causalSet.contains(new Clause(position, this)));
    }

    @Override
    public List<String> longGraphicalAnnotatedToString(int position,
                                                       Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache,
                                                       Set<Clause> causalSet, Set<Pair<LTLFormula, Integer>> highlightSet,
                                                       HighlightingMode hm) {
        return hm.longGraphicalAnnotateString(htmlToString(), formulaValueCache.get(Pair.of(position, this)),
                causalSet.contains(new Clause(position, this)), highlightSet.contains(Pair.of(this, position)));
    }

    @Override
    public List<String> shortGraphicalAnnotatedToString(int position,
                                                        Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache,
                                                        Set<Clause> causalSet,
                                                        Set<Pair<LTLFormula, Integer>> highlightSet, HighlightingMode hm) {
        return hm.shortGraphicalAnnotateString(htmlToString(), formulaValueCache.get(Pair.of(position, this)),
                causalSet.contains(new Clause(position, this)));
    }
}
