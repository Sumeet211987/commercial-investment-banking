FROM openjdk:21-jdk-slim


# Copy the source code
COPY target/*.jar portfolio-service-1.0.0.jar


# Expose the port the service runs on
EXPOSE 8085

# Run the application
CMD ["java", "-jar", "portfolio-service-1.0.0.jar"]