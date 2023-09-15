package com.buzzchat.ui.screens.chat

import androidx.lifecycle.viewModelScope
import com.buzzchat.ui.features.chat.usecases.GetChatByIdUseCase
import com.eliascoelho911.common.android.arch.StateViewModel
import kotlinx.coroutines.launch

class ChatViewModel(
    private val chatId: String,
    private val getChatById: GetChatByIdUseCase,
) : StateViewModel<ChatState>(ChatState()) {

    init {
        onInit()
    }

    private fun onInit() {
        // Todo: Implement loading state and error state
        viewModelScope.launch {
            getChatById(chatId)
                .onSuccess {
                    setState { chat ->
                        chat.copy(messages = chat.messages)
                    }
                }.onFailure {
                    throw it
                }
        }
    }
}