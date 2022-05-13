plugins {
    id(Plugins.Java.library)
    id(Plugins.Jetbrains.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(Dependencies.Koin.core)
}
