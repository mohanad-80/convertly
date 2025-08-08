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
  - [Implementation Details](#implementation-details)
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

### Implementation Details

The validation part was a bit tricky as I needed to validate multiple fields on the request body with conditional validation, so I needed to build a custom validator that checks if the `fromUnit` and `toUnit` belong to the `category` and also if the `value` is valid for that `category` (i.e. negative values for time is invalid, but for temperature it is valid).

I also build a custom validator that can be reused in other places in the project or in other projects. This validator checks if a field's value is of an enum type. This was not available out-of-the-box in Jakarta, so I had to build it myself.

For storing the conversion history I just created a dedicated service for handling this, it stores the history in a Java `List` in memory. The history is deleted whenever the service is restarted, though the same effect can be done with the `clearHistory` method in the service.

Working with enums was tricky, because I couldn't use it as type directly in the request body for fields like `fromUnit` and `toUnit` because I need to know in which category they fall before knowing which enum they will use as their type. And for fields like `category` I could not use the enum as the type directly because when spring uses Jackson it will try to map the category value to the enum type which could be a problem because it will throw an error if the category value is different from the enum in letter casing (i.e. it will refuse values like `time` because it expects `Time` from the enum) which is not the expected behavior of the API.

Setting up swagger UI was easy, but documenting the API endpoints was not. The syntax was new and challenging to me, even though I worked with swagger a lot in Node.Js and Nest.Js but it was my first time with spring boot. I managed to document all APIs with examples for the body request and for the response too along with description for each one.

I created a global exception handler to handle both custom exceptions like `InvalidCategoryException` for when validating the request, and also other validation exceptions and to send them all in a json object, so when the user has multiple issues with validating the request body, he will get all of them at once. 

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
