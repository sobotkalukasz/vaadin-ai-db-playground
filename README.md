# Vaadin AI DB Playground

Initial Java Vaadin application for experimenting with Vaadin 25.2 AI preview features after data has been imported into PostgreSQL.

## Stack

- Java 25 LTS
- Maven
- Spring Boot 4.1.x
- Vaadin 25.2.x
- PostgreSQL, Flyway, Spring Data JPA
- Spring WebClient
- JUnit 5

## GitHub Codespaces

Open the repository in Codespaces. The devcontainer provides Java 25 and Docker support. Start PostgreSQL with:

```bash
docker compose up -d postgres
```

## Local PostgreSQL with Docker Compose

```bash
docker compose up -d postgres
```

The default local database is `jdbc:postgresql://localhost:5432/playground` with username/password `playground`.

## Environment variables

The app reads configuration from environment variables:

- `DATABASE_URL` - JDBC URL for PostgreSQL, defaults to `jdbc:postgresql://localhost:5432/playground`
- `DATABASE_USERNAME` - database username, defaults to `playground`
- `DATABASE_PASSWORD` - database password, defaults to `playground`
- `EXTERNAL_API_BASE_URL` - external REST API base URL, defaults to `http://localhost:8081`
- `OPENAI_API_KEY` - reserved for future AI features

Do not configure an external API token as an environment variable. Manual imports ask for an API key/token in the Vaadin UI and keep it in memory only for that import request.

## Run locally

```bash
./mvnw spring-boot:run
```

Then open <http://localhost:8080>.

## Tests

```bash
./mvnw clean verify
```

Production Vaadin build:

```bash
./mvnw -Pproduction clean package -DskipTests
```

## Import architecture

Manual imports are designed around `ExternalDataImporter` implementations. `ImportOrchestrator` discovers importers, creates an `ImportRun`, runs the selected importer, and stores sanitized results. The first endpoint importer is a placeholder skeleton using configured endpoint paths and placeholder DTOs until real API details are provided.

## Future deployment

Build a production artifact with the production Maven profile or the provided Dockerfile. Provide PostgreSQL connection settings through environment variables in the deployment platform. AI views and Vaadin AI components are intentionally not implemented yet.
