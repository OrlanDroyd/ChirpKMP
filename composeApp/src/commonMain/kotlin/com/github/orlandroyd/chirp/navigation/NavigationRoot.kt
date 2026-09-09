package com.github.orlandroyd.chirp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.github.orlandroyd.auth.presentation.navigation.AuthGraphRoutes
import com.github.orlandroyd.auth.presentation.navigation.authGraph
import com.github.orlandroyd.chat.presentattion.chat_list.ChatListRoute
import com.github.orlandroyd.chat.presentattion.chat_list.ChatListScreenRoot

@Composable
fun NavigationRoot(
    navController: NavHostController,
    startDestination: Any
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        authGraph(
            navController = navController,
            onLoginSuccess = {
                navController.navigate(ChatListRoute) {
                    popUpTo(AuthGraphRoutes.Graph) {
                        inclusive = true
                    }
                }
            }
        )
        composable<ChatListRoute> {
            ChatListScreenRoot()
        }
    }
}