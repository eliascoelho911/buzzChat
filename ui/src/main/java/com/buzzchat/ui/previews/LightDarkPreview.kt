package com.buzzchat.ui.previews

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview

@Preview(uiMode = UI_MODE_NIGHT_YES, name = "dark")
@Preview(uiMode = UI_MODE_NIGHT_NO, name = "light")
@Target(AnnotationTarget.FUNCTION)
annotation class LightDarkPreview
