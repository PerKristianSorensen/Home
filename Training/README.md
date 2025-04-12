# MicroProfile jOOQ Project

This project is a MicroProfile application that utilizes jOOQ for database interactions and PostgreSQL as the database. The project is structured into multiple modules, each serving a specific purpose.

## Project Structure

- **api**: Contains the API definitions and DTOs.
  - `UserDto.java`: Data Transfer Object for user data.
  - `UserResource.java`: RESTful resource for user-related API requests.
  - `pom.xml`: Maven configuration for the API module.

- **api-impl**: Contains the implementation of the API, including service and repository layers.
  - `UserRepository.java`: Handles database operations related to users.
  - `UserService.java`: Contains business logic related to users.
  - `pom.xml`: Maven configuration for the API implementation module.

- **server**: The entry point of the application and configuration settings.
  - `DatabaseConfig.java`: Configures the database connection settings.
  - `Application.java`: Initializes the MicroProfile application.
  - `resources/db/migration`: Contains SQL migration files for database schema.
  - `META-INF/microprofile-config.properties`: Configuration properties for the MicroProfile application.
  - `pom.xml`: Maven configuration for the server module.

- **jooq-codegen**: Contains configuration for jOOQ code generation.
  - `jooq-codegen.xml`: Configuration for jOOQ code generation.
  - `pom.xml`: Maven configuration for the jOOQ code generation module.

- **docker**: Contains Docker configurations for the application and database.
  - `docker-compose.yml`: Defines Docker services for the backend and PostgreSQL database.
  - `Dockerfile.backend`: Instructions for building the Docker image for the backend application.
  - `Dockerfile.postgres`: Instructions for building the Docker image for the PostgreSQL database.

- **pom.xml**: Root Maven configuration for the entire project.

## Setup Instructions

1. **Clone the Repository**: Clone this repository to your local machine.

2. **Build the Project**: Navigate to the root directory of the project and run:
   ```
   mvn clean install
   ```

3. **Run the Docker Containers**: Navigate to the `docker` directory and run:
   ```
   docker-compose up
   ```

4. **Access the Application**: Once the containers are running, you can access the API at `http://localhost:8080/api/users`.

## Database Migrations

This project uses Flyway for database migrations. The migration scripts are located in `server/src/main/resources/db/migration`. You can add new migration scripts as needed.

## jOOQ Code Generation

jOOQ code generation is configured in `jooq-codegen/src/main/resources/jooq-codegen.xml`. You can run the code generation process using Maven.

## License

This project is licensed under the MIT License. See the LICENSE file for more details.