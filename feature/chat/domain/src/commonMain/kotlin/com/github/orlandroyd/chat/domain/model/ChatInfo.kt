package com.github.orlandroyd.chat.domain.model

data class ChatInfo(
    val chat: Chat,
    val messages: List<MessageWithSender>
)