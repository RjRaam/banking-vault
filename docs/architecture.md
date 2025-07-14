# 📐 Architecture

## Overview
A full-stack web app to manage personal bank data.

## Components
- **React.js frontend** → Web UI
- **Spring Boot backend** → REST APIs, encryption
- **MySQL database** → store encrypted data
- **Liquibase** → DB schema management
- **Docker** → containerized deployment
- **Jenkins** → build & CI/CD
- **Python & shell scripts** → backup & data export

## Flow
```
[React Frontend] → [REST API - Spring Boot] → [MySQL DB]
```
All run via Docker:
- docker-compose starts backend, frontend, db
- Jenkins builds & deploys containers
