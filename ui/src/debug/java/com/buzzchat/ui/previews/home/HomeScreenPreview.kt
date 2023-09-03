package com.buzzchat.ui.previews.home

import androidx.compose.runtime.Composable
import com.buzzchat.ui.features.chat.usecases.GetAllChatsUseCase
import com.buzzchat.ui.previews.annotations.LightDarkPreview
import com.buzzchat.ui.screens.home.HomeScreen
import com.buzzchat.ui.screens.home.HomeScreenState
import com.buzzchat.ui.screens.home.HomeScreenViewModel
import com.buzzchat.ui.stubs.chat.repository.MockChatRepository
import com.buzzchat.ui.theme.BuzzChatTheme

@LightDarkPreview
@Composable
private fun HomeScreenPreview() {
    BuzzChatTheme {
        HomeScreen(
            state = HomeScreenState(
                viewModel = HomeScreenViewModel(
                    getAllChats = GetAllChatsUseCase(MockChatRepository())
                )
            )
        )
    }
}