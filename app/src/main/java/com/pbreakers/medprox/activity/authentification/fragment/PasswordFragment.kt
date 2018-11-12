package com.pbreakers.medprox.activity.authentification.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import com.pbreakers.medprox.R
import kotlinx.android.synthetic.main.fragment_password.*
import kotlinx.android.synthetic.main.fragment_password.view.*


class PasswordFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = "MEDPROX | Mot de passe"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.previewToAdresse.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_passwordFragment_to_adressFragment)
        }

        view.createAccountButton.setOnClickListener {
            val password = edPassword.text.toString()
            val confirmation = edConfirmation.text.toString()
        }
    }
}
