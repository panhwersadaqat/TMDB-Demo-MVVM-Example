package com.example.tmdbdemo.data.api

import com.example.tmdbdemo.data.model.artist.ArtistList
import com.example.tmdbdemo.data.model.movies.MovieList
import com.example.tmdbdemo.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/30/21.
 */

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query(
            "api_key"
        )apiKey: String
    ): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(
        @Query(
            "api_key"
        )apiKey: String
    ): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtist(
        @Query(
            "api_key"
        )apiKey: String
    ): Response<ArtistList>

}