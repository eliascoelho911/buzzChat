package com.lifetracker.ui.common.date

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.joda.time.LocalDateTime

data class DueDate(
    val value: String,
    val color: DueDateColor
)

data class DueDateColor(
    val contentColor: Color
) {
    companion object {
        @Composable
        fun expired(): DueDateColor {
            return DueDateColor(
                contentColor = MaterialTheme.colorScheme.error
            )
        }

        @Composable
        fun upcoming(): DueDateColor {
            return DueDateColor(
                contentColor = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
fun dueDate(date: LocalDateTime): DueDate {
    return if (date.isBefore(LocalDateTime.now())) {
        DueDate(
            value = date.toHoursMinutes(),
            color = DueDateColor.expired(),
        )
    } else {
        DueDate(
            value = date.toHoursMinutes(),
            color = DueDateColor.upcoming(),
        )
    }
}
