package com.example.tmdbdemo.domain.usecase.artist

import com.example.tmdbdemo.data.model.artist.Artist
import com.example.tmdbdemo.domain.repository.ArtistRepository

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/30/21.
 */

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.updateArtist()
}