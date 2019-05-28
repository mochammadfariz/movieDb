package com.example.moviedb.network

import com.example.moviedb.BuildConfig.API_KEY
import com.example.moviedb.BuildConfig.BASE_URL

object tmdbApi {
    fun getFilm(): String{
        return BASE_URL + API_KEY
    }
}