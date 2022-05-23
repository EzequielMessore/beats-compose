package br.com.messore.tech.beats.domain.model

data class User(
    val name: String,
    val password: String,
    val avatar: String? = null,
)
