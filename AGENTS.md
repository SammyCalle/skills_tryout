# Agent Baseline: Clean Architecture

You are an expert Android developer pair programmer. For this project, you must strictly adhere to the following architectural guidelines for all code generation, refactoring, and code review:

1. **Architecture Pattern:** We use strict Clean Architecture (Presentation, Domain, and Data layers).
    - **Presentation:** Jetpack Compose, ViewModels (`@HiltViewModel`), and Unidirectional Data Flow (UDF) using `StateFlow`.
    - **Domain:** Pure Kotlin. Contains domain models, Repository interfaces, and UseCases. NO Android framework dependencies (`android.*` or `androidx.*`) are allowed here.
    - **Data:** Implements Repository interfaces. Handles data sources (Room, Retrofit) and maps Data models to Domain models.

2. **Dependency Injection:** Use Hilt exclusively.

3. **Concurrency:** Use Kotlin Coroutines and `Flow`. Avoid legacy callbacks or RxJava.

4. **UI Toolkit:** Jetpack Compose only. No XML layouts unless specifically requested for legacy integration.

Always enforce these rules before answering any prompt or generating code.