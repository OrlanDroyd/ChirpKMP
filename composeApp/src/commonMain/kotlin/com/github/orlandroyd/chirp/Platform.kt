package com.github.orlandroyd.chirp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform