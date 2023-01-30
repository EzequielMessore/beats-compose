plugins {
    id("beats.android.library.compose")
}

dependencies {
    implementation(project(":core:view-model"))
    implementation(project(":core:navigation"))
    implementation(project(":domain"))
    implementation(project(":ui:compose"))

    implementation(libs.coil.compose)
    implementation(libs.koin.compose)
    implementation(libs.koin.android)
    implementation(libs.androidx.navigation.compose)
}

android {
    namespace = "br.com.messore.tech.beats.headset"
}
