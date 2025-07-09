package com.loaizasoftware.domain.usecases

import com.loaizasoftware.core.usecase.UseCase
import com.loaizasoftware.domain.models.User
import com.loaizasoftware.domain.repository.UserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val usersRepository: UserRepository): UseCase<Unit, Result<List<User>>>() {

    override suspend operator fun invoke(params: Unit): Result<List<User>> {
        return usersRepository.getUsers()
    }

}