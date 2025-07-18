# Audit Service README

# Audit Service

The Audit Service is a microservice responsible for logging events for auditing and compliance purposes in the banking backend system. This service adheres to the 12-factor app principles and is independently deployable.

## Features

- Logs events related to user actions and system processes.
- Provides RESTful API endpoints for event logging.
- Configurable logging levels and formats through `application.yml`.

## Technology Stack

- Java 21
- Spring Boot 3.1
- Maven
- Docker

## Directory Structure

```
├── src
│   ├── main
│   │   ├── java/com/cib/audit
│   │   │   ├── AuditServiceApplication.java
│   │   │   ├── controller
│   │   │   │   └── AuditController.java
│   │   │   ├── service
│   │   │   │   └── AuditService.java
│   │   │   └── repository
│   │   │       └── AuditRepository.java
│   │   └── resources
│   │       └── application.yml
│   └── test/java/com/cib/audit
├── pom.xml
├── Dockerfile
└── .gitignore
```

## Getting Started

1. Clone the repository:
   ```
   git clone <repository-url>
   cd audit-service
   ```

2. Build the project using Maven:
   ```
   mvn clean install
   ```

3. Run the application:
   ```
   mvn spring-boot:run
   ```

4. Access the API at `http://localhost:<port>/api/audit`.

## Configuration

The service configuration can be found in `src/main/resources/application.yml`. You can set the server port and other properties as needed.

## Docker

To build the Docker image, run:
```
docker build -t audit-service .
```

To run the Docker container:
```
docker run -p <host-port>:<container-port> audit-service
```

## License

This project is licensed under the Virtusa
