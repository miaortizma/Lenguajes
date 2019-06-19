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

PLUS : '+' ;
MINUS : '-' ;
TIMES : '*' ;
DIVISION : '/' ;
MOD : '%' ;
POWER : '^' ;

NOT_EQUAL : '<>' ;
EQUAL : '==' ;
GREATER_EQUAL : '>=' ;
GREATER : '>' ;
LESS_EQUAL : '<=';
LESS : '<';

ASSIGN : '=' ;
SEMICOLON : ';';
DOUBLE_POINT : ':';
POINT : '.';
COMMA : ',';
LEFT_PAR : '(';
RIGHT_PAR : ')';
LEFT_BRACE : '[';
RIGHT_BRACE : ']';
LEFT_BRACKET : '{';
RIGHT_BRACKET : '}';

ID : [A-Za-zñÑ_][0-9A-Za-zñÑ_]*;

// Ignore
SPACES : [ \t\r\n]+ -> skip ;

COMMENT : (MULTILINE_COMMENT | SINGLE_LINE_COMMENT) -> skip ;

fragment
MULTILINE_COMMENT: '/*' .*? '*/' ;

fragment
SINGLE_LINE_COMMENT: '//' ~[\n]*;

mode STR1;

STRING : '"' -> popMode ;
TEXT : ~[\n] -> more ;

mode LIT1;

LITERAL : '\'' -> popMode ;
TEXT_LIT : . -> more ;