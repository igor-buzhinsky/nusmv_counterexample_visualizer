package nusmv_counterexample_visualizer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Uses the model checker as an independent oracle: for every specification in an input file, the truth value
 * computed by the tool on the counterexample must agree with the verdict printed by NuSMV/nuXmv
 * ("... is true" / "... is false"). Unlike the snapshot tests, this catches semantic bugs that already exist
 * rather than only changes in behavior.
 */
class NuSMVVerdictTest {
    @ParameterizedTest
    @ValueSource(strings = {"example-input.txt", "example-input-nuxmv-reals.txt", "test/inputs/symbolic-values.txt"})
    void computedValuesAgreeWithModelChecker(String input) throws IOException {
        final List<String> lines = Files.readAllLines(Paths.get(input), StandardCharsets.UTF_8);
        final List<String> expected = new ArrayList<>();
        for (String line : lines) {
            if (line.startsWith("-- specification ")) {
                final String verdict = line.endsWith(" is true") ? "TRUE" : line.endsWith(" is false") ? "FALSE" : null;
                if (verdict == null) {
                    throw new AssertionError("Specification without a verdict in " + input + ": " + line);
                }
                expected.add(verdict);
            }
        }

        final List<VerificationResult> results = TraceBuilder.read(lines);
        assertEquals(expected.size(), results.size(), "some specifications in " + input + " were not parsed");
        for (int i = 0; i < results.size(); i++) {
            final VerificationResult result = results.get(i);
            assertEquals(expected.get(i), result.formulaValue(), () -> input + ": " + result.strOriginalF);
        }
    }
}
