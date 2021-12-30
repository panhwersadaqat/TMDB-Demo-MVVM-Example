package com.example.tmdbdemo.data.repository.tvshow.datasourceimp

import com.example.tmdbdemo.data.model.movies.Movie
import com.example.tmdbdemo.data.model.tvshow.TvShow
import com.example.tmdbdemo.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbdemo.data.repository.tvshow.datasource.TvShowCacheDataSource

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/30/21.
 */

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowFromCache(): List<TvShow> {
       return tvShowList
    }

    override suspend fun saveTvShowToCache(movies: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShowList)
    }
}