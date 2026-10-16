package com.github.orlandroyd.chat.presentation.model

import com.github.orlandroyd.chat.domain.models.ChatMessage
import com.github.orlandroyd.core.designsystem.components.avatar.ChatParticipantUi

data class ChatUi(
    val id: String,
    val localParticipant: ChatParticipantUi,
    val otherParticipants: List<ChatParticipantUi>,
    val lastMessage: ChatMessage?,
    val lastMessageSenderUsername: String?
)