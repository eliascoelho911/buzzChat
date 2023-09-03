package com.buzzchat.ui.screens.home.components.chatitem

import androidx.compose.runtime.Immutable
import com.buzzchat.ui.features.chat.model.Chat
import com.buzzchat.ui.features.chat.model.PrivateChat

@Immutable
data class ChatItemState(
    val id: String,
    val avatarUrl: String,
    val personName: String,
    val lastMessage: String,
    val lastMessageMillis: Long,
    val unreadMessages: Int,
    val isTyping: Boolean,
) {
    val showUnreadBadge: Boolean
        get() = unreadMessages > 0
}

fun List<Chat>.toState(): List<ChatItemState> =
    mapNotNull { it.toState() }

fun Chat.toState(): ChatItemState? =
    when (this) {
        is PrivateChat -> {
            messages.lastOrNull()?.let { lastMessage ->
                ChatItemState(
                    id = id,
                    avatarUrl = otherUser.avatarUrl,
                    personName = otherUser.name,
                    lastMessage = lastMessage.content,
                    lastMessageMillis = lastMessage.createAt,
                    unreadMessages = messages.filter { it.sender.id != loggedUser.id }
                        .count { !it.isRead },
                    isTyping = otherUserIsTyping,
                )
            }
        }
    }
