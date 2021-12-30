package com.example.tmdbdemo.data.repository.artist.datasource

import com.example.tmdbdemo.data.model.artist.ArtistList
import retrofit2.Response

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/30/21.
 */

interface ArtistRemoteDataSource {
    suspend fun getArtist():Response<ArtistList>
}