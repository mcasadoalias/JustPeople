package es.iesnervion.mcasado.justpeople.application

import android.app.Application
import es.iesnervion.mcasado.justpeople.di.apiModule
import es.iesnervion.mcasado.justpeople.di.repoModule
import es.iesnervion.mcasado.justpeople.di.retrofitModule
import es.iesnervion.mcasado.justpeople.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PeopleApplication : Application (){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@PeopleApplication)
            modules(viewModelModule, apiModule, retrofitModule, repoModule)
        }
    }
}