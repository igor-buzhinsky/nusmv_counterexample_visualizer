package nusmv_counterexample_visualizer;

import nusmv_counterexample_visualizer.formula.LTLFormula;
import nusmv_counterexample_visualizer.highlighting.HighlightingMode;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by buzhinsky on 9/3/17.
 */
class VerificationResult {
    final String strOriginalF;
    private final LTLFormula originalF;
    final Counterexample ce;
    private final Set<Clause> causalSet;
    final Set<VarNameClause> varNameCausalSet;
    final Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache = new HashMap<>();

    VerificationResult(String strOriginalF, LTLFormula originalF, LTLFormula normalizedF, Counterexample ce,
                       boolean fillValueCache) {
        this.strOriginalF = strOriginalF;
        this.originalF = originalF;
        this.ce = ce;
        causalSet = ce != null ? ce.causalSet(normalizedF) : new HashSet<>();
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

    AnnotationData result(Set<Pair<LTLFormula, Integer>> highlightSet, HighlightingMode hm) {
        final List<String> list = new ArrayList<>();
        if (ce != null) {
            for (int i = 0; i < ce.length(); i++) {
                list.add(ce.graphicalAnnotatedToString(formulaValueCache, originalF, causalSet, i, highlightSet, hm));
            }
        }
        return new AnnotationData(list, ce);
    }
}
