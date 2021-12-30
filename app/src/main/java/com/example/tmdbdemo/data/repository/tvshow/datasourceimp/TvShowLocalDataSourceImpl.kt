package com.example.tmdbdemo.data.repository.tvshow.datasourceimp

import com.example.tmdbdemo.data.db.MovieDao
import com.example.tmdbdemo.data.db.TvShowDao
import com.example.tmdbdemo.data.model.movies.Movie
import com.example.tmdbdemo.data.model.tvshow.TvShow
import com.example.tmdbdemo.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbdemo.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/30/21.
 */

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao) : TvShowLocalDataSource {

    override suspend fun getTvShowFromDB(): List<TvShow> {
       return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowToDB(tvShow: List<TvShow>) {
       CoroutineScope(Dispatchers.IO).launch {
           tvShowDao.saveTvShows(tvShow)
       }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllShows()
        }
    }

}