package br.com.messore.tech.beats.register.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.messore.tech.beats.register.RegisterRoute
import br.com.messore.tech.navigation.Navigation

object RegisterNavigation : Navigation {
    override val route = "${javaClass.simpleName}_route"
    override val destination = "${javaClass.simpleName}_destination"
}

fun NavGraphBuilder.registerGraph(onBackClick: () -> Unit) {
    composable(route = RegisterNavigation.route) {
        RegisterRoute(onBackClick)
    }
}
