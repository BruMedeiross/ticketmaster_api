package com.brunadev.tm.repository


import com.brunadev.tm.constant.EventConstants.API_KEY
import com.brunadev.tm.model.ResponseBody
import com.brunadev.tm.network.HttpClient

class RemoteDataSource {

    suspend fun eventList(key: String) : ResponseBody = HttpClient.eventApi
        .fetchEvents(key)

    suspend fun eventSearchList(event: String, code: String, key: String) : ResponseBody = HttpClient.eventApi
        .searchEvents(event, code, key)
}