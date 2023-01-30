package br.com.messore.tech.beats.headset.detail

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import br.com.messore.tech.beats.compose.components.Background
import br.com.messore.tech.beats.headset.detail.compose.HeadsetDetailScreen
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
internal fun HeadsetDetailRoute(
    bundle: Bundle,
    onBackClick: () -> Unit,
    viewModel: HeadsetDetailViewModel = getViewModel(
        parameters = { parametersOf(bundle) }
    )
) = Background {
    val state by viewModel.state.collectAsState()

    state.headset?.let {
        HeadsetDetailScreen(headset = it, onBackClick = onBackClick)
    }
}
