plugins {
    id(Plugins.Java.library)
    id(Plugins.Jetbrains.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(project(":data:data"))
    implementation(Dependencies.Koin.core)
    implementation(Dependencies.Coroutines.core)

    implementation(Dependencies.SquareUp.gson)
    implementation(Dependencies.SquareUp.retrofit)
    implementation(Dependencies.SquareUp.loggingInterceptor)
}
