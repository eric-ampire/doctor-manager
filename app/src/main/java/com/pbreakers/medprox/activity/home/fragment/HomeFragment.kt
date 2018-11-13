package com.pbreakers.medprox.activity.home.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView

import com.pbreakers.medprox.R
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        return when(menuItem.itemId) {
            R.id.navigation_home -> {
                activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayoutDashBoard, DashBoardFragment())
                    .commit()

                true
            }

            else -> false
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        activity!!.supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayoutDashBoard, DashBoardFragment())
            .commit()

        bottomNavigation.setOnNavigationItemSelectedListener(this)
    }
}
