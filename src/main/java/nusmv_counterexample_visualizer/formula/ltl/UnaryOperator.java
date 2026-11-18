package nusmv_counterexample_visualizer.formula.ltl;

import nusmv_counterexample_visualizer.Cause;
import nusmv_counterexample_visualizer.Counterexample;
import nusmv_counterexample_visualizer.Util;
import nusmv_counterexample_visualizer.highlighting.HighlightingMode;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/**
 * Created by buzhinsky on 4/18/17.
 */
public class UnaryOperator extends LTLFormula {
    public final String name;
    public final LTLFormula argument;

    public UnaryOperator(String name, LTLFormula argument) {
        this.name = name;
        this.argument = argument;
        registerFormula(this);
    }

    @Override
    public String toString() {
        return name + Util.par(argument.toString());
    }

    @Override
    public Pair<Integer, Integer> pastTimeLoopUnwindingRequired() {
        final Pair<Integer, Integer> argValues = argument.pastTimeLoopUnwindingRequired();
        return Pair.of(argValues.getLeft() + (name.equals("Y") || name.equals("Z") ? 1 : 0),
                argValues.getRight() + (name.equals("O") || name.equals("H") ? 1 : 0));
    }

    @Override
    public Set<String> variableSet() {
        return argument.variableSet();
    }

    private LTLFormula recursion(Function<LTLFormula, LTLFormula> baseFunction,
                                 Function<UnaryOperator, LTLFormula> transformation, String specialName) {
        final LTLFormula processedArgument = baseFunction.apply(argument);
        final UnaryOperator processed = new UnaryOperator(name, processedArgument);
        return name.equals(specialName) ? transformation.apply(processed) : processed;
    }

    @Override
    public LTLFormula removeF() {
        return recursion(LTLFormula::removeF, f -> until(Proposition.trueFormula(), f.argument), "F");
    }

    @Override
    public LTLFormula removeG() {
        return recursion(LTLFormula::removeG, f -> release(Proposition.falseFormula(), f.argument), "G");
    }

    @Override
    public LTLFormula removeImplication() {
        return recursion(LTLFormula::removeImplication, null, null);
    }

    @Override
    public LTLFormula removeEquivalence() {
        return recursion(LTLFormula::removeEquivalence, null, null);
    }

    @Override
    public LTLFormula removeXor() {
        return recursion(LTLFormula::removeXor, null, null);
    }

    @Override
    public LTLFormula toNNF() {
        if (!name.equals("!")) {
            return new UnaryOperator(name, argument.toNNF());
        } if (argument instanceof Proposition) {
            return ((Proposition) argument).not();
        } else if (argument instanceof UnaryOperator) {
            final UnaryOperator o = (UnaryOperator) argument;
            switch (o.name) {
                case "G": return future(not(o.argument).toNNF());
                case "F": return global(not(o.argument).toNNF());
                case "X": return next(not(o.argument).toNNF());
                case "!": return o.argument.toNNF();
                case "H": return once(not(o.argument).toNNF());
                case "O": return historically(not(o.argument).toNNF());
                case "Y": return prevZ(not(o.argument).toNNF());
                case "Z": return prevY(not(o.argument).toNNF());
                default: throw new RuntimeException("Unknown unary operator " + o.name);
            }
        } else if (argument instanceof BinaryOperator) {
            final BinaryOperator o = (BinaryOperator) argument;
            switch (o.name) {
                case "|": return and(not(o.leftArgument).toNNF(), not(o.rightArgument).toNNF());
                case "&": return or(not(o.leftArgument).toNNF(), not(o.rightArgument).toNNF());
                case "U": return release(not(o.leftArgument).toNNF(), not(o.rightArgument).toNNF());
                case "V": return until(not(o.leftArgument).toNNF(), not(o.rightArgument).toNNF());
                default: throw new RuntimeException("Unknown binary operator " + o.name);
            }
        } else {
            throw new AssertionError();
        }
    }

    @Override
    public boolean compute(Counterexample ce, int position, Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache) {
        Boolean value = formulaValueCache.get(Pair.of(position, this));
        if (value == null) {
            final Function<Integer, Boolean> f = p -> argument.compute(ce, p, formulaValueCache);
            switch (name) {
                case "G": value = walk(ce, position, true, p -> !f.apply(p), p -> false);
                    break;
                case "F": value = walk(ce, position, false, p -> false, f);
                    break;
                case "X": value = f.apply(ce.shiftPosition(position + 1));
                    break;
                case "!": value = !f.apply(position);
                    break;
                case "Y": value = position != 0 && f.apply(position - 1);
                    break;
                case "Z": value = position == 0 || f.apply(position - 1);
                    break;
                case "O": value = walkBack(position, false, p -> false, f);
                    break;
                case "H": value = walkBack(position, true, p -> !f.apply(p), p -> false);
                    break;
                default:
                    throw new RuntimeException("Unknown unary operator " + name);
            }
            formulaValueCache.put(Pair.of(position, this), value);
        }
        return value;
    }

    @Override
    public List<String> annotatedToString(int position,
                                          Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache,
                                          Set<Cause> causalSet) {
        final List<String> argumentAnnotation = argument.annotatedToString(position, formulaValueCache,
                causalSet);
        final boolean value = formulaValueCache.get(Pair.of(position, this));
        final List<String> newLines = new ArrayList<>();
        newLines.add(Util.nChars(' ', name.length() + 1) + argumentAnnotation.get(0) + " ");
        newLines.add(name + Util.par(argumentAnnotation.get(1)));
        for (int i = 2; i < argumentAnnotation.size(); i++) {
            newLines.add("║" + Util.nChars(' ', name.length()) + argumentAnnotation.get(i) + "║");
        }
        newLines.add("╚" + Util.nChars(value ? 'T' : 'F', newLines.get(0).length() - 2) + "╝");
        if (newLines.stream().map(String::length).distinct().count() > 1) {
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
        final List<String> argumentAnnotation = argument.longGraphicalAnnotatedToString(position, formulaValueCache,
                causalSet, highlightSet, hm);
        final boolean value = formulaValueCache.get(Pair.of(position, this));
        final List<String> newLines = new ArrayList<>();
        newLines.add(name + Util.par(argumentAnnotation.get(0)));

        final String url = url(position);
        final boolean highlight = highlightSet.contains(Pair.of(this, position));

        for (int i = 1; i < argumentAnnotation.size(); i++) {
            newLines.add(hm.visualizeValue("║", value, url, highlight) + Util.nStrings("&nbsp;", name.length())
                    + argumentAnnotation.get(i) + hm.visualizeValue("║", value, url, highlight));
        }

        newLines.add(hm.visualizeValue("╚" + Util.nChars(value ? 'T' : 'F', Util.lengthWithoutTags(newLines.get(0)) - 2) + "╝",
                value, url, highlight));
        if (newLines.stream().map(Util::lengthWithoutTags).distinct().count() > 1) {
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
        final List<String> argumentAnnotation = argument.shortGraphicalAnnotatedToString(position, formulaValueCache,
                causalSet, highlightSet, hm);
        final boolean value = formulaValueCache.get(Pair.of(position, this));
        final String url = url(position);
        final boolean highlight = highlightSet.contains(Pair.of(this, position));
        return Util.bind(hm.shortGraphicalAnnotateString(name + "(", value, false, url, highlight), argumentAnnotation,
                hm.shortGraphicalAnnotateString(")", value, false, url, highlight));
    }

    @Override
    public void fillCache(Counterexample ce, Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache) {
        baseFillCache(ce, formulaValueCache, argument);
    }
}
