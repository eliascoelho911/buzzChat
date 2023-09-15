package com.buzzchat.ui.screens.home.components.chatitem

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.buzzchat.ui.R
import com.buzzchat.ui.components.image.ProfileImage
import com.eliascoelho911.common.date.localDateTime
import com.eliascoelho911.common.date.simpleFormat

@Composable
fun ChatItem(
    state: ChatItemState,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    with(state) {
        Surface(onClick = onClick, modifier = modifier) {
            ConstraintLayout(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
                val (pictureRef, personNameRef, lastMessageRef, lastMessageTimeRef, unreadBadgeRef) = createRefs()

                Picture(url = avatarUrl, modifier = Modifier.constrainAs(pictureRef) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                })

                Text(
                    text = chatName,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.constrainAs(personNameRef) {
                        start.linkTo(
                            pictureRef.end,
                            margin = HorizontalSpacing
                        )
                        top.linkTo(pictureRef.top)
                        end.linkTo(
                            lastMessageTimeRef.start,
                            margin = HorizontalSpacing
                        )
                        width = Dimension.fillToConstraints
                    }
                )

                Message(
                    chat = this@with,
                    modifier = Modifier.Companion.constrainAs(lastMessageRef) {
                        start.linkTo(personNameRef.start)
                        top.linkTo(
                            personNameRef.bottom,
                            margin = VerticalSpacing
                        )
                        end.linkTo(
                            if (showUnreadBadge) unreadBadgeRef.start else parent.end,
                            margin = HorizontalSpacing
                        )
                        width = Dimension.fillToConstraints
                    }
                )
                Text(
                    text = localDateTime(lastMessageMillis).simpleFormat(LocalConfiguration.current.locales[0]),
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
    chat: ChatItemState,
    modifier: Modifier = Modifier,
) {
    val text: String
    val fontStyle: FontStyle

    with(chat) {
        when {
            chat.isTyping -> {
                text = stringResource(R.string.is_typing, chatName)
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
    ProfileImage(url = url, modifier = modifier)
}

private val VerticalSpacing = 8.dp
private val HorizontalSpacing = 16.dp
