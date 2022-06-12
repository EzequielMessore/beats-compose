package br.com.messore.tech.beats.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import br.com.messore.tech.beats.headset.detail.navitation.HeadsetDetailNavigation
import br.com.messore.tech.beats.headset.list.navitation.HeadsetNavigation
import br.com.messore.tech.beats.headset.detail.navitation.headsetDetailGraph
import br.com.messore.tech.beats.headset.list.navitation.headsetGraph
import br.com.messore.tech.beats.login.navigation.LoginNavigation
import br.com.messore.tech.beats.login.navigation.loginGraph
import br.com.messore.tech.beats.register.navigation.RegisterNavigation
import br.com.messore.tech.beats.register.navigation.registerGraph

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    startDestination: String = LoginNavigation.route,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        loginGraph(
            navigateToHeadset = {
                navController.navigate(HeadsetNavigation.route) {
                    popUpTo(LoginNavigation.route) { inclusive = true }
                }
            },
            navigateToRegister = {
                navController.navigate(RegisterNavigation.route)
            },
        )

        registerGraph {
            navController.popBackStack()
        }

        headsetGraph(
            navigateToLogin = {
                navController.navigate(LoginNavigation.route) {
                    popUpTo(HeadsetNavigation.route) {
                        inclusive = true
                    }
                }
            },
            navigateToHeadsetDetail = {
                navController.navigate("${HeadsetDetailNavigation.route}/$it")
            },
            nestedGraphs = {
                headsetDetailGraph {
                    navController.popBackStack()
                }
            }
        )

    }
}
