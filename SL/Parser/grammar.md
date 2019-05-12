PROGRAMA
PROGRAMA : PROGRAMAPRC SUBRUTINAS
PROGRAMAPRC : NOMBRE DECLARACIONES SENTENCIAS 
NOMBRE : <programa> <id> | eps
DECLARACIONES : <const> CONSTS DECLARACIONES | <tipo> TIPOS DECLARACIONES | <var> VARS DECLARACIONES | eps 
CONSTS : CONST CONSTS2
CONST : <id> <tk_assign> <tk_cadena> | <id> <tk_assign> <tk_numerico> | <id> <tk_assign> <tk_logico>
CONSTS2 : CONST CONST2 | eps
TIPOS : TIPO TIPOS2
TIPO : <tipo>
TIPOS2 : TIPO TIPOS2 | eps
VARS : VAR VARS2 | eps 
VAR : <var>
VARS2 : VAR VARS2 | eps
SENTENCIAS : eps
SUBRUTINAS : PROCEDIMIENTO SUBRUTINAS | FUNCION SUBRUTINAS | eps
PROCEDIMIENTO : <procedimiento>
FUNCION : <subrutina> <id> <tk_left_par> <id> <tk_double_point> PARAMETROS <tk_left_par> <retorna> <id> DECLARACIONES <inicio> SENTENCIAS RETORNA <fin>
PARAMETROS : PARAMETRO PARAMETROS2 | eps
PARAMETRO : REF LISTAID <tk_doublepoint> <id>
PARAMETROS2 : <tk_semicolon> PARAMETRO PARAMETROS2
REF : <ref> | eps
LISTAID : <id> LISTAID2
LISTAID2 : <tk_comman> <id> LISTAID2 
RETORNA : <retorna> <tk_left_par> <id> <tk_right_par>