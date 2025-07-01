package com.loaizasoftware.data.repositories_impl

import com.loaizasoftware.data.api.RetrofitApiService
import com.loaizasoftware.domain.models.User
import com.loaizasoftware.domain.repository.UserRepository
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(private val apiService: RetrofitApiService): UserRepository {

    override suspend fun getUsers(): List<User> {
        return apiService.getUsers()
    }

}