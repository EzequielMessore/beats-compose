package br.com.messore.tech.beats.headset.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.messore.tech.beats.headset.R

@Composable
fun Headset(
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
) {
    Image(
        alignment = alignment,
        contentDescription = null,
        painter = painterResource(id = R.drawable.headset),
        modifier = modifier.size(width = 190.dp, height = 170.dp),
    )
}
