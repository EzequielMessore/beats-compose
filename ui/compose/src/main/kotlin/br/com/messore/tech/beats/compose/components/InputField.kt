package br.com.messore.tech.beats.compose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
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
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardActions: KeyboardActions = KeyboardActions(),
    keyboardOptions: KeyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    val text = remember { mutableStateOf(TextFieldValue(value)) }
    OutlinedTextField(
        colors = fieldColors(),
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
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation,
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = TextFieldDefaults.MinHeight)
    )
}

@Composable
fun PasswordInputField(
    label: String,
    onValueChange: (String) -> Unit = {},
    keyboardActions: KeyboardActions = KeyboardActions(),
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
) {
    val passwordVisibility = remember { mutableStateOf(false) }

    InputField(
        label = label,
        onValueChange = onValueChange,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        trailingIcon = passwordTrailing(passwordVisibility),
        visualTransformation = if (passwordVisibility.value) VisualTransformation.None
        else PasswordVisualTransformation(),
    )
}

@Composable
private fun passwordTrailing(visibility: MutableState<Boolean>): @Composable () -> Unit {
    return {
        IconButton(onClick = { visibility.value = !visibility.value }) {
            Icon(
                imageVector = if (visibility.value) Icons.Default.Visibility
                else Icons.Filled.VisibilityOff,
                contentDescription = null,
                tint = Color.White.copy(alpha = 0.6f)
            )
        }
    }
}

@Composable
private fun fieldColors(): TextFieldColors {
    return TextFieldDefaults.textFieldColors(
        containerColor = Color.Transparent,
        textColor = Color.White.copy(alpha = 0.87f),
        focusedIndicatorColor = Color(0xFFBB86FC),
        unfocusedIndicatorColor = Color.White.copy(alpha = 0.38f),
        focusedLabelColor = Color(0xFFBB86FC),
        unfocusedLabelColor = Color.White.copy(alpha = 0.60f)
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
