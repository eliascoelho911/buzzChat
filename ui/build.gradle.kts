plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "com.lifetracker.ui"

    compileSdk =34

    defaultConfig {
        minSdk = 24
        targetSdk = 34
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}

dependencies {
    implementation(libs.compose.ui)
    implementation(libs.compose.uiGraphics)
    implementation(libs.compose.uiToolingPreview)
    implementation(libs.compose.uiToolingPreview)
    implementation(libs.compose.material3)
    implementation(libs.compose.activity)
    debugImplementation(libs.compose.uiTooling)
    debugImplementation(libs.compose.uiTestManifest)

    implementation(libs.androidx.coreKtx)
    implementation(libs.androidx.appcompat)

    implementation(libs.jodaTime)
    implementation(libs.kotlin.collectionsImmutable)

    implementation(project(":data-domain"))

    testImplementation(libs.junit)
}