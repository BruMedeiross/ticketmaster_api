package com.brunadev.tm.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Images(

    @SerializedName("ratio") var ratio: String? = "",
    @SerializedName("url") var url: String? = "",
    @SerializedName("width") var width: Int? = 0,
    @SerializedName("height") var height: Int? = 0,
    @SerializedName("fallback") var fallback: Boolean? = false

) : Parcelable