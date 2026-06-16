# Ecom8600

## Overview

Ecom8600 is a RESTful E-Commerce Backend API developed using Java 17 and Spring Boot. The application follows a layered architecture with clear separation between controllers, services, repositories, DTOs, security components, and persistence models.

The project implements authentication, authorization, product management, category management, customer management, shopping cart functionality, and order processing while following Spring Boot best practices.

---

# Technology Stack

| Technology | Description |
|------------|--------------------------------|
| Java 17 | Programming Language |
| Spring Boot | Backend Framework |
| Spring Security | Authentication & Authorization |
| JWT | Token Based Authentication |
| Spring Data JPA | ORM Framework |
| Hibernate | Persistence Provider |
| MySQL | Relational Database |
| Maven | Build Tool |
| Lombok | Boilerplate Reduction |
| Swagger / OpenAPI | API Documentation |
| Jakarta Validation | Request Validation |

---

# Project Architecture

```
Client

↓

Controller Layer

↓

Service Interface Layer

↓

Service Implementation Layer

↓

Repository Layer

↓

MySQL Database
```

---

# Project Structure

```
src
└── main
    ├── java
    │
    └── com.ecomm45.ecom8600
        │
        ├── config
        │   ├── OpenApiConfig
        │   ├── PasswordConfig
        │   ├── SecurityConfig
        │   └── SwaggerSecurityConfig
        │
        ├── controller
        │   ├── AuthController
        │   ├── CartController
        │   ├── CategoryController
        │   ├── CustomerController
        │   ├── OrderController
        │   ├── ProductController
        │   └── UserController
        │
        ├── dto
        │   ├── Request
        │   │   ├── AddToCartRequest
        │   │   ├── CreateCategoryRequest
        │   │   ├── CreateCustomerRequest
        │   │   ├── CreateOrderRequest
        │   │   ├── CreateProductRequest
        │   │   ├── LoginRequest
        │   │   └── RegisterRequest
        │   │
        │   └── Response
        │       ├── AuthResponse
        │       ├── CartItemResponse
        │       ├── CartResponse
        │       ├── CategoryResponse
        │       ├── CustomerResponse
        │       ├── OrderResponse
        │       └── ProductResponse
        │
        ├── entity
        │   ├── Cart
        │   ├── CartItems
        │   ├── Category
        │   ├── Customer
        │   ├── Order
        │   ├── OrderItem
        │   ├── Product
        │   └── Users
        │
        ├── enums
        │   ├── Role
        │   └── Status
        │
        ├── exception
        │   ├── ErrorResponse
        │   ├── GlobalExceptionHandler
        │   └── NotFoundException
        │
        ├── repository
        │   ├── CartItemsRepository
        │   ├── CartRepository
        │   ├── CategoryRepository
        │   ├── CustomerRepository
        │   ├── OrderItemRepository
        │   ├── OrderRepository
        │   ├── ProductRepository
        │   └── UsersRepository
        │
        ├── security
        │   ├── JwtFilter
        │   ├── JwtUtil
        │   └── UserCustomDetailsService
        │
        ├── service
        │   ├── AuthService
        │   ├── CartService
        │   ├── CategoryService
        │   ├── CustomerService
        │   ├── OrderService
        │   ├── ProductService
        │   └── UserService
        │
        ├── serviceImpl
        │   ├── AuthServiceImpl
        │   ├── CartServiceImpl
        │   ├── CategoryServiceImpl
        │   ├── CustomerServiceImpl
        │   ├── OrderServiceImpl
        │   ├── ProductServiceImpl
        │   └── UserServiceImpl
        │
        └── Ecom8600Application
```

---

# Configuration Layer

The configuration package contains the application's configuration classes.

### OpenApiConfig

Configures Swagger/OpenAPI documentation.

### PasswordConfig

Provides BCryptPasswordEncoder bean for secure password hashing.

### SecurityConfig

