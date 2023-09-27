plugins {
    id("buzzchat.android.feature")
    id("buzzchat.android.library.compose")
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    namespace = "com.buzzchat.chat"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)

    androidTestImplementation(project(":core:testing"))
}
