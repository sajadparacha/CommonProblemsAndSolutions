#FROM eclipse-temurin:17
FROM openjdk

LABEL mentainer="sajadparacha@gmail.com"

WORKDIR /app

COPY target/CommonProblemsAndSolutions-0.0.1-SNAPSHOT.jar /app/CommonProblemsAndSolutions.jar
EXPOSE 8080:8080
ENTRYPOINT ["java", "-jar", "CommonProblemsAndSolutions.jar"]