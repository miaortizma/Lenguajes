parser grammar SLGrammarParser;

options { tokenVocab=SLGrammarLexer; }

program
    : (PROGRAM ID)? declarations? START sentences? END subroutines? ;

declarations
    : (consts|types|vars)+ ;

consts
    : CONST const_+ ;

const_
    : ID ASSIGN (STRING|NUMBER_LITERAL|PREDEF_BOOL_POS|PREDEF_BOOL_NEG) ;

types
    : TYPES type+;

type
    : ID
    | DATA_TYPE
    | tensor
    | record ;

vars
    : VAR var+;

var
    : id_list DOUBLE_POINT type;

sentences
    : sentence+ ;

sentence
    : expression
    | loop
    | assign
    | conditional_sentence
    | subroutine_call ;

record
    : RECORD LEFT_BRACKET vars RIGHT_BRACKET;

tensor
    : vector
    | matrix;

vector
    : VECTOR LEFT_BRACE (TIMES|expression) RIGHT_BRACE (DATA_TYPE|record);

matrix
    : MATRIX LEFT_BRACE mat_dim RIGHT_BRACE (DATA_TYPE|record);

mat_dim
    : (TIMES (COMMA TIMES)* ( COMMA expression)* ) | (expression (COMMA expression)) ;

id_list
    : ID (COMMA ID)*;

access_variable
    : ID ( POINT ID )+ access_tensor? ;

access_tensor
    : LEFT_BRACE expression ( COMMA expression )* RIGHT_BRACE access_variable? ;

operand
    : ID
    | STRING_LITERAL
    | NUMBER_LITERAL;

logic_operand
    : operand
    | access_variable
    | NUMBER_LITERAL
    | PREDEF_BOOL_POS
    | PREDEF_BOOL_NEG ;

expression
    : LEFT_PAR expression RIGHT_PAR
    | expression POWER expression
    | add_op+ expression // Change sign
    | expression mul_op expression
    | expression add_op expression
    | expression rel_op expression
    | NOT+ expression
    | expression AND expression
    | expression OR expression
    | (access_variable|array_init|NUMBER_LITERAL) ;

rel_op
    : NOT_EQUAL
    | EQUAL
    | GREATER_EQUAL
    | GREATER
    | LESS_EQUAL
    | LESS ;

add_op
    : PLUS
    | MINUS ;

mul_op
    : TIMES
    | DIVISION
    | MOD ;

array_init
    : operand
    | LEFT_BRACKET (array_init (COMMA array_init)*)? RIGHT_BRACKET ;

concat_expression
    : STRING (PLUS STRING)+ ; // unused ?

assign
    : access_variable ASSIGN expression ;

conditional_sentence
    :
    IF LEFT_PAR expression RIGHT_PAR
    LEFT_BRACKET sentences* (ELSE IF LEFT_PAR expression RIGHT_PAR sentences*)*
    (ELSE sentences*)? RIGHT_BRACKET ;

loop
    : while_loop
    | repeat_loop
    | eval_loop
    | from_loop ;

while_loop
    : WHILE LEFT_PAR expression RIGHT_PAR LEFT_BRACKET sentences* RIGHT_BRACKET ;

repeat_loop
    : REPEAT sentences* UNTIL LEFT_PAR expression RIGHT_PAR ;

eval_loop
    : EVAL LEFT_BRACKET (CASE LEFT_PAR expression RIGHT_PAR sentences*)+
      (ELSE sentences*)* RIGHT_BRACKET ;

from_loop
    : FROM assign UNTIL expression (STEP expression)? LEFT_BRACKET sentences* RIGHT_BRACKET;



parameters
    : (expression (COMMA expression)*) ;


subroutine_call
    : ID LEFT_PAR parameters? RIGHT_PAR ;

subroutines
    : subroutine+ ;

subroutine
    : SUBROUTINE ID LEFT_PAR formal_parameters? RIGHT_PAR (procedure|function);

formal_parameters
    : formal_parameter (SEMI formal_parameter)* ;

formal_parameter
    : REF? type ;

procedure
    :  declarations? START sentences? END;

function
    : RETURNS type declarations? START sentences? RETURNS LEFT_PAR ret RIGHT_PAR END;

ret
    : RETURNS LEFT_PAR expression RIGHT_PAR ;

