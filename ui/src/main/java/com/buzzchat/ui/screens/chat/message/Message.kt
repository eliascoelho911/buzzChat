package com.buzzchat.ui.screens.chat.message

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.buzzchat.ui.components.image.ProfileImage
import com.eliascoelho911.common.date.formatToHours
import com.eliascoelho911.common.date.localDateTime

@Composable
fun Message(state: MessageState, modifier: Modifier = Modifier) {
    val locale = LocalConfiguration.current.locales[0]

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        if (state.sender is MessageSender.Other) {
            Avatar(avatarUrl = state.sender.avatarUrl)
        }

        MessageContent(
            content = state.content,
            time = localDateTime(state.createAt).formatToHours(locale = locale),
            sender = state.sender
        )

        if (state.sender is MessageSender.Me) {
            Avatar(avatarUrl = state.sender.avatarUrl)
        }
    }
}

@Composable
private fun Avatar(avatarUrl: String) {
    Box {
        ProfileImage(url = avatarUrl)
    }
}

@Composable
private fun MessageContent(content: MessageContent, time: String, sender: MessageSender) {
    Column(horizontalAlignment = Alignment.End) {
        when (content) {
            is MessageContent.Text -> TextContent(content = content, shape = messageShape(sender))
        }
        Text(text = time, style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
private fun TextContent(
    content: MessageContent.Text,
    shape: Shape,
) {
    Surface(shape = shape, color = MessageColor) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = content.text,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
private fun messageShape(sender: MessageSender): Shape {
    return if (sender is MessageSender.Me) {
        MaterialTheme.shapes.medium.copy(bottomEnd = CornerSize(0.dp))
    } else {
        MaterialTheme.shapes.medium.copy(bottomStart = CornerSize(0.dp))
    }
}

private val MessageColor @Composable get() = MaterialTheme.colorScheme.primaryContainer