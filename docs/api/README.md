# Microservices API Documentation

This document contains Postman-tested API endpoints for the **UserService**, **HotelService**, and **RatingService** microservices.

---

## 📌 UserService

Base URL: `http://localhost:8081`

### 1. Get User

| | |
|---|---|
| **Method** | `GET` |
| **URL** | `http://localhost:8081/users/{userId}` |
| **Status** | `200 OK` / `404 Not Found` |

**Request**

No request body. Pass `userId` as a path parameter.

```
GET http://localhost:8081/users/1bef926f-62f7-4cd7-9119-e242092dda95
```

**Response** — `200 OK`

```json
{
  "userId": "1bef926f-62f7-4cd7-9119-e242092dda95",
  "name": "Rishabh Negi",
  "email": "rishinegi@gmail.com",
  "about": "I am Software Engineer",
  "ratings": []
}
```

**Error Response** — `404 Not Found`

```json
{
  "message": "User not found with given ID",
  "success": true,
  "status": "NOT_FOUND"
}
```

---

### 2. Create User

| | |
|---|---|
| **Method** | `POST` |
| **URL** | `http://localhost:8081/users` |
| **Status** | `201 Created` |

**Request**

```json
{
  "name": "Rimmi",
  "email": "rimminegi@gmail.com",
  "about": "Aspirant"
}
```

**Response**

```json
{
  "userId": "d10e674b-d4cf-45fe-b0b9-c59ab43f4171",
  "name": "Rimmi",
  "email": "rimminegi@gmail.com",
  "about": "Aspirant",
  "ratings": []
}
```

---

### 3. Get All Users

| | |
|---|---|
| **Method** | `GET` |
| **URL** | `http://localhost:8081/users` |
| **Status** | `200 OK` |

**Request**

No request body or parameters required.

**Response**

```json
[
  {
    "userId": "1bef926f-62f7-4cd7-9119-e242092dda95",
    "name": "Rishabh Negi",
    "email": "rishinegi@gmail.com",
    "about": "I am Software Engineer",
    "ratings": []
  },
  {
    "userId": "d10e674b-d4cf-45fe-b0b9-c59ab43f4171",
    "name": "Rimmi",
    "email": "rimminegi@gmail.com",
    "about": "Aspirant",
    "ratings": []
  }
]
```

---

## 📌 HotelService

Base URL: `http://localhost:8082`

### 1. Get Hotel

| | |
|---|---|
| **Method** | `GET` |
| **URL** | `http://localhost:8082/hotels/{id}` |
| **Status** | `200 OK` / `404 Not Found` |

**Request**

No request body. Pass `id` as a path parameter.

```
GET http://localhost:8082/hotels/bb7abba5-2378-497a-8ff4-5886c646f007
```

**Response** — `200 OK`

```json
{
  "id": "bb7abba5-2378-497a-8ff4-5886c646f007",
  "name": "Narmada",
  "location": "Karapakkam",
  "about": "Andhra Restaurant"
}
```

**Error Response** — `404 Not Found`

```json
{
  "success": false,
  "message": "Hotel Not found By ID",
  "status": "404 NOT_FOUND"
}
```

---

### 2. Create Hotel

| | |
|---|---|
| **Method** | `POST` |
| **URL** | `http://localhost:8082/hotels` |
| **Status** | `201 Created` |

**Request**

```json
{
  "name": "Narmada",
  "location": "Karapakkam",
  "about": "Andhra Restaurant"
}
```

**Response**

```json
{
  "id": "bb7abba5-2378-497a-8ff4-5886c646f007",
  "name": "Narmada",
  "location": "Karapakkam",
  "about": "Andhra Restaurant"
}
```

---

### 3. Get All Hotels

| | |
|---|---|
| **Method** | `GET` |
| **URL** | `http://localhost:8082/hotels` |
| **Status** | `200 OK` |

**Request**

No request body or parameters required.

**Response**

```json
[
  {
    "id": "9bc053c2-cdd2-4d01-82f6-8d835f547cb7",
    "name": "Gupta Bhavan",
    "location": "Thoraipakkam",
    "about": "Veg Restaurant and Sweets"
  },
  {
    "id": "bb7abba5-2378-497a-8ff4-5886c646f007",
    "name": "Narmada",
    "location": "Karapakkam",
    "about": "Andhra Restaurant"
  }
]
```

