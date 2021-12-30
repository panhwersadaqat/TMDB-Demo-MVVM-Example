package com.example.tmdbdemo.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tmdbdemo.databinding.ActivityArtistBinding

class ArtistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtistBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}