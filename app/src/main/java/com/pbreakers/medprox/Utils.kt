package com.pbreakers.medprox

import android.util.Log
import com.google.android.material.textfield.TextInputLayout

fun String.isNotValidText(textInputLayout: TextInputLayout, errorMessage: String): Boolean {
    if (this.isEmpty() or this.isBlank()) {
        textInputLayout.error = errorMessage
        return true
    }

    textInputLayout.isErrorEnabled = false
    return false
}

fun String.isNotValidPassWord(textInputLayout: TextInputLayout): Boolean {
    if (this.length < 8) {
        textInputLayout.error = "Le mot de passe doit avoir plus de 8 caractères"
        return true
    }

    textInputLayout.isErrorEnabled = false
    return false
}