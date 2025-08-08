# Konecta Task 2 - Convertly

A RESTful API for converting between measurement units in categories like **length**, **temperature**, **weight**, and **time**.  
This is the second task for the [Konecta](https://konecta.com/) fullstack development internship.

## Table of Contents

- [Overview](#overview)
  - [The API Description](#the-api-description)
  - [Main Endpoints](#main-endpoints)
- [Getting Started](#getting-started)
  - [Run Locally](#run-locally)
  - [Swagger UI](#swagger-ui)
  - [Postman Collection](#postman-collection)
- [Project Structure](#project-structure)
- [My Process](#my-process)
  - [Built With](#built-with)
  - [Useful Resources](#useful-resources)
- [Author](#author)

---

## Overview

### The API Description

Users can:

- Convert between measurement units across **4 categories**:
  - Length (e.g., meters to miles)
  - Temperature (e.g., Celsius to Fahrenheit)
  - Time (e.g., hours to seconds)
  - Weight (e.g., kilograms to pounds)
- Download conversion history (per session) as **JSON**
- Check service health
- List all available **categories** and **units**
- Generate a sample request body for conversion

### Main Endpoints

| Method | Path                | Description                                 |
| ------ | ------------------- | ------------------------------------------- |
| POST   | `/convert`          | Perform a unit conversion                   |
| GET    | `/categories`       | Get all conversion categories               |
| GET    | `/units?category=X` | Get all units in the given category         |
| GET    | `/sample-payload`   | Get a sample conversion request body        |
| GET    | `/health`           | Service health check                        |
| GET    | `/history/json`     | Download session conversion history in JSON |

---

## Getting Started

### Run Locally

> You can run the app directly in **VSCode** using the run button, or via the command line.

**Requirements**:

- Java 17+
- Maven

**Run command:**

```bash
mvn spring-boot:run
```

Or manually via Java:

```bash
java -jar target/convertly-0.0.1-SNAPSHOT.jar
```

### Swagger UI

The API is documented using Swagger (OpenAPI):

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

You’ll find example requests, response schemas, and error codes there.

### Postman Collection

A Postman collection with sample requests is included here:

[`Convertly.postman_collection.json`](./Convertly.postman_collection.json)

---

## Project Structure

```
src/
├── main/
│   ├── java/com/konecta/internship/convertly/
│   │   ├── controller/        # REST controllers
│   │   ├── enums/             # Supported categories & units
│   │   ├── exception/         # Custom exceptions & handlers
│   │   ├── model/             # Request/Response/Record models
│   │   ├── service/           # Business logic & conversion handling
│   │   └── validation/        # Custom annotations & validators
│   └── resources/
│       └── application.properties
└── test/
    └── ConvertlyApplicationTests.java
```

---

## My Process

### Built With

- **Java 17**
- **Spring Boot**
- **Spring Validation (Jakarta)**
- **Swagger (Springdoc OpenAPI)**
- **Postman** (for testing)

### Useful Resources

#### Spring Boot

- [Marco Codes Spring Boot Tutorial](https://www.youtube.com/watch?v=QuvS_VLbGko)

#### Validation

- [Enum Validation](https://www.baeldung.com/javax-validations-enums#any-of-validation)
- [Custom Validation](https://www.baeldung.com/spring-mvc-custom-validator)
- [Cross-field Validation](https://medium.com/@sanyal.s271/implementing-cross-field-validations-in-spring-boot-applications-3a8f61183bd0)

#### Swagger

- [OpenAPI with Spring Boot](https://www.baeldung.com/spring-rest-openapi-documentation)

---

## Author

- **Mohanad Ahmed**
- [Portfolio Website](https://mohanad-80.github.io/new-portfolio/)

---

> Note: This API does not persist any data. All conversion history is kept in-memory per session and is lost when the server restarts.
