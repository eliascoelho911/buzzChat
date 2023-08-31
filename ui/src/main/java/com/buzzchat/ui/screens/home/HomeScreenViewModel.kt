package com.buzzchat.ui.screens.home

import com.eliascoelho911.common.android.arch.StateViewModel

class HomeScreenViewModel(
    private val getAllChats: GetAllChats,
) : StateViewModel<HomeState>(HomeState()) {

    init {
        onInit()
    }

    private fun onInit() {
        setState { it.copy(chats = getAllChats()) }
    }
}