#!/bin/bash
yes > /dev/null & # yes escribe "y" sin parar; > /dev/null tira esa salida a la basura
top

yes > /dev/null &
yes > /dev/null &
top # pulsa 1 para ver los núcleos uno a uno

jobs # lista los trabajos en segundo plano de esta terminal
kill %1 %2 %3 # termina los trabajos 1, 2 y 3
pgrep yes # no debe mostrar nada; si sale algún PID: kill PID