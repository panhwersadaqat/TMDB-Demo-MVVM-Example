package com.example.tmdbdemo.data.repository.artist.datasource

import com.example.tmdbdemo.data.model.artist.Artist

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/30/21.
 */

interface ArtistCacheDataSource {
    suspend fun getArtistFromCache():List<Artist>
    suspend fun saveArtistToCache(artist:List<Artist>)
}