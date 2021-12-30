package com.example.tmdbdemo.data.repository.tvshow.datasourceimp

import com.example.tmdbdemo.data.api.TMDBService
import com.example.tmdbdemo.data.model.movies.MovieList
import com.example.tmdbdemo.data.model.tvshow.TvShowList
import com.example.tmdbdemo.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbdemo.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/30/21.
 */

class TvShowRemoteDataSourceImpl(
    private val tmdb: TMDBService,
    private val apiKey: String): TvShowRemoteDataSource {
    override suspend fun getTvShow(): Response<TvShowList>  = tmdb.getPopularTvShows(apiKey)
}