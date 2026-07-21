FROM eclipse-temurin:8-jre

WORKDIR /app

COPY target/docker-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

#FROM maven:3.9.4-eclipse-temurin-21-alpine
#
#WORKDIR /app
#
#COPY ./target/docker-service-0.0.1-SNAPSHOT.jar .
#
#EXPOSE 8080
#
#CMD ["java", "-jar", "docker-service-0.0.1-SNAPSHOT.jar"]

#COPY .mvn/ .mvn
#COPY mvnw pom.xml ./
#RUN ./mvnw dependency:go-offline
#
#COPY src ./src
#
#CMD ["./mvnw", "spring-boot:run"]