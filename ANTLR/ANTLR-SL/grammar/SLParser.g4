parser grammar SLParser;
options { tokenVocab=SLLexer; }

programa
    : programaprc subrutinas EOF ;

programaprc
    : (PROGRAMA ID)? (declaraciones)? INICIO sentencias? FIN;

declaraciones
    : declaracion+;

declaracion
    : (CONST consts)|(TIPOS tipos)|(VAR vars);

consts
    : const_+;

const_
    : ID ASSIGN literal opt;

tipos
    : tipo+;

tipo
    : ID DOUBLE_POINT tipobasico opt;

vars
    : var+;

var
    : listaid DOUBLE_POINT explicitvar opt;

explicitvar
    : ID | tipobasico;

opt
    : SEMI?;

listaid
    : ID (COMMA ID)*;

literal
    : NUMERICO_LITERAL
    | CADENA_LITERAL
    | LOGICO_LITERAL;

tipobasico
    : tipobasico2
    | tensor;

tipobasico2
    : tipobasico3
    | registro;

tipobasico3
    : NUMERICO
    | CADENA
    | LOGICO;

tensor
    : TENSOR;

registro
    : REGISTRO;

subrutinas
    : subrutina*;

subrutina
    : (SUBRUTINA nombre_subrutina=ID LEFT_PAR parametrosformales? RIGHT_PAR) (procedimiento | funcion);

procedimiento
    :  declaraciones? INICIO sentencias? FIN;

funcion
    : RETORNA tiporet declaraciones? INICIO sentencias? RETORNA LEFT_PAR ret RIGHT_PAR FIN;

tiporet
    : ID | tipobasico;

ret
    : ID | expr;

expr
    : NUMERICO_LITERAL PLUS NUMERICO_LITERAL
    | NUMERICO_LITERAL
    | ID;

parametrosformales
    : parametroformal (SEMI parametroformal)*;

parametroformal
    : REF? listaid DOUBLE_POINT ( ID | tipobasico );

sentencias
    : sentencia+;

sentencia
    : SENTENCIA | llamadosub;


llamadosub
    : ID LEFT_PAR parametros RIGHT_PAR;

parametros
    : expr (COMMA expr)*;

