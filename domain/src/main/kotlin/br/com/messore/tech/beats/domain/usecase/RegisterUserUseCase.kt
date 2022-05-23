package br.com.messore.tech.beats.domain.usecase

import br.com.messore.tech.beats.domain.model.User
import br.com.messore.tech.beats.domain.repository.UserRepository

class RegisterUserUseCase(
    private val repository: UserRepository
) {

    suspend operator fun invoke(name: String, password: String) {
        val user = User(name = name, password = password)

        repository.checkUser(user)
        repository.register(user)
    }
}
