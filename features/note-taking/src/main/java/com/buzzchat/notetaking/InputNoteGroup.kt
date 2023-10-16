package com.buzzchat.notetaking

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Inbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.buzzchat.chat.R
import com.buzzchat.core.designsystem.BasicTextFieldWithPlaceholder
import com.buzzchat.core.designsystem.theme.BuzzChatTheme
import com.buzzchat.core.designsystem.theme.buzzChatColorScheme

@Composable
internal fun InputNoteGroup(
    selectedGroup: Group,
    onSelectedGroupChange: (Group) -> Unit,
    onCreateNewGroup: (String) -> Unit,
    groupOptions: List<Group>,
    onSearchGroups: (query: String) -> Unit,
    showGroupOptions: Boolean,
    onShowGroupOptionsChange: (Boolean) -> Unit,
    isEditing: Boolean,
    onIsEditingChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.surfaceVariant,
        shape = MaterialTheme.shapes.extraSmall
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(end = 8.dp),
                text = stringResource(id = R.string.group_field_label),
                style = MaterialTheme.typography.titleSmall
            )
            if (isEditing) {
                EditableGroupDropdown(
                    modifier = Modifier.weight(1f),
                    options = groupOptions,
                    onSearchQueryChange = onSearchGroups,
                    onSelectOption = {
                        onSelectedGroupChange(it)
                        onIsEditingChange(false)
                    },
                    expanded = showGroupOptions,
                    onExpandedChange = onShowGroupOptionsChange,
                    onCreateNewGroup = onCreateNewGroup,
                )
            } else {
                InputChip(
                    selected = false,
                    onClick = {
                        onIsEditingChange(true)
                    },
                    label = {
                        Text(text = selectedGroup.name, style = MaterialTheme.typography.titleSmall)
                    },
                    leadingIcon = {
                        GroupIcon(selectedGroup)
                    },
                    trailingIcon = {
                        Icon(
                            modifier = Modifier.size(16.dp),
                            imageVector = Icons.Rounded.Close,
                            contentDescription = null
                        )
                    },
                )
            }
        }
    }
}

@Immutable
internal data class Group(
    val name: String,
    val color: Color,
    val icon: ImageVector? = null,
)

@Composable
private fun EditableGroupDropdown(
    options: List<Group>,
    onSearchQueryChange: (String) -> Unit,
    onSelectOption: (Group) -> Unit,
    onCreateNewGroup: (groupName: String) -> Unit,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    var selectedOptionText by rememberSaveable { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }
    var alreadyFocused by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded,
        onExpandedChange = onExpandedChange
    ) {
        fun selectOrCreateGroup() {
            options.find {
                it.name.equals(selectedOptionText, ignoreCase = true)
            }?.let {
                onSelectOption(it)
            } ?: onCreateNewGroup(selectedOptionText)
        }

        BasicTextFieldWithPlaceholder(
            modifier = Modifier
                .menuAnchor()
                .focusRequester(focusRequester)
                .onFocusChanged {
                    if (it.isFocused && !alreadyFocused) {
                        alreadyFocused = true
                        onExpandedChange(true)
                        onSearchQueryChange(selectedOptionText)
                    } else if (!it.isFocused && alreadyFocused) {
                        selectOrCreateGroup()
                    }
                },
            value = selectedOptionText,
            onValueChange = {
                selectedOptionText = it
                onExpandedChange(it.isNotBlank())
                onSearchQueryChange(it)
            },
            textStyle = MaterialTheme.typography.titleSmall,
            placeholder = { Text(stringResource(id = R.string.group_field_placeholder)) },
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    selectOrCreateGroup()
                }
            )
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { onExpandedChange(false) },
            modifier = Modifier.fillMaxWidth()
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                            GroupIcon(selectionOption)
                            Text(selectionOption.name)
                        }
                    },
                    onClick = {
                        onSelectOption(selectionOption)
                    },
                )
            }

            val shouldShowCreateNewGroupField = selectedOptionText.length > 1 && options.none {
                it.name.equals(selectedOptionText, ignoreCase = true)
            }
            if (shouldShowCreateNewGroupField) {
                DropdownMenuItem(
                    text = {
                        Text(
                            stringResource(
                                id = R.string.group_field_create_new,
                                selectedOptionText
                            )
                        )
                    },
                    onClick = {
                        onCreateNewGroup(selectedOptionText)
                    },
                )
            }
        }
    }
}

@Composable
private fun GroupIcon(group: Group) {
    if (group.icon != null) {
        Icon(
            modifier = Modifier.size(16.dp),
            imageVector = group.icon,
            contentDescription = null,
            tint = group.color
        )
    } else {
        Box(
            modifier = Modifier
                .size(8.dp)
                .background(group.color, CircleShape)
        )
    }
}

@Preview
@Composable
private fun InboxPreview() {
    InputNoteGroupPreview()
}

@Preview
@Composable
private fun EditingGroupPreview() {
    InputNoteGroupPreview(initialShowGroupOptions = true, initialIsEditing = true)
}

@Composable
private fun InputNoteGroupPreview(
    initialGroup: Group = Group(
        name = "Entrada",
        color = buzzChatColorScheme().electricBlue,
        icon = Icons.Rounded.Inbox
    ),
    initialShowGroupOptions: Boolean = false,
    initialIsEditing: Boolean = false,
) {
    val buzzChatColorScheme = buzzChatColorScheme()
    var selectedGroup by remember {
        mutableStateOf(initialGroup)
    }
    val allGroups = remember {
        mutableStateListOf(
            Group(
                name = "Entrada",
                color = buzzChatColorScheme.electricBlue,
                icon = Icons.Rounded.Inbox
            ),
            Group(
                name = "Grupo com nome muito grande",
                color = buzzChatColorScheme.deepRuby,
            ),
            Group(
                name = "Estudos",
                color = buzzChatColorScheme.brilliantTurquoise,
            ),
            Group(
                name = "Pessoal",
                color = buzzChatColorScheme.darkMagenta,
            ),
            Group(
                name = "Família",
                color = buzzChatColorScheme.emeraldGreen,
            )
        )
    }
    var groupOptions by remember {
        mutableStateOf(allGroups.toList())
    }
    var showGroupOptions by remember { mutableStateOf(initialShowGroupOptions) }
    var isEditing by rememberSaveable { mutableStateOf(initialIsEditing) }

    BuzzChatTheme {
        Surface {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
                Column {
                    InputNoteGroup(
                        selectedGroup = selectedGroup,
                        onSelectedGroupChange = { selectedGroup = it },
                        groupOptions = groupOptions,
                        onSearchGroups = { query ->
                            groupOptions =
                                allGroups.filter { it.name.contains(query, ignoreCase = true) }
                        },
                        showGroupOptions = showGroupOptions,
                        onShowGroupOptionsChange = { showGroupOptions = it },
                        isEditing = isEditing,
                        onIsEditingChange = { isEditing = it },
                        modifier = Modifier.padding(16.dp),
                        onCreateNewGroup = {
                            val newGroup = Group(
                                name = it,
                                color = buzzChatColorScheme.slateBlue
                            )
                            allGroups.add(newGroup)
                            selectedGroup = newGroup
                            isEditing = false
                        }
                    )

                    TextField(value = "", onValueChange = {})
                }
            }
        }
    }
}