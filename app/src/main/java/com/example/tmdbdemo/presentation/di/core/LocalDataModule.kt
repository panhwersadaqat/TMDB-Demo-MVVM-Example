package com.example.tmdbdemo.presentation.di.core

import com.example.tmdbdemo.data.db.ArtistDao
import com.example.tmdbdemo.data.db.MovieDao
import com.example.tmdbdemo.data.db.TvShowDao
import com.example.tmdbdemo.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbdemo.data.repository.artist.datasourceimp.ArtistLocalDataSourceImp
import com.example.tmdbdemo.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbdemo.data.repository.movie.datasourceimp.MovieLocalDataSourceImpl
import com.example.tmdbdemo.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdbdemo.data.repository.tvshow.datasourceimp.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/31/21.
 */

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao : ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImp(artistDao)
    }


}