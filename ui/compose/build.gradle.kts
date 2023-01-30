plugins {
    id("beats.android.library.compose")
}

dependencies {
    api(libs.bundles.compose)
}

android {
    namespace = "br.com.messore.tech.beats.compose"
}
