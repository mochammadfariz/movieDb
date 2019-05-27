package com.example.moviedb.model

import com.google.gson.annotations.SerializedName


data class movie (
    val id : String,
    val title: String,
    val overview : String,
    @SerializedName("poster_path") var poster : String
)