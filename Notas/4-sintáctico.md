Análisis Sintáctico Descendente (ASA):

$ : delimita final de la cadena

LL Leftmost derivation
ASA LR Rightmost derivation

# Conjuntos de predicción por cada regla de derivación

## PRIMEROS 
* x Cada No Terminal
* Pueden tener $\epsilon$
* No pueden tener $

## SIGUIENTES
* x Cada No terminal
* Pueden tener $
* No pueden tener $\epsilon$


## Condición $LL(1)$
* No existen dos conjuntos de predicción que tengan elementos en común y correspondan a dos reglas de un mismo simbolo no terminal

## Condición $LL(k)$
* Similar a $LL(1)$ pero con un look-ahead de k

## Condición $LL(\ast)$
* No importa el k, generalizado de $LL(k)$

## Recetas para convertir a $LL(1)$
* Eliminar recursividad por la izquierda de el no terminal $E$:
	* Se añade otro no terminal $E'$
	* Se añaden las reglas $E \rightarrow \beta_iE'$ donde $\beta_i$ son terminales de $E,\;(E \rightarrow \beta_i)$ 
	* Se añaden las reglas $E' \rightarrow \alpha_i E'$ donde $\alpha_i$ son no terminales de $E,\;(E \rightarrow E\alpha_i)$
	* Elimina la agrupación por izquierda
* Eliminar factores comúnes por la izquierda de el no terminal $E$:
	* Se agrupan las reglas con factor común por izquierda $\alpha,\;(E \rightarrow \alpha\beta_i)$  en un nuevo no terminal $E'$ y se añaden nuevas reglas:
	* $E \rightarrow \alpha E'$ 
	* $E' \rightarrow \beta_i$