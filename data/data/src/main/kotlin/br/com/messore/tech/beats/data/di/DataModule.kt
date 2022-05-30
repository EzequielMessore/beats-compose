package br.com.messore.tech.beats.data.di

import br.com.messore.tech.beats.data.repository.HeadsetRepositoryImpl
import br.com.messore.tech.beats.data.repository.UserRepositoryImpl
import br.com.messore.tech.beats.domain.repository.HeadsetRepository
import br.com.messore.tech.beats.domain.repository.UserRepository
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object DataModule {
    fun load() {
        loadKoinModules(module {
            factory<UserRepository> { UserRepositoryImpl(get()) }
            factory<HeadsetRepository> { HeadsetRepositoryImpl(get()) }
        })
    }
}
