package br.com.messore.tech.beats.login.view.model

sealed interface LoginActions {
    object SignUp : LoginActions
    data class Failure(val message: String) : LoginActions
}
