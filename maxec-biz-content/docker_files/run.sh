#!/bin/sh

# start WEB
nginx -g 'daemon off;' &

# start AP
java \
  -Dspring.datasource.url=${DBURL} \
  -Dspring.datasource.driver-class-name=${DBDRV} \
  -Dspring.datasource.username=${DBUSER} \
  -Dspring.datasource.password=${DBPASS} \
  -Dspring.jpa.properties.hibernate.dialect=${DBDIALECT} \
  -Dapp.data.basedir=/data \
  -jar /app.jar