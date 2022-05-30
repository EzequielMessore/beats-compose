plugins {
    alias(libs.plugins.detekt)
    alias(libs.plugins.kotlin.jvm)
}

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.android.gradle)
        classpath(libs.kotlin.gradle)
    }
}

dependencies {
    detektPlugins(libs.detekt.formatting)
}

detekt {
    toolVersion = libs.versions.detekt.get()
    source = files(
        "${projectDir}/app/src",
        "${projectDir}/build-logic/src",
        "${projectDir}/build-logic/convention/src",
        "${projectDir}/core/view-model/src",
        "${projectDir}/core/navigation/src",
        "${projectDir}/data/data/src",
        "${projectDir}/data/remote/src",
        "${projectDir}/domain/src",
        "${projectDir}/feature/headset/src",
        "${projectDir}/feature/login/src",
        "${projectDir}/feature/register/src",
        "${projectDir}/ui/compose/src",
    )
    config = files("${projectDir}/detekt/detekt.yml")
    reportsDir = file("${projectDir}/build/reports/detekt/")
}