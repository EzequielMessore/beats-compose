package br.com.messore.tech.beats.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalLifecycleOwner
import br.com.messore.tech.beats.compose.components.dialog.createDialog
import br.com.messore.tech.beats.login.compose.LoginScreen
import br.com.messore.tech.beats.login.view.model.LoginActions
import br.com.messore.tech.beats.login.view.model.LoginViewModel
import br.com.messore.tech.beats.view.model.observe
import org.koin.androidx.compose.getViewModel

@Composable
internal fun LoginRoute(
    navigateToRegister: () -> Unit = {},
    viewModel: LoginViewModel = getViewModel(),
) {
    val state by viewModel.state.collectAsState()

    LoginScreen(
        loading = state.loading,
        onRegisterClick = viewModel::onRegisterClicked,
        onLoginClick = viewModel::onRegisterClicked
    )

    ObserveActions(viewModel, navigateToRegister)
}

@Composable
private fun ObserveActions(viewModel: LoginViewModel, navigateToRegister: () -> Unit) {
    val (show, title, message) = createDialog()

    viewModel.action.observe(LocalLifecycleOwner.current) { action ->
        when (action) {
            is LoginActions.Failure -> {
                show.value = true
                title.value = "Login fail"
                message.value = "Your login attempt failed"
            }
            LoginActions.SignUp -> navigateToRegister()
        }
    }
}
