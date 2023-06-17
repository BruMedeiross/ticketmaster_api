package com.brunadev.bookstore.repository

import com.brunadev.bookstore.commom.HttpClient
import com.brunadev.bookstore.data.Book
import com.brunadev.bookstore.data.GetAllBooks
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RemoteDataSource {

    fun bookList(): Observable<GetAllBooks> = HttpClient.bookstoreApi
        .getBookList()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    suspend fun bookList2(): GetAllBooks = HttpClient.bookstoreApi
        .getBookList2()
}