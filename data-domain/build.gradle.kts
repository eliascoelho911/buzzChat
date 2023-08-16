plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "com.lifetracker.datadomain"

    compileSdk = 34

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
}

dependencies {
    implementation(libs.kotlin.serialization)

    testImplementation(libs.junit)
}