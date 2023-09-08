package com.buzzchat.ui.previews.chat

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.buzzchat.ui.previews.annotations.HorizontalPreview
import com.buzzchat.ui.screens.chat.message.DeliveryStatus
import com.buzzchat.ui.screens.chat.message.Message
import com.buzzchat.ui.screens.chat.message.MessageContent
import com.buzzchat.ui.screens.chat.message.MessageSender
import com.buzzchat.ui.screens.chat.message.MessageState
import com.buzzchat.ui.theme.BuzzChatTheme
import com.eliascoelho911.common.date.getMillis
import org.joda.time.LocalDateTime

@HorizontalPreview
@Composable
private fun SentPreview() {
    BuzzChatTheme {
        MessagePreview(
            state = defaultMessageState(
                deliveryStatus = DeliveryStatus.SENT,
                content = MessageContent.Text("Sent message")
            )
        )
    }
}

@HorizontalPreview
@Composable
private fun DeliveryPreview() {
    BuzzChatTheme {
        MessagePreview(
            state = defaultMessageState(
                deliveryStatus = DeliveryStatus.DELIVERED,
                content = MessageContent.Text("Delivered message")
            )
        )
    }
}

@HorizontalPreview
@Composable
private fun ReadPreview() {
    BuzzChatTheme {
        MessagePreview(
            state = defaultMessageState(
                deliveryStatus = DeliveryStatus.READ,
                content = MessageContent.Text("Read message")
            )
        )
    }
}

@HorizontalPreview
@Composable
private fun MessageFromMePreview() {
    BuzzChatTheme {
        MessagePreview(
            state = defaultMessageState(
                sender = MessageSender.Me(avatarUrl = ""),
                content = MessageContent.Text("Hello, how are you? Have you seen the new episode of the series?")
            )
        )
    }
}

@HorizontalPreview
@Composable
private fun MessageFromOtherPreview() {
    BuzzChatTheme {
        MessagePreview(
            state = defaultMessageState(
                sender = MessageSender.Other(
                    name = "Oliver",
                    avatarUrl = "I'm a fine, thanks. And you? I didn't see yet, but I'm going to see it today."
                )
            )
        )
    }
}

@Composable
private fun MessagePreview(state: MessageState) {
    BuzzChatTheme {
        Message(state = state, modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth())
    }
}

private fun defaultMessageState(
    sender: MessageSender = MessageSender.Me(avatarUrl = ""),
    content: MessageContent = MessageContent.Text("Hello"),
    createAt: Long = LocalDateTime.now().getMillis(),
    deliveryStatus: DeliveryStatus = DeliveryStatus.READ,
) = MessageState(
    sender = sender,
    content = content,
    createAt = createAt,
    deliveryStatus = deliveryStatus,
)