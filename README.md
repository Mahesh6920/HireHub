# HireHub

HireHub is a backend job portal application built using Spring Boot and MySQL. The project is currently under development with focus on building scalable REST APIs for authentication, job management, and recruitment workflows.

## Current Progress

* Spring Boot project initialized
* Maven project structure created
* Database connected using `application.properties`
* Spring Boot project setup
* MySQL database integration
* REST API architecture
* User registration API
* Fetch users API
* Layered backend structure
* CORS configuration for frontend integration

## Current Features
* User registeration API
* Get all users API
* Get user by email API
* Delete user API

## Tech Stack

### Backend

* Java
* Spring Boot
* Spring Data JPA
* Maven

### Database

* MySQL

## API Endpoints

### Register User
```
POST /api/auth/register
```

### Get All Users
```
GET /api/auth/users
```

### Get User By Email
```
GET /api/auth/user?email=user@example.com
```

### Delete User
```
DELETE /api/auth/user/{id}
```

## Project Status

This project is currently in the initial development phase. Upcoming updates will include:

* User authentication
* DTO implementation
* Password encryption
* JWT authentication
* Job posting APIs
* Job application system
* Role-based access
* Deployment

## Folder Structure

```bash
src/
├── main/
│     ├── java/com/mahesh/HireHub/
│     │     ├── Controller/
│     │     ├── Entity/
│     │     ├── Repository/
│     │     ├── Service/
│     │     └── HireHubApplication.java
│     └── resources/
|            └── application.properties
└── test/
```

### Architecture

Controller -> Service -> Repository -> Database

## Getting Started

### Clone Repository

```bash
git clone https://github.com/your-username/HireHub.git
```

### Run Project

```bash
mvn spring-boot:run
```

## Author

Mahesh Tailor
