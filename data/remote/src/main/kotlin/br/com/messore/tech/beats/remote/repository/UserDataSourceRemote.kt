package br.com.messore.tech.beats.remote.repository

import br.com.messore.tech.beats.data.source.UserDataSource
import br.com.messore.tech.beats.domain.exceptions.UserAlreadyExistsException
import br.com.messore.tech.beats.domain.exceptions.UserNotFoundException
import br.com.messore.tech.beats.domain.model.User
import br.com.messore.tech.beats.remote.extensions.getOrThrow
import br.com.messore.tech.beats.remote.service.UserService

class UserDataSourceRemote constructor(
    private val userService: UserService,
) : UserDataSource.Remote {

    override suspend fun signIn(name: String, password: String): User {
        return runCatching {
            val users = userService.checkUser(name, password)

            users.find {
                it.name == name && it.password == password
            } ?: throw UserNotFoundException()
        }.getOrThrow()
    }

    override suspend fun register(user: User) {
        runCatching {
            userService.register(user)
        }.getOrThrow()
    }

    override suspend fun checkUser(user: User) {
        runCatching {
            val users = userService.checkUser(user.name, user.password)
            if (users.isNotEmpty()) throw UserAlreadyExistsException()
        }.getOrThrow()
    }
}
