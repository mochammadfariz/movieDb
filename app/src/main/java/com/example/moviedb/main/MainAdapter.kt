package com.example.moviedb.main

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.moviedb.BuildConfig.URL_POSTER
import com.example.moviedb.R
import com.example.moviedb.R.id.movie_poster
import com.example.moviedb.R.id.movie_title
import com.example.moviedb.model.movie
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainAdapter(private val result: List<movie>,private val listener:(movie) -> Unit)
    : RecyclerView.Adapter<MovieViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MovieViewHolder {
        return MovieViewHolder(movieUI().createView(AnkoContext.create(p0.context,p0)))
    }

    override fun getItemCount(): Int = result.size

    override fun onBindViewHolder(p0: MovieViewHolder, p1: Int) {
        p0.bindItem(result[p1],listener)
    }

}

class movieUI : AnkoComponent<ViewGroup>{
    override fun createView(ui: AnkoContext<ViewGroup>): View {
       return with(ui){
         linearLayout {
             lparams(width= matchParent,height = wrapContent)
             padding = dip(5)
             orientation = LinearLayout.VERTICAL

             imageView{
                 id = R.id.movie_poster
             }.lparams{
                height = dip(250)
                 width = wrapContent
             }
             textView{
                 id = R.id.movie_title
                 textSize = 16f
             }.lparams{
                 margin = dip(16)
             }
         }
       }
    }
}

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view){
    private val moviePoster : ImageView = view.find(movie_poster)
    private val movieTitle : TextView = view.find(movie_title)
    fun bindItem(movies: movie,listener: (movie) -> Unit){
        Picasso.get().load(URL_POSTER + movies.poster).into(moviePoster)
        movieTitle.text = movies.title

        moviePoster.onClick {
            listener(movies)
        }
    }
}