package br.com.messore.tech.beats.compose.components.dialog

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties

@Composable
fun createDialog(
    confirmText: String? = null,
    dismissText: String? = null,
): Triple<MutableState<Boolean>, MutableState<String>, MutableState<String>> {
    val show = remember { mutableStateOf(false) }
    val title = remember { mutableStateOf("") }
    val message = remember { mutableStateOf("") }
    val confirmListener = remember { mutableStateOf({}) }
    val dismissListener = remember { mutableStateOf({}) }

    DialogView(
        show = show,
        title = title.value,
        message = message.value,
        confirmText = confirmText ?: stringResource(id = android.R.string.ok),
        onConfirmListener = confirmListener.value,
        dismissText = dismissText,
        onDismissListener = dismissListener.value
    )
    return Triple(show, title, message)
}

@Composable
private fun DialogView(
    show: MutableState<Boolean>,
    title: String? = null,
    message: String? = null,
    confirmText: String? = null,
    dismissText: String? = null,
    onConfirmListener: () -> Unit = {},
    onDismissListener: () -> Unit = {},
) {
    if (show.value) {
        AlertDialog(
            onDismissRequest = {
                show.value = false
            },
            title = {
                title?.let {
                    DialogText(
                        it,
                        style = MaterialTheme.typography.labelLarge.copy(fontSize = 18.sp)
                    )
                }
            },
            text = {
                message?.let {
                    DialogText(it)
                }
            },
            confirmButton = {
                confirmText?.let {
                    DialogButton(text = it, show = show, onClick = onConfirmListener)
                }
            },
            dismissButton = {
                dismissText?.let {
                    DialogButton(text = it, show = show, onClick = onDismissListener)
                }
            },
            properties = DialogProperties(dismissOnClickOutside = false, dismissOnBackPress = false)
        )
    }
}

@Composable
private fun DialogText(text: String, style: TextStyle = MaterialTheme.typography.labelLarge) =
    Text(
        text = text,
        style = style.copy(
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.primary
        )
    )

@Composable
private fun DialogButton(
    text: String,
    onClick: () -> Unit = {},
    show: MutableState<Boolean>
) {
    TextButton(
        onClick = {
            onClick()
            show.value = false
        }
    ) {
        Text(
            text,
            style = MaterialTheme.typography.labelMedium.copy(
                color = MaterialTheme.colorScheme.primary,
                fontSize = 13.sp
            )
        )
    }
}
