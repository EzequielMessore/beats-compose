plugins {
    id("beats.android.library.compose")
}

dependencies {
    implementation(project(":core:view-extensions"))
    implementation(project(":core:view-model"))
    implementation(project(":core:navigation"))
    implementation(project(":domain"))
    implementation(project(":ui:compose"))

    implementation(libs.koin.compose)
    implementation(libs.koin.android)
    implementation(libs.androidx.navigation.compose)
}
