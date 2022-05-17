package br.com.messore.tech.beats

import org.gradle.api.artifacts.VersionCatalog

fun VersionCatalog.getAppVersion(): AppVersion {
    val compileSdk = versionToInt("compileSdk")
    val minSdk = versionToInt("minSdk")
    val targetSdk = versionToInt("targetSdk")
    val versionCode = versionToInt("versionCode")

    return AppVersion(
        compile = compileSdk,
        min = minSdk,
        target = targetSdk,
        versionCode = versionCode,
        versionName = findVersion("versionName").get().requiredVersion,
    )
}

fun VersionCatalog.versionToInt(alias: String): Int {
    return findVersion(alias).get().requiredVersion.toInt()
}
