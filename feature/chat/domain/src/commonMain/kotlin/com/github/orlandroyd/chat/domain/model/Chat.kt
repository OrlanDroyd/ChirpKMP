package com.github.orlandroyd.chat.domain.model

import kotlin.time.Instant

data class Chat(
    val id: String,
    val participants: List<ChatParticipant>,
    val lastActivityAt: Instant,
    val lastMessage: String?
)