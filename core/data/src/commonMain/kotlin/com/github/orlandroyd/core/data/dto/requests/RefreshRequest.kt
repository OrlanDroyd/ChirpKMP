package com.github.orlandroyd.core.data.dto.requests

import kotlinx.serialization.Serializable

@Serializable
data class RefreshRequest(
    val refreshToken: String
)