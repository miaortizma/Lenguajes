parser grammar SLParser;
options { tokenVocab=SLLexer; }



programa
    : programaprc subrutinas;

programaprc
    : nombre declaraciones sentencias;

declaraciones
    :
    | CONST const_ consts declaraciones
    | TIPOS tipo tipos declaraciones
    | VAR var vars declaraciones;

consts
    :
    | const_ consts;

const_
    : ID ASSIGN literal opt;

tipos
    :
    | tipo tipos;

tipo
    : ID DOUBLE_POINT tipobasico opt;

vars
    :
    | var vars;

var
    : listaid DOUBLE_POINT explicitvar;

explicitvar
    : ID | tipobasico;

opt
    :
    | SEMICOLON;

nombre
    :
    | ID;

listaid
    : ID listaid2;

listaid2
    : COMMA ID listaid2;

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
    : ;

registro
    : ;

subrutinas          : ;

sentencias
    : ;
