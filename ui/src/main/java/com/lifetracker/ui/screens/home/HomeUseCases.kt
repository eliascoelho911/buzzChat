package com.lifetracker.ui.screens.home

import com.lifetracker.ui.model.Task
import kotlinx.coroutines.flow.Flow
import org.joda.time.LocalDateTime

typealias GetTasksFromDay = suspend (day: LocalDateTime) -> Flow<List<Task>>