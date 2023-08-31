package com.buzzchat.ui.screens.home.chat.model

import org.joda.time.LocalDateTime

data class Chat(
    val personPictureUrl: String,
    val personName: String,
    val lastMessage: String,
    val isTyping: Boolean,
    val lastMessageTime: LocalDateTime,
    val unreadMessages: Int
)