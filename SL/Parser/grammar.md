PROGRAMA
//Programa Principal
PROGRAMA : PROGRAMAPRC SUBRUTINAS
PROGRAMAPRC : NOMBRE DECLARACIONES <inicio> SENTENCIAS <fin> 
NOMBRE : <programa> IDENTIFICADOR | eps


//identificadores
IDENTIFICADOR : <id>
RESERVADA : <imprimir> | <leer>


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
VAR : LISTAID <tk_double_point> VAR2 OPT
VAR2 : IDENTIFICADOR | TIPOBASICO
LISTAID : IDENTIFICADOR LISTAID2
LISTAID2 : <tk_comma> IDENTIFICADOR LISTAID2 | eps 


//tokens
TOKENBASICO : <tk_numerico> | <tk_cadena> | <tk_logico>
TIPOBASICO : TIPOBASICO2 | TENSOR
TIPOBASICO2 : TIPOBASICO3| REGISTRO
TIPOBASICO3 : <numerico> | <cadena> | <logico> 


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
ACCESOREGISTRO : <tk_point> <id>


//recursion acceso
ACCESO : LLAMADOTENSOR ACCESO2 | ACCESOREGISTRO ACCESO2
ACCESO2 : LLAMADOTENSOR ACCESO2 | ACCESOREGISTRO ACCESO2 | eps

//sentencias
SENTENCIAS : SENTENCIA OPT SENTENCIAS | eps
SENTENCIA : IDENTIFICADOR SENTENCIA2 | RESERVADA LLAMADOSUB | SI | MIENTRAS | REPETIR | EVAL | DESDE 
SENTENCIA2 : ASIGNACION | LLAMADOSUB | ACCESO ASIGNACION
OPT : <tk_semicolon> | eps


//si probar de nuevo por si acaso
SI : <si> <tk_left_par> EXPRESION <tk_right_par> <tk_left_brace> SENTENCIAS SINO <tk_right_brace>
SINO : <sino> SINO2 | eps
SINO2 : SINOSI | SENTENCIAS
SINOSI : <si> <tk_left_par> EXPRESION <tk_right_par> SENTENCIAS SINO


//mientras falta probar
MIENTRAS : <mientras> <tk_left_par> EXPRESION <tk_right_par> <tk_left_brace> SENTENCIAS <tk_right_brace>


//repetir falta probar
REPETIR : <repetir> SENTENCIAS <hasta> <tk_left_par> EXPRESION <tk_right_par>


//eval falta probar
EVAL : <eval> <tk_left_brace> CASOS EVALSINO <tk_right_brace>
CASOS : CASO CASOS2
CASOS2 : CASO CASOS2 | eps
CASO : <caso> <tk_left_par> EXPRESION <tk_right_par> SENTENCIAS
EVALSINO : <sino> SENTENCIAS | eps


//desde falta probar
DESDE : <desde> IDENTIFICADOR DESDE2 <tk_assign> <tk_numerico> <hasta> <tk_numerico> PASO <tk_left_brace> SENTENCIAS <tk_right_brace> 
DESDE2 : LLAMADOTENSOR | eps
PASO : <paso> <tk_numerico>| eps

//asignacion
ASIGNACION : <tk_assign> ASIGNACION2
ASIGNACION2 : EXPRESION | LITERAL


//DECLARACIONES LITERALES
LITERAL : <tk_left_brace> LITERALES  <tk_right_brace>
LITERAL2 : LITERAL | EXPRESION
LITERALES : LITERAL2 LITERALES2 | eps
LITERALES2 : <tk_comma>  LITERAL2 LITERALES2 | eps


//EXPRESION falta probar
EXPRESION : IDENTIFICADOR IDEXPRESION EXPR2 | RESERVADA LLAMADOSUB EXPR2 | TOKENBASICO EXPR2 
IDEXPRESION : LLAMADOSUB | ACCESO | eps
EXPR2 : 

//NUMEXPR
NUMEXPRA : NUMEXPRB NUMEXPRA2
NUMEXPRA2 : <tk_plus> NUMEXPRB NUMEXPRA2 | eps
NUMEXPRB : NUMEXPRC | <tk_minus> NUMEXPRB | <tk_plus> NUMEXPRB
NUMEXPRC : NUMEXPRD NUMEXPRC2 
NUMEXPRC2 : <tk_asterisk> NUMEXPRD NUMEXPRC2 | <tk_division> NUMEXPRD NUMEXPRC2 | <tk_mod> NUMEXPRD NUMEXPRC2
NUMEXPRD : EXPRESION 
NUMEXPRD2 :

