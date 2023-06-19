package com.brunadev.bookstore.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue


data class GetAllBooks(
    val count: Int,
    val next: String?,
    val previous: String?,
    @SerializedName("results")val resultsList: List<Book>
)

@Parcelize
data class Book(
    val id: Int,
    val title: String,
    val authors: @RawValue List<Author>,
    val translators: @RawValue List<Translator>,
    val subjects: List<String>,
    val bookshelves: List<String>,
    val languages: List<String>,
    val copyright: Boolean,
    @SerializedName("media_type") val mediaType: String,
    val formats: Map<String, String>,
    @SerializedName("download_count") val downloadCount: Int
) : Parcelable


@Parcelize
data class Author(
    val name:  @RawValue String,
    @SerializedName("birth_year")val birthYear:  @RawValue Int,
    @SerializedName("death_year")val deathYear:  @RawValue Int
) : Parcelable

data class Translator(
    val name: String,
    val birth_year: Int,
    val death_year: Int
)