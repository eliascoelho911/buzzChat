package com.buzzchat.ui.previews.chat

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.buzzchat.ui.R
import com.buzzchat.ui.previews.annotations.HorizontalPreview
import com.buzzchat.ui.screens.chat.message.MessageContent
import com.buzzchat.ui.screens.chat.message.MessageSender
import com.buzzchat.ui.screens.chat.message.Messages
import com.buzzchat.ui.screens.chat.message.MessagesState
import com.buzzchat.ui.theme.BuzzChatTheme
import com.eliascoelho911.common.date.getMillis
import org.joda.time.LocalDateTime

@HorizontalPreview
@Composable
private fun MessageFromMePreview() {
    BuzzChatTheme {
        MessagePreview(
            state = defaultMessageState(
                sender = MessageSender(
                    name = stringResource(id = R.string.me_indication),
                    avatarUrl = "",
                    isMe = true
                ),
                text = "Hello, how are you? Have you seen the new episode of the series?",
            )
        )
    }
}

@HorizontalPreview
@Composable
private fun MessageFromOtherPreview() {
    BuzzChatTheme {
        MessagePreview(
            state = defaultMessageState(
                sender = MessageSender(
                    name = "Oliver",
                    avatarUrl = "",
                    isMe = false
                ),
                text = "I'm a fine, thanks. And you? I didn't see yet, but I'm going to see it today."
            )
        )
    }
}

@Composable
private fun MessagePreview(state: MessagesState) {
    BuzzChatTheme {
        Messages(
            state = state, modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
private fun defaultMessageState(
    sender: MessageSender = MessageSender(
        avatarUrl = "",
        name = stringResource(id = R.string.me_indication),
        isMe = true
    ),
    text: String = "Hello",
    createAt: Long = LocalDateTime.now().getMillis(),
) = MessagesState(
    content = MessageContent.Text(text = text, sender = sender, createAt = createAt),
)