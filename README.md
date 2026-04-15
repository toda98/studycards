# StudyCards

A turn-based card game where players manage their university studies. Choose your field of study, pick your modules, and survive the semester by playing cards that affect your learn progress, stress, and energy.

## Tech Stack

| Layer | Technology |
|---|---|
| Backend | Java 21, Spring Boot 3.x |
| Database | PostgreSQL |
| ORM | Spring Data JPA |
| API | REST |
| Build | Maven |
| Frontend *(planned)* | React + TypeScript |
| Migrations *(planned)* | Flyway |

## Getting Started

**Prerequisites:** Java 21, Maven, PostgreSQL running on `localhost:5432`

Create a database named `studycards` and update credentials in `src/main/resources/application.properties` if needed (default: `postgres` / `root`).

```bash
# Run the application
mvn spring-boot:run

# Run tests
mvn test
```

The API is available at `http://localhost:8080`.

## API Endpoints

| Method | Path | Description |
|---|---|---|
| `POST` | `/games` | Start a new game session |
| `GET` | `/games/{id}` | Get current game state |
| `POST` | `/games/{id}/modules` | Assign study modules to a session |
| `GET` | `/study-modules` | List all available study modules |

See `request.http` for ready-to-run example requests.

## Architecture

The backend follows a layered architecture with strict separation of concerns:

```
controller  →  service  →  repository  →  database
                ↕
              entity / dto / mapper
```

- **Entities** are never exposed directly — all responses use DTOs mapped by dedicated `@Component` mapper classes.
- **Services** own all business logic and are the only layer that writes to the database.
- **Exception handling** is centralized in `GlobalExceptionHandler` (`@RestControllerAdvice`).

### Domain Model

```
GameSession
  └── GameSessionStudyModule (rich join entity)
        └── StudyModule

Card (abstract, single-table inheritance)
  ├── PlayerCard  (has energyCost)
  └── ModuleCard
        └── CardEffect  (operatorType, value, resourceType, targetType)
```

`CardEffect` drives all game mechanics — each effect defines an operator (ADD/SUB/MUL/DIV), a value, a target resource (LEARN_PROGRESS/STRESS/ENERGY), and a target scope (player, one module, all modules, etc.).

## Game Rules

- Player starts with fixed energy and stress values
- Playing a card costs energy
- A card triggers one or more effects that modify resources
- A module is passed when `currentLearnProgress >= requiredLearnProgress`
- A turn ends manually via `end-turn`
- Energy resets to max after each turn
- A semester ends after 20 turns
- Game over when stress reaches maximum
- Victory when all selected modules are passed

## Roadmap

### Backend
- [ ] Seed initial cards and effects
- [ ] `TurnService` — end turn, counter, energy reset, game-over check
- [ ] `CardService` — draw card, validate playability
- [ ] `CardEffectService` — apply effects to player stats and module progress
- [ ] `GameService` — central game flow: start, load, save, get state
- [ ] Save & load game state
- [ ] Flyway migrations

### Frontend
- [ ] React + TypeScript project setup
- [ ] Game start screen (name, field of study, module selection)
- [ ] Game board (hand, status values, end turn)
- [ ] Load game screen