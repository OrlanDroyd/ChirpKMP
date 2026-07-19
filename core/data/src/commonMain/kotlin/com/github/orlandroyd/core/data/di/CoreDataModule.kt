package com.github.orlandroyd.core.data.di

import com.github.orlandroyd.core.data.auth.KtorAuthService
import com.github.orlandroyd.core.data.logging.KermitLogger
import com.github.orlandroyd.core.data.networking.HttpClientFactory
import com.github.orlandroyd.core.domain.auth.AuthService
import com.github.orlandroyd.core.domain.logging.ChirpLogger
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformCoreDataModule: Module

val coreDataModule = module {
    includes(platformCoreDataModule)
    single<ChirpLogger> { KermitLogger }
    single {
        HttpClientFactory(get()).create(get())
    }
    singleOf(::KtorAuthService) bind AuthService::class
}