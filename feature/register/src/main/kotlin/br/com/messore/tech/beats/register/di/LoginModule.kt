package br.com.messore.tech.beats.register.di

import br.com.messore.tech.beats.register.view.model.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object RegisterModule {
    fun load() {
        loadKoinModules(module {
            viewModel { RegisterViewModel(get()) }
        })
    }
}
