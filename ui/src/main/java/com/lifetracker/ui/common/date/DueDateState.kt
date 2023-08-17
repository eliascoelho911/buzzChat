package com.lifetracker.ui.common.date

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.lifetracker.ui.common.util.date.formatToHoursMinutes
import org.joda.time.LocalDateTime

data class DueDateState(
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
fun LocalDateTime.toDueDateState(): DueDateState {
    return if (isBefore(LocalDateTime.now())) {
        DueDateState(
            value = formatToHoursMinutes(),
            color = DueDateColor.expired(),
        )
    } else {
        DueDateState(
            value = formatToHoursMinutes(),
            color = DueDateColor.upcoming(),
        )
    }
}
