plugins {
    id(Plugins.Java.library)
    id(Plugins.Jetbrains.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    api(project(":domain"))

    implementation(Dependencies.Koin.core)
    implementation(Dependencies.Coroutines.core)
}
