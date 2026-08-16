package com.github.orlandroyd.auth.presentation.di

import com.github.orlandroyd.auth.presentation.email_verification.EmailVerificationViewModel
import com.github.orlandroyd.auth.presentation.register.RegisterViewModel
import com.github.orlandroyd.auth.presentation.register_success.RegisterSuccessViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val authPresentationModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::RegisterSuccessViewModel)
    viewModelOf(::EmailVerificationViewModel)
}