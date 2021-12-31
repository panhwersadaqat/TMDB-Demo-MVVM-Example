package com.example.tmdbdemo.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbdemo.R
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateArtist()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun updateArtist(){
        binding.artistProgressBar.visibility = View.VISIBLE
        val response = artistViewModel.updateArtist()
        response.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            }else{
                binding.artistProgressBar.visibility = View.GONE
            }
        })
    }
}