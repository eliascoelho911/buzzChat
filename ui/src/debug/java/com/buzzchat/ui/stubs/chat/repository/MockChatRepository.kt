package com.buzzchat.ui.stubs.chat.repository

import com.buzzchat.ui.features.chat.model.Chat
import com.buzzchat.ui.features.chat.repository.ChatRepository
import com.buzzchat.ui.stubs.chat.ChatGenerator

class MockChatRepository : ChatRepository {
    override fun getAllChats(): List<Chat> = listOf(
        ChatGenerator.privateChat(messages = 10)
    )
}