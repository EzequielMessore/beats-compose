package br.com.messore.tech.beats.data.source

import br.com.messore.tech.beats.domain.model.Headset

sealed interface HeadsetDataSource {
    interface Remote : HeadsetDataSource {
        suspend fun list() : List<Headset>
        suspend fun get(id: Int) : Headset
    }
}
