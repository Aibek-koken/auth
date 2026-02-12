# Auth Service

A minimal Spring Boot authentication demo that supports email/password registration and login using PostgreSQL.

## Tech Stack
- Java 17
- Spring Boot 4 (Spring MVC, Spring Data JPA)
- PostgreSQL
- Maven

## Requirements
- Java 17+
- PostgreSQL running locally
- Maven (or use the Maven wrapper)

## Quick Start
1. Create a database named `demo_db` and update credentials in `src/main/resources/application.properties`.
2. Start the app:

```bash
./mvnw spring-boot:run
```

3. The service runs on `http://localhost:8080` by default.

## Configuration
Key settings live in `src/main/resources/application.properties`.

- `server.port=8080`
- `spring.datasource.url=jdbc:postgresql://localhost:5432/demo_db`
- `spring.datasource.username=postgres`
- `spring.datasource.password=123456`
- `spring.jpa.hibernate.ddl-auto=update`

## API
All endpoints are under `/auth` and accept `application/x-www-form-urlencoded` parameters.

- `POST /auth/register`
- `POST /auth/login`

Example:

```bash
curl -X POST \
  -d "email=test@example.com" \
  -d "password=secret" \
  http://localhost:8080/auth/register
```

```bash
curl -X POST \
  -d "email=test@example.com" \
  -d "password=secret" \
  http://localhost:8080/auth/login
```

## Test UI
A simple HTML page is available at `src/main/resources/static/test.html` and is served by Spring Boot at:

- `http://localhost:8080/test.html`

## Notes
- Passwords are stored in plaintext in the database. This is a demo only.
- There is no session, token, or password hashing logic yet.
