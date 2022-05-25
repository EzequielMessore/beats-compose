package br.com.messore.tech.beats.login.di

import br.com.messore.tech.beats.login.view.model.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object LoginModule {
    fun load() {
        loadKoinModules(module {
            viewModel { LoginViewModel(get()) }
        })
    }
}
