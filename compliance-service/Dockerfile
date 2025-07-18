#Docker File content
#run application in java version
FROM openjdk:21-jdk-slim
COPY target/*.jar compliance-service.jar

EXPOSE 8085

#execute the JAR file
ENTRYPOINT ["java", "-jar", "compliance-service.jar"]