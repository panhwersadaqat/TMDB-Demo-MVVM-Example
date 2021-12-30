package com.example.tmdbdemo.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbdemo.domain.usecase.movie.GetMoviesUseCase
import com.example.tmdbdemo.domain.usecase.movie.UpdateMovieUseCase

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/30/21.
 */

class MovieViewModelFactory (
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       return MovieViewModel(getMoviesUseCase, updateMovieUseCase) as T
    }

}