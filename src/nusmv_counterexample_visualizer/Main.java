package nusmv_counterexample_visualizer;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.spi.BooleanOptionHandler;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    @Argument(usage = "NuSMV output file (input for the tool)", metaVar = "<in>", required = true, index = 0)
    private String input;

    @Argument(usage = "result file", metaVar = "<out>", required = true, index = 1)
    private String output;

    @Option(name = "--allVars", handler = BooleanOptionHandler.class,
            usage = "show values of all variables")
    private boolean allVars;

    @Option(name = "--annotateFormulas", handler = BooleanOptionHandler.class,
            usage = "show truth values of subformulas for each position of a counterexample")
    private boolean annotateFormulas;

    private void run(String[] args) throws IOException {
        if (parseArgs(args)) {
            launcher();
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().run(args);
    }

    private boolean parseArgs(String[] args) {
        final CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
            return true;
        } catch (CmdLineException e) {
            System.out.print("Usage: java -jar visualizer.jar ");
            parser.printSingleLineUsage(System.out);
            System.out.println();
            parser.printUsage(System.out);
            return false;
        }
    }

    private void launcher() throws IOException {
	    final List<String> lines;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(input)))) {
            lines = reader.lines().collect(Collectors.toList());
        }
        final Reader reader = new Reader(annotateFormulas);
        for (String line : lines) {
            reader.nextLine(line);
        }
        reader.finalizeCounterexample();
        try (BufferedWriter out = new BufferedWriter(new FileWriter(output))) {
            for (VerificationResult result : reader.result) {
                String s = result.result(allVars, annotateFormulas)
                        .replace("▅", "_").replace("▐", "*").replace("▌", "*");
                out.write(s);
            }
        }
        System.out.println();
    }
}
