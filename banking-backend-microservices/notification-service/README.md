# Notification Service README

# Notification Service

This is the Notification Service of the Banking Backend Microservices architecture. It is responsible for sending notifications via SMS, email, and push notifications to users.

## Features

- **REST API**: Provides endpoints for sending notifications.
- **Integration**: Can be integrated with various notification channels.
- **Scalability**: Designed to handle a large volume of notifications.

## Technologies Used

- **Java 21**
- **Spring Boot 3.1**
- **Maven** as the build tool
- **Docker** for containerization

## Directory Structure

```
├── src
│   ├── main
│   │   ├── java/com/cib/notification
│   │   │   ├── NotificationServiceApplication.java
│   │   │   ├── controller
│   │   │   │   └── NotificationController.java
│   │   │   ├── service
│   │   │   │   └── NotificationService.java
│   │   │   └── repository
│   │   │       └── NotificationRepository.java
│   │   └── resources
│   │       └── application.yml
│   └── test/java/com/cib/notification
├── pom.xml
├── Dockerfile
└── .gitignore
```

## Getting Started

1. **Clone the repository**:
   ```
   git clone <repository-url>
   ```

2. **Navigate to the project directory**:
   ```
   cd notification-service
   ```

3. **Build the project**:
   ```
   mvn clean install
   ```

4. **Run the application**:
   ```
   mvn spring-boot:run
   ```

5. **Access the API**: The service will be available at `http://localhost:<port>/api/notifications`.

## Configuration

The application configuration can be found in `src/main/resources/application.yml`. You can set the server port and other properties there.

## Docker

To build the Docker image, run the following command in the project directory:

```
docker build -t notification-service .
```

To run the Docker container:

```
docker run -p <host-port>:<container-port> notification-service
```

## License

This project is licensed under the Virtusa
