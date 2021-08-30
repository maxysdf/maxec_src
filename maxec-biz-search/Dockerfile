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
    "-Dspring.datasource.url=${DBURL}", \
    "-Dspring.datasource.driver-class-name=${DBDRV}", \
    "-Dspring.datasource.username=${DBUSER}", \
    "-Dspring.datasource.password=${DBPASS}", \
    "-Dspring.jpa.properties.hibernate.dialect=${DBDIALECT}", \
    "-jar","/app.jar" \
]

EXPOSE 13200