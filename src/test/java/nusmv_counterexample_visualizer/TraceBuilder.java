package nusmv_counterexample_visualizer;

import nusmv_counterexample_visualizer.formula.ltl.LTLFormula;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Builds NuSMV-style input from a compact trace notation and feeds it to {@link Reader}.
 *
 * <p>Trace notation: states are separated by {@code ;}, assignments within a state by whitespace
 * ({@code p=TRUE q=3}). A state prefixed with {@code >} is where the loop starts; if no state is marked, the tool's
 * own fallback (looping the last state) applies. As in NuSMV output, a variable omitted from a state keeps its
 * previous value.
 */
final class TraceBuilder {
    private TraceBuilder() {
    }

    static List<String> nusmvLines(String formula, String trace) {
        final List<String> lines = new ArrayList<>();
        lines.add("-- specification " + formula);
        int stateNum = 1;
        for (String state : trace.split(";")) {
            state = state.trim();
            if (state.startsWith(">")) {
                lines.add("  -- Loop starts here");
                state = state.substring(1).trim();
            }
            lines.add("  -> State: 1." + stateNum++ + " <-");
            if (!state.isEmpty()) {
                for (String assignment : state.split("\\s+")) {
                    final String[] parts = assignment.split("=", 2);
                    lines.add("    " + parts[0] + " = " + parts[1]);
                }
            }
        }
        return lines;
    }

    static List<VerificationResult> read(List<String> lines) {
        LTLFormula.reset();
        final Reader reader = new Reader(true);
        try {
            for (String line : lines) {
                reader.nextLine(line);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        reader.finalizeCounterexample();
        return reader.result;
    }

    static VerificationResult evaluate(String formula, String trace) {
        final List<VerificationResult> results = read(nusmvLines(formula, trace));
        if (results.size() != 1) {
            throw new AssertionError("Expected exactly one result for " + formula + ", got " + results.size());
        }
        return results.get(0);
    }
}
