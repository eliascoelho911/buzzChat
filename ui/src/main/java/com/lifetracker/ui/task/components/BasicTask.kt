package com.lifetracker.ui.task.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lifetracker.ui.R
import com.lifetracker.ui.common.date.DueDate
import com.lifetracker.ui.theme.LifetrackerTheme

@Composable
fun BasicTask(
    modifier: Modifier = Modifier,
    state: BasicTaskState = rememberBasicTaskState(),
    title: String = "",
    description: String = "",
    isShortDescriptionEnabled: Boolean = false,
    dueDate: DueDate? = null,
) {
    Surface(modifier = modifier) {
        Column(modifier = Modifier.padding(start = 2.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Checkbox(
                    checked = state.isCompleted,
                    onCheckedChange = { state.onCheckedChange(it) }
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = description,
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = if (isShortDescriptionEnabled) 1 else Int.MAX_VALUE,
                        overflow = TextOverflow.Ellipsis
                    )
                    dueDate?.let { dueDate ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(2.dp)
                        ) {
                            CompositionLocalProvider(LocalContentColor provides dueDate.color.contentColor) {
                                Icon(
                                    modifier = Modifier.size(16.dp),
                                    painter = painterResource(id = R.drawable.ic_event),
                                    contentDescription = null
                                )
                                Text(
                                    text = dueDate.value,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Stable
class BasicTaskState(isCompleted: Boolean) {
    var isCompleted by mutableStateOf(isCompleted)
        private set

    fun onCheckedChange(isChecked: Boolean) {
        isCompleted = isChecked
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BasicTaskState

        if (isCompleted != other.isCompleted) return false

        return true
    }

    override fun hashCode(): Int {
        return isCompleted.hashCode()
    }
}

@Composable
fun rememberBasicTaskState(isCompleted: Boolean = false): BasicTaskState = remember {
    BasicTaskState(
        isCompleted = isCompleted,
    )
}

@Preview
@Composable
private fun TaskWithDescriptionPreview() {
    LifetrackerTheme(darkTheme = false) {
        BasicTask(
            state = rememberBasicTaskState(),
            title = "Task with description",
            description = "This is a description of the task",
            isShortDescriptionEnabled = false
        )
    }
}

@Preview
@Composable
private fun TaskExpiredAndCheckedPreview() {
    LifetrackerTheme(darkTheme = false) {
        BasicTask(
            state = rememberBasicTaskState(
                isCompleted = true
            )
        )
    }
}

@Preview
@Composable
private fun TaskNoDueDatePreview() {
    LifetrackerTheme(darkTheme = false) {
        BasicTask(
            state = rememberBasicTaskState()
        )
    }
}