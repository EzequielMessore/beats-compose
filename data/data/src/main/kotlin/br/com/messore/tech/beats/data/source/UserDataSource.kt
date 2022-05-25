package br.com.messore.tech.beats.data.source

import br.com.messore.tech.beats.domain.model.User

sealed interface UserDataSource {
    interface Remote : UserDataSource {
        suspend fun register(user: User)
        suspend fun checkUser(user: User)
        suspend fun signIn(name: String, password: String): User
    }
}
