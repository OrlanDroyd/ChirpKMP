package com.github.orlandroyd.auth.presentation.login

sealed interface LoginEvent {
    data object Success : LoginEvent
}