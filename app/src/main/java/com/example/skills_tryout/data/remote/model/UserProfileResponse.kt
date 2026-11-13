package com.example.skills_tryout.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data class generated from UserProfileResponse schema.
 */
@Serializable
data class UserProfileResponse(
    @SerialName("user_id")
    val userId: String,
    
    @SerialName("username")
    val username: String,
    
    @SerialName("is_premium_member")
    val isPremiumMember: Boolean,
    
    @SerialName("recent_workouts")
    val recentWorkouts: List<String>? = null
)
