# Meme Management Microservices

- 👨‍💻 Developped by Saynarah Cruz Nabuco
- 📧 [saynarah.nabuco@gmail.com]
- 📅 04/15/2026

[![Java](https://img.shields.io/badge/Java-17-blue.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2-green.svg)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-purple.svg)](https://www.postgresql.org/)

## 📋 **What the project does**

A distributed Java backend application consisting of three microservices: **User Service**, **Category Service**, and **Meme Service**. Each service runs with a dedicated MySQL database. Services communicate via ZooKeeper for service discovery, enabling name-based connections (e.g., `user-service` to fetch user IDs before creating memes).

Built with Spring Boot, Hibernate, MySQL, Docker, and ZooKeeper. Supports CRUD operations with validation (e.g., memes require existing users and categories).

## **Architecture Overview**
ZooKeeper (Service Discovery)

├── User Service (MySQL DB)

├── Category Service (MySQL DB)

└── Meme Service (MySQL DB) → Calls User & Category Services

### **Main Functionalities:**
- 📊 **Complete logging** of all requests/responses
- 🧪 **Robust validation** with standardized responses


## **Access services (default ports)**:
| Service       | Endpoint Base | 
|---------------|---------------|
| User         | `localhost:8085`
| Category     | `localhost:8086`
| Meme         | `localhost:8087`


## 🛠️ **Stacks**

| Category | Tecnologies |
|-----------|-------------|
| **Backend** | Spring Boot 3.2,  Spring Data JPA, Hibernate |
| **Database** | PostgreSQL 16 |
| **Tools** | Maven|

## 🚀 **Install and Exec**

### **Requisites**
```bash
Java 17+ | Maven 3.8+ | PostgreSQL 16
``` 

## Step by step

### Dependencies install

```bash
mvn clean install -DskipTests
``` 

### Docker execution (MySQL Database)


#### 1. Open Docker Desktop

#### 2. Go to 'docker' folder

```bash
cd docker
```

#### 3. Up MySQL

```bash
docker-compose up -d
```

#### 4. At the end, dowd MySQL

```bash
docker-compose down
```

### Application Exec

```bash
mvn spring-boot:run
```

## **API Documentation**


### **1. Create User**

- POST /users
- Content-Type: application/json

Request Body:
```bash
json
{
	"name": "Madalena",
	"email": "madalena@teste.com"
}
```

Response 201 Created:

```bash
json
{
	"id": 452,
	"name": "Madalena",
	"email": "madalena@teste.com",
	"creationDate": "2026-04-15T03:00:00.000Z"
}
```

User already exists

Response 400 Bad Request

```bash
json
{
	"error": "User email already exists",
	"message": "User already exists by email: madalena@teste.com"
}
```


### **2. Get User By Email**

- GET /users/?email={email}
- Content-Type: application/json

Exemplo: GET /categories/name?name=pandemia

```bash
/users?email=felipe%40teste.com
```

Response 200:
```bash
452
```

Response 404 Not Found:
```bash
<empty>
```


### **3. Create category**

- POST /categories
- Content-Type: application/json

Request Body:
```bash
json
{
	"name": "Pandemia",
	"description":"memes durante as lives da pandemia",
	"emailUser": "george@teste.com"
}
```

Response 200 Created:

```bash
json
{
	"id": 503,
	"name": "Pandemia",
	"description": "memes durante as lives da pandemia",
	"creationDate": "2026-04-15T03:00:00.000Z",
	"userId": 402
}
```

Response 400 Bad Request:
```bash
{
	"error": "Category name already exists",
	"message": "Category already exists by name: Pandemia"
}
```

### **4. Retrieve a categoryId by Name**

- GET /categories/name?name={name}

Exemplo: GET /categories/name?name=pandemia


Response 200 OK:

```bash
503
```

Response 404 Not Found:
```bash
<empty>
```


### **5. Create a meme**

- POST /memes
- Content-Type: application/json

Request Body:
```bash
json
{
	"name": "Ludmila caindo",
	"description": "ludmila cai na piscina da live",
	"urlMedia": "www.google.com",
	"categoryName": "Pandemia",
	"userEmail": "saynarah@teste.com"
}
```

Response 201 Created:

```bash
json
{
	"id": 152,
	"name": "Ludmila caindo",
	"description": "ludmila cai na piscina da live",
	"creationDate": "2026-04-15T03:00:00.000Z",
	"urlMedia": "www.google.com",
	"categoryId": 503,
	"userId": 2
}
```

User doesn't exist

Response 404 Not Found

```bash
json
{
	"error": "Not Found",
	"message": "User not found by email: roberval@teste.com"
}
```

Category doesn't exist

Response 404 Not Found

```bash
json
{
	"error": "Not Found",
	"message": "Category not found by name: Futebol"
}
```


## **Database Model (MySQL)**


---

## 🗄️ **Database Model**

### **Table: `users`**
| Coluna | Tipo | Descrição | Constraints |
|--------|------|-----------|-------------|
| `id` | `BIGINT` | Identificador único | `PK` |
| `creation_date` | `DATEIME(6)` | Creation date | `DEFAULT NOW()` |
| `email` | `VARCHAR(255)` | User email | `NOT NULL` |
| `name` | `VARCHAR(255)` | User name | `NOT NULL` |

| `user_id` | `UUID` | Card's owner | `FK → users(id)` |


### **Table: `meme-categories`**
| Coluna | Tipo | Descrição | Constraints |
|--------|------|-----------|-------------|
| `id` | `BIGINT` | Unique identifier | `PK` |
| `creation_date` | `DATEIME(6)` | Creation date | `DEFAULT NOW()` |
| `description` | `VARCHAR(255)` | Category description | `NOT NULL` |
| `name` | `VARCHAR(255)` | Category's name | `UNIQUE, NOT NULL` |
| `user_id` | `BIGINT` | Category's creator | `FK → users(id)` |

### **Table: `memes`**
| Coluna | Tipo | Descrição | Constraints |
|--------|------|-----------|-------------|
| `id` | `BIGINT` | Unique identifier | `PK` |
| `creation_date` | `DATEIME(6)` | Creation date | `DEFAULT NOW()` |
| `description` | `VARCHAR(255)` | Meme description | `NOT NULL` |
| `name` | `VARCHAR(255)` | Meme's name | `UNIQUE, NOT NULL` |
| `url_media` | `VARCHAR(255)` | URL meme media | `NOT NULL` |
| `category_id` | `BIGINT` | Category ID | `FK → meme-categories(id)` |
| `user_id` | `BIGINT` | Meme's creator | `FK → users(id)` |

---


