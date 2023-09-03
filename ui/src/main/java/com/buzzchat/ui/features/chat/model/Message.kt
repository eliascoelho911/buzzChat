package com.buzzchat.ui.features.chat.model

import com.buzzchat.ui.features.user.model.User

data class Message(
    val id: String,
    val sender: User,
    val content: String,
    val createAt: Long,
    val isRead: Boolean,
    val isDelivered: Boolean,
)
