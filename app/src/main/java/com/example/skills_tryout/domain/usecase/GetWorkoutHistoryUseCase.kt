package com.example.skills_tryout.domain.usecase

import com.example.skills_tryout.domain.model.Workout
import com.example.skills_tryout.domain.repository.WorkoutHistoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * UseCase for retrieving the workout history.
 * Contains no Android framework dependencies.
 */
class GetWorkoutHistoryUseCase @Inject constructor(
    private val repository: WorkoutHistoryRepository
) {
    operator fun invoke(): Flow<List<Workout>> {
        return repository.getWorkoutHistory()
    }
}
