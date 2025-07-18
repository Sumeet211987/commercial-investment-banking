FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Maven build file
COPY pom.xml .

# Copy the source code
COPY src ./src

# Package the application
RUN ./mvnw clean package -DskipTests

# Expose the port the service runs on
EXPOSE 8082

# Run the application
CMD ["java", "-jar", "target/audit-service-0.0.1-SNAPSHOT.jar"]