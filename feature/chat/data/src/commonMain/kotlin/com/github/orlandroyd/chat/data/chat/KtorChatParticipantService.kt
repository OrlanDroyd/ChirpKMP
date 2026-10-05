package com.github.orlandroyd.chat.data.chat

import com.github.orlandroyd.chat.data.dto.ChatParticipantDto
import com.github.orlandroyd.chat.data.mappers.toDomain
import com.github.orlandroyd.chat.domain.chat.ChatParticipantService
import com.github.orlandroyd.chat.domain.models.ChatParticipant
import com.github.orlandroyd.core.data.networking.get
import com.github.orlandroyd.core.domain.util.DataError
import com.github.orlandroyd.core.domain.util.Result
import com.github.orlandroyd.core.domain.util.map
import io.ktor.client.HttpClient

class KtorChatParticipantService(
    private val httpClient: HttpClient
) : ChatParticipantService {

    override suspend fun searchParticipant(query: String): Result<ChatParticipant, DataError.Remote> {
        return httpClient.get<ChatParticipantDto>(
            route = "/participants",
            queryParams = mapOf(
                "query" to query
            )
        ).map { it.toDomain() }
    }
}