package com.github.orlandroyd.chat.domain.chat

import com.github.orlandroyd.chat.domain.models.ChatParticipant
import com.github.orlandroyd.core.domain.util.DataError
import com.github.orlandroyd.core.domain.util.Result

interface ChatParticipantService {
    suspend fun searchParticipant(
        query: String
    ): Result<ChatParticipant, DataError.Remote>
}