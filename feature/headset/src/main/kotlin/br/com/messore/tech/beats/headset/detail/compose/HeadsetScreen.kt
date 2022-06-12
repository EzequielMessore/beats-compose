package br.com.messore.tech.beats.headset.detail.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.com.messore.tech.beats.compose.components.PrimaryButton
import br.com.messore.tech.beats.compose.components.TopAppBar
import br.com.messore.tech.beats.compose.theme.SPACING_1
import br.com.messore.tech.beats.compose.theme.SPACING_2
import br.com.messore.tech.beats.domain.model.Headset
import br.com.messore.tech.beats.headset.R
import br.com.messore.tech.beats.headset.components.Headset

@Composable
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
internal fun HeadsetDetailScreen(
    headset: Headset,
    onBackClick: () -> Unit = {},
) {
    Scaffold(
        containerColor = Color.Transparent,
        topBar = {
            TopAppBar(
                navigationIcon = Icons.Outlined.ArrowBack,
                onNavigationClick = onBackClick,
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Transparent
                ),
            )
        }
    ) { innerPadding ->
        BoxWithConstraints(
            modifier = Modifier
                .padding(innerPadding)
                .consumedWindowInsets(innerPadding)
        ) {
            Column {
                Headset(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                )

                Text(
                    text = headset.model,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                )

                Divider(
                    modifier = Modifier
                        .padding(SPACING_2)
                        .background(Color(0x804B4B4B))
                )

                TableData(headset)

                PrimaryButton(
                    text = stringResource(R.string.buy),
                    modifier = Modifier.padding(SPACING_2)
                )
            }
        }
    }
}

@Composable
fun TableData(headset: Headset) {
    HeadsetRow(text = stringResource(R.string.connection), label = headset.connection)
    HeadsetRow(text = stringResource(R.string.compatibility), label = headset.compatibility)
    HeadsetRow(text = stringResource(R.string.power), label = headset.powerSupply)
    HeadsetRow(text = stringResource(R.string.autonomy), label = headset.autonomy)
    HeadsetRow(text = stringResource(R.string.height), label = headset.height)
    HeadsetRow(text = stringResource(R.string.capture), label = headset.capture)
}

@Composable
fun HeadsetRow(
    text: String,
    label: String,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(bottom = SPACING_1)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(end = SPACING_2),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge.copy(
                    fontSize = 16.sp
                ),
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = SPACING_2),
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                ),
            )
        }
    }
}
