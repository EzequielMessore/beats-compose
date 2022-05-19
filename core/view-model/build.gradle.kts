plugins {
    id("beats.android.library")
}

dependencies {
    implementation(libs.coroutines.core)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewModelCompose)
}