package com.loaizasoftware.domain.usecases

import com.loaizasoftware.core.usecase.UseCase
import com.loaizasoftware.domain.models.User
import com.loaizasoftware.domain.repository.UserRepository
import javax.inject.Inject

class CreateUserUseCase @Inject constructor(private val userRepository: UserRepository): UseCase<User, Result<Unit>>() {

    override suspend fun invoke(params: User): Result<Unit> {
        return userRepository.createUser(params)
    }

}