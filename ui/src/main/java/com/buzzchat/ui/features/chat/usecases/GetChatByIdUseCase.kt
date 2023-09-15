package com.buzzchat.ui.features.chat.usecases

import com.buzzchat.ui.features.chat.model.Chat
import com.buzzchat.ui.features.chat.repository.ChatRepository

class GetChatByIdUseCase(
    private val chatRepository: ChatRepository,
) {
    suspend operator fun invoke(id: String): Result<Chat> =
        chatRepository.getChatById(id)
}