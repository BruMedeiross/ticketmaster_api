package com.brunadev.tm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.brunadev.tm.model.Events

class DetailViewModel : ViewModel() {

    val bookDetail: LiveData<Events> get() = _bookClicked
    private val _bookClicked = MutableLiveData<Events>()

    fun setBookDetail(eventExtras: Events) {
        _bookClicked.postValue(eventExtras)
    }

}