plugins {
    alias(libs.plugins.detekt)
    alias(libs.plugins.kotlin.jvm)
    //id("io.gitlab.arturbosch.detekt") version "1.20.0"
    //id("org.jetbrains.kotlin.jvm") version "1.6.10" apply false
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

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
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
        "${projectDir}/data/data/src",
        "${projectDir}/data/remote/src",
        "${projectDir}/domain/src",
    )
    config = files("${projectDir}/detekt/detekt.yml")
    reportsDir = file("${projectDir}/build/reports/detekt/")
}