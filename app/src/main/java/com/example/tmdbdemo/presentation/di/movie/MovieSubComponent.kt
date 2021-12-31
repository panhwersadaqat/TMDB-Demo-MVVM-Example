package com.example.tmdbdemo.presentation.di.movie

import com.example.tmdbdemo.presentation.movie.MovieActivity
import dagger.Subcomponent

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/31/21.
 */

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): MovieSubComponent
    }

}

