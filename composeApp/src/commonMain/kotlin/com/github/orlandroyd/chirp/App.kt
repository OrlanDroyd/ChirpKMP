package com.github.orlandroyd.chirp

import androidx.compose.runtime.Composable
import com.github.orlandroyd.auth.presentation.register.RegisterRoot
import com.github.orlandroyd.core.designsystem.theme.ChirpTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    ChirpTheme {
        RegisterRoot(
            onRegisterSuccess = {}
        )
    }
}