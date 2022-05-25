package br.com.messore.tech.beats.login

import android.util.Log
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
    navigateToRegister: () -> Unit = {},
    viewModel: LoginViewModel = getViewModel(),
) {
    val state by viewModel.state.collectAsState()

    LoginScreen(loading = state.loading)

    ObserveActions(viewModel, navigateToRegister)
}

@Composable
private fun ObserveActions(viewModel: LoginViewModel, navigateToRegister: () -> Unit) {
    viewModel.action.observe(LocalLifecycleOwner.current) { action ->
        when (action) {
            is LoginAction.Failure -> {
                Log.e("TAG", "ObserveActions: one error occurred")
            }
            LoginAction.SignUp -> navigateToRegister()
            LoginAction.SignIn -> {
                Log.e("TAG", "ObserveActions: logged with success")
            }
        }
    }
}
