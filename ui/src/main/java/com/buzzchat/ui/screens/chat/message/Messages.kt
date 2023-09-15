package com.buzzchat.ui.screens.chat.message

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.buzzchat.ui.common.compose.getUserLocale
import com.buzzchat.ui.components.image.ProfileImage
import com.buzzchat.ui.screens.chat.message.MessageUIManager.avatarSize
import com.buzzchat.ui.screens.chat.message.MessageUIManager.backgroundColor
import com.buzzchat.ui.screens.chat.message.MessageUIManager.internalContentPadding
import com.buzzchat.ui.screens.chat.message.MessageUIManager.messageAvatarSpacing
import com.buzzchat.ui.screens.chat.message.MessageUIManager.messageShape
import com.buzzchat.ui.screens.chat.message.MessageUIManager.messageTextStyle
import com.buzzchat.ui.screens.chat.message.MessageUIManager.minHeightOfMessageContent
import com.buzzchat.ui.screens.chat.message.MessageUIManager.spacingBetweenContentAndInfo
import com.buzzchat.ui.screens.chat.message.MessageUIManager.spacingBetweenInfoItems
import com.buzzchat.ui.screens.chat.message.MessageUIManager.timeTextStyle
import com.eliascoelho911.common.date.formatToHours
import com.eliascoelho911.common.date.localDateTime
import java.util.Locale

@Composable
fun Messages(state: MessagesState, modifier: Modifier = Modifier) {
    with(state) {
        Row(
            modifier = Modifier
                .sizeIn(minHeight = minHeightOfMessageContent)
                .then(modifier),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.spacedBy(messageAvatarSpacing),
        ) {
            val sender = content.sender

            if (!sender.isMe) Avatar(sender.avatarUrl)

            MessageContent(state)

            if (sender.isMe) Avatar(sender.avatarUrl)
        }
    }
}

@Composable
private fun RowScope.MessageContent(state: MessagesState) {
    MessageContent(
        state = state,
        modifier = Modifier.weight(1f, fill = false)
    )
}

@Composable
private fun MessageContent(
    state: MessagesState,
    modifier: Modifier = Modifier,
    locale: Locale = getUserLocale(),
) {
    Chip
    with(state.content) {
        Surface(
            shape = messageShape(sender),
            color = backgroundColor,
            modifier = modifier
        ) {
            val horizontalAlignment = if (sender.isMe) {
                Alignment.End
            } else {
                Alignment.Start
            }

            Column(
                modifier = Modifier
                    .sizeIn(minHeight = minHeightOfMessageContent)
                    .padding(internalContentPadding),
                verticalArrangement = Arrangement.spacedBy(spacingBetweenContentAndInfo),
                horizontalAlignment = horizontalAlignment
            ) {
                when (this@with) {
                    is MessageContent.Text -> Text(
                        text = text,
                        style = messageTextStyle
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(spacingBetweenInfoItems)
                ) {
                    val time = localDateTime(createAt).formatToHours(locale = locale)
                    Text(text = time, style = timeTextStyle)
                }
            }
        }
    }
}

@Composable
private fun Avatar(avatarUrl: String) {
    Avatar(avatarUrl = avatarUrl, modifier = Modifier.size(avatarSize))
}

@Composable
private fun Avatar(avatarUrl: String, modifier: Modifier = Modifier) {
    ProfileImage(url = avatarUrl, modifier = modifier)
}

private object MessageUIManager {
    val backgroundColor @Composable get() = MaterialTheme.colorScheme.surfaceVariant

    val internalContentPadding = 8.dp

    val messageAvatarSpacing = 8.dp

    val minHeightOfMessageContent = 48.dp

    val spacingBetweenContentAndInfo = 8.dp

    val spacingBetweenInfoItems = 4.dp

    val avatarSize = 28.dp

    val messageTextStyle @Composable get() = MaterialTheme.typography.bodySmall

    val timeTextStyle @Composable get() = MaterialTheme.typography.labelSmall

    @Composable
    fun messageShape(sender: MessageSender): Shape {
        return if (sender.isMe) {
            MaterialTheme.shapes.medium.copy(bottomEnd = CornerSize(0.dp))
        } else {
            MaterialTheme.shapes.medium.copy(bottomStart = CornerSize(0.dp))
        }
    }
}