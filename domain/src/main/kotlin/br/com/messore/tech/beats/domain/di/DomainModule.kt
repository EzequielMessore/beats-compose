package br.com.messore.tech.beats.domain.di

import br.com.messore.tech.beats.domain.usecase.RegisterUserUseCase
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object DomainModule {
    fun load() {
        loadKoinModules(module {
            factory { RegisterUserUseCase(get()) }
        })
    }
}
