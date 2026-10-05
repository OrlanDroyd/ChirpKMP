package com.github.orlandroyd.chat.data.di

import com.github.orlandroyd.chat.data.chat.KtorChatParticipantService
import com.github.orlandroyd.chat.domain.chat.ChatParticipantService
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val chatDataModule = module {
    singleOf(::KtorChatParticipantService) bind ChatParticipantService::class
}