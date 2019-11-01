grammar Simple;

program
    : stmt+ EOF
    ;

stmt
    : var
    | out
    | print
    ;

var
    : 'var' def=VARIABLE_NAME EQ toCopy=VARIABLE_NAME   #varToVar
    | 'var' def=VARIABLE_NAME EQ numerical              #numToVar
    | 'var' def=VARIABLE_NAME EQ sequence               #seqToVar
    ;

out
    : 'out' numerical
    ;

print
    : 'print' STRING
    ;

STRING
    : '"'  ~["]* '"'
    ;

sequence
    : sequenceDef
    | map
    | variable
    ;

sequenceDef
    : '{' start=numerical ',' finish=numerical '}'
    ;

map
    : 'map('sequence ',' VARIABLE_NAME '->' numerical ')'
    ;

reduce
    : 'reduce('sequence ',' init=numerical ',' first=VARIABLE_NAME second=VARIABLE_NAME '->' lambda=numerical ')'
    ;

numerical
    : (sign=MINUS)? '(' parentheses=numerical ')'           #signedNum
    | <assoc=right> left=numerical op=POW right=numerical   #opNum
    | left=numerical op=(TIMES | DIV) right=numerical       #opNum
    | left=numerical op=(PLUS | MINUS) right=numerical      #opNum
    | (sign=MINUS)? reduceResult=reduce                     #signedNum
    | (sign=MINUS)? numVar=variable                         #signedNum
    | (sign=MINUS)? constant=CONST                          #signedNum
    ;

variable
    : VARIABLE_NAME
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