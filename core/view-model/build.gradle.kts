plugins {
    id("beats.android.library")
}

dependencies {
    implementation(libs.coroutines.core)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewModelCompose)
}

android {
    namespace = "br.com.messore.tech.beats.view.model"
}
