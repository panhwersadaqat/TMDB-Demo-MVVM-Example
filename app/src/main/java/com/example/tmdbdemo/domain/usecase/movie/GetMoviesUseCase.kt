package com.example.tmdbdemo.domain.usecase.movie

import com.example.tmdbdemo.data.model.movies.Movie
import com.example.tmdbdemo.domain.repository.MovieRepository

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/30/21.
 */

class GetMoviesUseCase(private val movieRepository: MovieRepository){
    suspend fun execute():List<Movie>? = movieRepository.getMovies()
}