package com.github.orlandroyd.core.data.auth

import com.github.orlandroyd.core.data.dto.requests.RegisterRequest
import com.github.orlandroyd.core.data.networking.post
import com.github.orlandroyd.core.domain.auth.AuthService
import com.github.orlandroyd.core.domain.util.DataError
import com.github.orlandroyd.core.domain.util.EmptyResult
import io.ktor.client.HttpClient

class KtorAuthService(
    private val httpClient: HttpClient
) : AuthService {

    override suspend fun register(
        email: String,
        username: String,
        password: String
    ): EmptyResult<DataError.Remote> {
        return httpClient.post(
            route = "/auth/register",
            body = RegisterRequest(
                email = email,
                username = username,
                password = password
            )
        )
    }
}