package com.pbreakers.medprox.activity.authentification.fragment


import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
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
                    tryToLogin(phoneNumber, password)
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
                .authentification(phoneNumber, password)

        userCallback.enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                loadingDialog.dismiss()
                Toast.makeText(activity, "Failure "  + t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    loadingDialog.dismiss()
                    saveUserInformation(response.body()!!)

                } else {
                    loadingDialog.dismiss()
                    Log.e("ericampire", "Error " + response.raw().toString())
                    Toast.makeText(activity, "Error " + response.raw(), Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun saveUserInformation(user: User) {
        activity!!.getSharedPreferences(User.KEY_USER, Context.MODE_PRIVATE).edit().apply {
            putString(User.ID_USER, user.idUser)
            putString(User.NOM_USER, user.nomUser)
            putString(User.POSTNOM_USER, user.postNomUser)
            putString(User.PRENOM_USER, user.prenomUser)
            putString(User.ADRESSE_USER, user.adressUser)
            putString(User.PASSWORD_USER, user.password)
            putString(User.DATE_ENREG_USER, user.dateEnregistrement)
            putString(User.PROFILE_USER, user.urlProfilUser)
            putString(User.GENRE_USER, user.genre)
            putString(User.LOGIN_USER, user.loginUser)

            apply()
        }

        startActivity(Intent(activity, MainActivity::class.java))
    }
}
