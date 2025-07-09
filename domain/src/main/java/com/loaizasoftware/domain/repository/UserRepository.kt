package com.loaizasoftware.domain.repository

import com.loaizasoftware.domain.models.User

interface UserRepository {
    suspend fun getUsers(): Result<List<User>>
    suspend fun createUser(user: User): Result<Unit>
}