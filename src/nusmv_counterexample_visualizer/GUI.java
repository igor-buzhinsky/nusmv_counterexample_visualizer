package nusmv_counterexample_visualizer;

import nusmv_counterexample_visualizer.formula.BinaryOperator;
import nusmv_counterexample_visualizer.formula.LTLFormula;
import nusmv_counterexample_visualizer.formula.UnaryOperator;
import nusmv_counterexample_visualizer.highlighting.HighlightingMode;
import org.apache.commons.lang3.tuple.Pair;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Created by buzhinsky on 10/16/17.
 */
public class GUI extends JFrame {
    @Argument(usage = "NuSMV output file (input for the tool)", metaVar = "<in>", required = false)
    private String input;

    public static void main(String[] args) throws IOException {
        new GUI().run(args);
    }

    private void run(String[] args) throws IOException {
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

    private GUI() {
    }

    private void launcher() {
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

    private java.util.List<VerificationResult> annotations = null;
    private int currentSpec = -1;
    private final Set<Pair<LTLFormula, Integer>> highlightSet = new HashSet<>();
    private final java.util.List<JTextPane> annotationPanels = new ArrayList<>();
    private final java.util.List<String> annotationTexts = new ArrayList<>();
    private HighlightingMode hm = HighlightingMode.modes().iterator().next();

    private final static int FONT_SIZE = 20;

    private static String wrap(String str) {
        return "<html><div style=\"font-family: 'Lucida Console', 'Monospaced', monospace; font-size: " + FONT_SIZE
                + "\">" + str + "</div></html>";
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
        final String[] columns = new String[] { "#", "Value", "LTL Specification" };

        final Object[][] data = new Object[annotations.size()][];
        for (int i = 0; i < annotations.size(); i++) {
            String property = annotations.get(i).strOriginalF.replaceAll("^-- specification ", "");
            final String satisfied;
            if (property.endsWith("is false")) {
                satisfied = "FALSE";
                property = property.replaceAll("is false$", "");
            } else if (property.endsWith("is true")) {
                satisfied = "TRUE";
                property = property.replaceAll("is true$", "");
            } else {
                throw new RuntimeException();
            }
            data[i] = new Object[] { i + 1, satisfied, property };
        }

        final JTable specTable = new JTable(data, columns);
        specTable.getColumnModel().getColumn(0).setMaxWidth(50);
        specTable.getColumnModel().getColumn(1).setMaxWidth(50);
        specTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
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
    }

    private void createLowerPanel() {
        lowerPanel = new JPanel();
        lowerPanel.setLayout(new GridLayout(1, 4));

        compactCheckbox = new JCheckBox();
        compactCheckbox.setText("Compact annotations");
        compactCheckbox.addItemListener(e -> fastUpdateAnnotationPanel());
        lowerPanel.add(compactCheckbox);

        final JComboBox<String> box = new JComboBox<>();
        for (HighlightingMode hm : HighlightingMode.modes()) {
            box.addItem(hm.name() + " highlighting");
        }
        box.addItemListener(e -> {
            hm = HighlightingMode.get(box.getSelectedItem().toString().replaceAll(" highlighting$", ""));
            updateAnnotationPanel();
            updateValueTable();
        });
        lowerPanel.add(box);

        lowerPanel.add(new JPanel());

        final JButton aboutButton = new JButton("About");

        final java.util.List<String> lines = Arrays.asList(
                "NuSMV LTL counterexample visualizer",
                "By Igor Buzhinsky, Aalto University & ITMO University, igor.buzhinsky@gmail.com",
                "",
                "The top panel lists LTL specifications from the input file. Visualization is available only " +
                        "for FALSE specifications. Select a FALSE specification to see the visualization of the " +
                        "counterexample for this specification in the middle panel.",
                "",
                "In the middle panel, the values (T, F) of each subformula of the LTL specification are shown for " +
                        "each step of the counterexample. Click on an annotation below a subformula to see an " +
                        "explanation of its value. As a result, this and some other values will be highlighted. In " +
                        "addition, important atomic propositions are highlighted in the LTL formula.",
                "",
                "An additional compact highlighting mode is available which displays subformula values on the same " +
                        "line where the formula is displayed. Explanations also work in this mode.",
                "",
                "In the bottom panel, the values of all variables for all counterexample steps are provided. The " +
                        "values which are present in the LTL formula are shown on the left. Important values are " +
                        "hightlighted.",
                "",
                "Highlighting of important atomic propositions is implemented (with some enhancements) according to " +
                        "the polynomial algorithm from: I. Beer, S. Ben-David, H. Chockler, A. Orni, R. Trefler. " +
                        "Explaining counterexamples using causality. Computer Aided Verification, pp. 94-108, 2009. " +
                        "Springer Berlin/Heidelberg.",
                "",
                "Supported arithmetic operators: comparisons, +, -, /, *, mod. Supported past-time LTL operators: " +
                        "Y, Z, O, H. If the provided counterexample has no loop (e.g. when BMC is used), the last " +
                        "element is looped automatically."
        );

        final JTextArea message = new JTextArea(String.join("\n", lines));
        message.setFont(message.getFont().deriveFont((float) FONT_SIZE));
        message.setColumns(45);
        message.setRows(20);
        message.setWrapStyleWord(true);
        message.setLineWrap(true);
        message.setEditable(false);
        aboutButton.addActionListener(e -> JOptionPane.showMessageDialog(this, new JScrollPane(message), "About",
                JOptionPane.INFORMATION_MESSAGE));
        lowerPanel.add(aboutButton);
    }

    private void updateValueTable() {
        if (currentSpec == -1) {
            return;
        }
        final JTable table = currentSpec >= 0 && annotations.get(currentSpec).ce != null
                ? annotations.get(currentSpec).ce.graphicalValueTable(annotations.get(currentSpec).varNameCausalSet, hm)
                : new JTable();
        valueScrollPane.setViewportView(table);
    }

    private void addElements() {
        createSpecTable();
        annotationScrollPane = new JScrollPane();
        createValueTable();
        createLowerPanel();

        final JSplitPane splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, propertyScrollPane,
                annotationScrollPane);
        final JSplitPane splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitPane1, valueScrollPane);

        rootPanel.add(splitPane2);
        rootPanel.add(lowerPanel, BorderLayout.SOUTH);

        splitPane1.setDividerLocation(150);
        splitPane2.setResizeWeight(0);
        splitPane2.setDividerLocation(550);
        splitPane2.setResizeWeight(1);
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

        for (int i = 0; i < annotation.longAnnotations.size(); i++) {
            if (i > 0) {
                final JPanel spacing = new JPanel();
                spacing.setBackground(Color.GRAY);
                panel.add(spacing);
            }
            final JPanel innerPanel = new JPanel();
            final BoxLayout layout = new BoxLayout(innerPanel, BoxLayout.X_AXIS);
            innerPanel.setLayout(layout);
            final JEditorPane textField = new JEditorPane();
            textField.setContentType("text/html");
            textField.setText(wrap("pos = " + i + "<br>" + (i < annotation.ce.loopPosition()
                    ? "prefix&nbsp;&nbsp;&nbsp;" : "loop&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")));
            textField.setEditable(false);
            textField.setMaximumSize(new Dimension(120, Integer.MAX_VALUE));
            textField.setBackground(Color.getHSBColor(1f, 0, 0.95f));
            innerPanel.add(textField);
            final JPanel panelWithListener = panelWithHtmlListener("");
            innerPanel.add(panelWithListener);
            annotationPanels.add((JTextPane) panelWithListener.getComponent(0));
            annotationTexts.add("");
            panel.add(innerPanel);
        }

        annotationScrollPane.setViewportView(panel);
        fastUpdateAnnotationPanel();
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

        SwingUtilities.invokeLater(() -> {
            annotationScrollPane.getHorizontalScrollBar().setValue(scrollX);
            annotationScrollPane.getVerticalScrollBar().setValue(scrollY);
        });

        highlightSet.clear();
    }

