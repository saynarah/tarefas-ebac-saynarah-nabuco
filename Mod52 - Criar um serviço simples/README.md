# API to manage animals for a animal rescuing house

## Módulo 52 - Especialista Back-end Java (EBAC)

### Palavras-chave

* Microsserviços
* API
* Springboot
* Rest


- 👨‍💻 Developped by Saynarah Cruz Nabuco
- 📧 [saynarah.nabuco@gmail.com]
- 📅 02/21/2026

[![Java](https://img.shields.io/badge/Java-17-blue.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2-green.svg)](https://spring.io/projects/spring-boot)


## 🛠️ **Stacks**

| Category | Tecnologies |
|-----------|-------------|
| **Backend** | Spring Boot 3.2, Spring Data JPA, Hibernate |
| **Database** | H2 |
| **Tools** | Maven|

## 🚀 **Install**

### **Requisites**
```bash
Java 17+ | Maven 3.8+ 
``` 

### **👤 1. Create Animal**

- POST /animals
- Content-Type: application/json

Request Body:
```bash
json
{
  "temporaryName": "Mimi",
  "estimatedAge": 1,
  "breed": "Vira-lata",
  "dateEntry": "2026-02-18",
  "descriptionConditions": "Filhote resgatado, saudável.",
  "nameWorker": "Rodrigo Pires",
  "size": "SMALL",
  "animalType": "dog",
	"adoptionDate": null
}
```

Response 200 Created:

```bash
json
{
	"adoptionDate": null,
	"animalType": "dog",
	"breed": "Vira-lata",
	"dateEntry": "2026-02-18T00:00:00.000Z",
	"deathDate": null,
	"descriptionConditions": "Filhote resgatado, saudável.",
	"estimatedAge": 1,
	"id": 5,
	"nameWorker": "Rodrigo Pires",
	"size": "SMALL",
	"temporaryName": "Mimi"
}
```

### **👤  2. Retrieve all animals**

- GET /animals

Response 200:
```bash
[
	{
	<Animal_1>
	},
	{
   <Animal_2>
	}
  ...
]
```

### **3. Retrieve animals by type**

- GET /animals/{animalType}

Response 200:

```bash
[
	{
	<Animal_1>
	},
	{
   <Animal_2>
	}
  ...
]
```

### **  4. Retrieve all adopted animals**

- GET /animals/adopted

Response 200:
```bash
[
	{
	<Animal_1>
	},
	{
   <Animal_2>
	}
  ...
]
```

### **5. Retrieve all not adopted animals**

- GET /animals/not-adopted

Response 200:

```bash
[
	{
	<Animal_1>
	},
	{
   <Animal_2>
	}
  ...
]
```

### **  6. Retrieve adopted animals by type**

- GET /animals/adopted/{animalType}

Response 200:
```bash
[
	{
	<Animal_1>
	},
	{
   <Animal_2>
	}
  ...
]
```

### **7. Retrieve not adopted animals by type**

- GET /animals/not-adopted/{animalType}

Response 200:

```bash
[
	{
	<Animal_1>
	},
	{
   <Animal_2>
	}
  ...
]
```

### **8. Animals rescued by Worker**

- GET /animals/workers

Query Parameters

endDate

startDate

Response 200:

```bash
[
	{
		"nameWorker": "Rodrigo Pires",
		"animalsRescued": 4
	}
]
```

## **Database Model (MySQL)**


---

## 🗄️ **Database Model**

### **Table: `animal`**
| Coluna | Tipo | Descrição | Constraints |
|--------|------|-----------|-------------|
| `id` | `Identity` | Identificador único | `PK` |
| `temporary_name` | `VARCHAR(100)` | Temporary Name | `NOT NULL` |
| `estimated_age` | `INT` | Animal age | `NOT NULL` |
| `breed` | `VARCHAR(50)` | Animal breed | `NOT NULL` |
| `date_entry` | `DATE` | Entry date | `NOT NULL` |
| `adoption_date` | `DATE` | Entry date |  |
| `description_conditions` | `VARCHAR(255)` | Describe animal's conditions by arrival | `NOT NULL` |
| `name_worker` | `VARCHAR(255)` | Name worker | `NOT NULL` |
| `death_date` | `DATE` | Death date | |
| `size` | `VARCHAR(50)` | Animal size | `NOT NULL` |
| `animal_type` | `VARCHAR(50)` | Enum Type (dog, cat) | `NOT NULL` |



