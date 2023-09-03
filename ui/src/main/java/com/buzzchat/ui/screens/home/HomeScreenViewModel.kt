package com.buzzchat.ui.screens.home

import com.buzzchat.ui.features.chat.usecases.GetAllChatsUseCase
import com.buzzchat.ui.screens.home.components.chatitem.toState
import com.eliascoelho911.common.android.arch.StateViewModel

class HomeScreenViewModel(
    private val getAllChats: GetAllChatsUseCase,
) : StateViewModel<HomeState>(HomeState()) {

    init {
        onInit()
    }

    private fun onInit() {
        setState { it.copy(chats = getAllChats().toState()) }
    }
}