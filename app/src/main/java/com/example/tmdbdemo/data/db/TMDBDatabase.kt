package com.example.tmdbdemo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdbdemo.data.model.artist.Artist
import com.example.tmdbdemo.data.model.movies.Movie
import com.example.tmdbdemo.data.model.tvshow.TvShow

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/30/21.
 */

@Database(entities = [Movie::class, TvShow::class, Artist::class],
version = 1,
exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}