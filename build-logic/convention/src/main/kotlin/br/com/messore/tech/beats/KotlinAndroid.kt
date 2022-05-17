package br.com.messore.tech.beats

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

@Suppress("UnstableApiUsage")
fun Project.configureKotlinAndroid(
    commonExtension: BaseExtension,
) {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
    val version = libs.getAppVersion()
    commonExtension.apply {
        compileSdkVersion(version.compile)

        defaultConfig {
            minSdk = version.min
            targetSdk = version.target

            versionCode = version.versionCode
            versionName = version.versionName
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
