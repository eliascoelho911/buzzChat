package com.buzzchat.ui.features.chat.repository

import com.buzzchat.ui.features.chat.model.Chat

interface ChatRepository {
    suspend fun getAllChats(): Result<List<Chat>>

    suspend fun getChatById(id: String): Result<Chat>
}