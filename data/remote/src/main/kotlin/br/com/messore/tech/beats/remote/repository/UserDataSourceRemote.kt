package br.com.messore.tech.beats.remote.repository

import br.com.messore.tech.beats.data.source.UserDataSource
import br.com.messore.tech.beats.domain.model.User
import br.com.messore.tech.beats.remote.extensions.getOrThrowDomainError
import br.com.messore.tech.beats.remote.service.UserService

class UserDataSourceRemote constructor(
    private val userService: UserService,
) : UserDataSource.Remote {

    override suspend fun register(user: User) {
        runCatching {
            userService.register(user)
        }.getOrThrowDomainError()
    }
}
