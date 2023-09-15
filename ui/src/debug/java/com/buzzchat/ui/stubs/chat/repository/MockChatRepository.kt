package com.buzzchat.ui.stubs.chat.repository

import com.buzzchat.ui.features.chat.model.Chat
import com.buzzchat.ui.features.chat.repository.ChatRepository
import com.buzzchat.ui.stubs.chat.ChatGenerator

class MockChatRepository : ChatRepository {
    override suspend fun getAllChats(): Result<List<Chat>> = Result.success(
        listOf(
            ChatGenerator.privateChat(messages = 10)
        )
    )

    override suspend fun getChatById(id: String): Result<Chat> = runCatching {
        getAllChats().getOrThrow().first { it.id == id }
    }
}