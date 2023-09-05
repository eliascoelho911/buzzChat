package com.buzzchat.ui.screens.chat.message

import androidx.compose.runtime.Immutable

@Immutable
data class MessageState(
    val sender: MessageSender,
    val content: MessageContent,
    val createAt: Long,
    val deliveryStatus: DeliveryStatus,
)

@Immutable
sealed interface MessageSender {
    @Immutable
    data class Me(
        val avatarUrl: String,
    ) : MessageSender

    @Immutable
    data class Other(
        val name: String?,
        val avatarUrl: String,
    ) : MessageSender
}

@Immutable
sealed interface MessageContent {
    data class Text(val text: String) : MessageContent
}

@Immutable
enum class DeliveryStatus {
    SENT,
    DELIVERED,
    SEEN,
}