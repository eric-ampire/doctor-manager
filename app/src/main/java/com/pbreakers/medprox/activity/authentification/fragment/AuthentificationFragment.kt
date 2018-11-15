package com.pbreakers.medprox.activity.authentification.fragment


import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

import com.pbreakers.medprox.R
import com.pbreakers.medprox.activity.home.MainActivity
import com.pbreakers.medprox.isNotValidText
import com.pbreakers.medprox.model.User
import com.pbreakers.medprox.rest.UserService
import com.pbreakers.medprox.retrofitBuilder
import kotlinx.android.synthetic.main.fragment_authentification.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AuthentificationFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_authentification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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
                    startActivity(Intent(activity, MainActivity::class.java))
                }
            }
        }

        tvCreateAccount.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_authentificationFragment_to_identityFragment)
        }

        tvPasswordForgotten.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_authentificationFragment_to_resetCodeFragment)
        }
    }

    private fun tryToLogin(phoneNumber: String, password: String) {
        val loadingDialog = ProgressDialog(activity).apply {
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
                Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {

                    response.body()?.forEach {
                        Toast.makeText(activity, it.login, Toast.LENGTH_LONG).show()

                        if ((it.login == phoneNumber) and (it.id == password)) {
                            loadingDialog.dismiss()

                            saveUserInformation(it)
                            startActivity(Intent(activity, MainActivity::class.java))
                        }

                        Toast.makeText(activity, "Verifier votre numero ou le mot de passe", Toast.LENGTH_LONG).show()
                    }

                } else {
                    loadingDialog.dismiss()
                    Toast.makeText(activity, response.errorBody().toString(), Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun saveUserInformation(it: User) {
        //val editor = getSharedPreferences("user-information", Context.MODE_PRIVATE).de
    }
}
