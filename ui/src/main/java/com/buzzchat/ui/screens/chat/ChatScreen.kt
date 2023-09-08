@file:OptIn(ExperimentalMaterial3Api::class)

package com.buzzchat.ui.screens.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.buzzchat.ui.R
import com.buzzchat.ui.previews.annotations.LightDarkPreview
import com.buzzchat.ui.theme.BuzzChatTheme

@Composable
fun ChatScreen(
    personName: String,
    personImage: Painter,
    screenState: ChatScreenState,
) {
    val scrollBehaviour = pinnedScrollBehavior()

    Scaffold(
        topBar = {
            ChatTopBar(
                personName = personName,
                personImage = personImage,
                scrollBehavior = scrollBehaviour,
                onBackClick = screenState::onBackClick,
            )
        },
        modifier = Modifier.nestedScroll(scrollBehaviour.nestedScrollConnection)
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            LazyColumn(modifier = Modifier.nestedScroll(scrollBehaviour.nestedScrollConnection)) {
//                items(screenState.state.messages) { message ->
//                    Text(
//                        text = message,
//                        style = MaterialTheme.typography.bodyMedium,
//                        maxLines = 1,
//                        overflow = TextOverflow.Ellipsis,
//                    )
//                }
            }
        }
    }
}

@Composable
private fun ChatTopBar(
    personName: String,
    personImage: Painter,
    scrollBehavior: TopAppBarScrollBehavior,
    onBackClick: () -> Unit = {},
) {
    TopAppBar(
        title = {
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = personName,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        },
        navigationIcon = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable(onClick = onBackClick)
            ) {
                Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = null)
                Image(
                    painter = personImage,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(4.dp)
                        .size(36.dp)
                        .clip(CircleShape)
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}

@LightDarkPreview
@Composable
private fun ChatScreenPreview() {
    BuzzChatTheme {
        ChatScreen(
            personName = "Elias Coelho",
            personImage = painterResource(id = R.drawable.person_image),
            screenState = ChatScreenState(ChatViewModel()),
        )
    }
}