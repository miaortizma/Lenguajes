parser grammar SLParser;
options { tokenVocab=SLLexer; }

commands    : command *;
command     : conditional;


conditional : IF booleanExpr THEN c1=commands (ELSE c2=commands)? ENDIF;
booleanExpr : expr ROP expr;

expr        : expr ASTERISK expr
            | expr PLUS expr
            | DOUBLE
            | LEFT_PAR expr RIGHT_PAR
            ;