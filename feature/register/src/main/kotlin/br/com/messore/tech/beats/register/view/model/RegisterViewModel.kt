package br.com.messore.tech.beats.register.view.model

import androidx.lifecycle.viewModelScope
import br.com.messore.tech.beats.domain.usecase.RegisterUserUseCase
import br.com.messore.tech.beats.view.model.BaseViewModel
import br.com.messore.tech.beats.view.model.runCatching
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class RegisterViewModel(
    private val registerUserUseCase: RegisterUserUseCase,
) : BaseViewModel<RegisterState, RegisterActions>(RegisterState()) {

    fun onRegisterClicked() = viewModelScope.launch {
        setState { copy(loading = true) }
        runCatching(
            dispatcher = Dispatchers.Default,
            execute = {
                registerUserUseCase(stateValue.username, stateValue.password)
            },
            onSuccess = {
                setState { copy(loading = false) }
                sendAction(RegisterActions.Registered)
            },
            onFailure = {
                setState { copy(loading = false) }
                sendAction(RegisterActions.Failure(message))
            }
        )
    }

    fun onUsernameChanged(username: String) {
        setState { copy(username = username) }
    }

    fun onPasswordChanged(password: String) {
        setState { copy(password = password) }
    }
}
