package com.github.orlandroyd.auth.presentation.register_success

import com.github.orlandroyd.core.presentation.util.UiText

data class RegisterSuccessState(
    val registeredEmail: String = "",
    val isResendingVerificationEmail: Boolean = false,
    val resendVerificationError: UiText? = null
)