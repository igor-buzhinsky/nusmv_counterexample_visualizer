package nusmv_counterexample_visualizer;

import nusmv_counterexample_visualizer.formula.ltl.*;
import nusmv_counterexample_visualizer.highlighting.HighlightingMode;
import org.apache.commons.lang3.tuple.Pair;

import javax.swing.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by buzhinsky on 6/29/17.
 */
public class Counterexample {
    private final Set<String> vars = new LinkedHashSet<>();
    private final Set<String> importantVars = new LinkedHashSet<>();
    private final Map<String, List<String>> values = new LinkedHashMap<>();
    private int length = 0;
    private Integer loopPosition = null;

    private int loopLen() {
        return length - loopPosition;
    }

    public int length() {
        return length;
    }

    void unwindLoop(int units, int loops) {
        final int unwindTotal = units + loops * loopLen();
        for (int i = 0; i < unwindTotal; i++) {
            unwindUnit();
        }
    }

    private void unwindUnit() {
        for (String var : vars) {
            values.get(var).add(values.get(var).get(loopPosition));
        }
        length++;
        loopPosition++;
    }

    public int shiftPosition(int position) {
        while (position >= length) {
            position -= loopLen();
        }
        return position;
    }

    private void printValues(StringBuilder sb, Set<VarNameCause> causalSet, int position, Collection<String> varNames,
                             Map<String, Integer> maxValueLengths) {
        int j = 0;
        for (String varName : varNames) {
            final String left;
            final String right;
            if (causalSet.contains(new VarNameCause(position, varName))) {
                left = "▐";
                right = "▌";
            } else {
                left = "[";
                right = "]";
            }
            sb.append(left).append(varName).append(" = ").append(String.format("%" + maxValueLengths.get(varName) + "s",
                    values.get(varName).get(position))).append(right);
            if (++j != varNames.size()) {
                sb.append(" ");
            }
        }
        sb.append("\n");
    }

    JTable graphicalValueTable(Set<VarNameCause> causalSet, HighlightingMode hm, int fontSize) {
        final Map<String, Integer> varNameToColumn = new HashMap<>();
        int j = 1;
        for (String varName : importantVars) {
            varNameToColumn.put(varName, j++);
        }
        for (String varName : vars) {
            if (!importantVars.contains(varName)) {
                varNameToColumn.put(varName, j++);
            }
        }

        final String[] columns = new String[vars.size() + 1];
        columns[0] = "Step";
        for (String varName : vars) {
            columns[varNameToColumn.get(varName)] = varName;
        }
        final Object[][] data = new Object[length][vars.size() + 1];
        for (int i = 0; i < length; i++) {
            data[i][0] = "<html>" + i + " " + (i >= loopPosition ? "loop" : "prefix") + "</html>";
            for (String varName : vars) {
                data[i][varNameToColumn.get(varName)] = "<html>" +
                        hm.visualizeImportanceInTable(values.get(varName).get(i),
                                causalSet.contains(new VarNameCause(i, varName))) + "</html>";
            }
        }

        final JTable table = new JTable(data, columns);
        Util.unifyTable(table, fontSize);
        Util.resizeColumnWidth(table);
        return table;
    }

