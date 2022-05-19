package br.com.messore.tech.beats.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import br.com.messore.tech.beats.compose.theme.MyBeatsComposeTheme
import br.com.messore.tech.beats.navigation.AppNavHost

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun BeatsApp() {
    MyBeatsComposeTheme {
        val navController = rememberNavController()

        Scaffold(
            modifier = Modifier,
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onBackground,
        ) { padding ->
            Row(Modifier.fillMaxSize()) {
                AppNavHost(
                    navController = navController,
                    modifier = Modifier
                        .padding(padding)
                )
            }
        }
    }
}
