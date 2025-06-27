FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Maven build file
COPY pom.xml .

# Copy the source code
COPY src ./src

# Package the application
RUN ./mvnw clean package -DskipTests

# Expose the port the application runs on
EXPOSE 8083

# Run the application
CMD ["java", "-jar", "target/fund-manager-service-0.0.1-SNAPSHOT.jar"]