# Compliance Service

This microservice is responsible for ensuring compliance with KYC (Know Your Customer) and AML (Anti-Money Laundering) regulations. It provides endpoints to manage compliance checks and store relevant data.

## Features

- **KYC Verification**: Validate user identities against regulatory requirements.
- **AML Monitoring**: Monitor transactions for suspicious activities.
- **Audit Logging**: Maintain logs of compliance checks and actions taken.

## Getting Started

To run the Compliance Service locally, follow these steps:

1. **Clone the repository**:
   ```
   git clone <repository-url>
   cd compliance-service
   ```

2. **Build the project**:
   ```
   mvn clean install
   ```

3. **Run the application**:
   ```
   mvn spring-boot:run
   ```

4. **Access the API**:
   The service will be available at `http://localhost:<port>/api/compliance`.

## Configuration

The application configuration can be found in `src/main/resources/application.yml`. You can set the server port and other properties as needed.

## Docker

To build and run the Docker container, use the following commands:

1. **Build the Docker image**:
   ```
   docker build -t compliance-service .
   ```

2. **Run the Docker container**:
   ```
   docker run -p <port>:<port> compliance-service
   ```

## Testing

Unit tests are located in the `src/test/java/com/cib/compliance` directory. You can run the tests using:

```
mvn test
```

## License

This project is licensed under the Virtusa
