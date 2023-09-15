package com.buzzchat.ui.features.chat.usecases

import com.buzzchat.ui.features.chat.model.Chat
import com.buzzchat.ui.features.chat.repository.ChatRepository

class GetAllChatsUseCase(
    private val repository: ChatRepository,
) {
    suspend operator fun invoke(): Result<List<Chat>> = repository.getAllChats().map { list ->
        list
            .filter { it.messages.isNotEmpty() }
            .sortedByDescending { it.messages.last().createAt }
    }
}