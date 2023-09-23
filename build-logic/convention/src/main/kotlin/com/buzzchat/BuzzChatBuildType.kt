package com.buzzchat

enum class BuzzChatBuildType(val applicationIdSuffix: String? = null) {
    DEBUG(".debug"),
    RELEASE;
}
