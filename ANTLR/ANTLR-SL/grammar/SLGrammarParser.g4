parser grammar SLGrammarParser;

options { tokenVocab=SLGrammarLexer; }

program
    : (PROGRAM ID)? declarations? body subroutine*
    ;

declarations
    : (const_declarations | types_declarations | var_declarations)+
    ;

const_declarations
    : CONST (ID ASSIGN (STRING
    | number
    | PREDEF_CONST_POS
    | PREDEF_CONST_NEG))+
    ;

types_declarations
    : TYPES simple_variable+
    ;

var_declarations
    : VAR simple_variable+
    ;

data_type
    : DATA_TYPE
    | ID ;

simple_variable
    : simple_variable_aux data_type
    | simple_variable_aux VECTOR LEFT_BRACE (INT_NUMBER | TIMES) RIGHT_BRACE data_type
    | simple_variable_aux MATRIX LEFT_BRACE (INT_NUMBER (COMMA INT_NUMBER)+ | TIMES (COMMA TIMES)*) RIGHT_BRACE data_type
    | simple_variable_aux RECORD LEFT_BRACKET (simple_variable)+ RIGHT_BRACKET
    ;

simple_variable_aux
    : ID (COMMA ID)* DOUBLE_POINT
    ;

access_variable
    : ID access_variable_aux
    ;

access_variable_aux
    : POINT ID access_variable_aux
    | LEFT_BRACE (INT_NUMBER|access_variable) (COMMA (INT_NUMBER|access_variable) )* RIGHT_BRACE access_variable_aux
    |
    ;

number
    : INT_NUMBER
    | REAL_NUMBER
    | EXP_NUMBER
    ;

operand
    : ID
    | STRING
    | CHAR
    | number
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
    | number
    | access_variable
    | PREDEF_CONST_POS
    | PREDEF_CONST_NEG
    ;

subroutine_call
    : ID LEFT_PAR (additive_expression (COMMA additive_expression)*)* RIGHT_PAR
    ;

expression
    : number_expression
    | array_init
    ;

number_expression
    : additive_expression
    | subroutine_call
    | number
    | access_variable
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
    : assign_sentence
    | conditional_sentence
    | subroutine_call
    ;

assign_sentence
    : access_variable ASSIGN expression
    ;

conditional_sentence
    :
    IF LEFT_PAR expression RIGHT_PAR
    LEFT_BRACKET sentences* (ELSE IF LEFT_PAR expression RIGHT_PAR sentences*)*
    (ELSE sentences*)? RIGHT_BRACKET
    ;

loop
    : while_loop
    | repeat_loop
    | eval_loop
    | from_loop ;

while_loop
    : WHILE LEFT_PAR expression RIGHT_PAR LEFT_BRACKET sentences* RIGHT_BRACKET
        ;

repeat_loop
    : REPEAT sentences* UNTIL LEFT_PAR expression RIGHT_PAR
    ;

eval_loop
    : EVAL LEFT_BRACKET (CASE LEFT_PAR expression RIGHT_PAR sentences*)+
      (ELSE sentences*)* RIGHT_BRACKET
    ;

from_loop
    : FROM assign_sentence UNTIL number_expression (STEP number_expression)? LEFT_BRACKET sentences* RIGHT_BRACKET
    ;

body
    : START (expression|loop|sentences)* END
    ;

subroutine
    : SUBROUTINE ID LEFT_PAR formal_parameters? RIGHT_PAR (RETURNS data_type)? declarations? subroutine_body
    ;

subroutine_body
    : START (sentences|loop|expression)* return_expression? END
    ;

return_expression
    : RETURNS LEFT_PAR expression RIGHT_PAR
    ;

formal_parameters
    : REF? simple_variable (COMMA REF? simple_variable)*
    ;