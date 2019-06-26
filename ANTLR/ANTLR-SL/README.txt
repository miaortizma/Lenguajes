## Interprete de SL usando ANTLR y Java.

Integrantes:
  - Fabio Steven Tovar Ramos
  - Miguel Ángel Ortiz Marín

Escrito a las 5:40, 26 de julio 2019. 

Para probar el código se puede correr desde Intellij el archivo TestVisitor o Interpreter del package interpreter usando como entrada los archivos en la carpeta input.

Los archivos de ejemplo son:

- input.txt : aqui probamos features básicas del lenguaje.

- FizzBuzz.txt : imprime para los numeros entre 1 y 100 Fizz si es múltiplo de 3, Buzz si es múltiplo de 5 y FizzBuzz si es múltiplo de ambos.
  
- fib.txt : fibbonaci iterativo y recursivo.

También se puede probar el StackedContextMap con TestStackedContextMap si ningun input.

FEATURES:

- Registros, Tensores (Vectores y Matrices), Numérico, Logico, Cadena

- Interfaces Assignable y Comparable 

- Expresiones, 

- StackedContextMap:

- Funciones

Manejamos el contexto de funciones y variables con un stack de HashMap en conjunto con una clase Ref y una clase Const.


Lo que nos falto:

- parsear literales estructurados

- sino si: no se diferencia entre sino si en la misma linea o sino si en diferente linea

- separar expresiones con ; en la misma linea: se parsea el ; pero también se permiten dos expresiones en la misma linea

- funciones predefinidas del lenguaje ( se hicieron sin para Numérico y leer e imprimir para Numérico, Logico y Cadena )
