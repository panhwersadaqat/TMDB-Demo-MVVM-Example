package com.example.tmdbdemo.data.repository.artist.datasource

import com.example.tmdbdemo.data.model.artist.Artist
import com.example.tmdbdemo.data.model.movies.Movie

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/30/21.
 */

interface ArtistLocalDataSource {
    suspend fun getArtistFromDB():List<Artist>
    suspend fun saveArtistToDB(artist: List<Artist>)
    suspend fun clearAll()
}