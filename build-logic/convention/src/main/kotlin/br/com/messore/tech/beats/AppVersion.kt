package br.com.messore.tech.beats

data class AppVersion(
    val compile: Int,
    val min: Int,
    val target: Int,
    val versionCode: Int,
    val versionName: String,
)
