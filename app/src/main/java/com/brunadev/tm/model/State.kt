package com.brunadev.tm.model

import com.google.gson.annotations.SerializedName

   
data class State (

   @SerializedName("name") var name : String,
   @SerializedName("stateCode") var stateCode : String

)