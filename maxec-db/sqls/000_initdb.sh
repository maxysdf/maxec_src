#!/bin/bash
set -e
base="$( cd "$( dirname "${BASH_SOURCE[0]}" )"/. && pwd )"

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE USER ${DBUSER} with encrypted password '${DBPASS}';
    CREATE DATABASE ${DBNAME};
    GRANT ALL PRIVILEGES ON DATABASE ${DBNAME} TO ${DBUSER};
EOSQL