parser grammar SLGrammarParser;

file : (PROGRAM ID)? declarations? body subroutine*
        ;

declarations : (const_declarations | types_declarations | var_declarations)+
        ;

const_declarations :
        CONST (ID TK_ASSIGN (TK_STRING
                                | number
                                | PREDEF_CONST_POS
                                | PREDEF_CONST_NEG))+
        ;

types_declarations : TYPES simple_variable+
        ;

var_declarations : VAR simple_variable+
        ;

data_type : DATA_TYPE
        | ID ;

simple_variable :
        simple_variable_aux data_type
        | simple_variable_aux VECTOR TK_LEFT_BRACE (INT_NUMBER | TK_TIMES) TK_RIGHT_BRACE data_type
        | simple_variable_aux MATRIX TK_LEFT_BRACE (INT_NUMBER (TK_COMMA INT_NUMBER)+ | TK_TIMES (TK_COMMA TK_TIMES)*) TK_RIGHT_BRACE data_type
        | simple_variable_aux RECORD TK_LEFT_BRACKET (simple_variable)+ TK_RIGHT_BRACKET
        ;

simple_variable_aux :
        ID (TK_COMMA ID)* TK_DOUBLE_POINT
        ;

access_variable : ID access_variable_aux
        ;

access_variable_aux : TK_POINT ID access_variable_aux
        | TK_LEFT_BRACE (INT_NUMBER|access_variable) (TK_COMMA (INT_NUMBER|access_variable) )* TK_RIGHT_BRACE access_variable_aux
        |
        ;

number : INT_NUMBER
        | REAL_NUMBER
        | EXP_NUMBER
        ;

operand : ID
        | TK_STRING
        | CHAR
        | number
        ;

additive_operation : TK_PLUS
        | TK_MINUS
        ;

multiplicative_operation : TK_TIMES
        | TK_DIVISION
        | TK_MOD
        ;

relat_operation : TK_NOT_EQUAL
        | TK_EQUAL
        | TK_GREATER_EQUAL
        | TK_GREATER
        | TK_LESS_EQUAL
        | TK_LESS
        ;

logic_operand : subroutine_call
        | operand
        | number
        | access_variable
        | PREDEF_CONST_POS
        | PREDEF_CONST_NEG
        ;

subroutine_call : ID TK_LEFT_PAR (additive_expression (TK_COMMA additive_expression)*)* TK_RIGHT_PAR
        ;

expression : number_expression
        | array_init
        ;

number_expression : additive_expression
        | subroutine_call
        | number
        | access_variable
        ;

array_init :
        operand
        | TK_LEFT_BRACKET (array_init (TK_COMMA array_init)*)? TK_RIGHT_BRACKET
        ;

additive_expression :
        multiplicative_expression (additive_operation multiplicative_expression)*
        ;

multiplicative_expression :
        change_sign_expression (multiplicative_operation change_sign_expression)*
        ;

change_sign_expression : additive_operation* potentiation_expression
        ;

potentiation_expression : unit TK_POWER potentiation_expression
        | unit
        ;

unit : relat_expression
        | TK_LEFT_PAR additive_expression TK_RIGHT_PAR
        ;

concat_expression : TK_STRING (TK_PLUS TK_STRING)+
        ;

relat_expression : not_expression (relat_operation not_expression)*
        ;

not_expression : NOT* and_expression
        ;

and_expression : or_expression (AND or_expression)*
        ;

or_expression : logic_unit (OR logic_unit)*
        ;

logic_unit : logic_operand
        | TK_LEFT_PAR additive_expression TK_RIGHT_PAR
        ;

sentences : assign_sentence
        | conditional_sentence
        | subroutine_call
        ;

assign_sentence : access_variable TK_ASSIGN expression
        ;

conditional_sentence :
        IF TK_LEFT_PAR expression TK_RIGHT_PAR
        TK_LEFT_BRACKET sentences* (ELSE IF TK_LEFT_PAR expression TK_RIGHT_PAR sentences*)*
        (ELSE sentences*)? TK_RIGHT_BRACKET
        ;

loop : while_loop | repeat_loop | eval_loop | from_loop ;

while_loop :
        WHILE TK_LEFT_PAR expression TK_RIGHT_PAR TK_LEFT_BRACKET sentences* TK_RIGHT_BRACKET
        ;

repeat_loop :
        REPEAT sentences* UNTIL TK_LEFT_PAR expression TK_RIGHT_PAR
        ;

eval_loop :
        EVAL TK_LEFT_BRACKET (CASE TK_LEFT_PAR expression TK_RIGHT_PAR sentences*)+
        (ELSE sentences*)* TK_RIGHT_BRACKET
        ;

from_loop :
        FROM assign_sentence UNTIL number_expression (STEP number_expression)? TK_LEFT_BRACKET sentences* TK_RIGHT_BRACKET
        ;

body : START (expression|loop|sentences)* END
        ;

subroutine :
        SUBROUTINE ID TK_LEFT_PAR formal_parameters? TK_RIGHT_PAR (RETURNS data_type)? declarations? subroutine_body
        ;

subroutine_body : START (sentences|loop|expression)* return_expression? END
        ;

return_expression :
        RETURNS TK_LEFT_PAR expression TK_RIGHT_PAR
        ;

formal_parameters : REF? simple_variable (TK_COMMA REF? simple_variable)*
        ;