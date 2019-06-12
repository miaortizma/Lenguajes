lexer grammar SLLexer;

WHITESPACE
    : [ \r\t]+ -> skip;

COMMENT
    : '//' ~ [\r\n]* -> skip;

BLOCK_COMMENT
    : '/*' .*? '*/' -> skip;

NEWLINE
    : ('\r' '\n'? | '\n');

// Keywords

IF
    : 'if';
THEN
    : 'then';
ELSE
    : 'else';
ENDIF
    : 'endif';

LOGICO_LITERAL
    : ('SI' | 'NO' | 'YES' | 'FALSE' | 'true' | 'false');

NUMERICO_LITERAL
    : [0-9]+( | [.][0-9]+)*;

SEQ_ESCAPE
    : [\\][.] ;

CADENA_LITERAL
    : [']( SEQ_ESCAPE | ~[\\\r\n\f'])*['] | ["]( SEQ_ESCAPE | ~[\\\r\n\f"])*["];

// Tokens

PLUS
    : '+';

MINUS
    : '-';

ASTERISK
    : '*';

DIVISION
    : '/';

POWER
    : '^';

MOD
    : '%';

SEMICOLON
    : ';';

DOUBLE_POINT
    : ':';

BOOL_OP
    : ( '<' | '<=' | '>=' | '>' | '==' | '<>' );

ASSIGN
    : '=';

POINT
    : '.';

COMMA
    : ',';

LEFT_PAR
    : '(';

RIGHT_PAR
    : ')';

LEFT_BRACE
    : '{';

RIGHT_BRACE
    : '}';

LEFT_BRACKET
    : '[';

RIGHT_BRACET
    : ']';


CONST
    : 'const';

TIPOS
    : 'tipos';

VAR
    : 'var';


ID : [a-zA-ZñÑ_][0-9a-zA-ZñÑ_]+;


NUMERICO
    : 'numerico';

CADENA
    : 'cadena';

LOGICO
    : 'logico';