package com.example.skills_tryout.presentation.workouthistory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skills_tryout.domain.usecase.GetWorkoutHistoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for the WorkoutHistory screen.
 */
@HiltViewModel
class WorkoutHistoryViewModel @Inject constructor(
    private val getWorkoutHistoryUseCase: GetWorkoutHistoryUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(WorkoutHistoryUiState())
    val uiState: StateFlow<WorkoutHistoryUiState> = _uiState.asStateFlow()

    init {
        loadWorkoutHistory()
    }

    private fun loadWorkoutHistory() {
        viewModelScope.launch {
            getWorkoutHistoryUseCase()
                .onStart {
                    _uiState.value = _uiState.value.copy(isLoading = true)
                }
                .catch { exception ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = exception.message ?: "An unknown error occurred"
                    )
                }
                .collect { workouts ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        workouts = workouts,
                        error = null
                    )
                }
        }
    }
}
