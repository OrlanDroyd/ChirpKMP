package com.github.orlandroyd.auth.presentation.forgot_password

import androidx.compose.foundation.text.input.TextFieldState
import com.github.orlandroyd.core.presentation.util.UiText

data class ForgotPasswordState(
    val emailTextFieldState: TextFieldState = TextFieldState(),
    val emailError: UiText? = null,
    val canSubmit: Boolean = false,
    val isLoading: Boolean = false,
    val errorText: UiText? = null,
    val isEmailSentSuccessfully: Boolean = false
)