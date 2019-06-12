lexer grammar SLLexer;


// Tokens

PLUS : '+';
MINUS : '-';
ASTERISK : '*';
DIVISION : '/';
POWER : '^';
MOD : '%';
SEMICOLON : ';';
DOUBLE_POINT : ':';
LESS : '<';
LESS_EQUAL : '<=';
GREATER : '>';
GREATER_EQUAL : '>=';
EQUAL : '==';
NOT_EQUAL : '<>';
ASSIGN : '=';
POINT : '.';
COMMA : ',';
LEFT_PAR : '(';
RIGHT_PAR : ')';
LEFT_BRACE : '{';
RIGHT_BRACE : '}';
LEFT_BRACKET : '[';
RIGHT_BRACET : ']';


IF : 'if';
THEN : 'then';
ELSE : 'else';
ENDIF : 'endif';
ROP : ( '<' | '<=' | '>=' | '>' | '==' | '!=' );

DOUBLE : [0-9]+( | [.][0-9]+)*;