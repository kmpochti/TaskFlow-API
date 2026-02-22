# TaskFlow API

A RESTful backend service for task management built with Spring Boot. This project is a practical application of Spring Data JPA, layered architecture, and containerized database management.

## Features
* Task CRUD operations (In progress)
* Persistent storage with **PostgreSQL**
* Containerized environment using **Docker**
* Layered architecture (Controller, Service, Repository)

## Technology Stack
* **Java 17**
* **Spring Boot 3**
* **Spring Data JPA** (Hibernate)
* **PostgreSQL 15** (Database)
* **Docker & Docker Compose**
* **Gradle**

## How to Run
1. **Ensure Docker Desktop is running** on your machine.
2. Clone the repository.
3. Start the database container using: docker-compose up -d
4. Run ./gradlew bootRun or start the application from your IDE.
5. The API will be available at http://localhost:8080/api/tasks.