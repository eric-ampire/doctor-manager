package com.pbreakers.medprox.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pbreakers.medprox.R
import com.pbreakers.medprox.model.User
import com.pbreakers.medprox.rest.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), Callback<List<User>> {
    override fun onFailure(call: Call<List<User>>, t: Throwable) {
        Log.e("ericampire", "error")
    }

    override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
        if (response.isSuccessful) {
            response.body()!!.forEach {
                Log.e("ericampire", it.login)
            }
        } else {
            Log.e("ericampire", "error " + response.raw())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(UserService::class.java)
        service.getUser(1).enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {

            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                        Log.e("ericampire", response.body()!!.login)

                } else {
                    Log.e("ericampire", "error " + response.raw())
                }
            }
        })
    }
}
