package br.com.messore.tech.beats.data.repository

import br.com.messore.tech.beats.data.source.HeadsetDataSource
import br.com.messore.tech.beats.domain.model.Headset
import br.com.messore.tech.beats.domain.repository.HeadsetRepository

class HeadsetRepositoryImpl constructor(
    private val remoteDataSource: HeadsetDataSource.Remote
) : HeadsetRepository {

    override suspend fun list(): List<Headset> {
        return remoteDataSource.list()
    }
}