Configures Spring Security authorization rules and JWT authentication.

### SwaggerSecurityConfig

Allows secure access to Swagger documentation.

---

# Controller Layer

The controller layer exposes REST endpoints.

### AuthController

Handles

- User Registration
- User Login

### UserController

Handles

- Update User
- Delete User

### CustomerController

Handles customer CRUD operations.

### CategoryController

Handles category CRUD operations.

### ProductController

Handles product CRUD operations.

### CartController

Handles shopping cart operations.

### OrderController

Handles order management.

---

# DTO Layer

DTOs isolate API contracts from persistence models.

## Request DTOs

- RegisterRequest
- LoginRequest
- CreateProductRequest
- CreateCategoryRequest
- CreateCustomerRequest
- CreateOrderRequest
- AddToCartRequest

## Response DTOs

- AuthResponse
- ProductResponse
- CategoryResponse
- CustomerResponse
- CartResponse
- CartItemResponse
- OrderResponse

---

# Entity Layer

### Users

Stores authentication and authorization information.

### Customer

Stores customer profile information.

### Category

Stores product categories.

### Product

Stores product details.

### Cart

Represents a customer's shopping cart.

### CartItems

Stores individual cart products.

### Order

Stores customer orders.

### OrderItem

Stores ordered products.

---

# Enum Layer

### Role

Application roles used for authorization.

```
ADMIN
CUSTOMER
```

### Status

Order status values.

```
PENDING
CONFIRMED
SHIPPED
DELIVERED
CANCELLED
```

---

# Repository Layer

The repository layer provides persistence operations using Spring Data JPA.

Repositories included:

- UsersRepository
- CustomerRepository
- CategoryRepository
- ProductRepository
- CartRepository
- CartItemsRepository
- OrderRepository
- OrderItemRepository

---

# Security Layer

Authentication is implemented using JWT.

### JwtUtil

Responsible for

- Token generation
- Token validation
- Extracting user information

### JwtFilter

Intercepts incoming requests and validates JWT tokens before processing.

### UserCustomDetailsService

Loads user details from the database for Spring Security authentication.

---

# Service Layer

The service package defines business contracts.

Interfaces

- AuthService
- UserService
- CustomerService
- CategoryService
- ProductService
- CartService
- OrderService

---

# Service Implementation Layer

Contains business logic implementations.

Implementations

- AuthServiceImpl
- UserServiceImpl
- CustomerServiceImpl
- CategoryServiceImpl
- ProductServiceImpl
- CartServiceImpl
- OrderServiceImpl

Responsibilities include

- Business validation
- Entity mapping
- DTO conversion
- Repository interaction
- Exception handling





---

# Authorization

### ADMIN

Permissions

- User Management
- Category Management
- Product Management
- Customer Management
- Order Management

### CUSTOMER

Permissions

- Browse Products
- Manage Cart
- Place Orders
- View Orders

---

# Validation

Request validation is implemented using Jakarta Validation.

Examples

```
@NotBlank

@NotNull

@Email

@Size
```

---

# API Documentation

Swagger/OpenAPI documentation is available at

```
http://localhost:8080/swagger-ui/index.html
```

---

# Design Principles

- Layered Architecture
- Separation of Concerns
- Repository Pattern
- DTO Pattern
- Service Pattern
- Dependency Injection
- JWT Based Authentication
- Global Exception Handling

---

# Build & Run

Clone the repository

```
git clone <repository-url>
```

Navigate to project

```
cd ecom8600
```

Build

```
mvn clean install
```

Run

```
mvn spring-boot:run
```

---

# Future Enhancements

- Payment Gateway Integration
- Inventory Management
- Email Notifications
- Wishlist Module
- Redis Caching
- Docker Deployment
- Unit Testing
- Integration Testing

---

# License

This project demonstrates the implementation of a secure, layered Spring Boot E-Commerce Backend API using REST principles, JWT authentication, Spring Data JPA, and MySQL.
