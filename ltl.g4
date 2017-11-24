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

// operator sequences
WS : (' ' | '\t' | ('\r'? '\n'))+ -> channel(HIDDEN);

// LTL operators
GLOBALLY : 'G'; FUTURE : 'F'; UNTIL : 'U'; RELEASE : 'V'; NEXT : 'X';
// past-time LTL operators
PREV_Y : 'Y'; PREV_Z : 'Z'; ONCE : 'O'; HISTORICALLY : 'H';

// Boolean operators
AND : '&'; OR : '|'; IMPLIES : '->'; NOT : '!';

GT : '>'; GE : '>='; LT : '<'; LE : '<=';

// constants
TRUE : 'TRUE'; FALSE : 'FALSE';
INT_CONST : '-'? ('0' | ('1'..'9' ('0'..'9')*));

// arithmetic operators
plus : '+'; minus : '-'; DIV : '/'; MOD : 'mod'; MUL : '*';

// ids
ID : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

equivalent : ('<->' | '=' | 'xnor');

xor : ('xor' | '!=');

eq : '=';

ne : '!=';

composite_id
    : ID ('.' ID)* ('[' INT_CONST ']')*
    ;

constant returns[String value]
    : INT_CONST { $value = $INT_CONST.text; }
    | TRUE { $value = "TRUE"; } | FALSE  { $value = "FALSE"; }
    ;

unary_operator_sign returns[String value]
    : NOT { $value = "!"; }
    | NEXT { $value = "X"; }
    | GLOBALLY { $value = "G"; } | FUTURE { $value = "F"; }
    | PREV_Y { $value = "Y"; } | PREV_Z { $value = "Z"; }
    | ONCE { $value = "O"; } | HISTORICALLY { $value = "H"; }
    ;

binary_operator_sign returns[String value]
    : AND { $value = "&"; } | OR { $value = "|"; } | IMPLIES { $value = "->"; }
    | equivalent { $value = "<->"; }
    | UNTIL { $value = "U"; } | RELEASE { $value = "V"; }
    | xor { $value = "xor"; }
    ;

comparison_operator_sign returns[String value]
    : eq { $value = "="; } | ne { $value = "!="; }
    | GT { $value = ">"; } | GE { $value = ">="; } | LT { $value = "<"; } | LE { $value = "<="; }
    ;

arithmetic_atom returns[ArithmeticExpression f]
    : constant { $f = new Constant($constant.value); }
    | composite_id { $f = new Variable($composite_id.text); }
    | '(' comparison_expression ')' { $f = $comparison_expression.f; }
    ;

arithmetic_expression3 returns[ArithmeticExpression f]
    : arithmetic_atom { $f = $arithmetic_atom.f; }
    | { String op; } (minus { op = "-"; } | plus { op = "+"; } /*| NOT { op = "!"; }*/ ) arithmetic_expression3
      { $f = new UnaryArithmeticOperator(op, $arithmetic_expression3.f); }
    ;

arithmetic_expression2 returns[ArithmeticExpression f]
    : f1=arithmetic_expression3 { $f = $f1.f; String op; }
        ((MUL { op = "*"; } | DIV { op = "/"; } | MOD { op = "mod"; })
      f2=arithmetic_expression3 { $f = new BinaryArithmeticOperator(op, $f, $f2.f); })*
    ;

arithmetic_expression1 returns[ArithmeticExpression f]
    : f1=arithmetic_expression2 { $f = $f1.f; String op; }
        ((plus { op = "+"; } | minus { op = "-"; })
      f2=arithmetic_expression2 { $f = new BinaryArithmeticOperator(op, $f, $f2.f); })*
    ;

comparison_expression returns[ArithmeticExpression f]
    : f1=arithmetic_expression1 { $f = $f1.f; String op; }
        (comparison_operator_sign f2=arithmetic_expression1
        { $f = new ComparisonOperator($comparison_operator_sign.value, $f, $f2.f); })?
    ;

/*and_arithmetic_expression returns[ArithmeticExpression f]
    : f1=comparison_expression { $f = $f1.f; } (AND f2=comparison_expression
        { $f = new BinaryArithmeticOperator("&", $f, $f2.f); })?
    ;

or_arithmetic_expression returns[ArithmeticExpression f]
    : f1=and_arithmetic_expression { $f = $f1.f; String op; }
        ((OR { op = "|"; } | 'xor' { op = "xor"; } | 'xnor' { op = "<->"; })
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
    ;*/

atom returns[LTLFormula f]
    : '(' formula ')' { $f = $formula.f; }
    | comparison_expression { $f = new Proposition($comparison_expression.f); }
    ;

unary_operator returns[LTLFormula f]
    : atom { $f = $atom.f; }
    | unary_operator_sign unary_operator { $f = new UnaryOperator($unary_operator_sign.value, $unary_operator.f); }
    ;

binary_operator returns[LTLFormula f]
    : f1=unary_operator { $f = $f1.f; } (binary_operator_sign f2=unary_operator
      { $f = new BinaryOperator($binary_operator_sign.value, $f, $f2.f); })?
    ;

/*binary_operator returns[LTLFormula f]
      : f1=unary_operator binary_operator_sign f2=unary_operator
        { $f = new BinaryOperator($binary_operator_sign.value, $f1.f, $f2.f); }
      | f3=unary_operator { $f = $f3.f; }
      ;*/

formula returns[LTLFormula f]
    : binary_operator { $f = $binary_operator.f; }
    ;
