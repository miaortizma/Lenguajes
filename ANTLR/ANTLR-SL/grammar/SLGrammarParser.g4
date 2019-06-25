parser grammar SLGrammarParser;

options { tokenVocab=SLGrammarLexer; }

program
    : (PROGRAM ID)? declarations? START sentences? END subroutines? ;

declarations
    : (consts|types|vars)+ ;

consts
    : CONST const_+ ;

const_
    : ID ASSIGN literal ;

types
    : TYPES alias+;

alias:
    (ID DOUBLE_POINT type);

type
    : (ID|data_type|tensor|record);

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
    : RECORD LEFT_BRACKET var+ RIGHT_BRACKET;

tensor
    : (vector|matrix) (data_type|record);

vector
    : VECTOR LEFT_BRACE (TIMES|expression) RIGHT_BRACE ;

matrix
    : MATRIX LEFT_BRACE mat_dim RIGHT_BRACE ;

data_type
    : DATA_TYPE;

string_literal
    : STRING_LITERAL;

literal
    : (string_literal|NUMBER_LITERAL|PREDEF_BOOL) ;

mat_dim
    : (TIMES (COMMA TIMES)* ( COMMA expression)* ) | (expression (COMMA expression)* ) ;

id_list
    : ID (COMMA ID)*;

access_variable
    : ID ( access_tensor | access_record );

access_record
    :  ( POINT ID )+ access_tensor? ;

access_tensor
    : LEFT_BRACE expression ( COMMA expression )* RIGHT_BRACE access_record ? ;

expression
    : LEFT_PAR expression RIGHT_PAR # expressionPar
    | expression POWER expression # expressionPower
    | add_op+ expression # expressionChangeSign
    | expression mul_op expression # expressionMultiplication
    | expression add_op expression # expressionAddition
    | expression rel_op expression # expressionRelational
    | NOT+ expression # expressionNot
    | expression AND expression # expressionAnd
    | expression OR expression # expressionOr
    | (access_variable|ID|literal) # expressionVariable
    ;

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

concat_expression
    : STRING (PLUS STRING)+ ; // unused ?

assign
    : (ID|access_variable) ASSIGN (expression|structured_literal) ;

structured_literal // Structured literal for tensors and records
    : LEFT_BRACKET (expression (COMMA expression)*)? RIGHT_BRACKET ;


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
    : (ID|PREDEF_FUNC) LEFT_PAR parameters? RIGHT_PAR ;

predef_func
    : PREDEF_FUNC;

subroutines
    : subroutine+ ;

subroutine
    : SUBROUTINE ID LEFT_PAR formal_parameters? RIGHT_PAR (procedure|function);

formal_parameters
    : formal_parameter (SEMI formal_parameter)* ;

formal_parameter
    : formal_parameter_id (COMMA formal_parameter_id)* DOUBLE_POINT type ;

formal_parameter_id
    : REF? ID;

procedure
    :  declarations? START sentences? END;

function
    : RETURNS type declarations? START sentences? RETURNS LEFT_PAR ret RIGHT_PAR END;

ret
    : RETURNS LEFT_PAR expression RIGHT_PAR ;

