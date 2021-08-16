FROM postgres:11
ENV POSTGRES_PASSWORD=na

RUN mkdir -p /docker-entrypoint-initdb.d/sqls
COPY sqls/*.sql /docker-entrypoint-initdb.d/sqls/
COPY sqls/*.sh /docker-entrypoint-initdb.d/

ENV DBROOT=postgres
ENV DBNAME=maxec
ENV DBUSER=maxec
ENV DBPASS=maxec