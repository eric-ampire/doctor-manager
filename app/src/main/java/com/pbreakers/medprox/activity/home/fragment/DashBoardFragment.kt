package com.pbreakers.medprox.activity.home.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.pbreakers.medprox.R
import com.pbreakers.medprox.model.TypePartenaire
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_dash_board.*
import kotlinx.android.synthetic.main.item_dashboard.view.*


class DashBoardFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dash_board, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = GroupAdapter<ViewHolder>()
        rvListItem.adapter = adapter

        adapter.add(DashBoardItem(TypePartenaire(nomType = "Pharmacie", descripType = "Trouver pr")))
        adapter.add(DashBoardItem(TypePartenaire(nomType = "Banque de sang", descripType = "Trouver pr")))
        adapter.add(DashBoardItem(TypePartenaire(nomType = "Hopital", descripType = "Trouver pr")))
        adapter.add(DashBoardItem(TypePartenaire(nomType = "Medecin", descripType = "Trouver un medecin")))
    }

    class DashBoardItem(val type: TypePartenaire) : Item<ViewHolder>() {
        override fun getLayout(): Int = R.layout.item_dashboard

        override fun bind(viewHolder: ViewHolder, position: Int) {
            with(viewHolder.itemView) {
                tvNomType.text = type.nomType
                tvDescripType.text = type.descripType
            }
        }
    }
}
