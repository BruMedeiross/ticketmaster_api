package com.brunadev.tm.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Public(

    @SerializedName("startDateTime") var startDateTime: String? = "",
    @SerializedName("startTBD") var startTBD: Boolean? = false,
    @SerializedName("endDateTime") var endDateTime: String? = ""

):Parcelable