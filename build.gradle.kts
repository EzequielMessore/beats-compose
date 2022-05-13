plugins {
    id(Plugins.detekt) version Versions.detekt
    id(Plugins.Jetbrains.jvm) version Versions.kotlin apply false
}

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.gradle)
        classpath(Dependencies.kotlin)
        classpath(Dependencies.detekt)
    }
}


allprojects {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

dependencies {
    detektPlugins(Dependencies.detektFormatting)
}

detekt {
    toolVersion = Versions.detekt
    source = files(
        "${projectDir}/app/src",
        "${projectDir}/buildSrc/src",
        "${projectDir}/data/data/src",
        "${projectDir}/data/remote/src",
        "${projectDir}/domain/src",
    )
    config = files("${projectDir}/detekt/detekt.yml")
    reportsDir = file("${projectDir}/build/reports/detekt/")
}