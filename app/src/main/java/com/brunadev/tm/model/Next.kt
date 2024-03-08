package com.brunadev.tm.model

import com.google.gson.annotations.SerializedName

   
data class Next (

   @SerializedName("href") var href : String,
   @SerializedName("templated") var templated : Boolean

)