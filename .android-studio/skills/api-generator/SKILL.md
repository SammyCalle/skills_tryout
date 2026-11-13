---
name: api-generator
description: Generates Kotlin data classes from network responses.
---
# API Generator

## Rules
1. **Reference the Schema:** When generating a new data class, you MUST read the `templates/response_schema.json` file located in this skill directory.
2. **Naming Convention:** Use standard Java/Kotlin camelCase for property names. You MUST use the `@SerialName("...")` annotation to map each property to the exact JSON key defined in the schema.
3. **Serialization:** Annotate all generated classes with `@Serializable`.