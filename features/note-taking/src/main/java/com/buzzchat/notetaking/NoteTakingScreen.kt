package com.buzzchat.notetaking

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import com.buzzchat.core.designsystem.BuzzChatLogo
import com.buzzchat.core.designsystem.theme.BuzzChatTheme
import com.buzzchat.core.ui.DevicePreviews
import com.buzzchat.core.ui.PhonePreview

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
private fun InputNoteBottomSheet(viewModel: NoteTakingViewModel) {
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
        Column {
            InputNoteGroup(
                selectedGroup = viewModel.selectedGroup,
                onSelectedGroupChange = viewModel::onSelectedGroupChange,
                onCreateNewGroup = viewModel::onCreateNewGroup,
                groupOptions = viewModel.groupOptions,
                onSearchGroups = viewModel::onSearchGroups,
                showGroupOptions = viewModel.,
                onShowGroupOptionsChange = ,
                isEditing = ,
                onIsEditingChange = 
            )
        }
    }
}

internal class NoteTakingViewModel: ViewModel() {

}

@PhonePreview
@Composable
private fun NoteTakingScreenPreview() {
    BuzzChatTheme {
        NoteTakingScreen()
    }
}