package com.github.orlandroyd.chirp

sealed interface MainEvent {
    data object OnSessionExpired : MainEvent
}