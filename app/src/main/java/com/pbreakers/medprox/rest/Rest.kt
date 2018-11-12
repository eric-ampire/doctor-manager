package com.pbreakers.medprox.rest

import com.pbreakers.medprox.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("users")
    fun getUsers() : Call<List<User>>

    @GET("users/{idUser}")
    fun getUser(@Path("idUser") idUser: Int) : Call<User>

}