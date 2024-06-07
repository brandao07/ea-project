#!/bin/bash

# Define as paths de origem
SOURCE_LIB="../vp-codigo/lib/orm.jar"
SOURCE_ORM_CFG="../vp-codigo/src/ormmapping/AASICProject.cfg.xml"
SOURCE_ORM="../vp-codigo/src/orm/*"
SOURCE_DAO="../vp-codigo/src/eaproject/dao/*"

# Define as paths de destino
TARGET_LIB="../ea-project/aplicação/backend/src/main/java/lib"
TARGET_ORM="../ea-project/aplicação/backend/src/main/java/orm"
TARGET_ORM_CFG="../ea-project/aplicação/backend/src/main/resources/ormmapping"
TARGET_DAO="../ea-project/aplicação/backend/src/main/java/eaproject/dao"

# Função para validar a existência dos arquivos de origem
validate_files() {
  if [ ! -e "$1" ]; then
    echo "Erro: Arquivo ou diretório de origem $1 não existe."
    exit 1
  fi
}

# Validar arquivos de origem
validate_files "$SOURCE_LIB"
validate_files "$SOURCE_ORM_CFG"
validate_files "$SOURCE_ORM"
validate_files "$SOURCE_DAO"

# Apagar arquivos existentes no destino
echo "Limpando diretórios de destino..."
rm -rf "$TARGET_LIB"/*
rm -rf "$TARGET_ORM"/*
rm -rf "$TARGET_ORM_CFG"/*
rm -rf "$TARGET_DAO"/*

# Criar diretórios de destino caso não existam
mkdir -p "$TARGET_LIB"
mkdir -p "$TARGET_ORM"
mkdir -p "$TARGET_ORM_CFG"
mkdir -p "$TARGET_DAO"

# Copiar arquivos do local de origem para o destino
echo "Copiando arquivos..."
cp "$SOURCE_LIB" "$TARGET_LIB"
cp "$SOURCE_ORM_CFG" "$TARGET_ORM_CFG"
cp -r $SOURCE_ORM "$TARGET_ORM"
cp -r $SOURCE_DAO "$TARGET_DAO"

echo "Cópia concluída com sucesso!"
