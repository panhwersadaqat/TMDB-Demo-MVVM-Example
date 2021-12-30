package com.example.tmdbdemo.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tmdbdemo.databinding.ActivityTvShowBinding

class TvShowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTvShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTvShowBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}