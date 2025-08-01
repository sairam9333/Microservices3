Match Service - Microservice 1

This microservice is used to manage football matches. It allows you to create and retrieve matches with details like teams, venue, and match time.

Features:

Add a new match

Get list of all matches

Uses Spring Boot and MySQL

Tech Stack:

Java 17

Spring Boot

MySQL

Maven

Project Structure:
match-service/
controller/ -> REST controller
model/ -> Match entity
repository/ -> JPA repository
resources/
application.yml -> Configuration file
MatchServiceApplication.java

Setup Instructions:

Create a MySQL database:
CREATE DATABASE football;

Update application.yml with your database credentials:
spring.datasource.url=jdbc:mysql://localhost:3306/football
spring.datasource.username=root
spring.datasource.password=your_password

Run the service:
mvn clean install
mvn spring-boot:run

API Endpoints:

POST /api/matches -> Add a match

GET /api/matches -> Get all matches

Sample JSON for POST:
{
"teamA": "Argentina",
"teamB": "France",
"venue": "Doha Stadium",
"matchTime": "2025-12-18T18:30:00"
}

Sample curl Command:
curl -X POST http://localhost:8080/api/matches
-H "Content-Type: application/json"
-d '{"teamA":"Brazil","teamB":"Germany","venue":"Maracana","matchTime":"2025-08-02T21:00:00"}'
