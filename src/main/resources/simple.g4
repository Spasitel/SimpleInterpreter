grammar simple;

program
    : stmt+ EOF ;

stmt
    : var
    | out
    | print;

var
    : 'var' VARIABLE_NAME EQ expr ;

out
    : 'out' numerical ;

print
    : 'print' STRING;

STRING
    : '"'  ~["]* '"';

expr
    : numerical
    | sequence;

sequence
    : sequence_def
    | map
    | variable;

sequence_def
    : '{' numerical COMMA numerical '}' ;

map
    : 'map('sequence COMMA VARIABLE_NAME '->' numerical ')' ;

reduce
    : 'reduce('sequence COMMA numerical COMMA VARIABLE_NAME VARIABLE_NAME '->' numerical ')' ;

numerical
   : multiplyingExpression ((PLUS | MINUS) multiplyingExpression)*
   ;

multiplyingExpression
   : powExpression ((TIMES | DIV) powExpression)*
   ;

powExpression
   : signedAtom (POW signedAtom)*
   ;

signedAtom
   : MINUS atom
   | atom
   ;

atom
   : variable
   | CONSTANT
   | reduce
   | LPAREN numerical RPAREN
   ;

variable
    : VARIABLE_NAME;

LPAREN
   : '('
   ;


RPAREN
   : ')'
   ;

PLUS
   : '+'
   ;


MINUS
   : '-'
   ;


TIMES
   : '*'
   ;


DIV
   : '/'
   ;

EQ
   : '='
   ;


COMMA
   : ','
   ;


POINT
   : '.'
   ;


POW
   : '^'
   ;

CONSTANT
   : ('0' .. '9') + ('.' ('0' .. '9') +)?
   ;

VARIABLE_NAME
   : VALID_ID_START VALID_ID_CHAR*
   ;


fragment VALID_ID_START
   : ('a' .. 'z') | ('A' .. 'Z') | '_'
   ;

fragment VALID_ID_CHAR
   : VALID_ID_START | ('0' .. '9')
   ;

WS
   : [ \r\n\t] + -> skip
   ;