    String annotatedToString(Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache, LTLFormula f,
                             Set<Cause> causalSet, Set<VarNameCause> varNameCausalSet, boolean printOther,
                             boolean annotateFormula) {
        final StringBuilder sb = new StringBuilder();
        final Map<String, Integer> maxValueLengths = new HashMap<>();
        for (String var : vars) {
            maxValueLengths.put(var, values.get(var).stream().mapToInt(String::length).max().orElse(0));
        }
        for (int i = 0; i < length; i++) {
            final String loopIndication = loopPosition == null ? "" : i >= loopPosition ? "[ loop ] " : "[prefix] ";
            final String prefix = loopIndication + String.format("step %" + String.valueOf(length - 1).length()
                    + "d: ", i);
            sb.append(prefix).append("values from the formula ");
            printValues(sb, varNameCausalSet, i, importantVars, maxValueLengths);
            if (printOther) {
                final List<String> otherVars = vars.stream().filter(v -> !importantVars.contains(v))
                        .collect(Collectors.toList());
                if (!otherVars.isEmpty()) {
                    sb.append(prefix).append("           other values ");
                    printValues(sb, varNameCausalSet, i, otherVars, maxValueLengths);
                }
            }

            if (annotateFormula && formulaValueCache != null && f != null) {
                for (String line : f.annotatedToString(i, formulaValueCache, causalSet)) {
                    sb.append(prefix).append(line).append("\n");
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    String graphicalAnnotatedToString(Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache, LTLFormula f,
                                      Set<Cause> causalSet, int step, Set<Pair<LTLFormula, Integer>> highlightSet,
                                      HighlightingMode hm, boolean shortAnnotations) {
        final StringBuilder sb = new StringBuilder();
        if (formulaValueCache != null && f != null) {
            final List<String> lines = shortAnnotations
                    ? f.shortGraphicalAnnotatedToString(step, formulaValueCache, causalSet, highlightSet, hm)
                    : f.longGraphicalAnnotatedToString(step, formulaValueCache, causalSet, highlightSet, hm);
            for (String line : lines) {
                sb.append(line).append("<br>");
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return annotatedToString(null, null, Collections.emptySet(), Collections.emptySet(), true, false);
    }

    void setImportant(Set<String> varNames) {
        importantVars.addAll(varNames);
    }

    public Map<String, List<String>> values() {
        return Collections.unmodifiableMap(values);
    }

    void newElement() {
        length++;
    }

    void setLoopPosition() {
        loopPosition = length;
    }

    void setEmergencyLoopPosition() {
        loopPosition = length - 1;
    }

    Integer loopPosition() {
        return loopPosition;
    }

    void addValue(String varName, String value) {
        vars.add(varName);
        final List<String> varValues = values.computeIfAbsent(varName, k -> new ArrayList<>());
        varValues.add(value);
        length = Math.max(length, varValues.size());
    }

    void padMissing() {
        for (Map.Entry<String, List<String>> entry : values.entrySet()) {
            final List<String> list = entry.getValue();
            while (list.size() < length) {
                final String padValue = list.get(list.size() - 1);
                list.add(padValue);
            }
        }
    }

    private final Map<Pair<Integer, LTLFormula>, Set<Cause>> causalSetCache = new HashMap<>();

    private boolean val(int position, LTLFormula f) {
        return c(position, f).isEmpty();
    }

    private Set<Cause> union(Set<Cause> left, Set<Cause> right) {
        final Set<Cause> result = new LinkedHashSet<>(left);
        result.addAll(right);
        return result;
    }

    /*
     * null clauses indicate false value caused not by clauses
     * thus, val can be defined simpler
     */
    private Set<Cause> c(int i, LTLFormula f) {
        Set<Cause> result = causalSetCache.get(Pair.of(i, f));
        final Set<Cause> res = new HashSet<>();
        if (result == null) {
            if (f instanceof Proposition) {
                final Proposition p = (Proposition) f;
                if (!p.calculate(this, i)) {
                    res.add(p.variableSet().isEmpty() ? null : new Cause(i, p.originalVersion()));
                }
                result = res;
            } else if (f instanceof UnaryOperator) {
                final UnaryOperator o = (UnaryOperator) f;
                final LTLFormula phi = o.argument;
                switch (o.name) {
                    case "X":
                        result = c(shiftPosition(i + 1), phi);
                        break;
                    case "Y":
                        result = i > 0 ? c(i - 1, phi) : Collections.singleton(null);
                        break;
                    case "Z":
                        result = i > 0 ? c(i - 1, phi) : Collections.emptySet();
                        break;
                    case "H":
                        loopBack(i, p -> {}, p -> !val(p, phi), p -> res.addAll(c(p, phi)), p -> {}, res::clear);
                        result = res;
                        break;
                    case "O":
                        loopBack(i, p -> {}, p -> val(p, phi), p -> res.clear(), p -> res.addAll(c(p, phi)), () -> {});
                        result = res;
                        break;
                    default:
                        throw new RuntimeException("Unexpected unary operator " + o.name);
                }
            } else if (f instanceof BinaryOperator) {
                final BinaryOperator o = (BinaryOperator) f;
                final LTLFormula phi = o.leftArgument;
                final LTLFormula psi = o.rightArgument;
                switch (o.name) {
                    case "&":
                        result = union(c(i, phi), c(i, psi));
                        break;
                    case "|":
                        result = !val(i, phi) && !val(i, psi) ? union(c(i, phi), c(i, psi)) : Collections.emptySet();
                        break;
                    case "U":
                        loop(i, p -> res.addAll(c(p, psi)), p -> !val(p, phi) || val(p, psi), p -> {
                            if (val(p, psi)) { // reached psi with phi previously true, hence U is true
                                res.clear();
                            } else { // both are false, hence U is false
                                res.addAll(c(p, phi));
                            }
                        }, p -> {}, () -> {});
                        result = res;
                        break;
                    case "V":
                        loop(i, p -> {}, p -> !val(p, psi) || val(p, phi), p -> {
                            if (val(p, phi) && val(p, psi)) { // reached phi & psi with psi previously true, hence V is true
                                res.clear();
                            } else { // psi is false and the situation above has not occurred, hence V is false
                                res.addAll(c(p, psi));
                            }
                        }, p -> res.addAll(c(p, phi)), res::clear);
                        result = res;
                        break;
                    default:
                        throw new RuntimeException("Unexpected binary operator " + o.name);
                }
            } else {
                throw new RuntimeException("Unexpected formula class!");
            }

            causalSetCache.put(Pair.of(i, f), result);
            //System.out.println("c(" + i + ", " + f + ") = " + result);
        }
        return result;
    }

    Set<Cause> causalSet(LTLFormula f) {
        final Set<Cause> set = new LinkedHashSet<>(c(0, f));
        set.remove(null);
        //System.out.println(f);
        //System.out.println(set.stream().map(Object::toString).sorted().collect(Collectors.toList()));
        //System.exit(0);
        return set;
    }

    void loop(int initialPosition, Consumer<Integer> unconditionalAction, Predicate<Integer> terminationCondition,
              Consumer<Integer> terminationAction, Consumer<Integer> otherAction, Runnable actionIfNotTerminated) {
        final Set<Integer> processedPositions = new HashSet<>();
        int i = initialPosition;
        while (processedPositions.add(i)) {
            unconditionalAction.accept(i);
            if (terminationCondition.test(i)) {
                terminationAction.accept(i);
                return;
            } else {
                otherAction.accept(i);
            }
            i = shiftPosition(i + 1);
        }
        actionIfNotTerminated.run();
    }

    void loopBack(int initialPosition, Consumer<Integer> unconditionalAction, Predicate<Integer> terminationCondition,
              Consumer<Integer> terminationAction, Consumer<Integer> otherAction, Runnable actionIfNotTerminated) {
        for (int i = 0; i <= initialPosition; i++) {
            unconditionalAction.accept(i);
            if (terminationCondition.test(i)) {
                terminationAction.accept(i);
                return;
            } else {
                otherAction.accept(i);
            }
        }
        actionIfNotTerminated.run();
    }
}
