package com.buzzchat.ui.features.chat.model

import com.buzzchat.ui.features.user.model.User

sealed interface Chat {
    val id: String
    val messages: List<Message>
    val loggedUser: User
}

data class PrivateChat(
    override val id: String,
    override val messages: List<Message>,
    override val loggedUser: User,
    val otherUser: User,
    val otherUserIsTyping: Boolean,
) : Chat