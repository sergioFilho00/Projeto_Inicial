#!/bin/bash

ARQUIVO_ORIGEM="/mnt/c/Users/a933760/OneDrive - ATOS/Projeto Inicial/ProjetoInicial/src/main/users.json"
PASTA_BACKUP="/mnt/c/Users/a933760/OneDrive - ATOS/Projeto Inicial/ProjetoInicial/src/main/backups"
DATA=$(date +"%Y-%m-%d_%H-%M-%S")
ARQUIVO_DESTINO="$PASTA_BACKUP/backup_$DATA.json"

if [ ! -d "$PASTA_BACKUP" ]; then
	mkdir -p "$PASTA_BACKUP"
fi

cp "$ARQUIVO_ORIGEM" "$ARQUIVO_DESTINO"

if [ $? -eq 0 ]; then
	echo "Backup realizado com sucesso: $ARQUIVO_DESTINO"
else
	echo "Erro ao fazer backup do arquivo: $ARQUIVO_ORIGEM"
	exit 1
fi
