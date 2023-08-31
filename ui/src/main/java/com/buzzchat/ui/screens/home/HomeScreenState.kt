package com.buzzchat.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.buzzchat.ui.screens.home.chat.model.Chat

@Stable
class HomeScreenState(
    private val viewModel: HomeScreenViewModel,
) {
    val state: HomeState @Composable get() = viewModel.state.collectAsStateWithLifecycle().value

    fun onChatClicked(chat: Chat) {
        // TODO: Implement
    }
}

@Immutable
data class HomeState(
    val chats: List<Chat> = emptyList(),
)