package com.buzzchat.ui.screens.chat

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Stable
class ChatScreenState(
    private val viewModel: ChatViewModel,
) {
    val state: ChatState @Composable get() = viewModel.state.collectAsStateWithLifecycle().value

    fun onBackClick() {
        // Todo: Implement onBackClick
    }
}

@Immutable
data class ChatState(
    val messages: List<String> = emptyList(),
)