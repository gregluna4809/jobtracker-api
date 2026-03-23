# 📋 Job Tracker API

> A production-style REST API built with **Spring Boot** and **PostgreSQL** for tracking job applications from application through offer.

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=flat-square&logo=spring-boot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=flat-square&logo=postgresql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat-square&logo=apache-maven&logoColor=white)
![Status](https://img.shields.io/badge/Status-Active-brightgreen?style=flat-square)

---

## 📖 Overview

Job Tracker API is a backend service for managing job applications using a **database-first approach**. It emphasizes clean architecture, data integrity, and real-world backend development practices — including schema validation, DTO separation, and centralized error handling.

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot |
| ORM | Spring Data JPA (Hibernate) |
| Database | PostgreSQL |
| Build Tool | Maven |
| Validation | Jakarta Validation |

---

## 🏗️ Architecture

The application follows a strict **layered architecture**:

```
Controller → Service → Repository → Database
```

**Key design decisions:**

- 📌 Database schema is **manually defined** (no auto-generation)
- 🔒 Hibernate runs in **`validate` mode** to enforce schema integrity
- 📦 **DTOs** cleanly separate API contracts from internal entities
- ✅ **Jakarta Validation** enforces constraints on all incoming requests
- 🌐 **Centralized exception handling** delivers consistent JSON error responses

---

## 🗄️ Database

**Database:** `jobtracker` &nbsp;|&nbsp; **Table:** `job_applications`

| Column | Type | Notes |
|---|---|---|
| `id` | `BIGSERIAL` | Primary key, auto-increment |
| `company` | `VARCHAR` | Required |
| `job_title` | `VARCHAR` | Required |
| `status` | `ENUM` | `APPLIED` · `INTERVIEWING` · `OFFER` · `REJECTED` · `WITHDRAWN` |
| `location` | `VARCHAR` | Optional |
| `salary` | `NUMERIC` | Optional |
| `date_applied` | `DATE` | Required |
| `job_url` | `VARCHAR` | Optional |
| `notes` | `TEXT` | Optional |
| `created_at` | `TIMESTAMP` | Auto-set on insert |
| `updated_at` | `TIMESTAMP` | Auto-set on update |

---

## 🔌 API Endpoints

**Base URL:** `http://localhost:8080/api/applications`

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/applications` | Retrieve all applications |
| `GET` | `/api/applications/{id}` | Retrieve a single application |
| `POST` | `/api/applications` | Create a new application |
| `PUT` | `/api/applications/{id}` | Update an existing application |
| `DELETE` | `/api/applications/{id}` | Delete an application |

---

## ✅ Validation

All incoming requests are validated using **Jakarta Validation**. Violations return a structured `400 Bad Request` response:

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
```

**Enforced rules include:**
- Required field presence
- String length constraints
- Numeric range validation for salary

---

## ⚠️ Error Handling

All errors return a consistent JSON structure with:

- Appropriate **HTTP status codes**
- Human-readable **error messages**
- Field-level **validation details** where applicable

---

## ⚙️ Configuration

Key settings in `application.properties`:

```properties
# Validate schema on startup — no auto-DDL changes
spring.jpa.hibernate.ddl-auto=validate

# Disable open session in view anti-pattern
spring.jpa.open-in-view=false
```

---

## 🚀 Running the Application

From the project root:

```bash
./mvnw spring-boot:run
```

> **Windows users:** use `mvnw.cmd spring-boot:run`

The application will start at: **[http://localhost:8080](http://localhost:8080)**

---

## 📊 Current Status

- [x] Fully functional CRUD API
- [x] PostgreSQL integration
- [x] DTO-based architecture
- [x] Request validation
- [x] Global exception handling
- [x] Clean layered design

---

## 🗺️ Roadmap

- [ ] Filtering and search endpoints
- [ ] React frontend
- [ ] Deploy backend to AWS
- [ ] Connect to AWS RDS
- [ ] Host frontend on S3 + CloudFront

---

## 👤 Author

**Gregory Luna**