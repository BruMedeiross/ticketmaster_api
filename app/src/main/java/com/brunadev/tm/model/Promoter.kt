package com.brunadev.tm.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Promoter (

   @SerializedName("id") var id : String? = ""
) : Parcelable