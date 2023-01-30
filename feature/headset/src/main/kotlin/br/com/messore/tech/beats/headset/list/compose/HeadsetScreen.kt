package br.com.messore.tech.beats.headset.list.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.messore.tech.beats.compose.components.PrimaryButton
import br.com.messore.tech.beats.compose.theme.SPACING_1
import br.com.messore.tech.beats.compose.theme.SPACING_2
import br.com.messore.tech.beats.domain.extensions.formatCurrency
import br.com.messore.tech.beats.domain.model.Headset
import br.com.messore.tech.beats.headset.R
import br.com.messore.tech.beats.headset.components.Headset

@Composable
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
fun HeadsetScreen(
    headsets: List<Headset>,
    onLogoutClick: () -> Unit = {},
    onDetailClick: (Int) -> Unit = {}
) {
    Scaffold(
        containerColor = Color.Transparent,
    ) { innerPadding ->
        BoxWithConstraints(
            modifier = Modifier
                .padding(innerPadding)
                .consumedWindowInsets(innerPadding)
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(SPACING_2))

                Headset()

                Spacer(modifier = Modifier.height(SPACING_2))

                PrimaryButton(
                    fullSize = false,
                    onClick = onLogoutClick,
                    text = stringResource(R.string.logout),
                    modifier = Modifier.fillMaxWidth(0.4f)
                )

                LazyColumn(Modifier.padding(top = SPACING_2)) {
                    items(headsets) { headset ->
                        HeadsetItem(headset, onDetailClick)
                    }
                }
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun HeadsetItem(
    headset: Headset,
    onDetailClick: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF232323))
            .clickable(onClick = { onDetailClick(headset.id) })
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(SPACING_2),
        ) {
            Card(
                modifier = Modifier
                    .size(55.dp)
                    .align(Alignment.CenterStart),
                shape = MaterialTheme.shapes.large,
            ) {
                Image(
                    contentDescription = null,
                    modifier = Modifier.padding(SPACING_1),
                    painter = painterResource(id = R.drawable.headset),
                )
            }

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.Companion
                    .align(Alignment.Center),
            ) {
                Text(
                    text = headset.model,
                    style = MaterialTheme.typography.labelMedium,
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        contentDescription = null,
                        imageVector = Icons.Filled.Star,
                        tint = Color(0xFFF6C44A),
                    )

                    Text(
                        text = headset.rating.toString(),
                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Normal),
                    )

                    Text(
                        modifier = Modifier.padding(start = SPACING_1),
                        text = stringResource(R.string.reviews, headset.reviews),
                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Normal),
                    )
                }
            }

            Column(
                modifier = Modifier.Companion.align(Alignment.CenterEnd),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = headset.price.formatCurrency(),
                    style = MaterialTheme.typography.labelLarge.copy(MaterialTheme.colorScheme.tertiary),
                )
            }
        }
    }
}

@Preview
@Composable
fun HeadsetScreenPreview() {
    HeadsetScreen(emptyList())
}
