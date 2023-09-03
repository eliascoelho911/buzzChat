package com.buzzchat.ui.previews.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.buzzchat.ui.previews.annotations.LightDarkPreview
import com.buzzchat.ui.screens.home.components.chatitem.ChatItem
import com.buzzchat.ui.screens.home.components.chatitem.toState
import com.buzzchat.ui.stubs.chat.ChatGenerator
import com.buzzchat.ui.theme.BuzzChatTheme
import java.util.Locale

@LightDarkPreview
@Composable
private fun ChatItemPreview() {
    val chat = ChatGenerator.privateChat()
    val state = chat.toState()!!
    val configuration = Configuration().apply {
        setLocale(Locale("pt", "BR"))
    }

    CompositionLocalProvider(LocalConfiguration provides configuration) {
        BuzzChatTheme {
            ChatItem(
                modifier = Modifier.width(300.dp),
                state = state
            )
        }
    }
}