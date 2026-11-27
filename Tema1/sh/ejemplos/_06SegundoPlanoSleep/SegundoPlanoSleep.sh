#COn & al final trabajan en segundo plano y fg %1 trae el 1º sleep a primer plano el 
#cual despues de con Ctrl + Z detiene el programa  y bg % 1 lo pondria a trbaja de nuevo
# en segundo plano


#!/bin/bash
sleep 100 & # en segundo plano: muestra [1] y el PID
sleep 200 & # trabajo [2]
jobs -l # trabajos de esta terminal, con su PID (-l)

fg %1 # foreground: la terminal se bloquea esperando a sleep 100

jobs -l # el 1 aparece como Detenido
ps -o pid,stat,cmd -p 3051 # usa TU PID: el estado es T (detenido)
bg %1 # background: sigue ejecutándose, en segundo plano
ps -o pid,stat,cmd -p 3051 # ahora el estado es S (dormido, esperando a que pase el tiempo)
kill %1 %2 # termina los dos
jobs -l # bash avisa de que han terminado; después, la lista queda
vacía


#pagina 18 empezar