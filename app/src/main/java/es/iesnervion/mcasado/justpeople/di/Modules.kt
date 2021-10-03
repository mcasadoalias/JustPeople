package es.iesnervion.mcasado.justpeople.di

import android.content.Context
import es.iesnervion.mcasado.justpeople.R
import es.iesnervion.mcasado.justpeople.api.PeopleApi
import es.iesnervion.mcasado.justpeople.repo.PeopleRepo
import es.iesnervion.mcasado.justpeople.vm.PeopleVM
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    viewModel { PeopleVM (get()) }
}

val apiModule = module {
    fun providePeopleApi (retrofit: Retrofit): PeopleApi {
        return retrofit.create (PeopleApi::class.java)
    }

    single {providePeopleApi(get())}
}

val retrofitModule = module {
    fun provideRetrofit(context : Context) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(context.resources.getString(R.string.baseUrl))
            .addConverterFactory (GsonConverterFactory.create())
            .build()
    }

    single {provideRetrofit(androidContext())}
}

val repoModule = module {

    fun providePeopleRepo (api : PeopleApi) : PeopleRepo {
        return PeopleRepo(api)
    }

    single {providePeopleRepo(get())}

}
