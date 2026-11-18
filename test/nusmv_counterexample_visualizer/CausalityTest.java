package nusmv_counterexample_visualizer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Checks which (step, variable) pairs are reported as causes of a formula's value
 * (the highlighted values in the GUI and the {@code *...*} markers in console output).
 */
class CausalityTest {
    private static Set<VarNameCause> causes(String formula, String trace) {
        return TraceBuilder.evaluate(formula, trace).varNameCausalSet;
    }

    private static Set<VarNameCause> setOf(Object... positionVarPairs) {
        final Set<VarNameCause> set = new HashSet<>();
        for (int i = 0; i < positionVarPairs.length; i += 2) {
            set.add(new VarNameCause((Integer) positionVarPairs[i], (String) positionVarPairs[i + 1]));
        }
        return set;
    }

    @Test
    void globallyFailsAtTheFirstViolation() {
        assertEquals(setOf(1, "p"), causes("G p", "p=TRUE; p=FALSE; >p=TRUE"));
    }

    @Test
    void eventuallyFailsBecauseOfEveryStep() {
        assertEquals(setOf(0, "p", 1, "p"), causes("F p", "p=FALSE; >p=FALSE"));
    }

    @Test
    void conjunctionBlamesOnlyTheFalseConjunct() {
        assertEquals(setOf(0, "p"), causes("p & q", ">p=FALSE q=TRUE"));
    }

    @Test
    void trueFormulaIsExplainedViaItsNegation() {
        // F p is TRUE here; the witness is p at step 1
        assertEquals(setOf(1, "p"), causes("F p", "p=FALSE; >p=TRUE"));
    }

    @Test
    void irrelevantVariablesAreNeverBlamed() {
        final Set<VarNameCause> causes = causes("G (req -> X ack)",
                "req=TRUE ack=FALSE noise=TRUE; >req=FALSE ack=FALSE noise=FALSE");
        assertTrue(causes.contains(new VarNameCause(0, "req")), causes::toString);
        assertTrue(causes.contains(new VarNameCause(1, "ack")), causes::toString);
        assertTrue(causes.stream().noneMatch(c -> c.toString().startsWith("noise@")), causes::toString);
    }

    @Test
    void symbolicConstantsAreNotTreatedAsVariables() {
        final VerificationResult result = TraceBuilder.evaluate("G state = idle",
                "state=idle; >state=busy");
        assertEquals(setOf(1, "state"), result.varNameCausalSet);
        // console rendering lists only real variables among "values from the formula"
        final String output = result.result(false, true);
        assertTrue(output.contains("step 0: values from the formula [state = idle]\n"), output);
        assertTrue(output.contains("step 1: values from the formula \u2590state = busy\u258c\n"), output);
    }

    @Test
    void malformedSpecificationIsSkippedAndParsingContinues() {
        final List<String> lines = TraceBuilder.nusmvLines("G (p &", ">p=TRUE");
        lines.addAll(TraceBuilder.nusmvLines("G p", ">p=TRUE"));
        final List<VerificationResult> results = TraceBuilder.read(lines);
        assertEquals(1, results.size());
        assertEquals("G p", results.get(0).strOriginalF);
        assertEquals("TRUE", results.get(0).formulaValue());
    }

    @Test
    void multipleSpecificationsAreReadIndependently() {
        final List<String> lines = TraceBuilder.nusmvLines("G p", "p=TRUE; >p=FALSE");
        lines.addAll(TraceBuilder.nusmvLines("F q", ">q=TRUE"));
        final List<VerificationResult> results = TraceBuilder.read(lines);
        assertEquals(Arrays.asList("FALSE", "TRUE"),
                Arrays.asList(results.get(0).formulaValue(), results.get(1).formulaValue()));
    }
}