    private JPanel panelWithHtmlListener(String msg) {
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
                                    p -> false, p -> {}, p -> {});
                            break;
                        case "F":
                            result.ce.loop(position, p -> add.accept(!value || cache.get(Pair.of(p, arg)), p),
                                    p -> false, p -> {}, p -> {});
                            break;
                        case "Y": case "Z":
                            add.accept(position > 0, position - 1);
                            break;
                        case "H":
                            result.ce.loopBack(position, p -> add.accept(value || !cache.get(Pair.of(p, arg)), p),
                                    p -> false, p -> {}, p -> {});
                            break;
                        case "O":
                            result.ce.loopBack(position, p -> add.accept(!value || cache.get(Pair.of(p, arg)), p),
                                    p -> false, p -> {}, p -> {});
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
                        case "<->":
                            addLeft.accept(position);
                            addRight.accept(position);
                            break;
                        case "U": // complementary to V
                            if (value) {
                                result.ce.loop(position, p -> {}, p -> cache.get(Pair.of(p, rightArg)),
                                        addRight, addLeft);
                            } else {
                                result.ce.loop(position, addRight, p -> !cache.get(Pair.of(p, leftArg)),
                                        addLeft, p -> {});
                            }
                            break;
                        case "V": // complementary to U
                            if (value) {
                                result.ce.loop(position, addRight, p -> cache.get(Pair.of(p, leftArg)),
                                        addLeft, p -> {});
                            } else {
                                result.ce.loop(position, p -> {}, p -> !cache.get(Pair.of(p, rightArg)),
                                        addRight, addLeft);
                            }
                            break;
                    }
                }
                fastUpdateAnnotationPanel();
            }
        });

        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(5, 5));
        panel.add(pane, BorderLayout.CENTER);

        return panel;
    }
}
