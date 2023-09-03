package com.buzzchat.ui.features.chat.repository

import com.buzzchat.ui.features.chat.model.Chat

interface ChatRepository {
    fun getAllChats(): List<Chat>
}