package com.example.skills_tryout.domain.repository

import com.example.skills_tryout.domain.model.Workout
import kotlinx.coroutines.flow.Flow

/**
 * Domain Repository Interface for WorkoutHistory.
 * Contains no Android framework dependencies.
 */
interface WorkoutHistoryRepository {
    fun getWorkoutHistory(): Flow<List<Workout>>
}
