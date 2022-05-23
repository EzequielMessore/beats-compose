package br.com.messore.tech.beats.register.view.model

data class RegisterState(
    val loading: Boolean = false,
    val username: String = "",
    val password: String = ""
)
