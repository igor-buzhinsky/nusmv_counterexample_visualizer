package nusmv_counterexample_visualizer;

import nusmv_counterexample_visualizer.formula.LTLFormula;
import nusmv_counterexample_visualizer.highlighting.HighlightingMode;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

/**
 * Created by buzhinsky on 9/3/17.
 */
class VerificationResult {
    final String strOriginalF;
    private final LTLFormula originalF;
    final Counterexample ce;
    private final Set<Cause> causalSet;
    final Set<VarNameCause> varNameCausalSet;
    final Map<Pair<Integer, LTLFormula>, Boolean> formulaValueCache = new HashMap<>();

    VerificationResult(String strOriginalF, LTLFormula originalF, LTLFormula normalizedF, Counterexample ce,
                       boolean fillValueCache) {
        this.strOriginalF = strOriginalF;
        this.originalF = originalF;
        this.ce = ce;
        causalSet = ce != null ? ce.causalSet(normalizedF) : new HashSet<>();
        varNameCausalSet = new HashSet<>();

        for (Cause cause : causalSet) {
            varNameCausalSet.addAll(cause.toVarNameClauses());
        }

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
        final List<String> listLong = new ArrayList<>();
        final List<String> listShort = new ArrayList<>();
        if (ce != null) {
            for (int i = 0; i < ce.length(); i++) {
                listLong.add(ce.graphicalAnnotatedToString(formulaValueCache, originalF, causalSet, i, highlightSet,
                        hm, false));
                listShort.add(ce.graphicalAnnotatedToString(formulaValueCache, originalF, causalSet, i, highlightSet,
                        hm, true));
            }
        }
        return new AnnotationData(listLong, listShort, ce);
    }
}
