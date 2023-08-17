package com.lifetracker.ui.screens.home

import androidx.lifecycle.viewModelScope
import com.lifetracker.ui.common.arch.StateViewModel
import kotlinx.coroutines.launch
import org.joda.time.LocalDateTime

class HomeViewModel(
    private val day: LocalDateTime,
    private val getTasksFromDay: GetTasksFromDay
) : StateViewModel<HomeState>(HomeState()) {
    init {
        onInit()
    }

    private fun onInit() {
        viewModelScope.launch {
            getTasksFromDay(day).collect { tasks ->
                setState {
                    it.copy(
                        tasks = tasks
                    )
                }
            }
        }
    }
}