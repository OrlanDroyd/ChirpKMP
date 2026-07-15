package com.github.orlandroyd.core.domain.auth

import com.github.orlandroyd.core.domain.util.DataError
import com.github.orlandroyd.core.domain.util.EmptyResult

interface AuthService {
    suspend fun register(
        email: String,
        username: String,
        password: String
    ): EmptyResult<DataError.Remote>
}