package com.github.orlandroyd.chirp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.github.orlandroyd.auth.presentation.navigation.AuthGraphRoutes
import com.github.orlandroyd.chat.presentattion.chat_list.ChatListRoute
import com.github.orlandroyd.chirp.navigation.DeepLinkListener
import com.github.orlandroyd.chirp.navigation.NavigationRoot
import com.github.orlandroyd.core.designsystem.theme.ChirpTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App(
    onAuthenticationChecked: () -> Unit = {},
    viewModel: MainViewModel = koinViewModel()
) {
    val navController = rememberNavController()
    DeepLinkListener(navController)

    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(state.isCheckingAuth) {
        if (!state.isCheckingAuth) {
            onAuthenticationChecked()
        }
    }

    ChirpTheme {
        if (!state.isCheckingAuth) {
            NavigationRoot(
                navController = navController,
                startDestination = if (state.isLoggedIn) {
                    ChatListRoute
                } else {
                    AuthGraphRoutes.Graph
                }
            )
        }
    }
}