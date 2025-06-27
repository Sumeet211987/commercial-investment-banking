# Fund Manager Service

This microservice is responsible for managing investment sectors and allocations within the banking backend application. It provides a RESTful API to interact with fund management functionalities.

## Features

- Manage investment sectors
- Allocate funds to different sectors
- Retrieve fund allocation details

## Technologies Used

- Java 21
- Spring Boot 3.1
- Maven
- Docker

## Directory Structure

```
├── src
│   ├── main
│   │   ├── java/com/cib/fundmanager
│   │   │   ├── FundManagerServiceApplication.java
│   │   │   ├── controller
│   │   │   │   └── FundManagerController.java
│   │   │   ├── service
│   │   │   │   └── FundManagerService.java
│   │   │   └── repository
│   │   │       └── FundManagerRepository.java
│   │   └── resources
│   │       └── application.yml
│   └── test/java/com/cib/fundmanager
├── pom.xml
├── Dockerfile
├── .gitignore
```

## Getting Started

1. Clone the repository:
   ```
   git clone <repository-url>
   ```

2. Navigate to the `fund-manager-service` directory:
   ```
   cd fund-manager-service
   ```

3. Build the project using Maven:
   ```
   mvn clean install
   ```

4. Run the application:
   ```
   mvn spring-boot:run
   ```

5. Access the API at `http://localhost:<port>/api/fund-manager`.

## API Documentation

Refer to the API documentation for details on available endpoints and request/response formats.

## License

This project is licensed under the Virtusa
