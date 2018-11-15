package com.pbreakers.medprox.rest

import com.pbreakers.medprox.model.Notification
import com.pbreakers.medprox.model.TypePartenaire
import com.pbreakers.medprox.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("users")
    fun getUsers(): Call<List<User>>

    @GET("user/api/{login}/{password}")
    fun authentification(@Path("login") numero: String, @Path("password") password: String) : Call<User>
}

interface TypePartenaireService {
    @GET("type/json")
    fun getAllType(): Call<String>
}

interface NotificationService {
    @GET("user/api/")
    fun getAllNotification(): Call<List<User>>
}