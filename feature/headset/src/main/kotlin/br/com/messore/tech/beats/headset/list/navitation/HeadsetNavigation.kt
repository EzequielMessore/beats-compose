package br.com.messore.tech.beats.headset.list.navitation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import br.com.messore.tech.beats.headset.list.HeadsetRoute
import br.com.messore.tech.navigation.Navigation

object HeadsetNavigation : Navigation {
    override val route = "headset_route"
    override val destination = "headset_destination"
}

fun NavGraphBuilder.headsetGraph(
    navigateToLogin: () -> Unit,
    navigateToHeadsetDetail: (Int) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    navigation(
        route = HeadsetNavigation.route,
        startDestination = HeadsetNavigation.destination
    ) {
        composable(route = HeadsetNavigation.destination) {
            HeadsetRoute(
                navigateToLogin = navigateToLogin,
                navigateToHeadsetDetail = navigateToHeadsetDetail,
            )
        }
        nestedGraphs()
    }
}
