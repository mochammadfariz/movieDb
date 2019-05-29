package com.example.moviedb.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.GridLayout
import android.widget.LinearLayout
import com.example.moviedb.detail.detailActivity
import com.example.moviedb.model.movie
import com.example.moviedb.network.apiRepo
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView


class MainActivity : AppCompatActivity(),MainView {


    private lateinit var listMovie : RecyclerView
    private lateinit var presenter: mainPresenter
    private lateinit var adapter : MainAdapter
    private var movies : MutableList<movie> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        linearLayout{
            lparams(width = matchParent,height = wrapContent)
            orientation = LinearLayout.VERTICAL
            padding = dip(16)

            listMovie = recyclerView{
                lparams(width= matchParent,height = wrapContent)
                layoutManager = GridLayoutManager(context,3)
            }
        }

        adapter = MainAdapter(movies){
            startActivity<detailActivity>(
                "Title" to it.title,
                "Gambar" to it.poster,
                "Overview" to it.overview
            )
        }
        listMovie.adapter = adapter
        presenter = mainPresenter(this, apiRepo(), Gson())
        presenter.getMovielist()
    }

    override fun showFilmList(data: List<movie>) {
        movies.clear()
        movies.addAll(data)
        adapter.notifyDataSetChanged()
    }
}
