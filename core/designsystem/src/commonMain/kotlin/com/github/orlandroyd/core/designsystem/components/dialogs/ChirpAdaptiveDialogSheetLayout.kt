package com.github.orlandroyd.core.designsystem.components.dialogs

import androidx.compose.runtime.Composable
import com.github.orlandroyd.core.presentation.util.currentDeviceConfiguration

@Composable
fun ChirpAdaptiveDialogSheetLayout(
    onDismiss: () -> Unit,
    content: @Composable () -> Unit
) {
    val configuration = currentDeviceConfiguration()
    if (configuration.isMobile) {
        ChirpBottomSheet(
            onDismiss = onDismiss,
            content = content
        )
    } else {
        ChirpDialogContent(
            onDismiss = onDismiss,
            content = content
        )
    }
}