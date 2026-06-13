# Ecom8600 - Spring Boot E-Commerce REST API

## Overview

Ecom8600 is a backend REST API built using Spring Boot that demonstrates the core functionalities of an e-commerce platform. The application follows a layered architecture using Controllers, Services, Repositories, DTOs, Entities, and Global Exception Handling.

The project includes user authentication with JWT, customer management, product and category management, shopping cart functionality, order processing, and API documentation with Swagger/OpenAPI.

---

## Features

### Authentication

* User Registration
* User Login
* JWT Authentication
* Role Based Authorization

### Customer Management

* Create Customer
* Get Customer Details
* Update Customer
* Delete Customer

### Category Management

* Create Category
* View Categories
* Update Category
* Delete Category

### Product Management

* Create Product
* Get Product
* Update Product
* Delete Product

### Shopping Cart

* Create Cart
* Get Cart
* Add Product to Cart
* Remove Cart Item
* Clear Cart

### Order Management

* Create Order from Cart
* Get Order by Customer
* View Ordered Products
* Order Status Management

### API Documentation

* Swagger/OpenAPI Integration

### Exception Handling

* Global Exception Handler
* Custom Not Found Exception
* Standard Error Response

---

## Tech Stack

| Technology      | Version               |
| --------------- | --------------------- |
| Java            | 17                    |
| Spring Boot     | 4.x                   |
| Spring MVC      | REST                  |
| Spring Security | JWT Authentication    |
| Spring Data JPA | Hibernate             |
| MySQL           | Database              |
| Maven           | Build Tool            |
| Swagger/OpenAPI | API Documentation     |
| Lombok          | Boilerplate Reduction |

---

## Project Structure

```
src
└── main
    └── java
        └── com.ecomm45.ecom8600
            ├── config
            │   ├── OpenApiConfig
            │   ├── PasswordConfig
            │   └── SecurityConfig
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
            │   ├── CustomUserDetails
            │   ├── JwtFilter
            │   └── JwtUtil
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

## Database Design

### Tables

```
users
customers
categories
products
cart
cart_items
orders
order_items
```

---

## API Endpoints

### Authentication

```
POST   /api/auth/register
POST   /api/auth/login
```

### Customers

```
POST   /api/customer
GET    /api/customer/{id}
PUT    /api/customer/{id}
DELETE /api/customer/{id}
```

### Categories

```
POST   /api/category
GET    /api/category
PUT    /api/category/{id}
DELETE /api/category/{id}
```

### Products

```
POST   /api/product
GET    /api/product
GET    /api/product/{id}
PUT    /api/product/{id}
DELETE /api/product/{id}
```

### Cart

```
POST   /api/cart/{customerId}
GET    /api/cart/{customerId}
POST   /api/cart/{customerId}/items
DELETE /api/cart/{customerId}/items/{cartItemId}
DELETE /api/cart/{customerId}/clear
```

### Orders

```
POST   /api/order/{email}
GET    /api/order/{customerId}/{orderId}
```

---

## Authentication

Protected endpoints require a JWT token.

```
Authorization: Bearer <jwt-token>
```

---

## Running the Project

### Clone Repository

```
git clone https://github.com/your-username/ecom8600.git
```

### Configure Database

```
spring.datasource.url=jdbc:mysql://localhost:3306/ecom8600
spring.datasource.username=root
spring.datasource.password=root
```

### Build Project

```
mvn clean install
```

### Run Application

```
mvn spring-boot:run
```

Application runs on

```
http://localhost:8080
```

---

## Swagger Documentation

```
http://localhost:8080/swagger-ui/index.html
```

---

## Architecture

```
Client
   │
   ▼
Controller
   │
   ▼
Service
   │
   ▼
Repository
   │
   ▼
MySQL Database
```

---

## Key Concepts Implemented

* Layered Architecture
* DTO Pattern
* Entity Relationships
* CRUD Operations
* REST API Development
* JWT Authentication
* Spring Security
* Global Exception Handling
* Validation
* Shopping Cart Workflow
* Order Processing
* OpenAPI Documentation



