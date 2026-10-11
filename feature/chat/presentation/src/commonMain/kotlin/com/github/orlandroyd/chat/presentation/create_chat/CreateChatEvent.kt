package com.github.orlandroyd.chat.presentation.create_chat

import com.github.orlandroyd.chat.domain.models.Chat

sealed interface CreateChatEvent {
    data class OnChatCreated(val chat: Chat) : CreateChatEvent
}