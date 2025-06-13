# Students Security

This project is a Spring Boot application for student management with integrated security.

**Main goal:** Understand session and cookie management in secure web applications using Spring Boot.

## Features

- Student management (CRUD)
- Authentication and authorization
- Database integration
- Session and cookie handling

## Requirements

- Java 17+
- Maven 3.8+
- Spring Boot

## Installation

1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Enter the project directory:
   ```bash
   cd students-security
   ```
3. Build the project:
   ```bash
   mvn clean install
   ```

## Running

```bash
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`.

## Project Structure

- `src/main/java`: Main source code
- `src/main/resources`: Configuration and resource files

## Configuration

Before running the application, copy `src/main/resources/application.example.yml` to `src/main/resources/application.yml` and update it with your specific configuration (e.g., database connection).
