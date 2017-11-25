grammar ltl;

options {
  language = Java;
}

@header {
import nusmv_counterexample_visualizer.formula.ltl.*;
import nusmv_counterexample_visualizer.formula.arithmetic.*;
}

@parser::members {
}

WS : (' ' | '\t' | ('\r'? '\n'))+ -> channel(HIDDEN);

INT_CONST : '-'? ('0' | ('1'..'9' ('0'..'9')*));

ID : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

constant
    : INT_CONST | 'TRUE' | 'FALSE'
    ;

composite_id
    : ID ('.' ID)* ('[' INT_CONST ']')*
    ;

unary_operator_sign
    : '!' | 'X' | 'G' | 'F' | 'Y' | 'Z' | 'O' | 'H'
    ;

binary_operator_sign
    : '&' | '|' | '->' | '<->' | 'xnor' | 'xor' | 'U' | 'V'
    ;

comparison_operator_sign
    : '=' | '!=' | '>' | '>=' | '<' | '<='
    ;

////////////////////

arithmetic_atomic_value returns[ArithmeticExpression f]
    : constant { $f = new Constant($constant.text); }
    | composite_id { $f = new Variable($composite_id.text); }
    ;

arithmetic_atom returns[ArithmeticExpression f]
    : arithmetic_atomic_value { $f = $arithmetic_atomic_value.f; }
    | '(' implies_arithmetic_expression ')' { $f = $implies_arithmetic_expression.f; }
    ;

arithmetic_expression3 returns[ArithmeticExpression f]
    : arithmetic_atom { $f = $arithmetic_atom.f; }
    | { String op; } ('-' { op = "-"; } | '+' { op = "+"; } | '!' { op = "!"; }) arithmetic_expression3
      { $f = new UnaryArithmeticOperator(op, $arithmetic_expression3.f); }
    ;

arithmetic_expression2 returns[ArithmeticExpression f]
    : f1=arithmetic_expression3 { $f = $f1.f; String op; }
        (('*' { op = "*"; } | '/' { op = "/"; } | 'mod' { op = "mod"; })
      f2=arithmetic_expression3 { $f = new BinaryArithmeticOperator(op, $f, $f2.f); })*
    ;

arithmetic_expression1 returns[ArithmeticExpression f]
    : f1=arithmetic_expression2 { $f = $f1.f; String op; } (('+' { op = "+"; } | '-' { op = "-"; })
      f2=arithmetic_expression2 { $f = new BinaryArithmeticOperator(op, $f, $f2.f); })*
    ;

comparison_expression returns[ArithmeticExpression f]
    : f1=arithmetic_expression1 { $f = $f1.f; } (comparison_operator_sign f2=arithmetic_expression1
        { $f = new ComparisonOperator($comparison_operator_sign.text, $f, $f2.f); })?
    ;

////////////////////

and_arithmetic_expression returns[ArithmeticExpression f]
    : f1=comparison_expression { $f = $f1.f; } ('&' f2=comparison_expression
        { $f = new BinaryArithmeticOperator("&", $f, $f2.f); })?
    ;

or_arithmetic_expression returns[ArithmeticExpression f]
    : f1=and_arithmetic_expression { $f = $f1.f; String op; }
        (('|' { op = "|"; } | 'xor' { op = "xor"; } | 'xnor' { op = "xnor"; })
        f2=and_arithmetic_expression { $f = new BinaryArithmeticOperator(op, $f, $f2.f); })?
    ;

ternary_arithmetic_expression returns[ArithmeticExpression f]
    : f1=or_arithmetic_expression { $f = $f1.f; } ('?' f2=or_arithmetic_expression ':' f3=or_arithmetic_expression
      { $f = new TernaryArithmeticOperator($f1.f, $f2.f, $f3.f); })?
    ;

eq_arithmetic_expression returns[ArithmeticExpression f]
    : f1=ternary_arithmetic_expression { $f = $f1.f; } ('<->' f2=ternary_arithmetic_expression
        { $f = new BinaryArithmeticOperator("<->", $f, $f2.f); })?
    ;

implies_arithmetic_expression returns[ArithmeticExpression f]
    : f1=eq_arithmetic_expression { $f = $f1.f; } ('->' f2=implies_arithmetic_expression
        { $f = new BinaryArithmeticOperator("->", $f, $f2.f); })?
    ;

////////////////////

proposition returns[ArithmeticExpression f]
    : f1=arithmetic_expression1 comparison_operator_sign f2=arithmetic_expression1
        { $f = new ComparisonOperator($comparison_operator_sign.text, $f1.f, $f2.f); }
    | o1=or_arithmetic_expression '?' o2=or_arithmetic_expression ':' o3=or_arithmetic_expression
        { $f = new TernaryArithmeticOperator($o1.f, $o2.f, $o3.f); }
    | arithmetic_atomic_value { $f = $arithmetic_atomic_value.f; }
    ;

atom returns[LTLFormula f]
    : '(' formula ')' { $f = $formula.f; }
    | proposition { $f = new Proposition($proposition.f); }
    ;

unary_operator returns[LTLFormula f]
    : atom { $f = $atom.f; }
    | unary_operator_sign unary_operator { $f = new UnaryOperator($unary_operator_sign.text, $unary_operator.f); }
    ;

binary_operator returns[LTLFormula f]
    : f1=unary_operator { $f = $f1.f; } (binary_operator_sign f2=unary_operator
      { $f = new BinaryOperator($binary_operator_sign.text, $f, $f2.f); })?
    ;

formula returns[LTLFormula f]
    : binary_operator { $f = $binary_operator.f; }
    ;
