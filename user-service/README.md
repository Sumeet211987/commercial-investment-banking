# User Service

This is the User Service of the Banking Backend Microservices architecture. It is responsible for managing user and company profiles onboarding.

## Features

- **User Management**: Create, update, delete, and retrieve user profiles.
- **REST API**: Exposes a RESTful API for interaction with other services and clients.
- **Spring Boot**: Built using Spring Boot 3.1, leveraging its features for rapid development.
- **Maven**: Uses Maven as the build tool for dependency management and project structure.
- **Docker**: Containerized using Docker for easy deployment and scalability.

## Getting Started

### Prerequisites

- Java 21
- Maven
- Docker

### Running the Application

1. Clone the repository:
   ```
   git clone <repository-url>
   cd user-service
   ```

2. Build the application:
   ```
   mvn clean install
   ```

3. Run the application:
   ```
   mvn spring-boot:run
   ```

### Configuration

The application configuration can be found in `src/main/resources/application.yml`. You can set the server port and other properties there.

### API Endpoints

- `POST /users`: Create a new user
- `GET /users/{id}`: Retrieve user details
- `PUT /users/{id}`: Update user information
- `DELETE /users/{id}`: Delete a user

### Docker

To build the Docker image, run:
```
docker build -t user-service .
```

To run the Docker container:
```
docker run -p 8080:8080 user-service
```

## License

This project is licensed under the Virtusa
