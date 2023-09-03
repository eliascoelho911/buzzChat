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
import com.buzzchat.ui.screens.home.components.chatitem.ChatItem

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
                            state = chat,
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
