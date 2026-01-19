# Movie App 🎬

A simple web application to manage a list of favorite movies.

## 📋 Project Idea

This app allows users to:
- View a list of their favorite movies
- Add new movies to the list
- Rate movies
- Write 
- personal reviews or notes for each movie (for personal reference)

# 🎬 Movie App – Backend

This is the backend of the Movie App, built with **Spring Boot (Java)**.  
It provides a REST API for authentication and movie management.

---

## Features

- User registration and login
- Create, read, update, delete (CRUD) movies
- Each movie belongs to a specific user
- RESTful API
- Unit and integration tests with JUnit

---

## Tech Stack

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 / Database (depending on your config)
- Gradle
- JUnit

---

## Running the backend

From the backend root directory:

```bash
./gradlew bootRun
