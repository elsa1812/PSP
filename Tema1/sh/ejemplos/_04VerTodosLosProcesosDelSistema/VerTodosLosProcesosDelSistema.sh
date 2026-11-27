#!/bin/bash
#Ver todos
ps -ef | head -15 # System V: todos (-e) en formato completo (-f)
ps aux | head -15 # BSD: añade %CPU, %MEM y el estado (STAT)
ps -ef | wc -l # ¿cuántos procesos hay ahora mismo?

#Ver uno concreto
ps -ef | grep bash # todas las líneas que contienen "bash"
pgrep -a bash # PID y comando de cada proceso llamado bash