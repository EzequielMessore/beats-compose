package br.com.messore.tech.beats.data.repository

import br.com.messore.tech.beats.data.source.UserDataSource
import br.com.messore.tech.beats.domain.model.User
import br.com.messore.tech.beats.domain.repository.UserRepository

class UserRepositoryImpl constructor(
    private val remoteDataSource: UserDataSource.Remote
) : UserRepository {

    override suspend fun register(user: User) {
        remoteDataSource.register(user)
    }
}
