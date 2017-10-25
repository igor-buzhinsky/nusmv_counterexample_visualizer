package nusmv_counterexample_visualizer;

import nusmv_counterexample_visualizer.formula.LTLFormula;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by buzhinsky on 9/3/17.
 */
class VerificationResult {
    final String strOriginalF;
    final LTLFormula originalF;
    final LTLFormula f;
    final Counterexample ce;
    final Set<Clause> causalSet;
    final Set<VarNameClause> varNameCausalSet;
    final Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache = new HashMap<>();

    VerificationResult(String strOriginalF, LTLFormula originalF, LTLFormula f, Counterexample ce,
                       boolean fillValueCache) {
        this.strOriginalF = strOriginalF;
        this.originalF = originalF;
        this.f = f;
        this.ce = ce;
        causalSet = ce != null ? ce.causalSet(f) : new HashSet<>();
        varNameCausalSet = new HashSet<>();
        varNameCausalSet.addAll(causalSet.stream().map(Clause::toVarNameClause).collect(Collectors.toList()));
        if (ce != null && fillValueCache) {
            originalF.fillCache(ce, formulaValueCache);
        }
    }

    String result(boolean printOther, boolean annotateFormula) {
        final StringBuilder sb = new StringBuilder();
        sb.append(strOriginalF).append("\n");
        if (ce != null) {
            sb.append(ce.annotatedToString(formulaValueCache, originalF, causalSet, varNameCausalSet, printOther,
                    annotateFormula));
        }
        sb.append("\n");
        return sb.toString();
    }

    AnnotationData result(Set<Pair<LTLFormula, Integer>> highlightSet) {
        final List<String> list = new ArrayList<>();
        if (ce != null) {
            for (int i = 0; i < ce.length(); i++) {
                list.add(ce.graphicalAnnotatedToString(formulaValueCache, originalF, causalSet, i, highlightSet));
            }
        }
        return new AnnotationData(strOriginalF, list, ce, causalSet, originalF, formulaValueCache);
    }
}
