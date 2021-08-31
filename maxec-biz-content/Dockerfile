FROM nginx:alpine

# nginx env. -----------------------------------
VOLUME ["/data"]
RUN apk add openjdk8
RUN mkdir /usr/share/nginx/html/js
COPY docker_files/nginx.conf /etc/nginx/conf.d/default.conf
COPY docker_files/upload.html /usr/share/nginx/html
COPY docker_files/axios.min.js /usr/share/nginx/html/js
COPY docker_files/run.sh /run.sh
RUN chmod +x /run.sh

# java env. -----------------------------------
ARG JARFILE=target/*.jar
ARG DBURL
ARG DBDRV
ARG DBUSER
ARG DBPASS
ARG DBDIALECT
COPY ${JARFILE} app.jar

CMD ["/run.sh"]

EXPOSE 13400