---
name: scaffold-feature
description: Scaffolds Clean Architecture boilerplate (ViewModel, UseCase, Repository) for a new feature. Use when the user asks to create, scaffold, or generate a new feature.
---
# Clean Architecture Feature Scaffolder

Generates the initial boilerplate for a new feature following strict Domain, Data, and Presentation layer separation.

## When to Use
- When asked to scaffold, start, or generate a new feature.
- When creating the initial layers (ViewModel, UseCase, Repository) for a specific business domain.

## Rules
1. **Presentation Layer (ViewModel):**
    - Create a Hilt-injected `ViewModel` annotated with `@HiltViewModel`.
    - Define a data class for the UI state (e.g., `[Feature]UiState`).
    - Expose state using a private `MutableStateFlow` and a public `StateFlow` via `asStateFlow()`.
    - Inject necessary UseCases via the constructor. Do not inject Repositories directly into the ViewModel.
2. **Domain Layer (UseCase & Repository Interface):**
    - Create a specific UseCase class (e.g., `Get[Feature]UseCase`) with a single `operator fun invoke()`.
    - Create an interface for the Repository defining the data operations (e.g., `[Feature]Repository`).
    - **Strict Rule:** Do NOT import any Android framework classes (`android.*` or `androidx.*`) in the Domain layer.
3. **Data Layer (Repository Impl):**
    - Implement the Repository interface in a separate class.
    - Inject local/remote data sources (e.g., Room DAOs, Retrofit API services).
    - Map Data/Network models to Domain models here before returning them.
4. **General Stack:**
    - Use Kotlin Coroutines (`suspend` functions) and `Flow` for all asynchronous operations.