package br.com.messore.tech.beats.remote.service

import br.com.messore.tech.beats.domain.model.Headset
import retrofit2.http.GET
import retrofit2.http.Path

interface HeadsetService {
    @GET("/headset")
    suspend fun getHeadsets(): List<Headset>

    @GET("/headset/{id}")
    suspend fun get(@Path("id") id: Int): Headset
}