//LOGICEXPR
EXPRESION3 : OPERACION | eps

LLAMADOTENSOR : <tk_left_bracket> LISTAEXPR <tk_right_bracket>
LISTAEXPR : EXPRESION LISTAEXPR2
LISTAEXPR2 : <tk_comma> EXPRESION LISTAEXPR2 | eps


// operaciones
OPERACIONCOMPLETA: OPERANDO OPERACION | OPERADORCAMBIOSIGNO OPERANDO
OPERACION : OPERADOR OPERACION2
OPERACION2 : OPERANDO OPERACION4 | <tk_left_par> OPERACION3 <tk_right_par> OPERACION4
OPERACION3 : <tk_left_par> OPERACION3 <tk_right_par> OPERACION4 | OPERANDO OPERACION4
OPERACION4 : OPERACION | eps


// operandos
OPERANDO : OPERANDO1 | OPERADORARITMETICO OPERANDO1
OPERANDO1 : IDENTIFICADOR OPERANDO2 | TOKENBASICO
OPERANDO2 : EXPRESION4 | eps


// operadores
OPERADOR : OPERADORARITMETICO | OPERADORLOGICO | OPERADORRELACIONAL
OPERADORARITMETICO : OPERADORARITMETICO1| OPERADORARITMETICO2 | OPERADORARITMETICO3
OPERADORARITMETICO1 : <tk_power>
OPERADORCAMBIOSIGNO : <tk_plus> | <tk_minus>
OPERADORARITMETICO2 : <tk_asterisk> | <tk_division> | <tk_mod>
OPERADORARITMETICO3 : <tk_plus> | <tk_minus>
OPERADORRELACIONAL : <tk_less> | <tk_less_equal> | <tk_greater_equal> | <tk_equal> | <tk_assign> | <tk_not_equal> | <tk_greater>
OPERADORLOGICO : <or> | <and> | <not>


// aritmeticos
//A : E |  A <tk_minus> E | A <tk_plus> E
//B : A | B <tk_asterisk> A | B <tk_division> A | B <tk_mod> A
//C : B | <tk_minus> B | <tk_plus> B
//D : C | D <tk_power> C
//E : D | <tk_left_par> D <tk_right_par>

// condicion
//A : E <or> E
//B : A | B <and> B
//C : B | <not> B
//D : C | C <tk_equal> C | C <tk_not_equal> C | C <tk_less> C | C <tk_less_equal> C | C <tk_greater> C | C <tk_greater_equal> C
//E : D | <tk_left_par> D <tk_right_par> 


//llamado subrutinas falta probar el nombre de Parametros formales y Parametros estan al revez
LLAMADOSUB : <tk_left_par> PARAMETROSFORMALES <tk_right_par>
PARAMETROSFORMALES : PARAMETROFORMAL PARAMETROSFORMALES2 | eps
PARAMETROFORMAL : EXPRESION
PARAMETROSFORMALES2 : <tk_comma> PARAMETROFORMAL PARAMETROSFORMALES2 | eps


//subrutinas falta probar
SUBRUTINAS : <subrutina> IDENTIFICADOR <tk_left_par> PARAMETROS <tk_right_par> SUBRUTINAS2 SUBRUTINAS | eps
SUBRUTINAS2 : PROCEDIMIENTO | FUNCION


//parametro falta probar
PARAMETROS : PARAMETRO PARAMETROS2 | eps
PARAMETROS2 : OPT PARAMETRO PARAMETROS2 | eps
PARAMETRO : REF LISTAID <tk_double_point> PARAMETRO2
PARAMETRO2 : IDENTIFICADOR | TIPOBASICO
REF : <ref> | eps


//procedimiento falta probar
PROCEDIMIENTO : DECLARACIONES <inicio> SENTENCIAS <fin>


//funcion falta probar
FUNCION : <retorna> FUNCION2 DECLARACIONES <inicio> SENTENCIAS RETORNA <fin>
FUNCION2 : IDENTIFICADOR | TIPOBASICO
RETORNA : <retorna> <tk_left_par> IDENTIFICADOR <tk_right_par>