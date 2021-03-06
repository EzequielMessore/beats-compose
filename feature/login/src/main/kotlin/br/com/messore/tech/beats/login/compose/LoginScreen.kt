package br.com.messore.tech.beats.login.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.messore.tech.beats.compose.components.ImageBackground
import br.com.messore.tech.beats.compose.components.InputField
import br.com.messore.tech.beats.compose.components.PasswordInputField
import br.com.messore.tech.beats.compose.components.ProgressButton
import br.com.messore.tech.beats.compose.theme.MyBeatsComposeTheme
import br.com.messore.tech.beats.compose.theme.SPACING_1
import br.com.messore.tech.beats.compose.theme.SPACING_3
import br.com.messore.tech.beats.login.R
import br.com.messore.tech.beats.login.view.model.LoginViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun LoginScreen(
    loading: Boolean = false,
) {
    ImageBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Header(modifier = Modifier.fillMaxHeight(0.4f))

            LoginForm(loading = loading)
        }
    }
}

@Composable
private fun Header(modifier: Modifier = Modifier) = Column(modifier = modifier) {
    Text(
        text = stringResource(id = R.string.login_title),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 63.dp),
        style = MaterialTheme.typography.titleLarge.copy(color = Color.White)
    )

    Text(
        text = stringResource(id = R.string.login_subtitle),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = SPACING_1),
        style = MaterialTheme.typography.labelMedium.copy(color = Color.White)
    )
}

@Composable
private fun LoginForm(
    loading: Boolean,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = getViewModel(),
) = Column(
    modifier = modifier
        .fillMaxSize()
        .padding(SPACING_3)
        .verticalScroll(rememberScrollState()),
    verticalArrangement = Arrangement.Bottom,
    horizontalAlignment = Alignment.CenterHorizontally,
) {
    val focus = LocalTextInputService.current
    val state by viewModel.state.collectAsState()

    InputField(
        stringResource(id = R.string.login_user),
        onValueChange = viewModel::onUsernameChanged
    )

    Spacer(modifier = Modifier.height(SPACING_3))

    PasswordInputField(
        label = stringResource(R.string.login_password),
        onValueChange = viewModel::onPasswordChanged,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions {
            focus?.hideSoftwareKeyboard()
            viewModel.onSignInClicked()
        }
    )

    Spacer(modifier = Modifier.height(SPACING_3))

    ProgressButton(
        loading = loading,
        enabled = state.buttonEnabled,
        onClick = viewModel::onSignInClicked,
        text = stringResource(R.string.login_log_in),
    )

    Spacer(modifier = Modifier.height(SPACING_3))

    Registry(onRegisterClick = viewModel::onSignUpClicked)
}

@Composable
private fun Registry(modifier: Modifier = Modifier, onRegisterClick: () -> Unit) {
    Row(modifier = modifier.padding(bottom = 63.dp)) {
        Text(
            text = stringResource(R.string.login_un_registered),
            style = MaterialTheme.typography.labelMedium
        )
        Text(
            text = stringResource(R.string.login_subscribe),
            modifier = Modifier
                .padding(start = SPACING_1)
                .clickable(onClick = onRegisterClick),
            style = MaterialTheme.typography.labelMedium.copy(color = Color(0xFF0ACF83))
        )
    }
}

@Preview
@Composable
fun LoginScreenPreview() = MyBeatsComposeTheme {
    LoginScreen()
}
