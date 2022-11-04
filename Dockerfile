# syntax=docker/dockerfile:1
FROM openjdk:8-jdk-alpine

MAINTAINER horaoen@gmail.com

WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve

COPY src ./src
CMD ["./mvnw", "spring-boot:run"]
