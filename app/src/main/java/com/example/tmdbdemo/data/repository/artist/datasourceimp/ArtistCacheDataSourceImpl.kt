package com.example.tmdbdemo.data.repository.artist.datasourceimp

import com.example.tmdbdemo.data.model.artist.Artist
import com.example.tmdbdemo.data.model.movies.Movie
import com.example.tmdbdemo.data.repository.artist.datasource.ArtistCacheDataSource

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/30/21.
 */

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistToCache(artist: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artist)
    }
}