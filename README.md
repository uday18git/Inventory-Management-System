# Inventory Management System - Microservices Project
https://github.com/user-attachments/assets/bf5892e9-d06d-4d87-a929-a53264c108fb

## Table of Contents



1. [Project Overview](#project-overview)
2. [Architecture](#architecture)
3. [Technologies Used](#technologies-used)
4. [Services Description](#services-description)
5. [Database Schemas](#database-schemas)
6. [Dependencies](#dependencies)
7. [Setup Instructions](#setup-instructions)
8. [Usage](#usage)
9. [APIs](#apis)
10. [Future Enhancements](#future-enhancements)

---

## Project Overview

The **Inventory Management System** is a microservices-based application designed to handle products and orders efficiently. It ensures that the product inventory is checked before processing an order. The system uses Spring Boot for building services, Eureka for service discovery, and OpenFeign for inter-service communication.

### Key Features:
- Product Management: Add, view, and check the availability of products.
- Order Management: Place orders only if sufficient inventory exists.
- Service Registry: Dynamically discover and connect services.

---

## Architecture

### High-Level Design:
1. **Eureka Server**: Acts as a service registry to discover and manage microservices.
2. **Product Service**: Manages product information and inventory.
3. **Order Service**: Handles order placement and validates product availability using the Product Service.
4. **Communication**: Services communicate via OpenFeign.

---

## Technologies Used
- **Spring Boot 3.x**
- **Spring Cloud Netflix Eureka**
- **Spring Data JPA**
- **MySQL**
- **OpenFeign**
- **Postman** (for API testing)

---

## Services Description

### 1. **Eureka Server**:
The service registry that enables other services to register and discover each other dynamically.

### 2. **Product Service**:
Manages the inventory of products.
- Endpoints to add products, view all products, and check product availability.
- Stores data in a MySQL database.

### 3. **Order Service**:
Handles the order placement workflow.
- Validates the availability of products using the Product Service before creating orders.
- Uses MySQL for storing order data.

---

## Database Schemas

### `products` Database Schema
The `products` database stores information about available products.

**Table: products**
| Column       | Type        | Constraints           |
|--------------|-------------|-----------------------|
| id           | BIGINT      | PRIMARY KEY, AUTO_INCREMENT |
| name         | VARCHAR(255)| NOT NULL             |
| description  | TEXT        |                       |
| price        | DOUBLE      | NOT NULL             |
| quantity     | INT         | NOT NULL             |

### `orders` Database Schema
The `orders` database stores details of placed orders.

**Table: orders**
| Column       | Type        | Constraints           |
|--------------|-------------|-----------------------|
| id           | BIGINT      | PRIMARY KEY, AUTO_INCREMENT |
| productId    | BIGINT      | NOT NULL             |
| quantity     | INT         | NOT NULL             |
| status       | VARCHAR(50) | NOT NULL             |

---


## Dependencies
### Common Dependencies (for all services):
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Spring Boot Starter Test
- MySQL Driver

### Eureka Server:
- Spring Cloud Netflix Eureka Server

### Product Service & Order Service:
- Spring Cloud Netflix Eureka Client
- Spring Cloud OpenFeign

---

## Setup Instructions

### Prerequisites:
- Java 17 or higher
- MySQL installed and running
- Maven

### Steps to Run:
1. **Clone the Repository:**
   ```bash
   git clone <repository_url>
   cd inventory-management-system
   ```

2. **Run Eureka Server:**
   Navigate to the `eureka-server` folder and start the application:
   ```bash
   mvn spring-boot:run
   ```

3. **Run Product Service:**
   - Update the `application.properties` with MySQL credentials.
   - Start the service:
     ```bash
     mvn spring-boot:run
     ```

4. **Run Order Service:**
   - Update the `application.properties` with MySQL credentials.
   - Start the service:
     ```bash
     mvn spring-boot:run
     ```

5. **Test the Services:**
   - Use Postman or any API client to test endpoints.

---

## Usage

### Step 1: Add Products
- **Endpoint:** `POST /products/add`
- **Payload:**
  ```json
  {
    "name": "Nike Shoes",
    "description": "Sports shoes",
    "price": 5000.0,
    "quantity": 10
  }
  ```

### Step 2: Check Product Availability
- **Endpoint:** `GET /products/{id}/check-availability`
- **Example:**
  ```bash
  GET /products/1/check-availability?quantity=5
  ```

### Step 3: Place Order
- **Endpoint:** `POST /orders/place`
- **Payload:**
  ```json
  {
    "productId": 1,
    "quantity": 5,
    "status": "Pending"
  }
  ```

---

## APIs

### Product Service
| Method | Endpoint                      | Description              |
|--------|-------------------------------|--------------------------|
| GET    | /products/getAll              | Fetch all products       |
| POST   | /products/add                 | Add a new product        |
| GET    | /products/{id}/check-availability | Check product availability |

### Order Service
| Method | Endpoint        | Description        |
|--------|-----------------|--------------------|
| GET    | /orders/getAll  | Fetch all orders  |
| POST   | /orders/place   | Place a new order |

---

## Future Enhancements
- Implement authentication and authorization.
- Add Kafka for asynchronous messaging.
- Introduce a front-end interface.
- Use Docker for containerization.



