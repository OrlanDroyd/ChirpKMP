package com.github.orlandroyd.chat.presentation.mappers

import com.github.orlandroyd.chat.domain.models.ChatParticipant
import com.github.orlandroyd.core.designsystem.components.avatar.ChatParticipantUi

fun ChatParticipant.toUi(): ChatParticipantUi {
    return ChatParticipantUi(
        id = userId,
        username = username,
        initials = initials,
        imageUrl = profilePictureUrl
    )
}