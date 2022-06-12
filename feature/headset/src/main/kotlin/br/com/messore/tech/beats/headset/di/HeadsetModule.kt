package br.com.messore.tech.beats.headset.di

import android.os.Bundle
import br.com.messore.tech.beats.headset.detail.HeadsetDetailViewModel
import br.com.messore.tech.beats.headset.list.HeadsetViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object HeadsetModule {
    fun load() {
        loadKoinModules(module {
            viewModel { HeadsetViewModel(get()) }
            viewModel { (args: Bundle) ->
                HeadsetDetailViewModel(args, get())
            }
        })
    }
}
