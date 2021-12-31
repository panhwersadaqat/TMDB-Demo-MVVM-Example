package com.example.tmdbdemo.presentation.di.tvshow

import com.example.tmdbdemo.domain.usecase.tvshow.GetTvShowUseCase
import com.example.tmdbdemo.domain.usecase.tvshow.UpdateTvShowUseCase
import com.example.tmdbdemo.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/31/21.
 */


@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowUseCase,
        updateTvShowsUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }

}