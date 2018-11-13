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

                else -> {
                    startActivity(Intent(baseContext, MainActivity::class.java))
                    //tryToLogin(phoneNumber, password)
                }
            }
        }

        tvCreateAccount.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
    }

    private fun tryToLogin(phoneNumber: String, password: String) {
        val loadingDialog = ProgressDialog(this).apply {
            setTitle("Connexion")
            setMessage("Patientez s'il vous plait")
            setCancelable(false)
        }

        loadingDialog.show()
        val userCallback = retrofitBuilder
                .create(UserService::class.java)
                .getUsers()

        userCallback.enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                loadingDialog.dismiss()
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {

                    response.body()?.forEach {
                        Toast.makeText(baseContext, it.login, Toast.LENGTH_LONG).show()

                        if ((it.login == phoneNumber) and (it.id == password)) {
                            loadingDialog.dismiss()

                            saveUserInformation(it)
                            startActivity(Intent(baseContext, MainActivity::class.java))
                        }

                        Toast.makeText(baseContext, "Verifier votre numero ou le mot de passe", Toast.LENGTH_LONG).show()
                    }

                } else {
                    loadingDialog.dismiss()
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun saveUserInformation(it: User) {
        //val editor = getSharedPreferences("user-information", Context.MODE_PRIVATE).de
    }
}
