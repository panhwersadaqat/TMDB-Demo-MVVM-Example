package com.example.tmdbdemo.presentation.di

import com.example.tmdbdemo.presentation.di.artist.ArtistSubComponent
import com.example.tmdbdemo.presentation.di.movie.MovieSubComponent
import com.example.tmdbdemo.presentation.di.tvshow.TvShowSubComponent

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/31/21.
 */

interface Injector {
   fun createMovieSubComponent(): MovieSubComponent
   fun createTvShowSubComponent(): TvShowSubComponent
   fun createArtistSubComponent(): ArtistSubComponent
}