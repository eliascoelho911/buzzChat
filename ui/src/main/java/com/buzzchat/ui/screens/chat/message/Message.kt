package com.buzzchat.ui.screens.chat.message

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.buzzchat.ui.R
import com.buzzchat.ui.common.compose.getUserLocale
import com.buzzchat.ui.components.image.ProfileImage
import com.buzzchat.ui.screens.chat.message.MessageUIManager.avatarSize
import com.buzzchat.ui.screens.chat.message.MessageUIManager.backgroundColor
import com.buzzchat.ui.screens.chat.message.MessageUIManager.deliveryStatusColors
import com.buzzchat.ui.screens.chat.message.MessageUIManager.deliveryStatusIcons
import com.buzzchat.ui.screens.chat.message.MessageUIManager.deliveryStatusSize
import com.buzzchat.ui.screens.chat.message.MessageUIManager.internalContentPadding
import com.buzzchat.ui.screens.chat.message.MessageUIManager.messageAvatarSpacing
import com.buzzchat.ui.screens.chat.message.MessageUIManager.messageShape
import com.buzzchat.ui.screens.chat.message.MessageUIManager.messageTextStyle
import com.buzzchat.ui.screens.chat.message.MessageUIManager.minHeightOfMessageContent
import com.buzzchat.ui.screens.chat.message.MessageUIManager.spacingBetweenContentAndInfo
import com.buzzchat.ui.screens.chat.message.MessageUIManager.spacingBetweenInfoItems
import com.buzzchat.ui.screens.chat.message.MessageUIManager.timeTextStyle
import com.buzzchat.ui.theme.GreenA700
import com.eliascoelho911.common.date.formatToHours
import com.eliascoelho911.common.date.localDateTime
import java.util.Locale

@Composable
fun Message(state: MessageState, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .sizeIn(minHeight = minHeightOfMessageContent)
            .then(modifier),
        horizontalArrangement = Arrangement.spacedBy(messageAvatarSpacing),
    ) {
        if (state.sender is MessageSender.Other) {
            Avatar(avatarUrl = state.sender.avatarUrl, modifier = Modifier.size(avatarSize))
        }

        MessageContent(state = state, modifier = Modifier.weight(1f, fill = false))

        if (state.sender is MessageSender.Me) {
            Avatar(avatarUrl = state.sender.avatarUrl, modifier = Modifier.size(avatarSize))
        }
    }
}

@Composable
private fun MessageContent(
    state: MessageState,
    modifier: Modifier = Modifier,
    locale: Locale = getUserLocale(),
) {
    with(state) {
        Surface(
            shape = messageShape(state.sender),
            color = backgroundColor,
            modifier = modifier
        ) {
            val horizontalAlignment = if (state.sender is MessageSender.Me) {
                Alignment.End
            } else {
                Alignment.Start
            }

            Column(
                modifier = Modifier
                    .sizeIn(minHeight = minHeightOfMessageContent)
                    .padding(internalContentPadding),
                verticalArrangement = Arrangement.spacedBy(spacingBetweenContentAndInfo),
                horizontalAlignment = horizontalAlignment
            ) {
                when (content) {
                    is MessageContent.Text -> Text(
                        text = content.text,
                        style = messageTextStyle
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(spacingBetweenInfoItems)
                ) {
                    val time = localDateTime(createAt).formatToHours(locale = locale)
                    Text(text = time, style = timeTextStyle)
                    DeliveryStatus(
                        iconRes = deliveryStatusIcons.from(deliveryStatus),
                        color = deliveryStatusColors.from(deliveryStatus)
                    )
                }
            }
        }
    }
}

@Composable
private fun DeliveryStatus(@DrawableRes iconRes: Int, color: Color) {
    Image(
        modifier = Modifier.size(deliveryStatusSize),
        painter = painterResource(id = iconRes),
        contentDescription = null,
        colorFilter = ColorFilter.tint(color)
    )
}

@Composable
private fun Avatar(avatarUrl: String, modifier: Modifier = Modifier) {
    ProfileImage(url = avatarUrl, modifier = modifier)
}

private object MessageUIManager {
    val backgroundColor @Composable get() = MaterialTheme.colorScheme.surfaceVariant

    val deliveryStatusColors: Map<DeliveryStatus, Color>
        @Composable get() {
            val lowAlphaColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f)
            return mapOf(
                DeliveryStatus.SENT to lowAlphaColor,
                DeliveryStatus.DELIVERED to lowAlphaColor,
                DeliveryStatus.READ to GreenA700
            )
        }

    val deliveryStatusIcons: Map<DeliveryStatus, Int>
        get() = mapOf(
            DeliveryStatus.SENT to R.drawable.ic_done,
            DeliveryStatus.DELIVERED to R.drawable.ic_done_all,
            DeliveryStatus.READ to R.drawable.ic_done_all
        )

    val internalContentPadding = 8.dp

    val messageAvatarSpacing = 8.dp

    val minHeightOfMessageContent = 48.dp

    val spacingBetweenContentAndInfo = 8.dp

    val spacingBetweenInfoItems = 4.dp

    val avatarSize = 28.dp

    val deliveryStatusSize = 16.dp

    val messageTextStyle @Composable get() = MaterialTheme.typography.bodySmall

    val timeTextStyle @Composable get() = MaterialTheme.typography.labelSmall

    @Composable
    fun messageShape(sender: MessageSender): Shape {
        return if (sender is MessageSender.Me) {
            MaterialTheme.shapes.medium.copy(topEnd = CornerSize(0.dp))
        } else {
            MaterialTheme.shapes.medium.copy(topStart = CornerSize(0.dp))
        }
    }
}

private fun <T> Map<DeliveryStatus, T>.from(deliveryStatus: DeliveryStatus): T {
    return this[deliveryStatus] ?: error("DeliveryStatus $deliveryStatus not found")
}