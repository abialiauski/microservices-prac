FROM openjdk:17-alpine

ENV TZ=Europe/Minsk
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ARG JAR_FILE=build/libs/post-vertx-0.0.1-SNAPSHOT.jar
ARG JAR_LIB_FILE=build/libs

WORKDIR /usr/local/runme

COPY ${JAR_FILE} vertxservice.jar

ADD ${JAR_LIB_FILE} lib/

EXPOSE 8705
ENTRYPOINT ["java", "-jar", "vertxservice.jar"]
