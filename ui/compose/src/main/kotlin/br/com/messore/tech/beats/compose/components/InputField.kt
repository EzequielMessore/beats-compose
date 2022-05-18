package br.com.messore.tech.beats.compose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import br.com.messore.tech.beats.compose.theme.MyBeatsComposeTheme
import br.com.messore.tech.beats.compose.theme.SPACING_1

@Composable
fun InputField(
    label: String,
    modifier: Modifier = Modifier,
    value: String = "",
    maxLines: Int = 1,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    onValueChange: (String) -> Unit = {},
    keyboardActions: KeyboardActions = KeyboardActions(),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    val text = remember { mutableStateOf(TextFieldValue(value)) }
    OutlinedTextField(
        value = text.value,
        label = { Text(label) },
        enabled = enabled,
        maxLines = maxLines,
        singleLine = singleLine,
        onValueChange = {
            text.value = it
            onValueChange(it.text)
        },
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = TextFieldDefaults.MinHeight)
    )
}

@Preview
@Composable
private fun InputFieldPreview() {
    Column(
        modifier = Modifier
            .padding(SPACING_1)
            .fillMaxWidth()
    ) {
        InputField(value = "", label = "Username")
        InputField(value = "", label = "Password")
    }
}
