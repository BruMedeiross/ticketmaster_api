package com.brunadev.tm.repository

import com.brunadev.tm.model.ResponseBody

interface Repository {

    suspend fun getEventsAPICoroutines () : ResponseBody

    suspend fun seachEventAPI (search: String) : ResponseBody
}
