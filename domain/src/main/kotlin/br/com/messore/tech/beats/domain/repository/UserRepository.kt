package br.com.messore.tech.beats.domain.repository

import br.com.messore.tech.beats.domain.model.User

interface UserRepository {
    suspend fun register(user: User)
}
