package br.com.messore.tech.beats.login.view.model

import br.com.messore.tech.beats.view.model.BaseViewModel

internal class LoginViewModel : BaseViewModel<LoginState, LoginActions>(LoginState()) {
    fun onRegisterClicked() {
        sendAction(LoginActions.Failure("User already exists"))
    }
}
