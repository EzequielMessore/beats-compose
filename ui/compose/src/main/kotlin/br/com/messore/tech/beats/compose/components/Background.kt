package br.com.messore.tech.beats.compose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.messore.tech.beats.compose.R

@Composable
fun Background(
    content: @Composable () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    0.1f to Color(0x4D7D22FF),
                    0.4f to Color(0xCC441783),
                    1f to Color.Black,
                )
            )
    ) {
        content()
    }
}

@Composable
fun ImageBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.ic_login_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.3f)
        )

        Background(content)
    }
}

@Preview
@Composable
private fun ImageBackgroundPreview() {
    ImageBackground {
        Column(
            modifier = Modifier
                .padding(top = 63.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "My Beats",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.White,
                    fontSize = 45.sp
                )
            )
        }
    }
}
