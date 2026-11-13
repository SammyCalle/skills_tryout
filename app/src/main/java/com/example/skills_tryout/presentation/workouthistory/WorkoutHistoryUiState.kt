package com.example.skills_tryout.presentation.workouthistory

import com.example.skills_tryout.domain.model.Workout

/**
 * UI State for the WorkoutHistory screen.
 */
data class WorkoutHistoryUiState(
    val isLoading: Boolean = false,
    val workouts: List<Workout> = emptyList(),
    val error: String? = null
)
