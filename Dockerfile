FROM openjdk:8-jdk-alpine
ARG JARFILE=maxec-app-frontend/target/*.jar
COPY ${JARFILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]