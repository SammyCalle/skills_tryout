---
name: legacy-migrator
description: Safely migrates legacy Android code to a modern stack. Converts XML layouts to Jetpack Compose and translates Java callback interfaces (often from external hardware or third-party SDKs) into Kotlin Coroutines and Flow.
---
# Legacy to Modern Migrator

Acts as an expert refactoring assistant to modernize legacy Android codebases without breaking existing business logic.

## When to Use
- When asked to convert an XML layout file into Jetpack Compose.
- When migrating Java code to Kotlin.
- When modernizing old listener/callback interfaces into Coroutines or Flow.

## Rules
1. **XML to Compose Migration:**
    - Translate `<LinearLayout>` and `<FrameLayout>` directly into Compose `Column`, `Row`, or `Box`.
    - Only use Compose `ConstraintLayout` if the original XML had complex, flat inter-dependencies that cannot be easily solved with nested Rows/Columns.
    - Migrate XML attributes (margins, padding, background) strictly into chained `Modifier` functions.
    - Convert all `@string/...` and `@color/...` references to `stringResource(...)` and `MaterialTheme.colorScheme...`.
2. **Java Callbacks to Coroutines (One-Shot):**
    - For single-result callbacks (like network requests or simple SDK hardware triggers), wrap the legacy call in `suspendCancellableCoroutine`.
    - Ensure you call `continuation.resume()` on success and `continuation.resumeWithException()` on failure.
    - Handle cancellation by cleaning up the listener inside `continuation.invokeOnCancellation { ... }`.
3. **Java Listeners to Flow (Streaming):**
    - For continuous data streams (like scanner events, location updates, or sensor data), wrap the legacy listener in a `callbackFlow { ... }`.
    - Use `trySend()` to emit values safely.
    - **Crucial:** You must always include `awaitClose { ... }` to unregister the listener when the Flow collector is cancelled.
4. **General Modernization:**
    - Completely remove `findViewById`, ViewBinding, and DataBinding boilerplate from the migrated output.
    - Ensure the resulting Kotlin code uses idiomatic syntax (e.g., `let`, `apply`, default arguments, and null-safety).