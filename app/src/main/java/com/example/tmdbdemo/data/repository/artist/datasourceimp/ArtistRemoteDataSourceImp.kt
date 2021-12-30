package com.example.tmdbdemo.data.repository.artist.datasourceimp

import com.example.tmdbdemo.data.api.TMDBService
import com.example.tmdbdemo.data.model.artist.Artist
import com.example.tmdbdemo.data.model.artist.ArtistList
import com.example.tmdbdemo.data.model.movies.MovieList
import com.example.tmdbdemo.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbdemo.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/30/21.
 */

class ArtistRemoteDataSourceImp (
    private val tmdb: TMDBService,
    private val apiKey: String): ArtistRemoteDataSource {
    override suspend fun getArtist(): Response<ArtistList> = tmdb.getPopularArtist(apiKey)
}