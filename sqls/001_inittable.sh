#!/bin/bash
set -e

base="$( cd "$( dirname "${BASH_SOURCE[0]}" )"/. && pwd )"

for s in ${base}/sqls/*.sql; do
    echo "run sql file: $s --------------"
    psql -v ON_ERROR_STOP=1 --username "${DBUSER}" --dbname "${DBNAME}" -f $s
done