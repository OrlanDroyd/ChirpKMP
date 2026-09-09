package com.github.orlandroyd.chirp

data class MainState(
    val isLoggedIn: Boolean = false,
    val isCheckingAuth: Boolean = true
)