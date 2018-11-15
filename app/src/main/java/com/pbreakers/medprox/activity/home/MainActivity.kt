package com.pbreakers.medprox.activity.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pbreakers.medprox.R
import com.pbreakers.medprox.activity.home.fragment.DashBoardFragment
import com.pbreakers.medprox.activity.home.fragment.NotificationFragment
import com.pbreakers.medprox.activity.home.fragment.ProfileFragment
import com.pbreakers.medprox.model.User
import com.pbreakers.medprox.rest.UserService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.action_launch_home -> {
                //Navigation.findNavController(bottomNavigation).navigate(R.id.action_launch_home)
                supportFragmentManager.beginTransaction().replace(R.id.fragmentHostMain, DashBoardFragment()).commit()
                true
            }

            R.id.action_launch_profil -> {
                //Navigation.findNavController(bottomNavigation).navigate(R.id.action_launch_profil)
                supportFragmentManager.beginTransaction().replace(R.id.fragmentHostMain, ProfileFragment()).commit()
                true
            }

            R.id.action_launch_notification -> {
               // Navigation.findNavController(bottomNavigation).navigate(R.id.action_launch_notification)
                supportFragmentManager.beginTransaction().replace(R.id.fragmentHostMain, NotificationFragment()).commit()
                true
            }

            else -> false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.fragmentHostMain, DashBoardFragment()).commit()

        //NavigationUI.setupWithNavController(bottomNavigation, fragmentHostMain.findNavController())
        bottomNavigation.setOnNavigationItemSelectedListener(this)
    }
}
