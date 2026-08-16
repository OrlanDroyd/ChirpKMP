package com.github.orlandroyd.chirp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.github.orlandroyd.chirp.navigation.DeepLinkListener
import com.github.orlandroyd.chirp.navigation.NavigationRoot
import com.github.orlandroyd.core.designsystem.theme.ChirpTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    DeepLinkListener(navController)

    ChirpTheme {
        NavigationRoot(navController)
    }
}