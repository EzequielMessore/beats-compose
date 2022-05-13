package br.com.messore.tech.beats.remote.di

import br.com.messore.tech.beats.remote.service.UserService
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

object ServicesModule {
    fun load() {
        loadKoinModules(module {
            factory { get<Retrofit>().create<UserService>() }
        })
    }
}
