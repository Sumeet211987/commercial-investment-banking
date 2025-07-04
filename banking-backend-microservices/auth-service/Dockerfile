FROM openjdk:21-jdk-slim


# Copy the source code
COPY target/*.jar auth-service.jar


# Expose the port the service runs on
EXPOSE 8082

# Run the application
CMD ["java", "-jar", "auth-service.jar"]