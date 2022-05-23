package br.com.messore.tech.beats.compose.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.sp

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    onActionClick: () -> Unit = {},
    actionIcon: ImageVector? = null,
    onNavigationClick: () -> Unit = {},
    navigationIcon: ImageVector? = null,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
) {
    CenterAlignedTopAppBar(
        colors = colors,
        modifier = modifier,
        title = { title?.let { Text(text = it, style = MaterialTheme.typography.titleLarge.copy(fontSize = 20.sp)) } },
        actions = { actionIcon?.let { CreateIcon(onActionClick, it) } },
        navigationIcon = { navigationIcon?.let { CreateIcon(onNavigationClick, it) } },
    )
}

@Composable
private fun CreateIcon(onNavigationClick: () -> Unit, icon: ImageVector) {
    IconButton(onClick = onNavigationClick) {
        Icon(
            tint = Color.White,
            imageVector = icon,
            contentDescription = null,
        )
    }
}
