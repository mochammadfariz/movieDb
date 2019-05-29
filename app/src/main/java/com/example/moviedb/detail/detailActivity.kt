package com.example.moviedb.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.moviedb.BuildConfig.URL_POSTER
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class detailActivity : AppCompatActivity() {
    private var titleFilm : String = ""
    private var posterFilm : String = ""
    private var overviewFilm : String = ""

    private lateinit var poster:ImageView
    private lateinit var title:TextView
    private lateinit var overview:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

      linearLayout{
          lparams(width = matchParent,height = wrapContent)
          orientation = LinearLayout.VERTICAL
          padding = dip(16)

          poster = imageView{

          }.lparams{
              width = dip(250)
              gravity = Gravity.CENTER
              height = dip(250)
          }

          title = textView()
          overview = textView()

      }

        val i = intent
        titleFilm = i.getStringExtra("Title")
        overviewFilm = i.getStringExtra("Overview")
        posterFilm = i.getStringExtra("Gambar")

        title.text = titleFilm
        overview.text = overviewFilm
        Picasso.get().load(URL_POSTER + posterFilm).into(poster)
    }
}
