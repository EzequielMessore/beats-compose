package br.com.messore.tech.beats.remote.service

import br.com.messore.tech.beats.domain.model.Headset
import retrofit2.http.GET

interface HeadsetService {
    @GET("/headset")
    suspend fun getHeadsets(): List<Headset>
}
