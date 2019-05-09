# Grámatica

$S \rightarrow ABC$

$S \rightarrow DE$

$A \rightarrow dos\;B\;tres$

$A \rightarrow \epsilon$

$B \rightarrow B'$

$B' \rightarrow cuatro\;C\;cinco\;B'$

$B' \rightarrow \epsilon$

$C \rightarrow seis\;A\;B$

$C \rightarrow \epsilon$

$D \rightarrow uno\;A\;E$

$D \rightarrow B$

$E \rightarrow tres$

# Primeros

$E : \{tres\}$

$B', B : \{cuatro, \epsilon\}$

$C : \{seis, \epsilon\}$

$D : \{uno, cuatro, \epsilon\}$

$A : \{dos, \epsilon\}$

$S : \{uno, dos, tres, cuatro, seis, \epsilon\}$


# Siguientes

$S : \{\$ \}$

$C : \{cinco, \$ \}$

$B : \{tres, seis, cinco, \$ \}$

$B' : \{tres, seis, cinco, \$ \}$

$A : \{tres, cuatro, cinco, seis, \$\}$

$E : \{tres, \$ \}$

$D : \{tres\}$

# Conjutos Predicción

$S \rightarrow ABC \quad \{dos, cuatro, seis, \$\}$

$S \rightarrow DE \quad \{uno, tres, cuatro\}$

$A \rightarrow dos\;B\;tres \quad \{dos\}$

$A \rightarrow \epsilon \quad \{tres, cuatro, cinco, seis, \$\}$

$B \rightarrow B' \quad \{treis, cuatro, cinco, seis, \$ \}$

$B' \rightarrow cuatro\;C\;cinco\;B' \quad \{cuatro\}$

$B' \rightarrow \epsilon \quad \{tres, cinco, seis, \$\}$

$C \rightarrow seis\;A\;B \quad \{seis\}$

$C \rightarrow \epsilon \quad \{cinco, \$\}$

$D \rightarrow uno\;A\;E \quad \{uno\}$

$D \rightarrow B \quad \{cuatro, tres\}$

$E \rightarrow tres \quad \{tres\}$

No es LL porque las dos primeras reglas comparten un elemento en su conjunto de predicción