---
name: compose-reviewer
description: Analyzes Jetpack Compose UI code for performance bottlenecks, stability issues, unnecessary recompositions, and incorrect state management. Use when reviewing UI code, optimizing Compose performance, or debugging stutter.
---
# Compose Performance Reviewer

Acts as a strict code reviewer for Jetpack Compose, identifying and fixing common performance pitfalls before they reach production.

## When to Use
- When asked to review a Compose screen or component.
- When troubleshooting UI stutter, lag, or dropped frames in Compose.
- When checking for recomposition loops or stability.

## Rules
1. **Parameter Stability:**
    - Flag any unstable parameters passed to Composables (e.g., standard `List`, `Set`, `Map`, or interfaces like `Any`).
    - Recommend using `kotlinx.collections.immutable` (e.g., `ImmutableList`) or annotating wrapper data classes with `@Immutable` or `@Stable`.
2. **Defer State Reads:**
    - Identify state reads happening in the Composition phase that only affect Layout or Draw phases.
    - Suggest lambda-based modifiers (e.g., `Modifier.offset { IntOffset(...) }` instead of `Modifier.offset(...)`) to defer reads to the Layout phase.
    - Suggest `derivedStateOf` when converting a rapidly changing state (like scroll position) into a less frequently changing state (like a boolean for a "Scroll to Top" button).
3. **Remembering Computations:**
    - Ensure any data sorting, filtering, or heavy object allocations inside a Composable are wrapped in `remember { ... }`.
4. **Lazy List Keys:**
    - Require a unique `key` parameter for `items` inside `LazyColumn` or `LazyRow` to prevent unnecessary recompositions when the list order changes or items are inserted.