package com.github.orlandroyd.chat.presentation.mappers

import com.github.orlandroyd.chat.domain.models.Chat
import com.github.orlandroyd.chat.presentation.model.ChatUi

fun Chat.toUi(localParticipantId: String): ChatUi {
    val (local, other) = participants.partition { it.userId == localParticipantId }
    return ChatUi(
        id = id,
        localParticipant = local.first().toUi(),
        otherParticipants = other.map { it.toUi() },
        lastMessage = lastMessage,
        lastMessageSenderUsername = participants
            .find { it.userId == lastMessage?.senderId }
            ?.username
    )
}