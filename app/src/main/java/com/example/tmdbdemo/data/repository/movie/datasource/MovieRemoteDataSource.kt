package com.example.tmdbdemo.data.repository.movie.datasource

import com.example.tmdbdemo.data.model.movies.Movie
import com.example.tmdbdemo.data.model.movies.MovieList
import retrofit2.Response

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/30/21.
 */

interface MovieRemoteDataSource {
    suspend fun getMovies():Response<MovieList>
}