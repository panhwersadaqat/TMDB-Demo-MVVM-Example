package com.example.tmdbdemo.data.repository.tvshow

import android.util.Log
import com.example.tmdbdemo.data.model.movies.Movie
import com.example.tmdbdemo.data.model.tvshow.TvShow
import com.example.tmdbdemo.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmdbdemo.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdbdemo.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmdbdemo.domain.repository.TvShowRepository
import java.lang.Exception

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/30/21.
 */

class TvShowsRepositoryImpl (
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository{
    override suspend fun getTvShows(): List<TvShow>? {
      return getTvShowFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows= getTvShowFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowFromAPI():List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try{
            val response = tvShowRemoteDataSource.getTvShow()
            val body = response.body()
            if(body!=null){
                tvShowList = body.results
            }

        }catch (e: Exception){
            Log.i("MyTag",e.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowFromDB():List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try{
            tvShowList = tvShowLocalDataSource.getTvShowFromDB()
        }catch (e: Exception){
            Log.i("MyTag",e.message.toString())
        }
        if(tvShowList.size>0){
            return tvShowList
        }else{
            tvShowList = getTvShowFromAPI()
            tvShowLocalDataSource.saveTvShowToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowFromCache():List<TvShow>{
        lateinit var tvShowlist:List<TvShow>
        try{
            tvShowlist = tvShowCacheDataSource.getTvShowFromCache()
        }catch (e: Exception){
            Log.i("MyTag",e.message.toString())
        }
        if(tvShowlist.size>0){
            return tvShowlist
        }else{
            tvShowlist = getTvShowFromDB()
            tvShowCacheDataSource.saveTvShowToCache(tvShowlist)
        }
        return tvShowlist
    }
}