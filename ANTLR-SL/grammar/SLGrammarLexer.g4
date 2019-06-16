lexer grammar SLGrammarLexer;

// Reserved words
RESERVED : 'archivo'|'constantes'|'lib'|'libext'|'sin'|'variables';

PROGRAM : 'programa';
SUBROUTINE : 'subrutina';
RETURNS : 'retorna' ;
DATA_TYPE : TYPE_STRING | TYPE_NUMBER | TYPE_LOGIC;
TYPE_STRING : 'cadena';
TYPE_NUMBER : 'numerico' ;
TYPE_LOGIC : 'logico';
REF : 'ref' ;
START : 'inicio' ;
END : 'fin' ;
VAR : 'var' ;
CONST : 'const' ;
VECTOR : 'vector' ;
MATRIX : 'matriz' ;
RECORD : 'registro' ;
IF : 'si' ;
ELSE : 'sino' ;
WHILE : 'mientras' ;
REPEAT : 'repetir' ;
UNTIL : 'hasta' ;
EVAL : 'eval' ;
CASE : 'caso' ;
FROM : 'desde' ;
STEP : 'paso' ;
TYPES : 'tipos' ;

PREDEF_CONST_POS : 'TRUE'|'SI' ;
PREDEF_CONST_NEG : 'FALSE'|'NO' ;

NOT : 'not';
OR : 'or';
AND : 'and';

// Main tokens
INT_NUMBER : DIGIT+ ;
REAL_NUMBER : INT_NUMBER '.' DIGIT+;
EXP_NUMBER : (INT_NUMBER|REAL_NUMBER) ('E'|'e') [+-]? DIGIT+;

fragment
DIGIT : [0-9];

START_STR : ('"') -> more, pushMode(STR1) ;
START_LIT : ('\'') -> more, pushMode(LIT1) ;

CHAR : '\'' . '\'';

TK_PLUS : '+' ;
TK_MINUS : '-' ;
TK_TIMES : '*' ;
TK_DIVISION : '/' ;
TK_MOD : '%' ;
TK_POWER : '^' ;

TK_NOT_EQUAL : '<>' ;
TK_EQUAL : '==' ;
TK_GREATER_EQUAL : '>=' ;
TK_GREATER : '>' ;
TK_LESS_EQUAL : '<=';
TK_LESS : '<';

TK_ASSIGN : '=' ;
TK_SEMICOLON : ';';
TK_DOUBLE_POINT : ':';
TK_POINT : '.';
TK_COMMA : ',';
TK_LEFT_PAR : '(';
TK_RIGHT_PAR : ')';
TK_LEFT_BRACE : '[';
TK_RIGHT_BRACE : ']';
TK_LEFT_BRACKET : '{';
TK_RIGHT_BRACKET : '}';

ID : [A-Za-zñÑ_][0-9A-Za-zñÑ_]*;

// Ignore
SPACES : [ \t\r\n]+ -> skip ;

COMMENT : (MULTILINE_COMMENT | SINGLE_LINE_COMMENT) -> skip ;

fragment
MULTILINE_COMMENT: '/*' .*? '*/' ;

fragment
SINGLE_LINE_COMMENT: '//' ~[\n]*;

mode STR1;

TK_STRING : '"' -> popMode ;
TEXT : ~[\n] -> more ;

mode LIT1;

LITERAL : '\'' -> popMode ;
TEXT_LIT : . -> more ;