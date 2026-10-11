package com.github.orlandroyd.chat.data.chat

import com.github.orlandroyd.chat.data.dto.ChatDto
import com.github.orlandroyd.chat.data.dto.request.CreateChatRequest
import com.github.orlandroyd.chat.data.mappers.toDomain
import com.github.orlandroyd.chat.domain.chat.ChatService
import com.github.orlandroyd.chat.domain.models.Chat
import com.github.orlandroyd.core.data.networking.post
import com.github.orlandroyd.core.domain.util.DataError
import com.github.orlandroyd.core.domain.util.Result
import com.github.orlandroyd.core.domain.util.map
import io.ktor.client.HttpClient

class KtorChatService(
    private val httpClient: HttpClient
) : ChatService {

    override suspend fun createChat(otherUserIds: List<String>): Result<Chat, DataError.Remote> {
        return httpClient.post<CreateChatRequest, ChatDto>(
            route = "/chat",
            body = CreateChatRequest(
                otherUserIds = otherUserIds
            )
        ).map { it.toDomain() }
    }
}