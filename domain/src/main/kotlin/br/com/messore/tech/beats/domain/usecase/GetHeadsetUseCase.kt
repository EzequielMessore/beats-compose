package br.com.messore.tech.beats.domain.usecase

import br.com.messore.tech.beats.domain.model.Headset
import br.com.messore.tech.beats.domain.repository.HeadsetRepository

class GetHeadsetUseCase(
    private val repository: HeadsetRepository,
) {
    suspend operator fun invoke(id: Int): Headset {
        return repository.get(id)
    }
}
