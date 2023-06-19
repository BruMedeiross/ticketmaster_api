package com.brunadev.bookstore.repository

import androidx.lifecycle.LiveData
import com.brunadev.bookstore.data.GetAllBooks

interface BookstoreRepository {

    fun getBooksAPIRX () : LiveData<GetAllBooks?>
    suspend fun getBooksAPICoroutines () : GetAllBooks
    suspend fun seachBookAPI (book: String) : GetAllBooks

}
