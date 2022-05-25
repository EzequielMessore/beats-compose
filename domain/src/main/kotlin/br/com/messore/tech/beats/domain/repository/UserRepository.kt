package br.com.messore.tech.beats.domain.repository

import br.com.messore.tech.beats.domain.model.User

interface UserRepository {
    suspend fun register(user: User)
    suspend fun checkUser(user: User)
    suspend fun signIn(user: String, password: String): User
}
