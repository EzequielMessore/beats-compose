package br.com.messore.tech.beats.remote.service

import br.com.messore.tech.beats.domain.model.User
import retrofit2.http.POST

interface UserService {
    @POST("/users")
    suspend fun register(user: User): User
}
