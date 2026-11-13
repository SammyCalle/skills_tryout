package com.example.skills_tryout.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.skills_tryout.data.local.entity.WorkoutEntity
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for WorkoutEntity.
 */
@Dao
interface WorkoutDao {

    @Query("SELECT * FROM workout_history ORDER BY date_millis DESC")
    fun getWorkouts(): Flow<List<WorkoutEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkout(workout: WorkoutEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkouts(workouts: List<WorkoutEntity>)
}
