package nusmv_counterexample_visualizer.formula;

import nusmv_counterexample_visualizer.Clause;
import nusmv_counterexample_visualizer.Counterexample;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.function.Function;

/**
 * Created by buzhinsky on 4/18/17.
 */
public abstract class LTLFormula {
    private static final List<LTLFormula> INT_TO_FORMULA = new ArrayList<>();
    static final Map<LTLFormula, Integer> FORMULA_TO_INT = new HashMap<>();

    static void registerFormula(LTLFormula f) {
        FORMULA_TO_INT.put(f, INT_TO_FORMULA.size());
        INT_TO_FORMULA.add(f);
    }

    public static LTLFormula intToFormula(int index) {
        return INT_TO_FORMULA.get(index);
    }

    static String par(String text) {
        return "(" + text + ")";
    }

    public abstract Set<String> variableSet();

    public abstract int length();

    public abstract LTLFormula removeFuture();

    public abstract LTLFormula removeRelease();

    public abstract LTLFormula removeImplication();

    public abstract LTLFormula removeEquivalence();

    public abstract LTLFormula toNNF();

    public abstract void fillCache(Counterexample ce, Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache);

    void baseFillCache(Counterexample ce, Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache,
                       LTLFormula... children) {
        Arrays.stream(children).forEach(c -> c.fillCache(ce ,formulaValueCache));
        for (int i = 0; i < ce.length(); i++) {
            formulaValueCache.put(Pair.of(i, this), compute(ce, i, formulaValueCache));
        }
    }

    static String nChars(char c, int n) {
        final char[] arr = new char[n];
        Arrays.fill(arr, c);
        return new String(arr);
    }

    static String nStrings(String s, int n) {
        return String.join("", Collections.nCopies(n, s));
    }

    public abstract boolean compute(Counterexample ce, int position,
                                    Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache);

    public abstract List<String> annotatedToString(int position,
                                                   Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache,
                                                   Set<Clause> causalSet);

    public abstract List<String> graphicalAnnotatedToString(int position,
                                                   Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache,
                                                   Set<Clause> causalSet, Set<Pair<LTLFormula, Integer>> highlightSet);

    List<String> annotateString(String str, boolean value, boolean important) {
        final String firstLine = nChars(important ? '▅' : ' ', str.length());
        final String thirdLine = nChars(value ? 'T' : 'F', str.length());
        return new ArrayList<>(Arrays.asList(firstLine, str, thirdLine));
    }

    List<String> graphicalAnnotateString(String str, boolean value, boolean important, boolean highlight) {
        final String firstLine = visualizeImportance(str, important);
        final String secondLine = visualizeValue(nChars(value ? 'T' : 'F', lengthWithoutTags(str)), value, null,
                highlight);
        return new ArrayList<>(Arrays.asList(firstLine, secondLine));
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

    boolean walk(Counterexample ce, int position, boolean defaultValue,
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

    static int lengthWithoutTags(String s) {
        return s.replaceAll("</?(font|a)[^>]*>","").replaceAll("&(nbsp|lt|gt);", " ").length();
    }

    static String visualizeValue(String s, boolean value, String url, boolean highlight) {
        final String color = value && highlight ? "color=green bgcolor=yellow"
                : value ? "color=green bgcolor=#eeffee"
                : highlight ? "color=red bgcolor=yellow" : "color=red bgcolor=#ffeeee";
        if (url != null) {
            s = "<a href=" + url + " style='text-decoration:none'>" + s + "</a>";
        }
        return "<font " + color + ">" + s + "</font>";
    }

    private static String visualizeImportance(String s, boolean important) {
        return important ? ("<font bgcolor=yellow>" + s + "</font>") : s;
    }

}
