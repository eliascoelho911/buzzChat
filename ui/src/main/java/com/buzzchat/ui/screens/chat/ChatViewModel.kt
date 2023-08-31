package com.buzzchat.ui.screens.chat

import com.eliascoelho911.common.android.arch.StateViewModel

class ChatViewModel() : StateViewModel<ChatState>(ChatState()) {

    init {
        onInit()
    }

    private fun onInit() {
    }
}