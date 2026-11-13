package com.example.skills_tryout.data.repository

import com.example.skills_tryout.domain.model.Workout
import com.example.skills_tryout.domain.repository.WorkoutHistoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

/**
 * Data layer implementation of the [WorkoutHistoryRepository].
 */
class WorkoutHistoryRepositoryImpl @Inject constructor(
    // TODO: Inject local DAO or remote Api Service here
) : WorkoutHistoryRepository {

    override fun getWorkoutHistory(): Flow<List<Workout>> {
        // TODO: Fetch data from the data source and map data/network models to the domain Workout model
        return flowOf(emptyList())
    }
}
