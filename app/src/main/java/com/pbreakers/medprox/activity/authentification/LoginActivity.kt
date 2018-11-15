package com.pbreakers.medprox.activity.authentification

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
//import androidx.core.content.edit
import com.pbreakers.medprox.R
import com.pbreakers.medprox.activity.home.MainActivity
import com.pbreakers.medprox.isNotValidText
import com.pbreakers.medprox.model.User
import com.pbreakers.medprox.rest.UserService
import com.pbreakers.medprox.retrofitBuilder
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}