---

## 📌 RatingService

Base URL: `http://localhost:8083`

### 1. Create Rating

| | |
|---|---|
| **Method** | `POST` |
| **URL** | `http://localhost:8083/ratings` |
| **Status** | `201 Created` |

**Request**

```json
{
  "userId": "d10e674b-d4cf-45fe-b0b9-c59ab43f4171",
  "hotelId": "9bc053c2-cdd2-4d01-82f6-8d835f547cb7",
  "rating": 8,
  "feedback": "Serving size not as per price but that compensates in teh tastes"
}
```

**Response**

```json
{
  "ratingId": "6a9074bd1a9fb6c37c23c04a",
  "userId": "d10e674b-d4cf-45fe-b0b9-c59ab43f4171",
  "hotelId": "9bc053c2-cdd2-4d01-82f6-8d835f547cb7",
  "rating": 8,
  "feedback": "Serving size not as per price but that compensates in teh tastes"
}
```

---

### 2. Get Ratings By User

| | |
|---|---|
| **Method** | `GET` |
| **URL** | `http://localhost:8083/ratings/users/{userId}` |
| **Status** | `200 OK` |

**Request**

No request body. Pass `userId` as a path parameter.

```
GET http://localhost:8083/ratings/users/1bef926f-62f7-4cd7-9119-e242092dda95
```

**Response**

```json
[
  {
    "ratingId": "6a8df7ad1a9fb6c37c23c048",
    "userId": "1bef926f-62f7-4cd7-9119-e242092dda95",
    "hotelId": "9bc053c2-cdd2-4d01-82f6-8d835f547cb7",
    "rating": 8,
    "feedback": "Variety of North food"
  },
  {
    "ratingId": "6a8df8661a9fb6c37c23c049",
    "userId": "1bef926f-62f7-4cd7-9119-e242092dda95",
    "hotelId": "bb7abba5-2378-497a-8ff4-5886c646f007",
    "rating": 7,
    "feedback": "Great Service & Hospitality"
  }
]
```

---

### 3. Get Ratings By Hotel

| | |
|---|---|
| **Method** | `GET` |
| **URL** | `http://localhost:8083/ratings/hotels/{hotelId}` |
| **Status** | `200 OK` |

**Request**

No request body. Pass `hotelId` as a path parameter.

```
GET http://localhost:8083/ratings/hotels/bb7abba5-2378-497a-8ff4-5886c646f007
```

**Response**

```json
[
  {
    "ratingId": "6a8df8661a9fb6c37c23c049",
    "userId": "1bef926f-62f7-4cd7-9119-e242092dda95",
    "hotelId": "bb7abba5-2378-497a-8ff4-5886c646f007",
    "rating": 7,
    "feedback": "Great Service & Hospitality"
  }
]
```

---

### 4. Get All Ratings

| | |
|---|---|
| **Method** | `GET` |
| **URL** | `http://localhost:8083/ratings` |
| **Status** | `200 OK` |

**Request**

No request body or parameters required.

**Response**

```json
[
  {
    "ratingId": "6a8df7ad1a9fb6c37c23c048",
    "userId": "1bef926f-62f7-4cd7-9119-e242092dda95",
    "hotelId": "9bc053c2-cdd2-4d01-82f6-8d835f547cb7",
    "rating": 8,
    "feedback": "Variety of North food"
  },
  {
    "ratingId": "6a8df8661a9fb6c37c23c049",
    "userId": "1bef926f-62f7-4cd7-9119-e242092dda95",
    "hotelId": "bb7abba5-2378-497a-8ff4-5886c646f007",
    "rating": 7,
    "feedback": "Great Service & Hospitality"
  },
  {
    "ratingId": "6a9074bd1a9fb6c37c23c04a",
    "userId": "d10e674b-d4cf-45fe-b0b9-c59ab43f4171",
    "hotelId": "9bc053c2-cdd2-4d01-82f6-8d835f547cb7",
    "rating": 8,
    "feedback": "Serving size not as per price but that compensates in teh tastes"
  }
]
```

---

## Tech Notes

- All three services expose REST APIs and were tested via Postman.
- `UserService` runs on port **8081**.
- `HotelService` runs on port **8082**.
- `RatingService` runs on port **8083**.
