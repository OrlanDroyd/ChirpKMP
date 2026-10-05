package com.github.orlandroyd.chirp.di

import com.github.orlandroyd.auth.presentation.di.authPresentationModule
import com.github.orlandroyd.chat.data.di.chatDataModule
import com.github.orlandroyd.chat.presentation.di.chatPresentationModule
import com.github.orlandroyd.core.data.di.coreDataModule
import com.github.orlandroyd.core.presentation.di.corePresentationModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            coreDataModule,
            authPresentationModule,
            appModule,
            chatPresentationModule,
            corePresentationModule,
            chatDataModule
        )
    }
}