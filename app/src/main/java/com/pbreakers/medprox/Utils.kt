package com.pbreakers.medprox

import android.util.Log
import com.google.android.material.textfield.TextInputLayout
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.random.Random


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


val retrofitBuilder: Retrofit by lazy {
    Retrofit.Builder()
        .baseUrl("http://192.168.43.46/medprox/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun main(args: Array<String>) {
    val randomValue = 0..7

    println(randomValue.toList().shuffled())
}

fun getRandomColor(): Int {

    val colors = listOf(
        android.R.color.holo_red_light,
        android.R.color.holo_blue_light,
        android.R.color.holo_purple,
        android.R.color.holo_green_light,
        android.R.color.holo_orange_light
    )

    val randomIndice = (0..(colors.size - 1)).toList().shuffled().first()
    return colors[randomIndice]
}

fun getRandonBackground(): Int {

    val background = listOf(
        R.drawable.bg_circle_bleu,
        R.drawable.bg_circle_darkmauve,
        R.drawable.bg_circle_green,
        R.drawable.bg_circle_mauve,
        R.drawable.bg_circle_orange,
        R.drawable.bg_circle_lightbleu
    )

    val randomIndice = (0..(background.size - 1)).toList().shuffled().first()
    return background[randomIndice]
}