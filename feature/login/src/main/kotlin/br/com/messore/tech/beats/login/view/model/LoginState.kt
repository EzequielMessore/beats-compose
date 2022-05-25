package br.com.messore.tech.beats.login.view.model

data class LoginState(
    val loading: Boolean = false,
    val username: String = "",
    val password: String = ""
)
