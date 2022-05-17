plugins {
    id("beats.java.library")
}

dependencies {
    implementation(project(":data:data"))
    implementation(libs.koin.core)
    implementation(libs.coroutines.core)

    implementation(libs.square.up.gson)
    implementation(libs.square.up.retrofit)
    implementation(libs.square.up.logging.interceptor)
}
