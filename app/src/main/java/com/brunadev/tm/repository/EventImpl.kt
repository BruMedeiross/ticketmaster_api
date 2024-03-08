package com.brunadev.tm.repository

import com.brunadev.tm.constant.EventConstants.API_CODE
import com.brunadev.tm.constant.EventConstants.API_KEY
import com.brunadev.tm.model.ResponseBody

import io.reactivex.disposables.CompositeDisposable

class EventImpl : Repository {

    private val remoteDataSource = RemoteDataSource()
    private val compositeDisposable = CompositeDisposable()

    override suspend fun getEventsAPICoroutines(): ResponseBody =
        remoteDataSource.eventList(API_KEY)

    override suspend fun seachEventAPI(search: String) =
        remoteDataSource.eventSearchList(search, API_CODE, API_KEY)
}

