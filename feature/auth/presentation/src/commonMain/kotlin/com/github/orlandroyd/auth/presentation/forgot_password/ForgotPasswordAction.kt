package com.github.orlandroyd.auth.presentation.forgot_password

sealed interface ForgotPasswordAction {
    data object OnSubmitClick : ForgotPasswordAction
}