package nusmv_counterexample_visualizer;

import nusmv_counterexample_visualizer.formula.ltl.BinaryOperator;
import nusmv_counterexample_visualizer.formula.ltl.LTLFormula;
import nusmv_counterexample_visualizer.formula.ltl.UnaryOperator;
import nusmv_counterexample_visualizer.highlighting.DefaultHighlightingMode;
import nusmv_counterexample_visualizer.highlighting.HighlightingMode;
import org.apache.commons.lang3.tuple.Pair;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by buzhinsky on 10/16/17.
 */
public class GUIMain extends JFrame {
    @Argument(usage = "NuSMV output file (input for the tool)", metaVar = "<in>")
    private String input;

    @Option(name = "--mainFontSize", metaVar = "<size>", usage = "font size for the main panels (default 20)")
    private int mainFontSize = 20;

    @Option(name = "--auxFontSize", metaVar = "<size>", usage = "font size for auxiliary panels (default 16)")
    private int auxFontSize = 16;

    @Option(name = "--highlightColor", metaVar = "<color>", usage = "highlight color in the hex format (default #ffff00)")
    private String highlightColor = "#ffff00";

    @Option(name = "--trueColor", metaVar = "<color>", usage = "TRUE value color in the hex format (default #008000)")
    private String trueColor = "#008000";

    @Option(name = "--falseColor", metaVar = "<color>", usage = "FALSE value color in the hex format (default #ff0000)")
    private String falseColor = "#ff0000";

    @Option(name = "--highlightChar", metaVar = "<char>", usage = "character to mark important values (default *)")
    private String highlightChar = "*";

    public static void main(String[] args) {
        new GUIMain().run(args);
    }

    private void run(String[] args) {
        if (parseArgs(args)) {
            launcher();
        }
    }

