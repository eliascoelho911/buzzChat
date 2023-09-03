package com.buzzchat.ui.features.chat.usecases

import com.buzzchat.ui.features.chat.model.Chat
import com.buzzchat.ui.features.chat.repository.ChatRepository

class GetAllChatsUseCase(
    private val repository: ChatRepository,
) {
    operator fun invoke(): List<Chat> = repository.getAllChats()
        .filter { it.messages.isNotEmpty() }
        .sortedByDescending { it.messages.last().createAt }
}