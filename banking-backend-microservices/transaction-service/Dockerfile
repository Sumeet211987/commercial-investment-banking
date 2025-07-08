#Docker File content

#run application in java version

FROM maven:3.9.6-eclipse-temurin-21 AS build

# Package the application

RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim

#path from jar file to docker container

COPY target/*.jar transaction-service.jar

##WorkDIR Docker JAR available

#WORKDIR /Users/LAKSHMI/AppData/Local/Docker

# Expose the port the application runs on

EXPOSE 8085

#execute the JAR file

ENTRYPOINT ["java", "-jar", "transaction-service.jar"]