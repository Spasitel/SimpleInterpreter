grammar Simple;

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
    : 'map('sequence COMMA unaryLambda ')' ;

unaryLambda
    : VARIABLE_NAME '->' numerical
    ;

reduce
    : 'reduce('sequence COMMA numerical COMMA binaryLambda ')' ;

binaryLambda
    : VARIABLE_NAME VARIABLE_NAME '->' numerical
    ;

numerical
    : (MINUS)? LPAREN numerical RPAREN          #signedNum
    | <assoc=right> numerical POW numerical     #powNum
    | numerical (TIMES | DIV) numerical         #mulNum
    | numerical (PLUS | MINUS) numerical        #plusNum
    | (MINUS)? constant                         #signedNum
    | (MINUS)? reduce                           #signedNum
    | (MINUS)? variable                         #signedNum
    ;

variable
    : VARIABLE_NAME;

constant
    : CONST
    ;

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

CONST
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