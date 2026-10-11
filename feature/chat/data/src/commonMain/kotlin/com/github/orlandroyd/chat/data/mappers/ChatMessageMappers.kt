package com.github.orlandroyd.chat.data.mappers

import com.github.orlandroyd.chat.data.dto.ChatMessageDto
import com.github.orlandroyd.chat.domain.models.ChatMessage
import kotlin.time.Instant

fun ChatMessageDto.toDomain(): ChatMessage {
    return ChatMessage(
        id = id,
        chatId = chatId,
        content = content,
        createdAt = Instant.parse(createdAt),
        senderId = senderId
    )
}