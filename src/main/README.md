# Course Registration System

A RESTful backend application built with Java and Spring Boot for managing students, courses, and course registrations.

## Features

- Register and manage students.
- Create, retrieve, update, and delete courses.
- Register students for courses.
- Check course capacity before registration.
- Prevent duplicate active registrations.
- Cancel registrations while preserving registration history.
- Handle exceptions and return meaningful API error responses.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST API
- VS Code

## Prerequisites

Make sure you have installed:

- Java JDK
- MySQL Server
- Maven, or use the included Maven Wrapper

## Database Configuration

1. Create a MySQL database named `course_registration_system`.
2. Configure your database connection in `src/main/resources/application.properties`.
3. Supply database credentials through environment variables.


## Running the Application

From the project root, run:

On Windows, use:

```powershell
.\mvnw.cmd spring-boot:run

The application runs on port `8088`, if configured as described in the project.

Base URL:

`http://localhost:8088`

## API Endpoints

Update these examples if your controller mappings differ.

| Method         Endpoint        Purpose
|
| POST          /course           Add a course
| GET           /course           Retrieve all courses
| GET           /course/{id}       Retrieve a course by ID
| PUT           /course/{id}       Update a course
| DELETE        /course/{id}        Delete a course
| POST          /registration       Register a student for a course
| GET       registration/student/{studentId}  Retrieve a student's registrations
| DELETE    /registration/{registrationId}  Cancel a registration

## Project Status

This project is being developed as a practical learning project to build backend development skills using Java and Spring Boot.

## Author

Brian Kipkorir
