package com.pbreakers.medprox.activity.authentification.fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import com.pbreakers.medprox.R
import com.pbreakers.medprox.activity.authentification.LoginActivity
import com.pbreakers.medprox.isNotValidText
import kotlinx.android.synthetic.main.fragment_identity.*
import kotlinx.android.synthetic.main.fragment_identity.view.*


class IdentityFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = "MEDPROX | Indentité"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_identity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.previewToLogin.setOnClickListener {
            startActivity(Intent(activity, LoginActivity::class.java))
        }

        view.nextToAdress.setOnClickListener {
            val nom = edName.text.toString()
            val postNom = edPostNom.text.toString()
            val prenom = edPrenom.text.toString()

            when {
                nom.isNotValidText(edNameLayout, "Le nom est invalide") -> return@setOnClickListener
                postNom.isNotValidText(edPostNomLayout, "Le post nom est invalide") -> return@setOnClickListener
                prenom.isNotValidText(edPrenomLayout, "Le prenom est invalide") -> return@setOnClickListener
                else -> saveIdentity(it)
            }
        }
    }

    private fun saveIdentity(view: View) {
        Navigation.findNavController(view).navigate(R.id.action_identityFragment_to_adressFragment)
    }
}
