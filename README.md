# TaskFlow API

A RESTful backend service for task management built with Spring Boot. This project is a practical application of Spring Data JPA and layered architecture.

## Features
* Task CRUD operations (In progress)
* Persistent storage with H2 in-memory database
* Automated data seeding on startup

## Technology Stack
* Java 17
* Spring Boot 3
* Spring Data JPA
* H2 Database
* Gradle

## How to Run
1. Clone the repository.
2. Run `./gradlew bootRun` or start the application from your IDE.
3. The API will be available at `http://localhost:8080/api/tasks`.

## Current Status
Working on implementing full CRUD functionality. Layered architecture is being established to separate concerns between controllers and repositories.
