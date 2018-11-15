package com.pbreakers.medprox.activity.home.fragment


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.pbreakers.medprox.R
import com.pbreakers.medprox.model.User
import kotlinx.android.synthetic.main.fragment_identity.*
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = "MEDPROX | Profile"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        loadProfileData()
    }

    private fun loadProfileData() {
        val userInfo = activity!!.getSharedPreferences(User.KEY_USER, Context.MODE_PRIVATE)

        edNomProfile.setText(userInfo.getString(User.NOM_USER, ""))
        edPostNomProfile.setText(userInfo.getString(User.POSTNOM_USER, ""))
        edPrenomProfile.setText(userInfo.getString(User.PRENOM_USER, ""))
        edGenreProfile.setText(userInfo.getString(User.GENRE_USER, ""))
        edAdresseProfile.setText(userInfo.getString(User.ADRESSE_USER, ""))
    }
}
