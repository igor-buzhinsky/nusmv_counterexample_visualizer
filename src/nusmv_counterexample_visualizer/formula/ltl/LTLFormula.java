package nusmv_counterexample_visualizer.formula.ltl;

import nusmv_counterexample_visualizer.Cause;
import nusmv_counterexample_visualizer.Counterexample;
import nusmv_counterexample_visualizer.Util;
import nusmv_counterexample_visualizer.highlighting.HighlightingMode;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.function.Function;

/**
 * Created by buzhinsky on 4/18/17.
 */
public abstract class LTLFormula {
    private static final List<LTLFormula> INT_TO_FORMULA = new ArrayList<>();
    private static final Map<LTLFormula, Integer> FORMULA_TO_INT = new HashMap<>();

    static void registerFormula(LTLFormula f) {
        FORMULA_TO_INT.put(f, INT_TO_FORMULA.size());
        INT_TO_FORMULA.add(f);
    }

    public static LTLFormula intToFormula(int index) {
        return INT_TO_FORMULA.get(index);
    }

    /*
     * For past-time LTL formulas, unwinding the loop to some extent may be required for subformula values to
     * be fixed for each element of the loop (e.g. what is the predecessor of the first loop element?)
     * Attempt of a solution:
     * - presence of O or H requires the loop to be repeated once
     * - multiple occurrence of O and H seem not to require more unwinding
     * - each Y and Z require an additional element to be unwound.
     */
    public abstract Pair<Integer, Integer> pastTimeLoopUnwindingRequired();

    public abstract Set<String> variableSet();

    public abstract LTLFormula removeF();

    public abstract LTLFormula removeG();

    public abstract LTLFormula removeImplication();

    public abstract LTLFormula removeEquivalence();

    public abstract LTLFormula removeXor();

    public abstract LTLFormula toNNF();

    public abstract void fillCache(Counterexample ce, Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache);

    void baseFillCache(Counterexample ce, Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache,
                       LTLFormula... children) {
        Arrays.stream(children).forEach(c -> c.fillCache(ce ,formulaValueCache));
        for (int i = 0; i < ce.length(); i++) {
            formulaValueCache.put(Pair.of(i, this), compute(ce, i, formulaValueCache));
        }
    }

    public abstract boolean compute(Counterexample ce, int position,
                                    Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache);

    public abstract List<String> annotatedToString(int position,
                                                   Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache,
                                                   Set<Cause> causalSet);

    public abstract List<String> longGraphicalAnnotatedToString(int position,
                                                                Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache,
                                                                Set<Cause> causalSet, Set<Pair<LTLFormula, Integer>> highlightSet,
                                                                HighlightingMode hm);

    public abstract List<String> shortGraphicalAnnotatedToString(int position,
                                                                 Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache,
                                                                 Set<Cause> causalSet, Set<Pair<LTLFormula, Integer>> highlightSet,
                                                                 HighlightingMode hm);

    List<String> annotateString(String str, boolean value, boolean important) {
        final String firstLine = Util.nChars(important ? '▅' : ' ', str.length());
        final String thirdLine = Util.nChars(value ? 'T' : 'F', str.length());
        return new ArrayList<>(Arrays.asList(firstLine, str, thirdLine));
    }

    LTLFormula not(LTLFormula other) {
        return new UnaryOperator("!", other);
    }

    LTLFormula future(LTLFormula other) {
        return new UnaryOperator("F", other);
    }

    LTLFormula global(LTLFormula other) {
        return new UnaryOperator("G", other);
    }

    LTLFormula next(LTLFormula other) {
        return new UnaryOperator("X", other);
    }

    LTLFormula and(LTLFormula left, LTLFormula right) {
        return new BinaryOperator("&", left, right);
    }

    LTLFormula or(LTLFormula left, LTLFormula right) {
        return new BinaryOperator("|", left, right);
    }

    LTLFormula release(LTLFormula left, LTLFormula right) {
        return new BinaryOperator("V", left, right);
    }

    LTLFormula until(LTLFormula left, LTLFormula right) {
        return new BinaryOperator("U", left, right);
    }

    LTLFormula once(LTLFormula other) {
        return new UnaryOperator("O", other);
    }

    LTLFormula historically(LTLFormula other) {
        return new UnaryOperator("H", other);
    }

    LTLFormula prevY(LTLFormula other) {
        return new UnaryOperator("Y", other);
    }

    LTLFormula prevZ(LTLFormula other) {
        return new UnaryOperator("Z", other);
    }

    static boolean walk(Counterexample ce, int position, boolean defaultValue,
                  Function<Integer, Boolean> returnFalsePredicate, Function<Integer, Boolean> returnTruePredicate) {
        final boolean[] checkedPositions = new boolean[ce.length()];
        int curPosition = position;
        while (!checkedPositions[curPosition]) {
            if (returnFalsePredicate.apply(curPosition)) {
                return false;
            }
            if (returnTruePredicate.apply(curPosition)) {
                return true;
            }
            checkedPositions[curPosition] = true;
            curPosition = ce.shiftPosition(curPosition + 1);
        }
        return defaultValue;
    }

    static boolean walkBack(int position, boolean defaultValue, Function<Integer, Boolean> returnFalsePredicate,
                     Function<Integer, Boolean> returnTruePredicate) {
        for (int curPosition = position; curPosition >= 0; curPosition--) {
            if (returnFalsePredicate.apply(curPosition)) {
                return false;
            }
            if (returnTruePredicate.apply(curPosition)) {
                return true;
            }
        }
        return defaultValue;
    }

    String url(int position) {
        return FORMULA_TO_INT.get(this) + ":" + position;
    }
}
