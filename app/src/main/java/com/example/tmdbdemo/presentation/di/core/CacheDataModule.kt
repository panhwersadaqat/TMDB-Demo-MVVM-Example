package com.example.tmdbdemo.presentation.di.core

import com.example.tmdbdemo.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdbdemo.data.repository.artist.datasourceimp.ArtistCacheDataSourceImpl
import com.example.tmdbdemo.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbdemo.data.repository.movie.datasourceimp.MovieCacheDataSourceImpl
import com.example.tmdbdemo.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmdbdemo.data.repository.tvshow.datasourceimp.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/31/21.
 */

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }


}