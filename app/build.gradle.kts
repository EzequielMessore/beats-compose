import Dependencies.AndroidX
import Dependencies.Compose
import Dependencies.Testing

plugins {
    id(Plugins.Android.application)
    kotlin("android")
}

android {
    compileSdk = AppConfig.Sdk.compile

    defaultConfig {
        applicationId = AppConfig.appId
        minSdk = AppConfig.Sdk.min
        targetSdk = AppConfig.Sdk.target
        versionCode = AppConfig.Version.code
        versionName = AppConfig.Version.name

        testInstrumentationRunner = AppConfig.instrumentationTestRunner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.compose
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(AndroidX.core)
    implementation(AndroidX.lifecycleRuntime)

    implementation(Compose.ui)
    implementation(Compose.material)
    implementation(Compose.activity)
    implementation(Compose.uiToolingPreview)


    testImplementation(Testing.junit)

    androidTestImplementation(Testing.junitExt)
    androidTestImplementation(Testing.espresso)
    androidTestImplementation(Compose.uiTest)
    debugImplementation(Compose.uiTooling)
}