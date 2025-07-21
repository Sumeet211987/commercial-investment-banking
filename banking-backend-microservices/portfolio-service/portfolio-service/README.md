# Portfolio Service

The Portfolio Service is a microservice responsible for tracking and displaying user investment portfolios. It is built using Java 21 and Spring Boot 3.1, following the 12-factor app principles. This service is independently deployable and can be easily integrated with other services in the banking backend ecosystem.

## Features

- Manage user investment portfolios
- RESTful API for portfolio operations
- Docker containerization for easy deployment

## Getting Started

### Prerequisites

- Java 21
- Maven
- Docker

### Running the Service

1. Clone the repository:
   ```
   git clone <repository-url>
   ```

2. Navigate to the portfolio-service directory:
   ```
   cd portfolio-service
   ```

3. Build the project using Maven:
   ```
   mvn clean install
   ```

4. Run the application:
   ```
   mvn spring-boot:run
   ```

5. Access the API at `http://localhost:<port>/api/portfolio`

### Configuration

The application configuration can be found in `src/main/resources/application.yml`. You can customize the server port and other properties as needed.

### Docker

To build the Docker image, run:
```
docker build -t portfolio-service .
```

To run the Docker container:
```
docker run -p <host-port>:<container-port> portfolio-service
```

## API Documentation

Refer to the API documentation for details on available endpoints and request/response formats.

## License

This project is licensed under the Virtusa
