grammar ltl;

options {
  language = Java;
}

@header {
import nusmv_counterexample_visualizer.formula.*;
}

@parser::members {
}

equivalent : ('<->' | '=' | 'xnor');

xor : ('xor' | '!=');

eq : '=';

ne : '!=';

unary_operator_sign returns[String value]
    : NOT { $value = "!"; }
    | NEXT { $value = "X"; }
    | GLOBALLY { $value = "G"; }
    | FUTURE { $value = "F"; }
    ;

binary_operator_sign returns[String value]
    : AND { $value = "&"; }
    | OR { $value = "|"; }
    | IMPLIES { $value = "->"; }
    | equivalent { $value = "<->"; }
    | UNTIL { $value = "U"; }
    | RELEASE { $value = "V"; }
    | xor { $value = "xor"; }
    ;

comparison_operator_sign returns[String value]
    : eq { $value = "="; }
    | ne { $value = "!="; }
    | GT { $value = ">"; }
    | GE { $value = ">="; }
    | LT { $value = "<"; }
    | LE { $value = "<="; }
    ;

constant returns[String value]
    : INT_CONST { $value = $INT_CONST.text; }
    | TRUE { $value = "TRUE"; }
    | FALSE  { $value = "FALSE"; }
    ;

composite_id
    : ID ('.' ID)* ('[' INT_CONST']')?
    ;

proposition returns[LTLFormula f]
    : TRUE { $f = new TrueFormula(); }
    | FALSE { $f = new FalseFormula(); }
    | ({ String c = "TRUE"; String op = "="; }
      composite_id (comparison_operator_sign constant { op = $comparison_operator_sign.value; c = $constant.value; })?
      { $f = new Proposition($composite_id.text, op, c); })
    ;

atom returns[LTLFormula f]
    : proposition { $f = $proposition.f; }
    | '(' formula ')' { $f = $formula.f; }
    ;

unary_operator returns[LTLFormula f]
    : atom { $f = $atom.f; }
    | unary_operator_sign unary_operator { $f = new UnaryOperator($unary_operator_sign.value, $unary_operator.f); }
    ;

binary_operator returns[LTLFormula f]
    : f1=unary_operator { $f = $f1.f; } (binary_operator_sign f2=unary_operator
      { $f = new BinaryOperator($binary_operator_sign.value, $f, $f2.f); })?
    ;

formula returns[LTLFormula f]
    : binary_operator { $f = $binary_operator.f; }
    ;

// operator sequences
WS : (' ' | '\t' | ('\r'? '\n'))+ -> channel(HIDDEN);

// temporal operators
GLOBALLY : 'G'; FUTURE : 'F'; UNTIL : 'U'; RELEASE : 'V'; NEXT : 'X';

// Boolean operators
AND : '&'; OR : '|'; IMPLIES : '->'; NOT : '!';

GT : '>'; GE : '>='; LT : '<'; LE : '<=';

// constants
TRUE : 'TRUE'; FALSE : 'FALSE';
INT_CONST : '-'? ('0' | ('1'..'9' ('0'..'9')*));

// ids
ID : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;