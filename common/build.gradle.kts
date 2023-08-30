plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "com.eliascoelho911.common"

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
    implementation(libs.androidx.coreKtx)
    implementation(libs.androidx.appcompat)

    testImplementation(libs.junit)
}