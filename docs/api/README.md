@'

\# Microservices API Documentation



This document describes the endpoints available in the UserService and HotelService microservices.



Base URLs:

\- User Service: http://localhost:8081

\- Hotel Service: http://localhost:8082



\---



\## User Service



\### 1. Create User

Method: POST

URL: http://localhost:8081/users



Request Body:

```json

{

&#x20; "name": "Rimmi",

&#x20; "email": "rimmiiinegi@gmail.com",

&#x20; "about": "Aspiran"

}

