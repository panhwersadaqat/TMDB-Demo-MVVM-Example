package com.example.tmdbdemo.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbdemo.databinding.ActivityArtistBinding
import com.example.tmdbdemo.presentation.di.Injector
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var binding: ActivityArtistBinding
    private lateinit var adapter: ArtistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as Injector).createArtistSubComponent()
            .inject(this)

        artistViewModel= ViewModelProvider(this,factory)
            .get(ArtistViewModel::class.java)
        val responseLiveData = artistViewModel.getArtist()
        responseLiveData.observe(this, Observer {
            initRecyclerView()
        })
    }

    private fun initRecyclerView() {
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        binding.artistRecyclerView.adapter = adapter
        displayArtist()
    }

    private fun displayArtist() {
        binding.artistProgressBar.visibility = View.VISIBLE
        val responseLivedata = artistViewModel.getArtist()
        responseLivedata.observe(this, Observer {
            if(it!=null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            }else {
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data available", Toast.LENGTH_SHORT).show()
            }
        })
    }
}