FROM  openjdk:14-alpine
VOLUME /tmp
EXPOSE 8085
COPY target/HmoAppProfileWebService.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JxAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]