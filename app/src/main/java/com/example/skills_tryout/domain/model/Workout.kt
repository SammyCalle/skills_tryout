package com.example.skills_tryout.domain.model

/**
 * Domain model representing a Workout.
 * Contains no Android framework dependencies.
 */
data class Workout(
    val id: String,
    val name: String,
    val dateMillis: Long
)
