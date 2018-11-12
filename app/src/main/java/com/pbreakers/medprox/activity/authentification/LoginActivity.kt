package com.pbreakers.medprox.activity.authentification

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pbreakers.medprox.activity.MainActivity
import com.pbreakers.medprox.R
import com.pbreakers.medprox.isNotValidText
import kotlinx.android.synthetic.main.activity_login.*
import android.view.View
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.snackbar.Snackbar
import com.roger.catloadinglibrary.CatLoadingView
import org.json.JSONArray


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton.setOnClickListener {
            val phoneNumber = edPhoneNumber.text.toString()
            val password = edPassword.text.toString()

            when {
                phoneNumber.isNotValidText(edPhoneNumberLayout, "Le numero n'est pas valide") -> {
                    return@setOnClickListener
                }

                password.isNotValidText(edPasswordLayout, "Le mot de passe n'est pas valide") -> {
                    return@setOnClickListener
                }

                else -> tryToLogin()
            }
        }

        tvCreateAccount.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
    }

    private fun tryToLogin() {
        val loadingDialog = ProgressDialog(this).apply {
            setTitle("Connexion")
            setMessage("Patientez s'il vous plait")
            setCancelable(false)
        }


        loadingDialog.show()
    }
}
