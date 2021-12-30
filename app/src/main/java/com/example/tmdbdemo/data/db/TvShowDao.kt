package com.example.tmdbdemo.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbdemo.data.model.tvshow.TvShow

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/30/21.
 */

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShow: List<TvShow>)

    @Query("DELETE FROM popular_tvshows")
    suspend fun deleteAllShows()

    @Query("SELECT * FROM popular_tvshows")
    suspend fun getTvShows(tvShow: List<TvShow>)

}