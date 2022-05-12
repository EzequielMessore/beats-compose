plugins {
    id(Plugins.detekt) version Versions.detekt
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
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:${Versions.detekt}")
}

detekt {
    toolVersion = Versions.detekt
    source = files(
        "${projectDir}/app/src",
        "${projectDir}/data/remote/src",
    )
    config = files("${projectDir}/detekt/detekt.yml")
    reportsDir = file("${projectDir}/build/reports/detekt/")
}