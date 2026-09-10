package com.github.orlandroyd.auth.presentation.di

import com.github.orlandroyd.auth.presentation.email_verification.EmailVerificationViewModel
import com.github.orlandroyd.auth.presentation.forgot_password.ForgotPasswordViewModel
import com.github.orlandroyd.auth.presentation.login.LoginViewModel
import com.github.orlandroyd.auth.presentation.register.RegisterViewModel
import com.github.orlandroyd.auth.presentation.register_success.RegisterSuccessViewModel
import com.github.orlandroyd.auth.presentation.reset_password.ResetPasswordViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val authPresentationModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::RegisterSuccessViewModel)
    viewModelOf(::EmailVerificationViewModel)
    viewModelOf(::LoginViewModel)
    viewModelOf(::ForgotPasswordViewModel)
    viewModelOf(::ResetPasswordViewModel)
}