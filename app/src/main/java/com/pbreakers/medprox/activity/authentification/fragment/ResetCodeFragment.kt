package com.pbreakers.medprox.activity.authentification.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController

import com.pbreakers.medprox.R
import kotlinx.android.synthetic.main.fragment_reset_code.*

class ResetCodeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = "MEDPROX | Réinitialisation"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        if (edCodeVerification.text != null && edCodeVerification.text!!.isBlank()) {
            outState.putCharSequence("code", edCodeVerification.text.toString())
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        val restoredCode = savedInstanceState?.getCharSequence("code")

        if (restoredCode != null) {
            edCodeVerification.setText(restoredCode)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reset_code, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        verificationCodeButton.setOnClickListener {
            // Si le code correspond
            val codeVerification = edCodeVerification.text.toString()

            Navigation.findNavController(it).navigate(R.id.action_resetCodeFragment_to_passwordFragment)
        }

        tvResendCode.setOnClickListener {
            Toast.makeText(activity, "Vous aller bientot recevoir le code de reinitialisation", Toast.LENGTH_LONG).show()
        }
    }
}
