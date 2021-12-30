package com.example.tmdbdemo.data.repository.movie.datasourceimp

import com.example.tmdbdemo.data.model.movies.Movie
import com.example.tmdbdemo.data.repository.movie.datasource.MovieCacheDataSource

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/30/21.
 */

class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMovieFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}