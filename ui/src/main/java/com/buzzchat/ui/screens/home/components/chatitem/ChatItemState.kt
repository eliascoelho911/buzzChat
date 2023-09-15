package com.buzzchat.ui.screens.home.components.chatitem

import androidx.compose.runtime.Immutable
import com.buzzchat.ui.features.chat.model.Chat

@Immutable
data class ChatItemState(
    val id: String,
    val avatarUrl: String,
    val chatName: String,
    val lastMessage: String,
    val lastMessageMillis: Long,
    val unreadMessages: Int,
    // todo rever depois
    val isTyping: Boolean = false,
) {
    val showUnreadBadge: Boolean
        get() = unreadMessages > 0
}

fun List<Chat>.toState(): List<ChatItemState> =
    mapNotNull { it.toState() }

fun Chat.toState(): ChatItemState? =
    messages.lastOrNull()?.let { lastMessage ->
        val otherUser = otherUsers.first()
        ChatItemState(
            id = id,
            avatarUrl = otherUser.avatarUrl,
            chatName = otherUser.fullName,
            lastMessage = lastMessage.content,
            lastMessageMillis = lastMessage.createAt,
            unreadMessages = messages.filter { it.sender.username != loggedUser.username }
                .count { !it.isRead },
        )
    }
