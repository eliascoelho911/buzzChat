package com.buzzchat.core.designsystem

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.buzzchat.core.designsystem.theme.BuzzChatTheme
import com.buzzchat.core.ui.DevicePreviews

private val LogoTextStyle = TextStyle(
    fontFamily = FontFamily(Font(R.font.m_plus_bold)),
    fontSize = 24.sp
)

@Composable
fun BuzzChatLogo(modifier: Modifier = Modifier) {
    Text(text = "BuzzChat", modifier = modifier, style = LogoTextStyle)
}

@Composable
@DevicePreviews
@Preview
private fun BuzzChatLogoPreview() {
    BuzzChatTheme {
        Surface(Modifier.fillMaxWidth()) {
            BuzzChatLogo(modifier = Modifier.padding(16.dp))
        }
    }
}