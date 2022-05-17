plugins {
    id("beats.java.library")
}

dependencies {
    api(project(":domain"))

    implementation(libs.koin.core)
    implementation(libs.coroutines.core)
}
