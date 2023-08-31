package com.buzzchat.ui.components.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.buzzchat.ui.R
import com.buzzchat.ui.previews.LightDarkPreview
import com.buzzchat.ui.theme.BuzzChatTheme

@Composable
fun ProfilePlaceholder(
    modifier: Modifier = Modifier,
    iconSize: Dp = 24.dp,
    backgroundColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    contentColor: Color = contentColorFor(backgroundColor),
) {
    Surface(
        modifier = modifier,
        shape = CircleShape,
        color = backgroundColor,
        contentColor = contentColor,
    ) {
        Box(contentAlignment = Alignment.Center) {
            Image(
                modifier = Modifier.size(iconSize),
                painter = painterResource(id = R.drawable.ic_person),
                contentDescription = null,
                colorFilter = ColorFilter.tint(contentColor)
            )
        }
    }
}

@LightDarkPreview
@Composable
fun ProfilePlaceholderPreview() {
    BuzzChatTheme {
        ProfilePlaceholder()
    }
}