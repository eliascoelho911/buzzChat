plugins {
    id("cubeSolver.android.library")
    id("cubeSolver.android.library.compose")
}

android {
    namespace = "com.eliascoelho911.cubesolver.testing"
}

dependencies {
    api(libs.androidx.activity.compose)
    api(libs.androidx.compose.ui.test)
    api(libs.androidx.test.core)
    api(libs.androidx.test.espresso.core)
    api(libs.androidx.test.rules)
    api(libs.androidx.test.runner)
    api(libs.junit4)
    api(libs.kotlinx.coroutines.test)
    api(libs.robolectric.shadows)
    api(libs.turbine)

    debugApi(libs.androidx.compose.ui.testManifest)

    implementation(project(":core:common"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:domain"))
    implementation(libs.kotlinx.datetime)
}
