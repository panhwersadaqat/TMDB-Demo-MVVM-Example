package com.example.tmdbdemo.presentation.di.artist

import com.example.tmdbdemo.domain.usecase.artist.GetArtistUseCase
import com.example.tmdbdemo.domain.usecase.artist.UpdateArtistUseCase
import com.example.tmdbdemo.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/31/21.
 */

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistUseCase,
        updateArtistsUseCase: UpdateArtistUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase
        )
    }

}