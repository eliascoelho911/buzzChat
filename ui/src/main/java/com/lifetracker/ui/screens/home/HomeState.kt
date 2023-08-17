package com.lifetracker.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.lifetracker.ui.model.Task

@Stable
class HomeUIState(
    private val viewModel: HomeViewModel
) {
    val state: HomeState @Composable get() = viewModel.state.collectAsStateWithLifecycle().value
    val tasks: List<Task> @Composable get() = state.tasks

    fun onAddTask() {
        // Todo: Navigate to add task screen
    }
}

@Immutable
data class HomeState(
    val tasks: List<Task> = emptyList()
)