# Spring Boot CRUD

A Spring Boot Project demonstrating how to implement CRUD operations with a User entity through endpoints provided from API, using MVC architecture.
	
## Technologies used:
- Java 1.8
- Lombok
- Spring Boot
- Spring MVC (Payara)
- Spring Data JPA (Hibernate & PostgreSQL)
- Hibernate
- Maven

## Installation
The project is created with Maven, so you just need to import it to your IDE and build the project to resolve the dependencies

## How to configure database
Create a PostgreSQL database with the name crud, add a schema with the name admin and config the credentials to /resources/application.properties.

```
#datasource
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/crud
spring.datasource.platform=postgres
spring.datasource.username=postgres
spring.datasource.password=

#jpa
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## How to use the API
Run the project through the IDE and head out to [http://localhost:8080](http://localhost:8080)

