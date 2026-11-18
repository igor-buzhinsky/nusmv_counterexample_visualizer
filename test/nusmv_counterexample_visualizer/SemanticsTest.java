package nusmv_counterexample_visualizer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Checks the computed truth value of LTL formulas on small hand-written lasso traces.
 * Columns: formula :: trace (see {@link TraceBuilder}) :: expected value.
 */
class SemanticsTest {
    private static void check(String formula, String trace, String expected) {
        assertEquals(expected, TraceBuilder.evaluate(formula, trace).formulaValue(),
                () -> formula + " on " + trace);
    }

    @DisplayName("future-time operators")
    @ParameterizedTest(name = "{0} on [{1}] is {2}")
    @CsvSource(delimiterString = "::", value = {
            // p holds, fails once, then holds forever
            "G p          :: p=TRUE; p=FALSE; >p=TRUE :: FALSE",
            "F p          :: p=TRUE; p=FALSE; >p=TRUE :: TRUE",
            "X p          :: p=TRUE; p=FALSE; >p=TRUE :: FALSE",
            "X X p        :: p=TRUE; p=FALSE; >p=TRUE :: TRUE",
            "F G p        :: p=TRUE; p=FALSE; >p=TRUE :: TRUE",
            "G F !p       :: p=TRUE; p=FALSE; >p=TRUE :: FALSE",
            "p U !p       :: p=TRUE; p=FALSE; >p=TRUE :: TRUE",
            // p alternates forever inside the loop, q never holds
            "G F p        :: p=TRUE q=FALSE; >p=FALSE; p=TRUE :: TRUE",
            "G F !p       :: p=TRUE q=FALSE; >p=FALSE; p=TRUE :: TRUE",
            "F G p        :: p=TRUE q=FALSE; >p=FALSE; p=TRUE :: FALSE",
            "F q          :: p=TRUE q=FALSE; >p=FALSE; p=TRUE :: FALSE",
            "p U q        :: p=TRUE q=FALSE; >p=FALSE; p=TRUE :: FALSE",
            "q V p        :: p=TRUE q=FALSE; >p=FALSE; p=TRUE :: FALSE",
            "q V !q       :: p=TRUE q=FALSE; >p=FALSE; p=TRUE :: TRUE",
            "G (p -> X !p) :: p=TRUE q=FALSE; >p=FALSE; p=TRUE :: TRUE",
            // U is strong (q must eventually hold), V is its weak dual
            "p U q        :: >p=TRUE q=FALSE :: FALSE",
            "q V p        :: >p=TRUE q=FALSE :: TRUE",
            // the loop jumps back to the very first state
            "G (p -> X !p) :: >p=TRUE; p=FALSE; p=TRUE :: FALSE",
    })
    void futureOperators(String formula, String trace, String expected) {
        check(formula, trace, expected);
    }

    @DisplayName("past-time operators")
    @ParameterizedTest(name = "{0} on [{1}] is {2}")
    @CsvSource(delimiterString = "::", value = {
            "G (y -> O x) :: x=FALSE y=FALSE; x=TRUE; >x=FALSE y=TRUE :: TRUE",
            "G (y -> Y x) :: x=FALSE y=FALSE; x=TRUE; >x=FALSE y=TRUE :: FALSE",
            "G (y -> H !x) :: x=FALSE y=FALSE; x=TRUE; >x=FALSE y=TRUE :: FALSE",
            "F (y & Y x)  :: x=FALSE y=FALSE; x=TRUE; >x=FALSE y=TRUE :: TRUE",
            // at the initial state, Y (strong yesterday) is false and Z (weak yesterday) is true
            "Y TRUE       :: >x=FALSE :: FALSE",
            "Z FALSE      :: >x=FALSE :: TRUE",
            "X Y x        :: x=TRUE; >x=FALSE :: TRUE",
            "G H x        :: x=TRUE; >x=FALSE :: FALSE",
    })
    void pastOperators(String formula, String trace, String expected) {
        check(formula, trace, expected);
    }

