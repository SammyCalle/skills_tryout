---
name: room-entity-setup
description: Generates Room Database entities, DAOs, and mapping functions for the Data layer. Use when asked to create local database components, DAOs, or offline-first storage.
---
# Room Database Setup

Generates the local data layer components using Room, ensuring strict separation between Data models (Entities) and pure Domain models.

## When to Use
- When asked to create database tables, entities, or DAOs.
- When setting up offline-first caching or local storage for a feature.

## Rules
1. **Room Entity (`[Feature]Entity.kt`):**
    - Create a data class annotated with `@Entity(tableName = "...")`.
    - Define a primary key using `@PrimaryKey(autoGenerate = true)` or a specific ID field.
    - Use `@ColumnInfo` if the column name should explicitly differ from the variable name.
2. **Room DAO (`[Feature]Dao.kt`):**
    - Create an interface annotated with `@Dao`.
    - Use `suspend` functions for one-shot operations (`@Insert`, `@Update`, `@Delete`).
    - Default to `@Insert(onConflict = OnConflictStrategy.REPLACE)` for insert operations.
    - Use `Flow<List<[Feature]Entity>>` for read operations (`@Query`) that need to be observed reactively. (Do NOT use `suspend` when returning a `Flow`).
3. **Domain Mappers (`[Feature]Mapper.kt`):**
    - Generate Kotlin extension functions to map the Room Entity to the Domain model (e.g., `fun [Feature]Entity.toDomain(): [Feature]`).
    - Generate extension functions to map the Domain model to the Room Entity (e.g., `fun [Feature].toEntity(): [Feature]Entity`).
    - Never expose the Room Entity directly to the Domain or Presentation layers.