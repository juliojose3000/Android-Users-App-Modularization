package com.loaizasoftware.data.repositories_impl

import com.loaizasoftware.core.network.ApiResultHandler
import com.loaizasoftware.data.api.RetrofitApiService
import com.loaizasoftware.domain.models.User
import com.loaizasoftware.domain.repository.UserRepository
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(private val apiService: RetrofitApiService) :
    UserRepository {

    /*override suspend fun getUsers(): Result<List<User>> {
        return try {
            val users = apiService.getUsers()
            Result.success(users)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }*/

    override suspend fun getUsers(): Result<List<User>> {
        return ApiResultHandler.resolve(apiService::getUsers)
        //return ApiResultHandler.resolve { apiService.getUsers() }
    }

    /*override suspend fun createUser(user: User): Result<Unit> {
        return try {
            val response = apiService.createUser(user)
            if (response.isSuccessful) {
                Result.success(Unit)
            } else {
                Result.failure(Exception("Failed with code ${response.code()}"))
            }

        } catch (e: Exception) {
            Result.failure(e)
        }
    }*/

    override suspend fun createUser(user: User): Result<Unit> {
        return ApiResultHandler.resolve(apiService.createUser(user))
    }

}