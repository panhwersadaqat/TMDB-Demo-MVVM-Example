package com.example.tmdbdemo.data.repository.artist

import android.util.Log
import com.example.tmdbdemo.data.model.artist.Artist
import com.example.tmdbdemo.data.model.movies.Movie
import com.example.tmdbdemo.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdbdemo.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbdemo.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbdemo.domain.repository.ArtistRepository
import java.lang.Exception

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/30/21.
 */

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
    ) : ArtistRepository {
    override suspend fun getArtist(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {
        val newListOfArtist = getArtistFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistToDB(newListOfArtist)
        artistLocalDataSource.saveArtistToDB(newListOfArtist)
        return newListOfArtist
    }

    suspend fun getArtistFromAPI():List<Artist>{
        lateinit var artistList:List<Artist>
        try{
            val response = artistRemoteDataSource.getArtist()
            val body = response.body()
            if(body!=null){
                artistList = body.results
            }

        }catch (e: Exception){
            Log.i("MyTag",e.message.toString())
        }
        return artistList
    }

    suspend fun getArtistFromDB():List<Artist>{
        lateinit var artistList:List<Artist>
        try{
            artistList = artistLocalDataSource.getArtistFromDB()
        }catch (e: Exception){
            Log.i("MyTag",e.message.toString())
        }
        if(artistList.size>0){
            return artistList
        }else{
            artistList = getArtistFromAPI()
            artistLocalDataSource.saveArtistToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistFromCache():List<Artist>{
        lateinit var artistList:List<Artist>
        try{
            artistList = artistCacheDataSource.getArtistFromCache()
        }catch (e: Exception){
            Log.i("MyTag",e.message.toString())
        }
        if(artistList.size>0){
            return artistList
        }else{
            artistList = getArtistFromDB()
            artistCacheDataSource.saveArtistToCache(artistList)
        }
        return artistList
    }
}