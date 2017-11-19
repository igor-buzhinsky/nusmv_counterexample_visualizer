package nusmv_counterexample_visualizer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by buzhinsky on 10/17/17.
 */
class AnnotationData {
    final List<String> annotations;
    final List<String> shortAnnotations;
    final Counterexample ce;

    AnnotationData(List<String> annotations, List<String> shortAnnotations, Counterexample ce) {
        this.annotations = annotations;
        this.shortAnnotations = shortAnnotations;
        this.ce = ce;
    }

    static List<VerificationResult> graphicalAnnotation(String inputFilename) throws IOException {
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
