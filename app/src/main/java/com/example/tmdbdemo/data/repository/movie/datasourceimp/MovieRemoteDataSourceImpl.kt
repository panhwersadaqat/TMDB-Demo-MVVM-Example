package com.example.tmdbdemo.data.repository.movie.datasourceimp

import com.example.tmdbdemo.data.api.TMDBService
import com.example.tmdbdemo.data.model.movies.MovieList
import com.example.tmdbdemo.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/30/21.
 */

class MovieRemoteDataSourceImpl(
    private val tmdb: TMDBService,
    private val apiKey: String): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdb.getPopularMovies(apiKey)
}