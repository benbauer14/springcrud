# Applications

Spring boot application created with spring.io initializer. This application is a simple REST API that allows for the creation, update and the retrieval of a student.

# Prerequisites

Create a local Postgres database with the following properties:

- Database name: `student_tracker`
- Database port: `5432`

Create a table in the database with the following properties:

- Table name: `student`
- Columns:
  - `id` (type: `int`, primary key)
  - `first_name`
  - `last_name`
  - `email`

# Tech Overview

- Spring Boot 2.6.3
- Postgres
