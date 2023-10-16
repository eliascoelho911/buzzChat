package com.buzzchat.notetaking

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.buzzchat.core.designsystem.BuzzChatLogo
import com.buzzchat.core.designsystem.theme.BuzzChatTheme
import com.buzzchat.core.ui.DevicePreviews

@Composable
internal fun NoteTakingScreen() {
    NoteTakingScreenContent()
}

@Composable
private fun NoteTakingScreenContent() {
    BottomSheetScaffold(
        topBar = { NoteTakingTopBar() },
        sheetContent = { InputNoteBottomSheet() },
    ) { innerPadding ->
        NoteTakingContent(innerPadding)
    }
}

@Composable
private fun NoteTakingTopBar() {
    TopAppBar(title = { BuzzChatLogo() })
}

@Composable
private fun NoteTakingContent(innerPadding: PaddingValues) {
    // Todo: Adicionar lista de notas
}

@Composable
private fun InputNoteBottomSheet() {

}

@DevicePreviews
@Composable
private fun NoteTakingScreenPreview() {
    BuzzChatTheme {
        NoteTakingScreen()
    }
}