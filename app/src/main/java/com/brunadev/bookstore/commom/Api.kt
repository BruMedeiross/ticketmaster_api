package com.brunadev.bookstore.commom

import com.brunadev.bookstore.data.GetAllBooks
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {

    @GET("books/")
    fun getBookList(
    ): Observable<GetAllBooks>

    @GET("books/")
    suspend fun getBookListAPI(
    ): GetAllBooks

    @GET("books/")
    suspend fun search(@Query("search") book: String): GetAllBooks
}