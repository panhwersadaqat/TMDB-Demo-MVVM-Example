package com.example.tmdbdemo.data.model.tvshow


import com.google.gson.annotations.SerializedName

data class TvShowList(
    @SerializedName("results")
    val results: List<TvShow>
)