package com.example.moviedb.main

import com.example.moviedb.model.movie

interface MainView{
    fun showFilmList(data:List<movie>)
}