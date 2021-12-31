package com.example.tmdbdemo.presentation.di.artist

import com.example.tmdbdemo.presentation.artist.ArtistActivity
import dagger.Subcomponent

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/31/21.
 */

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): ArtistSubComponent
    }

}

