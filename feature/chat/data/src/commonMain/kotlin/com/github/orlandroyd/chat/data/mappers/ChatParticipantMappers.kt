package com.github.orlandroyd.chat.data.mappers

import com.github.orlandroyd.chat.data.dto.ChatParticipantDto
import com.github.orlandroyd.chat.domain.models.ChatParticipant

fun ChatParticipantDto.toDomain(): ChatParticipant {
    return ChatParticipant(
        userId = userId,
        username = username,
        profilePictureUrl = profilePictureUrl
    )
}