package com.example.tmdbdemo.presentation.di.core


import com.example.tmdbdemo.data.api.TMDBService
import com.example.tmdbdemo.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbdemo.data.repository.artist.datasourceimp.ArtistRemoteDataSourceImp
import com.example.tmdbdemo.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbdemo.data.repository.movie.datasourceimp.MovieRemoteDataSourceImpl
import com.example.tmdbdemo.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmdbdemo.data.repository.tvshow.datasourceimp.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/31/21.
 */

@Module
class RemoteDataModule(private val apiKey: String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImp(
            tmdbService, apiKey
        )
    }


}