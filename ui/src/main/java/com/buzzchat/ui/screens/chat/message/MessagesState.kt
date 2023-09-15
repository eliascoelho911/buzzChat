package com.buzzchat.ui.screens.chat.message

import androidx.compose.runtime.Immutable

@Immutable
data class MessagesState(
    val content: MessageContent,
)

@Immutable
sealed interface MessageContent {
    val sender: MessageSender
    val createAt: Long

    @Immutable
    data class Text(
        val text: String,
        override val sender: MessageSender,
        override val createAt: Long,
    ) : MessageContent
}

@Immutable
data class MessageSender(
    val avatarUrl: String,
    val name: String,
    val isMe: Boolean,
)