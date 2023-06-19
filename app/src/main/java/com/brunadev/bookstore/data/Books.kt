package com.brunadev.bookstore.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue


data class GetAllBooks(
    val count: Int? = 0,
    val next: String? = "",
    val previous: String? = "",
    @SerializedName("results") val resultList: List<Book>
)

@Parcelize
data class Book(
    val id: Int? = 0,
    val title: String? = "",
    val authors: @RawValue List<Author>,
    val translators: @RawValue List<Translator>,
    val subjects: List<String?>,
    val bookshelves: List<String?>,
    val languages: List<String?>,
    val copyright: Boolean? = false,
    @SerializedName("media_type") val mediaType: String? = "",
    val formats: Map<String, String>,
    @SerializedName("download_count") val downloadCount: Int? = 0
) : Parcelable


@Parcelize
data class Author(
    val name: @RawValue String? = "",
    @SerializedName("birth_year") val birthYear: @RawValue Int? = 0,
    @SerializedName("death_year") val deathYear: @RawValue Int? = 0
) : Parcelable

@Parcelize
data class Translator(
    val name: String? = "",
    @SerializedName("birth_year")val birthYear: Int? = 0,
    @SerializedName("death_year")val deathYear: Int? = 0
) : Parcelable