package com.brunadev.tm.viewmodel

import androidx.lifecycle.*
import com.brunadev.tm.model.ResponseBody
import com.brunadev.tm.repository.Repository
import kotlinx.coroutines.launch


class  MainViewModel(private val repository: Repository) : ViewModel(){

    private val _listState = MutableLiveData<ResponseBody?>()
    val listState: LiveData<ResponseBody?> get() = _listState

    fun init() {
        viewModelScope.launch {
            val responseAPI = repository.getEventsAPICoroutines()
            _listState.value = responseAPI
        }
    }

    fun searchEvent(search: String){
        viewModelScope.launch {
            val responseAPI = repository.seachEventAPI(search)
            _listState.value = responseAPI
        }
    }


}







