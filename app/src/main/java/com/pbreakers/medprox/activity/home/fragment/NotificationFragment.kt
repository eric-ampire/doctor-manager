package com.pbreakers.medprox.activity.home.fragment


import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.pbreakers.medprox.R
import com.pbreakers.medprox.getRandomColor
import com.pbreakers.medprox.model.Notification
import com.pbreakers.medprox.model.TypePartenaire
import com.pbreakers.medprox.model.User
import com.pbreakers.medprox.rest.NotificationService
import com.pbreakers.medprox.rest.TypePartenaireService
import com.pbreakers.medprox.retrofitBuilder
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_notification.*
import kotlinx.android.synthetic.main.item_notification.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.random.Random


class NotificationFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = "MEDPROX | Notifications"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = GroupAdapter<ViewHolder>()
        rvListNotification.adapter = adapter

        adapter.add(NotificationItem(Notification(title = "Notification pour le text numero 1", contenu = "Vous etes conviez a prendre par a une reunion")))
        adapter.add(NotificationItem(Notification(title = "Il s'agit de la deuxieme notification", contenu = "Vous etes conviez a prendre par a une reunion")))
        adapter.add(NotificationItem(Notification(title = "C'est pas fini voila la troisieme notification", contenu = "Vous etes conviez a prendre par a une reunion")))
    }

    inner class NotificationItem(val notification: Notification) : Item<ViewHolder>() {
        override fun getLayout(): Int = R.layout.item_notification

        override fun bind(viewHolder: ViewHolder, position: Int) {
            with(viewHolder.itemView) {
                tvTitreNotif.text = notification.title
                tvContenuNotif.text = notification.contenu
                tvDateNofication.text = "Mardi 12-05-2014"
                bannierNotification.background = Resources.getSystem().getDrawable(getRandomColor())
            }
        }
    }
}
