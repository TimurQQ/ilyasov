package com.ilyasov.gifs_tinkoff_test_task.data.db.repository

import com.ilyasov.gifs_tinkoff_test_task.domain.entity.GifEntity
import com.ilyasov.gifs_tinkoff_test_task.domain.entity.GifResponse
import retrofit2.Response

interface RemoteRepository {
    suspend fun getGifs(
        section: String,
        page: Long,
        json: Boolean
    ): Response<GifResponse>

    suspend fun getRandomGif(
        json: Boolean
    ): Response<GifEntity>
}