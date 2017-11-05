package nusmv_counterexample_visualizer.formula;

import nusmv_counterexample_visualizer.Clause;
import nusmv_counterexample_visualizer.Counterexample;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        return name + par(argument.toString());
    }

    @Override
    public Set<String> variableSet() {
        return argument.variableSet();
    }

    private LTLFormula recursion(Function<LTLFormula, LTLFormula> baseFunction, String specialName,
                                 Function<UnaryOperator, LTLFormula> transformation) {
        final LTLFormula processedArgument = baseFunction.apply(argument);
        final UnaryOperator processed = new UnaryOperator(name, processedArgument);
        return name.equals(specialName) ? transformation.apply(processed) : processed;
    }

    @Override
    public LTLFormula removeFuture() {
        return recursion(LTLFormula::removeFuture, "F", f -> until(new TrueFormula(), f.argument));
    }

    @Override
    public LTLFormula removeRelease() {
        return recursion(LTLFormula::removeRelease, null, null);
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
    public LTLFormula toNNF() {
        if (!name.equals("!")) {
            return new UnaryOperator(name, argument.toNNF());
        } else if (argument instanceof FalseFormula) {
            return new TrueFormula();
        } else if (argument instanceof TrueFormula) {
            return new FalseFormula();
        } else if (argument instanceof Proposition) {
            return ((Proposition) argument).not();
        } else if (argument instanceof UnaryOperator) {
            final UnaryOperator o = (UnaryOperator) argument;
            switch (o.name) {
                case "G": return future(not(o.argument).toNNF());
                case "F": return global(not(o.argument).toNNF());
                case "X": return next(not(o.argument).toNNF());
                case "!": return o.argument.toNNF();
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
            switch (name) {
                case "G":
                    value = walk(ce, position, true, p -> !argument.compute(ce, p, formulaValueCache), p -> false);
                    break;
                case "F":
                    value = walk(ce, position, false, p -> false, p -> argument.compute(ce, p, formulaValueCache));
                    break;
                case "X":
                    value = argument.compute(ce, ce.shiftPosition(position + 1), formulaValueCache);
                    break;
                case "!":
                    value = !argument.compute(ce, position, formulaValueCache);
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
                                          Set<Clause> causalSet) {
        final List<String> argumentAnnotation = argument.annotatedToString(position, formulaValueCache,
                causalSet);
        final boolean value = formulaValueCache.get(Pair.of(position, this));
        final List<String> newLines = new ArrayList<>();
        newLines.add(nChars(' ', name.length() + 1) + argumentAnnotation.get(0) + " ");
        newLines.add(name + par(argumentAnnotation.get(1)));
        for (int i = 2; i < argumentAnnotation.size(); i++) {
            newLines.add("║" + nChars(' ', name.length()) + argumentAnnotation.get(i) + "║");
        }
        newLines.add("╚" + nChars(value ? 'T' : 'F', newLines.get(0).length() - 2) + "╝");
        if (newLines.stream().map(String::length).distinct().collect(Collectors.toList()).size() > 1) {
            newLines.forEach(System.err::println);
            throw new RuntimeException();
        }
        return newLines;
    }

    @Override
    public List<String> graphicalAnnotatedToString(int position,
                                          Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache,
                                          Set<Clause> causalSet, Set<Pair<LTLFormula, Integer>> highlightSet) {
        final List<String> argumentAnnotation = argument.graphicalAnnotatedToString(position, formulaValueCache,
                causalSet, highlightSet);
        final boolean value = formulaValueCache.get(Pair.of(position, this));
        final List<String> newLines = new ArrayList<>();
        newLines.add(name + par(argumentAnnotation.get(0)));

        final String url = FORMULA_TO_INT.get(this) + ":" + position;
        final boolean highlight = highlightSet.contains(Pair.of(this, position));

        for (int i = 1; i < argumentAnnotation.size(); i++) {
            newLines.add(visualizeValue("║", value, url, highlight) + nStrings("&nbsp;", name.length())
                    + argumentAnnotation.get(i) + visualizeValue("║", value, url, highlight));
        }

        newLines.add(visualizeValue("╚" + nChars(value ? 'T' : 'F', lengthWithoutTags(newLines.get(0)) - 2) + "╝",
                value, url, highlight));
        if (newLines.stream().map(LTLFormula::lengthWithoutTags).distinct().collect(Collectors.toList()).size() > 1) {
            newLines.forEach(System.err::println);
            throw new RuntimeException();
        }
        return newLines;
    }

    @Override
    public int length() {
        return argument.length() + (name.equals("!") ? 0 : 1);
    }

    @Override
    public void fillCache(Counterexample ce, Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache) {
        baseFillCache(ce, formulaValueCache, argument);
    }
}
