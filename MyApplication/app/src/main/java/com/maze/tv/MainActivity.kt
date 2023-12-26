package com.maze.tv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.maze.tv.network.MovieData
import com.maze.tv.repo.Repo
import com.maze.tv.screens.HomeScreenLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val movies:Array<MovieData>
        runBlocking { withContext(Dispatchers.IO){
            movies= Repo().fetchData()
        } }

        setContent {
            HomeScreenLayout(context = this, arr = movies)
        }
    }
}

