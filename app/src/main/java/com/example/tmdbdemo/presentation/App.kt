package com.example.tmdbdemo.presentation

import android.app.Application
import com.example.tmdbdemo.BuildConfig
import com.example.tmdbdemo.presentation.di.Injector
import com.example.tmdbdemo.presentation.di.artist.ArtistSubComponent
import com.example.tmdbdemo.presentation.di.core.*
import com.example.tmdbdemo.presentation.di.movie.MovieSubComponent
import com.example.tmdbdemo.presentation.di.tvshow.TvShowSubComponent

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/31/21.
 */

class App :Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

}