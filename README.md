Job Tracker API

Production-style REST API built with Spring Boot and PostgreSQL for tracking job applications.

Overview

This project is a backend service for managing job applications using a database-first approach. It emphasizes clean architecture, data integrity, and real-world backend development practices.

Tech Stack
Java 21
Spring Boot
Spring Data JPA
PostgreSQL
Maven
Architecture

The application follows a layered architecture:

Controller → Service → Repository → Database

Key design decisions:

Database schema is manually defined
Hibernate is configured in validate mode
DTOs separate API contracts from entities
Validation is enforced on incoming requests
Centralized exception handling provides consistent error responses
Database

Database name: jobtracker

Table name: job_applications

Key fields:

id (BIGSERIAL PRIMARY KEY)
company
job_title
status (APPLIED, INTERVIEWING, OFFER, REJECTED, WITHDRAWN)
location
salary
date_applied
job_url
notes
created_at
updated_at
API Endpoints

Base URL:

http://localhost:8080/api/applications

Get all applications:

GET /api/applications

Get application by ID:

GET /api/applications/{id}

Create application:

POST /api/applications

Update application:

PUT /api/applications/{id}

Delete application:

DELETE /api/applications/{id}

Validation

Requests are validated using Jakarta Validation.

Validation rules include:

Required fields enforced
String length constraints
Numeric validation for salary

Example validation response:

{
"error": "Bad Request",
"message": "Validation failed",
"status": 400,
"validationErrors": {
"company": "Company must be between 1 and 150 characters",
"status": "Status is required"
}
}

Error Handling

Global exception handling provides:

Consistent JSON error responses
Proper HTTP status codes
Clear error messages
Configuration

Key settings in application.properties:

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.open-in-view=false

Running the Application

From the project root:

mvnw.cmd spring-boot:run

Application starts on:

http://localhost:8080

Current Status
Fully functional CRUD API
PostgreSQL integration
DTO-based architecture
Request validation
Global exception handling
Clean layered design
Next Steps
Add filtering and search endpoints
Build React frontend
Deploy backend to AWS
Connect to AWS RDS
Host frontend on S3 and CloudFront
Author

Gregory Luna