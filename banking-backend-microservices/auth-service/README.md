# Auth Service

This microservice is responsible for handling authentication and authorization for the banking backend application. It provides endpoints for user login, registration, and token management.

## Features

- User authentication
- Token generation and validation
- Role-based access control

## Getting Started

### Prerequisites

- Java 21
- Maven
- Docker

### Running the Service

1. Clone the repository:
   ```
   git clone <repository-url>
   cd auth-service
   ```

2. Build the project using Maven:
   ```
   mvn clean install
   ```

3. Run the application:
   ```
   mvn spring-boot:run
   ```

### Docker

To build and run the Docker container:

1. Build the Docker image:
   ```
   docker build -t auth-service .
   ```

2. Run the Docker container:
   ```
   docker run -p 8081:8081 auth-service
   ```

### API Endpoints

- `POST /api/auth/login`: Authenticate user and return a token.
- `POST /api/auth/register`: Register a new user.

### Configuration

The application configuration can be found in `src/main/resources/application.yml`. You can customize the server port and other settings there.

### Testing

Unit tests are located in the `src/test/java/com/cib/auth` directory. You can run the tests using:
```
mvn test
```

### License

This project is licensed under the Virtusa.
