package br.com.messore.tech.beats.login.view.model

import androidx.lifecycle.viewModelScope
import br.com.messore.tech.beats.domain.usecase.SignInUseCase
import br.com.messore.tech.beats.view.model.BaseViewModel
import br.com.messore.tech.beats.view.model.runCatching
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class LoginViewModel(
    private val signInUseCase: SignInUseCase,
) : BaseViewModel<LoginState, LoginAction>(LoginState()) {

    fun onUsernameChanged(username: String) {
        setState { copy(username = username) }
    }

    fun onPasswordChanged(password: String) {
        setState { copy(password = password) }
    }

    fun onSignUpClicked() {
        sendAction(LoginAction.SignUp)
    }

    fun onSignInClicked() = viewModelScope.launch {
        setState { copy(loading = true) }
        runCatching(
            dispatcher = Dispatchers.Default,
            execute = {
                signInUseCase(stateValue.username, stateValue.password)
            },
            onSuccess = {
                setState { copy(loading = false) }
                sendAction(LoginAction.SignIn)
            },
            onFailure = {
                setState { copy(loading = false) }
                sendAction(LoginAction.Failure(message))
            }
        )
    }
}
