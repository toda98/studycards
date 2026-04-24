# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Tech-Stack

| Layer | Technology |
|---|---|
| Frontend | React + TypeScript *(planned)* |
| Backend | Java 21, Spring Boot 3.x |
| Database | PostgreSQL |
| ORM | Spring Data JPA |
| Migrations | Flyway *(planned)* |
| Build | Maven |

## Architecture

Spring Boot REST API following a strict layered architecture — `com.tommydang.studycards`:

| Package | Purpose |
|---|---|
| `entity` | JPA entities — the domain model |
| `repository` | Spring Data `CrudRepository` interfaces |
| `service` | Business logic; `@Transactional` where needed |
| `controller` | REST endpoints — thin, delegate to services |
| `dto` | Request/Response POJOs (entities never exposed directly) |
| `mapper` | `@Component` beans converting entity → DTO |
| `enums` | Shared enum types |
| `exception` | Custom exceptions + `@RestControllerAdvice` global handler |
| `init` | `CommandLineRunner` beans for seed data on startup |

## Domain Model

**Core game flow:** `GameSession` → `GameSessionStudyModule` (rich join entity) ↔ `StudyModule`

**Card hierarchy** (single-table inheritance, discriminator: `card_type`):
- `Card` (abstract) — many-to-many with `CardEffect`
  - `PlayerCard` — adds `energyCost`
  - `ModuleCard`

**`CardEffect`** drives all game mechanics via: `operatorType` (ADD/SUB/MUL/DIV) · `value` · `resourceType` (LEARN_PROGRESS/STRESS/ENERGY) · `targetType` (PLAYER/SINGLE_SELECTED_MODULE/SINGLE_RANDOM_MODULE/MULTIPLE_RANDOM_MODULES/ALL_MODULES)

**`GameSession`** tracks player name, field of study, semester, turn counter, stress/energy pools, and status: NEW → IN_PROGRESS → WON/LOST/ABANDONED. Holds `Set<PlayerCard> handCards` via `@ManyToMany` (join table `game_session_hand_cards`).

**`GameSessionStudyModule`** is a rich join entity — not just a foreign key table. It holds `currentLearnProgress`, `currentTries`/`maxTries`, and its own status (IN_PROGRESS/PASSED/FAILED).

**`FieldOfStudy`** — groups `StudyModule`s for a field (e.g. Informatik). Referenced by `GameSession` via `@ManyToOne`; modules linked via `@ManyToMany`.


## Game Rules

- Player starts with fixed energy and stress values
- Playing a card costs energy; a card triggers one or more effects
- A module is passed when `currentLearnProgress >= requiredLearnProgress`
- A turn ends manually via `end-turn`; energy resets to max after each turn
- A semester ends after 20 turns
- Game over when stress reaches maximum
- Victory when all selected modules are passed

## Planned Services

| Service | Responsibility |
|---|---|
| `GameService` | Central game flow: start, load, save, get state |
| `TurnService` | End turn, turn counter, energy reset, game-over check |
| `CardService` | Draw card, validate playability |
| `CardEffectService` | Apply effects to player stats and module progress |
| `SemesterService` | *(optional)* Semester transition |

## Coding Conventions

| Type | Pattern | Example |
|---|---|---|
| Entity | `PascalCase` | `GameSession` |
| Repository | `<Entity>Repository` | `GameSessionRepository` |
| Service | `<Domain>Service` | `TurnService` |
| Controller | `<Entity>Controller` | `GameSessionController` |
| Request DTO | `<Verb><Entity>Request` | `CreateGameSessionRequest` |
| Response DTO | `<Entity>Response` | `GameSessionResponse` |
| Mapper | `<Entity>Mapper` | `GameSessionMapper` |
| Exception | `<Entity>NotFoundException` | `GameSessionNotFoundException` |
| Initializer | `<Domain>DataInitializer` | `CardDataInitializer` |

Packages stay flat — no sub-packages within a layer.

## REST Endpoints

| Method | Path                            | Description                               |
|--------|---------------------------------|-------------------------------------------|
| `POST` | `/games`                        | Create a game session with fieldOfStudyId |
| `GET`  | `/games/{id}`                   | Get game session by ID                    |
| `POST` | `/games/{id}/modules`           | Assign study modules to a session         |
| `GET`  | `/study-modules`                | List all available study modules          |
| `GET`  | `/fields-of-study`              | List all fields of study                  |
| `GET`  | `/fields-of-study/{id}/modules` | Get study modules for a field             |

Validation errors → 400 with field details. Not found → 404. Both handled centrally in `GlobalExceptionHandler`.  
HTTP test requests are in `request.http` (happy path + error cases).

## Database

PostgreSQL on `localhost:5432/studycards`. Schema managed by Hibernate (`ddl-auto=update`). SQL logging enabled in dev. All PKs use `SEQUENCE` generation strategy.

`CardDataInitializer` (implements `CommandLineRunner`) seeds cards and effects on startup — implementation must be idempotent (check-then-insert).

## Backlog

### In Progress

### Todo — Backend
- [ ] `TurnService` — end turn, counter, energy reset, game-over check
- [ ] `CardService` — draw card, validate playability
- [ ] `CardEffectService` — apply effects to stats and module progress
- [ ] `GameService` — start, load, save, get state
- [ ] Save & load game state
- [ ] Flyway migrations

### Todo — Frontend
- [ ] React + TypeScript project setup
- [ ] Game start screen (name, field of study, module selection)
- [ ] Game board (hand, status values, end turn)
- [ ] Load game screen

### Done
- [x] Domain model: `GameSession`, `StudyModule`, `GameSessionStudyModule`
- [x] REST endpoints: create/get session, assign/list modules
- [x] Card hierarchy with `CardEffect` (single-table inheritance)
- [x] `CardDataInitializer` (seed data initializer wired up)
- [x] Seed initial cards and effects (`CardDataInitializer`)
- [x] GameSession.selectedFieldOfStudy migration to @ManyToOne FieldOfStudy
- [x] FieldOfStudy entity, repository, seed data, REST endpoints
- [x] FieldOfStudyDataInitializer and StudyModuleDataInitializer implemented
- [x] StudyModule.creditPoints field added + @ManyToMany FieldOfStudy relation
- [x] GameSession.handCards added as @ManyToMany PlayerCard (join table game_session_hand_cards); PlayerCardResponse + CardEffectResponse DTOs + mappers added; GET /games/{id} returns handCards

## Commands

```bash
mvn spring-boot:run                      # Run application
mvn test                                 # Run all tests
mvn test -Dtest=ClassName#methodName     # Run single test
mvn clean install                        # Build
```
