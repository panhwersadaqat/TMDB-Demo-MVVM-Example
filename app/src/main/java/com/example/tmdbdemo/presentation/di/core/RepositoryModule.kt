package com.example.tmdbdemo.presentation.di.core


import com.example.tmdbdemo.data.repository.artist.ArtistRepositoryImpl
import com.example.tmdbdemo.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdbdemo.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbdemo.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbdemo.data.repository.movie.MovieRepositoryImpl
import com.example.tmdbdemo.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbdemo.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbdemo.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbdemo.data.repository.tvshow.TvShowsRepositoryImpl
import com.example.tmdbdemo.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmdbdemo.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdbdemo.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmdbdemo.domain.repository.ArtistRepository
import com.example.tmdbdemo.domain.repository.MovieRepository
import com.example.tmdbdemo.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/31/21.
 */

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDataSource,
            movieCacheDataSource
        )


    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {

        return TvShowsRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )


    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {

        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDataSource,
            artistCacheDataSource
        )


    }

}