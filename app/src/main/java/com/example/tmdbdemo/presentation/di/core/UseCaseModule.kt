package com.example.tmdbdemo.presentation.di.core

import com.example.tmdbdemo.domain.repository.ArtistRepository
import com.example.tmdbdemo.domain.repository.MovieRepository
import com.example.tmdbdemo.domain.repository.TvShowRepository
import com.example.tmdbdemo.domain.usecase.artist.GetArtistUseCase
import com.example.tmdbdemo.domain.usecase.artist.UpdateArtistUseCase
import com.example.tmdbdemo.domain.usecase.movie.GetMoviesUseCase
import com.example.tmdbdemo.domain.usecase.movie.UpdateMovieUseCase
import com.example.tmdbdemo.domain.usecase.tvshow.GetTvShowUseCase
import com.example.tmdbdemo.domain.usecase.tvshow.UpdateTvShowUseCase
import dagger.Module
import dagger.Provides

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/31/21.
 */

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository):UpdateMovieUseCase{
        return UpdateMovieUseCase(movieRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository):GetTvShowUseCase{
        return GetTvShowUseCase(tvShowRepository)
    }
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository):UpdateTvShowUseCase{
        return UpdateTvShowUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository):GetArtistUseCase{
        return GetArtistUseCase(artistRepository)
    }
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository):UpdateArtistUseCase{
        return UpdateArtistUseCase(artistRepository)
    }

}