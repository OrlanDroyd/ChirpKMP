@file:OptIn(ExperimentalMaterial3AdaptiveApi::class, ExperimentalComposeUiApi::class)

package com.github.orlandroyd.chat.presentation.chat_list_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.backhandler.BackHandler
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.orlandroyd.chat.presentation.chat_list.ChatListRoot
import com.github.orlandroyd.chat.presentation.create_chat.CreateChatRoot
import com.github.orlandroyd.core.designsystem.theme.extended
import com.github.orlandroyd.core.presentation.util.DialogSheetScopedViewModel
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ChatListDetailAdaptiveLayout(
    onLogout: () -> Unit,
    chatListDetailViewModel: ChatListDetailViewModel = koinViewModel()
) {
    val sharedState by chatListDetailViewModel.state.collectAsStateWithLifecycle()
    val scaffoldDirective = createNoSpacingPaneScaffoldDirective()
    val scaffoldNavigator = rememberListDetailPaneScaffoldNavigator(
        scaffoldDirective = scaffoldDirective
    )
    val scope = rememberCoroutineScope()

    BackHandler(enabled = scaffoldNavigator.canNavigateBack()) {
        scope.launch {
            scaffoldNavigator.navigateBack()
        }
    }

    ListDetailPaneScaffold(
        directive = scaffoldDirective,
        value = scaffoldNavigator.scaffoldValue,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.extended.surfaceLower),
        listPane = {
            AnimatedPane {
                ChatListRoot(
                    onChatClick = {
                        chatListDetailViewModel.onAction(ChatListDetailAction.OnChatClick(it.id))
                        scope.launch {
                            scaffoldNavigator.navigateTo(
                                ListDetailPaneScaffoldRole.Detail
                            )
                        }
                    },
                    onConfirmLogoutClick = onLogout,
                    onCreateChatClick = {
                        chatListDetailViewModel.onAction(ChatListDetailAction.OnCreateChatClick)
                    },
                    onProfileSettingsClick = {
                        chatListDetailViewModel.onAction(ChatListDetailAction.OnProfileSettingsClick)
                    },
                )
            }
        },
        detailPane = {
            AnimatedPane {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    sharedState.selectedChatId?.let {
                        Text(
                            text = it
                        )
                    }
                }
            }
        }
    )

    DialogSheetScopedViewModel(
        visible = sharedState.dialogState is DialogState.CreateChat
    ) {
        CreateChatRoot(
            onChatCreated = { chat ->
                chatListDetailViewModel.onAction(ChatListDetailAction.OnDismissCurrentDialog)
                chatListDetailViewModel.onAction(ChatListDetailAction.OnChatClick(chat.id))
                scope.launch {
                    scaffoldNavigator.navigateTo(ListDetailPaneScaffoldRole.Detail)
                }
            },
            onDismiss = {
                chatListDetailViewModel.onAction(ChatListDetailAction.OnDismissCurrentDialog)
            }
        )
    }
}