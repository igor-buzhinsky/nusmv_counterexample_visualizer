package nusmv_counterexample_visualizer;

import nusmv_counterexample_visualizer.formula.LTLFormula;
import org.apache.commons.lang3.tuple.Pair;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by buzhinsky on 10/17/17.
 */
public class AnnotationData {
    final String property;
    final List<String> annotations;
    final Counterexample ce;
    final Set<Clause> causalSet;
    final LTLFormula originalProperty;
    final Map<Pair<Integer, LTLFormula>, Boolean> valueCache;

    AnnotationData(String property, List<String> annotations, Counterexample ce, Set<Clause> causalSet,
                   LTLFormula originalProperty, Map<Pair<Integer, LTLFormula>, Boolean> valueCache) {
        this.property = property;
        this.annotations = annotations;
        this.ce = ce;
        this.causalSet = causalSet;
        this.originalProperty = originalProperty;
        this.valueCache = valueCache;
    }

    static List<VerificationResult> graphicalAnnotation(String inputFilename, Set<Pair<LTLFormula, Integer>> highlightSet)
            throws IOException {
        final List<String> lines;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilename)))) {
            lines = reader.lines().collect(Collectors.toList());
        }
        final Reader reader = new Reader(true);
        for (String line : lines) {
            reader.nextLine(line);
        }
        reader.finalizeCounterexample();
        return reader.result;
    }
}
