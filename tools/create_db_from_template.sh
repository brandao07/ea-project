#!/bin/bash

# Define file paths
TEMPLATE_FILE="./templates/database_template"
TABLES_SQL_FILE="../vp-codigo/AASICProject_table_create.sql"
PRIMARY_KEYS_SQL_FILE="../vp-codigo/AASICProject_pk_create.sql"
FOREIGN_KEYS_SQL_FILE="../vp-codigo/AASICProject_fk_create.sql"
FINAL_SQL_FILE="../app/backend/initdb/database.sql"

# Function to check if a file exists
check_file_exists() {
    if [[ ! -f $1 ]]; then
        echo "Error: File '$1' does not exist."
        exit 1
    fi
}

# Check if all required files exist
check_file_exists $TEMPLATE_FILE
check_file_exists $TABLES_SQL_FILE
check_file_exists $PRIMARY_KEYS_SQL_FILE
check_file_exists $FOREIGN_KEYS_SQL_FILE

# Read the content of the SQL files
TABLES_SQL=$(cat $TABLES_SQL_FILE)
PRIMARY_KEYS_SQL=$(cat $PRIMARY_KEYS_SQL_FILE)
FOREIGN_KEYS_SQL=$(cat $FOREIGN_KEYS_SQL_FILE)

# Read the content of the template file
TEMPLATE_CONTENT=$(cat $TEMPLATE_FILE)

# Replace the placeholders with the actual SQL content
FINAL_SQL="${TEMPLATE_CONTENT//\{\{@Tables\}\}/$TABLES_SQL}"
FINAL_SQL="${FINAL_SQL//\{\{@PrimaryKeys\}\}/$PRIMARY_KEYS_SQL}"
FINAL_SQL="${FINAL_SQL//\{\{@ForeignKeys\}\}/$FOREIGN_KEYS_SQL}"

# Output the final SQL to a new file
echo "$FINAL_SQL" > $FINAL_SQL_FILE

echo "Final SQL script generated and saved as '$FINAL_SQL_FILE'"
