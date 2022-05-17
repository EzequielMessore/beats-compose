package br.com.messore.tech.beats

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

@Suppress("UnstableApiUsage")
fun Project.configureKotlinAndroid(
    commonExtension: BaseExtension,
) {
    commonExtension.apply {
        compileSdkVersion(32)

        defaultConfig {
            minSdk = 26
            targetSdk = 32

            versionCode = 1
            versionName = "1.0.0"
            testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }

        kotlinOptions {
            allWarningsAsErrors = properties["warningsAsErrors"] as? Boolean ?: false

            freeCompilerArgs = freeCompilerArgs + listOf(
                "-Xopt-in=kotlin.RequiresOptIn",
                "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                "-Xopt-in=kotlinx.coroutines.FlowPreview",
                "-Xopt-in=kotlin.Experimental",
                "-Xopt-in=kotlinx.serialization.ExperimentalSerializationApi"
            )

            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }
}

private fun BaseExtension.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
}
