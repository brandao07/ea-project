#!/bin/bash

# Define as paths de origem
SOURCE_LIB="../vp-codigo/lib/orm.jar"
SOURCE_ORM_CFG="../vp-codigo/src/ormmapping/AASICProject.cfg.xml"
SOURCE_ORM="../vp-codigo/src/orm/"
SOURCE_DAO="../vp-codigo/src/eaproject/dao/"

# Define as paths de destino
TARGET_LIB="../app/backend/src/main/java/lib/"
TARGET_ORM="../app/backend/src/main/java/orm/"
TARGET_ORM_CFG="../app/backend/src/main/resources/ormmapping/"
TARGET_DAO="../app/backend/src/main/java/eaproject/dao/"

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
echo "A limpar diretórios de destino..."
sudo chmod -R 777 "$TARGET_LIB"
sudo chmod -R 777 "$TARGET_ORM"
sudo chmod -R 777 "$TARGET_ORM_CFG"
sudo chmod -R 777 "$TARGET_DAO"
sudo rm -rf $TARGET_LIB*
sudo rm -rf $TARGET_ORM*
sudo rm -rf $TARGET_ORM_CFG*
sudo rm -rf $TARGET_DAO*

# Verificar se os arquivos foram realmente apagados
if [ "$(ls -A $TARGET_LIB)" ]; then
  echo "Erro: $TARGET_LIB não está vazio após tentar apagar."
  exit 1
fi
if [ "$(ls -A $TARGET_ORM)" ]; then
  echo "Erro: $TARGET_ORM não está vazio após tentar apagar."
  exit 1
fi
if [ "$(ls -A $TARGET_ORM_CFG)" ]; then
  echo "Erro: $TARGET_ORM_CFG não está vazio após tentar apagar."
  exit 1
fi
if [ "$(ls -A $TARGET_DAO)" ]; then
  echo "Erro: $TARGET_DAO não está vazio após tentar apagar."
  exit 1
fi

# Criar diretórios de destino caso não existam
sudo mkdir -p "$TARGET_LIB"
sudo mkdir -p "$TARGET_ORM"
sudo mkdir -p "$TARGET_ORM_CFG"
sudo mkdir -p "$TARGET_DAO"

# Copiar arquivos do local de origem para o destino
echo "A copiar arquivos..."
sudo cp -r $SOURCE_LIB* "$TARGET_LIB"
sudo cp -r $SOURCE_ORM_CFG* "$TARGET_ORM_CFG"
sudo cp -r $SOURCE_ORM* "$TARGET_ORM"
sudo cp -r $SOURCE_DAO* "$TARGET_DAO"

echo "Cópia concluída com sucesso!"
