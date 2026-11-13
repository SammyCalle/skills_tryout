package com.example.skills_tryout.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Room Database Entity representing a Workout in the local database.
 */
@Entity(tableName = "workout_history")
data class WorkoutEntity(
    @PrimaryKey
    val id: String,

    @ColumnInfo(name = "workout_name")
    val name: String,

    @ColumnInfo(name = "date_millis")
    val dateMillis: Long
)
