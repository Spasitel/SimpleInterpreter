grammar Simple;

program
    : commands=stmt+ EOF
    ;

stmt
    : 'var' to=IDENTIFIER '=' from=expr #varStmt
    | 'out' arg=expr                    #outStmt
    | 'print' STRING                    #printStmt
    ;

expr
    : <assoc=right> left=expr op='^' right=expr         #opExpression
    | left=expr op=('*'|'/') right=expr                 #opExpression
    | left=expr op=('+'|'-') right=expr                 #opExpression
    | '(' arg=expr ')'                                  #parentheses
    | IDENTIFIER                                        #variable
    | '{' start=expr ',' end=expr '}'                   #sequenceDef
    | NUMBER                                            #constant
    | 'map(' arg=expr ',' param=IDENTIFIER '->' lambda=expr ')'                                             #map
    | 'reduce(' arg=expr ',' start=expr',' firstParam=IDENTIFIER secondParam=IDENTIFIER '->' lambda=expr')' #reduce
    ;

STRING
    : '"' ~["]* '"'
    ;

NUMBER
    : ('-')?('0' .. '9') + ('.' ('0' .. '9') +)?
    ;
IDENTIFIER
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