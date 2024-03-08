package com.brunadev.tm.di

import com.brunadev.tm.commom.Api
import com.brunadev.tm.repository.EventImpl
import com.brunadev.tm.repository.Repository
import com.brunadev.tm.viewmodel.DetailViewModel
import com.brunadev.tm.viewmodel.MainViewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import org.koin.androidx.viewmodel.dsl.viewModel

object AppModule {

    val appModule = module {

        single { provideApi(get()) }
        single<Repository> { EventImpl() }

        viewModel { MainViewModel(get()) }
        viewModel { DetailViewModel() }

    }

    private fun provideApi(retrofit: Retrofit): Api =
        retrofit.create(Api::class.java)

}
