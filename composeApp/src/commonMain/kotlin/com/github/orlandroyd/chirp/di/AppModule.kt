package com.github.orlandroyd.chirp.di

import com.github.orlandroyd.chirp.MainViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::MainViewModel)
}