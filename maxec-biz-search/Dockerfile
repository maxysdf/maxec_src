FROM openjdk:8-jdk-alpine

ARG JARFILE=target/*.jar
ARG DBURL
ARG DBDRV
ARG DBUSER
ARG DBPASS
ARG DBDIALECT
COPY ${JARFILE} app.jar
ENTRYPOINT [ \
    "java", \
    "-Dapp.es.hosts=${ES_HOST}:${ES_PORT}", \
    "-jar","/app.jar" \
]

EXPOSE 13200