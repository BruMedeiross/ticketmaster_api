package com.brunadev.bookstore.commom

import com.brunadev.bookstore.data.GetAllBooks
import io.reactivex.Observable
import retrofit2.http.GET

interface Api {

    @GET("books/")
    fun getBookList(
    ): Observable<GetAllBooks>

    @GET("books/")
    suspend fun getBookList2(
    ): GetAllBooks
}