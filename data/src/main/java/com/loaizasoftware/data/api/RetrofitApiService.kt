package com.loaizasoftware.data.api

import com.loaizasoftware.domain.models.User
import retrofit2.http.GET

interface RetrofitApiService {

    @GET("users/getAll")
    suspend fun getUsers(): List<User>

}