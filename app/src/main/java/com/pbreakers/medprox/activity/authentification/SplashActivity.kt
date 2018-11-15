package com.pbreakers.medprox.activity.authentification

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pbreakers.medprox.R
import com.pbreakers.medprox.activity.home.MainActivity
import com.pbreakers.medprox.model.User

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        object : Thread() {
            override fun run() {
                Thread.sleep(1000)

                val userPreferences = baseContext.getSharedPreferences(User.KEY_USER, Context.MODE_PRIVATE)


                if (userPreferences.contains(User.LOGIN_USER) and userPreferences.contains(User.PASSWORD_USER)) {
                    startActivity(Intent(baseContext, MainActivity::class.java))
                    finish()
                } else {

                    startActivity(Intent(baseContext, LoginActivity::class.java))
                    finish()
                }
            }
        }.start()
    }
}
