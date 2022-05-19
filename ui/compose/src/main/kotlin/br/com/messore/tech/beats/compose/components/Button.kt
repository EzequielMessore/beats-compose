package br.com.messore.tech.beats.compose.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.messore.tech.beats.compose.theme.SPACING_2

internal val buttonSize = 48.dp

@Composable
fun PrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit = {}
) {
    Button(
        text = text,
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        backgroundColor = MaterialTheme.colorScheme.primary,
    )
}

@Composable
fun ProgressButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
    loading: Boolean
) {
    Box(modifier) {
        Crossfade(targetState = loading) { loading ->
            if (loading) {
                PrimaryButton(
                    text = "",
                    enabled = false,
                    onClick = onClick
                )
            } else {
                PrimaryButton(
                    text = text,
                    enabled = enabled,
                    onClick = onClick
                )
            }
        }

        AnimatedVisibility(
            modifier = Modifier.align(Alignment.Center),
            visible = loading, enter = fadeIn(), exit = fadeOut()
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(buttonSize - SPACING_2),
                color = MaterialTheme.colorScheme.onPrimary,
                strokeWidth = 3.dp
            )
        }
    }
}

@Composable
internal fun Button(
    text: String,
    backgroundColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation()
) {
    val buttonEnabledAlpha = 1f
    val backgroundDisabledAlpha = 0.8f

    val backgroundAlpha by animateFloatAsState(
        targetValue = if (enabled) buttonEnabledAlpha else backgroundDisabledAlpha
    )

    Button(
        onClick = onClick,
        enabled = backgroundAlpha == buttonEnabledAlpha,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColorFor(backgroundColor),
            disabledContainerColor = backgroundColor
        ),
        shape = RoundedCornerShape(200.dp),
        elevation = elevation,
        modifier = modifier
            .height(buttonSize)
            .fillMaxWidth()
            .alpha(backgroundAlpha)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
        )
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        PrimaryButton("Testing", enabled = false, modifier = Modifier)
    }
}

@Preview
@Composable
private fun ProgressButtonPreview() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ProgressButton("Testing", loading = true, modifier = Modifier)
    }
}
