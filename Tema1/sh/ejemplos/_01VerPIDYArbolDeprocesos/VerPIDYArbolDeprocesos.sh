#!/bin/bash
echo $$ # PID de esta bash
ps -o pid,ppid,cmd -p $$ # solo mi bash: PID, PPID y comando (-o elige las columnas)
pstree -p $$ # árbol que cuelga de esta bash
pstree -p | less # árbol completo (muévete con las flechas, sal con q)