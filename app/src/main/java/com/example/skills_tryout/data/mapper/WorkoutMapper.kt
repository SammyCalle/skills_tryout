package com.example.skills_tryout.data.mapper

import com.example.skills_tryout.data.local.entity.WorkoutEntity
import com.example.skills_tryout.domain.model.Workout

/**
 * Maps the Room [WorkoutEntity] to the Domain [Workout] model.
 */
fun WorkoutEntity.toDomain(): Workout {
    return Workout(
        id = id,
        name = name,
        dateMillis = dateMillis
    )
}

/**
 * Maps the Domain [Workout] model to the Room [WorkoutEntity].
 */
fun Workout.toEntity(): WorkoutEntity {
    return WorkoutEntity(
        id = id,
        name = name,
        dateMillis = dateMillis
    )
}
