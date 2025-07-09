FROM openjdk:21-jdk-slim


# Copy the source code
COPY target/*.jar user-service.jar


# Expose the port the service runs on
EXPOSE 8081

# Run the application
CMD ["java", "-jar", "user-service.jar"]