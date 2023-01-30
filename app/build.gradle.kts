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
    namespace = "br.com.messore.tech.beats"
}

dependencies {
    implementation(project(":core:navigation"))
    implementation(project(":data:data"))
    implementation(project(":data:remote"))
    implementation(project(":domain"))
    implementation(project(":feature:headset"))
    implementation(project(":feature:login"))
    implementation(project(":feature:register"))
    implementation(project(":ui:compose"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.navigation.compose)

    implementation(libs.koin.android)

    testImplementation(libs.testing.junit)

    androidTestImplementation(libs.testing.junit.ext)
    androidTestImplementation(libs.testing.espresso)
    androidTestImplementation(libs.compose.ui.test)
    debugImplementation(libs.compose.ui.tooling)
}