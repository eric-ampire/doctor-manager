package com.pbreakers.medprox.activity.home.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.pbreakers.medprox.R
import com.pbreakers.medprox.getRandonBackground
import com.pbreakers.medprox.model.TypePartenaire
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.item_dashboard.view.*


class DashBoardFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = "MEDPROX | Acceuil"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = GroupAdapter<ViewHolder>()
        rvListItem.adapter = adapter

        adapter.add(DashBoardItem(TypePartenaire(nomType = "Pharmacie", descripType = "Trouver une")))
        adapter.add(DashBoardItem(TypePartenaire(nomType = "Banque de sang", descripType = "Banque de sang")))
        adapter.add(DashBoardItem(TypePartenaire(nomType = "Hopital", descripType = "Nos hopitaux partenaire")))
        adapter.add(DashBoardItem(TypePartenaire(nomType = "Medecin", descripType = "Trouver un medecin")))
    }

    inner class DashBoardItem(val type: TypePartenaire) : Item<ViewHolder>() {
        override fun getLayout(): Int = R.layout.item_dashboard

        override fun bind(viewHolder: ViewHolder, position: Int) {
            with(viewHolder.itemView) {
                tvTitreType.text = type.nomType
                tvDescripType.text = type.descripType

                ivLogoItem.apply {
                    background = resources.getDrawable(getRandonBackground())
                    when {
                        type.nomType == "Hopital" -> setImageResource(R.drawable.ic_business_black_24dp)
                        type.nomType == "Pharmacie" -> setImageResource(R.drawable.ic_local_pharmacy_black_24dp)
                        type.nomType == "Banque de sang" -> setImageResource(R.drawable.ic_local_hospital_black_24dp)
                        type.nomType == "Medecin" -> setImageResource(R.drawable.ic_person_black_24dp)
                    }
                }
            }
        }
    }
}
