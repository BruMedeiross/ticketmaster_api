package com.brunadev.tm.model

import com.google.gson.annotations.SerializedName


data class ResponseBody (

    @SerializedName("_links") var Links : Links,
    @SerializedName("_embedded") var Embedded : Embedded,
    @SerializedName("page") var page : Page

)