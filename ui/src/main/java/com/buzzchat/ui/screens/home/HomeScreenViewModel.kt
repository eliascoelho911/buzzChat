package com.buzzchat.ui.screens.home

import androidx.lifecycle.viewModelScope
import com.buzzchat.ui.features.chat.usecases.GetAllChatsUseCase
import com.buzzchat.ui.screens.home.components.chatitem.toState
import com.eliascoelho911.common.android.arch.StateViewModel
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val getAllChats: GetAllChatsUseCase,
) : StateViewModel<HomeState>(HomeState()) {

    init {
        onInit()
    }

    private fun onInit() {
        viewModelScope.launch {
            getAllChats().onSuccess { chats ->
                setState { it.copy(chats = chats.toState()) }
            }
        }
    }
}