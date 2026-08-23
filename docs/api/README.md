\# Microservices API Documentation

&#x20;

This document contains Postman-tested API endpoints for the \*\*UserService\*\* and \*\*HotelService\*\* microservices.

&#x20;

\---

&#x20;

\## 📌 UserService

&#x20;

Base URL: `http://localhost:8081`

&#x20;

\### 1. Get User

&#x20;

| | |

|---|---|

| \*\*Method\*\* | `GET` |

| \*\*URL\*\* | `http://localhost:8081/users/{userId}` |

| \*\*Status\*\* | `200 OK` |

&#x20;

\*\*Request\*\*

&#x20;

No request body. Pass `userId` as a path parameter.

&#x20;

```

GET http://localhost:8081/users/1bef926f-62f7-4cd7-9119-e242092dda95

```

&#x20;

\*\*Response\*\*

&#x20;

```json

{

&#x20; "userId": "1bef926f-62f7-4cd7-9119-e242092dda95",

&#x20; "name": "Rishabh Negi",

&#x20; "email": "rishinegi@gmail.com",

&#x20; "about": "I am Software Engineer",

&#x20; "ratings": \[]

}

```

&#x20;

\---

&#x20;

\### 2. Create User

&#x20;

| | |

|---|---|

| \*\*Method\*\* | `POST` |

| \*\*URL\*\* | `http://localhost:8081/users` |

| \*\*Status\*\* | `201 Created` |

&#x20;

\*\*Request\*\*

&#x20;

```json

{

&#x20; "name": "Rimmi",

&#x20; "email": "rimminegi@gmail.com",

&#x20; "about": "Aspirant"

}

```

&#x20;

\*\*Response\*\*

&#x20;

```json

{

&#x20; "userId": "d10e674b-d4cf-45fe-b0b9-c59ab43f4171",

&#x20; "name": "Rimmi",

&#x20; "email": "rimminegi@gmail.com",

&#x20; "about": "Aspirant",

&#x20; "ratings": \[]

}

```

&#x20;

\---

&#x20;

\### 3. Get All Users

&#x20;

| | |

|---|---|

| \*\*Method\*\* | `GET` |

| \*\*URL\*\* | `http://localhost:8081/users` |

| \*\*Status\*\* | `200 OK` |

&#x20;

\*\*Request\*\*

&#x20;

No request body or parameters required.

&#x20;

\*\*Response\*\*

&#x20;

```json

\[

&#x20; {

&#x20;   "userId": "1bef926f-62f7-4cd7-9119-e242092dda95",

&#x20;   "name": "Rishabh Negi",

&#x20;   "email": "rishinegi@gmail.com",

&#x20;   "about": "I am Software Engineer",

&#x20;   "ratings": \[]

&#x20; },

&#x20; {

&#x20;   "userId": "d10e674b-d4cf-45fe-b0b9-c59ab43f4171",

&#x20;   "name": "Rimmi",

&#x20;   "email": "rimminegi@gmail.com",

&#x20;   "about": "Aspirant",

&#x20;   "ratings": \[]

&#x20; }

]

```

&#x20;

\---

&#x20;

\## 📌 HotelService

&#x20;

Base URL: `http://localhost:8082`

&#x20;

\### 1. Get Hotel

&#x20;

| | |

|---|---|

| \*\*Method\*\* | `GET` |

| \*\*URL\*\* | `http://localhost:8082/hotels/{id}` |

| \*\*Status\*\* | `200 OK` |

&#x20;

\*\*Request\*\*

&#x20;

No request body. Pass `id` as a path parameter.

&#x20;

```

GET http://localhost:8082/hotels/bb7abba5-2378-497a-8ff4-5886c646f007

```

&#x20;

\*\*Response\*\*

&#x20;

```json

{

&#x20; "id": "bb7abba5-2378-497a-8ff4-5886c646f007",

&#x20; "name": "Narmada",

&#x20; "location": "Karapakkam",

&#x20; "about": "Andhra Restaurant"

}

```

&#x20;

\---

&#x20;

\### 2. Create Hotel

&#x20;

| | |

|---|---|

| \*\*Method\*\* | `POST` |

| \*\*URL\*\* | `http://localhost:8082/hotels` |

| \*\*Status\*\* | `201 Created` |

&#x20;

\*\*Request\*\*

&#x20;

```json

{

&#x20; "name": "Narmada",

&#x20; "location": "Karapakkam",

&#x20; "about": "Andhra Restaurant"

}

```

&#x20;

\*\*Response\*\*

&#x20;

```json

{

&#x20; "id": "bb7abba5-2378-497a-8ff4-5886c646f007",

&#x20; "name": "Narmada",

&#x20; "location": "Karapakkam",

&#x20; "about": "Andhra Restaurant"

}

```

&#x20;

\---

&#x20;

\### 3. Get All Hotels

&#x20;

| | |

|---|---|

| \*\*Method\*\* | `GET` |

| \*\*URL\*\* | `http://localhost:8082/hotels` |

| \*\*Status\*\* | `200 OK` |

&#x20;

\*\*Request\*\*

&#x20;

No request body or parameters required.

&#x20;

\*\*Response\*\*

&#x20;

```json

\[

&#x20; {

&#x20;   "id": "9bc053c2-cdd2-4d01-82f6-8d835f547cb7",

&#x20;   "name": "Gupta Bhavan",

&#x20;   "location": "Thoraipakkam",

&#x20;   "about": "Veg Restaurant and Sweets"

&#x20; },

&#x20; {

&#x20;   "id": "bb7abba5-2378-497a-8ff4-5886c646f007",

&#x20;   "name": "Narmada",

&#x20;   "location": "Karapakkam",

&#x20;   "about": "Andhra Restaurant"

&#x20; }

]

```

&#x20;

\---

&#x20;

\## Tech Notes

&#x20;

\- Both services expose REST APIs and were tested via Postman.

\- `UserService` runs on port \*\*8081\*\*.

\- `HotelService` runs on port \*\*8082\*\*.

