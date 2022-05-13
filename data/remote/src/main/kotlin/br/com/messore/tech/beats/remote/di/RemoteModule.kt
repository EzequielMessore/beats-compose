package br.com.messore.tech.beats.remote.di

import br.com.messore.tech.beats.data.source.UserDataSource
import br.com.messore.tech.beats.remote.repository.UserDataSourceRemote
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object RemoteModule {
    fun load() {
        loadKoinModules(module {
            factory<UserDataSource.Remote> { UserDataSourceRemote(get()) }
        })
    }
}
