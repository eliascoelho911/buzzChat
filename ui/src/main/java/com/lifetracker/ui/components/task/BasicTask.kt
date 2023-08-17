package com.lifetracker.ui.components.task

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
import com.lifetracker.ui.common.date.toDueDateState
import com.lifetracker.ui.model.Task
import com.lifetracker.ui.theme.LifetrackerTheme
import org.joda.time.LocalDateTime

@Composable
fun BasicTask(
    modifier: Modifier = Modifier,
    state: BasicTaskState = rememberBasicTaskState(),
    task: Task,
    isShortDescriptionEnabled: Boolean = false,
) {
    with(task) {
        Surface(modifier = modifier) {
            Column(
                modifier = Modifier.padding(
                    start = 2.dp,
                    end = 16.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
            ) {
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
                        description?.let {
                            Text(
                                text = it,
                                style = MaterialTheme.typography.bodyMedium,
                                maxLines = if (isShortDescriptionEnabled) 1 else Int.MAX_VALUE,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        dueDate.toDueDateState().let { dueDate ->
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

        return isCompleted == other.isCompleted
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
            task = Task(
                title = "Task with description",
                description = "This is a description of the task",
                dueDate = LocalDateTime.now()
            ),
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
            ),
            task = Task(
                title = "Task with description",
                description = "This is a description of the task",
                dueDate = LocalDateTime.now()
            )
        )
    }
}