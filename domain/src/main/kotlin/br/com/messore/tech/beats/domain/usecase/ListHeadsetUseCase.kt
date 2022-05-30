package br.com.messore.tech.beats.domain.usecase

import br.com.messore.tech.beats.domain.model.Headset
import br.com.messore.tech.beats.domain.repository.HeadsetRepository

class ListHeadsetUseCase(
    private val repository: HeadsetRepository,
) {
    suspend operator fun invoke(): List<Headset> {
        return repository.list()
    }
}
