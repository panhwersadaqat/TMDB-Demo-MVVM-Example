package com.example.tmdbdemo.presentation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tmdbdemo.R
import com.example.tmdbdemo.databinding.ActivityMainBinding
import com.example.tmdbdemo.presentation.artist.ArtistActivity
import com.example.tmdbdemo.presentation.movie.MovieActivity
import com.example.tmdbdemo.presentation.tvshow.TvShowActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.main = this
    }

     fun startArtistActivity() {
        val intent = Intent(this, ArtistActivity::class.java)
        startActivity(intent)
    }

     fun startMovieActivity() {
        val intent = Intent(this, MovieActivity::class.java)
        startActivity(intent)
    }

     fun startTvShowActivity() {
        val intent = Intent(this, TvShowActivity::class.java)
        startActivity(intent)
    }

}