# API Gateway — Routing Guide

## What the Gateway Does

The API Gateway sits in front of all backend microservices (`UserService`, `HotelService`, `RatingService`, etc.) and acts as a single entry point. Instead of clients calling each service directly on its own port, they call the gateway, which forwards ("routes") the request to the correct downstream service.

### Key dependencies used

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webflux</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-gateway</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

---

## 1. YAML-based Routes — Declarative

Use this when routing rules are simple: match a path prefix, forward to a service via load-balancing (`lb://ServiceName` tells the gateway "resolve this via Eureka/discovery, then load-balance across instances").

In `application.yml`, provide details of all internal microservice names, paths, and URIs as below:

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: UserService
          uri: lb://UserService
          predicates:
            - Path=/users/**
        - id: HotelService
          uri: lb://HotelService
          predicates:
            - Path=/hotels/**
        - id: RatingService
          uri: lb://RatingService
          predicates:
            - Path=/ratings/**
```

### How it works

- Each entry under `routes` defines one route: an `id` (any unique name), a target `uri`, and one or more `predicates` (conditions that decide whether a request matches this route).
- `lb://UserService` — the `lb://` prefix tells the gateway to resolve `UserService` through the load-balancer/service-discovery client (Eureka), rather than treating it as a literal hostname. It looks up all healthy instances registered under that name and load-balances across them.
- `Path=/users/**` — a predicate matching any request path starting with `/users/`. If the incoming request is `GET /users/123`, it matches this route and gets forwarded to a `UserService` instance.

---

## 2. Programmatic Routing (Java `RouteLocator` Bean)

```java
@Bean
public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    // adding 2 routes to first microservice as we need to log request body if method is POST
    return builder.routes()
            .route("first-microservice", r -> r.path("/first")
                    .and().method("POST")
                    .and().readBody(Student.class, s -> true).filters(f -> f.filters(requestFilter, authFilter))
                    .uri("http://localhost:8081"))
            .route("first-microservice", r -> r.path("/first")
                    .and().method("GET").filters(f -> f.filters(authFilter))
                    .uri("http://localhost:8081"))
            .route("second-microservice", r -> r.path("/second")
                    .and().method("POST")
                    .and().readBody(Company.class, s -> true).filters(f -> f.filters(requestFilter, authFilter))
                    .uri("http://localhost:8082"))
            .route("second-microservice", r -> r.path("/second")
                    .and().method("GET").filters(f -> f.filters(authFilter))
                    .uri("http://localhost:8082"))
            .route("auth-server", r -> r.path("/login")
                    .uri("http://localhost:8088"))
            .build();
}
```

### How it works

- You build routes programmatically using `RouteLocatorBuilder`, chaining `.route(id, routeSpec -> ...)` calls.
- Each route can combine multiple predicates with `.and(...)` — e.g. path **and** HTTP method **and** a body condition — something a single YAML `predicates` list can't express as cleanly.
- `.filters(...)` lets you attach custom `GatewayFilter`s (like an auth check or request logging) to specific routes only, instead of applying a filter globally.
- `.uri(...)` can point to a literal address (`http://localhost:8081`) instead of a discovery-resolved service name — useful for services or servers not registered in Eureka (e.g. an external auth server).

### Use this when you need any of

- Routing based on more than just the path — e.g. only route POST requests one way and GET another
- Inspecting/validating the request body before deciding how to route it (`.readBody(...)`)
- Applying different filters to different routes (e.g. an auth filter on some routes but not others)
- Any routing logic that can't be expressed as a static YAML predicate

The moment you need something like — "log the request body only on POST to `/users`," or "run an auth filter on some routes but not others," or "route based on a header value" — YAML predicates alone can't do it, and you'd write a `RouteLocator` bean like the one above, mixing `.and()` conditions and `.filters()`.
