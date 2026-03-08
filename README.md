# TaskFlow API

A production-ready Task Management API built with Spring Boot 3, engineered for scalability and maintainability. This project demonstrates advanced backend expertise through Clean Architecture, comprehensive test coverage (JUnit/Mockito), and automated database auditing, all orchestrated within a Docker environment.

## Features
* Full Task CRUD Operations
* Persistent storage with PostgreSQL
* Professional Error Handling with JSON Responses
* Interactive Swagger UI Documentation
* Unit Testing with JUnit 5 and Mockito
* Containerized database environment using Docker
* Automated JPA Auditing and Timestamps
* Layered architecture (Controller, Service, Repository)
* Data Validation using Jakarta Bean Validation
* DTO Pattern for secure data transfer

## Technology Stack
* Java 17
* Spring Boot 3
* Spring Data JPA
* PostgreSQL 15
* Docker / Docker Compose
* Mockito & JUnit 5
* SpringDoc OpenAPI
* Gradle

## How to Run
1. Ensure Docker Desktop is running on your machine.
2. Clone the repository.
3. Start the database container using: docker-compose up -d
4. Run ./gradlew bootRun or start the application from your IDE.
5. The API will be available at http://localhost:8080/api/tasks.
6. Swagger UI: http://localhost:8080/swagger-ui/index.html
