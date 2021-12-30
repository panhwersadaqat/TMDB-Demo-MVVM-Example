package com.example.tmdbdemo.data.repository.tvshow.datasource

import com.example.tmdbdemo.data.model.tvshow.TvShow

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/30/21.
 */

interface TvShowLocalDataSource {
    suspend fun getTvShowFromDB():List<TvShow>
    suspend fun saveTvShowToDB(tvShow: List<TvShow>)
    suspend fun clearAll()
}