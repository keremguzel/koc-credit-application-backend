# Koc Finans - Credit Application
- Saving credit application of users.
- Reporting the application result and also specified the credit limit for user if the application was approved.


## Requirements
PostgreSQL database is used for the project. A database must be created according to the following information;

database-name = postgres

username = postgres

password = 1234


- Jdk 1.8

- Apache Maven 4.0.0

- PostgreSQL 

## Swagger Link

http://localhost:8080/swagger-ui.html

## Futures

### POST Request
---
**Endpoint:** localhost:8080/api/1.0/users 

**Request:**

```json
POST 
Accept: application/json
Content-Type: application/json
Content-Length: xy

{
    "id":12581449116,
        "name":"Kerem",
        "surname":"Güzel",
        "salary":"10000",
        "phone":5418672978
}
```
**Successful Response:**
```json
HTTP/1.1 200 OK
Server: My RESTful API
Content-Type: application/json
Content-Length: xy

{
    "message": "CREDIT_LIMIT_SUCCESS",
    "object": {
        "id": 1,
        "creditLimit": 10000,
        "approved": true,
        "user": {
            "id": 12581449116,
            "name": "Kerem",
            "surname": "Güzel",
            "salary": 10000,
            "phone": 5418672978
        }
    }
}
```
**Failed Response / ID:**
```json
HTTP/1.1 500
Content-Type: application/json
{
    "status": 500,
    "error": "Internal Server Error",
    "trace": "BusinessValidationException,
    "message": "ID_IS_NOT_VALID",
    "path": "/api/1.0/users"
}
```

**Failed Response / Phone Number:**
```json
HTTP/1.1 500
Content-Type: application/json
{
    "status": 500,
    "error": "Internal Server Error",
    "trace": "BusinessValidationException,
    "message": "PHONE_NUMBER_NOT_UNIQUE",
    "path": "/api/1.0/users"
}
```

### GET Request
---
**Endpoint:** localhost:8080/api/1.0/users/{id}

**Request:**

```json
GET HTTP/1.1
Accept: application/json
Content-Type: application/json

```

**Successful Response:**

```json
HTTP 200 OK
Content-Type: application/json

{
    "message": "CREDIT_INFO",
    "object": {
        "id": 1,
        "creditLimit": 10000,
        "approved": true,
        "user": {
            "id": 12581449116,
            "name": "Kerem",
            "surname": "Güzel",
            "salary": 10000,
            "phone": 5418672978
        }
    }
}
```
