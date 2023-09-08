package com.buzzchat.ui.common.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import java.util.Locale

@Composable
fun getUserLocale(): Locale = LocalConfiguration.current.locales[0] ?: Locale.getDefault()