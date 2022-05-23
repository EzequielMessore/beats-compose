package br.com.messore.tech.beats.register

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalLifecycleOwner
import br.com.messore.tech.beats.compose.components.Background
import br.com.messore.tech.beats.register.compose.RegisterScreen
import br.com.messore.tech.beats.register.view.model.RegisterActions
import br.com.messore.tech.beats.register.view.model.RegisterViewModel
import br.com.messore.tech.beats.view.model.observe
import org.koin.androidx.compose.getViewModel

@Composable
internal fun RegisterRoute(
    onBackClick: () -> Unit,
    viewModel: RegisterViewModel = getViewModel(),
) = Background {
    val state by viewModel.state.collectAsState()

    RegisterScreen(
        loading = state.loading,
        onBackClick = onBackClick,
        onRegisterClick = viewModel::onRegisterClicked,
    )

    ObserveActions(onRegistered = {
        onBackClick()
    })
}

@Composable
private fun ObserveActions(
    onRegistered: () -> Unit,
    viewModel: RegisterViewModel = getViewModel(),
) {

    viewModel.action.observe(LocalLifecycleOwner.current) { action ->
        when (action) {
            is RegisterActions.Failure -> {

            }
            RegisterActions.Registered -> {

            }
        }
    }
}
