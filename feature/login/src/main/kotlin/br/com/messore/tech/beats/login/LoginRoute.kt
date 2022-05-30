package br.com.messore.tech.beats.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalLifecycleOwner
import br.com.messore.tech.beats.login.compose.LoginScreen
import br.com.messore.tech.beats.login.view.model.LoginAction
import br.com.messore.tech.beats.login.view.model.LoginViewModel
import br.com.messore.tech.beats.view.model.observe
import org.koin.androidx.compose.getViewModel

@Composable
internal fun LoginRoute(
    navigateToHeadset: () -> Unit = {},
    navigateToRegister: () -> Unit = {},
    viewModel: LoginViewModel = getViewModel(),
) {
    val state by viewModel.state.collectAsState()

    LoginScreen(loading = state.loading)

    ObserveActions(
        navigateToHeadset = navigateToHeadset,
        navigateToRegister = navigateToRegister
    )
}

@Composable
private fun ObserveActions(
    navigateToHeadset: () -> Unit,
    navigateToRegister: () -> Unit,
    viewModel: LoginViewModel = getViewModel(),
) {
    viewModel.action.observe(LocalLifecycleOwner.current) { action ->
        when (action) {
            is LoginAction.Failure -> {}
            LoginAction.SignIn -> navigateToHeadset()
            LoginAction.SignUp -> navigateToRegister()
        }
    }
}
