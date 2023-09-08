package com.buzzchat.ui.components.image

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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.buzzchat.ui.R

@Composable
fun ProfileImage(url: String, modifier: Modifier = Modifier) {
    val profileModifier = modifier.then(Modifier.size(48.dp))
    SubcomposeAsyncImage(
        modifier = profileModifier,
        model = ImageRequest.Builder(LocalContext.current).data(url).crossfade(true).build(),
        contentDescription = null,
        loading = {
            ProfilePlaceholder(profileModifier)
        },
        error = {
            ProfilePlaceholder(profileModifier)
        }
    )
}

@Composable
private fun ProfilePlaceholder(
    modifier: Modifier = Modifier,
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
                modifier = Modifier
                    .matchParentSize()
                    .graphicsLayer(scaleX = 0.7f, scaleY = 0.7f),
                painter = painterResource(id = R.drawable.ic_person),
                contentDescription = null,
                colorFilter = ColorFilter.tint(contentColor)
            )
        }
    }
}

@Preview
@Composable
private fun ProfileImagePreview() {
    ProfileImage(url = "")
}