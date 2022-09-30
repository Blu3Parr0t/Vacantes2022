package com.bps.retrofitexample2022.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieModel(
    @SerializedName("Title")
    val title: String?,
    @SerializedName("Year")
    val year: String?,
    @SerializedName("Rated")
    val rated: String?,
    @SerializedName("Genre")
    val genre: String?
): Parcelable
