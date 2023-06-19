package com.brunadev.bookstore.viewmodel

import androidx.lifecycle.*
import com.brunadev.bookstore.data.GetAllBooks
import com.brunadev.bookstore.repository.BookstoreRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: BookstoreRepository) : ViewModel(){

    private val _listState = MutableLiveData<GetAllBooks?>()
    val listState: LiveData<GetAllBooks?> get() = _listState

    fun init() {
        viewModelScope.launch {
            val responseAPI = repository.getBooksAPICoroutines()
            if (responseAPI != null) {
                _listState.value = responseAPI
            }
        }
    }

    fun searchBook(book: String){
        viewModelScope.launch {
            val responseAPI = repository.seachBookAPI(book)
            if (responseAPI != null) {
                _listState.value = responseAPI
            }
        }
    }

    fun getBookList() = repository.getBooksAPIRX()
}







