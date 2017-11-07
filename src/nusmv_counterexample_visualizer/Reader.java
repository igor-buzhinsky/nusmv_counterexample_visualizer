package nusmv_counterexample_visualizer;

import nusmv_counterexample_visualizer.formula.LTLFormula;
import nusmv_counterexample_visualizer.generated.ltlLexer;
import nusmv_counterexample_visualizer.generated.ltlParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * Created by buzhinsky on 10/17/17.
 */
class Reader {
    private String strOriginalF;
    private LTLFormula originalF;
    private LTLFormula f;
    private Counterexample ce;
    final List<VerificationResult> result = new ArrayList<>();
    private final boolean fillValueCache;
    private int lineNum;

    Reader(boolean fillValueCache) {
        this.fillValueCache = fillValueCache;
    }

    void finalizeCounterexample() {
        if (f != null) {
            if (ce != null) {
                ce.padMissing();
                if (ce.loopPosition() == null) {
                    ce.setEmergencyLoopPosition();
                    System.err.println("Warning: for property " + originalF +
                            ", looping the last state since a finite counterexample was given.");
                }
                if (f.isPastTime()) {
                    ce.unwindLoopOnce();
                    System.err.println("Info: for past-time property " + originalF +
                            ", the loop has been unwound once.");
                }
                ce.setImportant(f.variableSet());
            }
            result.add(new VerificationResult(strOriginalF, originalF, f, ce, fillValueCache));
        }
        ce = null;
        f = null;
        strOriginalF = null;
    }

    void nextLine(String line) throws IOException {
        lineNum++;
        if (line.startsWith("-- specification ")) {
            finalizeCounterexample();
            strOriginalF = line.replaceAll("  +", " ");
            line = line.substring("-- specification ".length()).replace(" is true", "").replace(" is false", "");
            try (InputStream in = new ByteArrayInputStream(line.getBytes(StandardCharsets.UTF_8))) {
                final ltlLexer lexer = new ltlLexer(new ANTLRInputStream(in));
                final CommonTokenStream tokens = new CommonTokenStream(lexer);
                final ltlParser parser = new ltlParser(tokens);
                parser.addErrorListener(new ANTLRErrorListener() {
                    @Override
                    public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s,
                                            RecognitionException e) {
                        throw new NullPointerException();
                    }

                    @Override
                    public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet,
                                                ATNConfigSet atnConfigSet) {
                        throw new NullPointerException();
                    }

                    @Override
                    public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet,
                                                            ATNConfigSet atnConfigSet) {
                        throw new NullPointerException();
                    }

                    @Override
                    public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2,
                                                         ATNConfigSet atnConfigSet) {
                        throw new NullPointerException();
                    }
                });
                originalF = parser.formula().f;
            } catch (NullPointerException | RecognitionException e) {
                System.err.println("Parse error with " + strOriginalF);
                ce = null;
                f = null;
                return;
            }
            f = originalF.removeImplication().removeEquivalence().toNNF().removeFuture().removeRelease();
            ce = strOriginalF.endsWith(" is false") ? new Counterexample() : null;
        } else if (line.equals("  -- Loop starts here")) {
            if (ce != null) {
                ce.setLoopPosition();
            }
        } else if (line.startsWith("  -> ")) {
            if (ce != null) {
                ce.padMissing();
                ce.newElement();
            }
        } else if (line.startsWith("    ")) {
            if (ce != null) {
                final String[] tokens = line.substring(4).split(" = ");
                if (tokens.length != 2) {
                    System.err.println("Erroneous input at line " + lineNum + ", skipping.");
                } else {
                    ce.addValue(tokens[0], tokens[1]);
                }
            }
        }
    }
}
