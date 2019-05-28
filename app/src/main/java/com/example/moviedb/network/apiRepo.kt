package com.example.moviedb.network

import java.net.URL

class apiRepo {
    fun doReq(url: String) : String{
        return URL(url).readText()
    }
}