    private boolean parseArgs(String[] args) {
        final CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
            return true;
        } catch (CmdLineException e) {
            System.out.print("Usage: java -jar visualizer-gui.jar");
            parser.printSingleLineUsage(System.out);
            System.out.println();
            parser.printUsage(System.out);
            return false;
        }
    }

    private void launcher() {
        varInit();
        setLookAndFeel();

        if (input == null) {
            final JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Select file with NuSMV output (LTL only)");
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
            final int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                input = fileChooser.getSelectedFile().getAbsolutePath();
            } else {
                System.err.println("Input file not selected, terminating.");
                return;
            }
        }

        auxFontSize = Math.max(auxFontSize, 4);
        mainFontSize = Math.max(mainFontSize, 4);

        DefaultHighlightingMode.HIGHLIGHT_COLOR = highlightColor;
        DefaultHighlightingMode.TRUE_COLOR = trueColor;
        DefaultHighlightingMode.FALSE_COLOR = falseColor;
        DefaultHighlightingMode.HIGHLIGHT_CHAR = highlightChar.isEmpty() ? "*" : String.valueOf(highlightChar.charAt(0));

        rootPanel = new JPanel();
        setTitle("NuSMV LTL Counterexample Visualizer");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        rootPanel.setLayout(new BorderLayout());
        setContentPane(rootPanel);
        try {
            annotations = AnnotationData.graphicalAnnotation(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        addElements();
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel rootPanel;
    private JScrollPane propertyScrollPane;
    private JScrollPane annotationScrollPane;
    private JScrollPane valueScrollPane;
    private JPanel lowerPanel;
    private JCheckBox compactCheckbox;
    private JComboBox<String> highlightingBox;
    private JSplitPane splitPane1;
    private JSplitPane splitPane2;

    private java.util.List<VerificationResult> annotations;
    private int currentSpec;
    private Set<Pair<LTLFormula, Integer>> highlightSet;
    private java.util.List<JTextPane> annotationPanels;
    private java.util.List<String> annotationTexts;
    private HighlightingMode hm;

    private void varInit() {
        annotations = null;
        currentSpec = -1;
        highlightSet = new HashSet<>();
        annotationPanels = new ArrayList<>();
        annotationTexts = new ArrayList<>();
        hm = HighlightingMode.modes().iterator().next();
    }

    private String wrap(String str) {
        return "<html><div style=\"font-family: 'Lucida Console', 'Monospaced', monospace; font-size: "
                + mainFontSize + "\">" + str + "</div></html>";
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private void createSpecTable() {
        final String[] columns = new String[] { "#", "Value", "LTL specification" };

        final Object[][] data = new Object[annotations.size()][];
        for (int i = 0; i < annotations.size(); i++) {
            final VerificationResult result = annotations.get(i);
            final String value = result.formulaValue();
            final Function<String, String> color = result.ce == null
                    ? s -> "<html><font color=gray>" + s + "</font></html>"
                    : s -> "<html>" + s + "</html>";
            data[i] = new Object[] { i + 1, color.apply(value), color.apply(Util.toHtmlString(result.strOriginalF)) };
        }

        final JTable specTable = new JTable(data, columns);
        Util.unifyTable(specTable, auxFontSize);
        Util.resizeColumnWidth(specTable);

        propertyScrollPane = new JScrollPane(specTable);

        specTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        specTable.getSelectionModel().addListSelectionListener(e -> {
            if (e.getValueIsAdjusting()) {
                return;
            }
            final String strSource = e.getSource().toString();
            final int start = strSource.indexOf("{") + 1;
            final int stop = strSource.length() - 1;
            currentSpec = Integer.parseInt(strSource.substring(start, stop));
            updateAnnotationPanel();
            updateValueTable();
        });
    }

    private void createValueTable() {
        final JTable table = new JTable();
        valueScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        valueScrollPane.setViewportView(Util.messageField("Select LTL specification in the top panel.",
                auxFontSize));
    }

    private void createLowerPanel() {
        lowerPanel = new JPanel();
        lowerPanel.setLayout(new GridLayout(1, 4));

        compactCheckbox = new JCheckBox();
        compactCheckbox.setText("Compact annotations");
        compactCheckbox.addItemListener(e -> fastUpdateAnnotationPanel());
        compactCheckbox.setSelected(true);
        lowerPanel.add(compactCheckbox);

        highlightingBox = new JComboBox<>();
        for (HighlightingMode hm : HighlightingMode.modes()) {
            highlightingBox.addItem(hm.name() + " highlighting");
        }
        highlightingBox.addItemListener(e -> {
            hm = HighlightingMode.get(highlightingBox.getSelectedItem().toString().replaceAll(" highlighting$", ""));
            updateAnnotationPanel();
            updateValueTable();
        });
        lowerPanel.add(highlightingBox);

        final JButton reloadButton = new JButton("Reload input file");
        reloadButton.addActionListener(e -> {
            final boolean compact = compactCheckbox.isSelected();
            final int highlightingIndex = highlightingBox.getSelectedIndex();
            final int splitPane1Pos = splitPane1.getDividerLocation();
            final int splitPane2Pos = splitPane2.getDividerLocation();
            LTLFormula.reset();
            launcher();
            compactCheckbox.setSelected(compact);
            highlightingBox.setSelectedIndex(highlightingIndex);
            javax.swing.SwingUtilities.invokeLater(() -> {
                splitPane1.setDividerLocation(splitPane1Pos);
                splitPane2.setDividerLocation(splitPane2Pos);
            });
        });
        lowerPanel.add(reloadButton);

        final JButton aboutButton = new JButton("About & Help");
        final java.util.List<String> lines = Arrays.asList(
                "NuSMV LTL counterexample visualizer",
                "By Igor Buzhinsky, Aalto University & ITMO University, igor.buzhinsky@gmail.com",
                "",
                "The top panel lists LTL specifications from the input file. Visualization is available only " +
                        "for FALSE specifications. Select a FALSE specification to see the visualization of the " +
                        "counterexample for this specification in the middle panel.",
                "",
                "In the middle panel, the values (T = true, F = false) of each subformula of the LTL specification are " +
                        "shown for each step of the counterexample. Click on an annotation below a subformula to see " +
                        "an explanation of its value. As a result, this and some other values will be highlighted. In " +
                        "addition, important atomic propositions are highlighted in the LTL formula.",
                "",
                "An additional compact highlighting mode is available which displays subformula values on the same " +
                        "line where the formula is displayed. Explanations also work in this mode.",
                "",
                "In the bottom panel, the values of all variables for all counterexample steps are provided. The " +
                        "values which are present in the LTL formula are shown on the left. Important values are " +
                        "highlighted.",
                "",
                "Highlighting of important atomic propositions is implemented (with some enhancements) according to " +
                        "the polynomial algorithm from: I. Beer, S. Ben-David, H. Chockler, A. Orni, R. Trefler. " +
                        "Explaining counterexamples using causality. Computer Aided Verification, pp. 94-108, 2009. " +
                        "Springer Berlin/Heidelberg.",
                "",
                "Almost all arithmetic operators are supported. Supported past-time LTL operators: Y, Z, O, H. " +
                        "If the provided counterexample has no loop (e.g. when BMC is used), the last element is " +
                        "looped automatically.",
                "",
                "Font sizes can be configured via command line options --mainFontSize <size> and --auxFontSize <size>.",
                "",
                "The colors of the default highlighting mode can be configured via command line options " +
                        "--highlightColor <color>, --trueColor <color>, --falseColor <color>. Another option " +
                        "--highlightChar <char> specifies the character used to highlight important Boolean values."
        );

        final JTextArea message = Util.messageField(String.join("\n", lines), auxFontSize);
        message.setColumns(45);
        message.setRows(20);
        aboutButton.addActionListener(e -> JOptionPane.showMessageDialog(this, new JScrollPane(message), "About & Help",
                JOptionPane.INFORMATION_MESSAGE));
        lowerPanel.add(aboutButton);
    }

    private void updateValueTable() {
        if (currentSpec == -1) {
            return;
        }
        final VerificationResult result = annotations.get(currentSpec);
        valueScrollPane.setViewportView(result.ce != null
                ? result.ce.graphicalValueTable(result.varNameCausalSet, hm, auxFontSize)
                : Util.messageField("For specification " + result.originalF +
                    ", no trace is provided in the input. If the input is produced by NuSMV, this is only possible for" +
                    " specifications which are TRUE and thus do not have counterexamples.", auxFontSize));
    }

    private void addElements() {
        createSpecTable();
        annotationScrollPane = new JScrollPane();
        createValueTable();
        createLowerPanel();

        splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, propertyScrollPane, annotationScrollPane);
        splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitPane1, valueScrollPane);

        rootPanel.add(splitPane2);
        rootPanel.add(lowerPanel, BorderLayout.SOUTH);

        splitPane1.setDividerLocation(150);
        splitPane2.setResizeWeight(0);
        splitPane2.setDividerLocation(550);
        splitPane2.setResizeWeight(1);
    }

    private String htmlSpaces(int num) {
        return Util.nStrings("&nbsp;", String.valueOf(annotations.get(currentSpec).ce.length() - 1).length()
            - String.valueOf(num).length());
    }

    private void updateAnnotationPanel() {
        if (currentSpec == -1) {
            return;
        }
        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        annotationPanels.clear();
        annotationTexts.clear();
        final AnnotationData annotation = annotations.get(currentSpec).result(highlightSet, hm);

        final java.util.List<JPanel> innerPanels = new ArrayList<>();

        final Consumer<JTextComponent> setBorder = c -> c.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black),
                BorderFactory.createLineBorder(c.getBackground(), 3)));

        for (int i = 0; i < annotation.longAnnotations.size(); i++) {
            final JPanel innerPanel = new JPanel();
            innerPanels.add(innerPanel);

            final BoxLayout layout = new BoxLayout(innerPanel, BoxLayout.X_AXIS);
            innerPanel.setLayout(layout);
            final JEditorPane textField = new JEditorPane();
            textField.setContentType("text/html");
            textField.setText(wrap("step " + i + htmlSpaces(i) + "<br>"
                    + (i < annotation.ce.loopPosition() ? "prefix" : "loop")));
            textField.setEditable(false);
            textField.setMaximumSize(new Dimension(1, Integer.MAX_VALUE));
            textField.setBackground(Color.getHSBColor(1f, 0, 0.95f));
            textField.setBorder(BorderFactory.createLineBorder(Color.black));
            innerPanel.add(textField);
            setBorder.accept(textField);
            final JTextPane panelWithListener = panelWithHtmlListener("");
            setBorder.accept(panelWithListener);
            innerPanel.add(panelWithListener);
            annotationPanels.add(panelWithListener);
            annotationTexts.add("");
            panel.add(innerPanel);
        }

        annotationScrollPane.setViewportView(panel);
        fastUpdateAnnotationPanel();

        SwingUtilities.invokeLater(() -> innerPanels.forEach(p -> {
            p.revalidate();
            p.repaint();
        }));
    }

    private void fastUpdateAnnotationPanel() {
        if (currentSpec == -1) {
            return;
        }
        final int scrollX = annotationScrollPane.getHorizontalScrollBar().getValue();
        final int scrollY = annotationScrollPane.getVerticalScrollBar().getValue();
        final AnnotationData annotation = annotations.get(currentSpec).result(highlightSet, hm);
        for (int i = 0; i < annotation.longAnnotations.size(); i++) {
            final String strAnnotation = wrap((compactCheckbox.isSelected() ? annotation.shortAnnotations
                    : annotation.longAnnotations).get(i));
            final JTextPane panel = annotationPanels.get(i);
            final String previousText = annotationTexts.get(i);
            if (!previousText.equals(strAnnotation)) {
                panel.setText(strAnnotation);
                annotationTexts.set(i, strAnnotation);
                panel.getParent().getParent().revalidate();
                panel.getParent().getParent().repaint();
            }
        }

        highlightSet.clear();

        SwingUtilities.invokeLater(() -> {
            annotationScrollPane.getHorizontalScrollBar().setValue(scrollX);
            annotationScrollPane.getVerticalScrollBar().setValue(scrollY);
        });
    }

    private JTextPane panelWithHtmlListener(String msg) {
        final JTextPane pane = new JTextPane();
        pane.setContentType("text/html");
        pane.setText(msg);
        pane.setEditable(false);
        pane.setOpaque(true);
        pane.setBackground(Color.WHITE);

        pane.addHyperlinkListener(hyperLink -> {
            if (HyperlinkEvent.EventType.ACTIVATED.equals(hyperLink.getEventType())) {
                //respond to html link clicked
                final String[] tokens = hyperLink.getDescription().split(":");
                final int formulaIndex = Integer.parseInt(tokens[0]);
                final int position = Integer.parseInt(tokens[1]);
                final LTLFormula f = LTLFormula.intToFormula(formulaIndex);
                final VerificationResult result = annotations.get(currentSpec);
                final Map<Pair<Integer, LTLFormula>, Boolean> cache = result.formulaValueCache;
                final boolean value = cache.get(Pair.of(position, f));
                highlightSet.add(Pair.of(f, position));

                if (f instanceof UnaryOperator) {
                    final LTLFormula arg = ((UnaryOperator) f).argument;
                    final BiConsumer<Boolean, Integer> add = (cond, p) -> {
                        if (cond) {
                            highlightSet.add(Pair.of(arg, p));
                        }
                    };
                    switch (((UnaryOperator) f).name) {
                        case "!":
                            add.accept(true, position);
                            break;
                        case "X":
                            add.accept(true, result.ce.shiftPosition(position + 1));
                            break;
                        case "G":
                            result.ce.loop(position, p -> add.accept(value || !cache.get(Pair.of(p, arg)), p),
                                    p -> false, p -> {}, p -> {}, () -> {});
                            break;
                        case "F":
                            result.ce.loop(position, p -> add.accept(!value || cache.get(Pair.of(p, arg)), p),
                                    p -> false, p -> {}, p -> {}, () -> {});
                            break;
                        case "Y": case "Z":
                            add.accept(position > 0, position - 1);
                            break;
                        case "H":
                            result.ce.loopBack(position, p -> add.accept(value || !cache.get(Pair.of(p, arg)), p),
                                    p -> false, p -> {}, p -> {}, () -> {});
                            break;
                        case "O":
                            result.ce.loopBack(position, p -> add.accept(!value || cache.get(Pair.of(p, arg)), p),
                                    p -> false, p -> {}, p -> {}, () -> {});
                            break;
                    }
                } else if (f instanceof BinaryOperator) {
                    final LTLFormula leftArg = ((BinaryOperator) f).leftArgument;
                    final LTLFormula rightArg = ((BinaryOperator) f).rightArgument;
                    final boolean leftValue = cache.get(Pair.of(position, leftArg));
                    final boolean rightValue = cache.get(Pair.of(position, rightArg));
                    final Consumer<Integer> addLeft = p -> highlightSet.add(Pair.of(leftArg, p));
                    final Consumer<Integer> addRight = p -> highlightSet.add(Pair.of(rightArg, p));
                    final BiConsumer<Boolean, Integer> addLeftIf = (v, p) -> { if (v) { addLeft.accept(p); } };
                    final BiConsumer<Boolean, Integer> addRightIf = (v, p) -> { if (v) { addRight.accept(p); } };
                    switch (((BinaryOperator) f).name) {
                        case "&":
                            addLeftIf.accept(value || !leftValue, position);
                            addRightIf.accept(value || !rightValue, position);
                            break;
                        case "|":
                            addLeftIf.accept(!value || leftValue, position);
                            addRightIf.accept(!value || rightValue, position);
                            break;
                        case "->":
                            addLeftIf.accept(!value || !leftValue, position);
                            addRightIf.accept(!value || rightValue, position);
                            break;
                        case "<->": case "xnor": case "xor":
                            addLeft.accept(position);
                            addRight.accept(position);
                            break;
                        case "U": // complementary to V
                            if (value) {
                                result.ce.loop(position, p -> {}, p -> cache.get(Pair.of(p, rightArg)),
                                        addRight, addLeft, () -> {});
                            } else {
                                result.ce.loop(position, addRight, p -> !cache.get(Pair.of(p, leftArg)),
                                        addLeft, p -> {}, () -> {});
                            }
                            break;
                        case "V": // complementary to U
                            if (value) {
                                result.ce.loop(position, addRight, p -> cache.get(Pair.of(p, leftArg)),
                                        addLeft, p -> {}, () -> {});
                            } else {
                                result.ce.loop(position, p -> {}, p -> !cache.get(Pair.of(p, rightArg)),
                                        addRight, addLeft, () -> {});
                            }
                            break;
                    }
                }
                fastUpdateAnnotationPanel();
            }
        });

        return pane;
    }
}
