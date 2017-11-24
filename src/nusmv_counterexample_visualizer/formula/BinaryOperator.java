package nusmv_counterexample_visualizer.formula;

import nusmv_counterexample_visualizer.Cause;
import nusmv_counterexample_visualizer.Counterexample;
import nusmv_counterexample_visualizer.Util;
import nusmv_counterexample_visualizer.highlighting.HighlightingMode;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by buzhinsky on 4/18/17.
 */
public class BinaryOperator extends LTLFormula {
    public final String name;
    public final LTLFormula leftArgument;
    public final LTLFormula rightArgument;

    public BinaryOperator(String name, LTLFormula leftArgument, LTLFormula rightArgument) {
        this.name = name;
        this.leftArgument = leftArgument;
        this.rightArgument = rightArgument;
        registerFormula(this);
    }

    @Override
    public String toString() {
        return Util.par(leftArgument + " " + name + " " + rightArgument);
    }

    @Override
    public Pair<Integer, Integer> pastTimeLoopUnwindingRequired() {
        final Pair<Integer, Integer> leftValues = leftArgument.pastTimeLoopUnwindingRequired();
        final Pair<Integer, Integer> rightValues = rightArgument.pastTimeLoopUnwindingRequired();
        return Pair.of(Math.max(leftValues.getLeft(), rightValues.getLeft()),
                Math.max(leftValues.getRight(), rightValues.getRight()));
    }

    @Override
    public Set<String> variableSet() {
        final Set<String> result = leftArgument.variableSet();
        result.addAll(rightArgument.variableSet());
        return result;
    }

    private LTLFormula recursion(Function<LTLFormula, LTLFormula> baseFunction, String specialName,
                                 Function<BinaryOperator, LTLFormula> transformation) {
        final LTLFormula processedLeft = baseFunction.apply(leftArgument);
        final LTLFormula processedRight = baseFunction.apply(rightArgument);
        final BinaryOperator processed = new BinaryOperator(name, processedLeft, processedRight);
        return name.equals(specialName) ? transformation.apply(processed) : processed;
    }

    @Override
    public LTLFormula removeFuture() {
        return recursion(LTLFormula::removeFuture, null, null);
    }

    @Override
    public LTLFormula removeImplication() {
        return recursion(LTLFormula::removeImplication, "->", f -> or(not(f.leftArgument), f.rightArgument));
    }

    @Override
    public LTLFormula removeEquivalence() {
        return recursion(LTLFormula::removeEquivalence, "<->", f -> or(and(f.leftArgument, f.rightArgument),
                and(not(f.leftArgument), not(f.rightArgument))));
    }

    @Override
    public LTLFormula removeXor() {
        return recursion(LTLFormula::removeXor, "xor", f -> not(or(and(f.leftArgument, f.rightArgument),
                and(not(f.leftArgument), not(f.rightArgument)))));
    }

    @Override
    public LTLFormula removeRelease() {
        return recursion(LTLFormula::removeRelease, "V", f -> or(until(f.rightArgument,
                and(f.rightArgument, f.leftArgument)), global(f.rightArgument)));
    }

    @Override
    public LTLFormula toNNF() {
        return recursion(LTLFormula::toNNF, null, null);
    }

    @Override
    public boolean compute(Counterexample ce, int position, Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache) {
        Boolean value = formulaValueCache.get(Pair.of(position, this));
        if (value == null) {
            switch (name) {
                case "U":
                    value = walk(ce, position, false,
                        p -> !leftArgument.compute(ce, p, formulaValueCache)
                                && !rightArgument.compute(ce, p, formulaValueCache),
                        p -> rightArgument.compute(ce, p, formulaValueCache));
                    break;
                case "V":
                    // ϕ has to be true until and including the point where ψ first becomes true;
                    // if ψ never becomes true, ϕ must remain true forever.
                    value = walk(ce, position, true,
                        p -> !leftArgument.compute(ce, p, formulaValueCache),
                        p -> leftArgument.compute(ce, p, formulaValueCache)
                                && rightArgument.compute(ce, p, formulaValueCache));
                    break;
                case "|":
                    value = leftArgument.compute(ce, position, formulaValueCache)
                            || rightArgument.compute(ce, position, formulaValueCache);
                    break;
                case "&":
                    value = leftArgument.compute(ce, position, formulaValueCache)
                            && rightArgument.compute(ce, position, formulaValueCache);
                    break;
                case "->":
                    value = !leftArgument.compute(ce, position, formulaValueCache)
                            || rightArgument.compute(ce, position, formulaValueCache);
                    break;
                case "<->":
                    value = leftArgument.compute(ce, position, formulaValueCache)
                            == rightArgument.compute(ce, position, formulaValueCache);
                    break;
                case "xor":
                    value = leftArgument.compute(ce, position, formulaValueCache)
                            != rightArgument.compute(ce, position, formulaValueCache);
                    break;
                default: throw new RuntimeException("Unknown binary operator " + name);
            }
            formulaValueCache.put(Pair.of(position, this), value);
        }
        return value;
    }

