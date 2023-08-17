package com.lifetracker.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.lifetracker.ui.model.Task
import com.lifetracker.ui.theme.LifetrackerTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import org.joda.time.LocalDateTime

@Preview
@Composable
private fun HomeScreenPreview() {
    LifetrackerTheme {
        HomeScreen(
            state = HomeUIState(
                viewModel = HomeViewModel(
                    day = LocalDateTime.now(),
                    getTasksFromDay = {
                        flow {
                            loop()
                            loop()
                            loop()
                            loop()
                            loop()
                        }
                    }
                )
            )
        )
    }
}

private suspend fun FlowCollector<List<Task>>.loop() {
    emit(
        listOf(
            Task(
                title = "Task 1",
                description = "Description 1",
                dueDate = LocalDateTime.now()
            ),
            Task(
                title = "Task 2",
                description = "Description 2",
                dueDate = LocalDateTime.now().plusHours(2)
            ),
            Task(
                title = "Task 3",
                description = "Description 3",
                dueDate = LocalDateTime.now().minusHours(1)
            ),
        )
    )
    delay(5000)
    emit(
        listOf(
            Task(
                title = "Task 1",
                description = "Description 1",
                dueDate = LocalDateTime.now()
            )
        )
    )
    delay(5000)
}