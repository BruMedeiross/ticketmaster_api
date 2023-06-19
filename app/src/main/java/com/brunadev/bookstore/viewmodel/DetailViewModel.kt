package com.brunadev.bookstore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.brunadev.bookstore.data.Book

class DetailViewModel : ViewModel() {

    val bookDetail: LiveData<Book?> get() = _bookClicked
    private val _bookClicked = MutableLiveData<Book?>()

    fun setBookDetail(bookExtras: Book?) {
        _bookClicked.postValue(bookExtras)
    }

}