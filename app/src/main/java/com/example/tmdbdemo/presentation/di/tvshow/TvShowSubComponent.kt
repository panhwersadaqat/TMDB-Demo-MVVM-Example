package com.example.tmdbdemo.presentation.di.tvshow

import com.example.tmdbdemo.presentation.tvshow.TvShowActivity
import dagger.Subcomponent

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/31/21.
 */

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): TvShowSubComponent
    }

}

