package br.com.messore.tech.beats.register.compose

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import br.com.messore.tech.beats.compose.components.InputField
import br.com.messore.tech.beats.compose.components.PasswordInputField
import br.com.messore.tech.beats.compose.components.ProgressButton
import br.com.messore.tech.beats.compose.components.TopAppBar
import br.com.messore.tech.beats.compose.theme.SPACING_2
import br.com.messore.tech.beats.compose.theme.SPACING_3
import br.com.messore.tech.beats.register.R
import br.com.messore.tech.beats.register.view.model.RegisterViewModel
import org.koin.androidx.compose.getViewModel

@Composable
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
fun RegisterScreen(
    loading: Boolean = false,
    onBackClick: () -> Unit,
    onRegisterClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = stringResource(R.string.register_title),
                navigationIcon = Icons.Outlined.ArrowBack,
                onNavigationClick = onBackClick,
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Transparent
                ),
            )
        },
        containerColor = Color.Transparent
    ) { innerPadding ->
        BoxWithConstraints(
            modifier = Modifier
                .padding(innerPadding)
                .consumedWindowInsets(innerPadding)
        ) {
            Spacer(modifier = Modifier.height(SPACING_3))

            UserForm(
                loading = loading,
                onRegisterClick = onRegisterClick,
            )
        }
    }
}

@Composable
private fun UserForm(
    loading: Boolean,
    onRegisterClick: () -> Unit,
    viewModel: RegisterViewModel = getViewModel()
) {
    val focus = LocalTextInputService.current
    Column(modifier = Modifier.padding(SPACING_2)) {
        InputField(
            label = stringResource(R.string.register_username),
            onValueChange = viewModel::onUsernameChanged
        )

        Spacer(modifier = Modifier.height(SPACING_3))

        PasswordInputField(
            label = stringResource(R.string.register_password),
            onValueChange = viewModel::onPasswordChanged,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions {
                focus?.hideSoftwareKeyboard()
                onRegisterClick()
            }
        )

        Spacer(modifier = Modifier.height(SPACING_3))

        ProgressButton(
            text = stringResource(id = R.string.register_title),
            loading = loading,
            onClick = onRegisterClick
        )
    }
}
