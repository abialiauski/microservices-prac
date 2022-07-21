FROM openjdk:17-alpine

ENV TZ=Europe/Minsk
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ARG JAR_FILE=build/libs/user-microservice-1.0.jar
ARG JAR_LIB_FILE=build/libs

WORKDIR /usr/loca/runme

COPY ${JAR_FILE} myapp.jar

ADD ${JAR_LIB_FILE} lib/

EXPOSE 8090
ENTRYPOINT ["java", "-jar", "myapp.jar"]