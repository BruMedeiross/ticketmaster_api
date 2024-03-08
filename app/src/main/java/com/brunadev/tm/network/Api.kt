package com.brunadev.tm.commom

import com.brunadev.tm.model.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/discovery/v2/events.json")
    suspend fun fetchEvents(
       @Query("apikey") apiKey: String
    ): ResponseBody

    @GET("discovery/v2/events.json")
    suspend fun searchEvents(
        @Query("keyword") keyword: String,
        @Query("countryCode") countryCode: String,
        @Query("apikey") apiKey: String
    ):  ResponseBody
}