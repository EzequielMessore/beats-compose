package br.com.messore.tech.beats.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.messore.tech.beats.login.LoginRoute
import br.com.messore.tech.navigation.Navigation

object LoginNavigation : Navigation {
    override val route = "login_route"
    override val destination = "login_destination"
}

fun NavGraphBuilder.loginGraph(
    navigateToRegister: () -> Unit,
    navigateToHeadset: () -> Unit,
) {
    composable(route = LoginNavigation.route) {
        LoginRoute(
            navigateToHeadset = navigateToHeadset,
            navigateToRegister = navigateToRegister,
        )
    }
}
