# Transaction Service

This microservice is responsible for processing investment transactions and payment integrations. It is built using Java 21, Spring Boot 3.1, and Maven. The service adheres to the 12-factor app principles and is independently deployable.

## Features

- REST API for transaction processing
- Integration with payment gateways
- Transaction logging and auditing
- Configurable application properties

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

2. Navigate to the transaction-service directory:
   ```
   cd transaction-service
   ```

3. Build the project using Maven:
   ```
   mvn clean install
   ```

4. Run the application:
   ```
   mvn spring-boot:run
   ```

5. Access the API at `http://localhost:<port>/api/transactions`.

### Docker

To build and run the Docker container:

1. Build the Docker image:
   ```
   docker build -t transaction-service .
   ```

2. Run the Docker container:
   ```
   docker run -p <port>:<port> transaction-service
   ```

### Configuration

The application configuration can be found in `src/main/resources/application.yml`. You can customize the server port and other properties as needed.

### Testing

Unit tests are located in the `src/test/java/com/cib/transaction` directory. You can run the tests using Maven:
```
mvn test
```

### License

This project is licensed under the Virtusa
