package com.pbreakers.medprox.activity.authentification.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import com.pbreakers.medprox.R
import com.pbreakers.medprox.isNotValidText
import kotlinx.android.synthetic.main.fragment_adress.*
import kotlinx.android.synthetic.main.fragment_adress.view.*


class AdressFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = "MEDPROX | Adresse"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adress, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.previewToIndentity.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_adressFragment_to_identityFragment)
        }

        view.nextToPassword.setOnClickListener {
            val number = edPhoneNumber.text.toString()
            val adress = edAdress.text.toString()

            when {
                number.isNotValidText(edPhoneNumberLayout, "Le numéro est invalide") -> return@setOnClickListener
                adress.isNotValidText(edAdressLayout, "L'adresse est invalide") -> return@setOnClickListener
                else -> saveAdress(it)
            }

        }
    }

    private fun saveAdress(it: View) {
        Navigation.findNavController(it).navigate(R.id.action_adressFragment_to_passwordFragment)
    }
}
