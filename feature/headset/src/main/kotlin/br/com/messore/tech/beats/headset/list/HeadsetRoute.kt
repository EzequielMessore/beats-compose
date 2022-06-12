package br.com.messore.tech.beats.headset.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import br.com.messore.tech.beats.compose.components.Background
import br.com.messore.tech.beats.headset.list.compose.HeadsetScreen
import org.koin.androidx.compose.getViewModel

@Composable
internal fun HeadsetRoute(
    navigateToLogin: () -> Unit,
    navigateToHeadsetDetail: (Int) -> Unit,
    viewModel: HeadsetViewModel = getViewModel(),
) = Background {
    val state by viewModel.state.collectAsState()

    HeadsetScreen(
        headsets = state.headsets,
        onLogoutClick = navigateToLogin,
        onDetailClick = navigateToHeadsetDetail,
    )
}
