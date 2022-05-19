package br.com.messore.tech.beats

import android.app.Application
import br.com.messore.tech.beats.data.di.DataModule
import br.com.messore.tech.beats.domain.di.DomainModule
import br.com.messore.tech.beats.login.di.LoginModule
import br.com.messore.tech.beats.remote.di.NetworkModule
import br.com.messore.tech.beats.remote.di.RemoteModule
import br.com.messore.tech.beats.remote.di.ServicesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
        }

        loadAllModules()
    }

    private fun loadAllModules() {
        DataModule.load()
        LoginModule.load()
        DomainModule.load()
        RemoteModule.load()
        NetworkModule.load()
        ServicesModule.load()
    }
}
