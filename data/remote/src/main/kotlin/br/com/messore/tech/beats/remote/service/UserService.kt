package br.com.messore.tech.beats.remote.service

import br.com.messore.tech.beats.domain.model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserService {
    @POST("/users")
    suspend fun register(@Body user: User): User

    @GET("/users")
    suspend fun checkUser(
        @Query("search") name: String,
        @Query("password") password: String
    ): List<User>
}
