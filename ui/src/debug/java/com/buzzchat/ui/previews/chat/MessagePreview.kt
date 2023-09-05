package com.buzzchat.ui.previews.chat

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.buzzchat.ui.screens.chat.message.DeliveryStatus
import com.buzzchat.ui.screens.chat.message.Message
import com.buzzchat.ui.screens.chat.message.MessageContent
import com.buzzchat.ui.screens.chat.message.MessageSender
import com.buzzchat.ui.screens.chat.message.MessageState
import com.buzzchat.ui.theme.BuzzChatTheme
import com.eliascoelho911.common.date.getMillis
import org.joda.time.LocalDateTime

@Preview(showBackground = true)
@Composable
private fun DeliveryStatusPreview(@PreviewParameter(DeliveryStatusParameterProvider::class) deliveryStatus: DeliveryStatus) {
    BuzzChatTheme {
        Message(state = defaultMessageState(deliveryStatus = deliveryStatus))
    }
}

private class DeliveryStatusParameterProvider : PreviewParameterProvider<DeliveryStatus> {
    override val values: Sequence<DeliveryStatus> = DeliveryStatus.values().asSequence()
}

@Preview(showBackground = true)
@Composable
private fun MessageSenderPreview(@PreviewParameter(MessageSenderParameterProvider::class) messageSender: MessageSender) {
    BuzzChatTheme {
        Message(state = defaultMessageState(sender = messageSender))
    }
}

private class MessageSenderParameterProvider : PreviewParameterProvider<MessageSender> {
    override val values: Sequence<MessageSender> = sequenceOf(
        MessageSender.Me(avatarUrl = ""),
        MessageSender.Other(name = null, avatarUrl = ""),
        MessageSender.Other(name = "Elias", avatarUrl = "")
    )
}

private fun defaultMessageState(
    sender: MessageSender = MessageSender.Me(avatarUrl = ""),
    content: MessageContent = MessageContent.Text("Hello"),
    createAt: Long = LocalDateTime.now().getMillis(),
    deliveryStatus: DeliveryStatus = DeliveryStatus.SENT,
) = MessageState(
    sender = sender,
    content = content,
    createAt = createAt,
    deliveryStatus = deliveryStatus,
)