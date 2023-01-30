plugins {
    id("beats.android.library")
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.compose.material3)
}

android {
    namespace = "br.com.messore.tech.beats.view.extensions"
}
