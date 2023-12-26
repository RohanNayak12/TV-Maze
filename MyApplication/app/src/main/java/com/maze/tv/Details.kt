package com.maze.tv

import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.maze.tv.screens.DetailsScreenLayout

class Details : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val movieScore=intent.getDoubleExtra("MovieScore",0.0)
        val movieName=intent.getStringExtra("MovieName")
        val movieSummary=intent.getStringExtra("MovieSummary")
        val movieRating=intent.getDoubleExtra("MovieRating",0.0)
        val movieLanguage=intent.getStringExtra("MovieLanguage")
        val movieImage=intent.getStringExtra("MovieMedium")

        setContent {
            DetailsScreenLayout(
                movieScore = movieScore,
                name = movieName,
                summary = movieSummary,
                average = movieRating,
                language = movieLanguage,
                medium = movieImage
            )
        }
    }

}
