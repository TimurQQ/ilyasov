package com.ilyasov.gifs_tinkoff_test_task.data.db.remote.api

import com.ilyasov.gifs_tinkoff_test_task.domain.entity.GifEntity
import com.ilyasov.gifs_tinkoff_test_task.domain.entity.GifResponse
import retrofit2.Response

interface APIInterface {
    suspend fun getGifs(
        section: String,
        page: Long,
        json: Boolean = true
    ): Response<GifResponse>

    suspend fun getRandomGif(
        json: Boolean = true
    ): Response<GifEntity>
}