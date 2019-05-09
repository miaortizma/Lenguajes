### Análisis Léxico

* Scanner == Tokenizer == Lexer

* Agrupa los caracteres en elementos léxicos: tokens ("palabras")

* Comúnmente se centra en elementos importantes y descarta otros elementos del lenguaje que no son importantes para el análisis: espacios en blanco, tabulaciones, etc.

Errores Léxicos:

* Caracteres que no pertenece al alfabeto del lenguaje

* Cadena que no coincide co ninguno de los patrones de los tokens posibles

* Cadena que no coincide con ninguno de los patrones de los tokens posibles (:= es la asignación pero : no puede aparecer solo)

***

* La cadena de caracteres conreta que representa un token se denomina lexema

* El lexema no juega un papel desde el punto de vista estructural, pero si desde el semántico

* A la información auxiliar que acompaña a un token se le llama atributos del token (lexema, fila, columna, ...)

***

* Analizador Léxico funciona en conjunto con el Analizador Sintáctico   

* Procesado léxico del programa fuente (tokens, lexemans, interacción con A. Sintáctico)

* Manejo del archivo de código fuente (abrir, leer caracteres, cerrar, gestión de errores de lectura de archivo)

* Ignorar comentarios y, en lenguajes de formato libre, ignorar separadores (espacios en blanco, tabulaciones, retornos de carro, etc...)

* Localización (número de linea, posición)

* Preproceso de macros, definiciones, constantes, inclusión de otros archivos, ...

***

* Clases de tokens: 
	* Palabras reservadas(if, then,...)
	* simbolos especiales(operadores aritméticos, lógicas...)
	* cadenas no especificas(identificador, número real,...)
	* EOF(fin de archivo)
* Se especifican mediante expresiones regulares

***

Consideraciones:

* Política de elección de palabra reservada sobre identificador
* Principio de la subcadena más larga (Seguir leyendo mientras existan posibilidades para la cadena)
* Con algunos tokens nos tenemos que "pasar" leyendo la entrada (es necesario leer uno o varios caracteres más para determinar de que token se trata)


