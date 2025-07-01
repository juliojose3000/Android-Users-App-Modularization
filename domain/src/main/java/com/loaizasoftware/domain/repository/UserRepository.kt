package com.loaizasoftware.domain.repository

import com.loaizasoftware.domain.models.User

interface UserRepository {
    suspend fun getUsers(): List<User>
}