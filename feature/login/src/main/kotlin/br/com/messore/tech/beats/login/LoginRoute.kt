package br.com.messore.tech.beats.login

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import br.com.messore.tech.beats.login.compose.LoginScreen
import br.com.messore.tech.beats.login.view.model.LoginActions
import br.com.messore.tech.beats.login.view.model.LoginViewModel
import observe
import org.koin.androidx.compose.getViewModel

@Composable
internal fun LoginRoute(viewModel: LoginViewModel = getViewModel()) {
    val state by viewModel.state.collectAsState()

    LoginScreen(state.loading) {
        viewModel.onRegisterClicked()
    }
    ObserveActions(viewModel)
}


@Composable
private fun ObserveActions(viewModel: LoginViewModel) {
    val context = LocalContext.current

    viewModel.action.observe(LocalLifecycleOwner.current) { action ->
        when (action) {
            is LoginActions.Failure -> {
                Toast.makeText(context, "Failure: ${action.message}", Toast.LENGTH_SHORT).show()
            }
            LoginActions.SignUp -> {
                Toast.makeText(context, "SignUp", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
