package com.example.tmdbdemo.domain.usecase.tvshow

import com.example.tmdbdemo.data.model.tvshow.TvShow
import com.example.tmdbdemo.domain.repository.TvShowRepository

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/30/21.
 */

class UpdateTvShowUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>? = tvShowRepository.updateTvShows()
}