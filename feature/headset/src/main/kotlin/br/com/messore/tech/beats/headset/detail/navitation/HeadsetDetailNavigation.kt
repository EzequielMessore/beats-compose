package br.com.messore.tech.beats.headset.detail.navitation

import androidx.core.os.bundleOf
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.com.messore.tech.beats.headset.detail.HeadsetDetailRoute
import br.com.messore.tech.navigation.Navigation

object HeadsetDetailNavigation : Navigation {
    override val route = "headset_detail_route"
    override val destination = "headset_detail_destination"
    const val headsetIdArg = "headsetId"
}

fun NavGraphBuilder.headsetDetailGraph(onBackClick: () -> Unit) {
    composable(
        route = "${HeadsetDetailNavigation.route}/{${HeadsetDetailNavigation.headsetIdArg}}",
        arguments = listOf(
            navArgument(HeadsetDetailNavigation.headsetIdArg) {
                type = NavType.IntType
            }
        ),
    ) {
        HeadsetDetailRoute(it.arguments ?: bundleOf(), onBackClick)
    }
}
