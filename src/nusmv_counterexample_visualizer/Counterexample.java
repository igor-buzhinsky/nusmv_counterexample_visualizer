package nusmv_counterexample_visualizer;

import nusmv_counterexample_visualizer.formula.*;
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

    public int length() {
        return length;
    }

    public int shiftPosition(int position) {
        final int loopLen = length - loopPosition;
        while (position >= length) {
            position -= loopLen;
        }
        return position;
    }

    private void printValues(StringBuilder sb, Set<VarNameClause> causalSet, int position, Collection<String> varNames,
                             Map<String, Integer> maxValueLengths) {
        int j = 0;
        for (String varName : varNames) {
            final String left;
            final String right;
            if (causalSet.contains(new VarNameClause(position, varName))) {
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

    JTable graphicalValueTable(Set<VarNameClause> causalSet) {
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
        columns[0] = "#";
        for (String varName : vars) {
            columns[varNameToColumn.get(varName)] = varName;
        }
        final Object[][] data = new Object[length][vars.size() + 1];
        for (int i = 0; i < length; i++) {
            data[i][0] = i + " " + (i >= loopPosition ? "loop" : "prefix");
            for (String varName : vars) {
                data[i][varNameToColumn.get(varName)] = "<html>" +
                        LTLFormula.visualizeImportanceInTable(values.get(varName).get(i),
                                causalSet.contains(new VarNameClause(i, varName))) + "</html>";
            }
        }
        final JTable table = new JTable(data, columns);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        return table;
    }

    String annotatedToString(Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache, LTLFormula f,
                             Set<Clause> causalSet, Set<VarNameClause> varNameCausalSet, boolean printOther,
                             boolean annotateFormula) {
        final StringBuilder sb = new StringBuilder();
        final Map<String, Integer> maxValueLengths = new HashMap<>();
        for (String var : vars) {
            maxValueLengths.put(var, values.get(var).stream().mapToInt(String::length).max().orElse(0));
        }
        for (int i = 0; i < length; i++) {
            final String loopIndication = loopPosition == null ? "" : i >= loopPosition ? "[ loop ] " : "[prefix] ";
            final String prefix = loopIndication + String.format("pos = %" + String.valueOf(length - 1).length()
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
                             Set<Clause> causalSet, int step, Set<Pair<LTLFormula, Integer>> highlightSet) {
        final StringBuilder sb = new StringBuilder();
        if (formulaValueCache != null && f != null) {
            for (String line : f.graphicalAnnotatedToString(step, formulaValueCache, causalSet, highlightSet)) {
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
        List<String> varValues = values.get(varName);
        if (varValues == null) {
            varValues = new ArrayList<>();
            values.put(varName, varValues);
        }
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

    private final Map<Pair<Integer, LTLFormula>, Set<Clause>> causalSetCache = new HashMap<>();

    private boolean val(int position, LTLFormula f) {
        return (f instanceof TrueFormula) || !(f instanceof FalseFormula) && c(position, f).isEmpty();
    }

    private boolean label(int position, Proposition p) {
        return p.calculate(values.get(p.varName).get(position));
    }

    private Set<Clause> union(Set<Clause> left, Set<Clause> right) {
        final Set<Clause> result = new LinkedHashSet<>(left);
        result.addAll(right);
        return result;
    }

    private Set<Clause> c(int i, LTLFormula f) {
        Set<Clause> result = causalSetCache.get(Pair.of(i, f));
        final Set<Clause> res = new HashSet<>();
        if (result == null) {
            if (f instanceof TrueFormula || f instanceof FalseFormula) {
                result = Collections.emptySet();
            } else if (f instanceof Proposition) {
                final Proposition p = (Proposition) f;
                result = label(i, p)
                        ? Collections.emptySet()
                        : Collections.singleton(new Clause(i, p.getOriginalVersion()));
            } else if (f instanceof UnaryOperator) {
                final UnaryOperator o = (UnaryOperator) f;
                final LTLFormula phi = o.argument;
                switch (o.name) {
                    case "X":
                        result = c(shiftPosition(i + 1), phi);
                        break;
                    case "G":
                        loop(i, p -> {}, p -> !val(p, phi), p -> res.addAll(c(p, phi)), p -> {});
                        result = res;
                        break;
                    default:
                        throw new RuntimeException("Unexpected operator " + o.name);
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
                        loop(i, p -> res.addAll(c(p, psi)), p -> !val(p, phi) && !val(p, psi),
                                p -> res.addAll(c(p, phi)), p -> {});
                        result = res;
                        break;
                    default:
                        throw new RuntimeException("Unexpected operator " + o.name);
                }
            } else {
                throw new RuntimeException("Unexpected formula class!");
            }
            causalSetCache.put(Pair.of(i, f), result);
        }
        return result;
    }

    Set<Clause> causalSet(LTLFormula f) {
        return c(0, f).stream().map(c -> new Clause(shiftPosition(c.position), c.p)).collect(Collectors.toSet());
    }

    void loop(int initialPosition, Consumer<Integer> unconditionalAction, Predicate<Integer> terminationCondition,
              Consumer<Integer> terminationAction, Consumer<Integer> otherAction) {
        final Set<Integer> processedPositions = new HashSet<>();
        int i = initialPosition;
        while (processedPositions.add(i)) {
            unconditionalAction.accept(i);
            if (terminationCondition.test(i)) {
                terminationAction.accept(i);
                break;
            } else {
                otherAction.accept(i);
            }
            i = shiftPosition(i + 1);
        }
    }
}
