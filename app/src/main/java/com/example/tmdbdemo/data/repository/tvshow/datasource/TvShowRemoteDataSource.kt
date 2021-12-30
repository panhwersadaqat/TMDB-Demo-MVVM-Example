package com.example.tmdbdemo.data.repository.tvshow.datasource

import com.example.tmdbdemo.data.model.tvshow.TvShowList
import retrofit2.Response

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/30/21.
 */

interface TvShowRemoteDataSource {
    suspend fun getTvShow():Response<TvShowList>
}