    @DisplayName("operator precedence and associativity")
    @ParameterizedTest(name = "{0} on [{1}] is {2}")
    @CsvSource(delimiterString = "::", value = {
            // & binds tighter than |: p | (q & r)
            "p | q & r    :: >p=TRUE q=FALSE r=FALSE :: TRUE",
            // -> is right-associative: p -> (q -> r)
            "p -> q -> r  :: >p=FALSE q=TRUE r=FALSE :: TRUE",
            // U binds tighter than &: (p U q) & r
            "p U q & r    :: p=TRUE q=FALSE r=FALSE; >p=FALSE q=TRUE r=TRUE :: FALSE",
            // unary operators bind tighter than binary ones: (!p) U q
            "!p U q       :: >p=FALSE q=TRUE :: TRUE",
            "p xor q      :: >p=TRUE q=TRUE :: FALSE",
            "p xnor q     :: >p=TRUE q=TRUE :: TRUE",
            "p <-> q      :: >p=FALSE q=FALSE :: TRUE",
    })
    void precedence(String formula, String trace, String expected) {
        check(formula, trace, expected);
    }

    @DisplayName("arithmetic and data types")
    @ParameterizedTest(name = "{0} on [{1}] is {2}")
    @CsvSource(delimiterString = "::", value = {
            "u + 2 * 3 = 7          :: >u=1 :: TRUE",
            "u mod 3 = 1            :: >u=4 :: TRUE",
            "-u < 0                 :: >u=1 :: TRUE",
            "G u < 3                :: u=1; u=2; >u=3 :: FALSE",
            "count(a, b, c) = 2     :: >a=TRUE b=FALSE c=TRUE :: TRUE",
            "m.v[1] = 2             :: >m.v[1]=2 :: TRUE",
            "s$1 = s#2              :: >s$1=5 s#2=5 :: TRUE",
            "x * 2 = 1              :: >x=0.5 :: TRUE",
            "x = f'1/2              :: >x=0.5 :: TRUE",
            "x > 1.3e-2             :: >x=f'1/50 :: TRUE",
    })
    void arithmetic(String formula, String trace, String expected) {
        check(formula, trace, expected);
    }

    @DisplayName("symbolic (enum) values")
    @ParameterizedTest(name = "{0} on [{1}] is {2}")
    @CsvSource(delimiterString = "::", value = {
            "state = idle              :: >state=idle :: TRUE",
            "idle = state              :: >state=idle :: TRUE",
            "state != busy             :: >state=idle :: TRUE",
            "G state = idle            :: state=idle; >state=busy :: FALSE",
            "G F state = busy          :: state=idle; >state=busy; state=idle :: TRUE",
            "state = idle U done       :: state=idle done=FALSE; >state=busy done=TRUE :: TRUE",
            "state = prev_state        :: >state=idle prev_state=idle :: TRUE",
            // an "e" in a symbol must not make it look like a decimal number
            "mode = e1                 :: >mode=e1 :: TRUE",
            // mixed enumerations of integers and symbols
            "level = 3                 :: level=3; >level=low :: TRUE",
            "level = low               :: level=3; >level=low :: FALSE",
            "F level = low             :: level=3; >level=low :: TRUE",
            // a constant that never occurs in the trace
            "G state != error          :: state=idle; >state=busy :: TRUE",
    })
    void symbolicValues(String formula, String trace, String expected) {
        check(formula, trace, expected);
    }

    @DisplayName("misspelled variables are reported, not taken for symbolic constants")
    @ParameterizedTest(name = "{0} on [{1}] reports {2}")
    @CsvSource(delimiterString = "::", value = {
            "stat = 1      :: >state=1 :: stat",
            "x = y_typo    :: x=1; >x=2 y=1 :: y_typo",
            "p = q_typo    :: >p=TRUE q=TRUE :: q_typo",
            "p != q_typo   :: >p=FALSE q=TRUE :: q_typo",
    })
    void misspelledVariableIsReported(String formula, String trace, String missing) {
        final RuntimeException e = assertThrows(RuntimeException.class,
                () -> TraceBuilder.evaluate(formula, trace));
        assertTrue(e.getMessage().contains("Missing variable name: " + missing), e.getMessage());
    }

    @Test
    void symbolicValuesCannotBeOrdered() {
        assertThrows(RuntimeException.class, () -> TraceBuilder.evaluate("state < busy", ">state=idle"));
    }

    @DisplayName("input format conventions")
    @ParameterizedTest(name = "{0} on [{1}] is {2}")
    @CsvSource(delimiterString = "::", value = {
            // a variable not listed in a state keeps its previous value
            "G p          :: p=TRUE; >q=TRUE :: TRUE",
            // a finite trace (no loop marker) loops its last state
            "F G p        :: p=FALSE; p=TRUE :: TRUE",
            // NuSMV's trailing verdict is accepted, but the computed value is reported
            "G p is false :: >p=TRUE :: TRUE",
            "F p is true  :: >p=FALSE :: FALSE",
    })
    void inputFormat(String formula, String trace, String expected) {
        check(formula, trace, expected);
    }
}
