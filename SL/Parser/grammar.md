PROGRAMA
//Programa Principal
PROGRAMA : PROGRAMAPRC SUBRUTINAS
PROGRAMAPRC : NOMBRE DECLARACIONES <inicio> SENTENCIAS <fin> 
NOMBRE : <programa> IDENTIFICADOR | eps


//identificadores
IDENTIFICADOR : <id> | RESERVADA
RESERVADA : <imprimir> | <leer> | <numerico> | <cadena> | <logico>


//Declaraciones
DECLARACIONES : <const> CONSTS DECLARACIONES | <tipos> TIPOS DECLARACIONES | <var> VARS DECLARACIONES | eps 


//const
CONSTS : CONST CONSTS2
CONSTS2 : CONST CONSTS2 | eps
CONST : IDENTIFICADOR <tk_assign> TOKENBASICO OPT


//tipos
TIPOS : TIPO TIPOS2
TIPOS2 : TIPO TIPOS2 | eps
TIPO : IDENTIFICADOR <tk_double_point> TIPOBASICO OPT


//vars
VARS : VAR VARS2
VARS2 : VAR VARS2 | eps
VAR : LISTAID <tk_double_point> TIPOBASICO OPT
LISTAID : IDENTIFICADOR LISTAID2
LISTAID2 : <tk_comma> IDENTIFICADOR LISTAID2 | eps 


//tokens
TOKENBASICO : <tk_numerico> | <tk_cadena> | <tk_logico>
TOKENLOGICO : <tk_logico> | <SI> | <NO> | <TRUE> | <FALSE>
TIPOBASICO : TIPOBASICO2 | TENSOR
TIPOBASICO2 : <numerico> | <cadena> | <logico> | REGISTRO


//tensores
TENSOR : VECTOR | MATRIZ
VECTOR : <vector> <tk_left_bracket> VECDIM <tk_right_bracket> TIPOBASICO2
MATRIZ : <matriz> <tk_left_bracket> MATDIM <tk_right_bracket> TIPOBASICO2


//dimension
VECDIM : <tk_numerico> | <tk_asterisk>
MATDIM : <tk_numerico> <tk_comma> <tk_numerico> MATDIMA | <tk_asterisk> MATDIMB
MATDIMA : <tk_comma> <tk_numerico> MATDIMA | eps


//open mat
MATDIMB : <tk_comma> MATDIMC
MATDIMC : <tk_asterisk> MATDIMB2 | <tk_numerico> MATDIMA
MATDIMB2 : <tk_comma> MATDIMC | eps


//registro
REGISTRO : <registro> <tk_left_brace> VARS <tk_right_brace>


//sentencias
SENTENCIAS : SENTENCIA OPT SENTENCIAS | eps
SENTENCIA : IDENTIFICADOR SENTENCIA2 | SI | MIENTRAS | REPETIR | EVAL | DESDE 
SENTENCIA2 : ASIGNACION | LLAMADOSUB 
OPT : <tk_semicolon> | eps


//si
SI : <si> <tk_left_par> EXPRESION <tk_right_par> <tk_left_brace> SENTENCIAS SINO <tk_right_brace>
SINO : <sino> SINO2 | eps
SINO2 : SINOSI | SENTENCIAS
SINOSI : <si> <tk_left_par> EXPRESION <tk_right_par> SENTENCIAS SINO

//asignacion
ASIGNACION : <tk_assign> EXPRESION

//EXPRESION 
EXPRESION : IDENTIFICADOR EXPRESION2 | TOKENBASICO
EXPRESION2 : LLAMADOSUB | eps

//llamado subrutinas
LLAMADOSUB : <tk_left_par> PARAMETROSFORMALES <tk_right_par>
PARAMETROSFORMALES : PARAMETROFORMAL PARAMETROSFORMALES2 | eps
PARAMETROFORMAL : EXPRESION
PARAMETROSFORMALES2 : <tk_comma> PARAMETROFORMAL PARAMETROSFORMALES2 | eps


//subrutinas
SUBRUTINAS : <subrutina> IDENTIFICADOR <tk_left_par> PARAMETROS <tk_right_par> SUBRUTINAS2 SUBRUTINAS | eps
SUBRUTINAS2 : PROCEDIMIENTO | FUNCION


//parametro
PARAMETROS : PARAMETRO PARAMETROS2 | eps
PARAMETROS2 : <tk_semicolon> PARAMETRO PARAMETROS2 | eps
PARAMETRO : REF LISTAID <tk_double_point> IDENTIFICADOR
REF : <ref> | eps


//procedimiento
PROCEDIMIENTO : DECLARACIONES <inicio> SENTENCIAS <fin>


//funcion
FUNCION : <retorna> IDENTIFICADOR DECLARACIONES <inicio> SENTENCIAS RETORNA <fin>
RETORNA : <retorna> <tk_left_par> IDENTIFICADOR <tk_right_par>

//TO:DO parametros por referencia, sentencias (más), OPERADORES, asignacion 