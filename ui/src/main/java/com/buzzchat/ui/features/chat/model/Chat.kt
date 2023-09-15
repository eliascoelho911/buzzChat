package com.buzzchat.ui.features.chat.model

import com.buzzchat.ui.features.user.model.User

data class Chat(
    val id: String,
    val messages: List<Message>,
    val loggedUser: User,
    val otherUsers: List<User>,
)