parser grammar SLGrammarParser;

options { tokenVocab=SLGrammarLexer; }

program
    : (PROGRAM ID)? declarations? body subroutines?
    ;

body
    : START (expression|loop|sentences)* END
    ;

subroutines
    : subroutine+
    ;

declarations
    : (consts|types|vars)+
    ;

consts
    : CONST const_+
    ;

const_
    : ID ASSIGN (STRING|NUMBER|PREDEF_BOOL_POS|PREDEF_BOOL_NEG)
    ;

types
    : TYPES data_type+;

vars
    : VAR var+;

var
    : id_list simple_data_type;


data_type
    : DATA_TYPE
    | ID ;

simple_data_type
    : data_type
    | VECTOR LEFT_BRACE (TIMES|number_expression) RIGHT_BRACE data_type
    | MATRIX LEFT_BRACE mat_dim RIGHT_BRACE data_type
    | RECORD LEFT_BRACKET (id_list simple_data_type)+ RIGHT_BRACKET
    ;

mat_dim
    : (TIMES (COMMA TIMES)* ( COMMA number_expression)* ) | (number_expression (COMMA number_expression) ;

id_list
    : ID (COMMA ID)* DOUBLE_POINT;

access_variable
    : ID access_variable_aux
    ;

access_variable_aux
    : POINT ID access_variable_aux
    | LEFT_BRACE (INT|access_variable) (COMMA (INT|access_variable) )* RIGHT_BRACE access_variable_aux
    |
    ;

operand
    : ID
    | STRING_LITERAL
    | NUMBER_LITERAL
    ;

additive_operation
    : PLUS
    | MINUS
    ;

multiplicative_operation
    : TIMES
    | DIVISION
    | MOD
    ;

relat_operation
    : NOT_EQUAL
    | EQUAL
    | GREATER_EQUAL
    | GREATER
    | LESS_EQUAL
    | LESS
    ;

logic_operand
    : subroutine_call
    | operand
    | access_variable
    | NUMBER_LITERAL
    | PREDEF_BOOL_POS
    | PREDEF_BOOL_NEG
    ;

subroutine_call
    : ID LEFT_PAR parameters RIGHT_PAR
    ;

parameters
    : (additive_expression (COMMA additive_expression)*)*
    ;

expression
    : number_expression
    | array_init
    ;

number_expression
    : additive_expression
    | subroutine_call
    | access_variable
    | NUMBER_LITERAL
    ;

array_init
    : operand
    | LEFT_BRACKET (array_init (COMMA array_init)*)? RIGHT_BRACKET
    ;

additive_expression
    : multiplicative_expression (additive_operation multiplicative_expression)*
    ;

multiplicative_expression
    :
    change_sign_expression (multiplicative_operation change_sign_expression)*;

change_sign_expression
    : additive_operation* potentiation_expression;

potentiation_expression
    : unit POWER potentiation_expression
    | unit
    ;

unit
    : relat_expression
    | LEFT_PAR additive_expression RIGHT_PAR
    ;

concat_expression
    : STRING (PLUS STRING)+
    ;

relat_expression
    : not_expression (relat_operation not_expression)*
    ;

not_expression
    : NOT* and_expression
    ;

and_expression
    : or_expression (AND or_expression)*
    ;

or_expression
    : logic_unit (OR logic_unit)*
    ;

logic_unit
    : logic_operand
    | LEFT_PAR additive_expression RIGHT_PAR
    ;

sentences
    : assign
    | conditional_sentence
    | subroutine_call
    ;

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
    : FROM assign_sentence UNTIL number_expression (STEP number_expression)? LEFT_BRACKET sentences* RIGHT_BRACKET;

subroutine
    : SUBROUTINE ID LEFT_PAR formal_parameters? RIGHT_PAR (RETURNS data_type)? declarations? subroutine_body ;

formal_parameters
    : formal_parameter (SEMI formal_parameter)* ;

formal_parameter
    : REF? simple_variable ;

subroutine_body
    : START (sentences|loop|expression)* return_expression? END ;

return_expression
    : RETURNS LEFT_PAR expression RIGHT_PAR ;

