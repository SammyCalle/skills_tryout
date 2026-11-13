---
name: "edge-to-edge"
description: "Rules for applying modern edge-to-edge UI in Compose."
---
When I ask you to make a screen edge-to-edge:
1. Always call `enableEdgeToEdge()` inside `onCreate` before `setContent`.
2. Do not use `WindowCompat.setDecorFitsSystemWindows`.
3. Always apply `Modifier.safeDrawingPadding()` to the top-level `Scaffold` or container.