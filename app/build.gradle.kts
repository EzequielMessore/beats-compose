plugins {
    id("beats.android.application")
    id("beats.android.application.compose")
}

android {
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(":data:data"))
    implementation(project(":data:remote"))
    implementation(project(":domain"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    implementation(libs.compose.ui.asProvider())
    implementation(libs.compose.material)
    implementation(libs.compose.activity)
    implementation(libs.compose.ui.tooling.preview)

    implementation(libs.koin.android)

    testImplementation(libs.testing.junit)

    androidTestImplementation(libs.testing.junit.ext)
    androidTestImplementation(libs.testing.espresso)
    androidTestImplementation(libs.compose.ui.test)
    debugImplementation(libs.compose.ui.tooling)
}