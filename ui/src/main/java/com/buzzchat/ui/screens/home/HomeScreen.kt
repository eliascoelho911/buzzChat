package com.buzzchat.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.buzzchat.ui.R
import com.buzzchat.ui.previews.LightDarkPreview
import com.buzzchat.ui.screens.home.chat.ChatItem
import com.buzzchat.ui.screens.home.chat.model.Chat
import com.buzzchat.ui.theme.BuzzChatTheme
import org.joda.time.LocalDateTime

@Composable
fun HomeScreen(
    toolbarTitle: String = stringResource(id = R.string.home_screen_title),
    state: HomeScreenState,
) {
    val scrollBehaviour = pinnedScrollBehavior()

    Scaffold(
        topBar = { HomeTopBar(toolbarTitle, scrollBehaviour) },
        modifier = Modifier.nestedScroll(scrollBehaviour.nestedScrollConnection)
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .padding(top = 8.dp)
                .fillMaxSize()
        ) {
            with(state.state) {
                LazyColumn(
                    modifier = Modifier
                        .nestedScroll(scrollBehaviour.nestedScrollConnection)
                        .fillMaxWidth(),
                ) {
                    items(chats) { chat ->
                        ChatItem(
                            chat = chat,
                            modifier = Modifier.fillParentMaxWidth(),
                            onClick = state::onChatClicked
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun HomeTopBar(title: String, scrollBehavior: TopAppBarScrollBehavior) {
    TopAppBar(
        title = { Text(text = title) },
        scrollBehavior = scrollBehavior
    )
}

@LightDarkPreview
@Composable
private fun HomeScreenPreview() {
    BuzzChatTheme {
        HomeScreen(
            state = HomeScreenState(
                viewModel = HomeScreenViewModel(
                    getAllChats = {
                        List(8) {
                            Chat(
                                personPictureUrl = "",
                                personName = "Elias Coelho",
                                lastMessage = "Olá, tudo bem? Como está a sua família? Estou com saudades de vocês.",
                                lastMessageTime = LocalDateTime.now().minusDays(it),
                                unreadMessages = 0,
                                isTyping = false
                            )
                        }.sortedByDescending { it.lastMessageTime }
                    }
                )
            )
        )
    }
}