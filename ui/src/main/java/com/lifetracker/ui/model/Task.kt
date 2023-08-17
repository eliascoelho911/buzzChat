package com.lifetracker.ui.model

import org.joda.time.LocalDateTime

data class Task(
    val title: String,
    val description: String? = null,
    val dueDate: LocalDateTime
)
