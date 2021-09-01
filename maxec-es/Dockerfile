FROM elasticsearch:7.14.0 as esbuilder

RUN mkdir /app
COPY app/* /app/
RUN chmod +x /app/init.sh
ENV ES_JAVA_OPTS="-Xms2048m -Xmx2048m"
ENV "discovery.type"=single-node
RUN /usr/local/bin/docker-entrypoint.sh elasticsearch -d -E path.data=/tmp/data \
    && for i in $(seq 1 30); do curl http://localhost:9200 >/dev/null 2>&1; [ $? -eq 0 ] && break; echo "waiting $i"; sleep 1 ; done \
    && /app/init.sh


FROM elasticsearch:7.14.0
COPY --from=esbuilder /tmp/data/ /usr/share/elasticsearch/data/

ENV ES_JAVA_OPTS="-Xms2048m -Xmx2048m"
ENV "discovery.type"=single-node