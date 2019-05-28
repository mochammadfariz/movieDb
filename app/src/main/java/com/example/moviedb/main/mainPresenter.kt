package com.example.moviedb.main

import com.example.moviedb.model.movieResponse
import com.example.moviedb.network.apiRepo
import com.example.moviedb.network.tmdbApi
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class mainPresenter(private val view: MainView, private val apiRepos: apiRepo,private val gson: Gson){
    fun getMovielist(){
        doAsync {
            val data = gson.fromJson(apiRepos.doReq(tmdbApi.getFilm()),
                movieResponse::class.java)
            uiThread {
                view.showFilmList(data.results)
            }
        }
    }
}