package com.brunadev.bookstore.di

import com.brunadev.bookstore.commom.Api
import com.brunadev.bookstore.repository.BookStoreImpl
import com.brunadev.bookstore.repository.BookstoreRepository
import com.brunadev.bookstore.viewmodel.DetailViewModel
import com.brunadev.bookstore.viewmodel.MainViewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import org.koin.androidx.viewmodel.dsl.viewModel

object AppModule {

    val appModule = module {

        single { provideApi(get()) }
        single<BookstoreRepository> { BookStoreImpl() }

        viewModel { MainViewModel(get()) }
        viewModel { DetailViewModel() }

    }

    private fun provideApi(retrofit: Retrofit): Api =
        retrofit.create(Api::class.java)

}
