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
    "-Dapp.api.product.endpoint=${API_PRODUCT_ENDPOINT}", \
    "-Dapp.api.search.endpoint=${API_SEARCH_ENDPOINT}", \
    "-Dapp.api.shopping.endpoint=${API_SHOPPING_ENDPOINT}", \
    "-Dapp.api.content.endpoint=${API_CONTENT_ENDPOINT}", \
    "-Dapp.api.customer.endpoint=${API_CUSTOMER_ENDPOINT}", \
    "-jar","/app.jar" \
]

EXPOSE 12000