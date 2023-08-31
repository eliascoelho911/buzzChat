package com.buzzchat.ui.screens.home.chat

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Badge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.buzzchat.ui.R
import com.buzzchat.ui.components.common.ProfilePlaceholder
import com.buzzchat.ui.previews.LightDarkPreview
import com.buzzchat.ui.screens.home.chat.model.Chat
import com.buzzchat.ui.theme.BuzzChatTheme
import com.eliascoelho911.common.date.simpleFormat
import org.joda.time.LocalDateTime
import java.util.Locale

@Composable
fun ChatItem(
    chat: Chat,
    modifier: Modifier = Modifier,
    onClick: (Chat) -> Unit = {},
) {
    with(chat) {
        Surface(onClick = { onClick(chat) }, modifier = modifier) {
            ConstraintLayout(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
                val (pictureRef, personNameRef, lastMessageRef, lastMessageTimeRef, unreadBadgeRef) = createRefs()

                Picture(url = personPictureUrl, modifier = Modifier.constrainAs(pictureRef) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                })

                Text(
                    text = personName,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.constrainAs(personNameRef) {
                        start.linkTo(pictureRef.end, margin = HorizontalSpacing)
                        top.linkTo(pictureRef.top)
                        end.linkTo(lastMessageTimeRef.start, margin = HorizontalSpacing)
                        width = Dimension.fillToConstraints
                    }
                )

                Message(
                    chat = this@with,
                    modifier = Modifier.Companion.constrainAs(lastMessageRef) {
                        start.linkTo(personNameRef.start)
                        top.linkTo(personNameRef.bottom, margin = VerticalSpacing)
                        end.linkTo(
                            if (showUnreadBadge) unreadBadgeRef.start else parent.end,
                            margin = HorizontalSpacing
                        )
                        width = Dimension.fillToConstraints
                    }
                )
                Text(
                    text = lastMessageTime.simpleFormat(LocalConfiguration.current.locales[0]),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.constrainAs(lastMessageTimeRef) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                    }
                )
                if (showUnreadBadge) {
                    Badge(modifier = Modifier.constrainAs(unreadBadgeRef) {
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }) {
                        Text(text = unreadMessages.toString())
                    }
                }
            }
        }
    }
}

@Composable
private fun Message(
    chat: Chat,
    modifier: Modifier = Modifier,
) {
    val text: String
    val fontStyle: FontStyle

    with(chat) {
        when {
            chat.isTyping -> {
                text = stringResource(R.string.is_typing, personName)
                fontStyle = FontStyle.Italic
            }

            else -> {
                text = lastMessage
                fontStyle = FontStyle.Normal
            }
        }
    }

    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodySmall,
        fontStyle = fontStyle,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

@Composable
private fun Picture(url: String, modifier: Modifier = Modifier) {
    @Composable
    fun Placeholder() {
        ProfilePlaceholder(modifier = Modifier.size(ImageSize), iconSize = 36.dp)
    }

    SubcomposeAsyncImage(
        modifier = modifier,
        model = ImageRequest.Builder(LocalContext.current).data(url).crossfade(true).build(),
        contentDescription = null,
        loading = {
            Placeholder()
        },
        error = {
            Placeholder()
        }
    )
}

private val ImageSize = 48.dp
private val VerticalSpacing = 8.dp
private val HorizontalSpacing = 16.dp

@LightDarkPreview
@Composable
private fun ChatItemPreview(@PreviewParameter(SampleChatProvider::class) chat: Chat) {
    val configuration = Configuration().apply {
        setLocale(Locale("pt", "BR"))
    }
    CompositionLocalProvider(LocalConfiguration provides configuration) {
        BuzzChatTheme {
            ChatItem(
                modifier = Modifier.width(300.dp),
                chat = chat
            )
        }
    }
}

private class SampleChatProvider : PreviewParameterProvider<Chat> {
    override val values: Sequence<Chat>
        get() = sequenceOf(
            Chat(
                personPictureUrl = "",
                personName = "Elias Coelho",
                lastMessage = "Olá, tudo bem? Como está a sua família? Estou com saudades de vocês.",
                isTyping = false,
                lastMessageTime = LocalDateTime.now().minusDays(2),
                unreadMessages = 2
            ),
            Chat(
                personPictureUrl = "",
                personName = "Letícia Lucena",
                lastMessage = "Você viu o que aconteceu? Estou muito preocupada!",
                isTyping = true,
                lastMessageTime = LocalDateTime.now(),
                unreadMessages = 0
            )
        )
}