Estructura de un compilador

* Análisis léxico -> Reporte de errores
* Análisis sintáctico -> Reporte de errores
* Análisis semántico -> Reporte de errores
* Generación de código intermedio
* Optimización
* Generación de código objeto

Reporte de errores: Depende de la proeza del compilador, puede ser por fase o completo. ( algunos abortan el proceso al primer momento de encontrar un error, otros después de un error de ; siguen compilando y encuentran más errores después del error)

Análisis Léxico:
	* Recibo código fuente	
	* Barrido del código fuente buscando que todos los elementos, simbolos sean conocidos dentro del lenguaje.
	* Se lee caracter por caracter y se agrupan en tokens de acuerdo a las expresiones regulares 
	* Agrupa los caracteres del archivo en elementos léxicos: tokens("palabras")
	* Errores léxicos: 
		* Caracteres no permitidos en el lenguaje
		* No permitidos en un contexto determinado 
	* Clases de tokens: 
		* Palabras reservadas
		* Simbolos especiales
		* Cadenas no especificas
		* EOF
	* Se epecifican mediante expresiones regulares:
		* Expresión Regular | Token
		* [a-z][a-z0-9]* | id
		* if | if
		* [0-9]+ | entero
		* > | mayor
		* >= | mayor_igual
		* / | div
	* Analogia:  
		* Clase -> Objeto
		* Token -> Lexema
	* Retorna Tokens("palabras")

Análisis sintáctico:
	* Análisis léxico -> Tokens("palabras")
	* Análisis sintáctico -> Estructura de las frases
	* Tipos de errores
	* Arbol de sintaxis abstracto (AST):
		* Captura estructuras anidadas
		* Abstrae la sintaxis especificas
		* Compacto y facil de usar
		* Se abstrae de el lenguaje original, no importa si la notación es pre, in o post fijo
		* Es una de las tareas más importantes 
	* Proces o que permite decidir si una cadena dada pertenece a una GIC
	* Estrategias
		* Análisis sintactico descendente
		* Análisis sintactico ascendente
	* Generación de un Arbol de Sintaxis Abstracta a partir de los tokens
	* Implementación de analizadores sintacticos:
		* A mano (para gramáticas simples)
		* Usando generadores automáticos : yacc/bison, ANTLR, PCCTS..
	
Análisis semántico:
	* Análisis léxico -> Tokens("palabras")
	* Análisis sintáctico -> Estructura de las frases
	* Análisis semántico -> "significado"
	* Tipos de errores:
		* Los tipos se usan correctamente
		* Todas las variables estan definidas
		* Los metodos se llmana en un orden correcto
		* ...
	* Puede ser muy sencillo o muy complicado
	* Las reglas semánticas hacen que los lenguajes sean sensibles al contexto, pero no se utilizan gramáticas sensibles al contexto
	* Se utilizan GIC + acciones para la comprobacion de restricciones semánticas ( Como una gramática con código )
	* Analizador semántico: añade información semántica al AST -> Árbol AST enriquecido (revisado/decorado)
	
Generación de código intermedio: 
	Código en una representación intermedia independiente de la sintaxis del lenguaje y de la arquitectura
	Ejemplo: .NET -> LIS (Maquina virtual de pila)
	
Optimización:

	* Mejora en el código en memoria, potencia, eficiencia, ...
	* ¿ Cuándo Optimizar ? :	
		* En el AST:
			* pro: independiente de arquitectura
			* contra: demasiado alto nivel
		* En código ensamblador:
			* pro: facilidad de optimización 
			* contra: dependiente de la arquitectura, necesario optimizar por cada arquitectura
		* En código intermedio
			* pro: independiente de arquitectura
			* pro: facilidad de optimización
	* Grafo de Control de Flujo (GFC):
		* BB
		* ...
	* Tipos de optimización:
		* Local:
			* "peephole"
			* código inalcanzable
			* código muerto
		* Global:	
			* algunas opt. locales se pueden extender a globales (a todo el gfc)
			* desenrollado de ciclos
			* análisis de la vida de las variables (LVA)
			* expresiones disponibles
		* A nivel de programa:
			* eliminacion de procesos inalcanzables: grafo de llamados
			* tener cuidado con programas cómo APIs
	
Generación de código objeto:
	* más fácil que la generación de código intermedio, tipicamente es una traducción 1-1
	
Aplicaciones
	* Implementar lenguajes de programación de alto nivel: propósito general y de dominio especifico (e.g Matlab, SQL, R o lenguaje muy sencillo para químicos que usan rutinas comunes) 
	* Optimización: paralelismo Cuda OpenCL, jerarquía de memoria (caches, ...)
	* Diseño de nuevas arquitecturas de computadores: (PowerPC, SPARC, MIPS, Alpha, and PA-RISC, basadas en RISC; arq. especializadas)
	* Traductores: (traducción binaria, síntesis de hardware, consultas a bases de datos, simulación, traductores de lenguaje natural, navegadores web, visores PDF, ...)
	* Aplicaciones de análisis de código fuente
	
	
Aplicaciones de análisis: 
	Procedimiento automatizado que busca obtener una idea acerca de distintos aspectos del código fuente
	Manipulación Procedimiento automático donde se realizan tranformaciones al código fuente
	
Optimización
Seguridad
Debug
Profiling estilo de codigo o de programadores
Métricas software
Tolerancia a fallos
Ingeniería Inversa
Visualización de software
Verificación
Refactoring
Calidad
Más...
	


	