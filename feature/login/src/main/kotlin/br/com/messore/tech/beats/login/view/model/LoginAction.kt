package br.com.messore.tech.beats.login.view.model

sealed interface LoginAction {
    object SignIn : LoginAction
    object SignUp : LoginAction
    data class Failure(val message: String?) : LoginAction
}
