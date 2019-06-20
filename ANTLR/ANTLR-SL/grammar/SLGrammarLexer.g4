lexer grammar SLGrammarLexer;

// Reserved words
RESERVED : 'archivo'|'constantes'|'lib'|'libext'|'sin'|'variables';

PROGRAM
    : 'programa';

SUBROUTINE
    : 'subrutina';

RETURNS
    : 'retorna' ;

DATA_TYPE :
    STRING | NUMBER | LOGIC;

STRING
    : 'cadena';

NUMBER
    : 'numerico' ;

LOGIC
    : 'logico';

REF
    : 'ref' ;

START
    : 'inicio' ;

END
    : 'fin' ;

VAR
    : 'var' ;

CONST
    : 'const' ;

VECTOR
    : 'vector' ;

MATRIX
    : 'matriz' ;

RECORD
    : 'registro' ;

IF
    : 'si' ;

ELSE
    : 'sino' ;

WHILE
    : 'mientras' ;

REPEAT
    : 'repetir' ;

UNTIL
    : 'hasta' ;

EVAL
    : 'eval' ;

CASE
    : 'caso' ;

FROM
    : 'desde' ;

STEP
    : 'paso' ;

TYPES
    : 'tipos' ;

PREDEF_BOOL_POS
    : 'TRUE'|'SI' ;

PREDEF_BOOL_NEG
    : 'FALSE'|'NO' ;

NOT
    : 'not';

OR
    : 'or';

AND
    : 'and';

fragment SEQ_ESCAPE
    : [\\][.] ;

fragment VALID_CHAR
    : ~[\\\r\n\f'];

STRING_LITERAL
    : ([']( SEQ_ESCAPE|VALID_CHAR )*[']) | (["]( SEQ_ESCAPE|VALID_CHAR )*["]) ;

fragment DIGIT
    : [0-9] ;

fragment REAL
    : DIGIT+ ( '.' DIGIT+)?;

fragment EXP_NUMBER
    : (REAL) ('E'|'e') [+-]? DIGIT+ ;

INT
    : DIGIT+;


NUMBER_LITERAL : INT|REAL|EXP_NUMBER;

fragment LETTER
    : [A-Za-zñÑ];
ID : (LETTER|[_])(LETTER|DIGIT|[_])*;

PLUS
    : '+' ;

MINUS
    : '-' ;

TIMES
    : '*' ;

DIVISION
    : '/' ;

MOD
    : '%' ;

POWER
    : '^' ;

NOT_EQUAL
    : '<>' ;

EQUAL
    : '==' ;

GREATER_EQUAL
    : '>=' ;

GREATER
    : '>' ;

LESS_EQUAL
    : '<=';

LESS
    : '<';

ASSIGN
    : '=' ;

SEMI
    : ';';

DOUBLE_POINT
    : ':';

POINT
    : '.';

COMMA
    : ',';

LEFT_PAR
    : '(';

RIGHT_PAR
    : ')';

LEFT_BRACE
    : '[';

RIGHT_BRACE
    : ']';

LEFT_BRACKET
    : '{';

RIGHT_BRACKET
    : '}';

// Ignore
SPACES : [ \t\r\n]+ -> skip ;

BLOCK_COMMENT: '/*' .*? '*/'  -> skip;

COMMENT: '//' ~[\r\n]* -> skip;

ANY :
    . ;