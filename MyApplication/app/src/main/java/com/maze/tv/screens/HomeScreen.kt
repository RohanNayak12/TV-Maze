@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)

package com.maze.tv.screens


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.maze.tv.Details
import com.maze.tv.network.MovieData

@Composable
fun HomeScreenLayout(context: Context, arr: Array<MovieData>){

    LazyColumn(Modifier.background(Color.White)){
        items(arr){
            Log.d("Movie","${it.show.name}")
            ScreenCard(context,movie = it)
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}
@Composable
fun ScreenCard(context: Context, movie: MovieData){
    Card(onClick = {
        val intent=Intent(context,Details::class.java)
        intent.putExtra("MovieScore",movie.score)
        intent.putExtra("MovieName",movie.show.name)
        intent.putExtra("MovieSummary",movie.show.summary)
        intent.putExtra("MovieRating",movie.show.rating.average)
        intent.putExtra("MovieLanguage",movie.show.language)
        intent.putExtra("MovieMedium",movie.show?.image?.medium)
        startActivity(context,intent, Bundle.EMPTY)
                   },
        colors = CardDefaults.cardColors(Color.LightGray), elevation = CardDefaults.cardElevation(7.dp)) {
        Row(Modifier.fillMaxWidth()){
            if(movie.show.image != null){GlideImage(model = movie.show.image?.original,
                contentDescription = "Movie Image",
                Modifier
                    .height(80.dp)
                    .width(80.dp))}
            else{
                Text(text = "No Image available", fontSize = 6.sp)}
            Column (Modifier.height(100.dp)){
                Text(text = movie.show.name, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Text(text = movie.show.summary, fontSize = 12.sp, fontWeight = FontWeight.Light)
            }
        }
        Spacer(modifier = Modifier.width(6.dp))
    }
}



