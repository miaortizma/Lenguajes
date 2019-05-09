
Uso de los AFD: Traductor

Generan cadena de salida a partir de una de entrada

No hay estados de aceptación.

* Se incorporan:
	* Alfabeto de salida $(\Lambda )$
	* Función de salida $(\lambda )$

$$M=\left(Q,\sum ,f,\Lambda ,\lambda ,q_0\right)$$

* Máquinas de Moore $\left(\lambda : Q \Rightarrow \Lambda \right)$:
	
	(traducen en los estados, no imprime nada en el estado inicial)

* Máquinas de Mealy $\left(\lambda : Q  \times \sum 	
	(traducen en las transiciones, se puede simplificar más)


Automátas Finitos No Determinitas (AFND)

Se permite: 

* Más de una transición $\Delta(q_x, a)$
* Más de un estado inicila
* $\epsilon-\text{transiciones}$

Propiedades:

* Para una misma cadena pueden haber varios caminos

* Todo AFND puede convertirse en un AFD

* Si $\left(M_{AFD} \equiv M_{AFND}\Rightarrow L(M_{AFD}) = L(M_{AFND})\right)$

* Suelen ser más faciles de diseñar


