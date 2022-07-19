FROM openjdk:11-slim as build
WORKDIR user-crud
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} user-crud.jar
RUN java -Djarmode=layertools -jar user-crud.jar extract