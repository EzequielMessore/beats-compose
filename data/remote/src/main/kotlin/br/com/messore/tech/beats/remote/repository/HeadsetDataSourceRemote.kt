package br.com.messore.tech.beats.remote.repository

import br.com.messore.tech.beats.data.source.HeadsetDataSource
import br.com.messore.tech.beats.domain.model.Headset
import br.com.messore.tech.beats.remote.extensions.getOrThrow
import br.com.messore.tech.beats.remote.service.HeadsetService

class HeadsetDataSourceRemote constructor(
    private val headsetService: HeadsetService,
) : HeadsetDataSource.Remote {

    override suspend fun list(): List<Headset> {
        return runCatching {
            headsetService.getHeadsets()
        }.getOrThrow()
    }
}
