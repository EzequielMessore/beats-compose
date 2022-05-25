package br.com.messore.tech.beats.domain.usecase

import br.com.messore.tech.beats.domain.model.User
import br.com.messore.tech.beats.domain.repository.UserRepository

class SignInUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(name: String, password: String): User {
        return repository.signIn(name, password)
    }
}
