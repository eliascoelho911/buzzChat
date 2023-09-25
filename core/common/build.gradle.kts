plugins {
    id("buzzchat.android.library")
}

android {
    namespace = "com.buzzchat.core.common"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.jodaTime)
    testImplementation(project(":core:testing"))
}