package com.github.orlandroyd.chat.domain.models

enum class ConnectionState {
    DISCONNECTED,
    CONNECTING,
    CONNECTED,
    ERROR_NETWORK,
    ERROR_UNKNOWN
}