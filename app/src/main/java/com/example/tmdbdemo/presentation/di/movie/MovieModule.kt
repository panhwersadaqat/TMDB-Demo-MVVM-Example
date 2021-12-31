package com.example.tmdbdemo.presentation.di.movie


import com.example.tmdbdemo.domain.usecase.movie.GetMoviesUseCase
import com.example.tmdbdemo.domain.usecase.movie.UpdateMovieUseCase
import com.example.tmdbdemo.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/31/21.
 */

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUsecase: UpdateMovieUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUsecase
        )
    }

}