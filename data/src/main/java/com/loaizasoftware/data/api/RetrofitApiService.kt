package com.loaizasoftware.data.api

import com.loaizasoftware.domain.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitApiService {

    @GET("users/getAll")
    suspend fun getUsers(): List<User>

    @POST("users")
    suspend fun createUser(@Body user: User): Response<Unit> //Unit because I'm not interested in the response, just in the code

}