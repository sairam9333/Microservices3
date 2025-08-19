# Microservices Football Management Project

This repository contains a simple microservices‑based application built with **Java 17** and **Spring Boot**.  It demonstrates how to split a domain into discrete services, each with its own responsibility, and how to compose those services behind a lightweight gateway.  The project intentionally avoids advanced features like service discovery or message brokers to keep the example easy to run locally.

## Overview

The project consists of three Spring Boot applications:

| Service | Purpose | Default Port |
|---|---|---|
| **match‑service** | Stores and retrieves information about football matches, including the competing teams, venue and kickoff time. | `8081` |
| **score‑service** | Keeps track of scores for existing matches.  You can record a score for a match and fetch scores by match ID. | `8082` |
| **gateway‑service** | A simple façade that forwards incoming HTTP requests to the appropriate downstream service using a `RestTemplate`.  It exposes a unified API on port `8080`. | `8080` |

> **Note:** A minimal `application.yml` file is kept at the repository root as a relic from earlier experiments.  It does not affect the three microservices in this example.

## Technologies

* **Spring Boot 3** – Rapidly create production‑ready Spring applications with minimal configuration.  The `@SpringBootApplication` annotation enables auto‑configuration and component scanning【28841497750044†L245-L279】.
* **Spring Data JPA** – Declarative persistence layer.  Repositories extend `JpaRepository` so Spring generates implementations automatically【28841497750044†L227-L241】.
* **MySQL** – Each service uses a separate MySQL schema by default.  Update the database credentials in each service’s `application.yml` before running.
* **RestTemplate** – Simplifies making HTTP calls from the gateway to downstream services.

## Running the services

Each microservice can be built and run independently using Maven.  The example uses default database credentials; adjust them as needed:

```
cd match-service
mvn spring-boot:run

cd ../score-service
mvn spring-boot:run

cd ../gateway-service
mvn spring-boot:run
```

After starting all three services, you can interact with them using `curl` or any API client.  For example, to create a match and record its score:

```
# Create a match
curl -X POST http://localhost:8081/api/matches \ 
     -H "Content-Type: application/json" \ 
     -d '{"teamA":"Argentina","teamB":"France","venue":"Doha Stadium","matchTime":"2025-12-18T18:30:00"}'

# Save a score for the match with ID 1
curl -X POST http://localhost:8082/api/scores \ 
     -H "Content-Type: application/json" \ 
     -d '{"matchId":1,"teamAScore":2,"teamBScore":1}'

# Retrieve all matches via the gateway
curl http://localhost:8080/api/matches

# Retrieve score for match with ID 1 via the gateway
curl http://localhost:8080/api/scores/1
```

## Project structure

```
Microservices3/
├── match-service/        # REST service for matches
│   ├── pom.xml
│   ├── src/main/java/
│   │   └── com/example/matchservice/
│   │       ├── MatchServiceApplication.java
│   │       ├── controller/MatchController.java
│   │       ├── model/Match.java
│   │       └── repository/MatchRepository.java
│   └── src/main/resources/application.yml
├── score-service/        # REST service for scores
│   ├── pom.xml
│   ├── src/main/java/
│   │   └── com/example/scoreservice/
│   │       ├── ScoreServiceApplication.java
│   │       ├── controller/ScoreController.java
│   │       ├── model/Score.java
│   │       └── repository/ScoreRepository.java
│   └── src/main/resources/application.yml
├── gateway-service/      # Simple gateway that delegates calls to other services
│   ├── pom.xml
│   ├── src/main/java/
│   │   └── com/example/gatewayservice/
│   │       ├── GatewayServiceApplication.java
│   │       ├── controller/GatewayController.java
│   │       └── model/
│   │           ├── Match.java
│   │           └── Score.java
│   └── src/main/resources/application.yml
└── application.yml       # Unused sample configuration for a Eureka server
```

## License

This project is provided as a learning example and is released under the MIT License.
