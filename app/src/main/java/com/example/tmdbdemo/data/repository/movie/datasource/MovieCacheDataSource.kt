package com.example.tmdbdemo.data.repository.movie.datasource

import com.example.tmdbdemo.data.model.movies.Movie

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/30/21.
 */

interface MovieCacheDataSource {
    suspend fun getMovieFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)

}