    @Override
    public List<String> annotatedToString(int position,
                                          Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache,
                                          Set<Cause> causalSet) {
        final List<String> leftAnnotation = leftArgument.annotatedToString(position, formulaValueCache, causalSet);
        final List<String> rightAnnotation = rightArgument.annotatedToString(position, formulaValueCache, causalSet);
        while (leftAnnotation.size() > rightAnnotation.size()) {
            rightAnnotation.add(Util.nChars(' ', rightAnnotation.get(0).length()));
        }
        while (rightAnnotation.size() > leftAnnotation.size()) {
            leftAnnotation.add(Util.nChars(' ', leftAnnotation.get(0).length()));
        }
        final boolean value = formulaValueCache.get(Pair.of(position, this));
        final List<String> newLines = new ArrayList<>();
        newLines.add(" " + leftAnnotation.get(0) + Util.nChars(' ', name.length() + 2) + rightAnnotation.get(0) + " ");
        newLines.add(Util.par(leftAnnotation.get(1) + " " + name + " " + rightAnnotation.get(1)));
        for (int i = 2; i < leftAnnotation.size(); i++) {
            newLines.add("║" + leftAnnotation.get(i) + Util.nChars(' ', name.length() + 2) + rightAnnotation.get(i) + "║");
        }
        newLines.add("╚" + Util.nChars(value ? 'T' : 'F', newLines.get(0).length() - 2) + "╝");
        if (newLines.stream().map(String::length).distinct().collect(Collectors.toList()).size() > 1) {
            newLines.forEach(System.err::println);
            throw new RuntimeException();
        }
        return newLines;
    }

    @Override
    public List<String> longGraphicalAnnotatedToString(int position,
                                                       Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache,
                                                       Set<Cause> causalSet, Set<Pair<LTLFormula, Integer>> highlightSet,
                                                       HighlightingMode hm) {
        final List<String> leftAnnotation = leftArgument.longGraphicalAnnotatedToString(position, formulaValueCache,
                causalSet, highlightSet, hm);
        final List<String> rightAnnotation = rightArgument.longGraphicalAnnotatedToString(position, formulaValueCache,
                causalSet, highlightSet, hm);
        while (leftAnnotation.size() > rightAnnotation.size()) {
            rightAnnotation.add(Util.nStrings("&nbsp;", Util.lengthWithoutTags(rightAnnotation.get(0))));
        }
        while (rightAnnotation.size() > leftAnnotation.size()) {
            leftAnnotation.add(Util.nStrings("&nbsp;", Util.lengthWithoutTags(leftAnnotation.get(0))));
        }
        final boolean value = formulaValueCache.get(Pair.of(position, this));
        final List<String> newLines = new ArrayList<>();
        final String htmlName = Util.toHtmlString(name);
        newLines.add(Util.par(leftAnnotation.get(0) + "&nbsp;" + htmlName + "&nbsp;" + rightAnnotation.get(0)));

        final String url = url(position);
        final boolean highlight = highlightSet.contains(Pair.of(this, position));

        for (int i = 1; i < leftAnnotation.size(); i++) {
            newLines.add(hm.visualizeValue("║", value, url, highlight) + leftAnnotation.get(i)
                    + Util.nStrings("&nbsp;", name.length() + 2) + rightAnnotation.get(i)
                    + hm.visualizeValue("║", value, url, highlight));
        }

        newLines.add(hm.visualizeValue("╚" + Util.nChars(value ? 'T' : 'F', Util.lengthWithoutTags(newLines.get(0)) - 2) + "╝",
                value, url, highlight));

        if (newLines.stream().map(Util::lengthWithoutTags).distinct().collect(Collectors.toList()).size() > 1) {
            newLines.forEach(System.err::println);
            throw new RuntimeException();
        }
        return newLines;
    }

    @Override
    public List<String> shortGraphicalAnnotatedToString(int position,
                                                        Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache,
                                                        Set<Cause> causalSet,
                                                        Set<Pair<LTLFormula, Integer>> highlightSet,
                                                        HighlightingMode hm) {
        final List<String> leftAnnotation = leftArgument.shortGraphicalAnnotatedToString(position, formulaValueCache,
                causalSet, highlightSet, hm);
        final List<String> rightAnnotation = rightArgument.shortGraphicalAnnotatedToString(position, formulaValueCache,
                causalSet, highlightSet, hm);
        final boolean value = formulaValueCache.get(Pair.of(position, this));
        final String url = url(position);
        final boolean highlight = highlightSet.contains(Pair.of(this, position));
        return Util.bind(hm.shortGraphicalAnnotateString("(", value, false, url, highlight), leftAnnotation,
                hm.shortGraphicalAnnotateString("&nbsp;" + Util.toHtmlString(name) + "&nbsp;", value, false, url,
                        highlight), rightAnnotation, hm.shortGraphicalAnnotateString(")", value, false, url, highlight));
    }

    @Override
    public void fillCache(Counterexample ce, Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache) {
        baseFillCache(ce, formulaValueCache, leftArgument, rightArgument);
    }
}
