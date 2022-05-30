package br.com.messore.tech.beats.domain.di

import br.com.messore.tech.beats.domain.usecase.ListHeadsetUseCase
import br.com.messore.tech.beats.domain.usecase.RegisterUserUseCase
import br.com.messore.tech.beats.domain.usecase.SignInUseCase
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object DomainModule {
    fun load() {
        loadKoinModules(module {
            factory { SignInUseCase(get()) }
            factory { ListHeadsetUseCase(get()) }
            factory { RegisterUserUseCase(get()) }
        })
    }
}
