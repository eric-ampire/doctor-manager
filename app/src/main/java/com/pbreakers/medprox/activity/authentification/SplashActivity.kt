package com.pbreakers.medprox.activity.authentification

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pbreakers.medprox.R
import com.pbreakers.medprox.activity.home.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        object : Thread() {
            override fun run() {
                Thread.sleep(1000)

                val userPreferences = getSharedPreferences("user-info", Context.MODE_PRIVATE)

                if (userPreferences == null) {
                    startActivity(Intent(baseContext, LoginActivity::class.java))
                    finish()
                } else {
                    startActivity(Intent(baseContext, MainActivity::class.java))
                    finish()
                }
            }
        }.start()
    }
}
