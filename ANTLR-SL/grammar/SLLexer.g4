lexer grammar SLLexer;

WHITESPACE
    : [ \t\n] -> skip;

COMMENT
    : '//' ~ [\r\n]* -> skip;

BLOCK_COMMENT
    : '/*' .*? '*/' -> skip;

NEW_LINE
    : '\r'? '\n';

// Keywords

PROGRAMA
    : 'programa';

CONST
    : 'const';

TIPOS
    : 'tipos';

VAR
    : 'var';

NUMERICO
    : 'numerico';

CADENA
    : 'cadena';

LOGICO
    : 'logico';

SUBRUTINA
    : 'subrutina';

INICIO
    : 'inicio';

REF
    : 'ref';

FIN
    : 'fin';

IF
    : 'if';

THEN
    : 'then';

ELSE
    : 'else';

ENDIF
    : 'endif';

RETORNA
    : 'retorna';

LOGICO_LITERAL
    : ('SI' | 'NO' | 'TRUE' | 'FALSE' );

REGISTRO
    : 'registro';

TENSOR
    : 'tensor';

SENTENCIAS
    : 'sentencias';


fragment DIGIT
    : [0-9];

fragment LETTER
    : [a-zA-ZñÑ];

ID
    : (LETTER|[_]) (LETTER|DIGIT|[_])*;

NUMERICO_LITERAL
    : DIGIT+([.] DIGIT+)?;

fragment SEQ_ESCAPE
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

SEMI
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

ANY
    : .;