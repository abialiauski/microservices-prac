FROM openjdk:17-alpine

ENV TZ=Europe/Minsk
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ARG JAR_FILE=build/libs/user-crud-0.0.1-SNAPSHOT.jar
ARG JAR_LIB_FILE=build/libs

WORKDIR /usr/local/runme

COPY ${JAR_FILE} mycrudms.jar

ADD ${JAR_LIB_FILE} lib/

EXPOSE 9000
ENTRYPOINT ["java", "-jar", "mycrudms.jar"]
