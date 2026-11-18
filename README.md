# NuSMV LTL counterexample visualizer

[![Build](https://github.com/igor-buzhinsky/nusmv_counterexample_visualizer/actions/workflows/build.yml/badge.svg)](https://github.com/igor-buzhinsky/nusmv_counterexample_visualizer/actions/workflows/build.yml) [![License](https://img.shields.io/github/license/igor-buzhinsky/nusmv_counterexample_visualizer)](LICENSE)

This tool explains why a particular LTL formula fails on a particular trace by means of causal analysis and structured visualization. Below you can see the explanation of the formula's false outcome (middle) and variable values that are important for this outcome (bottom).

<img src="screenshot.png" width="800">

Cite:

* Pakonen A., Buzhinsky I., Vyatkin V. Counterexample visualization and explanation for function block diagrams. 16th IEEE International Conference on Industrial Informatics (INDIN). July 18–20, 2018, Porto, Portugal, pp. 747–753. IEEE, 2018 [[web]](https://ieeexplore.ieee.org/document/8472025) [[preprint]](https://ctlab.itmo.ru/~buzhinsky/papers/indin-2018.pdf)

## Notes on the input format

* The input file to the tool is the output file of NuSMV with LTL formulas and corresponding counterexample traces.
* Bounded operators (e.g., G[0, 3]) in LTL formulas are not supported. You will have to rewrite them manually (e.g., with X).
* Dashes (-) in identifiers are not supported, but $ and # are supported.
* All arithmetic operators supported by NuSMV should work.
* Enumeration types with symbolic values are supported when a symbolic constant is a direct operand of = or != and the other operand is an enumeration variable (e.g., state = idle). Since the tool sees only the trace, not the type declarations, a misspelled constant (e.g., state = idel) cannot be detected and simply compares unequal.
* Supported past-time LTL operators: Y, Z, O, H. Unsupported past-time LTL operators: T, S.
* Since nuXmv counterexamples usually have the same format as NuSMV ones, the tool may be used on nuXmv counterexamples. Real (rational) data type is supported by the tool but timed traces and formulas are not.

## Running

The tool can be run on Windows, Mac OS, Linux. Requires [Java 8 or higher](https://adoptium.net/) to be installed on your system.

Simply run [jars/visualizer-gui.jar](/jars/visualizer-gui.jar). Alternatively, or if this does not work, you can run the tool from the console:

> java -jar jars/visualizer-gui.jar

You can select the input file (for example, [example-input.txt](/example-input.txt)) either in the dialog window or in the command line:

> java -jar jars/visualizer-gui.jar example-input.txt

Font sizes can be configured via command line options --mainFontSize &lt;size&gt; and --auxFontSize &lt;size&gt;.

The colors of the default highlighting mode can be configured via command line options --highlightColor &lt;color&gt;, --trueColor &lt;color&gt;, --falseColor &lt;color&gt;. Another option --highlightChar &lt;char&gt; specifies the character used to highlight important Boolean values.

A purely console version of the tool is also available:

> java -jar jars/visualizer-console.jar


## GUI help

The top panel lists LTL specifications from the input file. Visualization is available only for FALSE specifications. Select a FALSE specification to see the visualization of the counterexample for this specification in the middle panel.

In the middle panel, the values (T = true, F = false) of each subformula of the LTL specification are shown for each step of the counterexample. Click on an annotation below a subformula to see an explanation of its value. As a result, this and some other values will be highlighted. In addition, important atomic propositions are highlighted in the LTL formula.

An additional compact highlighting mode is available which displays subformula values on the same line where the formula is displayed. Explanations also work in this mode.

In the bottom panel, the values of all variables for all counterexample steps are provided. The values which are present in the LTL formula are shown on the left. Important values are highlighted.

Highlighting of important atomic propositions is implemented (with some enhancements) according to the polynomial algorithm from: I. Beer, S. Ben-David, H. Chockler, A. Orni, R. Trefler. Explaining counterexamples using causality. Computer Aided Verification, pp. 94-108, 2009. Springer Berlin/Heidelberg.

## Building

The build uses [Gradle](https://gradle.org/) through the included wrapper, so only JDK 17 or higher is needed (the built jars still run on Java 8):

> ./gradlew build

This generates the LTL parser from the ANTLR grammar ([src/main/antlr](/src/main/antlr)), compiles the code, runs the tests, and builds self-contained jars (visualizer-console.jar and visualizer-gui.jar) in build/libs. To update the downloadable jars in [jars/](/jars), run `./gradlew updateJars`. On Windows, use `gradlew.bat` instead of `./gradlew`.

## Testing

> ./gradlew test

The test suite (JUnit 5, in [src/test](/src/test)) consists of:

* **Snapshot tests**: the console tool runs on the example inputs with different options, and the output is compared with the recorded files in [src/test/resources/golden](/src/test/resources/golden). Any change in formula evaluation, causality analysis or rendering shows up as a diff. After an intended change, re-record them with `./gradlew updateGolden` and review the diff. Snapshots of removed inputs or options are not deleted automatically.
* **Model checker verdicts**: for every specification in the example inputs, the truth value computed by the tool must agree with the verdict printed by NuSMV/nuXmv.
* **Semantics tests**: the truth values of LTL formulas (future and past operators, precedence, arithmetic, reals, enumeration types) on small hand-written lasso traces.
* **Causality tests**: which variable values are reported as the causes of a formula's value.
* **Unit tests** for rational arithmetic.

## Extended input format & educational use of the tool

The tool supports the extension of the NuSMV output format, namely:

* Traces on which the LTL formula is TRUE are supported (the TRUE value of the formula will be explained). In this case, "is false" in the end can be replaced with "is true". Moreover, there is no need to write "is false" or "is true" at all, the value will be determined automatically.
* When NuSMV outputs LTL formulas, it puts redundant parentheses. In the input to the tool, they can be omitted. In this case, precedence of binary operators is U/V, &, |/xor/xnor, <->, -> (-> associates to the right). This complies with how NuSMV operates.
* LTL operator Release can be specified as V (NuSMV expresses this operator via Until).
* State numbers in traces can be omitted, i.e. "&nbsp;&nbsp;&nbsp;&nbsp;-> <-" would specify the start of the new trace element.
* No lines to start the trace (such as "-- as demonstrated by the following execution sequence") are required.

These extensions simplify the use of the tool when the input is produced manually (not by NuSMV). In particular, this can be useful to learn/teach LTL semantics.

## Bugs

If you see an error or something strange, you can open an issue here or email Igor Buzhinsky (igor.buzhinsky@gmail.com).