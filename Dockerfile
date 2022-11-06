# syntax=docker/dockerfile:1
FROM williamyeh/java8

MAINTAINER horaoen@gmail.com
COPY target/fake-cms-springboot-0.0.1-SNAPSHOT.jar fake-cms-springboot-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/fake-cms-springboot-0.0.1-SNAPSHOT.jar"]

COPY src ./src
CMD ["./mvnw", "spring-boot:run"]
