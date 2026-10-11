package com.github.orlandroyd.chat.data.mappers

import com.github.orlandroyd.chat.data.dto.ChatDto
import com.github.orlandroyd.chat.domain.models.Chat
import kotlin.time.Instant

fun ChatDto.toDomain(): Chat {
    return Chat(
        id = id,
        participants = participants.map { it.toDomain() },
        lastActivityAt = Instant.parse(lastActivityAt),
        lastMessage = lastMessage?.toDomain()
    )
}