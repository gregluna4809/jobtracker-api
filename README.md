# Job Tracker API

Production-style REST API built with Spring Boot and PostgreSQL for tracking job applications.

---

## 🚀 Overview

This project is a backend service designed to manage job applications using a database-first approach. The system emphasizes clean architecture, data integrity, and real-world backend development practices.

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

---

## 🧱 Architecture

The application follows a layered architecture:

Controller → Service → Repository → Database

Key design decisions:

- Database schema is manually defined (no auto-generation)
- Hibernate is configured in **validate mode**
- DTOs are used to separate API contracts from entities
- Validation is enforced at the request level
- Centralized exception handling for consistent error responses

---

## 🗄️ Database

Database: `jobtracker`

Table: `job_applications`

Key fields:

- id (BIGSERIAL PRIMARY KEY)
- company
- job_title
- status (APPLIED, INTERVIEWING, OFFER, REJECTED, WITHDRAWN)
- location
- salary
- date_applied
- job_url
- notes
- created_at
- updated_at

---

## 📡 API Endpoints

Base URL:
http://localhost:8080/api/applications

### GET all applications
GET /api/applications

---

### GET application by ID
GET /api/applications/{id}

---

### CREATE application
POST /api/applications

---

### UPDATE application
PUT /api/applications/{id}

---

### DELETE application
DELETE /api/applications/{id}

---

## ✅ Validation

Requests are validated using Jakarta Validation:

- Required fields enforced
- String length constraints
- Numeric validation for salary

Example validation response:

```json
{
  "error": "Bad Request",
  "message": "Validation failed",
  "status": 400,
  "validationErrors": {
    "company": "Company must be between 1 and 150 characters",
    "status": "Status is required"
  }
}
⚠️ Error Handling

Global exception handling ensures:

Consistent JSON error responses
Proper HTTP status codes
Clear error messaging
🔧 Configuration

Key settings in application.properties:
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.open-in-view=false

▶️ Running the Application

From project root:
mvnw.cmd spring-boot:run

Application will start on:
http://localhost:8080

📌 Current Status

✔ Fully functional CRUD API
✔ PostgreSQL integration
✔ DTO-based architecture
✔ Request validation
✔ Global exception handling
✔ Clean layered design

🚧 Next Steps
Add filtering/search endpoints
Build React frontend
Deploy backend to AWS
Connect to AWS RDS
Host frontend on S3 + CloudFront

👤 Author

Gregory Luna