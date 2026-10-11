package com.github.orlandroyd.chat.domain.chat

import com.github.orlandroyd.chat.domain.models.Chat
import com.github.orlandroyd.core.domain.util.DataError
import com.github.orlandroyd.core.domain.util.Result

interface ChatService {
    suspend fun createChat(
        otherUserIds: List<String>
    ): Result<Chat, DataError.Remote>
}