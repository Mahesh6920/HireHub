# HireHub

HireHub is a backend job portal application built using Spring Boot and MySQL. The project focuses on building scalable REST APIs for user management, recruiter management, authentication, authorization, and recruitment workflows.

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
* Spring Security integration
* Role-Based Access Control (RBAC)
* HTTP Basic Authentication
* CORS configuration for frontend integration

## Current Features
* User registeration API
* Get all users API
* Get user by email API
* Delete user API
* Update user API

## Security Features
* Spring Security 7
* HTTP Basic Authentication
* Role-Based Authorization
* Custom UserDetailsService
* Custom RecruiterDetailsService
* DaoAuthenticationProvider
* Protected API Endpoints
* Stateless Security Configuration

# 🔐 Spring Security Implementation

Implemented Spring Security authentication and authorization for Users and Recruiters.

## Features Added
* User Registration API
* Recruiter Registration API
* Role-Based Access Control (RBAC)
* Password validation through Spring Security AuthenticationProvider

## Roles
| Role      | Access                                  |
| --------- | --------------------------------------- |
| USER      | Access to `/api/user/**` endpoints      |
| RECRUITER | Access to `/api/recruiter/**` endpoints |
| ADMIN     | Access to `/api/admin/**` endpoints     |


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

### Update User
```
UPDATE /api/auth/user
```

## Project Status

This project is currently in the initial development phase. Upcoming updates will include:

* Password Encryption using BCrypt
* JWT Authentication
* Account Locking after Failed Login Attempts
* Job posting APIs
* Email Verification
* DTO implementation
* Forgot Password Functionality
* Deployment

## Folder Structure

```bash
src/
├── main/
│     ├── java/com/mahesh/HireHub/
|     |     ├── Config/
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

* Java Backend Developer
* Spring Boot Developer

LinkedIn: https://www.linkedin.com/in/tailormahesh/
