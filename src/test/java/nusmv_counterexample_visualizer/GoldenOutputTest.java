package nusmv_counterexample_visualizer;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Snapshot (golden-file) tests: runs the console tool on the example inputs and compares the output with recorded
 * files (for the bundled examples, recorded from the released jar). Any change in formula evaluation, causality
 * analysis or rendering shows up as a diff here.
 *
 * <p>To re-record the snapshots after an intended change, run {@code ./gradlew updateGolden} and review the diff.
 */
class GoldenOutputTest {
    private static final Path GOLDEN_DIR = Paths.get("src", "test", "resources", "golden");
    private static final boolean UPDATE = Boolean.getBoolean("golden.update");

    private static final String[] INPUTS = {
            "example-input.txt", "example-input-nuxmv-reals.txt", "src/test/resources/inputs/symbolic-values.txt"};

    private static final String[][] OPTION_SETS = {
            {},
            {"--annotateFormulas"},
            {"--allVars", "--annotateFormulas"},
    };

    @TempDir
    Path tempDir;

    @TestFactory
    Stream<DynamicTest> consoleOutputMatchesSnapshot() {
        final List<DynamicTest> tests = new ArrayList<>();
        for (String input : INPUTS) {
            for (String[] options : OPTION_SETS) {
                final String name = goldenName(input, options);
                tests.add(DynamicTest.dynamicTest(name, () -> check(input, options, name)));
            }
        }
        return tests.stream();
    }

    private void check(String input, String[] options, String goldenName) throws IOException {
        final Path actualFile = tempDir.resolve(goldenName);
        final List<String> args = new ArrayList<>(Arrays.asList(input, actualFile.toString()));
        args.addAll(Arrays.asList(options));
        ConsoleMain.main(args.toArray(new String[0]));

        final String actual = new String(Files.readAllBytes(actualFile), StandardCharsets.UTF_8);
        final Path goldenFile = GOLDEN_DIR.resolve(goldenName);
        if (UPDATE) {
            Files.createDirectories(GOLDEN_DIR);
            Files.write(goldenFile, actual.getBytes(StandardCharsets.UTF_8));
            return;
        }
        final String expected = new String(Files.readAllBytes(goldenFile), StandardCharsets.UTF_8);
        assertEquals(expected, actual, "Output differs from snapshot " + goldenFile);
    }

    private static String goldenName(String input, String[] options) {
        final StringBuilder sb = new StringBuilder(Paths.get(input).getFileName().toString().replaceAll("\\.txt$", ""));
        for (String option : options) {
            sb.append('_').append(option.replace("--", ""));
        }
        return sb.append(".out").toString();
    }
}
