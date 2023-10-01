plugins {
    id("cubeSolver.android.library")
}

android {
    namespace = "com.eliascoelho911.common"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.jodaTime)
    testImplementation(project(":core:testing"))
}