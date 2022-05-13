package br.com.messore.tech.beats.domain.model

data class User(
    val name: String,
    val avatar: String? = null,
    val password: String? = null
)
