package br.com.messore.tech.beats.domain.repository

import br.com.messore.tech.beats.domain.model.Headset

interface HeadsetRepository {
    suspend fun list(): List<Headset>
}
