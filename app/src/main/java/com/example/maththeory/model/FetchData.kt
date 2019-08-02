package com.example.maththeory.model

import com.google.gson.annotations.SerializedName


data class FetchData(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("picture")
    val picture: String
)