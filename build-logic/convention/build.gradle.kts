plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(libs.android.gradle)
    implementation(libs.kotlin.gradle)
}

gradlePlugin {
    plugins {
        register("applicationCompose") {
            id = "beats.android.application.compose"
            implementationClass = "AndroidApplicationComposePlugin"
        }
        register("androidApplication") {
            id = "beats.android.application"
            implementationClass = "AndroidApplicationPlugin"
        }
        register("androidLibraryCompose") {
            id = "beats.android.library.compose"
            implementationClass = "AndroidComposePlugin"
        }
        register("androidLibrary") {
            id = "beats.android.library"
            implementationClass = "AndroidLibraryPlugin"
        }
        register("androidTest") {
            id = "beats.android.test"
            implementationClass = "AndroidTestPlugin"
        }
        register("javaLibrary") {
            id = "beats.java.library"
            implementationClass = "JavaLibraryPlugin"
        }
    }
}
