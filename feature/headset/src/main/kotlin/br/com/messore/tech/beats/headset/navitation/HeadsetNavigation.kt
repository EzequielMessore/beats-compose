package br.com.messore.tech.beats.headset.navitation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.messore.tech.beats.headset.HeadsetRoute
import br.com.messore.tech.navigation.Navigation

object HeadsetNavigation : Navigation {
    override val route = "headset_route"
    override val destination = "headset_destination"
}

fun NavGraphBuilder.headsetGraph() {
    composable(route = HeadsetNavigation.route) {
        HeadsetRoute()
    }
}
