package com.pbreakers.medprox

import android.util.Log
import com.google.android.material.textfield.TextInputLayout
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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


val retrofitBuilder by lazy {
    Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}